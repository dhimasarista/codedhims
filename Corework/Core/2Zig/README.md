# Zig Programming Language

![alt text](image-1.png)

Zig adalah bahasa pemrograman sistem serbaguna dan toolchain yang dirancang untuk **keterbacaan**, **optimasi**, dan **keamanan**. Zig hadir sebagai alternatif modern untuk C, dengan tujuan memperbaiki beberapa kekurangan C sambil tetap mempertahankan kontrol *low-level* dan performa tinggi.

* **Dibuat oleh:** Andrew Kelley
* **Mulai:** 2015 (proyek awal)
* **Motivasi awal:** Menciptakan "C yang lebih baik" — lebih aman, lebih modern, dan tetap *low-level*.
* **Filosofi Utama:**
  * **Tidak ada alur kontrol tersembunyi:** Apa yang terlihat adalah apa yang terjadi. Tidak ada *method* yang dipanggil secara implisit.
  * **Tidak ada alokasi memori tersembunyi:** Setiap alokasi memori harus dilakukan secara eksplisit.
  * **Tanpa preprocessor, tanpa makro:** Fitur *comptime* menggantikan kebutuhan ini dengan cara yang lebih aman dan kuat.

## Installation

Untuk memulai dengan Zig, Anda perlu menginstal toolchain-nya terlebih dahulu.

