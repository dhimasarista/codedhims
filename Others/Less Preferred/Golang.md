# Go Programming Language

Golang, atau disebut juga Go, adalah bahasa pemrograman yang dikembangkan oleh Google pada tahun 2007 dan diumumkan secara resmi pada tahun 2009. Bahasa ini dirancang untuk mengatasi beberapa masalah yang dihadapi oleh pengembang perangkat lunak dalam bahasa-bahasa pemrograman lain, terutama terkait dengan kinerja, keamanan, dan produktivitas. Sejarah Golang dimulai pada tahun 2007 ketika Google memulai pengembangan bahasa pemrograman baru untuk mengatasi beberapa kelemahan yang ada dalam bahasa-bahasa pemrograman yang digunakan secara luas pada saat itu. Tiga tokoh utama dalam pengembangannya adalah Robert Griesemer, Rob Pike, dan Ken Thompson.

2007

* Google memulai proyek pembuatan bahasa pemrograman baru dengan tujuan mengatasi beberapa masalah yang dihadapi oleh pengembang perangkat lunak saat itu.
* Robert Griesemer, Rob Pike, dan Ken Thompson terlibat dalam proyek tersebut. Rob Pike adalah salah satu tokoh yang terlibat dalam pengembangan Unix dan Go adalah upaya berkelanjutan untuk menggantikan bahasa C dalam pengembangan perangkat lunak di Google.

2009

* Pada bulan Maret 2009, Google secara resmi mengumumkan Golang melalui posting blog resmi.
* Versi pertama dari bahasa ini, yang disebut sebagai “Go 1,” dirilis pada Maret 2012. Keberhasilan rilis ini menunjukkan bahwa Golang adalah bahasa yang stabil dan dapat diandalkan.

## 0. Introduction

### 0.1. Aturan & Penamaan

> ⚠️ Catatan: Hati-hati dengan case-sensitive terutama camelCase dan PascalCase.

Penamaan File

* Do :
  * file_name.go
* Avoid :
  * FileName.go

Penamaan Struct/Function/Variable

> Setiap penamaan struct/function/variable dengan PascalCase, menandakan itu adalah objek global yang bisa diakses dari kode lain. Sedangkan camelCase, menandkan object tersebut private yang hanya bisa diakses satu kode file.

PascalCase

```go
type Car struct {}

function CallCar(){}

var NewCarName string
```

camelCase

```go
type car struct {}

function callCar(){}

var newCarName string
```

**Go Project Layout**

**Struktur direktori** sangat penting dalam Golang karena pengorganisasiannya memengaruhi kemampuan tim untuk bekerja dengan proyek. Banyak proyek Go mengadopsi struktur direktori yang dikenal dari template seperti  **Go Project Layout** .

```
nama_project/
├── cmd/                # Sub-komando aplikasi
│   └── myapp/          # Folder untuk main aplikasi
│       └── main.go     # Entry point
├── internal/           # Kode private, tidak bisa diimport dari luar
│   └── pkgname/        # Modul internal spesifik
├── pkg/                # Kode yang dapat digunakan ulang di luar project (umum)
│   └── utilities.go    # Contoh utilities (misalnya helper func)
├── api/                # Definisi API seperti protokol gRPC, GraphQL, dll.
├── configs/            # Konfigurasi aplikasi, file YAML atau JSON
├── docs/               # Dokumentasi untuk pengembang
├── migrations/         # File migrasi database
├── scripts/            # Skrip untuk CI/CD atau automation
├── test/               # File pengujian terpisah
│   └── integration/    # Tes integrasi
│   └── e2e/            # End-to-end testing
├── go.mod              # File Go Modules
├── go.sum              # Checksum dependency
└── README.md           # Penjelasan proyek

```

Tools untuk men-generate membuat project mengikuti standar Go Project Layout:

1. Cobra CLI
2. Go Boilerplate
3. Cookiecutter Templates

### 0.2 Standard Libraries

1. I/O (Input/Output)

* `fmt` – Operasi input/output.
* `io` dan `io/ioutil` – Baca/tulis data dari file atau stream.

2. Strings

* `strings` – Manipulasi string (split, join, replace, dll.).
* `strconv` – Konversi antara string dan tipe data lainnya.

3. Networking

* `net/http` – Membuat server dan client HTTP.
* `net` – Operasi TCP/IP, UDP, DNS, dll.

4. Concurrency

* `sync` – Tools untuk sinkronisasi (WaitGroup, Mutex).
* `time` – Operasi waktu dan durasi.

5. File System

* `os` – Operasi file dan direktori.
* `path/filepath` – Manipulasi path file.

6. Data Structures

* `container/list` – Linked list.
* `sort` – Pengurutan slice atau collection.

7. Testing

* `testing` – Framework untuk unit testing.

8. JSON

* `encoding/json` – Encoding dan decoding JSON.

9. Cryptography

* `crypto/sha256` – Hashing dengan algoritma SHA-256.

10. Regular Expressions

* `regexp` – Pencocokan pola menggunakan regex.

### 0.3 Libraries & Frameworks

1. Web Frameworks

* Gin
* Echo
* Fiber

2. ORM (Object-Relational Mapping)

* GORM
* Ent
* sqlx

3. API Development

* go-chi
* go-swagger

4. Concurrency and Messaging

* gorilla/websocket
* nats
* go-worker

5. Authentication & Authorization

* Casbin
* JWT (github.com/dgrijalva/jwt-go)

6. Testing

* Testify
* Ginkgo

7. Task Scheduling

* gocron
* cron

8. Logging

* logrus
* zap

9. Data Serialization

* protobuf (Protocol Buffers)
* msgpack

10. Configuration Management

* viper
* envconfig

11. Validation

* validator
* ozzo-validation

12. GraphQL

* gqlgen
* graphql-go

13. Metrics and Monitoring

* prometheus/client_golang
* go-metrics

14. Miscellaneous

* Cobra (CLI framework)
* go-hcaptcha (Captcha handling)
* go-mail (Email sending)

## 1. Basic

### 1.1 Data Types

```go
// Boolean
var isActive bool = true

// Integer: Bilangan Bulat
var intDefault int = 100              // Default integer type (size depends on architecture)
var int8Value int8 = -128             // 8-bit signed integer
var int16Value int16 = -32768         // 16-bit signed integer
var int32Value int32 = -2147483648    // 32-bit signed integer
var int64Value int64 = -9223372036854775808 // 64-bit signed integer
var uint8Value uint8 = 255            // 8-bit unsigned integer
var uint16Value uint16 = 65535        // 16-bit unsigned integer
var uint32Value uint32 = 4294967295   // 32-bit unsigned integer
var uint64Value uint64 = 18446744073709551615 // 64-bit unsigned integer

// Floating: Bilangan desimal
var float32Value float32 = 3.14159    // 32-bit floating point
var float64Value float64 = 3.141592653589793 // 64-bit floating point

// Complex numbers
var complex64Value complex64 = 1 + 2i    // Complex number with 32-bit real and imaginary parts
var complex128Value complex128 = 1 + 2i // Complex number with 64-bit real and imaginary parts

// String: Kumpulan Karakter
var stringValue string = "Hello, Go!"

// Rune (alias dari int32, representasi karakter Unicode)
var runeValue rune = 'G' // Unicode character literal

// Byte (alias dari uint8, representasi single byte)
var byteValue byte = 'H' // Single byte character

// Unsigned integer (ukuran bisa tergantung arsitektur)
var uintValue uint = 500

// Alias types (often used for compatibility)
var uintptrValue uintptr = 0x12345 // Integer to store pointer values

```

### 1.2 Konversi, Type Check, & Casting Tipe Data

```go
// Konversi (Conversion)
var intValue int = 42
var floatValue float64 = float64(intValue) // Konversi dari int ke float64
var stringValue string = fmt.Sprintf("%d", intValue) // Konversi int ke string
fmt.Println("Konversi:")
fmt.Println("intValue:", intValue)
fmt.Println("floatValue (converted):", floatValue)
fmt.Println("stringValue (converted):", stringValue)

// Type Checking
fmt.Println("Type of intValue:", reflect.TypeOf(intValue))
fmt.Println("Type of floatValue:", reflect.TypeOf(floatValue))
fmt.Println("Type of stringValue:", reflect.TypeOf(stringValue))

// Casting
var originalFloat float64 = 3.14159
var castedInt int = int(originalFloat) // Casting dari float64 ke int (pecahan dibuang)

fmt.Println("Original float64 value:", originalFloat)
fmt.Println("Casted int value (from float64):", castedInt)
```

### 1.3 Pointer

Pointer adalah variabel yang menyimpan alamat memori dari variabel lain. Dengan menggunakan pointer, kita dapat mengakses dan mengubah nilai variabel secara langsung melalui alamat memori.

Konsep Dasar Pointer

* Pointer adalah variabel yang menyimpan alamat memori dari variabel lain.
* Tipe data pointer menunjukkan jenis data yang akan disimpan di alamat memori tersebut.

Deklarasi Pointer

Untuk mendeklarasikan pointer, Anda menggunakan tanda `*` untuk menunjukkan bahwa variabel tersebut adalah pointer ke tipe data tertentu.

* Sintaks:
  ```go
  var ptr *tipeData
  ```

Mendapatkan Alamat Memori dengan `&`

Untuk mendapatkan alamat memori dari sebuah variabel, Anda dapat menggunakan operator `&`. Ini disebut sebagai  address-of operator .

* Sintaks:
  ```go
  ptr := &variabel
  ```

Mengakses Nilai melalui Pointer

Untuk mengakses nilai yang disimpan dalam alamat memori, Anda menggunakan operator `*` di depan pointer. Ini disebut sebagai  dereferencing .

* Sintaks:
  ```go
  nilai := *ptr
  ```

Contoh Penggunaan Pointer

```go
package main

import "fmt"

func main() {
	// Deklarasi variabel biasa
	var x int = 58
	var y int

	// Deklarasi pointer yang menyimpan alamat variabel x
	var ptr *int

	// Menyimpan alamat dari variabel x ke dalam pointer ptr
	ptr = &x

	// Menampilkan alamat memori dari variabel x
	fmt.Println("Alamat memori dari x:", ptr)

	// Mengakses nilai dari alamat memori yang disimpan dalam ptr (dereferencing)
	fmt.Println("Nilai yang disimpan di alamat ptr:", *ptr)

	// Mengubah nilai variabel x melalui pointer
	*ptr = 100

	// Menampilkan nilai variabel x setelah diubah melalui pointer
	fmt.Println("Nilai x setelah perubahan:", x)

	// Menggunakan pointer untuk menyalin nilai ke variabel lain
	y = *ptr
	fmt.Println("Nilai y yang disalin dari pointer ptr:", y)
}
```

Penjelasan Kode

1. Deklarasi Pointer

   Variabel `ptr` dideklarasikan sebagai pointer ke tipe `int`, yang berarti `ptr` dapat menyimpan alamat memori dari variabel bertipe `int`.
2. Mendapatkan Alamat Memori

   Menggunakan `&x` untuk mendapatkan alamat memori dari variabel `x` dan menyimpannya di dalam pointer `ptr`.
3. Dereferencing Pointer

   Menggunakan `*ptr` untuk mengakses nilai yang disimpan di alamat memori yang ditunjukkan oleh pointer `ptr`.

   Setelah dereferencing, kita bisa mengubah nilai variabel yang ditunjuk oleh pointer.
4. Mengubah Nilai Melalui Pointer

   Dengan menggunakan `*ptr = 100`, kita mengubah nilai variabel `x` karena `ptr` menunjuk ke alamat memori dari `x`.

Pointer dengan Fungsi

Pointer juga sering digunakan untuk memodifikasi variabel yang diteruskan ke dalam fungsi.

```go
package main

import "fmt"

// Fungsi yang mengubah nilai variabel menggunakan pointer
func changeValue(num *int) {
	*num = 50
}

func main() {
	var a int = 10
	fmt.Println("Nilai a sebelum fungsi:", a)

	// Mengubah nilai a melalui pointer
	changeValue(&a)

	fmt.Println("Nilai a setelah fungsi:", a)
}
```

