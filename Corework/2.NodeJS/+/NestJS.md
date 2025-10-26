# NestJS : Enterprise on Javascript


NestJS adalah kerangka kerja Node.js yang progresif untuk membangun aplikasi sisi server yang efisien, andal, dan dapat diskalakan.

### NestJS CLI

NestJS CLI adalah alat antarmuka baris perintah untuk membuat, mengelola, dan membuat perancah aplikasi NestJS.

**Contoh:**
Membuat proyek baru:
```bash
$ npm i -g @nestjs/cli
$ nest new project-name
```
Membuat controller baru:
```bash
$ nest g controller products
```

### Struktur Folder

Struktur folder default NestJS mempromosikan arsitektur yang bersih dan terorganisir.

**Contoh:**
```
/
├── src/
│   ├── app.controller.ts
│   ├── app.module.ts
│   ├── app.service.ts
│   └── main.ts
├── test/
│   ├── app.e2e-spec.ts
│   └── jest-e2e.json
├── .eslintrc.js
├── .prettierrc
├── nest-cli.json
├── package.json
├── tsconfig.build.json
└── tsconfig.json
```

### Decorator

Decorator adalah fungsi khusus yang dapat dilampirkan ke kelas, metode, atau properti untuk memodifikasi perilakunya.

**Contoh:**
Decorator `@Controller()` mendefinisikan kelas sebagai controller.
```typescript
import { Controller, Get } from '@nestjs/common';

@Controller('products')
export class ProductsController {
  @Get()
  findAll(): string {
    return 'This action returns all products';
  }
}
```

### Module

Modul adalah kelas dengan decorator `@Module()` yang menyediakan metadata yang digunakan Nest untuk mengatur struktur aplikasi.

**Contoh:**
```typescript
import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';

@Module({
  imports: [],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
```

### Controller

Controller bertanggung jawab untuk menangani permintaan masuk dan mengembalikan respons ke klien.

**Contoh:**
```typescript
import { Controller, Get } from '@nestjs/common';

@Controller('cats')
export class CatsController {
  @Get()
  findAll(): string {
    return 'This action returns all cats';
  }
}
```

### HTTP Method

NestJS menyediakan decorator untuk semua metode HTTP standar: `@Get()`, `@Post()`, `@Put()`, `@Delete()`, `@Patch()`, `@Options()`, dan `@Head()`.

**Contoh:**
```typescript
import { Controller, Get, Post } from '@nestjs/common';

@Controller('items')
export class ItemsController {
  @Post()
  create(): string {
    return 'This action adds a new item';
  }

  @Get()
  findAll(): string {
    return 'This action returns all items';
  }
}
```

### HTTP Request

Objek permintaan mewakili permintaan HTTP dan memiliki properti untuk string kueri permintaan, parameter, header HTTP, dan isi.

**Contoh:**
Mengakses objek permintaan:
```typescript
import { Controller, Get, Req } from '@nestjs/common';
import { Request } from 'express';

@Controller('cats')
export class CatsController {
  @Get()
  findAll(@Req() request: Request): string {
    return 'This action returns all cats';
  }
}
```

### HTTP Response

Objek respons mewakili respons HTTP yang dikirim kembali oleh aplikasi Nest saat menerima permintaan.

**Contoh:**
Mengelola respons:
```typescript
import { Controller, Get, Res } from '@nestjs/common';
import { Response } from 'express';

@Controller('cats')
export class CatsController {
  @Get()
  findAll(@Res() res: Response) {
    res.status(200).send('This action returns all cats');
  }
}
```

### Asynchronous

NestJS mendukung metode `async` dan `Promise`.

**Contoh:**
```typescript
import { Controller, Get } from '@nestjs/common';

@Controller('cats')
export class CatsController {
  @Get()
  async findAll(): Promise<any[]> {
    return [];
  }
}
```

### Cookie

Anda dapat mengatur cookie pada respons keluar menggunakan metode `res.cookie()`.

