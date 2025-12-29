- C# : ASP.NET Core
    - Performance : 14707 RPS / 1.2 ms / 136.5 mb
    - Weakness : Garbage Collection / GC
- Rust : Actix
    - Performance : 21965 RPS / 1.4 ms / 16.6 mb
    - Weakness : Steep Learning Curve
- Java : Spring Webflux
    - Performance : 7051 RPS / 1.2 ms / 130.4 mb
    - Weakness : GC, High Memory Footprint without AOT Build
- NodeJS : NestJS/Fastify
    - Performance : 9164 RPS / 3.5 ms / 66.7 mb
    - Weakness : Single-threaded (Bad for CPU Bound), GC

## Nice to Have

* **Dependency Injection** : Built-in IoC / DI container
* **Routing & Controllers** : Modular, decorator/annotation-based
* **ORM / Database Layer** : ORM or Query Builder (SQL + NoSQL)
* **Validation & Serialization** : Schema-based / DTO / class-validator
* **Security** : Auth (JWT, OAuth2), Role/Permission, CSRF/XSS protection
* **API Layer** : RESTful / GraphQL / WebSocket / gRPC
* **Microservices Support** : Message brokers (RabbitMQ, Kafka, NATS)
* **Testing** : Unit + Integration + e2e frameworks
* **Config Management** : Env files + structured config repository
* **Build / CLI Tools** : Build scripts, scaffolding, migration tools
* **Queues & Jobs** : Background jobs / task queues / scheduler
* **Observability** : Logging, metrics, monitoring, tracing