Penjelasan Kode:

* Fungsi `changeValue` menerima pointer `*int` sebagai argumen, yang memungkinkan fungsi untuk mengubah nilai variabel yang diteruskan.
* `&a` mengirimkan alamat memori dari `a` ke fungsi, yang kemudian bisa diakses dan diubah melalui pointer.

Pointer ke Pointer

Go mendukung pointer ke pointer, di mana kita dapat membuat pointer yang menunjuk ke pointer lain.

```go
package main

import "fmt"

func main() {
	var a int = 30
	var ptr1 *int = &a
	var ptr2 **int = &ptr1

	// Mengakses nilai melalui pointer ke pointer
	fmt.Println("Nilai a:", a)
	fmt.Println("Nilai melalui ptr1:", *ptr1)
	fmt.Println("Nilai melalui ptr2:", **ptr2)
}
```

Penjelasan Kode:

* `ptr1` adalah pointer yang menyimpan alamat memori dari variabel `a`.
* `ptr2` adalah pointer yang menyimpan alamat memori dari `ptr1`.
* Dereferencing dua kali (`**ptr2`) untuk mendapatkan nilai dari `a`.

Kesimpulan

* Pointer memberikan cara untuk bekerja dengan alamat memori langsung.
* Go menggunakan `*` untuk dereferencing dan `&` untuk mendapatkan alamat memori.
* Pointer sering digunakan untuk memodifikasi variabel yang diteruskan ke fungsi dan untuk efisiensi memori.

### 1.4 Data Items

Go menyediakan beberapa cara untuk mendeklarasikan dan menginisialisasi variabel, konstanta, dan item data lainnya.

Go mendukung deklarasi variabel atau konstanta secara bersamaan.

Contoh:

```go
package main

import "fmt"

func main() {
    // Deklarasi variabel
    var (
        x int = 10
        y string = "Golang"
    )

    // Deklarasi konstanta
    const (
        alpha = "A"
        beta  = "B"
    )

    fmt.Println("x:", x, "y:", y)
    fmt.Println("alpha:", alpha, "beta:", beta)
}
```

#### Perbedaan var, const, dan :=

| Fitur                     | `var`                                          | `const` | `:=`                  |
| ------------------------- | ------------------------------------------------ | --------- | ----------------------- |
| Deklarasi                 | Ya                                               | Ya        | Ya (hanya dalam fungsi) |
| Inisialisasi              | Opsional                                         | Wajib     | Wajib                   |
| Nilai dapat diubah        | Ya                                               | Tidak     | Ya                      |
| Penggunaan di luar fungsi | Ya (`var`bisa digunakan untuk variabel global) | Ya        | Tidak                   |

```go
// var
var age int = 25
var name string = "John"

// const
const pi float64 = 3.14159

// :=
address := "123 Golang Street"
```

### 1.4 Data Structures

#### 1. Array

Array adalah kumpulan elemen dengan tipe data yang sama dan ukuran tetap.

```go
// Mendeklarasikan array dengan tipe data int dan ukuran 5
var arr [5]int

// Inisialisasi array
arr[0] = 1
arr[1] = 2
arr[2] = 3
arr[3] = 4
arr[4] = 5

// Array lain yang langsung diinisialisasi
var arr2 = [3]string{"Go", "Golang", "Programming"}
```

#### 2. Slice

Slice adalah kumpulan elemen dengan tipe data yang sama, tetapi ukuran yang bisa berubah (dinamis).

```go
// Membuat slice dengan kapasitas awal 3
var slice []int = []int{1, 2, 3}

// Menambahkan elemen ke slice
slice = append(slice, 4, 5)

// Slice dengan kapasitas lebih besar
slice2 := []string{"Go", "is", "awesome"}
```

#### 3. Map

Map adalah struktur data yang menyimpan pasangan kunci (key) dan nilai (value).

```go
// Deklarasi map dengan tipe kunci string dan tipe nilai int
var m map[string]int = make(map[string]int)

// Menambahkan elemen ke dalam map
m["age"] = 30
m["year"] = 2025

// Membaca nilai dari map
age := m["age"]

// Menghapus elemen dari map
delete(m, "year")
```

#### 4. Struct

Struct adalah tipe data yang memungkinkan Anda mengelompokkan elemen dengan tipe data yang berbeda dalam satu unit.

```go
// Mendeklarasikan struct untuk menyimpan informasi buku
type Book struct {
	Title  string
	Author string
	Year   int
}

// Membuat instance struct
var book1 Book
book1.Title = "Go Programming"
book1.Author = "John Doe"
book1.Year = 2021

// Atau langsung inisialisasi
book2 := Book{
	Title:  "Advanced Go",
	Author: "Jane Smith",
	Year:   2023,
}
```

> Struct bisa dijadikan object-oriented di go, yang dimana golang tidak memiliki konsep OOP murni menggunakan prototyping seperti class. Dibahas di bab struct.

#### 5. Linked List (Menggunakan Struct)

```go
type Node struct {
	Data int
	Next *Node
}

var head *Node

// Menambahkan node baru
newNode := &Node{Data: 10}
head = newNode

secondNode := &Node{Data: 20}
newNode.Next = secondNode

thirdNode := &Node{Data: 30}
secondNode.Next = thirdNode
```

#### 6. Stack (Menggunakan Slice)

```go
// Stack menggunakan slice
var stack []int

// Menambahkan elemen ke stack (Push)
stack = append(stack, 1)
stack = append(stack, 2)
stack = append(stack, 3)

// Mengambil elemen terakhir dari stack (Pop)
top := stack[len(stack)-1]
stack = stack[:len(stack)-1]
```

#### 7. Queue (Menggunakan Slice)

Contoh implementasi queue menggunakan slice.

```go
// Queue menggunakan slice
var queue []int

// Menambahkan elemen ke antrian (enqueue)
queue = append(queue, 1)
queue = append(queue, 2)
queue = append(queue, 3)

// Mengambil elemen pertama dari antrian (dequeue)
front := queue[0]
queue = queue[1:]
```

#### 8. Set (Menggunakan Map)

Set dapat diimplementasikan menggunakan map, karena map hanya dapat memiliki satu entri per kunci.

```go
// Set menggunakan map
set := make(map[int]bool)

// Menambahkan elemen ke set
set[1] = true
set[2] = true
set[3] = true

// Mengecek apakah elemen ada dalam set
exists := set[2]  // true jika 2 ada di set
```

Penjelasan:

* Array memiliki ukuran tetap dan tipe data yang sama.
* Slice mirip dengan array, tetapi dapat berubah ukurannya.
* Map menyimpan pasangan kunci-nilai, sangat berguna untuk pencarian cepat.
* Struct digunakan untuk mengelompokkan data yang terkait dalam satu tipe yang lebih kompleks.
* Linked List adalah struktur data yang terdiri dari elemen yang saling terhubung.
* Stack adalah struktur data dengan prinsip LIFO (Last In, First Out).
* Queue adalah struktur data dengan prinsip FIFO (First In, First Out).
* Set adalah kumpulan elemen unik, yang diimplementasikan dengan map.

### 1.5 Operators

Dalam bahasa pemrograman Go, terdapat berbagai operator yang digunakan untuk melakukan operasi pada data. Berikut adalah beberapa operator yang tersedia dalam Go:

1. Operator Aritmatika:

   - `+` : Penjumlahan
   - `-` : Pengurangan
   - `*` : Perkalian
   - `/` : Pembagian
   - `%` : Modulo (Sisa bagi)
   - `++` : Increment (Peningkatan nilai sebesar 1)
   - `-` : Decrement (Pengurangan nilai sebesar 1)
2. Operator Perbandingan:

   - `==` : Sama dengan
   - `!=` : Tidak sama dengan
   - `>` : Lebih besar dari
   - `<` : Lebih kecil dari
   - `>=` : Lebih besar dari atau sama dengan
   - `<=` : Lebih kecil dari atau sama dengan
3. Operator Logika:

   - `&&` : Operator AND logika
   - `||` : Operator OR logika
   - `!` : Operator NOT logika
4. Operator Assignment:

   - `=` : Memberikan nilai
   - `+=` : Menambahkan dan mengassign nilai
   - `=` : Mengurangi dan mengassign nilai
   - `=` : Mengalikan dan mengassign nilai
   - `/=` : Membagi dan mengassign nilai
   - `%=` : Mengambil sisa bagi dan mengassign nilai
5. Operator Bitwise:

   - `&` : Operator AND bitwise
   - `|` : Operator OR bitwise
   - `^` : Operator XOR bitwise
   - `<<` : Operator Left Shift (geser ke kiri)
   - `>>` : Operator Right Shift (geser ke kanan)
   - `&^` : Operator Clear (membersihkan bit)
6. Operator Pointer:

   - `*` : Operator dereference pointer (untuk mendapatkan nilai yang ditunjuk oleh pointer)
   - `&` : Operator address-of (untuk mendapatkan alamat memori dari suatu nilai)

### 1.6 Control Flow

Conditionals

Dalam bahasa pemrograman Go, kondisi (conditions) digunakan untuk membuat keputusan logika dalam program. Kondisi memungkinkan kita untuk menjalankan blok kode tertentu hanya jika kondisi yang ditentukan terpenuhi (true), atau menjalankan blok kode alternatif jika kondisi tidak terpenuhi (false). Berikut adalah beberapa cara yang dapat digunakan untuk mengekspresikan kondisi dalam Go:

1. Pernyataan If:
   Pernyataan `if` digunakan untuk mengeksekusi blok kode jika kondisi yang diberikan benar (true). Contoh:

   ```go
   if kondisi {
       // Blok kode yang dijalankan jika kondisi benar
   }
   ```

   Contoh penggunaan `if`:

   ```go
   if x > 5 {
       fmt.Println("Nilai x lebih besar dari 5")
   }
   ```
2. Pernyataan If-Else:
   Pernyataan `if-else` digunakan untuk mengeksekusi blok kode jika kondisi yang diberikan benar (true), dan menjalankan blok kode alternatif jika kondisi tidak terpenuhi (false). Contoh:

   ```go
   if kondisi {
       // Blok kode yang dijalankan jika kondisi benar
   } else {
       // Blok kode yang dijalankan jika kondisi tidak terpenuhi
   }
   ```

   Contoh penggunaan `if-else`:

   ```go
   if x > 5 {
       fmt.Println("Nilai x lebih besar dari 5")
   } else {
       fmt.Println("Nilai x kurang dari atau sama dengan 5")
   }
   ```
3. Pernyataan If-Else If-Else:
   Pernyataan `if-else if-else` digunakan untuk mengevaluasi beberapa kondisi berurutan dan mengeksekusi blok kode sesuai dengan kondisi yang terpenuhi. Contoh:

   ```go
   if kondisi1 {
       // Blok kode yang dijalankan jika kondisi1 benar
   } else if kondisi2 {
       // Blok kode yang dijalankan jika kondisi2 benar
   } else {
       // Blok kode yang dijalankan jika tidak ada kondisi yang terpenuhi
   }
   ```

   Contoh penggunaan `if-else if-else`:

   ```go
   if x > 5 {
       fmt.Println("Nilai x lebih besar dari 5")
   } else if x == 5 {
       fmt.Println("Nilai x sama dengan 5")
   } else {
       fmt.Println("Nilai x kurang dari 5")
   }
   ```
4. Pernyataan Switch:
   Pernyataan `switch` digunakan untuk mengevaluasi ekspresi atau nilai dan menjalankan blok kode yang sesuai dengan nilai yang cocok. Contoh:

   ```go
   switch ekspresi {
   case nilai1:
       // Blok kode yang dijalankan jika nilai cocok dengan nilai1
   case nilai2:
       // Blok kode yang dijalankan jika nilai cocok dengan nilai2
   default:
       // Blok kode yang dijalankan jika tidak ada nilai yang cocok
   }
   ```

   Contoh penggunaan `switch`:

   ```go
   switch angka {
   case 1:
       fmt.Println("Angka adalah 1")
   case 2:
       fmt.Println("Angka adalah 2")
   default:
       fmt.Println("Angka bukan 1 atau 2")
   }
   ```

