![](assets/20251115_135255_Frame_80.png)

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

## Rust : Safe Systems
* Paradigma : Struct-Oriented, Functional, Minimal OOP
* Parallelisme : Async/Await, Threads, Futures
* Build : AOT/Native Binary (LLVM)
* Tools : Rust Compiler (rustc), Cargo, Crates.io
* Type : Ownership + Borrowing, No Garbage Collector

### 🏗️ Software Development
- **Databases** : PostgreSQL, Dragonfly
- **Orchestration**
  - CI/CD : Github Actions, Jenkins
  - Podman + Kubernetes (Optional)
- **Event Bus** :
  - RabbitMQ, Kafka, NATS
  - Redis Pub/Sub
- **Observability & Monitoring**
  - Grafana + Prometheus atau Elastic Stack (ELK)
  - Sentry / LogRocket
- **API Layer**
  - API Gateway (Kong / Traefik / Nginx)
- **Securiy Enhancements**
  - JWT / OAuth2 / OpenID Connect
  - Vault / AWS Secrets Manager
- **Caching & Search**
  - In-memory (Dragongly/Redis)
  - Elasticsearch

### ⛔ Trade-off Territory
- 🐢 single-thread bottleneck 
- 🐘 no native concurreny
- 🐹 minimalist over flexible
- 🐍 slow in raw, duck typing

> Notion should be used only for planning, overviews, and lightweight documentation.
