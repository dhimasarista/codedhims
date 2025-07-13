# 1. Pengenalan NestJS

NestJS adalah framework backend berbasis TypeScript yang dibuat di atas Express.js (atau Fastify) untuk membangun aplikasi yang modular, testable, dan scalable. Dengan pendekatan berbasis dekorator seperti Angular, NestJS sangat cocok untuk membangun aplikasi yang terstruktur dengan baik.

NestJS pertama kali dirilis oleh **Kamil Myśliwiec** pada tahun 2017. Framework ini dibuat untuk menghadirkan solusi **modular, scalable, dan maintainable** dalam pengembangan aplikasi backend berbasis **Node.js**. Terinspirasi dari **Angular**, NestJS mengadopsi pendekatan **dekorator dan dependency injection** untuk membangun aplikasi yang lebih terstruktur.

Seiring waktu, NestJS berkembang menjadi framework yang populer di komunitas **JavaScript dan TypeScript**, terutama dalam pengembangan **backend API, microservices, dan aplikasi server-side lainnya**. Dengan dukungan ekosistem yang kuat, NestJS kini digunakan oleh banyak perusahaan besar untuk membangun aplikasi backend yang modern dan efisien.

# 2. Instalasi dan Setup

Untuk memulai dengan NestJS, pastikan Node.js sudah terinstal, lalu jalankan:

```sh
npm i -g @nestjs/cli
nest new my-app
```

Setelah itu, masuk ke folder proyek dan jalankan server:

```sh
cd my-app
npm run start:dev
```

# 3. Struktur Proyek

NestJS menggunakan arsitektur modular dengan beberapa komponen utama:

* **Modules** : Mengelompokkan fitur terkait.
* **Controllers** : Menangani permintaan HTTP.
* **Services** : Menangani logika bisnis.
* **Providers** : Menyediakan dependensi untuk digunakan di module lain.
* **Decorators** : Menyederhanakan penggunaan metadata untuk routing, validasi, dll.

## **Monolith**

```bash
/nestjs-monolith
├── src
│   ├── modules
│   │   ├── auth
│   │   │   ├── auth.controller.ts
│   │   │   ├── auth.service.ts
│   │   │   ├── auth.module.ts
│   │   │   ├── dto
│   │   │   │   ├── login.dto.ts
│   │   │   │   ├── register.dto.ts
│   │   ├── users
│   │   │   ├── users.controller.ts
│   │   │   ├── users.service.ts
│   │   │   ├── users.module.ts
│   │   ├── products
│   │   │   ├── products.controller.ts
│   │   │   ├── products.service.ts
│   │   │   ├── products.module.ts
│   ├── common
│   │   ├── decorators
│   │   ├── guards
│   │   ├── interceptors
│   │   ├── filters
│   ├── config
│   │   ├── database.config.ts
│   │   ├── env.config.ts
│   ├── main.ts
│   ├── app.module.ts
├── test
├── package.json
├── tsconfig.json
├── .env
```

## **Microservices**

```bash
/nestjs-microservices
├── apps
│   ├── api-gateway
│   │   ├── src
│   │   │   ├── main.ts
│   │   │   ├── app.module.ts
│   │   │   ├── modules
│   │   │   │   ├── auth
│   │   │   │   ├── users
│   │   │   │   ├── products
│   │   ├── package.json
│   │   ├── tsconfig.json
│   │   ├── .env
│   ├── auth-service
│   │   ├── src
│   │   │   ├── main.ts
│   │   │   ├── auth.module.ts
│   │   │   ├── auth.controller.ts
│   │   │   ├── auth.service.ts
│   │   │   ├── dto
│   │   ├── package.json
│   │   ├── tsconfig.json
│   │   ├── .env
│   ├── user-service
│   │   ├── src
│   │   │   ├── main.ts
│   │   │   ├── user.module.ts
│   │   │   ├── user.controller.ts
│   │   │   ├── user.service.ts
│   │   ├── package.json
│   │   ├── tsconfig.json
│   │   ├── .env
├── libs
│   ├── common
│   │   ├── src
│   │   │   ├── decorators
│   │   │   ├── guards
│   │   │   ├── interceptors
│   ├── package.json
├── docker-compose.yml
├── package.json

```

// tambahkan tentang sub-app monorepo

# 4. Modul, Controller, dan Service

Buat modul baru dengan:

```sh
nest g module nama directory
```

```sh
nest generate module users
nest generate controller users
nest generate service users
```

Modul ini akan otomatis terdaftar dalam `app.module.ts`.

# 5. Routing

Contoh controller sederhana:

```ts
import { Controller, Get } from '@nestjs/common';

@Controller('users')
export class UsersController {
  @Get()
  findAll() {
    return ['User1', 'User2'];
  }
}
```

# 6. Dependency Injection (DI)

NestJS menggunakan **DI** untuk mengelola dependensi secara efisien. Contoh penggunaan service dalam controller:

```ts
import { Injectable } from '@nestjs/common';

@Injectable()
export class UsersService {
  getUsers() {
    return ['User1', 'User2'];
  }
}
```