Kondisi-kondisi di atas memungkinkan pengambilan keputusan berdasarkan nilai atau ekspresi yang dievaluasi. Dengan menggunakan kondisi, Anda dapat mengontrol alur eksekusi program sesuai dengan logika yang diinginkan.

Loopings

Dalam bahasa pemrograman Go, terdapat beberapa jenis perulangan (looping) yang dapat digunakan untuk mengulangi serangkaian instruksi. Berikut adalah beberapa perulangan yang tersedia dalam Go:

1. Perulangan `for`:
   Perulangan `for` digunakan untuk mengulangi blok kode sejumlah kali yang telah ditentukan atau berdasarkan kondisi tertentu. Contoh:

   ```go
   for inisialisasi; kondisi; perubahan {
       // Blok kode yang diulang
   }
   ```

   Contoh penggunaan perulangan `for`:

   ```
   for i := 0; i < 5; i++ {
       fmt.Println(i)
   }
   ```
2. Perulangan `for` dengan `range`:
   Perulangan `for` dengan `range` digunakan untuk mengulangi elemen-elemen dari tipe data koleksi seperti array, slice, map, atau string. Contoh:

   ```go
   for indeks, nilai := range koleksi {
       // Blok kode yang diulang
   }
   ```

   Contoh penggunaan perulangan `for` dengan `range`:

   ```go
   angka := []int{1, 2, 3, 4, 5}
   for indeks, nilai := range angka {
       fmt.Println("Indeks:", indeks, "Nilai:", nilai)
   }
   ```
3. Perulangan `while`:
   Meskipun Go tidak memiliki perulangan `while` secara eksplisit, perulangan `for` dapat digunakan untuk mensimulasikan perulangan `while`. Contoh:

   ```go
   for kondisi {
       // Blok kode yang diulang
   }
   ```

   Contoh penggunaan perulangan `while`:

   ```go
   n := 0
   for n < 5 {
       fmt.Println(n)
       n++
   }
   ```
4. Perulangan `do-while`:
   Go juga tidak memiliki perulangan `do-while`. Namun, kita dapat menggunakan perulangan `for` dengan `break` untuk mensimulasikan perulangan `do-while`. Contoh:

   ```go
   for {
       // Blok kode yang diulang
       if kondisi {
           break
       }
   }
   ```

   Contoh penggunaan perulangan `do-while`:

   ```go
   n := 0
   for {
       fmt.Println(n)
       n++
       if n >= 5 {
           break
       }
   }
   ```

Dengan menggunakan perulangan, Anda dapat mengulang instruksi-instruksi tertentu berulang kali sesuai dengan kebutuhan dalam program. Setiap jenis perulangan memiliki kegunaan yang berbeda tergantung pada situasi dan kebutuhan program yang sedang Anda tulis.

### 1.8 Input-Output

Di Go, kita dapat melakukan operasi input dan output menggunakan berbagai paket dari pustaka standar, seperti `fmt` untuk pencetakan ke konsol dan membaca input dari pengguna. Berikut adalah beberapa contoh dasar tentang cara melakukan input dan output di Go:

#### 1. Output menggunakan `fmt.Println`

`fmt.Println` digunakan untuk mencetak ke konsol dengan menambahkan baris baru setelah teks.

```go
fmt.Println("Hello, World!")
```

Output:

```
Hello, World!
```

#### 2. Output menggunakan `fmt.Printf`

`fmt.Printf` memungkinkan Anda untuk mencetak teks dengan format yang lebih spesifik, seperti angka, string, dan lainnya.

```go
name := "Go"
version := 1.18
fmt.Printf("Welcome to %s programming language, version %v\n", name, version)
```

Output:

```
Welcome to Go programming language, version 1.18
```

#### 3. Input menggunakan `fmt.Scan`

`fmt.Scan` digunakan untuk membaca input dari pengguna dan menyimpannya dalam variabel.

```go
var name string
fmt.Print("Enter your name: ")
fmt.Scan(&name)
fmt.Println("Hello, " + name)
```

Output:

```
Enter your name: John
Hello, John
```

#### 4. Input menggunakan `fmt.Scanln`

`fmt.Scanln` adalah cara lain untuk membaca input, dan dia akan membaca input hingga baris baru.

```go
var name string
fmt.Print("Enter your name: ")
fmt.Scanln(&name)
fmt.Println("Hello,", name)
```

Output:

```
Enter your name: Alice
Hello, Alice
```

#### 5. Input menggunakan `fmt.Scanf`

`fmt.Scanf` memungkinkan kita untuk membaca input dengan format yang lebih terstruktur, mirip dengan `printf`.

```go
var age int
fmt.Print("Enter your age: ")
fmt.Scanf("%d", &age)
fmt.Printf("Your age is: %d\n", age)
```

Output:

```
Enter your age: 25
Your age is: 25
```

#### 6. Membaca Input dari File

Go juga memungkinkan kita untuk membaca dan menulis ke file menggunakan paket `os` dan `bufio`.

```go
import (
    "fmt"
    "os"
)

func main() {
    file, err := os.Open("data.txt")
    if err != nil {
        fmt.Println("Error opening file:", err)
        return
    }
    defer file.Close()

    var content string
    _, err = fmt.Fscan(file, &content)
    if err != nil {
        fmt.Println("Error reading file:", err)
        return
    }
    fmt.Println("File content:", content)
}
```

#### 7. Menulis ke File

Untuk menulis ke file, Anda bisa menggunakan `os.Create` untuk membuat file baru dan `fmt.Fprintln` untuk menulis ke dalamnya.

```go
import (
    "fmt"
    "os"
)

func main() {
    file, err := os.Create("output.txt")
    if err != nil {
        fmt.Println("Error creating file:", err)
        return
    }
    defer file.Close()

    fmt.Fprintln(file, "Hello, Go!")
    fmt.Println("Data has been written to output.txt")
}
```

#### 8. Golang Embed

Fitur `embed` di Go diperkenalkan pada versi 1.16 untuk memungkinkan file statis (seperti gambar, HTML, CSS, JS, atau file konfigurasi) disematkan (embed) langsung ke dalam kode sumber Go. Ini mempermudah distribusi aplikasi tanpa harus mengelola file eksternal.

* Tujuan: Menyematkan file statis ke dalam file binary aplikasi.
* Penggunaan: File yang disematkan dapat diakses secara langsung dalam program sebagai data mentah.

Contoh penggunaan `embed`:

```go
package main

import (
    "embed"
    "fmt"
    "log"
)

// Menyematkan file .txt ke dalam kode sumber
//go:embed message.txt
var message string

func main() {
    fmt.Println(message)
}
```

Pada contoh di atas, file `message.txt` akan disematkan ke dalam aplikasi Go, dan kita dapat mengaksesnya sebagai string menggunakan variabel `message`.

Jika file `message.txt` berisi:

```
Hello, Go Embed!
```

Maka output yang akan dicetak adalah:

```
Hello, Go Embed!
```

Kelebihan `embed`:

* Semua file statis dibundel dalam binary aplikasi.
* Aplikasi bisa lebih portabel karena tidak perlu dependensi file eksternal.
* Memudahkan distribusi aplikasi yang tidak bergantung pada sistem file.

Kekurangan `embed`:

* Ukuran binary aplikasi bisa menjadi besar karena file statis disematkan.
* Tidak fleksibel untuk file yang sering berubah, karena perubahan file memerlukan rebuild aplikasi.

Perbedaan Utama:

| Fitur         | `embed`                                               | `io`                                                                       |
| ------------- | ------------------------------------------------------- | ---------------------------------------------------------------------------- |
| Tujuan        | Menyematkan file statis ke dalam binary aplikasi        | Bekerja dengan file atau stream data secara dinamis saat runtime             |
| File          | File disematkan dalam binary aplikasi                   | File diakses dari disk atau sumber lainnya saat aplikasi dijalankan          |
| Ukuran Binary | Dapat meningkatkan ukuran binary karena file disematkan | Ukuran binary tidak terpengaruh karena file eksternal tetap terpisah         |
| Fleksibilitas | Kurang fleksibel jika file sering berubah               | Lebih fleksibel karena dapat bekerja dengan file yang berubah selama runtime |

Kapan Menggunakan `embed`?

* Jika aplikasi Anda membutuhkan file statis yang tidak berubah (misalnya template HTML, gambar, atau file konfigurasi) dan Anda ingin mendistribusikan semuanya dalam satu binary.
* Jika Anda membutuhkan distribusi yang lebih mudah dan portabel.

Kapan Menggunakan `io`?

* Jika aplikasi Anda memerlukan akses ke file yang dapat berubah selama runtime atau bergantung pada file eksternal yang tidak bisa disematkan.
* Jika Anda bekerja dengan data dalam jumlah besar atau file yang tidak cocok untuk disematkan ke dalam binary.

### 1.9 `defer`, `panic`, dan `recover`

Di Go,  `defer` ,  `panic` , dan `recover` adalah tiga fitur yang bekerja bersama untuk menangani situasi yang tidak terduga dalam program, seperti kesalahan runtime (errors) atau pengecualian (exceptions). Meskipun Go tidak memiliki mekanisme pengecualian seperti bahasa lain, fitur-fitur ini memberikan cara untuk menangani dan merespons kesalahan.

### 1. `defer`

`defer` digunakan untuk menunda eksekusi suatu fungsi hingga fungsi yang memanggilnya selesai. Biasanya digunakan untuk memastikan bahwa sesuatu dilakukan pada akhir fungsi, seperti menutup file atau melepaskan resource, terlepas dari apakah terjadi kesalahan atau tidak.

* Penggunaan: Menunda eksekusi fungsi sampai fungsi yang memanggilnya selesai dieksekusi.
* Kapan digunakan: Untuk menutup resource seperti file, koneksi database, atau mutex setelah operasi selesai.

#### Contoh `defer`:

```go
package main

import "fmt"

func sayHello() {
    defer fmt.Println("Goodbye!")  // Fungsi ini dipanggil setelah sayHello selesai
    fmt.Println("Hello, Go!")
}

func main() {
    sayHello()
}
```

Output:

```
Hello, Go!
Goodbye!
```

Pada contoh di atas, meskipun `defer fmt.Println("Goodbye!")` berada di akhir fungsi `sayHello`, `Goodbye!` baru dicetak setelah seluruh eksekusi fungsi `sayHello` selesai.

### 2. `panic`

`panic` digunakan untuk memicu kondisi darurat (panic) dalam program, yang menyebabkan program berhenti menjalankan sisa kode dan melompat ke mekanisme penanganan kesalahan.

* Penggunaan: Menghentikan eksekusi normal dan menyebabkan panik.
* Kapan digunakan: Biasanya digunakan ketika terjadi kesalahan yang tidak bisa dipulihkan, seperti kesalahan yang fatal atau tidak terduga dalam program (misalnya pembagian dengan nol).

#### Contoh `panic`:

```go
package main

import "fmt"

func division(a, b int) int {
    if b == 0 {
        panic("division by zero")  // Memicu panic jika pembagi adalah 0
    }
    return a / b
}

func main() {
    fmt.Println(division(10, 2))  // Output: 5
    fmt.Println(division(10, 0))  // Menyebabkan panic
}
```

Output:

```
5
panic: division by zero

goroutine 1 [running]:
main.division(0x6, 0x0)
	.../main.go:7 +0x60
main.main()
	.../main.go:14 +0x80
exit status 2
```

Pada contoh di atas, ketika pembagi adalah 0, `panic` dipanggil dan program akan berhenti eksekusi setelah pesan panic dicetak.

