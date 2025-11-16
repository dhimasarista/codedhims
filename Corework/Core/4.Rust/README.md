# Rust Programming Language

![I made 3 Ferris wallpapers! : r/rust](https://external-preview.redd.it/sNEcEeDq_WAQbU8pZgzG6fAOKL9nLjoNJCvXMot7GvU.jpg?auto=webp&s=3ab515f94ddb3480c17b1049954a327e75ad9a31)

# 0. Introduction

**Rust** (dibaca: *rust* ) adalah sebuah bahasa pemrograman sistem-level yang berfokus pada **keamanan memori** (*memory safety* ) tanpa menggunakan *garbage collector* . Rust dikembangkan oleh **Mozilla Research** dan kini dipelihara komunitas melalui **Rust Foundation** . Bahasa ini dirancang untuk menggantikan bahasa seperti **C** dan **C++** dalam ranah sistem, namun tetap memberikan pengalaman modern seperti yang ditemukan pada bahasa tingkat tinggi.

Rust menggabungkan beberapa paradigma — termasuk **imperatif** , **fungsional** , serta **concurrent programming** dan mengatasi masalah klasik seperti *null pointer* , *race condition* , dan *manual memory management* menggunakan fitur seperti:

* **Ownership**
* **Borrowing**
* **Lifetimes**
* **Pattern Matching**
* **Zero-cost Abstractions**

Rust memiliki sintaks yang terinspirasi dari C/C++, namun dengan sejumlah penyempurnaan dan pengamanan yang membuat kode lebih aman dan mudah dipelihara.

Menurut **Rust Reference** , nama *Rust* dipilih karena singkat, unik, dan mudah dikenali; tidak ada arti teknis tertentu di balik nama tersebut.

> Comparative references across C#, Zig, Java, and Rust.

## Installation, Running Hello World

## Toolchain & Workload

## Karakteristik, Aturan & Penamaan

# 1. Basic

## 1.1 Data Types

### 1.1.1 Numbers

### 1.1.2 Characters

### 1.1.3 Boolean

### 1.1.4 Pointer-like Types (References)

### 1.1.5 Empty Data Type (`()`)

### 1.1.6 Aliasses (`type`)

### 1.1.7 Type Checking

## 1.2 Konversi, Type Check, & Casting Tipe Data

## 1.3 Data Items (let, const, static)

## 1.4 Data Structures

### 1.4.1 Array

### 1.4.2 Vector (`Vec`)

### 1.4.3 HashMap & BTreeMap

### 1.4.4 Struct

### 1.4.5 Trait (Interface Equivalent)

### 1.4.6 Enum

### 1.4.7 Object (Trait Objects)

### 1.4.8 Tuple

### 1.4.9 Anon Struct (Tidak ada, pakai tuple/struct literal)

### 1.4.10 Channel (mpsc)

### 1.4.11 Lainnya (Slices, Box, Rc, Arc)

## 1.5 Operators

## 1.6 Control Flow

### 1.6.1 Conditionals

### 1.6.2 Loopings

## 1.7 Null-Safety (`Option`, `Result`)

## 1.8 Input-Output (std::io)

## 1.9 Use Keyword (`use`, `pub use`, `crate`)

# 2. Programming Paradigms

# 3. Functional Programming

## 3.1 First-class & Higher-order Functions

## 3.2 Main Function

## 3.3 Pure Function-style

## 3.4 Recursion

## 3.5 Immutable Variable di Function

## 3.6 Fungsi dengan return value dan tidak

## 3.7 Function Parameter

## 3.8 Main Function Parameter (CLI args)

## 3.9 Function Short Expression

## 3.10 Higher Order Function

## 3.11 Method Reference (UFCS)

# 4. Struct

# 5. Object-Oriented Programming

## Object

## Struct as Class Equivalent

## Property & Method (impl)

## Access Modifier (`pub`)

## Namespace (Modules)

## Enkapsulasi

## Constructor (`new`)

## Variable Shadowing

## Inheritance (Composition & Traits)

## Abstract (Traits)

## Enumerated Types

## Extension Method (`trait` + `impl`)

## Base Keyword Equivalent (tidak ada, pakai trait default)

## Polymorphism (Static & Dynamic)

## Meta Programming (Macros)

## Static (Associated Functions)

## Metadata (`#[attributes]`)

# 6. Exception & Error Handling

## 1. Membuat Error

## 2. Menangani Error (`match`, `?`)

## 3. Menggunakan `?` Operator

# 7. Concurrency & Parallel Programming

## 1. Concurrency (async/await, futures)

## 2. Parallel Programming (rayon, threads)

## 3. Race Condition & Ownership Rules

# 8. Generic

## 1. Type Inference

## 2. Generic Struct

## 3. Generic Function

## 4. Trait Bounds (Covariant-like)

# 9. Domain-Specific Language (macro_rules!, proc-macro)

# 10. Package Manager (Cargo & Crates.io)

# 11. Testing & Debugging

## Unit Testing dalam Rust

## Debugging dalam Rust

# 12. Keywords & Syntactic Sugar

# 13. Regular-Expression (crate `regex`)

# 14. Preprocessor Directives (Attributes, cfg)

# 15. Memory Management

## Ownership

## Borrowing

## Lifetimes

## Smart Pointers (Box, Rc, Arc)

## No GC & Stack/Heap Behavior

# 16. Performance Engineering

## Zero-cost Abstraction

## Inlining & LLVM Optimizations

## Profiling Tools (perf, flamegraph)

## Unsafe Optimization

# 17. Monitoring & Diagnostic

## Logging (`log`, `tracing`)

## Metrics

## Diagnostic Tools

# 18. Build System & Project Architecture

## Cargo Workspace

## Module Layout

## Build Profiles

# 19. Design Patterns (Rust Versions)

# 20. Module System & Visibility Rules

# 21. Networking Fundamentals (Tokio, async-std)

# 22. File System & OS Interaction (std::fs)

# 23. Serialization & Interoperability (serde)

# 24. Reflection & Meta-programming (No runtime reflection, proc-macro)

# 25. Ecosystem & Frameworks