```ts
import { Controller, Get } from '@nestjs/common';
import { UsersService } from './users.service';

@Controller('users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  @Get()
  findAll() {
    return this.usersService.getUsers();
  }
}
```

# 6. Middleware dan Guards

Middleware digunakan untuk memproses request sebelum mencapai controller, sedangkan Guards digunakan untuk otentikasi dan otorisasi.

```ts
import { Injectable, CanActivate, ExecutionContext } from '@nestjs/common';

@Injectable()
export class AuthGuard implements CanActivate {
  canActivate(context: ExecutionContext): boolean {
    const request = context.switchToHttp().getRequest();
    return !!request.headers.authorization;
  }
}
```

Digunakan dalam controller:

```ts
import { UseGuards } from '@nestjs/common';
import { AuthGuard } from './auth.guard';

@Controller('secure')
@UseGuards(AuthGuard)
export class SecureController {}
```

# 8. ORM dan Database

NestJS mendukung berbagai ORM, seperti:

* **TypeORM**
* **Prisma**
* **Sequelize**
* **Mongoose** (MongoDB)

Contoh konfigurasi TypeORM:

```ts
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'root',
      password: 'password',
      database: 'test',
      autoLoadEntities: true,
      synchronize: true,
    }),
  ],
})
export class AppModule {}
```

Contoh model dengan TypeORM:

```ts
import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class User {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;
}
```

# 9. Validasi dan DTO

Gunakan class-validator untuk validasi:

```ts
import { IsString } from 'class-validator';

export class CreateUserDto {
  @IsString()
  name: string;
}
```

Gunakan DTO di controller:

```ts
@Post()
create(@Body() createUserDto: CreateUserDto) {
  return this.userService.create(createUserDto);
}
```

# 10. Testing

NestJS mendukung unit test dan e2e test dengan Jest.

```ts
describe('UsersService', () => {
  let service: UsersService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [UsersService],
    }).compile();

    service = module.get<UsersService>(UsersService);
  });

  it('should return an array of users', () => {
    expect(service.getUsers()).toEqual(['User1', 'User2']);
  });
});
```

# 11. Nest Adapter: Common, ExpressJS, Fastify

# 12. Pipe

# 13. Exception Filter

# 15. Decorator

### 1. **Decorator untuk Controller & Routing**

* `@Controller(path?)` → Menandai kelas sebagai controller.
* `@Get(path?)` → Menangani permintaan HTTP GET.
* `@Post(path?)` → Menangani permintaan HTTP POST.
* `@Put(path?)` → Menangani permintaan HTTP PUT.
* `@Delete(path?)` → Menangani permintaan HTTP DELETE.
* `@Patch(path?)` → Menangani permintaan HTTP PATCH.
* `@Options(path?)` → Menangani permintaan HTTP OPTIONS.
* `@Head(path?)` → Menangani permintaan HTTP HEAD.

### 2. **Decorator untuk Request & Response**

* `@Req()` → Mendapatkan objek request.
* `@Res()` → Mendapatkan objek response.
* `@Next()` → Mendapatkan fungsi next untuk middleware.
* `@Param(param?: string)` → Mendapatkan parameter route.
* `@Query(param?: string)` → Mendapatkan query parameter.
* `@Body(param?: string)` → Mendapatkan body request.
* `@Headers(param?: string)` → Mendapatkan header request.
* `@Session()` → Mengakses session dari request.
* `@Ip()` → Mendapatkan IP client.
* `@HostParam(param?: string)` → Mendapatkan host parameter dari request.

### 3. **Decorator untuk Dependency Injection**

* `@Injectable()` → Menandai kelas sebagai provider yang bisa di-inject.
* `@Inject(token?)` → Menginject provider secara eksplisit.
* `@Optional()` → Menandai dependency sebagai opsional.

### 4. **Decorator untuk Middleware**

* `@Middleware()` → Menandai kelas sebagai middleware.

### 5. **Decorator untuk Guard & Interceptor**

* `@UseGuards(...guards)` → Menggunakan guard untuk proteksi route.
* `@UseInterceptors(...interceptors)` → Menggunakan interceptor untuk mengubah response.

### 6. **Decorator untuk Pipe & Filter**

* `@UsePipes(...pipes)` → Menggunakan validation pipe.
* `@UseFilters(...filters)` → Menggunakan exception filter.

### 7. **Decorator untuk WebSocket**

* `@WebSocketGateway(port?, options?)` → Menandai kelas sebagai WebSocket Gateway.
* `@SubscribeMessage(event)` → Menangani event WebSocket tertentu.

### 8. **Decorator untuk Microservices**

* `@MessagePattern(pattern)` → Menangani pesan masuk dalam microservices.
* `@EventPattern(pattern)` → Menangani event dalam microservices.

### 9. **Decorator untuk GraphQL**

* `@Resolver(of?)` → Menandai kelas sebagai resolver.
* `@Query(returnsType?)` → Menangani query GraphQL.
* `@Mutation(returnsType?)` → Menangani mutation GraphQL.
* `@Subscription(returnsType?)` → Menangani subscription GraphQL.
* `@Args(name?)` → Mengambil argument dari GraphQL.
