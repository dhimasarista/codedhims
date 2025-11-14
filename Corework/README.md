![](assets/20251106_155227_Frame_76.png)
# ⛾ ARC⌗Σage
- Corework : C# & Zig | Java, Swift
- Ohters : NodeJS, PHP
- Backend #1 : Spring Boot
- Backend #2 : NestJS, Laravel
- IoT/Embed : MicroEJ

## C# : Swis Army Knife

- Paradigma : OOP, Struct, Functional
- Parallelisme : Async/Await, Task Parallel Library
- Build : JIT, R2R, AOT/Native Binary
- Type : Garbage Collection, Runtime
- Tools : .NET SDK, Nuget

## Zig : The Low Level

* Paradigma : Struct-Oriented, Compile-time, No hidden control flow
* Parallelisme : Async/await, Multithread
* Build : AOT/Native Binary
* Tools : Zig Compiler, Zigmod
* Type : Manual Allocate / Free, Compile Time

## Java : Enterprise Ready

* Paradigma : OOP, Functional (Streams, Lambdas)
* Parallelisme : Threads, Virtual Threads, Reactive Programming
* Build : JIT, AOT/Native Binary
* Tools : OpenJDK, GraalVM, Maven.
* Type : Garbage Collection, Runtime

## Swift : Shifting Style

- Paradgima : OOP, Struct-Oriented, Actor, Functional
- Parallelisme : Async/Await, GCD
- Build : AOT/Native Binary
- Tools : Swift SDK (LLVM), Static SDK, SwiftPM

#### Analyze Them
- C# : ASP.NET Core
    - Performance : ~100k – 1.2M RPS ~50 - 100 Mb / sub (~0.2) Ms
    - Weakness : Managed GC overhead tetap ada (meskipun AOT / ReadyToRun / trimming membantu), plus runtime metadata, jadi overhead lebih besar vs native no-runtime bahasa.
- Zig : JetZig (HttpZ)
    - Performance : ~100k – 2M RPS ~4 - 50 Mb / ~nano - mili
    - Weakness : Manual Allocate/Free, Security Awareness
- Java : Spring Webflux
    - Performance : ~100k – 1.8M RPS / ~250 Mb - 2 Gb / ~0.1 Ms
    - Weakness : GC & Heavy than C#, JIT Startup Slow (Leyden Sol) , AOT Build (GraalVM CE) Single-thread
- Swift : Vapor
    - Performance : ~100K RPS / ~10 - 50 Mb / 0.3 Ms
    - Weakness : Low Adoption - Small Ecosystem

### 🟦 **Spring Boot (Java)**

* **Dependency Injection** : Spring Context (IoC Container)
* **ORM / Database Layer** : Spring Data JPA / Hibernate
* **Web Framework** : Spring MVC / WebFlux (Reactive)
* **Security** : Spring Security (JWT, OAuth2, OpenID Connect)
* **Configuration Management** : `application.yml` + Spring Profiles
* **Testing** : JUnit 5 + Mockito
* **Build Tool** : Maven / Gradle
* **Microservices** : Spring Cloud (Eureka, Config Server, Gateway)
* **Observability** : Micrometer + Prometheus + Grafana

---

### 🟩 **NestJS (TypeScript)**

* **Dependency Injection** : Built-in via @Injectable() decorator
* **Routing & Controllers** : Decorator-based modular architecture
* **ORM / Database Layer** : TypeORM / Prisma / Sequelize
* **Validation & Pipes** : class-validator + class-transformer
* **Security** : Passport.js (JWT, OAuth2), Guards, Interceptors
* **API Layer** : RESTful / GraphQL / WebSocket Gateway
* **Microservices Support** : gRPC, NATS, RabbitMQ, Kafka
* **Testing** : Jest (unit, e2e)
* **Config Management** : @nestjs/config + dotenv
* **CLI** : Nest CLI for scaffolding & modularization

---

### 🟥 **Laravel (PHP)**

* **Dependency Injection** : Service Container
* **Routing & Controllers** : Expressive route definitions + resource controllers
* **ORM / Database Layer** : Eloquent ORM
* **Validation** : Built-in Request Validation
* **Security** : CSRF Protection, Sanctum / Passport (JWT & OAuth2)
* **Template Engine** : Blade
* **Queues & Events** : Redis / RabbitMQ / Beanstalkd integration
* **API Layer** : RESTful + Resource Collections + API Resource
* **Testing** : PHPUnit + PestPHP
* **Config Management** : `.env` + Config Repository
* **CLI** : Artisan (migration, seeding, scaffolding)
* **Microservices Integration** : Laravel Octane / Horizon / Vapor
* **Observability** : Laravel Telescope / Log channels (Stackdriver, ELK, Sentry)