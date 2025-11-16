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

## **Installation, Running Hello World**

**1. Install Rust Toolchain**

Rust menggunakan installer resmi bernama **rustup** (toolchain manager).

**Windows / Linux / macOS:**

```sh
curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh
```

Setelah selesai, jalankan:

```sh
rustc --version
cargo --version
```

Keduanya harus tampil.

* `rustc` = compiler
* `cargo` = package manager + build system

---

**2. Update Rust**

```sh
rustup update
```

---

**3. Membuat Project Baru**

Rust menggunakan Cargo sebagai build system.

```sh
cargo new hello
cd hello
```

Struktur project:

```
hello/
 ├─ Cargo.toml
 └─ src/
     └─ main.rs
```

---

**4. Hello World**

File: `src/main.rs`

```rust
fn main() {
    println!("Hello, world!");
}
```

Jalankan:

```sh
cargo run
```

---

## **Toolchain & Workload**

Rust memiliki sistem toolchain yang kuat, dikelola oleh **rustup**.

**1. Channel / Toolchain**

Rust menyediakan beberapa channel:

* **stable** → digunakan untuk produksi
* **beta** → kandidat stable berikutnya
* **nightly** → fitur eksperimental

Ganti toolchain:

```sh
rustup default stable
rustup default nightly
```

---

**2. Target & Cross Compilation**

Rust sangat kuat dalam *cross-compiling*.

Melihat target yang tersedia:

```sh
rustc --print target-list
```

Contoh compile ke ARM:

```sh
rustup target add aarch64-unknown-linux-gnu
```

---

**3. Cargo Workload**

Cargo menyediakan banyak perintah inti:


| Perintah                | Fungsi                   |
| ------------------------- | -------------------------- |
| `cargo build`           | Compile debug mode       |
| `cargo build --release` | Build optimized          |
| `cargo run`             | Compile + run            |
| `cargo test`            | Jalankan test            |
| `cargo fmt`             | Format kode              |
| `cargo clippy`          | Linting & Best Practices |
| `cargo doc --open`      | Generate documentation   |

---

**4. Workspace (Monorepo)**

Rust mendukung workspace untuk banyak crate dalam satu project besar.

Struktur:

```
my_workspace/
 ├─ Cargo.toml (workspace)
 ├─ app/
 └─ lib/
```

Cargo workspace membantu modularitas besar seperti microservices, game engine, atau IoT stack.

## **Karakteristik, Aturan & Penamaan**

**1. Karakteristik Bahasa Rust**

* **Memory-safety tanpa garbage collector**
  Menggunakan **ownership**, **borrowing**, dan **lifetimes** sebagai sistem keamanan.
* **Zero-cost abstractions**
  Abstraksi tinggi tanpa overhead runtime.
* **Strong static typing**
  Kompiler sangat ketat, banyak error tertangkap saat compile-time.
* **Immutable-by-default**
  Semua binding default-nya immutable kecuali diberi `mut`.
* **Ekosistem modern dengan Cargo**
  Build system + dependency manager bawaan.
* **Cross-platform & Embedded Ready**
  Bisa untuk server, CLI, sistem low-level, IoT, hingga WebAssembly.

---

**2. Aturan Penamaan (Naming Rules)**

**Variabel**

snake_case

```rust
let user_name = "dhimas";
```

**Function**

snake_case

```rust
fn calculate_sum() {}
```

**Struct / Enum / Trait**

PascalCase

```rust
struct UserAccount {}
enum LogLevel {}
trait Drawable {}
```

**Constant**

SCREAMING_SNAKE_CASE

```rust
const MAX_RETRIES: u32 = 3;
```

**Module**

snake_case

```rust
mod user_service;
```

---

**3. Aturan Dasar Syntax Rust**

**Immutable by default**

```rust
let x = 10;      // immutable
let mut y = 20;  // mutable
```

**Semicolon = end of statement**

```rust
let a = 5;
```

**Expression-based language**