- **Unduh dari Situs Resmi:**
  Kunjungi halaman unduhan resmi Zig: [https://ziglang.org/learn/getting-started/](https://ziglang.org/learn/getting-started/)
  Pilih versi yang sesuai untuk sistem operasi Anda (Windows, macOS, Linux). Zig didistribusikan sebagai arsip `.zip` atau `.tar.xz` yang hanya perlu diekstrak.
- **Setup di Windows:**

  1. Ekstrak file arsip ke direktori pilihan Anda (misalnya, `C:\zig`).
  2. Tambahkan path direktori tersebut ke **Environment Variables** sistem Anda agar perintah `zig` dapat diakses dari mana saja.
- **Verifikasi Instalasi:**
  Buka terminal atau command prompt dan jalankan perintah berikut untuk memastikan instalasi berhasil:

  ```bash
  zig version
  ```

### Zig CLI

Toolchain Zig menyertakan serangkaian perintah yang sangat kuat, tidak hanya untuk kompilasi tetapi juga sebagai pengganti toolchain C/C++.

```
info: Usage: zig [command] [options]

Commands:

  build            Membangun proyek dari file build.zig
  init-exe         Membuat proyek executable baru
  init-lib         Membuat proyek library baru

  build-exe        Membuat file executable dari source code
  build-lib        Membuat file library dari source code
  build-obj        Membuat file object dari source code
  test             Menjalankan unit test
  run              Membuat executable dan langsung menjalankannya

  fmt              Memformat kode Zig sesuai gaya kanonis
  translate-c      Mengonversi kode C ke kode Zig

  cc               Menggunakan Zig sebagai compiler C
  c++              Menggunakan Zig sebagai compiler C++

  env              Menampilkan path library, cache, dan versi
  help             Menampilkan bantuan
  version          Menampilkan nomor versi
  zen              Menampilkan "The Zen of Zig"
```

## Aturan dan Penamaan Sintaks

- **Penamaan Variabel, Fungsi, Konstanta:** Menggunakan `camelCase` untuk variabel dan fungsi. Menggunakan `PascalCase` untuk tipe data (struct, enum, union).
- **Case Sensitivity:** Zig adalah bahasa yang *case-sensitive*.
- **Ekstensi File:** File kode Zig menggunakan ekstensi `.zig`.
- **Komentar:**
  - `//` untuk komentar satu baris.
  - `///` untuk komentar dokumentasi yang dapat diakses melalui `std.meta`.

# 0. Introduction

### 0.1 Menjalankan Kode Zig

Ada dua cara utama untuk menjalankan kode Zig:

1. **Menjalankan Langsung (`zig run`):**
   Perintah ini akan mengompilasi dan menjalankan file Zig Anda dalam satu langkah. Sangat berguna untuk pengembangan dan pengujian cepat.

   ```bash
   zig run nama_file.zig
   ```
2. **Kompilasi ke Executable (`zig build-exe`):**
   Perintah ini hanya akan mengompilasi kode Anda menjadi sebuah file executable tanpa menjalankannya.

   ```bash
   # Kompilasi mode debug (default)
   zig build-exe nama_file.zig

   # Kompilasi mode rilis (teroptimasi)
   zig build-exe nama_file.zig -O ReleaseFast
   ```

   Setelah itu, Anda dapat menjalankan file hasilnya: `./nama_file` (di Linux/macOS) atau `nama_file.exe` (di Windows).

### 0.2 Workload

Zig sangat cocok untuk berbagai jenis pengembangan *low-level*:

- **Pemrograman Sistem:** Membuat sistem operasi, driver, atau utilitas sistem.
- **Aplikasi Desktop & CLI:** Membangun aplikasi native berperforma tinggi.
- **Embedded & IoT:** Zig tidak memiliki *runtime* tersembunyi, membuatnya ideal untuk perangkat dengan sumber daya terbatas.
- **Pengembangan Game:** Kontrol memori manual dan performa tinggi sangat penting dalam game.
- **Backend & Jaringan:** Membuat server web atau layanan jaringan yang efisien.
- **Interoperabilitas C:** Menggunakan atau menggantikan library C dengan mudah.

### 0.3 Domain Specific Language (DSL) dengan `comptime`

Zig tidak memiliki preprocessor atau makro seperti C. Sebagai gantinya, Zig menyediakan `comptime`, sebuah fitur untuk mengeksekusi kode pada saat kompilasi. Ini memungkinkan *metaprogramming* yang kuat dan aman.

Dengan `comptime`, Anda bisa:

- Membuat fungsi generik.
- Memvalidasi tipe data saat kompilasi.
- Menghasilkan kode berdasarkan kondisi kompilasi.

Contoh sederhana:

```zig
fn add(comptime T: type, a: T, b: T) T {
    return a + b;
}

pub fn main() void {
    const result_int = add(i32, 5, 3); // T menjadi i32
    const result_float = add(f64, 3.14, 1.59); // T menjadi f64
}
```

### 0.4 Karakteristik

- **Kontrol Memori Manual:** Anda mengontrol alokasi dan dealokasi memori sepenuhnya menggunakan `Allocator`.
- **Tanpa Runtime Tersembunyi:** Tidak ada *garbage collector* atau *runtime* besar yang berjalan di latar belakang.
- **Keamanan Tipe:** Sistem tipe yang kuat mencegah banyak bug umum.
- **Cross-Compilation:** Zig dapat mengompilasi kode untuk berbagai arsitektur dan sistem operasi secara *out-of-the-box*.
- **Penanganan Error Eksplisit:** Error ditangani menggunakan *error union* (`!T`) dan `try`/`catch`, membuat alur kontrol error menjadi jelas.
- **Interoperabilitas C:** Zig dapat mengimpor file header C (`@cImport`) dan menghasilkan library yang kompatibel dengan C.

# 1. Basic

### 1.1 Data Types

#### 1.1.1 Numbers

- **Integer:**
  - Signed: `i8`, `i16`, `i32`, `i64`, `i128`
  - Unsigned: `u8`, `u16`, `u32`, `u64`, `u128`
  - Ukuran platform: `isize`, `usize`
- **Floating Point:**
  - `f16`, `f32`, `f64`, `f128`
- **Arbitrary Bit-Width Integers:**
  - Anda bisa mendefinisikan integer dengan jumlah bit spesifik, misal `i7` atau `u2`.

```zig
const integer: i32 = -100;
const unsigned_integer: u32 = 100;
const large_number: i64 = 999_999_999; // _ untuk keterbacaan
const float_number: f64 = 3.14;
```

#### 1.1.2 Characters & Strings

- **Karakter:** Sebuah karakter tunggal direpresentasikan sebagai `u8` (untuk ASCII) atau `u21` (untuk Unicode code point).
  ```zig
  const my_char: u8 = 'A';
  ```
- **String:** String di Zig adalah *slice* dari byte konstan: `[]const u8`. String literal bersifat *null-terminated* untuk kompatibilitas dengan C.
  ```zig
  const greeting: []const u8 = "Hello, Zig!";
  ```

#### 1.1.3 Boolean

- Tipe `bool` dengan nilai `true` atau `false`.
  ```zig
  const is_active: bool = true;
  ```

#### 1.1.4 Pointer

- `*T`: Pointer ke satu item tipe `T`.
- `[*]T`: Pointer ke banyak item (jumlah tidak diketahui) tipe `T`.
- `[]T`: Slice, yang merupakan pointer ke data dan sebuah panjang (`len`).

```zig
var x: i32 = 10;
const ptr_x: *i32 = &x;
ptr_x.* = 20; // Dereferencing untuk mengubah nilai x
```

#### 1.1.5 Empty Data Type

- `void`: Menandakan ketiadaan nilai, sering digunakan sebagai tipe kembalian fungsi yang tidak mengembalikan apa-apa.
- `undefined`: Sebuah nilai yang dapat diberikan ke variabel apa pun, menandakan bahwa nilainya tidak ditentukan. Berguna saat inisialisasi akan dilakukan nanti.
  ```zig
  var value: i32 = undefined;
  value = 10; // OK
  ```

#### 1.1.6 Aliases

- Gunakan `const` untuk membuat alias tipe.
  ```zig
  const MyInt = i32;
  var number: MyInt = 42;
  ```

#### 1.1.7 Type Checking

- Zig adalah bahasa yang *statically typed*. Pengecekan tipe terjadi saat kompilasi.
- `@typeOf(value)`: Mendapatkan tipe dari sebuah nilai pada saat kompilasi.
- `@as(T, value)`: Melakukan *casting* `value` ke tipe `T`.

### 1.2 Konversi, Type Check, & Casting

Zig sangat ketat soal tipe. Tidak ada konversi tipe implisit.

- **Konversi Eksplisit:**
  ```zig
  const a: i32 = 10;
  const b: f64 = @floatFromInt(a);

  const c: f64 = 3.14;
  const d: i32 = @intFromFloat(c);
  ```
- **Casting dengan `@as`:**
  Digunakan untuk mengubah tipe pointer atau melakukan *widening/narrowing cast* yang aman.
  ```zig
  const value: i64 = 100;
  const smaller_value: i32 = @intCast(value);
  ```

### 1.3 Data items

- `const`: Mendeklarasikan konstanta yang nilainya harus diketahui saat kompilasi dan tidak dapat diubah.
- `var`: Mendeklarasikan variabel yang nilainya dapat diubah.

```zig
const compile_time_const: i32 = 10;
var mutable_variable: i32 = 20;
mutable_variable = 30;
```

### 1.4 Data Structures

#### 1.4.1 Array

Array di Zig memiliki ukuran yang tetap dan diketahui saat kompilasi.

```zig
var fixed_size_array: [3]i32 = .{ 10, 20, 30 };
const first_element = fixed_size_array[0];
```

#### 1.4.2 Slice

Slice adalah referensi ke sebagian atau seluruh array. Slice menyimpan pointer ke data dan panjangnya.

```zig
var array: [5]i32 = .{ 1, 2, 3, 4, 5 };
var a_slice: []i32 = array[1..4]; // Slice dari indeks 1 hingga 3
```

#### 1.4.3 Struct

Struct adalah tipe data komposit untuk mengelompokkan beberapa variabel.

```zig
const Point = struct {
    x: i32,
    y: i32,

    fn new(x: i32, y: i32) Point {
        return Point{ .x = x, .y = y };
    }

    fn print(self: Point) void {
        std.debug.print("Point(x: {d}, y: {d})\n", .{self.x, self.y});
    }
};

var p = Point.new(10, 20);
p.print();
```

#### 1.4.4 Enum

Enum digunakan untuk mendefinisikan tipe dengan sekumpulan nilai yang terbatas.

```zig
const Status = enum {
    pending,
    active,
    inactive,
};

var current_status: Status = .active;
```

#### 1.4.5 Union

Union memungkinkan beberapa tipe data berbagi lokasi memori yang sama.

```zig
const Payload = union(enum) {
    Int: i32,
    Float: f32,
    Bool: bool,
};

var p: Payload = .{ .Int = 42 };
```

#### 1.4.6 Lainnya

- **Optionals (`?T`):** Tipe yang bisa bernilai `T` atau `null`.
- **Error Unions (`!T`):** Tipe yang bisa bernilai `T` atau sebuah error.

### 1.5 Operators

- **Aritmatika:** `+`, `-`, `*`, `/`, `%` (dengan varian `+%`, `-%`, `*%` untuk *wrapping arithmetic*).
- **Logika:** `and`, `or`.
- **Bitwise:** `&`, `|`, `^`, `~`, `<<`, `>>`.
- **Perbandingan:** `==`, `!=`, `<`, `<=`, `>`, `>=`.
- **Pointer:** `&` (address-of), `.*` (dereference).

### 1.6 Control Flow

#### 1.6.1 Conditionals

- `if` dan `else`:
  ```zig
  if (condition) {
      // ...
  } else if (another_condition) {
      // ...
  } else {
      // ...
  }
  ```
- `switch`: Sangat kuat di Zig, dapat digunakan pada enum, integer, dan tipe lainnya.
  ```zig
  switch (status) {
      .pending => { /* ... */ },
      .active => { /* ... */ },
      else => { /* ... */ },
  }
  ```

#### 1.6.2 Loops

- `while`:
  ```zig
  while (condition) {
      // ...
  }
  ```
- `for`: Digunakan untuk iterasi pada slice atau array.
  ```zig
  const items = [_]i32{ 1, 2, 3 };
  for (items) |item, index| {
      std.debug.print("Item {d}: {d}\n", .{index, item});
  }
  ```
- `break`, `continue`: Berfungsi seperti di bahasa lain.

### 1.7 Null-Safety

Zig sangat aman terkait `null`. `null` hanya bisa digunakan dengan tipe *optional*.

```zig
var maybe_value: ?i32 = null;
maybe_value = 42;

if (maybe_value) |value| {
    // Unwrapping aman
    std.debug.print("Value is {d}\n", .{value});
} else {
    std.debug.print("Value is null\n", .{});
}
```

### 1.8 Input-Output

I/O di Zig ditangani melalui `std.io`.

```zig
const std = @import("std");

pub fn main() !void {
    const stdout = std.io.getStdOut().writer();
    try stdout.print("Hello, {s}!\n", .{"world"});
}
```

### 1.9 `usingnamespace`

Mirip dengan `using` di C# atau import di Java, dimana membawa semua deklarasi dari sebuah library atau namespace ke dalam scope saat ini.

```zig
const std = @import("std");

pub fn main() void {
    usingnamespace std.debug;
    // Sekarang bisa memanggil print secara langsung
    print("Hello!\n", .{});
}
```

# 2. Programming Paradigms

Zig utamanya adalah bahasa **prosedural**, tetapi mendukung beberapa konsep dari paradigma lain:

- **Procedural:** Fokus pada fungsi dan urutan eksekusi.
- **Object-Oriented (like):** Pola desain berbasis `struct` dengan fungsi sebagai *method* memberikan fungsionalitas mirip OOP, tetapi tanpa *inheritance* atau *virtual dispatch* otomatis.
- **Functional (like):** Dukungan untuk fungsi sebagai *first-class citizen* memungkinkan beberapa pola pemrograman fungsional.

# 3. Functional Programming

### 3.1 Functions are first-class citizen

Di Zig, fungsi adalah nilai yang bisa disimpan dalam variabel, diteruskan sebagai argumen, dan dikembalikan dari fungsi lain.

```zig
const Operation = fn(i32, i32) i32;

fn add(a: i32, b: i32) i32 { return a + b; }
fn sub(a: i32, b: i32) i32 { return a - b; }

pub fn main() void {
    var op: Operation = add;
    std.debug.print("{d}\n", .{op(10, 5)}); // 15

    op = sub;
    std.debug.print("{d}\n", .{op(10, 5)}); // 5
}
```

### 3.2 Main Function

Titik masuk utama dari sebuah program Zig adalah fungsi `main` yang dideklarasikan sebagai `pub`.

```zig
pub fn main() void {
    // Kode dimulai di sini
}
```

Atau jika bisa mengembalikan error:

```zig
pub fn main() !void {
    // Kode yang bisa gagal
}
```

### 3.3 Recursion

Zig mendukung rekursi, sama seperti bahasa prosedural lainnya.

```zig
fn factorial(n: u32) u32 {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

### 3.4 Immutable Variables

Konsep *immutability* di Zig dicapai melalui `const`. Variabel yang dideklarasikan dengan `const` tidak dapat diubah.

### 3.5 Function Return

- Fungsi mengembalikan nilai dengan `return`.
- Tipe kembalian didefinisikan setelah parameter.
- `void` digunakan jika fungsi tidak mengembalikan apa-apa.

### 3.6 Function Parameters

Parameter didefinisikan dengan format `nama: Tipe`.

```zig
fn greet(name: []const u8, age: u8) void {
    // ...
}
```

### 3.7 Inline Functions

Gunakan `inline` untuk menyarankan compiler agar menyisipkan kode fungsi langsung di lokasi pemanggilan, yang bisa meningkatkan performa.

```zig
inline fn add(a: i32, b: i32) i32 {
    return a + b;
}
```

### 3.8 Higher-order Functions

Karena fungsi adalah *first-class citizen*, Anda bisa membuat *higher-order function*.

```zig
fn apply(f: fn(i32) void, value: i32) void {
    f(value);
}

fn printInt(x: i32) void {
    std.debug.print("{d}\n", .{x});
}

pub fn main() void {
    apply(printInt, 42);
}
```

### 3.9 Comptime Function Evaluation

Fungsi yang dievaluasi saat kompilasi menggunakan `comptime`.

```zig
fn comptime_add(a: i32, b: i32) i32 {
    return a + b;
}

const result = comptime_add(2, 3); // Dihitung saat kompilasi
```

# 4. Struct

Struct adalah cara utama untuk membuat tipe data kustom di Zig.

- **Definisi:**
  ```zig
  const User = struct {
      id: u64,
      name: []const u8,
  };
  ```
- **Method:** Fungsi yang mengambil `self` sebagai parameter pertama.
  ```zig
  const Rectangle = struct {
      width: f32,
      height: f32,

      fn area(self: Rectangle) f32 {
          return self.width * self.height;
      }
  };
  ```
- **Memory Layout Control:** Anda bisa mengontrol bagaimana field struct diatur di memori (`packed`, `extern`).
- **Comptime Reflection:** Anda bisa memeriksa field dan method sebuah struct saat kompilasi menggunakan `@typeInfo`.

# 5. Object-Oriented-like Programming

Zig tidak memiliki `class`, `inheritance`, atau `polymorphism` dinamis bawaan. Namun, pola OOP dapat disimulasikan:

- **Encapsulation:** `struct` dengan fungsi publik (`pub`) dan privat.
- **Composition over Inheritance:** Gunakan komposisi (menyematkan satu struct di dalam struct lain) sebagai ganti pewarisan.
- **Polymorphism:**
  - **Statis (Compile-time):** Menggunakan `comptime` dan `anytype`.
  - **Dinamis (Runtime):** Secara manual membuat *vtable* (virtual method table), yaitu sebuah struct yang berisi pointer ke fungsi.

Contoh VTable untuk polymorphism dinamis:

```zig
const Shape = struct {
    vtable: *const VTable,
    data: *anyopaque,

    const VTable = struct {
        area: fn(*anyopaque) f32,
        name: fn(*anyopaque) []const u8,
    };

    fn area(self: Shape) f32 {
        return self.vtable.area(self.data);
    }
};
```

# 6. Error & Exception Handling

Penanganan error di Zig eksplisit dan aman.

- **Error Set:** Kumpulan error yang bisa dikembalikan oleh sebuah fungsi.
  ```zig
  const FileError = error{
      AccessDenied,
      OutOfMemory,
  };
  ```
- **Error Union:** Sebuah fungsi yang bisa gagal mengembalikan `ErrorSet!T`.
  ```zig
  fn readFile() ![]u8 {
      // ... bisa melempar error
  }
  ```
- **`try` dan `catch`:**
  - `try`: Mempropagasi error ke atas (jika fungsi saat ini juga bisa melempar error).
  - `catch`: Menangani error.

  ```zig
  const data = try readFile(); // Propagasi error

  const content = readFile() catch |err| {
      // Tangani error di sini
      return "default content";
  };
  ```
- **`defer` dan `errdefer`:**
  - `defer`: Menjalankan sebuah ekspresi di akhir scope, baik berhasil maupun gagal. Berguna untuk membersihkan resource.
  - `errdefer`: Hanya berjalan jika scope diakhiri karena error.

# 7. Concurrency & Parallel Programming

Zig menyediakan fitur konkurensi modern berbasis `async/await`.

- **`async`:** Membuat sebuah pemanggilan fungsi menjadi asinkron, mengembalikan sebuah *frame*.
- **`await`:** Menunggu hasil dari sebuah *frame* asinkron.
- **`suspend` dan `resume`:** Untuk kontrol manual atas eksekusi asinkron.
- **`std.Thread`:** Untuk membuat dan mengelola thread OS secara langsung.

```zig
async fn fetchUrl(url: []const u8) ![]u8 {
    // ...
}

pub fn main() !void {
    const frame = async fetchUrl("https://ziglang.org");
    const result = await frame;
}
```

# 8. Generic

Generik di Zig diimplementasikan menggunakan `comptime` dan `anytype`.

- **`anytype`:** Memungkinkan sebuah fungsi menerima parameter dari tipe apa pun.
  ```zig
  fn printAny(value: anytype) {
      std.debug.print("{any}\n", .{value});
  }
  ```
- **Fungsi Generik dengan `comptime`:**
  ```zig
  fn List(comptime T: type) type {
      return struct {
          items: []T,
          allocator: std.mem.Allocator,
          // ... method lainnya
      };
  }

  const IntList = List(i32);
  var list = IntList.init(allocator);
  ```

# 9. Standard Library (std)

Library standar Zig sangat kaya dan terus berkembang. Beberapa modul penting:

- `std.mem`: Alokator memori, utilitas slice.
- `std.fs`: Operasi file system.
- `std.io`: Operasi I/O (stdin, stdout, file).
- `std.net`: Jaringan (TCP, UDP).
- `std.json`: Parsing dan serialisasi JSON.
- `std.crypto`: Fungsi kriptografi.
- `std.math`: Fungsi matematika.
- `std.debug`: Utilitas untuk debugging, seperti `print`.

# 10. Build System

Zig memiliki sistem build terintegrasi yang ditulis dalam... Zig!

- **`build.zig`:** File ini mendefinisikan bagaimana proyek Anda dibangun.
- **Fleksibel:** Anda bisa mendefinisikan langkah-langkah build kustom, mengelola dependensi, dan bahkan menjalankan kode selama proses build.
- **Cross-Compilation:** Mudah dikonfigurasi untuk mengompilasi ke target yang berbeda.

# 11. Testing & Debugging

- **Testing:** Zig memiliki framework testing bawaan.
  - Tulis tes dalam blok `test "deskripsi" { ... }`.
  - Jalankan dengan `zig test nama_file.zig`.

  ```zig
  test "simple addition" {
      try std.testing.expect(add(2, 3) == 5);
  }
  ```
- **Debugging:**
  - Gunakan `std.debug.print` untuk logging.
  - Kompilasi dalam mode `Debug` untuk menyertakan simbol debug.
  - Gunakan debugger seperti GDB atau LLDB.

# 12. Memory Management: A Deep Dive for High-Level Programmers

Bahasa high-level seperti C#, Java, atau Swift memori nya dikelola otomatis saat runtime, sedangkan Zig harus melakukan manual sama seperti C/C++. Tidak ada Garbage Collector (GC) dan tidak ada Automatic Reference Counting (ARC). Setiap alokasi dan dealokasi harus dilakukan secara eksplisit oleh programmer.
Berbeda dengan Rust yang juga compile time, Zig tidak memiliki konsep ini semuanya harus di handle oleh Programmer.

- Zig → Trust the programmer
- Rust → Don’t trust the programmer

## 12.1 Konsep Dasar

Zig memberikan kontrol total terhadap alokasi memori. Tidak ada mekanisme otomatis untuk mengelola objek yang tidak terpakai. Hal ini memberikan prediktabilitas performa dan kontrol penuh terhadap lifetime data.

* **allocator** : objek atau mekanisme yang bertanggung jawab mengatur alokasi dan dealokasi memori (misal `std.heap.page_allocator`, `std.heap.c_allocator`).
* **alloc** : fungsi dari allocator untuk *meminta* blok memori baru dengan ukuran tertentu.
* **free** : fungsi dari allocator untuk *mengembalikan* atau *membebaskan* blok memori yang sebelumnya dialokasikan.
* **create** : seperti `alloc`, tapi langsung memanggil konstruktor untuk membuat instance dari tipe tertentu.
* **destroy** : pasangan dari `create`, membebaskan memori sekaligus memanggil destructor.
* **resize** : menyesuaikan ukuran blok memori yang sudah dialokasikan (memperbesar atau memperkecil).
* **ArenaAllocator** : tipe allocator yang mengalokasikan memori dalam satu blok besar dan membebaskannya sekaligus dengan `deinit()`.
* **FixedBufferAllocator** : tipe allocator yang menggunakan buffer tetap, cocok untuk alokasi kecil atau temporer.
* **defer** : mekanisme bahasa Zig untuk memastikan `free()` atau `deinit()` tetap dijalankan di akhir scope, bahkan jika fungsi keluar lebih awal.

## 12.2 Stack vs Heap

### 12.2.1 Stack

- Lokasi memori yang cepat dan otomatis.
- Digunakan untuk variabel lokal dan data dengan ukuran tetap.
- Tidak dapat di-free secara manual.
- Contoh:

```zig
var x: i32 = 10;
```

### 12.2.2 Heap

* Lokasi memori fleksibel untuk data dinamis.
* Menggunakan allocator.
* Harus di-free secara manual.
* Contoh:

```zig
const allocator = std.heap.page_allocator;
const buf = try allocator.alloc(u8, 128);
// ...
allocator.free(buf);
```

### Example Case
Struct adalah tipe data yang disimpan di Stack, tidak seperti Class dimana kita pass by reference. Karena Zig tidak punya OOP murni, kita bisa mengalokasikan Struct ke Heap jika Struct harus menampung data yang besar atau lifetime panjang (misalnya digunakan lintas fungsi atau thread).

```zig
const std = @import("std");

const LargeData = struct {
    data: []u8,
};

pub fn main() !void {
    const allocator = std.heap.page_allocator;

    // Alokasi struct di heap
    const obj = try allocator.create(LargeData);
    defer allocator.destroy(obj);

    // Alokasi field di heap juga
    obj.data = try allocator.alloc(u8, 1024);
    defer allocator.free(obj.data);

    std.debug.print("Allocated {} bytes\n", .{obj.data.len});
}
```

## 12.3 Allocator

Allocator adalah objek yang mengelola alokasi, resizing, dan pembebasan memori. Semua alokasi heap melewati allocator.

### 12.3.1 Contoh penggunaan

```zig
const std = @import("std");

pub fn main() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    defer _ = gpa.deinit();

    var list = std.ArrayList(u8).init(allocator);
    defer list.deinit();

    try list.append(42);
}
```

### 12.3.2 Jenis allocator yang umum

* `std.heap.page_allocator`
* `std.heap.c_allocator`
* `std.heap.GeneralPurposeAllocator`
* `std.heap.ArenaAllocator`
* `std.testing.allocator`


## 12.4 Pola Allocator-Passing

Fungsi yang bekerja dengan data dinamis sebaiknya menerima allocator sebagai parameter.

```zig
fn makeBuffer(allocator: std.mem.Allocator) ![]u8 {
    return try allocator.alloc(u8, 1024);
}
```


## 12.5 Siklus Hidup Memori: alloc → free → defer

### 12.5.1 Alokasi

```zig
const buf = try allocator.alloc(u8, 256);
```

### 12.5.2 Pembebasan

```zig
allocator.free(buf);
```

### 12.5.3 Penggunaan defer

`defer` memastikan cleanup tetap terjadi ketika fungsi keluar.

```zig
const std = @import("std");