### 3. `recover`

`recover` digunakan untuk menangani panic, sehingga program tidak berhenti. Biasanya digunakan di dalam fungsi yang ditunda dengan `defer` untuk menangani panic dan menghindari program berhenti secara tak terduga.

* Penggunaan: Menangkap panic untuk mencegah program berhenti secara mendadak.
* Kapan digunakan: Untuk menangani panic di dalam `defer` dan mencegah program berhenti.

#### Contoh `recover`:

```go
package main

import "fmt"

func safeDivision(a, b int) int {
    defer func() {
        if r := recover(); r != nil {
            fmt.Println("Recovered from panic:", r)
        }
    }()
  
    if b == 0 {
        panic("division by zero")
    }
    return a / b
}

func main() {
    fmt.Println(safeDivision(10, 2))  // Output: 5
    fmt.Println(safeDivision(10, 0))  // Program tidak berhenti, tetapi memulihkan dari panic
}
```

Output:

```
5
Recovered from panic: division by zero
```

Pada contoh di atas, meskipun terjadi panic karena pembagian dengan nol, fungsi `recover` menangkap panic dan mencegah program berhenti. Program melanjutkan eksekusi setelah pemulihan.

Ringkasan dan Kombinasi Penggunaan:

* `defer` memastikan eksekusi fungsi dilakukan pada akhir fungsi, bahkan jika terjadi kesalahan.
* `panic` digunakan untuk memicu keadaan darurat dan menghentikan eksekusi program.
* `recover` digunakan untuk menangani panic dan memulihkan eksekusi program.

Proses alur dengan `defer`, `panic`, dan `recover`:

1. Eksekusi dimulai.
2. Jika terjadi panic, kontrol program akan melompat ke fungsi yang terdefer.
3. Jika `recover` dipanggil dalam fungsi yang terdefer, maka panic akan ditangani dan program tidak akan berhenti.
4. Eksekusi program dilanjutkan.

Contoh Penggunaan Semua Tiga:

```go
package main

import "fmt"

func safeFunction() {
    defer fmt.Println("Defered function executed.")
    defer func() {
        if r := recover(); r != nil {
            fmt.Println("Recovered from panic:", r)
        }
    }()

    fmt.Println("Executing function...")
    panic("Something went wrong!")
}

func main() {
    safeFunction()
    fmt.Println("Program continues after panic.")
}
```

Output:

```
Executing function...
Recovered from panic: Something went wrong!
Defered function executed.
Program continues after panic.
```

Pada contoh di atas, meskipun terjadi panic di dalam `safeFunction()`, eksekusi program tetap dilanjutkan karena `recover` menangkap panic dan `defer` memastikan fungsi eksekusi tetap dilakukan.

## 2. Programming Paradigms

Go (Golang) mendukung berbagai paradigma pemrograman, meskipun lebih fokus pada pemrograman  imperatif ,  prosedural , dan  concurrent . Go tidak secara eksplisit mendukung paradigma pemrograman fungsional seperti di beberapa bahasa lain, tetapi menawarkan fitur-fitur tertentu yang memungkinkan gaya pemrograman fungsional.

Paradigma Pemrograman yang Didukung Go:

1. Imperatif :
   Go adalah bahasa pemrograman yang sangat mendukung gaya pemrograman imperatif, yang berarti program dijalankan dengan memberikan urutan perintah untuk eksekusi. Dalam Go, Anda menulis instruksi yang akan dieksekusi satu per satu, dan kontrol alur seperti `if`, `for`, dan `switch` memungkinkan Anda mengontrol eksekusi berdasarkan kondisi tertentu.
2. Prosedural :
   Go juga mendukung paradigma pemrograman prosedural, di mana kode dipisahkan menjadi fungsi-fungsi yang dapat dipanggil. Anda bisa mendeklarasikan fungsi dan prosedur, yang dapat menerima input dan mengembalikan output, untuk mengorganisir dan menyusun kode.
3. Concurrent Programming :
   Salah satu fitur utama Go adalah kemampuannya untuk menangani concurrency secara native dengan menggunakan goroutine dan channel. Goroutine memungkinkan Anda menjalankan fungsi secara paralel (concurrent) dengan cara yang sangat ringan dan efisien.
4. Object-Oriented Programming (OOP) :
   Go tidak secara eksplisit mendukung OOP seperti bahasa lain (misalnya, C++ atau Java), tetapi Anda bisa menggunakan struct dan method untuk mendefinisikan objek dan perilakunya. Go mendukung konsep-konsep penting dalam OOP seperti encapsulation (pembungkusan data dalam struct), polymorphism (dengan interface), dan inheritance tidak langsung (melalui composition).
5. Functional Programming :
   Go tidak secara penuh mendukung paradigma pemrograman fungsional, tetapi Anda bisa menggunakan beberapa fitur fungsional, seperti higher-order functions (fungsi yang menerima fungsi lain sebagai argumen atau mengembalikan fungsi) dan closures (fungsi yang menangkap lingkungan variabel lokal).
6. Declarative Programming :
   Walaupun Go lebih berfokus pada pemrograman imperatif dan prosedural, Anda bisa menerapkan gaya deklaratif dalam beberapa situasi, misalnya, saat menggunakan goroutine dan channel untuk menyusun tugas-tugas yang harus dikerjakan secara paralel. Beberapa penggunaan Go juga mengarah pada pendekatan deklaratif, terutama di luar kode aplikasi murni, seperti dalam konfigurasi sistem.
   Contoh deklaratif lebih cenderung terlihat dalam penggunaan goroutine dan channel untuk tugas-tugas tertentu secara paralel, yang membantu mendeklarasikan apa yang ingin dicapai tanpa mendetailkan bagaimana mencapainya.

Kesimpulan:

Go mendukung berbagai paradigma, meskipun lebih menonjolkan  imperatif ,  prosedural , dan  concurrent programming . Pemrograman fungsional dan OOP dapat diimplementasikan di Go meskipun tidak sekomprehensif dalam bahasa lain. Secara keseluruhan, Go adalah bahasa yang fleksibel dengan fitur-fitur yang kuat untuk pengembangan perangkat lunak modern, terutama dalam aplikasi yang membutuhkan  concurrency .

## 3. Functional Programming

Go (atau Golang) adalah bahasa pemrograman yang lebih dikenal dengan paradigma imperatif dan konkurensi melalui goroutine. Namun, meskipun tidak sepenuhnya mendukung pemrograman fungsional murni seperti bahasa fungsional lainnya (misalnya Haskell), Go tetap memungkinkan penerapan beberapa konsep pemrograman fungsional dalam aplikasinya.

Pemrograman fungsional di Go dapat diterapkan dengan menggunakan fungsi sebagai  *first-class citizens* ,  higher-order functions ,  closure , dan konsep-konsep lainnya yang sering digunakan dalam paradigma fungsional. Berikut adalah pembahasan mengenai bagaimana Go mengadopsi prinsip-prinsip pemrograman fungsional.

Konsep Pemrograman Fungsional di Go

#### 1. First-Class Functions

Di Go, fungsi adalah objek pertama (first-class citizens), yang berarti kita bisa menyimpan fungsi dalam variabel, meneruskannya sebagai argumen ke fungsi lain, atau mengembalikannya dari fungsi lain.

 Contoh :

```go
package main

import "fmt"

func add(x, y int) int {
    return x + y
}

func main() {
    // Fungsi pertama
    var f = add

    // Menggunakan fungsi yang disimpan dalam variabel
    fmt.Println(f(3, 4))  // Output: 7
}
```

Dalam contoh di atas, fungsi `add` disimpan dalam variabel `f` dan dipanggil seperti halnya fungsi biasa.

#### 2. Higher-Order Functions

Fungsi yang menerima fungsi lain sebagai parameter atau mengembalikan fungsi lain adalah contoh  higher-order functions .

 Contoh :

```go
package main

import "fmt"

// Higher-order function
func applyFunction(x int, f func(int) int) int {
    return f(x)
}

func square(x int) int {
    return x * x
}

func main() {
    result := applyFunction(5, square)
    fmt.Println(result)  // Output: 25
}
```

Di sini, `applyFunction` adalah fungsi tingkat tinggi yang menerima fungsi lain (`square`) sebagai parameter, dan kemudian menerapkannya ke nilai yang diberikan.

#### 3. Closures

Go mendukung  closure , yang berarti fungsi dapat "mengingat" variabel yang ada dalam lingkup di mana fungsi tersebut didefinisikan, meskipun fungsi tersebut dipanggil di luar lingkup tersebut.

 Contoh :

```go
package main

import "fmt"

func main() {
    // Fungsi closure
    increment := func() func() int {
        counter := 0
        return func() int {
            counter++
            return counter
        }
    }

    // Membuat closure
    inc := increment()

    // Memanggil closure
    fmt.Println(inc())  // Output: 1
    fmt.Println(inc())  // Output: 2
}
```

Dalam contoh di atas, fungsi `increment` mengembalikan fungsi baru yang mengakses dan memodifikasi variabel `counter` yang ada dalam lingkup fungsi `increment`, meskipun `counter` tidak ada lagi setelah fungsi `increment` selesai dipanggil.

#### 4. Immutability (Data yang Tidak Dapat Diubah)

Meskipun Go lebih cenderung menggunakan objek yang dapat diubah (mutable), kita bisa menerapkan prinsip immutability dengan membuat struktur data yang tidak dapat diubah setelah dibuat.

 Contoh :

```go
package main

import "fmt"

type Point struct {
    X, Y int
}

// Fungsi ini mengembalikan nilai Point baru dengan X dan Y yang diubah
func (p Point) Move(dx, dy int) Point {
    return Point{p.X + dx, p.Y + dy}
}

func main() {
    p1 := Point{2, 3}
    p2 := p1.Move(1, 1)

    fmt.Println(p1)  // Output: {2 3}
    fmt.Println(p2)  // Output: {3 4}
}
```

Pada contoh di atas, meskipun objek `p1` dan `p2` merupakan objek yang berbeda, mereka tidak mengubah status internal satu sama lain. Fungsi `Move` mengembalikan salinan baru dari objek yang telah dimodifikasi, menjaga prinsip immutability.

#### 5. Anonymous Functions

Go memungkinkan penggunaan anonymous functions atau fungsi tanpa nama, yang sering digunakan dalam pemrograman fungsional untuk operasi tertentu yang hanya digunakan sekali.

 Contoh :

```go
package main

import "fmt"

func main() {
    // Anonymous function yang langsung dipanggil
    result := func(x, y int) int {
        return x + y
    }(3, 4)

    fmt.Println(result)  // Output: 7
}
```

Di sini, kita mendefinisikan dan langsung memanggil fungsi anonim untuk menghitung hasil penjumlahan antara `3` dan `4`.

#### 6. Map, Filter, Reduce (Menggunakan Fungsi Higher-Order)

Meskipun Go tidak menyediakan built-in fungsi `map`, `filter`, dan `reduce` seperti dalam bahasa pemrograman fungsional murni, kita bisa mengimplementasikan pola-pola tersebut menggunakan higher-order functions.

 Contoh: Implementasi `map` dan `filter` :

```go
package main

import "fmt"

// Fungsi untuk memetakan fungsi ke setiap elemen slice
func mapFunc(slice []int, f func(int) int) []int {
    var result []int
    for _, v := range slice {
        result = append(result, f(v))
    }
    return result
}

// Fungsi untuk memfilter elemen berdasarkan kondisi
func filter(slice []int, f func(int) bool) []int {
    var result []int
    for _, v := range slice {
        if f(v) {
            result = append(result, v)
        }
    }
    return result
}

func main() {
    numbers := []int{1, 2, 3, 4, 5}

    // Map: Menerapkan fungsi yang mengalikan setiap elemen dengan 2
    doubled := mapFunc(numbers, func(x int) int {
        return x * 2
    })
    fmt.Println(doubled)  // Output: [2 4 6 8 10]

    // Filter: Memilih elemen yang lebih besar dari 2
    filtered := filter(numbers, func(x int) bool {
        return x > 2
    })
    fmt.Println(filtered)  // Output: [3 4 5]
}
```

