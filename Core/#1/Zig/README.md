# Zig Programming Language

![alt text](image-1.png)

* **Dibuat oleh:** Andrew Kelley
* **Mulai:** 2015 (proyek awal), versi stabil pertama rilis 2020-an
* **Motivasi awal:** Membuat bahasa “better C” — lebih aman, lebih modern, tetap low-level
* **Evolusi:** Dari eksperimen menjadi bahasa sistem dengan fokus performa tinggi, kontrol memory, dan kompilasi langsung ke mesin target tanpa runtime besar.

## Installation

- Cara menginstal Zig di Windows, Linux, macOS
  - [https://ziglang.org/learn/getting-started/](https://ziglang.org/learn/getting-started/)
- Zig CLI

```
info: Usage: zig [command] [options]

Commands:

  build            Build project from build.zig
  fetch            Copy a package into global cache and print its hash
  init             Initialize a Zig package in the current directory

  build-exe        Create executable from source or object files
  build-lib        Create library from source or object files
  build-obj        Create object from source or object files
  test             Perform unit testing
  run              Create executable and run immediately

  ast-check        Look for simple compile errors in any set of files
  fmt              Reformat Zig source into canonical form
  reduce           Minimize a bug report
  translate-c      Convert C code to Zig code

  ar               Use Zig as a drop-in archiver
  cc               Use Zig as a drop-in C compiler
  c++              Use Zig as a drop-in C++ compiler
  dlltool          Use Zig as a drop-in dlltool.exe
  lib              Use Zig as a drop-in lib.exe
  ranlib           Use Zig as a drop-in ranlib
  objcopy          Use Zig as a drop-in objcopy
  rc               Use Zig as a drop-in rc.exe

  env              Print lib path, std path, cache directory, and version
  help             Print this help and exit
  std              View standard library documentation in a browser
  libc             Display native libc paths file or validate one
  targets          List available compilation targets
  version          Print version number and exit
  zen              Print Zen of Zig and exit

General Options:

-h, --help       Print command-specific usage
```

## Aturan dan Penamaan Sintaks

- Penamaan variabel, fungsi, konstanta
- Case sensitivity
- Style guideline Zig

## 0. Introduction

### 0.1 Menjalankan Kode Zig

- `zig run file.zig`
- Kompilasi ke executable `zig build-exe file.zig`

### 0.2 Workload

- Sistem programming
- Embedded & IoT
- Backend performa tinggi

### 0.3 Domain Specific Language

- Compile-time computation (`comptime`)
- Macro & metaprogramming

### 0.4 Karakteristik

- Low-level, manual memory management
- Tanpa hidden runtime
- Cross-compilation built-in
- Error handling berbasis `!ErrorType` dan `try/catch`

## 1. Basic

### 1.1 Data Types

#### 1.1.1 Numbers

- Integer: `i8, i16, i32, i64, u8, u16, u32, u64`
- Floating point: `f32, f64`

#### 1.1.2 Characters

- `u8` untuk ASCII
- `[]const u8` untuk string

#### 1.1.3 Boolean

- `bool`

#### 1.1.4 Pointer

- `*T` dan `?*T` (nullable pointer)

#### 1.1.5 Empty Data Type

- `void` dan `undefined`

#### 1.1.6 Aliases

- `type alias = OriginalType;`

#### 1.1.7 Type Checking

- Compile-time type checking
- `@typeOf` dan `@as` casting

### 1.2 Konversi, Type Check, & Casting

- Implicit vs explicit cast
- `@intCast`, `@floatCast`

### 1.3 Data items

- Variabel dan konstanta (`var`, `const`, `inline`)

### 1.4 Data Structures

#### 1.4.1 Array

- Static & dynamic array (`[]T`)

#### 1.4.2 Slice

- Referensi subset array

#### 1.4.3 Struct

- Definisi dan instansiasi
- Method & `pub` access

#### 1.4.4 Enum

- Compile-time enum

#### 1.4.5 Tuple-like Struct

- Multiple field struct sebagai tuple

#### 1.4.6 Lainnya

- Optionals `?T`
- Error unions `!T`

### 1.5 Operators

- Arithmetic, logical, bitwise
- Pointer operations

### 1.6 Control Flow

#### 1.6.1 Conditionals

- `if`, `else`

#### 1.6.2 Loops

- `while`, `for`, `break`, `continue`

### 1.7 Null-Safety

- `?T` type dan optional handling

### 1.8 Input-Output

- `std.io.getStdOut().print()`
- File I/O dengan `std.fs`

### 1.9 Using Keyword

- `usingnamespace std` atau alias namespace

## 2. Programming Paradigms

- Procedural programming
- Struct-based design
- Minimal OOP-like via structs & functions

## 3. Functional Programming

### 3.1 Functions as first-class citizen

### 3.2 Main Function

### 3.3 Recursion

### 3.4 Immutable Variables

### 3.5 Function Return

### 3.6 Function Parameters

### 3.7 Inline Functions & Short Expressions

### 3.8 Higher-order Functions

### 3.9 Comptime Function Evaluation

## 4. Struct

- Struct definition
- Methods via standalone functions
- Const vs var
- Memory layout control
- Comptime reflection

## 5. Object-Oriented-like Programming

- Struct-based encapsulation
- Namespaces via modules
- Method extensions via functions
- Polymorphism via interfaces simulated

## 6. Error & Exception Handling

- Error unions `!T`
- `try`, `catch`
- `defer` for cleanup
- Panic handling

## 7. Concurrency & Parallel Programming

- Async / Await style via `async` & `await`
- `std.Thread` dan mutex
- Race condition awareness

## 8. Generic

- Comptime generics
- `fn foo(comptime T: type) { ... }`

## 9. Standard Library (std)

- Containers, slices, arrays
- I/O, formatting, memory allocators

## 10. Package Manager

- Zig uses build.zig
- Dependencies via `addPackagePath`

## 11. Testing & Debugging

- `zig test file.zig`
- Assertions & panic handling
- Debug build vs release build

## 12. Regular Expressions

- Implementasi manual atau via std.regex

## 13. Preprocessor Directives

- Tidak ada preprocessor, gunakan `comptime` dan `@compileError`

## 14. Memory Management

- Manual memory management via `Allocator`
- Stack vs heap
- `defer allocator.free(obj)`
- Avoid garbage collector

## 15. Runtime Tuning

- Optimizations flags: `-O ReleaseFast`, `-O ReleaseSafe`
- Linker & cross compilation options

## 16. Monitoring & Diagnostics

- Profiling via external tools
- Logging via `std.debug.print`
- Memory leak detection with `Allocator` tracking
