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