Di sini, kita membuat fungsi `mapFunc` dan `filter` yang dapat digunakan untuk memanipulasi slice dengan cara yang lebih deklaratif.

Keterbatasan Pemrograman Fungsional di Go

Meskipun Go memungkinkan penggunaan gaya pemrograman fungsional, ada beberapa keterbatasan:

1. Mutabilitas : Go lebih sering menggunakan objek yang dapat diubah (mutable), sehingga tidak sepenuhnya sesuai dengan prinsip immutability dari pemrograman fungsional murni.
2. Side Effects : Go memberikan kebebasan untuk memiliki efek samping, seperti pengubahan variabel global atau I/O, yang bertentangan dengan prinsip fungsional murni.
3. Tidak Ada Generics (Sampai Go 1.18) : Generics di Go baru diperkenalkan di Go 1.18, yang dapat membantu membuat kode lebih fungsional dengan tipe yang lebih fleksibel. Sebelumnya, Go kurang mendukung pemrograman fungsional berbasis tipe.
4. Kurangnya Konsep-konsep Fungsional Lainnya : Go tidak menyediakan banyak konsep yang biasa ditemukan dalam bahasa fungsional seperti monads dan  functors .

## 4. Object-Oriented Programming

Go tidak sepenuhnya mendukung Object-Oriented Programming (OOP) seperti bahasa lain (misalnya, Java atau C++). Namun, Go memungkinkan penerapan konsep-konsep OOP dengan menggunakan struct (untuk objek),  method ,  interface , dan prinsip-prinsip OOP lainnya. Berikut adalah pembahasan mengenai konsep-konsep OOP yang bisa diterapkan di Go.

### 1. Object (Struct sebagai Representasi Object)

Di Go, objek tidak dibuat menggunakan kelas seperti di bahasa pemrograman OOP lainnya. Sebagai gantinya, kita menggunakan struct untuk mendefinisikan objek dan atribut-atributnya.

 Contoh Struct (Objek) :

```go
package main

import "fmt"

// Definisi Struct sebagai representasi objek
type Car struct {
    Make  string
    Model string
    Year  int
}

func main() {
    // Membuat objek dengan Struct
    car := Car{Make: "Toyota", Model: "Corolla", Year: 2020}
    fmt.Println(car)  // Output: {Toyota Corolla 2020}
}
```

Di sini, `Car` adalah struct yang berfungsi seperti objek, dengan field `Make`, `Model`, dan `Year`.

### 2. Properties dan Methods

Go tidak memiliki konsep properties seperti di bahasa OOP lainnya, tetapi kita bisa menggunakan fields dalam struct untuk menyimpan data. Kemudian, kita bisa mendefinisikan methods untuk memberi perilaku pada struct tersebut. Access modifier di Go didasarkan pada huruf pertama dari nama field atau method: jika diawali dengan huruf besar, maka bisa diakses secara publik; jika huruf kecil, maka private.

 Contoh :

```go
package main

import "fmt"

// Definisi Struct
type Person struct {
    Name string // Public (bisa diakses dari luar paket)
    age  int    // Private (hanya bisa diakses dalam paket ini)
}

// Method untuk struct Person
func (p Person) GetName() string {
    return p.Name
}

func (p *Person) SetAge(age int) {
    p.age = age
}

func (p Person) GetAge() int {
    return p.age
}

func main() {
    person := Person{Name: "Alice", age: 30}
    fmt.Println(person.GetName()) // Output: Alice
    person.SetAge(31)
    fmt.Println(person.GetAge())  // Output: 31
}
```

* Public Field/Method : Jika nama dimulai dengan huruf besar, bisa diakses dari luar.
* Private Field/Method : Jika nama dimulai dengan huruf kecil, hanya bisa diakses di dalam paket.

### 3. Interface

Go tidak memiliki konsep kelas atau pewarisan langsung. Sebagai gantinya, Go menggunakan interface untuk mendefinisikan perilaku yang dapat diimplementasikan oleh tipe-tipe lain. Salah satu fitur menarik dari interface di Go adalah  multiple interfaces , yang memungkinkan satu tipe untuk mengimplementasikan lebih dari satu interface.

 Contoh Implementasi Interface :

```go
package main

import "fmt"

// Definisi Interface
type Speaker interface {
    Speak() string
}

// Struct pertama
type Person struct {
    Name string
}

func (p Person) Speak() string {
    return "Hello, my name is " + p.Name
}

// Struct kedua
type Robot struct {
    Model string
}

func (r Robot) Speak() string {
    return "I am a robot, model " + r.Model
}

func introduce(speaker Speaker) {
    fmt.Println(speaker.Speak())
}

func main() {
    person := Person{Name: "Bob"}
    robot := Robot{Model: "R2D2"}

    // Menggunakan multiple interfaces
    introduce(person)  // Output: Hello, my name is Bob
    introduce(robot)   // Output: I am a robot, model R2D2
}
```

* Multiple Interfaces : Dalam Go, sebuah tipe bisa mengimplementasikan banyak interface sekaligus.
* Empty Interface (`interface{}`) : Ini adalah jenis interface yang tidak memiliki metode apa pun, sehingga dapat menyimpan nilai apa pun.

 Contoh Empty Interface :

```go
package main

import "fmt"

func printAny(value interface{}) {
    fmt.Println(value)
}

func main() {
    printAny(42)          // Output: 42
    printAny("Hello")     // Output: Hello
    printAny(true)        // Output: true
}
```

`interface{}` adalah tipe yang dapat menyimpan nilai dari tipe data mana pun.

### 4. Polymorphism

Go mendukung polymorphism melalui  interface . Polymorphism memungkinkan objek dari tipe yang berbeda untuk diperlakukan sebagai objek dari tipe yang sama (yaitu, interface).

 Contoh Polymorphism :

```go
package main

import "fmt"

// Interface
type Animal interface {
    Speak() string
}

type Dog struct{}
type Cat struct{}

func (d Dog) Speak() string {
    return "Woof!"
}

func (c Cat) Speak() string {
    return "Meow!"
}

func printAnimalSound(a Animal) {
    fmt.Println(a.Speak())
}

func main() {
    dog := Dog{}
    cat := Cat{}

    printAnimalSound(dog)  // Output: Woof!
    printAnimalSound(cat)  // Output: Meow!
}
```

Di sini, `Dog` dan `Cat` keduanya mengimplementasikan interface `Animal` dengan cara yang berbeda, menghasilkan perilaku yang berbeda meskipun menggunakan tipe data yang sama.

### 5. Composition over Inheritance

Go lebih mengutamakan composition daripada  inheritance . Dengan menggunakan embedding, kita dapat menambahkan fungsionalitas dari tipe lain tanpa harus mewarisi langsung dari tipe tersebut.

 Contoh Composition :

```go
package main

import "fmt"

// Struct pertama
type Engine struct {
    Horsepower int
}

// Method untuk Engine
func (e Engine) Start() {
    fmt.Println("Engine starting...")
}

// Struct kedua yang meng-embed Engine
type Car struct {
    Engine // Composition
    Make   string
    Model  string
}

func main() {
    car := Car{
        Engine: Engine{Horsepower: 300},
        Make:   "Tesla",
        Model:  "Model S",
    }

    fmt.Println("Car:", car.Make, car.Model)
    car.Start()  // Output: Engine starting...
}
```

Di sini, `Car` meng-embed `Engine`, yang artinya `Car` dapat menggunakan metode `Start` dari `Engine` tanpa pewarisan langsung.

### 6. Constructor Patterns (Factory Functions)

Go tidak memiliki konstruktor formal seperti di bahasa OOP lain. Sebagai gantinya, kita bisa menggunakan factory function untuk membuat dan menginisialisasi objek.

 Contoh Factory Function :

```go
package main

import "fmt"

type Point struct {
    X, Y int
}

// Factory function untuk membuat objek Point
func NewPoint(x, y int) Point {
    return Point{X: x, Y: y}
}

func main() {
    p := NewPoint(10, 20)
    fmt.Println(p)  // Output: {10 20}
}
```

Factory function `NewPoint` berfungsi seperti konstruktor untuk membuat objek `Point`.

### 7. Embedding untuk Pewarisan

Go menggunakan embedding untuk pewarisan, yang memungkinkan sebuah struct untuk "memiliki" tipe lain tanpa harus mewarisinya. Ini adalah cara untuk menyusun fungsionalitas dari tipe lain ke dalam tipe kita.

 Contoh Embedding :

```go
package main

import "fmt"

type Animal struct {
    Name string
}

func (a Animal) Speak() {
    fmt.Println("Animal says:", a.Name)
}

type Dog struct {
    Animal // Embedding (seperti pewarisan)
    Breed  string
}

func main() {
    dog := Dog{
        Animal: Animal{Name: "Rex"},
        Breed:  "Bulldog",
    }

    dog.Speak()  // Output: Animal says: Rex
}
```

Dengan embedding `Animal` dalam `Dog`, struct `Dog` dapat menggunakan metode `Speak` dari `Animal`, memberikan kesan bahwa `Dog` mewarisi `Animal`.

## 5. Concurrency & Parallel Programming

Go memiliki kemampuan concurrency yang sangat baik dan membuatnya mudah untuk menangani eksekusi secara paralel dengan fitur goroutines dan  channels . Concurrency memungkinkan program untuk menjalankan banyak tugas secara bersamaan, sedangkan parallelism adalah eksekusi beberapa tugas secara bersamaan pada banyak core prosesor. Go menyediakan alat untuk menangani keduanya dengan cara yang sederhana dan efisien.

### 1. Goroutines

Goroutine adalah unit terkecil dari eksekusi concurrent di Go. Goroutine adalah thread ringan yang dikelola oleh runtime Go, yang memungkinkan program untuk menjalankan banyak fungsi secara bersamaan tanpa harus memulai thread baru untuk setiap eksekusi.

Untuk memulai sebuah goroutine, Anda cukup menambahkan kata kunci `go` di depan fungsi yang ingin dijalankan secara konkuren.

 Contoh Goroutine :

```go
package main

import (
    "fmt"
    "time"
)

func printMessage(msg string) {
    fmt.Println(msg)
}

func main() {
    // Menjalankan fungsi secara concurrent (goroutine)
    go printMessage("Hello from Goroutine!")

    // Menunggu sejenak agar goroutine selesai
    time.Sleep(1 * time.Second)
    fmt.Println("Main function ends")
}
```

Penjelasan:

* `go printMessage("Hello from Goroutine!")` menjalankan fungsi `printMessage` dalam sebuah goroutine.
* `time.Sleep(1 * time.Second)` digunakan untuk memberi waktu agar goroutine dapat menyelesaikan tugasnya sebelum program utama selesai.

Goroutine sangat ringan dan banyak goroutine dapat dijalankan dalam satu program tanpa mempengaruhi kinerja.

### 2. Channels

Channel adalah cara utama di Go untuk berkomunikasi antar goroutine. Channels memungkinkan goroutine untuk mengirim dan menerima data antar satu sama lain dengan aman. Anda bisa menganggap channel sebagai pipa yang mengalirkan data antar goroutine.

Untuk membuat channel, gunakan kata kunci `make`. Untuk mengirimkan data ke channel, gunakan operator `<-`.

 Contoh Channels :

```go
package main

import "fmt"

func sendData(ch chan string) {
    ch <- "Hello from Goroutine!" // Mengirim data ke channel
}

func main() {
    ch := make(chan string) // Membuat channel tipe string

    // Menjalankan fungsi sendData dalam goroutine
    go sendData(ch)

    // Menerima data dari channel
    msg := <-ch
    fmt.Println(msg) // Output: Hello from Goroutine!
}
```

Penjelasan:

* `ch <- "Hello from Goroutine!"` mengirim data ke channel `ch`.
* `msg := <-ch` menerima data dari channel dan menyimpannya dalam variabel `msg`.
* Program akan menunggu sampai data diterima sebelum melanjutkan ke baris berikutnya.

Anda juga dapat menggunakan channel buffered (dengan kapasitas) yang memungkinkan goroutine untuk mengirim data tanpa harus menunggu goroutine lain untuk menerima.

 Contoh Buffered Channel :

```go
package main

import "fmt"

func sendData(ch chan string) {
    ch <- "Message in buffered channel"
}

func main() {
    ch := make(chan string, 1) // Membuat buffered channel dengan kapasitas 1

    // Menjalankan fungsi sendData dalam goroutine
    go sendData(ch)

    // Menerima data dari channel
    msg := <-ch
    fmt.Println(msg) // Output: Message in buffered channel
}
```

Buffered channel memungkinkan goroutine untuk mengirim data tanpa harus menunggu penerima siap, asalkan kapasitas channel masih ada.

### 3. Race Conditions dan Sync Mechanisms (`sync.Mutex`, `sync.WaitGroup`)

Race Condition terjadi ketika dua atau lebih goroutine mengakses data yang sama pada saat yang sama, dan setidaknya salah satunya mengubah data tersebut. Ini bisa menyebabkan hasil yang tidak dapat diprediksi. Untuk menghindari masalah ini, Go menyediakan beberapa mekanisme untuk sinkronisasi, seperti `sync.Mutex` dan `sync.WaitGroup`.

Race Condition Contoh :

```go
package main

import (
    "fmt"
    "sync"
)

var counter int

func increment(wg *sync.WaitGroup) {
    counter++
    wg.Done()
}

func main() {
    var wg sync.WaitGroup

    // Menjalankan 1000 goroutine
    for i := 0; i < 1000; i++ {
        wg.Add(1)
        go increment(&wg)
    }

    wg.Wait() // Menunggu semua goroutine selesai
    fmt.Println("Counter:", counter) // Output bisa bervariasi karena race condition
}
```

Penjelasan:

* Program ini memiliki 1000 goroutine yang mengakses variabel `counter` secara bersamaan.
* Karena `counter` diakses oleh banyak goroutine tanpa penguncian, bisa terjadi race condition yang menghasilkan nilai yang tidak konsisten.

#### Menghindari Race Condition dengan `sync.Mutex` :

Mutex adalah objek untuk mengunci data, memastikan bahwa hanya satu goroutine yang dapat mengakses data dalam satu waktu.

 Contoh menggunakan `sync.Mutex` :

```go
package main

import (
    "fmt"
    "sync"
)

var counter int
var mutex sync.Mutex

func increment(wg *sync.WaitGroup) {
    mutex.Lock() // Mengunci akses ke counter
    counter++
    mutex.Unlock() // Melepaskan kunci
    wg.Done()
}

func main() {
    var wg sync.WaitGroup

    // Menjalankan 1000 goroutine
    for i := 0; i < 1000; i++ {
        wg.Add(1)
        go increment(&wg)
    }

    wg.Wait() // Menunggu semua goroutine selesai
    fmt.Println("Counter:", counter) // Output: 1000
}
```

Penjelasan:

* Dengan menggunakan `mutex.Lock()` dan `mutex.Unlock()`, kita memastikan bahwa hanya satu goroutine yang dapat mengakses variabel `counter` pada satu waktu, menghindari race condition.

#### Menggunakan `sync.WaitGroup` untuk Sinkronisasi :

WaitGroup digunakan untuk menunggu hingga sekumpulan goroutine selesai menjalankan tugasnya.

 Contoh menggunakan `sync.WaitGroup` :

```go
package main

import (
    "fmt"
    "sync"
)

func task(wg *sync.WaitGroup, id int) {
    fmt.Printf("Task %d started\n", id)
    wg.Done() // Menandakan bahwa tugas telah selesai
}

func main() {
    var wg sync.WaitGroup

    // Menambahkan 3 tugas ke WaitGroup
    for i := 1; i <= 3; i++ {
        wg.Add(1)
        go task(&wg, i)
    }

    wg.Wait() // Menunggu semua goroutine selesai
    fmt.Println("All tasks completed")
}
```

Penjelasan:

* `wg.Add(1)` menambahkan satu goroutine yang akan dikerjakan.
* `wg.Done()` mengurangi hitungan goroutine yang masih harus selesai.
* `wg.Wait()` akan menunggu hingga semua goroutine selesai.

## 6. Generics

Generics di Go adalah fitur yang memungkinkan Anda menulis fungsi, tipe data, dan struktur yang dapat bekerja dengan berbagai jenis data (types) tanpa mengorbankan keamanan tipe. Fitur ini diperkenalkan dalam Go 1.18 dan memungkinkan Anda untuk membuat kode yang lebih fleksibel dan dapat digunakan kembali.

Sebelumnya, Go tidak memiliki dukungan untuk generics, dan para pengembang sering kali menggunakan antarmuka kosong (`interface{}`) untuk mencapai fleksibilitas tipe. Namun, dengan adanya generics, kode Go menjadi lebih kuat, dengan tipe yang dapat dipastikan secara statis.

### 1. Generic Function

Contoh fungsi generik yang menerima berbagai jenis tipe data:

```go
package main

import "fmt"

// Fungsi generik untuk mencetak nilai apa pun
func print[T any](value T) {
    fmt.Println(value)
}

func main() {
    print(42)          // Output: 42
    print("Hello Go")  // Output: Hello Go
    print(3.14)        // Output: 3.14
}
```

Penjelasan:

* Fungsi `print` menggunakan parameter tipe `T` yang disertai dengan `any` (jenis tipe data apa saja). `any` adalah alias untuk `interface{}`.
* Saat fungsi dipanggil, Go akan mengidentifikasi tipe data dari argumen yang diberikan dan menggantikan `T` dengan tipe tersebut.

### 2. Generic Type

Anda juga bisa membuat tipe generik seperti struktur data atau tipe koleksi yang dapat bekerja dengan berbagai jenis data.

```go
package main

import "fmt"

// Tipe Stack generik
type Stack[T any] struct {
    items []T
}

// Fungsi untuk menambah item ke stack
func (s *Stack[T]) Push(item T) {
    s.items = append(s.items, item)
}

// Fungsi untuk mengambil item dari stack
func (s *Stack[T]) Pop() T {
    if len(s.items) == 0 {
        var zero T // Mengembalikan nilai nol dari tipe T
        return zero
    }
    item := s.items[len(s.items)-1]
    s.items = s.items[:len(s.items)-1]
    return item
}

func main() {
    // Menggunakan Stack untuk int
    intStack := Stack[int]{}
    intStack.Push(1)
    intStack.Push(2)
    fmt.Println(intStack.Pop()) // Output: 2

    // Menggunakan Stack untuk string
    strStack := Stack[string]{}
    strStack.Push("Go")
    strStack.Push("Language")
    fmt.Println(strStack.Pop()) // Output: Language
}
```

Penjelasan:

* Struktur `Stack` adalah tipe generik yang dapat digunakan untuk menyimpan berbagai jenis data (`int`, `string`, dll.).
* Anda bisa memanggil fungsi `Push` dan `Pop` untuk memasukkan dan mengeluarkan elemen dari stack, dan Go akan mengatur tipe data dengan tepat berdasarkan tipe yang Anda pilih.

### 3. Constraints pada Generics

Go juga memungkinkan Anda untuk memberi batasan pada tipe yang dapat digunakan dengan generics menggunakan `interface{}` atau dengan mendefinisikan `type constraints`.

Misalnya, jika Anda hanya ingin tipe data tertentu yang mendukung operasi matematika tertentu, Anda bisa menggunakan constraint:

```go
package main

import "fmt"

// Membatasi tipe hanya untuk tipe data yang mendukung operasi penjumlahan
type Adder[T int | float64] interface {
    Add(T) T
}

// Fungsi untuk menjumlahkan dua angka
func sum[T int | float64](a, b T) T {
    return a + b
}

func main() {
    fmt.Println(sum(10, 20))      // Output: 30
    fmt.Println(sum(3.14, 2.71))  // Output: 5.85
}
```

Penjelasan:

* `sum` adalah fungsi generik yang hanya menerima tipe `int` atau `float64`. Pembatasan ini dilakukan dengan menggunakan tipe union `|`.
* `Adder` adalah contoh lain di mana Anda bisa menggunakan constraints untuk hanya memungkinkan tipe yang dapat melakukan operasi tertentu (misalnya, penjumlahan).

## 7. Package Management

Di Go, manajemen paket dan pengelolaan dependensi dilakukan menggunakan `go.mod`, serta alat-alat seperti `go get` untuk mengunduh dan mengelola dependensi proyek. Berikut adalah penjelasan dan contoh tentang bagaimana cara menggunakan package management di Go:

1. `go.mod`

`go.mod` adalah file yang berfungsi untuk mengelola dependensi dan menetapkan modul Go. Modul adalah kumpulan file Go yang diorganisir dalam direktori dan disertakan dengan file `go.mod` untuk mencatat dependensi dan versi Go yang digunakan.

2. Membuat Proyek Baru dengan Modul Go

Untuk memulai proyek Go dengan menggunakan modul, Anda harus terlebih dahulu menginisialisasi modul dengan perintah `go mod init`. Ini akan membuat file `go.mod` yang menyimpan informasi tentang modul dan dependensi yang diperlukan.

Langkah-langkah:

1. Inisialisasi Modul Go :

* Jalankan perintah berikut untuk membuat file `go.mod`:

```bash
   go mod init nama_modul
```

   Contoh: `go mod init github.com/user/project`

1. File go.mod :
   Setelah menjalankan perintah di atas, Go akan membuat file `go.mod` di direktori proyek Anda. File ini akan berisi informasi dasar tentang modul, seperti nama modul dan versi Go yang digunakan.
   Contoh isi file `go.mod`:

```go
   module github.com/user/project

   go 1.18
```

1. Menambahkan Paket ke Proyek :
   Untuk menambahkan paket eksternal, Anda bisa menggunakan `go get`.
2. `go get`

Perintah `go get` digunakan untuk mengunduh dan menambahkan dependensi eksternal ke dalam proyek Anda.

Contoh Penggunaan `go get`:

Misalnya Anda ingin menggunakan paket `gorilla/mux` (router HTTP) dalam proyek Anda. Anda bisa menambahkannya dengan menjalankan:

```bash
go get github.com/gorilla/mux
```

Perintah ini akan mengunduh paket dan memperbarui file `go.mod` untuk menyertakan dependensi tersebut.

Setelah menambahkan dependensi, file `go.mod` Anda akan diperbarui menjadi seperti berikut:

```go
module github.com/user/project

go 1.18

require github.com/gorilla/mux v1.8.0 // indirect
```

4. Contoh Kode dengan Modul Go dan Paket Eksternal

Setelah modul Go diinisialisasi dan dependensi diunduh, Anda bisa menulis kode dengan menggunakan paket-paket tersebut.

File `main.go`:

```go
package main

import (
    "fmt"
    "net/http"
    "github.com/gorilla/mux"
)

func helloHandler(w http.ResponseWriter, r *http.Request) {
    fmt.Fprintf(w, "Hello, Go with Gorilla Mux!")
}

func main() {
    r := mux.NewRouter()
    r.HandleFunc("/", helloHandler)

    fmt.Println("Server started at http://localhost:8080")
    http.ListenAndServe(":8080", r)
}
```

Penjelasan:

* Di sini, kita menggunakan `gorilla/mux` sebagai router untuk menangani HTTP request.
* Ketika Anda menjalankan aplikasi, Anda bisa mengakses halaman yang menampilkan "Hello, Go with Gorilla Mux!" di `localhost:8080`.

5. Perbarui dan Bersihkan Dependensi dengan `go mod tidy`