```rust
let score = {
    let base = 10;
    base + 5      // tanpa semicolon → menjadi nilai return
};
```

**Tidak ada `null`**

Rust menggantinya dengan:

```rust
let value: Option<i32> = Some(10);
let nothing: Option<i32> = None;
```

Untuk error handling:

```rust
fn load() -> Result<String, std::io::Error> {
    Ok("done".to_string())
}
```

# 1. Basic

## 1.1 Data Types

Rust tidak membedakan tipe data menjadi “primitive” dan “object” seperti C# atau Java. Semua tipe di Rust adalah **value types** , dan tidak ada konsep *object wrapper* seperti `Integer` atau `Boolean` di Java, maupun *boxing/unboxing* seperti di C#. Scalar types (integer, float, bool, char) disimpan di stack seperti di Zig, sementara tipe yang mengelola data heap seperti `String` dan `Vec<T>` tetap merupakan value yang memiliki ownership, bukan objek referensi seperti di Java/C#.

### 1.1.1 Numbers

* **Integer (Signed / Unsigned)**
  * **8-bit** : `i8`, `u8`
  * **16-bit** : `i16`, `u16`
  * **32-bit** : `i32`, `u32`
  * **64-bit** : `i64`, `u64`
  * **128-bit** : `i128`, `u128`
  * **Pointer-sized** : `isize`, `usize`
* **Floating Point**
  * **32-bit** : `f32`
  * **64-bit** : `f64`

### 1.1.2 Characters

**Char**

* `char` di Rust menyimpan **satu karakter Unicode** penuh dan **berukuran 4 byte (32-bit)** — berbeda dengan C# (16-bit UTF-16).
* Tetap menggunakan tanda kutip tunggal `' '` untuk karakter tunggal.

```rust
let letter: char = 'A';        // Huruf tunggal
let digit: char = '1';         // Angka sebagai karakter
let symbol: char = '$';        // Simbol
let unicode_char: char = '😊'; // Karakter Unicode penuh
```

Rust `char` mewakili **Unicode scalar value (UTF-32)** sehingga seluruh karakter global, termasuk emoji, valid.

---

**String**

Rust memiliki **dua tipe string utama**:

* **`String`** → owned, mutable, berada di heap
* **`&str`** → string slice, immutable, biasanya literal statis `"hello"`

```rust
let name: &str = "codedhims";         // String literal (immutable)
let mut owned = String::from("hi");   // Owned string (heap)
```

`&str` mirip konsep **string literal** di C#/Java (immutable),
sedangkan `String` mirip **string builder** atau **buffer yang dapat bertambah**.

---

**String Interpolation (Formatting String)**

Rust tidak memiliki interpolasi seperti C# `$"{name}"` atau Zig multiline formatting.

Rust menggunakan **macro formatting** dengan placeholder `{}`.

```rust
let name = "John";
let age = 30;
println!("Hello, my name is {} and I am {} years old.", name, age);
```

Menghasilkan string:

```rust
let msg = format!("Hello, {} ({})", name, age);
```

`format!` setara secara konsep dengan:

* **C#** → `string.Format` / interpolasi
* **Java** → `String.format`
* **Zig** → `std.fmt.allocPrint`

---

**Escape String**

Rust mendukung escape sequence standar:

```
\n      newline
\r      carriage return
\t      tab
\\      backslash
\"      kutip ganda
\'      kutip tunggal
\u{1F600}   Unicode scalar (emoji)
```

Contoh:

```rust
let say_hello = "Hello, Rust!\n";
print!("{}", say_hello);
```

Rust menggunakan format Unicode **`\u{HEX}`**, bukan `\uXXXX` seperti C#/Java.

---

**Multiline String**

Rust menggunakan **raw string literal**:

```rust
let multiline = r#"
Ini adalah
multiline string
di Rust.
"#;
```

Jika terdapat karakter `"` di dalam string:

```rust
let text = r###"
Multiline string
dengan tanda kutip " di dalamnya
tanpa escape.
"###;
```