pub fn main() !void {
    const allocator = std.heap.page_allocator;

    // alokasi buffer 256 byte di heap
    const buf = try allocator.alloc(u8, 256);
    defer allocator.free(buf); // pastikan dibebaskan saat keluar fungsi

    // gunakan buf
    // tulis data ke dalam buffer
    for (buf, 0..) |*byte, i| {
        byte.* = @intCast(u8, i); // isi dengan 0,1,2,3,...
    }

    // baca kembali beberapa isi buffer
    std.debug.print("Byte pertama: {}\n", .{buf[0]});
    std.debug.print("Byte terakhir: {}\n", .{buf[buf.len - 1]});

    // tampilkan jumlah byte yang dialokasikan
    std.debug.print("Buffer size: {}\n", .{buf.len});
}
```

### 12.5.4 Penggunaan errdefer

Hanya dijalankan saat terjadi error.

```zig
var obj = try allocator.create(MyStruct);
errdefer allocator.destroy(obj);

try doSomething(obj);
```


## 12.6 Apa Saja yang Bisa di-Free

### 12.6.1 Di-free

* Alokasi melalui allocator:

```zig
const p = try allocator.create(MyStruct);
allocator.destroy(p);
```

* Slice/array dinamis:

```zig
const s = try allocator.alloc(u8, 100);
allocator.free(s);
```

### 12.6.2 Tidak bisa di-free

* Variabel stack

```zig
var x: i32 = 1;
```

* Array fixed-size

```zig
var arr: [100]u8 = undefined;
```

* String literal

```zig
const msg = "hello";
```


## 12.7 Arena Allocator

Arena mengalokasikan blok besar dan membebaskan semuanya sekaligus pada akhir lifetime.

```zig
var arena = std.heap.ArenaAllocator.init(std.heap.page_allocator);
const alloc = arena.allocator();
defer arena.deinit();