Setelah mengubah dependensi atau menambah paket, Anda dapat menggunakan perintah `go mod tidy` untuk membersihkan dan memperbarui file `go.mod` dan `go.sum`. Ini menghapus dependensi yang tidak digunakan dan memastikan bahwa semua dependensi yang diperlukan ada di dalam file.

```bash
go mod tidy
```

6. Menjalankan Kode dengan `go run`

Setelah semuanya diatur, Anda bisa menjalankan kode Go Anda menggunakan `go run`:

```bash
go run main.go
```

Ini akan menjalankan aplikasi dan Anda dapat mengaksesnya melalui browser di `http://localhost:8080`.

7. Menambahkan atau Memperbarui Versi Dependensi

Jika Anda ingin memperbarui versi paket yang Anda gunakan, Anda bisa menggunakan perintah `go get` dengan menambahkan versi paket.

Contoh memperbarui `mux` ke versi terbaru:

```bash
go get github.com/gorilla/mux@latest
```

Perintah ini akan memperbarui dependensi di `go.mod` dan `go.sum` ke versi terbaru.

8. File `go.sum`

Selain `go.mod`, ada juga file `go.sum` yang berfungsi untuk memastikan integritas dari dependensi yang diunduh. File ini mencatat hash dari modul yang digunakan.

Contoh isi file `go.sum`:

```
github.com/gorilla/mux v1.8.0 h1:si1d1f...
github.com/gorilla/mux v1.8.0/go.mod h1:123456...
```

`go.sum` memastikan bahwa dependensi yang diunduh adalah versi yang benar dan tidak ada perubahan yang tidak sah.

9. Menggunakan Modul dalam Kode Go

Jika Anda ingin menggunakan dependensi yang sudah diatur dalam `go.mod`, cukup import di dalam kode Go Anda.

Contoh import dari modul `mux`:

```go
import "github.com/gorilla/mux"
```

Dengan sistem manajemen paket ini, Anda bisa dengan mudah mengelola dan menjaga dependensi di proyek Go Anda.

## 8. Testing & Debugging

### 1. Unit Testing (Package `testing`)

Unit testing di Go dilakukan dengan menggunakan package `testing`. Package ini menyediakan cara untuk menulis tes untuk memverifikasi apakah kode berfungsi sebagaimana mestinya. Unit testing adalah pendekatan penting untuk memastikan bahwa bagian-bagian kecil dari aplikasi (unit) bekerja sesuai harapan.

Fitur utama dalam `testing`:

* Fungsi tes ditulis dalam bentuk fungsi yang dimulai dengan kata `Test`, misalnya `TestFunctionName`.
* Fungsi tes menerima argumen `*testing.T`, yang menyediakan metode untuk melaporkan hasil tes (misalnya, `t.Error()`, `t.Fail()`, dll).
* Tes dapat dijalankan dengan menggunakan perintah `go test`.

Contoh Unit Test di Go:

```go
package main

import (
	"testing"
)

// Fungsi yang akan diuji
func Add(a, b int) int {
	return a + b
}

// Unit test untuk fungsi Add
func TestAdd(t *testing.T) {
	result := Add(2, 3)
	expected := 5

	if result != expected {
		t.Errorf("Add(2, 3) = %d; expected %d", result, expected)
	}
}
```

Penjelasan:

* Fungsi `Add` yang diuji adalah fungsi sederhana untuk penjumlahan dua angka.
* Fungsi `TestAdd` adalah unit test untuk memverifikasi bahwa hasil penjumlahan 2 dan 3 adalah 5.
* Jika hasilnya tidak sesuai dengan yang diharapkan, kita menggunakan `t.Errorf` untuk melaporkan kesalahan.

Menjalankan Unit Test:
Untuk menjalankan tes, cukup gunakan perintah:

```bash
go test
```

Go akan mencari file yang diawali dengan `Test` dan menjalankan semua fungsi tes yang ditemukan.

### 2. Debugging dengan `delve`

`delve` adalah debugger untuk Go yang memungkinkan Anda untuk memeriksa dan menganalisis aplikasi Go saat dijalankan. Dengan `delve`, Anda dapat melihat nilai variabel, melangkah melalui kode, menetapkan breakpoint, dan menjalankan aplikasi Go secara interaktif untuk memecahkan masalah dan menemukan bug.

Fitur utama `delve`:

* Set Breakpoints: Anda dapat menetapkan breakpoint untuk menghentikan eksekusi aplikasi pada titik tertentu.
* Inspect Variables: Setelah aplikasi berhenti di breakpoint, Anda dapat memeriksa nilai variabel.
* Step Through Code: Anda dapat melangkah secara terperinci melalui kode untuk memeriksa bagaimana aplikasi berjalan.
* Remote Debugging: Anda dapat menggunakan `delve` untuk debugging aplikasi Go yang berjalan di mesin jarak jauh.

Menginstal `delve`:
Untuk menginstal `delve`, Anda dapat menjalankan:

```bash
go install github.com/go-delve/delve/cmd/dlv@latest
```

Contoh Penggunaan `delve`:

1. Menjalankan program dengan `delve`:

```bash
dlv run
```

2. Menetapkan breakpoint di suatu titik dalam kode:

```bash
break main.main
```

3. Melangkah melalui kode dengan perintah `step` dan memeriksa variabel dengan perintah `print`.

Perintah Dasar `delve`:

* `break <function>`: Menetapkan breakpoint di fungsi tertentu.
* `continue`: Melanjutkan eksekusi setelah breakpoint.
* `step`: Melangkah satu baris kode.
* `next`: Menjalankan kode hingga baris berikutnya dalam fungsi yang sama.
* `print <variable>`: Mencetak nilai dari variabel tertentu.
* `exit`: Keluar dari debugger.

Dengan `delve`, debugging aplikasi Go menjadi lebih efisien dan memberikan wawasan lebih mendalam tentang eksekusi kode.

### Libraries untuk Unit Testing di Go:

Selain package `testing` yang sudah disediakan oleh Go, ada beberapa library tambahan yang memperkaya kemampuan unit testing di Go. Berikut adalah beberapa library yang populer digunakan untuk testing di Go:

1. `Testify`

   * Fungsi: Menyediakan assertion dan mock objects untuk mempermudah penulisan tes.
   * Fitur: Assertion methods, mock objects, dan suite testing.
   * Link: [Testify on GitHub](https://github.com/stretchr/testify)

   Contoh Penggunaan:

   ```go
   import (
       "testing"
       "github.com/stretchr/testify/assert"
   )

   func TestAdd(t *testing.T) {
       result := Add(2, 3)
       assert.Equal(t, 5, result, "they should be equal")
   }
   ```
2. `GoMock`

   * Fungsi: Menghasilkan mock object untuk mempermudah testing kode yang berinteraksi dengan interface.
   * Fitur: Integrasi dengan `testing` package, mock object generation.
   * Link: [GoMock on GitHub](https://github.com/golang/mock)

   Contoh Penggunaan:
   GoMock biasanya digunakan dengan tools untuk menghasilkan mock interfaces secara otomatis.

   ```bash
   mockgen -source=my_interface.go -destination=mocks/my_interface_mock.go
   ```
3. `Ginkgo`

   * Fungsi: Framework untuk behavior-driven development (BDD) di Go.
   * Fitur: Menyediakan syntax testing yang lebih mudah dibaca, seperti `It`, `Describe`, dll.
   * Link: [Ginkgo on GitHub](https://github.com/onsi/ginkgo)

   Contoh Penggunaan:

   ```go
   var _ = Describe("Add Function", func() {
       It("should add two numbers", func() {
           result := Add(2, 3)
           Expect(result).To(Equal(5))
       })
   })
   ```
4. `GoConvey`

   * Fungsi: Framework lain untuk BDD yang memungkinkan syntax testing yang lebih ekspresif dan interaktif.
   * Fitur: Support untuk live test reporting, assertion, dan BDD-style testing.
   * Link: [GoConvey on GitHub](https://github.com/smartystreets/goconvey)

   Contoh Penggunaan:

   ```go
   convey.Convey("Given two numbers", t, func() {
       convey.Convey("When adding them", func() {
           result := Add(2, 3)
           convey.So(result, convey.ShouldEqual, 5)
       })
   })
   ```
5. `assert`

   * Fungsi: Paket assertion sederhana untuk Go.
   * Fitur: Menyediakan berbagai metode assertion seperti `Equal`, `NotNil`, `Nil`, dll.
   * Link: [assert on GitHub](https://github.com/go-playground/assert)

Dengan berbagai libraries dan alat yang tersedia di Go, Anda dapat memperkaya pengalaman unit testing dan debugging Anda, serta mempermudah proses pengembangan dan pemeliharaan kode.

## 9. Regular Expressions

Regular expressions (regex) digunakan untuk mencocokkan pola dalam string. Di Go, regex didukung melalui package `regexp`, yang menyediakan fungsi-fungsi untuk bekerja dengan regex. Dengan package ini, kita bisa melakukan pencocokan pola, ekstraksi data, penggantian, dan lainnya.

Fitur Utama `regexp`:

* Compile: Mengkompilasi pola regex menjadi objek `Regexp`.
* Match: Memeriksa apakah pola regex ada dalam string.
* Find: Menemukan bagian dari string yang cocok dengan pola.
* Replace: Mengganti bagian string yang cocok dengan pola.
* Split: Memisahkan string berdasarkan pola regex.

Menggunakan Package `regexp`

1. Compile Regex :
   Fungsi `regexp.Compile` digunakan untuk mengkompilasi pola regex menjadi objek `Regexp` yang bisa digunakan untuk pencocokan dan operasi lainnya.

```go
   package main

   import (
       "fmt"
       "regexp"
   )

   func main() {
       pattern := `\d+` // Pola untuk mencocokkan angka
       re, err := regexp.Compile(pattern)
       if err != nil {
           fmt.Println("Error compiling regex:", err)
           return
       }

       text := "There are 15 apples and 20 oranges."
       match := re.FindString(text)
       fmt.Println("First number found:", match)
   }
```

   Penjelasan:

* Pola `\d+` mencocokkan satu atau lebih digit.
* `FindString` digunakan untuk menemukan kecocokan pertama dalam string.

1. Match dengan Regex :
   Fungsi `MatchString` digunakan untuk memeriksa apakah sebuah string cocok dengan pola regex tertentu.

```go
   package main

   import (
       "fmt"
       "regexp"
   )

   func main() {
       pattern := `^Hello` // Pola untuk mencocokkan string yang diawali dengan "Hello"
       re, err := regexp.Compile(pattern)
       if err != nil {
           fmt.Println("Error compiling regex:", err)
           return
       }

       text := "Hello, world!"
       match := re.MatchString(text)
       fmt.Println("Match found:", match)
   }
```

   Penjelasan:

* Pola `^Hello` mencocokkan string yang diawali dengan kata "Hello".
* `MatchString` mengembalikan `true` jika ada kecocokan, atau `false` jika tidak ada.

1. Find Semua Kecocokan :
   Fungsi `FindAllString` digunakan untuk menemukan semua kecocokan dari pola dalam sebuah string.

```go
   package main

   import (
       "fmt"
       "regexp"
   )

   func main() {
       pattern := `\d+` // Pola untuk mencocokkan angka
       re, err := regexp.Compile(pattern)
       if err != nil {
           fmt.Println("Error compiling regex:", err)
           return
       }

       text := "There are 15 apples, 20 oranges, and 100 bananas."
       matches := re.FindAllString(text, -1) // -1 untuk menemukan semua kecocokan
       fmt.Println("All numbers found:", matches)
   }
```

   Penjelasan:

* `FindAllString` digunakan untuk mendapatkan semua kecocokan pola dalam string.
* `-1` sebagai parameter kedua berarti kita ingin menemukan semua kecocokan, bukan hanya satu.

1. Replace dengan Regex :
   Fungsi `ReplaceAllString` digunakan untuk mengganti bagian dari string yang cocok dengan pola regex.

```go
   package main

   import (
       "fmt"
       "regexp"
   )

   func main() {
       pattern := `\d+` // Pola untuk mencocokkan angka
       re, err := regexp.Compile(pattern)
       if err != nil {
           fmt.Println("Error compiling regex:", err)
           return
       }

       text := "There are 15 apples and 20 oranges."
       replacedText := re.ReplaceAllString(text, "[number]")
       fmt.Println("Replaced text:", replacedText)
   }
```

   Penjelasan:

* `ReplaceAllString` mengganti setiap kecocokan pola dalam string dengan string yang diberikan.
* Dalam contoh ini, setiap angka diganti dengan `[number]`.

1. Split String dengan Regex :
   Fungsi `Split` digunakan untuk membagi string berdasarkan pola regex.

```go
   package main

   import (
       "fmt"
       "regexp"
   )

   func main() {
       pattern := `\s+` // Pola untuk mencocokkan spasi satu atau lebih
       re, err := regexp.Compile(pattern)
       if err != nil {
           fmt.Println("Error compiling regex:", err)
           return
       }

       text := "This is a test sentence."
       words := re.Split(text, -1)
       fmt.Println("Words:", words)
   }
```

   Penjelasan:

* `Split` membagi string berdasarkan kecocokan pola, dalam hal ini spasi satu atau lebih.
* Hasilnya adalah array dari kata-kata yang dipisahkan oleh spasi.

Beberapa Fungsi Penting dalam `regexp`:

* `MatchString(pattern, s string) bool` : Memeriksa apakah string `s` cocok dengan pola regex `pattern`.
* `FindString(s string) string` : Mencari kecocokan pertama dan mengembalikan string yang cocok.
* `FindAllString(s string, n int) []string` : Mencari semua kecocokan dan mengembalikan slice string.
* `ReplaceAllString(s, repl string) string` : Mengganti semua kecocokan dengan string `repl`.
* `Split(s string, n int) []string` : Memisahkan string `s` berdasarkan pola regex.

## 10. Preprocessor Directives

Di Go, tidak ada konsep preprocessor directives seperti di bahasa pemrograman lain seperti C/C++ yang menggunakan `#define`, `#if`, `#ifdef`, dll. Go memilih untuk tidak mengandalkan preprocessor, yang berarti bahwa semua kode di Go harus dapat dipahami secara langsung oleh kompilator tanpa adanya pra-kompilasi.

Namun, Go memiliki beberapa fitur yang mirip dengan preprocessor untuk beberapa tujuan tertentu. Berikut adalah beberapa fitur yang sering digunakan yang mirip dengan preprocessor directives di Go:

### 1. Build Constraints (Build Tags)

Go menyediakan cara untuk mengatur berbagai konfigurasi build yang mirip dengan preprocessor directives, yaitu menggunakan build constraints atau  build tags . Build tags memungkinkan Anda untuk menentukan file mana yang akan disertakan dalam kompilasi berdasarkan kondisi tertentu, seperti platform atau arsitektur tertentu.

Sintaks Build Tag:

* Build tags ditempatkan di bagian atas file Go sebagai komentar dan harus diawali dengan `// +build`.
* Build tag menentukan file mana yang akan disertakan dalam kompilasi untuk platform atau kondisi tertentu.

Contoh penggunaan build tags:

```go
// +build linux

package main

import "fmt"

func main() {
    fmt.Println("This is a Linux build!")
}
```

Penjelasan:

* File di atas hanya akan disertakan dalam kompilasi jika build dilakukan pada sistem operasi  Linux .
* Anda bisa menggunakan beberapa kondisi dalam build tags seperti `linux`, `windows`, `amd64`, `arm`, dll.
* Anda dapat menggabungkan beberapa kondisi menggunakan `&&` atau `||`.

### 2.  Conditional Compilation :

Go tidak mendukung conditional compilation langsung di dalam kode (seperti `#ifdef` di C), tetapi Anda bisa mengontrol file mana yang digunakan pada kompilasi berdasarkan tag build, platform, atau arsitektur. Ini memberikan kontrol serupa terhadap pengkondisian kompilasi tetapi dengan cara yang lebih eksplisit dan terorganisir.

Misalnya, Anda dapat memiliki dua file berbeda untuk platform yang berbeda, dan Go akan memilih file yang sesuai selama kompilasi berdasarkan build tag yang diterapkan.

Contoh:

* file_linux.go:
  ```go
  // +build linux

  package main

  func platformSpecific() string {
      return "Running on Linux"
  }
  ```
* file_windows.go:
  ```go
  // +build windows

  package main

  func platformSpecific() string {
      return "Running on Windows"
  }
  ```

Di sini, Go akan memilih file yang sesuai berdasarkan sistem operasi yang digunakan selama kompilasi.

### 3. `go:generate` Directive

Go juga mendukung perintah `go:generate`, yang memungkinkan Anda untuk menjalankan perintah eksternal atau generator kode saat proses build, mirip dengan preprocessor directives di bahasa lain. Perintah ini dapat digunakan untuk menghasilkan kode sumber sebelum kompilasi.

Contoh Penggunaan `go:generate`:

```go
//go:generate echo "Generating code for struct..."

package main

import "fmt"

func main() {
    fmt.Println("Hello, world!")
}
```

Penjelasan:

* `go:generate` adalah direktif yang memberi tahu alat Go untuk menjalankan perintah yang tertera setelahnya sebelum kompilasi.
* Dalam contoh ini, perintah `echo "Generating code for struct..."` akan dijalankan setiap kali Anda menjalankan perintah `go generate`.

Anda bisa menggunakan `go:generate` untuk menjalankan perintah lain, seperti kode pembangkit otomatis atau alat lain yang berguna selama proses build.

### 4. Cgo Directives (untuk Interoperabilitas dengan C)

Cgo adalah alat di Go yang memungkinkan interaksi antara Go dan C. Ada beberapa direktif khusus yang digunakan oleh Cgo untuk mengatur penggabungan kode Go dan C.

Contoh Cgo Directive:

```go
/*
#cgo CFLAGS: -g -Wall
#cgo LDFLAGS: -lm
#include <stdio.h>
*/
import "C"

func main() {
    C.puts(C.CString("Hello from C!"))
}
```

Penjelasan:

* Direktif `#cgo` digunakan untuk menentukan flag kompilasi atau penghubung yang diperlukan untuk file C.
* `#cgo CFLAGS` dan `#cgo LDFLAGS` digunakan untuk menyesuaikan pengaturan kompilasi ketika Go menggunakan C melalui Cgo..

## 11. Garbage Collection

Garbage Collection (GC) adalah mekanisme otomatis dalam bahasa pemrograman untuk mengelola memori dengan cara membersihkan objek yang tidak lagi digunakan (tidak dapat dijangkau oleh kode program). Dalam Go, garbage collection memungkinkan pengelolaan memori otomatis sehingga pengembang tidak perlu khawatir tentang pengalokasian dan pembebasan memori secara eksplisit, yang mengurangi potensi kebocoran memori.

### 1. Apa itu Garbage Collection (GC)?

Garbage Collection adalah proses di mana sistem secara otomatis mengidentifikasi dan menghapus objek yang tidak lagi digunakan, untuk membebaskan ruang memori. Di Go, GC berfungsi untuk menjaga agar program tidak menggunakan lebih banyak memori daripada yang diperlukan dengan menghapus objek-objek yang tidak bisa diakses lagi.

GC memungkinkan Go untuk menangani memori tanpa perlu intervensi manual seperti yang diperlukan dalam bahasa lain (misalnya, C dan C++). Hal ini mengurangi kemungkinan kesalahan seperti *memory leaks* dan  *dangling pointers* .

### 2. Cara Kerja Garbage Collection di Go

Garbage Collection di Go dilakukan dengan algoritma yang berfokus pada *mark-and-sweep* dan *tracing* untuk mencari objek yang tidak lagi digunakan. Berikut adalah langkah-langkah dasar bagaimana GC bekerja di Go:

* Marking Phase : GC memulai dengan menandai semua objek yang masih bisa dijangkau dari akar (roots) program, seperti variabel global, objek yang sedang digunakan, dan objek yang terhubung melalui pointer.
* Sweeping Phase : Setelah objek yang masih digunakan ditandai, GC kemudian menghapus objek-objek yang tidak ditandai (artinya objek-objek ini tidak dapat diakses lagi), membebaskan memori yang mereka gunakan.

Proses ini berlangsung secara terus menerus di latar belakang saat program berjalan. Go menggunakan generasi yang disebut dengan *generational garbage collection* untuk meningkatkan efisiensi, di mana objek yang lebih lama lebih jarang diperiksa dibandingkan objek yang lebih muda.

### 3. Memahami GC Latency Modes

Go 1.5 dan versi setelahnya menggunakan algoritma  *concurrent garbage collection* , yang berarti bahwa GC dapat berjalan bersamaan dengan program utama tanpa menyebabkan penghentian yang panjang. Ada beberapa mode latensi yang digunakan oleh Go GC untuk mengoptimalkan latensi.

* GC Pause Time : Ini adalah waktu yang dihabiskan oleh GC untuk menghentikan aplikasi sementara untuk mengidentifikasi dan membersihkan objek yang tidak digunakan. Latensi dapat berbeda tergantung pada pengaturan dan cara GC mengelola proses ini.
* Low Latency Mode : Dalam mode ini, GC dioptimalkan untuk meminimalkan waktu yang dihabiskan untuk pause (terutama dalam aplikasi real-time). Meskipun demikian, mode ini bisa menyebabkan beban lebih tinggi di CPU.
* Normal Mode : Mode standar yang memberikan keseimbangan antara waktu pause dan penggunaan sumber daya.
* Adaptive GC : Mode ini memungkinkan Go untuk menyesuaikan perilaku GC berdasarkan pola alokasi memori dari program.

### 4. Optimasi Memory di Go

Meskipun Go menangani banyak hal terkait memori melalui GC, pengembang dapat melakukan beberapa hal untuk mengoptimalkan penggunaan memori dan memperbaiki kinerja aplikasi:

* Menggunakan `sync.Pool` :
* `sync.Pool` adalah kumpulan objek yang dapat digunakan kembali, yang berguna untuk menghindari alokasi objek yang terlalu sering. Ini sangat berguna untuk objek-objek yang memiliki siklus hidup pendek.

  Contoh penggunaan `sync.Pool`:

```go
  package main

  import (
      "fmt"
      "sync"
  )

  func main() {
      var pool = sync.Pool{
          New: func() interface{} {
              return make([]byte, 1024) // Buat buffer byte baru
          },
      }

      // Ambil objek dari pool
      buffer := pool.Get().([]byte)
      fmt.Println(len(buffer))

      // Kembalikan objek ke pool setelah selesai digunakan
      pool.Put(buffer)
  }
```

  Penjelasan:

* `sync.Pool` memungkinkan kita untuk mengelola objek yang digunakan berulang kali tanpa perlu mengalokasikan ulang memori setiap kali objek tersebut dibutuhkan.
* Menjaga Jangkauan Objek Semaksimal Mungkin :
* Meminimalisir penggunaan pointer yang tidak diperlukan dapat membantu menghindari alokasi memori berlebihan dan mengurangi beban GC.
* Meminimalkan Alokasi Memori yang Tidak Perlu :
* Hindari alokasi memori yang tidak perlu atau berlebihan dalam loop atau fungsi yang dipanggil berulang kali.
* Menggunakan Profiling Memori :
* Go menyediakan alat untuk melakukan profiling memori, seperti `pprof`, untuk mengidentifikasi titik-titik di mana alokasi memori tinggi dan mengoptimalkan kodenya.

  Contoh penggunaan `pprof`:

```go
  import (
      "net/http"
      _ "net/http/pprof"
  )

  go func() {
      log.Println(http.ListenAndServe("localhost:6060", nil))
  }()
```

  Dengan profil memori, Anda dapat menganalisis penggunaan memori di aplikasi Go dan mengetahui apakah ada kebocoran memori atau alokasi yang tidak efisien.