**Contoh:**
```typescript
import { Controller, Get, Res } from '@nestjs/common';
import { Response } from 'express';

@Controller('cats')
export class CatsController {
  @Get()
  findAll(@Res({ passthrough: true }) response: Response) {
    response.cookie('key', 'value');
    return 'This action returns all cats';
  }
}
```

### View

NestJS dapat diintegrasikan dengan library rendering sisi server seperti Handlebars atau Pug.

**Contoh:**
Menggunakan `hbs` sebagai template engine.
```typescript
// main.ts
import { NestFactory } from '@nestjs/core';
import { NestExpressApplication } from '@nestjs/platform-express';
import { join } from 'path';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create<NestExpressApplication>(
    AppModule,
  );

  app.useStaticAssets(join(__dirname, '..', 'public'));
  app.setBaseViewsDir(join(__dirname, '..', 'views'));
  app.setViewEngine('hbs');

  await app.listen(3000);
}
bootstrap();
```

### Unit Test

Pengujian unit menguji komponen individual (seperti kelas atau fungsi) secara terpisah.

**Contoh:**
```typescript
// cats.controller.spec.ts
import { Test, TestingModule } from '@nestjs/testing';
import { CatsController } from './cats.controller';
import { CatsService } from './cats.service';

describe('CatsController', () => {
  let controller: CatsController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [CatsController],
      providers: [CatsService],
    }).compile();

    controller = module.get<CatsController>(CatsController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
```

### Integration Test

Pengujian integrasi menguji bagaimana beberapa komponen bekerja sama.

**Contoh:**
```typescript
// app.e2e-spec.ts
import { Test, TestingModule } from '@nestjs/testing';
import { INestApplication } from '@nestjs/common';
import * as request from 'supertest';
import { AppModule } from './../src/app.module';

describe('AppController (e2e)', () => {
  let app: INestApplication;

  beforeEach(async () => {
    const moduleFixture: TestingModule = await Test.createTestingModule({
      imports: [AppModule],
    }).compile();

    app = moduleFixture.createNestApplication();
    await app.init();
  });

  it('/ (GET)', () => {
    return request(app.getHttpServer())
      .get('/')
      .expect(200)
      .expect('Hello World!');
  });
});
```

### Provider

Provider adalah kelas yang dapat disuntikkan sebagai dependensi. Mereka sering digunakan untuk abstraksi detail implementasi.

**Contoh:**
```typescript
// cats.service.ts
import { Injectable } from '@nestjs/common';
import { Cat } from './interfaces/cat.interface';

@Injectable()
export class CatsService {
  private readonly cats: Cat[] = [];

  create(cat: Cat) {
    this.cats.push(cat);
  }

  findAll(): Cat[] {
    return this.cats;
  }
}
```

### Dependency Injection

NestJS memiliki wadah Inversion of Control (IoC) bawaan yang mengelola dependensi.

**Contoh:**
Menyuntikkan `CatsService` ke dalam `CatsController`.
```typescript
import { Controller, Get } from '@nestjs/common';
import { CatsService } from './cats.service';
import { Cat } from './interfaces/cat.interface';

@Controller('cats')
export class CatsController {
  constructor(private catsService: CatsService) {}

  @Get()
  async findAll(): Promise<Cat[]> {
    return this.catsService.findAll();
  }
}
```

- NestJS CLI
- Membuat Project
- Struktur Folder
- Decorator
- Module
- Controller
- HTTP Method
- HTTP Request
- HTTP Response
- Asynchronous
- Cookie
- View
- Unit Test
- Integration Test
- Provider
- Dependency Injection
- Custom Provider
- Module Reference
- Configuration
- Shared Module
- Database
- Logging
- Global Module
- Dynamic Module
- Validation
- Middleware
- Exception Filter
- Pipe
- Interceptor
- Custom Decorator
- Guard
- Lifecycle Event
- Reflector
- Global Provider