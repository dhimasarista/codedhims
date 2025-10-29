# NestJS : Enterprise on Javascript

![Why you should start using Nest JS in 2022? | by Yaman Omar Alashqar |  Medium](https://miro.medium.com/1*KSaKpNjCfrvOhTR8BGX5cg.jpeg)

NestJS adalah framework NodeJS (BunJS Compatible) yang progresif dan dibangun dengan TypeScript untuk membangun aplikasi sisi server yang efisien, andal, dan dapat diskalakan. NestJS sangat cocok untuk aplikasi enterprise karena framework ini menggunakan micro-framework seperti Express atau Fastify sebagai engine utamanya atau adapter, sehingga memungkinkan pengembangan yang lebih cepat dan efisien tanpa harus membangun semuanya dari awal.

### Project Structures

- Monolith

```bash
nestjs-monolith/
├── src/
│   ├── app.module.ts               # Root module
│   ├── main.ts                     # Entry point aplikasi
│   ├── config/                     # Konfigurasi global
│   │   ├── config.module.ts
│   │   ├── config.service.ts
│   │   └── database.config.ts
│   ├── common/                     # Folder untuk utilitas global
│   │   ├── constants/              # Konstanta global
│   │   │   └── index.ts
│   │   ├── decorators/             # Custom decorators
│   │   ├── filters/                # Global exception filters
│   │   ├── guards/                 # Global guards
│   │   ├── interceptors/           # Global interceptors
│   │   ├── pipes/                  # Global pipes
│   │   └── utils/                  # Helper functions/utilities
│   │       └── index.ts
│   ├── modules/                    # Semua fitur modul
│   │   ├── auth/                   # Modul authentication
│   │   │   ├── auth.module.ts
│   │   │   ├── auth.controller.ts
│   │   │   ├── auth.service.ts
│   │   │   ├── dto/
│   │   │   │   ├── login.dto.ts
│   │   │   │   └── register.dto.ts
│   │   │   ├── guards/
│   │   │   │   └── jwt-auth.guard.ts
│   │   │   └── strategies/
│   │   │       └── jwt.strategy.ts
│   │   ├── users/                  # Modul user
│   │   │   ├── users.module.ts
│   │   │   ├── users.controller.ts
│   │   │   ├── users.service.ts
│   │   │   ├── dto/
│   │   │   │   ├── create-user.dto.ts
│   │   │   │   └── update-user.dto.ts
│   │   │   └── entities/
│   │   │       └── user.entity.ts
│   │   └── products/               # Modul produk contoh
│   │       ├── products.module.ts
│   │       ├── products.controller.ts
│   │       ├── products.service.ts
│   │       ├── dto/
│   │       │   ├── create-product.dto.ts
│   │       │   └── update-product.dto.ts
│   │       └── entities/
│   │           └── product.entity.ts
│   ├── database/                   # Database setup
│   │   ├── database.module.ts
│   │   ├── database.providers.ts
│   │   └── entities/               # Optional, bisa juga di module masing-masing
│   └── shared/                     # Reusable module
│       ├── mail/                   # Email service
│       │   ├── mail.module.ts
│       │   └── mail.service.ts
│       └── logger/                 # Logger global
│           ├── logger.module.ts
│           └── logger.service.ts
├── test/                            # Unit & e2e tests
│   ├── app.e2e-spec.ts
│   └── jest-e2e.json
├── node_modules/
├── .env                             # Environment variables
├── .env.example                     # Template env
├── .eslintrc.js
├── .prettierrc
├── nest-cli.json
├── package.json
├── tsconfig.build.json
└── tsconfig.json
```

- Microservices

```
nestjs-microservice/
├── services/                       # Setiap microservice terpisah
│   ├── auth-service/
│   │   ├── src/
│   │   │   ├── main.ts
│   │   │   ├── app.module.ts
│   │   │   ├── config/
│   │   │   │   ├── config.module.ts
│   │   │   │   ├── config.service.ts
│   │   │   │   └── database.config.ts
│   │   │   ├── common/
│   │   │   │   ├── decorators/
│   │   │   │   ├── filters/
│   │   │   │   ├── guards/
│   │   │   │   ├── interceptors/
│   │   │   │   ├── pipes/
│   │   │   │   └── utils/
│   │   │   ├── modules/
│   │   │   │   └── auth/
│   │   │   │       ├── auth.module.ts
│   │   │   │       ├── auth.controller.ts
│   │   │   │       ├── auth.service.ts
│   │   │   │       ├── dto/
│   │   │   │       │   ├── login.dto.ts
│   │   │   │       │   └── register.dto.ts
│   │   │   │       └── strategies/
│   │   │   │           └── jwt.strategy.ts
│   │   │   ├── database/
│   │   │   │   ├── database.module.ts
│   │   │   │   └── database.providers.ts
│   │   │   └── shared/
│   │   │       └── logger/
│   │   │           ├── logger.module.ts
│   │   │           └── logger.service.ts
│   │   ├── test/
│   │   │   └── auth.e2e-spec.ts
│   │   ├── package.json
│   │   └── tsconfig.json
│   ├── user-service/
│   │   ├── src/
│   │   │   ├── main.ts
│   │   │   ├── app.module.ts
│   │   │   ├── modules/
│   │   │   │   └── users/
│   │   │   │       ├── users.module.ts
│   │   │   │       ├── users.controller.ts
│   │   │   │       ├── users.service.ts
│   │   │   │       ├── dto/
│   │   │   │       └── entities/
│   │   │   └── common/
│   │   │       └── utils/
│   │   ├── test/
│   │   └── package.json
│   └── product-service/
│       ├── src/
│       │   ├── main.ts
│       │   ├── app.module.ts
│       │   ├── modules/
│       │   │   └── products/
│       │   │       ├── products.module.ts
│       │   │       ├── products.controller.ts
│       │   │       ├── products.service.ts
│       │   │       ├── dto/
│       │   │       └── entities/
│       │   └── common/
│       │       └── utils/
│       ├── test/
│       └── package.json
├── gateway/                        # API Gateway / BFF (opsional)
│   ├── src/
│   │   ├── main.ts
│   │   ├── app.module.ts
│   │   ├── modules/
│   │   │   └── gateway/
│   │   └── common/
│   └── package.json
├── docker-compose.yml              # Untuk orkestrasi semua service
├── .env.example
└── README.md
```

- Modular-Monolith

```
nestjs-modular-monolith/
├── src/
│   ├── main.ts                     # Entry point aplikasi
│   ├── app.module.ts               # Root module
│   ├── config/                     # Konfigurasi global
│   │   ├── config.module.ts
│   │   ├── config.service.ts
│   │   └── database.config.ts
│   ├── common/                     # Reusable utilities & global tools
│   │   ├── constants/
│   │   ├── decorators/
│   │   ├── filters/
│   │   ├── guards/
│   │   ├── interceptors/
│   │   ├── pipes/
│   │   └── utils/
│   ├── modules/                    # Semua modul fitur, masing-masing modular
│   │   ├── auth/
│   │   │   ├── auth.module.ts
│   │   │   ├── auth.controller.ts
│   │   │   ├── auth.service.ts
│   │   │   ├── dto/
│   │   │   │   ├── login.dto.ts
│   │   │   │   └── register.dto.ts
│   │   │   └── strategies/
│   │   │       └── jwt.strategy.ts
│   │   ├── users/
│   │   │   ├── users.module.ts
│   │   │   ├── users.controller.ts
│   │   │   ├── users.service.ts
│   │   │   ├── dto/
│   │   │   │   ├── create-user.dto.ts
│   │   │   │   └── update-user.dto.ts
│   │   │   └── entities/
│   │   │       └── user.entity.ts
│   │   ├── products/
│   │   │   ├── products.module.ts
│   │   │   ├── products.controller.ts
│   │   │   ├── products.service.ts
│   │   │   ├── dto/
│   │   │   └── entities/
│   │   │       └── product.entity.ts
│   │   └── orders/
│   │       ├── orders.module.ts
│   │       ├── orders.controller.ts
│   │       ├── orders.service.ts
│   │       ├── dto/
│   │       └── entities/
│   │           └── order.entity.ts
│   ├── database/                   # Database provider
│   │   ├── database.module.ts
│   │   ├── database.providers.ts
│   │   └── entities/               # Bisa ditempatkan di masing-masing modul juga
│   └── shared/                     # Reusable module lintas modul
│       ├── mail/
│       │   ├── mail.module.ts
│       │   └── mail.service.ts
│       └── logger/
│           ├── logger.module.ts
│           └── logger.service.ts
├── test/                            # Unit & e2e tests
│   ├── app.e2e-spec.ts
│   └── jest-e2e.json
├── .env
├── .env.example
├── package.json
├── tsconfig.json
├── tsconfig.build.json
├── nest-cli.json
├── .eslintrc.js
└── .prettierrc
```

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

### Hasil Generate New Project

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

#### Common Decorator

Dekorator Controller

- @Controller(): Mendefinisikan controller
- @Controller('path'): Mendefinisikan controller dengan path tertentu

Dekorator Route

- @Get(): Mendefinisikan route HTTP GET
- @Post(): Mendefinisikan route HTTP POST
- @Put(): Mendefinisikan route HTTP PUT
- @Delete(): Mendefinisikan route HTTP DELETE
- @Patch(): Mendefinisikan route HTTP PATCH
- @Options(): Mendefinisikan route HTTP OPTIONS
- @Head(): Mendefinisikan route HTTP HEAD

Dekorator Parameter

- @Param(): Mengambil parameter dari route
- @Query(): Mengambil query parameter
- @Body(): Mengambil body request
- @Headers(): Mengambil header request
- @Req(): Mengambil objek request
- @Res(): Mengambil objek response
- @Next(): Mengambil fungsi next

Dekorator Lainnya

- @Inject(): Menginject dependency
- @Injectable(): Mendefinisikan kelas yang dapat diinject
- @Module(): Mendefinisikan modul
- @UseGuards(): Mengaktifkan guard untuk controller atau route
- @UseInterceptors(): Mengaktifkan interceptor untuk controller atau route
- @UseFilters(): Mengaktifkan filter untuk controller atau route

Dekorator Validasi

- @IsString(): Validasi bahwa nilai adalah string
- @IsNumber(): Validasi bahwa nilai adalah number
- @IsBoolean(): Validasi bahwa nilai adalah boolean
- @IsEmail(): Validasi bahwa nilai adalah email
- @Min(): Validasi bahwa nilai minimal
- @Max(): Validasi bahwa nilai maksimal
- @Length(): Validasi bahwa nilai memiliki panjang tertentu

#### ExpressJS Decorator

Menggunakan `@nestjs/platform-express` atau `express`

Adapter `ExpressAdapter` (default)

Berikut daftar dekoratornya:

- @Req()

  Mengakses objek Request milik Express (express.Request).

  Berguna untuk membaca data mentah request.

  Biasanya digunakan kalau kamu butuh akses langsung ke header, cookie, atau properti lain dari Express.

  ```javascript
  import { Request } from 'express';
  ...
  @Get("index")
  index(@Req() req: Request){}
  ...
  ```
- @Res()

  Mengakses Response dari Express (express.Response).

  Memungkinkan kamu memanggil method native seperti res.send() atau res.json().

  Bila tidak pakai { passthrough: true }, kamu harus kirim respons manual.

  ```javascript
  import { Response } from 'express';
  ...
  @Get("index")
  index(@Res() res: Response){}
  ...
  ```
- @Next()

  Mengakses fungsi next() khas middleware Express.

  Umumnya dipakai dalam middleware chaining atau exception handling manual.

  ```javascript
  @Get()
  handle(@Req() req, @Res() res, @Next() next) {
    if (!req.user) return next(new Error('Unauthorized'));
    res.send('OK');
  }
  ```
- @UploadedFile() / @UploadedFiles()

  - Bekerja sama dengan **`FileInterceptor`** dari `@nestjs/platform-express`.
  - Menggunakan **multer** di balik layar.
  - `@UploadedFile()` → untuk upload satu file.
  - `@UploadedFiles()` → untuk upload banyak file.

  ```javascript
  @Post('upload')
  @UseInterceptors(FileInterceptor('file'))
  upload(@UploadedFile() file: Express.Multer.File) {
    return file.originalname;
  }

  ```
- @Session()`*(opsional)`

  - `Mengakses session Express bila kamu pakai`express-session`.
  - Biasanya digunakan untuk autentikasi berbasis sesi.

#### Fastify Decorator

Paket: @nestjs/platform-fastify

Digunakan saat aplikasi NestJS dijalankan dengan FastifyAdapter.

- `@Req()`

* Mengakses **FastifyRequest** (bukan Express).
* Objek ini lebih ringan dan cepat dibanding Express.
* Tidak semua property Express tersedia (misal `req.params` bisa berbeda struktur).

```ts
@Post()
handle(@Req() req: FastifyRequest) {
  console.log(req.ip);
}
```

- `@Res()`

* Mengakses **FastifyReply** , objek response versi Fastify.
* Kamu bisa panggil `res.send()`, `res.status()`, atau `res.header()`.
* Tapi kalau mau NestJS handle otomatis, jangan return langsung dari `res.send()`.

```ts
@Get()
getData(@Res() reply: FastifyReply) {
  reply.code(200).send({ msg: 'Hello from Fastify' });
}
```

- `@FastifyRequest()` dan `@FastifyReply()`

* Alias eksplisit agar jelas bahwa ini bukan Express.
* Berguna kalau kamu mau menjaga kode tetap eksplisit lintas platform.

```ts
@Post()
handle(@FastifyRequest() req: FastifyRequest, @FastifyReply() reply: FastifyReply) {
  reply.send({ id: req.id });
}
```

- File Upload (via Plugin)

* Fastify tidak punya `multer`, jadi perlu plugin:

  `@fastify/multipart`
* Setelah di-register di `main.ts`, baru kamu bisa akses file di handler.
* Tidak tersedia decorator khusus seperti `@UploadedFile()` (harus manual).

```ts
@Post('upload')
async upload(@Req() req: FastifyRequest) {
  const data = await req.file();
  return { filename: data.filename };
}
```

- Streaming & Performance

* Fastify decorators mendukung **streaming response** dan **async hooks** bawaan Fastify.
* Cocok untuk high-performance API, misalnya real-time data push atau IoT.

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

## **Custom Provider**

Custom provider digunakan saat kita ingin mengontrol bagaimana dependency diinject.

```ts
// src/common/providers/custom.provider.ts
import { Provider } from '@nestjs/common';
import { ConfigService } from '../config/config.service';

export const CustomServiceProvider: Provider = {
  provide: 'CUSTOM_SERVICE',
  useFactory: (config: ConfigService) => {
    return new SomeCustomService(config.get('CUSTOM_OPTION'));
  },
  inject: [ConfigService],
};
```

---

## **Module Reference**

Module reference memungkinkan kita mengakses provider dari modul lain.

```ts
// src/modules/users/users.module.ts
import { Module, forwardRef } from '@nestjs/common';
import { UsersService } from './users.service';
import { AuthModule } from '../auth/auth.module';

@Module({
  imports: [forwardRef(() => AuthModule)],
  providers: [UsersService],
  exports: [UsersService],
})
export class UsersModule {}
```

---

## **Configuration**

Konfigurasi global menggunakan `ConfigModule` & `ConfigService`.

```ts
// src/config/config.module.ts
import { Module } from '@nestjs/common';
import { ConfigService } from './config.service';

@Module({
  providers: [ConfigService],
  exports: [ConfigService],
})
export class ConfigModule {}
```

```ts
// src/config/config.service.ts
import { Injectable } from '@nestjs/common';
import * as dotenv from 'dotenv';

dotenv.config();

@Injectable()
export class ConfigService {
  get(key: string): string {
    return process.env[key];
  }
}
```

---

## **Shared Module**

Module yang bisa dipakai lintas modul.

```ts
// src/shared/logger/logger.module.ts
import { Module, Global } from '@nestjs/common';
import { LoggerService } from './logger.service';

@Global()
@Module({
  providers: [LoggerService],
  exports: [LoggerService],
})
export class LoggerModule {}
```

---

## **Database**

Database connection bisa diwrap di module terpisah.

```ts
// src/database/database.module.ts
import { Module } from '@nestjs/common';
import { databaseProviders } from './database.providers';

@Module({
  providers: [...databaseProviders],
  exports: [...databaseProviders],
})
export class DatabaseModule {}
```

```ts
// src/database/database.providers.ts
import { DataSource } from 'typeorm';

export const databaseProviders = [
  {
    provide: 'DATA_SOURCE',
    useFactory: async () => {
      const dataSource = new DataSource({
        type: 'mysql',
        host: process.env.DB_HOST,
        username: process.env.DB_USER,
        password: process.env.DB_PASS,
        database: process.env.DB_NAME,
        entities: [__dirname + '/../**/*.entity{.ts,.js}'],
        synchronize: true,
      });
      return dataSource.initialize();
    },
  },
];
```

---

## **Logging**

Gunakan service logging global.

```ts
// src/shared/logger/logger.service.ts
import { Injectable, Logger } from '@nestjs/common';

@Injectable()
export class LoggerService extends Logger {
  logInfo(message: string) {
    this.log(message, 'INFO');
  }
  logError(message: string, trace?: string) {
    this.error(message, trace, 'ERROR');
  }
}
```

---

## **Global Module**

Module yang bersifat global untuk seluruh aplikasi.

```ts
// src/common/global/global.module.ts
import { Global, Module } from '@nestjs/common';
import { LoggerService } from '../logger/logger.service';

@Global()
@Module({
  providers: [LoggerService],
  exports: [LoggerService],
})
export class GlobalModule {}
```

---

## **Dynamic Module**

Module yang bisa dikonfigurasi saat import.

```ts
// src/modules/mail/mail.module.ts
import { Module, DynamicModule } from '@nestjs/common';
import { MailService } from './mail.service';

@Module({})
export class MailModule {
  static forRoot(apiKey: string): DynamicModule {
    return {
      module: MailModule,
      providers: [{ provide: 'MAIL_API_KEY', useValue: apiKey }, MailService],
      exports: [MailService],
    };
  }
}
```

---

## **Validation**

Gunakan DTO & `ValidationPipe` untuk request validation.

```ts
// src/modules/users/dto/create-user.dto.ts
import { IsEmail, IsNotEmpty, Length } from 'class-validator';

export class CreateUserDto {
  @IsEmail()
  email: string;

  @IsNotEmpty()
  @Length(6, 20)
  password: string;
}
```

```ts
// src/main.ts
import { ValidationPipe } from '@nestjs/common';

app.useGlobalPipes(new ValidationPipe({ whitelist: true }));
```

---

## **Middleware**

Middleware untuk intercept request sebelum controller.

```ts
// src/common/middleware/logger.middleware.ts
import { Injectable, NestMiddleware } from '@nestjs/common';
import { Request, Response, NextFunction } from 'express';

@Injectable()
export class LoggerMiddleware implements NestMiddleware {
  use(req: Request, res: Response, next: NextFunction) {
    console.log(`[Request] ${req.method} ${req.originalUrl}`);
    next();
  }
}
```

---

## **Exception Filter**

Custom exception handling.

```ts
// src/common/filters/http-exception.filter.ts
import { ExceptionFilter, Catch, ArgumentsHost, HttpException } from '@nestjs/common';
import { Request, Response } from 'express';

@Catch(HttpException)
export class HttpExceptionFilter implements ExceptionFilter {
  catch(exception: HttpException, host: ArgumentsHost) {
    const ctx = host.switchToHttp();
    const response = ctx.getResponse<Response>();
    const request = ctx.getRequest<Request>();
    const status = exception.getStatus();

    response.status(status).json({
      statusCode: status,
      timestamp: new Date().toISOString(),
      path: request.url,
      message: exception.message,
    });
  }
}
```

---

## **Pipes**

Pipes di NestJS adalah sebuah konsep yang memungkinkan Anda untuk memvalidasi dan mengubah data yang diterima oleh aplikasi Anda. Pipes adalah sebuah fungsi yang dapat digunakan untuk memvalidasi dan mengubah data sebelum data tersebut diproses oleh controller.Custom pipe untuk transformasi/validasi

```ts
// src/common/pipes/parse-int.pipe.ts
import { PipeTransform, Injectable, BadRequestException } from '@nestjs/common';

@Injectable()
export class ParseIntPipe implements PipeTransform<string, number> {
  transform(value: string): number {
    const val = parseInt(value, 10);
    if (isNaN(val)) {
      throw new BadRequestException('Validation failed');
    }
    return val;
  }
}
```

---

## **Interceptor**

Interceptor di NestJS adalah sebuah konsep yang memungkinkan Anda untuk mengintersepsi request dan response HTTP sebelum atau setelah controller menangani request tersebut. Interceptor dapat digunakan untuk melakukan beberapa hal, seperti:

- Logging: Interceptor dapat digunakan untuk mencatat request dan response HTTP untuk keperluan logging.
- Autentikasi: Interceptor dapat digunakan untuk memeriksa apakah request HTTP memiliki token autentikasi yang valid.
- Otorisasi: Interceptor dapat digunakan untuk memeriksa apakah pengguna yang membuat request memiliki akses yang cukup untuk melakukan aksi tertentu.
- Transformasi data: Interceptor dapat digunakan untuk mengubah data request atau response sebelum atau setelah controller menangani request tersebut.

```ts
// src/common/interceptors/logging.interceptor.ts
import { Injectable, NestInterceptor, ExecutionContext, CallHandler } from '@nestjs/common';
import { Observable, tap } from 'rxjs';

@Injectable()
export class LoggingInterceptor implements NestInterceptor {
  intercept(context: ExecutionContext, next: CallHandler): Observable<any> {
    console.log('Before...');
    const now = Date.now();
    return next.handle().pipe(tap(() => console.log(`After... ${Date.now() - now}ms`)));
  }
}
```

---

## **Custom Decorator**

Buat decorator sendiri untuk metadata.

```ts
// src/common/decorators/roles.decorator.ts
import { SetMetadata } from '@nestjs/common';

export const Roles = (...roles: string[]) => SetMetadata('roles', roles);
```

---

## **Guard**

Protect routes berdasarkan role atau kondisi lain.

```ts
// src/common/guards/roles.guard.ts
import { Injectable, CanActivate, ExecutionContext } from '@nestjs/common';
import { Reflector } from '@nestjs/core';

@Injectable()
export class RolesGuard implements CanActivate {
  constructor(private reflector: Reflector) {}
  canActivate(context: ExecutionContext): boolean {
    const roles = this.reflector.get<string[]>('roles', context.getHandler());
    if (!roles) return true;
    const request = context.switchToHttp().getRequest();
    const user = request.user;
    return roles.includes(user.role);
  }
}
```

---

## **Lifecycle Event**

Hook untuk lifecycle modul/service.

```ts
// OnModuleInit & OnApplicationBootstrap
import { Injectable, OnModuleInit, OnApplicationBootstrap } from '@nestjs/common';

@Injectable()
export class AppService implements OnModuleInit, OnApplicationBootstrap {
  onModuleInit() {
    console.log('Module initialized');
  }
  onApplicationBootstrap() {
    console.log('Application bootstrap finished');
  }
}
```

---

## **Reflector**

Gunakan `Reflector` untuk mengambil metadata dari decorator.

```ts
import { Reflector } from '@nestjs/core';
const roles = this.reflector.get<string[]>('roles', handler);
```

---

## **Global Provider**

Provider yang bisa dipakai di seluruh modul tanpa import ulang.

```ts
// src/common/global/global.provider.ts
import { Global, Module } from '@nestjs/common';
import { LoggerService } from '../logger/logger.service';

@Global()
@Module({
  providers: [LoggerService],
  exports: [LoggerService],
})
export class GlobalProviderModule {}
```