const a = try alloc.alloc(u8, 50);
const b = try alloc.alloc(u8, 100);
```


## 12.8 Alokasi String dan Slice

### 12.8.1 Manual

```zig
const hello = "hello";
const world = " world";

const buf = try allocator.alloc(u8, hello.len + world.len);
defer allocator.free(buf);

@memcpy(buf[0..hello.len], hello);
@memcpy(buf[hello.len..], world);
```

### 12.8.2 allocPrint

```zig
const msg = try std.fmt.allocPrint(allocator, "{s}{s}", .{ hello, world });
defer allocator.free(msg);
```


## 12.9 Debugging Memory

### 12.9.1 GeneralPurposeAllocator

```zig
var gpa = std.heap.GeneralPurposeAllocator(.{}){};
const allocator = gpa.allocator();
defer {
    const leaked = gpa.deinit();
    std.debug.assert(!leaked);
}
```

### 12.9.2 Valgrind (Linux)

Dapat digunakan untuk mendeteksi error seperti:

* invalid read/write
* use-after-free
* double free


## 12.10 Konsep Tambahan

### 12.10.1 Pointer dan Slice

```zig
var x: i32 = 10;
const ptr: *i32 = &x;

const buf = try allocator.alloc(u8, 10);
const slice: []u8 = buf;
```

### 12.10.2 Sentinel-Terminated Slice

```zig
const s: [:0]const u8 = "hello";
```

### 12.10.3 Alignment

```zig
var x: u32 align(8) = 123;
```

### 12.10.4 Comptime Memory

Memori yang dialokasikan saat compile-time tidak perlu di-free.


## 12.11 Best Practice

* Pasangkan setiap `alloc` dengan `defer free`.
* Gunakan `ArenaAllocator` untuk data berumur pendek.
* Gunakan `GeneralPurposeAllocator` pada tahap pengembangan.
* Definisikan *ownership* secara jelas.
* Jangan mengembalikan pointer ke data yang telah di-free.
* Hindari double free.
* Hindari global allocator untuk alur hidup kompleks.
* Gunakan `errdefer` untuk rollback saat error.


## 12.12 Perbandingan dengan Bahasa Lain


| Bahasa  | Mekanisme             | Catatan                                         |
| --------- | ----------------------- | ------------------------------------------------- |
| Zig     | Manual + defer        | Prediktif, tanpa GC pause                       |
| C#/Java | Garbage Collector     | Otomatis tapi tidak deterministik               |
| Swift   | ARC                   | Rentan retain cycle                             |
| Rust    | Borrowing + Ownership | Sangat aman, compile-time enforcements          |
| C++     | RAII                  | Modern C++ aman, tetapi raw pointer rawan error |


## 12.13 Mengapa C++ Bermasalah Sebelum RAII

```cpp
void test() {
    MyObject* obj = new MyObject();
    if (err) return;  // leak
    delete obj;
}
```

RAII memperbaiki masalah ini dengan destruktor yang otomatis dipanggil saat scope berakhir. Di Zig, hal yang sama dicapai melalui `defer`.


## 12.14 Penting di Pelajair

1. Mengimplementasikan fungsi untuk menyalin string dengan alokasi manual.
2. Membuat dynamic array menggunakan allocator.
3. Menggunakan `GeneralPurposeAllocator` untuk mendeteksi memory leak.
4. Membuat custom allocator sederhana.

Hal yang bisa dipelajar untuk meningkatkan skill manajemen manual :
- Alokasi buffer file I/O  
- Manajemen memori untuk JSON parser  
- Arena allocator untuk HTTP request  


# 13. Runtime Tuning & Optimizations

- **Build Modes:** Zig memiliki beberapa mode optimasi:
  - `-O Debug`: Tanpa optimasi, cepat dikompilasi, baik untuk debugging.
  - `-O ReleaseSafe`: Optimasi dengan pemeriksaan keamanan runtime (default untuk `zig build -O ReleaseSafe`).
  - `-O ReleaseFast`: Optimasi agresif untuk performa maksimal.
  - `-O ReleaseSmall`: Optimasi untuk ukuran binary terkecil.
- **Linker & Cross-Compilation:** Anda bisa dengan mudah menargetkan arsitektur dan OS yang berbeda langsung dari CLI.
  ```bash
  # Kompilasi untuk Windows dari Linux
  zig build-exe main.zig -target x86_64-windows
  ```