Raw string pada Rust serupa konsepnya dengan:

* **Zig** → multi-line string literal
* **C#** → verbatim string `@"..."`
* **Java** → text block `""" ... """`

### 1.1.3 Boolean

*Boolean di Rust bernilai **true** atau **false**, sama seperti C#, tetapi **tidak dapat digantikan dengan angka 1 atau 0**. Rust tidak mengizinkan konversi implisit antara integer dan boolean.*

```rust
let mut value: bool = true;
value = false;
println!("{}", value);
```

Rust **tidak mengizinkan**:

```rust
let x: bool = 1;   // ERROR
```

Boolean biasanya digunakan dalam kondisi:

```rust
let is_active = true;

if is_active {
    println!("Active!");
}
```

### 1.1.4 Pointer

Rust **tidak menggunakan pointer mentah sebagai default** seperti Zig atau C/C++. Sebagai gantinya, Rust menyediakan *safe references* yang dikelola compiler melalui sistem **ownership & borrowing**, sehingga aman dari segfault, use-after-free, dan double free.

**1. Borrowed References (Pointer Aman)**

Ini adalah “pointer versi aman” di Rust:

```rust
let value = 10;
let ref_value: &i32 = &value;       // immutable reference
let mut x = 20;
let ref_mut: &mut i32 = &mut x;     // mutable reference
```

* `&T` → pointer read-only
* `&mut T` → pointer yang bisa mengubah data
* Dicek compile-time, bukan runtime.

Ini tidak ada padanannya di Java/C# (karena mereka pakai GC & heap reference), tetapi mirip konsep *borrow* di Zig (`*T` + aturan manual).

---

**2. Raw Pointer (Unsafe)**

Rust tetap menyediakan pointer mentah seperti Zig/C, tetapi hanya bisa dipakai dalam `unsafe` block.

```rust
let mut num = 10;
let r1: *const i32 = #
let r2: *mut i32 = &mut num;
```

* `*const T` → pointer immutable
* `*mut T` → pointer mutable
* Rust **tidak menjamin keselamatan**, programmer bertanggung jawab penuh.

Ini setara dengan:

* Zig: `*T`
* C#: `int*` dalam *unsafe mode*
* Java: **tidak ada**, kecuali melalui JNI/native code

---

**3. Smart Pointer**

Rust juga memiliki *smart pointer* di `std`, mirip C# managed objects tetapi tanpa GC:

* `Box<T>` → menyimpan data di heap
* `Rc<T>` → reference counting (mirip shared_ptr)
* `Arc<T>` → thread-safe reference counting
* `RefCell<T>` / `Cell<T>` → mutability di runtime

Contoh:

```rust
let boxed = Box::new(100);
```

Ini mirip:

* C#: class selalu heap (mirip Box<T>)
* Java: semua object di heap
* Zig: manual alloc/free (lebih mirip Box tapi tanpa safety otomatis)

### 1.1.5 Empty Data Type

Rust **tidak memiliki `null`** seperti C#, Java, atau Zig. Sebagai gantinya, Rust menggunakan tipe aman bernama **`Option<T>`** untuk mewakili nilai yang *mungkin ada atau tidak ada*.
Konsep ini menggantikan `null` dan mencegah *null reference error* (seperti *NullPointerException*).

Rust menyediakan dua varian:

* `Some(value)` → ada nilai
* `None` → tidak ada nilai

Contoh:

```rust
let value: Option<i32> = Some(10);
let empty: Option<i32> = None;

println!("Result: {:?}", empty);
```

`None` inilah yang setara dengan “kosong” atau “null” pada bahasa lain, tetapi jauh lebih aman karena **wajib ditangani** secara eksplisit menggunakan `match`, `if let`, atau `.unwrap()`.

Karena Rust tidak punya `null`, pola error yang umum di C#/Java seperti `Object reference not set to an instance of an object` mustahil terjadi di Rust.

### 1.1.6 Aliasses

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
