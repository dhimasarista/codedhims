![](assets/20251106_155227_Frame_76.png)

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