# # Swift Programming Language

**Swift** adalah bahasa pemrograman yang kuat dan intuitif yang dibuat oleh Apple untuk membangun aplikasi untuk iOS, Mac, Apple TV, dan Apple Watch. Swift dirancang untuk memberikan lebih banyak kebebasan kepada pengembang. Swift mudah digunakan dan bersifat open source, jadi siapa pun yang punya ide bisa menciptakan sesuatu yang luar biasa.

> Sumber: Apple

**Alasan-alasan Kenapa Menggunakan Swift:**

* Dirancang untuk keamanan
* Cepat dan kuat
* Dukungan ekosistem Apple yang besar
* Sintaks yang ekspresif dan modern

**Karakteristik Swift:**

- **Ekstensi File**: Swift menggunakan ekstensi file `.swift`
- **Statically typed**: Swift adalah bahasa yang statically typed.
- **Type inference**: Swift mendukung type inference.
- **Paradigma**: Swift mendukung beberapa paradigma, termasuk Object-Oriented, Functional, dan Imperative.
- **Manajemen Memori**: Swift menggunakan Automatic Reference Counting (ARC).

**Komentar**:

Komentar dalam Swift dapat ditambahkan menggunakan `//` untuk komentar satu baris dan `/* */` untuk komentar multi-baris.

```swift
// Ini adalah contoh komentar satu baris

/*
Ini adalah contoh komentar
banyak baris.
*/
```

## Installation

**Environment yang dibutuhkan:**

- **Xcode**: [https://developer.apple.com/xcode/](https://developer.apple.com/xcode/)
- **Swift.org**: [https://www.swift.org/download/](https://www.swift.org/download/)

## Aturan dan Penamaan Sintaks

> ⚠️ Catatan: Swift adalah case-sensitive.

**Penamaan File**

- **Do**: `FileName.swift`
- **Avoid**: `file_name.swift`

**Standard Library**


| Standard Library | Deskripsi                                            |
| ------------------ | ------------------------------------------------------ |
| Foundation       | Layanan dasar, tipe data, dan fungsionalitas OS.     |
| SwiftUI          | Framework UI deklaratif untuk semua platform Apple.  |
| Combine          | Framework untuk memproses nilai dari waktu ke waktu. |

**Libraries & Frameworks**


| Kategori   | Library/Framework   | Deskripsi                               |
| ------------ | --------------------- | ----------------------------------------- |
| Web App    | Vapor, Kitura       | Framework untuk membangun aplikasi web. |
| Mobile App | UIKit, SwiftUI      | Framework untuk aplikasi iOS.           |
| Database   | Core Data, Realm    | Solusi untuk persistensi data.          |
| Game       | SpriteKit, SceneKit | Framework untuk pengembangan game.      |

# 0. Introduction

**Swift** adalah bahasa pemrograman yang kuat dan intuitif yang dibuat oleh Apple untuk membangun aplikasi untuk iOS, Mac, Apple TV, dan Apple Watch. Swift dirancang untuk memberikan lebih banyak kebebasan kepada pengembang. Swift mudah digunakan dan bersifat open source, jadi siapa pun yang punya ide bisa menciptakan sesuatu yang luar biasa.

> Sumber: Apple

**Alasan-alasan Kenapa Menggunakan Swift:**

* Dirancang untuk keamanan
* Cepat dan kuat
* Dukungan ekosistem Apple yang besar
* Sintaks yang ekspresif dan modern

**Karakteristik Swift:**

- **Ekstensi File**: Swift menggunakan ekstensi file `.swift`
- **Statically typed**: Swift adalah bahasa yang statically typed.
- **Type inference**: Swift mendukung type inference.
- **Paradigma**: Swift mendukung beberapa paradigma, termasuk Object-Oriented, Functional, dan Imperative.
- **Manajemen Memori**: Swift menggunakan Automatic Reference Counting (ARC).

**Komentar**:

Komentar dalam Swift dapat ditambahkan menggunakan `//` untuk komentar satu baris dan `/* */` untuk komentar multi-baris.

```swift
// Ini adalah contoh komentar satu baris

/*
Ini adalah contoh komentar
banyak baris.
*/
```

## Installation

**Environment yang dibutuhkan:**

- **Xcode**: [https://developer.apple.com/xcode/](https://developer.apple.com/xcode/)
- **Swift.org**: [https://www.swift.org/download/](https://www.swift.org/download/)

## Aturan dan Penamaan Sintaks

> ⚠️ Catatan: Swift adalah case-sensitive.

**Penamaan File**

- **Do**: `FileName.swift`
- **Avoid**: `file_name.swift`

## Primitif vs Objek

Perlakuan terhadap tipe data `String` menunjukkan perbedaan filosofi yang menarik antara Swift, Java, dan C#.

* **C#** : Tipe data dasar seperti `int`, `double`, `bool`, dan `string` adalah **primitif** dan disimpan di **stack** . Ada juga **object wrapper** untuk tipe data ini, yang disimpan di **heap** , sehingga bisa diperlakukan seperti objek ketika perlu.
* **Java** : Beberapa tipe data, seperti `String`, adalah **object** . Tipe primitif (`int`, `double`, dll.) bisa dibungkus menjadi **wrapper class** untuk diperlakukan sebagai object. Hampir semua tipe bisa diakses sebagai object jika dibutuhkan.

* **Swift**: Swift mengambil pendekatan yang berbeda. Di Swift, `String` adalah sebuah **struct**, yang merupakan *value type*. Ini adalah perbedaan kunci. Tidak seperti *reference type* (class), *value type* disalin ketika dioper ke fungsi atau di-assign ke variabel baru. Ini memberikan keamanan dan prediktabilitas yang lebih besar, karena tidak ada dua variabel yang secara tidak sengaja menunjuk (dan mengubah) data yang sama. Swift tidak benar-benar memiliki konsep "primitif" dalam artian tradisional; tipe data dasar seperti `Int`, `Double`, dan `Bool` juga diimplementasikan sebagai `struct` dengan properti dan metode, memberikan kekuatan objek dengan efisiensi *value type*.

Singkatnya, sementara Java dan C# memperlakukan `String` sebagai objek (reference type), Swift memperlakukannya sebagai *value type* (struct), yang sejalan dengan filosofi desainnya yang mengutamakan keamanan dan kejelasan.

**Standard Library**


| Standard Library | Deskripsi                                            |
| ------------------ | ------------------------------------------------------ |
| Foundation       | Layanan dasar, tipe data, dan fungsionalitas OS.     |
| SwiftUI          | Framework UI deklaratif untuk semua platform Apple.  |
| Combine          | Framework untuk memproses nilai dari waktu ke waktu. |

**Libraries & Frameworks**


| Kategori   | Library/Framework   | Deskripsi                               |
| ------------ | --------------------- | ----------------------------------------- |
| Web App    | Vapor, Kitura       | Framework untuk membangun aplikasi web. |
| Mobile App | UIKit, SwiftUI      | Framework untuk aplikasi iOS.           |
| Database   | Core Data, Realm    | Solusi untuk persistensi data.          |
| Game       | SpriteKit, SceneKit | Framework untuk pengembangan game.      |

# 1. Basic

## 1.1 The Basics

Swift adalah bahasa yang aman tipe. Bahasa yang aman tipe mendorong Anda untuk jelas tentang jenis nilai yang dapat dikerjakan oleh kode Anda. Jika bagian dari kode Anda mengharapkan `String`, Anda tidak dapat secara tidak sengaja meneruskannya `Int`.

Karena Swift aman tipe, ia melakukan pemeriksaan tipe saat mengompilasi kode Anda dan menandai setiap jenis yang tidak cocok sebagai kesalahan. Ini memungkinkan Anda untuk menangkap dan memperbaiki kesalahan sedini mungkin dalam proses pengembangan.

### 1.1.1 Constants and Variables

Di Swift, Anda mendeklarasikan konstanta dengan kata kunci `let` dan variabel dengan kata kunci `var`.

```swift
let maximumNumberOfLoginAttempts = 10
var currentLoginAttempt = 0
```

### 1.1.2 Type Annotations

Anda dapat memberikan anotasi tipe saat Anda mendeklarasikan konstanta atau variabel, untuk memperjelas jenis nilai yang dapat disimpan.

```swift
var welcomeMessage: String
welcomeMessage = "Hello"
```

### 1.1.3 Semicolons

Swift tidak mengharuskan Anda menulis titik koma (`;`) setelah setiap pernyataan dalam kode Anda, meskipun Anda dapat melakukannya jika Anda mau. Namun, titik koma diperlukan jika Anda ingin menulis beberapa pernyataan terpisah pada satu baris.

```swift
let cat = "🐱"; print(cat)
// Prints "🐱"
```

## 1.2 Basic Operators

### 1.2.1 Terminology

Operator adalah unary, binary, atau ternary:

* **Unary operators** beroperasi pada satu target (seperti `-a`). Operator unary prefix muncul tepat sebelum target mereka (seperti `!b`), dan operator unary postfix muncul tepat setelah target mereka (seperti `c!`).
* **Binary operators** beroperasi pada dua target (seperti `2 + 3`) dan bersifat infix karena muncul di antara kedua target mereka.
* **Ternary operators** beroperasi pada tiga target. Seperti C, Swift hanya memiliki satu operator ternary, yaitu operator kondisional ternary (`a ? b : c`).

### 1.2.2 Assignment Operator

Operator penugasan (`a = b`) menginisialisasi atau memperbarui nilai `a` dengan nilai `b`:

```swift
let b = 10
var a = 5
a = b
// a is now 10
```

### 1.2.3 Arithmetic Operators

Swift mendukung empat operator aritmatika standar untuk semua jenis angka:

* Penjumlahan (`+`)
* Pengurangan (`-`)
* Perkalian (`*`)
* Pembagian (`/`)

```swift
1 + 2       // equals 3
5 - 3       // equals 2
2 * 3       // equals 6
10.0 / 2.5  // equals 4.0
```

### 1.2.4 Compound Assignment Operators

Seperti C, Swift menyediakan operator penugasan majemuk yang menggabungkan penugasan (`=`) dengan operasi lain. Salah satu contohnya adalah operator penugasan penjumlahan (`+=`):

```swift
var a = 1
a += 2
// a is now 3
```

### 1.2.5 Comparison Operators

Swift mendukung semua operator perbandingan standar C:

* Sama dengan (`a == b`)
* Tidak sama dengan (`a != b`)
* Lebih besar dari (`a > b`)
* Kurang dari (`a < b`)
* Lebih besar dari atau sama dengan (`a >= b`)
* Kurang dari atau sama dengan (`a <= b`)

### 1.2.6 Ternary Conditional Operator

Operator kondisional ternary adalah operator khusus dengan tiga bagian, yang berbentuk `question ? answer1 : answer2`.

```swift
let contentHeight = 40
let hasHeader = true
let rowHeight = contentHeight + (hasHeader ? 50 : 20)
// rowHeight is equal to 90
```

### 1.2.7 Nil-Coalescing Operator

Operator nil-coalescing (`a ?? b`) membongkar opsional `a` jika berisi nilai, atau mengembalikan nilai default `b` jika `a` adalah `nil`.

```swift
let defaultColorName = "red"
var userDefinedColorName: String?   // defaults to nil

var colorNameToUse = userDefinedColorName ?? defaultColorName
// userDefinedColorName is nil, so colorNameToUse is set to the default of "red"
```

### 1.2.8 Range Operators

Swift mencakup beberapa operator rentang, yang merupakan pintasan untuk mengekspresikan rentang nilai.

* **Closed Range Operator** (`a...b`) mendefinisikan rentang yang berjalan dari `a` ke `b`, dan termasuk nilai `a` dan `b`.
* **Half-Open Range Operator** (`a..<b`) mendefinisikan rentang yang berjalan dari `a` ke `b`, tetapi tidak termasuk `b`.
* **One-Sided Ranges** (`a...` atau `...b`) rentang yang berlanjut sejauh mungkin dalam satu arah.

### 1.2.9 Logical Operators

Operator logika memodifikasi atau menggabungkan nilai logika Boolean `true` dan `false`.

* Logical NOT (`!a`)
* Logical AND (`a && b`)
* Logical OR (`a || b`)

## 1.3 Data Types

Swift menawarkan berbagai macam tipe data dasar dan koleksi. Berikut adalah beberapa yang paling umum digunakan:

### 1.3.1 Numeric Types

* **Int**: Tipe data default untuk bilangan bulat (angka tanpa komponen pecahan). Ukurannya tergantung pada platform (32-bit atau 64-bit).
* **UInt**: Tipe data untuk bilangan bulat tanpa tanda (hanya positif).
* **Double**: Tipe data untuk angka floating-point 64-bit. Ini adalah tipe data default untuk angka desimal dan menawarkan presisi tinggi.
* **Float**: Tipe data untuk angka floating-point 32-bit. Digunakan saat presisi yang lebih rendah dapat diterima.

```swift
let integer: Int = -10
let unsignedInteger: UInt = 20
let double: Double = 3.14159
let float: Float = 3.14159
```

### 1.3.2 Booleans

Swift memiliki tipe data Boolean dasar, yang disebut `Bool`. Tipe Boolean direferensikan sebagai *logical*, karena hanya dapat berupa `true` atau `false`.

```swift
let orangesAreOrange = true
let turnipsAreDelicious = false
```

### 1.3.3 Tuples

Tuple mengelompokkan beberapa nilai menjadi satu nilai majemuk. Nilai-nilai dalam tuple dapat berupa tipe apa pun dan tidak harus sama satu sama lain.

```swift
let http404Error = (404, "Not Found")
// http404Error is of type (Int, String), and equals (404, "Not Found")
```

### 1.3.4 Optionals

Anda menggunakan opsional dalam situasi di mana nilai mungkin tidak ada. Opsional mewakili dua kemungkinan: Entah ada nilai, dan Anda dapat membuka bungkus opsional untuk mengakses nilai itu, atau tidak ada nilai sama sekali.

```swift
let possibleNumber = "123"
let convertedNumber = Int(possibleNumber)
// convertedNumber is inferred to be of type "Int?", or "optional Int"
```

### 1.3.6 Void

`Void` adalah nama lain untuk tipe tuple kosong, `()`. Anda dapat menggunakannya sebagai tipe kembalian untuk fungsi yang tidak mengembalikan nilai.

```swift
func doNothing() -> Void {
    // this function does not return a value
}
```

### 1.3.7 Any and AnyObject

* **Any**: Dapat mewakili instance dari tipe apa pun, termasuk tipe fungsi.
* **AnyObject**: Dapat mewakili instance dari kelas apa pun.

## 1.4 Strings and Characters

### 1.4.1 String Literals

Anda dapat menyertakan nilai string yang telah ditentukan sebelumnya dalam kode Anda sebagai literal string. Literal string adalah urutan karakter yang dikelilingi oleh tanda kutip ganda (`"`).

```swift
let someString = "Some string literal value"
```

### 1.4.2 Initializing an Empty String

Untuk membuat nilai `String` kosong sebagai titik awal, tetapkan literal string kosong ke variabel, atau inisialisasi objek `String` baru dengan sintaksis initializer.

```swift
var emptyString = ""
var anotherEmptyString = String()
// these two strings are both empty, and are equivalent to each other
```

### 1.4.3 String Mutability

Anda menunjukkan apakah `String` tertentu dapat dimodifikasi (atau *mutable*) dengan menetapkannya ke variabel (dalam hal ini dapat dimodifikasi), atau ke konstanta (dalam hal ini tidak dapat dimodifikasi).

```swift
var variableString = "Horse"
variableString += " and carriage"
// variableString is now "Horse and carriage"

let constantString = "Highlander"
constantString += " and another Highlander"
// this reports a compile-time error - a constant string cannot be modified
```

### 1.4.4 Working with Characters

Anda dapat mengakses nilai `Character` individual dari sebuah `String` dengan mengulanginya dengan loop `for-in`:

```swift
for character in "Dog!🐶" {
    print(character)
}
// D
// o
// g
// !
// 🐶
```

### 1.4.5 Concatenating Strings and Characters

Nilai string dapat ditambahkan bersama (atau digabungkan) dengan operator penjumlahan (`+`) untuk membuat string baru:

```swift
let string1 = "hello"
let string2 = " there"
var welcome = string1 + string2
// welcome now equals "hello there"
```

### 1.4.6 String Interpolation

Interpolasi string adalah cara untuk membuat `String` baru dari campuran konstanta, variabel, literal, dan ekspresi dengan menyertakan nilainya di dalam literal string.

```swift
let multiplier = 3
let message = "\(multiplier) times 2.5 is \(Double(multiplier) * 2.5)"
// message is "3 times 2.5 is 7.5"
```

## 1.5 Collection Types

### 1.5.1 Mutability of Collections

Jika Anda membuat array, set, atau kamus dan menetapkannya ke variabel, koleksi yang dibuat akan dapat diubah. Ini berarti Anda dapat mengubah (atau *mutate*) koleksi setelah dibuat dengan menambahkan, menghapus, atau mengubah item dalam koleksi.

### 1.5.2 Arrays

Array adalah kumpulan nilai yang terurut. Array dapat menyimpan nilai duplikat.

```swift
var shoppingList: [String] = ["Eggs", "Milk"]
```

### 1.5.3 Sets

Set adalah kumpulan nilai unik yang tidak terurut. Gunakan set alih-alih array saat urutan item tidak penting, atau saat Anda perlu memastikan bahwa item hanya muncul sekali.

```swift
var letters = Set<Character>()
```

### 1.5.4 Dictionaries

Dictionary adalah kumpulan pasangan kunci-nilai yang tidak terurut. Setiap nilai dikaitkan dengan kunci unik, yang bertindak sebagai pengidentifikasi untuk nilai itu di dalam kamus.

```swift
var namesOfIntegers: [Int: String] = [:]
```

# 2. Control Flow

## 2.1 For-In Loops

Anda menggunakan loop `for-in` untuk mengulang urutan, seperti item dalam larik, rentang angka, atau karakter dalam string.

```swift
let names = ["Anna", "Alex", "Brian", "Jack"]
for name in names {
    print("Hello, \(name)!")
}
// Hello, Anna!
// Hello, Alex!
// Hello, Brian!
// Hello, Jack!
```

## 2.2 While Loops

Loop `while` melakukan serangkaian pernyataan hingga suatu kondisi menjadi `false`. Loop semacam ini paling baik digunakan saat jumlah iterasi tidak diketahui sebelum iterasi pertama dimulai.

```swift
while condition {
   statements
}
```

## 2.3 Conditional Statements

### 2.3.1 If

Dalam bentuknya yang paling sederhana, pernyataan `if` memiliki satu kondisi `if`. Ia menjalankan serangkaian pernyataan hanya jika kondisi itu `true`.

```swift
var temperatureInFahrenheit = 30
if temperatureInFahrenheit <= 32 {
    print("It's very cold. Consider wearing a scarf.")
}
// Prints "It's very cold. Consider wearing a scarf."
```

### 2.3.2 Switch

Pernyataan `switch` mempertimbangkan suatu nilai dan membandingkannya dengan beberapa kemungkinan pola yang cocok. Ia kemudian menjalankan blok kode yang sesuai, berdasarkan pola pertama yang berhasil dicocokkan.

```swift
let someCharacter: Character = "z"
switch someCharacter {
case "a":
    print("The first letter of the alphabet")
case "z":
    print("The last letter of the alphabet")
default:
    print("Some other character")
}
// Prints "The last letter of the alphabet"
```

## 2.4 Control Transfer Statements

Pernyataan transfer kontrol mengubah urutan eksekusi kode Anda, dengan mentransfer kontrol dari satu bagian kode ke bagian lain.

### 2.4.1 Continue

Pernyataan `continue` memberi tahu sebuah loop untuk berhenti melakukan apa yang dilakukannya dan memulai lagi di awal iterasi berikutnya melalui loop.

### 2.4.2 Break

Pernyataan `break` mengakhiri eksekusi seluruh pernyataan kontrol aliran dengan segera.

### 2.4.3 Fallthrough

Dalam Swift, pernyataan `switch` tidak jatuh melalui bagian bawah setiap kasus dan ke yang berikutnya. Sebaliknya, seluruh pernyataan `switch` menyelesaikan eksekusinya segera setelah kasus pertama yang cocok selesai. Sebaliknya, Anda dapat menggunakan kata kunci `fallthrough` untuk sengaja jatuh ke kasus berikutnya.

### 2.4.4 Labeled Statements

Anda dapat menandai pernyataan loop atau pernyataan kondisional dengan label pernyataan. Dalam pernyataan `if`, Anda dapat menggunakan label dengan pernyataan `break` untuk mengakhiri pernyataan `if` yang diberi label. Dalam pernyataan `loop`, Anda dapat menggunakan label dengan pernyataan `break` atau `continue` untuk mengakhiri atau melanjutkan eksekusi pernyataan loop yang diberi label.

# 3. Functions

## 3.1 Defining and Calling Functions

Saat Anda mendefinisikan sebuah fungsi, Anda dapat secara opsional mendefinisikan satu atau lebih nilai bernama yang dapat diterima oleh fungsi sebagai masukan, yang dikenal sebagai *parameter*. Anda juga dapat secara opsional mendefinisikan tipe nilai yang akan dikembalikan oleh fungsi sebagai keluaran saat fungsi selesai, yang dikenal sebagai *tipe kembalian*.

```swift
func greet(person: String) -> String {
    let greeting = "Hello, " + person + "!"
    return greeting
}

print(greet(person: "Anna"))
// Prints "Hello, Anna!"
```

## 3.2 Function Parameters and Return Values

Parameter fungsi dan nilai kembalian sangat fleksibel di Swift. Anda dapat mendefinisikan apa pun mulai dari fungsi utilitas sederhana dengan satu parameter tanpa nama hingga fungsi kompleks dengan nama parameter ekspresif dan opsi parameter yang berbeda.

Fungsi dapat mengembalikan beberapa nilai sebagai bagian dari sebuah tuple.

```swift
func minMax(array: [Int]) -> (min: Int, max: Int) {
    var currentMin = array[0]
    var currentMax = array[0]
    for value in array[1..<array.count] {
        if value < currentMin {
            currentMin = value
        } else if value > currentMax {
            currentMax = value
        }
    }
    return (currentMin, currentMax)
}
```

## 3.3 Function Argument Labels and Parameter Names

Setiap parameter fungsi memiliki *label argumen* dan *nama parameter*. Label argumen digunakan saat memanggil fungsi; setiap argumen ditulis dalam pemanggilan fungsi dengan label argumennya di depannya. Nama parameter digunakan dalam implementasi fungsi. Secara default, parameter menggunakan nama parameternya sebagai label argumennya.

```swift
func someFunction(argumentLabel parameterName: Int) {
    // In the function body, parameterName refers to the argument value
    // for that parameter.
}
```

## 3.4 Function Types

Setiap fungsi memiliki *tipe fungsi* tertentu, yang terdiri dari tipe parameter dan tipe kembalian fungsi. Anda dapat menggunakan tipe ini seperti tipe lainnya di Swift, yang memudahkan untuk meneruskan fungsi sebagai parameter ke fungsi lain, dan untuk mengembalikan fungsi dari fungsi.

```swift
func addTwoInts(_ a: Int, _ b: Int) -> Int {
    return a + b
}
var mathFunction: (Int, Int) -> Int = addTwoInts
```

## 3.5 Nested Functions

Fungsi yang Anda definisikan sejauh ini dalam bab ini semuanya adalah contoh dari *fungsi global*, yang didefinisikan pada lingkup global. Anda juga dapat mendefinisikan fungsi di dalam badan fungsi lain, yang dikenal sebagai *fungsi bersarang*.

```swift
func chooseStepFunction(backward: Bool) -> (Int) -> Int {
    func stepForward(input: Int) -> Int { return input + 1 }
    func stepBackward(input: Int) -> Int { return input - 1 }
    return backward ? stepBackward : stepForward
}
```

# 4. Closures

Closures adalah blok fungsionalitas mandiri yang dapat diteruskan dan digunakan dalam kode Anda. Closure dapat menangkap dan menyimpan referensi ke konstanta dan variabel apa pun dari konteks di mana mereka didefinisikan. Ini dikenal sebagai *closing over* konstanta dan variabel tersebut. Swift menangani semua manajemen memori untuk menangkap untuk Anda.

## 4.1 Closure Expressions

Ekspresi closure adalah cara untuk menulis closure inline dalam sintaks yang ringkas. Ekspresi closure menyediakan beberapa pengoptimalan sintaks:

* Menyimpulkan tipe parameter dan nilai kembalian dari konteks
* Pengembalian implisit dari closure ekspresi tunggal
* Nama argumen singkatan
* Sintaks closure Trailing

```swift
let names = ["Chris", "Alex", "Ewa", "Barry", "Daniella"]
var reversedNames = names.sorted(by: { (s1: String, s2: String) -> Bool in
    return s1 > s2
})
```

## 4.2 Trailing Closures

Jika Anda perlu meneruskan closure ke sebuah fungsi sebagai argumen terakhir fungsi, dan ekspresi closure panjang, akan berguna untuk menuliskannya sebagai *trailing closure*.

```swift
func someFunctionThatTakesAClosure(closure: () -> Void) {
    // function body goes here
}

// Here's how you call this function without using a trailing closure:
someFunctionThatTakesAClosure(closure: {
    // closure's body goes here
})

// Here's how you call this function with a trailing closure instead:
someFunctionThatTakesAClosure() {
    // trailing closure's body goes here
}
```

## 4.3 Capturing Values

Sebuah closure dapat *menangkap* konstanta dan variabel dari konteks di sekitarnya di mana ia didefinisikan. Closure kemudian dapat merujuk dan memodifikasi nilai-nilai konstanta dan variabel tersebut dari dalam tubuhnya, bahkan jika lingkup asli yang mendefinisikan konstanta dan variabel tidak ada lagi.

```swift
func makeIncrementer(forIncrement amount: Int) -> () -> Int {
    var runningTotal = 0
    func incrementer() -> Int {
        runningTotal += amount
        return runningTotal
    }
    return incrementer
}
```

## 4.4 Escaping Closures

Sebuah closure dikatakan *escape* dari sebuah fungsi ketika closure tersebut diteruskan sebagai argumen ke fungsi, tetapi dipanggil setelah fungsi kembali. Saat Anda mendeklarasikan fungsi yang mengambil closure sebagai salah satu parameternya, Anda dapat menulis `@escaping` sebelum tipe parameter untuk menunjukkan bahwa closure diizinkan untuk escape.

```swift
var completionHandlers: [() -> Void] = []
func someFunctionWithEscapingClosure(completionHandler: @escaping () -> Void) {
    completionHandlers.append(completionHandler)
}
```

## 4.5 Autoclosures

*Autoclosure* adalah closure yang secara otomatis dibuat untuk membungkus ekspresi yang diteruskan sebagai argumen ke sebuah fungsi. Itu tidak mengambil argumen apa pun, dan ketika dipanggil, ia mengembalikan nilai ekspresi yang dibungkus di dalamnya.

```swift
var customersInLine = ["Chris", "Alex", "Ewa", "Barry", "Daniella"]

let customerProvider = { customersInLine.remove(at: 0) }
print("Now serving \(customerProvider())!")
// Prints "Now serving Chris!"
```

# 5. Enumerations

Enumerasi mendefinisikan tipe umum untuk sekelompok nilai terkait dan memungkinkan Anda untuk bekerja dengan nilai-nilai tersebut dengan cara yang aman tipe dalam kode Anda.

```swift
// Deklarasi enum
enum Direction {
    case north
    case south
    case east
    case west
}

// Akses secara implisit
let dir1: Direction = .north  // tidak perlu tulis 'Direction.north'

// Akses secara eksplisit
let dir2: Direction = Direction.south

```

## 5.1 Enumeration Syntax

Anda memperkenalkan enumerasi dengan kata kunci `enum` dan menempatkan seluruh definisinya dalam sepasang kurung kurawal:

```swift
enum SomeEnumeration {
    // enumeration definition goes here
}
```

Berikut adalah contoh untuk titik-titik kompas:

```swift
enum CompassPoint {
    case north
    case south
    case east
    case west
}
```

## 5.2 Matching Enumeration Values with a Switch Statement

Anda dapat mencocokkan nilai enumerasi individual dengan pernyataan `switch`:

```swift
directionToHead = .south
switch directionToHead {
case .north:
    print("Lots of planets have a north")
case .south:
    print("Watch out for penguins")
case .east:
    print("Where the sun rises")
case .west:
    print("Where the skies are blue")
}
// Prints "Watch out for penguins"
```

## 5.3 Associated Values

Anda dapat mendefinisikan enumerasi Swift untuk menyimpan nilai terkait dari jenis apa pun, dan jenis nilai dapat berbeda untuk setiap kasus enumerasi jika Anda perlu.

```swift
enum Barcode {
    case upc(Int, Int, Int, Int)
    case qrCode(String)
}

var productBarcode = Barcode.upc(8, 85909, 51226, 3)
```

## 5.4 Raw Values

Sebagai alternatif untuk nilai terkait, kasus enumerasi dapat diisi sebelumnya dengan nilai default (disebut *raw values*), yang semuanya memiliki tipe yang sama.

```swift
enum ASCIIControlCharacter: Character {
    case tab = "\t"
    case lineFeed = "\n"
    case carriageReturn = "\r"
}
```

# 6. Structures and Classes

Struktur dan kelas adalah blok bangunan kode Anda. Keduanya memungkinkan Anda untuk mendefinisikan properti untuk menyimpan nilai dan metode untuk menyediakan fungsionalitas.

## 6.1 Definition Syntax

Struktur dan kelas memiliki sintaks definisi yang serupa. Anda memperkenalkan struktur dengan kata kunci `struct` dan kelas dengan kata kunci `class`. Keduanya menempatkan seluruh definisinya dalam sepasang kurung kurawal:

```swift
struct Resolution {
    var width = 0
    var height = 0
}
class VideoMode {
    var resolution = Resolution()
    var interlaced = false
    var frameRate = 0.0
    var name: String?
}
```

## 6.2 Structures and Classes Instances

Sintaks untuk membuat instance dari struktur dan kelas sangat mirip:

```swift
let someResolution = Resolution()
let someVideoMode = VideoMode()
```

## 6.3 Accessing Properties

Anda dapat mengakses properti instance menggunakan sintaks titik.

```swift
print("The width of someResolution is \(someResolution.width)")
// Prints "The width of someResolution is 0"
```

## 6.4 Memberwise Initializers for Structure Types

Semua struktur memiliki *memberwise initializer* yang dibuat secara otomatis, yang dapat Anda gunakan untuk menginisialisasi properti anggota dari instance struktur baru.

```swift
let vga = Resolution(width: 640, height: 480)
```

## 6.5 Structures and Enumerations Are Value Types

*Tipe nilai* adalah tipe yang nilainya disalin saat ditetapkan ke variabel atau konstanta, atau saat diteruskan ke suatu fungsi.

```swift
let hd = Resolution(width: 1920, height: 1080)
var cinema = hd
cinema.width = 2048

print("cinema is now \(cinema.width) pixels wide")
// Prints "cinema is now 2048 pixels wide"

print("hd is still \(hd.width) pixels wide")
// Prints "hd is still 1920 pixels wide"
```

## 6.6 Classes Are Reference Types

Tidak seperti tipe nilai, *tipe referensi* tidak disalin saat ditetapkan ke variabel atau konstanta, atau saat diteruskan ke suatu fungsi. Sebaliknya, referensi ke instance yang sama yang ada digunakan.

```swift
let tenEighty = VideoMode()
tenEighty.resolution = hd
tenEighty.interlaced = true
tenEighty.name = "1080i"
tenEighty.frameRate = 25.0

let alsoTenEighty = tenEighty
alsoTenEighty.frameRate = 30.0

print("The frameRate property of tenEighty is now \(tenEighty.frameRate)")
// Prints "The frameRate property of tenEighty is now 30.0"
```

# 7. Properties

Properti mengaitkan nilai dengan kelas, struktur, atau enumerasi tertentu. Properti yang disimpan menyimpan nilai konstanta dan variabel sebagai bagian dari instance, sedangkan properti yang dihitung menghitung (bukan menyimpan) nilai. Properti yang dihitung disediakan oleh kelas, struktur, dan enumerasi. Properti yang disimpan hanya disediakan oleh kelas dan struktur.

## 7.1 Stored Properties

Dalam bentuknya yang paling sederhana, properti yang disimpan adalah konstanta atau variabel yang disimpan sebagai bagian dari instance kelas atau struktur tertentu. Properti yang disimpan dapat berupa *properti yang disimpan variabel* (diperkenalkan dengan kata kunci `var`) atau *properti yang disimpan konstan* (diperkenalkan dengan kata kunci `let`).

```swift
struct FixedLengthRange {
    var firstValue: Int
    let length: Int
}
var rangeOfThreeItems = FixedLengthRange(firstValue: 0, length: 3)
// the range represents integer values 0, 1, and 2
rangeOfThreeItems.firstValue = 6
// the range now represents integer values 6, 7, and 8
```

## 7.2 Computed Properties

Selain properti yang disimpan, kelas, struktur, dan enumerasi dapat mendefinisikan *properti yang dihitung*, yang tidak benar-benar menyimpan nilai. Sebaliknya, mereka menyediakan pengambil dan pengatur opsional untuk mengambil dan mengatur properti dan nilai lain secara tidak langsung.

```swift
struct Point {
    var x = 0.0, y = 0.0
}
struct Size {
    var width = 0.0, height = 0.0
}
struct Rect {
    var origin = Point()
    var size = Size()
    var center: Point {
        get {
            let centerX = origin.x + (size.width / 2)
            let centerY = origin.y + (size.height / 2)
            return Point(x: centerX, y: centerY)
        }
        set(newCenter) {
            origin.x = newCenter.x - (size.width / 2)
            origin.y = newCenter.y - (size.height / 2)
        }
    }
}
```

## 7.3 Property Observers

Pengamat properti mengamati dan menanggapi perubahan nilai properti. Pengamat properti dipanggil setiap kali nilai properti diatur, bahkan jika nilai baru sama dengan nilai properti saat ini.

Anda dapat menambahkan pengamat properti ke properti tersimpan apa pun yang Anda definisikan, kecuali untuk properti tersimpan yang malas. Anda juga dapat menambahkan pengamat properti ke properti terhitung apa pun yang Anda warisi dengan menimpa properti di subkelas.

* `willSet` dipanggil tepat sebelum nilai disimpan.
* `didSet` dipanggil segera setelah nilai baru disimpan.

## 7.4 Property Wrappers

*Property wrapper* menambahkan lapisan pemisahan antara kode yang mengelola bagaimana properti disimpan dan kode yang mendefinisikan properti. Misalnya, jika Anda memiliki properti yang menyediakan thread-safety check atau menyimpan datanya dalam database, Anda harus menulis kode itu pada setiap properti. Saat Anda menggunakan property wrapper, Anda menulis kode manajemen sekali saat Anda mendefinisikan wrapper, lalu menggunakan kembali kode manajemen itu untuk banyak properti.

```swift
@propertyWrapper
struct TwelveOrLess {
    private var number = 0
    var wrappedValue: Int {
        get { return number }
        set { number = min(newValue, 12) }
    }
}
```

# 8. Methods

*Metode* adalah fungsi yang terkait dengan tipe tertentu. Kelas, struktur, dan enumerasi semuanya dapat mendefinisikan metode instance, yang merangkum tugas dan fungsionalitas spesifik untuk bekerja dengan instance dari suatu tipe. Kelas, struktur, dan enumerasi juga dapat mendefinisikan metode tipe, yang terkait dengan tipe itu sendiri. Metode tipe mirip dengan metode kelas di Objective-C.

## 8.1 Instance Methods

*Metode instance* adalah fungsi yang dimiliki oleh instance dari kelas, struktur, atau enumerasi tertentu. Mereka mendukung fungsionalitas instance tersebut, baik dengan menyediakan cara untuk mengakses dan memodifikasi properti instance, atau dengan menyediakan fungsionalitas yang terkait dengan tujuan instance. Metode instance memiliki sintaks yang persis sama dengan fungsi.

```swift
class Counter {
    var count = 0
    func increment() {
        count += 1
    }
    func increment(by amount: Int) {
        count += amount
    }
    func reset() {
        count = 0
    }
}
```

## 8.2 Type Methods

Metode instance, seperti yang dijelaskan di atas, adalah metode yang Anda panggil pada instance dari tipe tertentu. Anda juga dapat mendefinisikan metode yang dipanggil pada tipe itu sendiri. Jenis metode ini disebut *metode tipe*. Anda menunjukkan metode tipe dengan menulis kata kunci `static` sebelum kata kunci `func` metode. Kelas dapat menggunakan kata kunci `class` sebagai gantinya, untuk memungkinkan subkelas menimpa implementasi superkelas dari metode itu.

```swift
class SomeClass {
    static func someTypeMethod() {
        // type method implementation goes here
    }
}
SomeClass.someTypeMethod()
```

# 9. Subscripts

Kelas, struktur, dan enumerasi dapat mendefinisikan *subscript*, yang merupakan pintasan untuk mengakses anggota elemen koleksi, daftar, atau urutan. Anda menggunakan subskrip untuk mengatur dan mengambil nilai dengan indeks tanpa perlu metode terpisah untuk pengaturan dan pengambilan.

## 9.1 Subscript Syntax

Sintaks subskrip memungkinkan Anda untuk membuat kueri instance dari suatu tipe dengan menulis satu atau lebih nilai dalam tanda kurung siku setelah nama instance. Sintaksnya mirip dengan sintaks metode instance dan sintaks properti terhitung.

```swift
subscript(index: Int) -> Int {
    get {
        // Return an appropriate subscript value here.
    }
    set(newValue) {
        // Perform a suitable setting action here.
    }
}
```

## 9.2 Subscript Usage

Penggunaan subskrip yang tepat tergantung pada konteks di mana ia digunakan. Subskrip biasanya digunakan sebagai jalan pintas untuk mengakses elemen dalam koleksi, daftar, atau urutan. Anda bebas mengimplementasikan subskrip dengan cara yang paling sesuai untuk fungsionalitas kelas atau struktur khusus Anda.

```swift
let threeTimesTable = TimesTable(multiplier: 3)
print("six times three is \(threeTimesTable[6])")
// Prints "six times three is 18"
```

## 9.3 Subscript Options

Subskrip dapat mengambil sejumlah parameter masukan, dan parameter masukan ini dapat dari tipe apa pun. Subskrip juga dapat mengembalikan nilai dari tipe apa pun. Subskrip dapat menggunakan parameter variabel dan parameter variadik, tetapi tidak dapat menggunakan parameter masuk-keluar atau memberikan nilai parameter default.

Sebuah kelas atau struktur dapat menyediakan subskrip sebanyak yang dibutuhkannya, dan subskrip yang sesuai untuk digunakan akan disimpulkan berdasarkan jenis nilai indeks yang Anda berikan ke subskrip dalam tanda kurung siku pada titik di mana subskrip digunakan.

# 10. Inheritance

Sebuah kelas dapat *mewarisi* metode, properti, dan karakteristik lain dari kelas lain. Ketika satu kelas mewarisi dari kelas lain, kelas yang mewarisi dikenal sebagai *subkelas*, dan kelas yang diwarisinya dikenal sebagai *superkelas*.

## 10.1 Defining a Base Class

Setiap kelas yang tidak mewarisi dari kelas lain dikenal sebagai *kelas dasar*.

```swift
class Vehicle {
    var currentSpeed = 0.0
    var description: String {
        return "traveling at \(currentSpeed) miles per hour"
    }
    func makeNoise() {
        // do nothing - an arbitrary vehicle doesn't necessarily make a noise
    }
}
```

## 10.2 Subclassing

*Subclassing* adalah tindakan mendasarkan kelas baru pada kelas yang sudah ada. Subkelas mewarisi karakteristik dari kelas yang ada, yang kemudian dapat Anda sempurnakan. Anda juga dapat menambahkan karakteristik baru ke subkelas.

```swift
class Bicycle: Vehicle {
    var hasBasket = false
}
```

## 10.3 Overriding

Subkelas dapat menyediakan implementasi kustomnya sendiri dari metode instance, metode tipe, properti instance, properti tipe, atau subskrip yang seharusnya diwarisi dari superkelas. Ini dikenal sebagai *overriding*.

Untuk menimpa karakteristik yang seharusnya diwarisi, Anda mengawalinya dengan kata kunci `override`. Melakukannya mengklarifikasi bahwa Anda bermaksud untuk menyediakan penimpaan dan belum memberikan definisi yang cocok karena kesalahan.

## 10.4 Preventing Overrides

Anda dapat mencegah metode, properti, atau subskrip ditimpa dengan menandainya sebagai *final*. Lakukan ini dengan menulis kata kunci `final` sebelum kata kunci pengantar metode, properti, atau subskrip (`final var`, `final func`, `final class func`, dan `final subscript`).

# 11. Initialization

*Inisialisasi* adalah proses mempersiapkan instance dari kelas, struktur, atau enumerasi untuk digunakan. Proses ini melibatkan pengaturan nilai awal untuk setiap properti yang disimpan pada instance tersebut dan melakukan penyiapan atau inisialisasi lain yang diperlukan sebelum instance baru siap digunakan.

## 11.1 Setting Initial Values for Stored Properties

Kelas dan struktur harus mengatur semua properti yang disimpannya ke nilai awal yang sesuai pada saat instance kelas atau struktur itu dibuat. Properti yang disimpan tidak boleh dibiarkan dalam keadaan tidak pasti.

```swift
struct Fahrenheit {
    var temperature: Double
    init() {
        temperature = 32.0
    }
}
var f = Fahrenheit()
print("The default temperature is \(f.temperature)° Fahrenheit")
// Prints "The default temperature is 32.0° Fahrenheit"
```

## 11.2 Customizing Initialization

Anda dapat menyesuaikan proses inisialisasi dengan parameter masukan dan badan inisialisasi opsional, atau dengan mengatur properti pada instance baru.

## 11.3 Default Initializers

Swift menyediakan *inisiator default* untuk struktur atau kelas apa pun yang menyediakan nilai default untuk semua propertinya dan tidak menyediakan setidaknya satu inisiator itu sendiri. Inisiator default hanya membuat instance baru dengan semua propertinya diatur ke nilai defaultnya.

## 11.4 Failable Initializers

Terkadang berguna untuk mendefinisikan kelas, struktur, atau enumerasi yang inisialisasinya dapat gagal. Kegagalan ini mungkin dipicu oleh nilai inisialisasi yang tidak valid, tidak adanya sumber daya eksternal yang diperlukan, atau beberapa kondisi lain yang mencegah inisialisasi berhasil.

Anda menulis inisiator yang dapat gagal dengan menempatkan tanda tanya setelah kata kunci `init` (`init?`).

## 11.5 Required Initializers

Tulis kata kunci `required` sebelum definisi inisiator kelas untuk menunjukkan bahwa setiap subkelas dari kelas tersebut harus mengimplementasikan inisiator tersebut:

```swift
class SomeClass {
    required init() {
        // initializer implementation goes here
    }
}
```

# 12. Deinitialization

*Deinitializer* dipanggil segera sebelum instance kelas dibatalkan alokasinya. Anda menulis deinitializer dengan kata kunci `deinit`, mirip dengan bagaimana inisialisator ditulis dengan kata kunci `init`. Deinitializer hanya tersedia pada tipe kelas.

## 12.1 How Deinitialization Works

Swift secara otomatis membatalkan alokasi instance Anda saat tidak lagi diperlukan, untuk membebaskan sumber daya. Swift menangani manajemen memori instance Anda melalui *penghitungan referensi otomatis* (ARC). Biasanya Anda tidak perlu melakukan pembersihan manual saat instance Anda dibatalkan alokasinya. Namun, saat Anda bekerja dengan sumber daya Anda sendiri, Anda mungkin perlu melakukan beberapa pembersihan tambahan sendiri.

## 12.2 Deinitializers in Action

Berikut adalah contoh deinitializer dalam tindakan. Contoh ini mendefinisikan dua tipe baru, `Bank` dan `Player`, untuk permainan sederhana. Kelas `Bank` mengelola mata uang fiktif, yang tidak akan pernah memiliki lebih dari 10.000 koin yang beredar. Hanya ada satu `Bank` dalam permainan, jadi diimplementasikan sebagai kelas dengan properti tipe dan metode untuk menyimpan dan mendistribusikan koin:

```swift
class Bank {
    static var coinsInBank = 10_000
    static func distribute(coins numberOfCoinsRequested: Int) -> Int {
        let numberOfCoinsToDistribute = min(numberOfCoinsRequested, coinsInBank)
        coinsInBank -= numberOfCoinsToDistribute
        return numberOfCoinsToDistribute
    }
    static func receive(coins: Int) {
        coinsInBank += coins
    }
}

class Player {
    var coinsInPurse: Int
    init(coins: Int) {
        coinsInPurse = Bank.distribute(coins: coins)
    }
    func win(coins: Int) {
        coinsInPurse += Bank.distribute(coins: coins)
    }
    deinit {
        Bank.receive(coins: coinsInPurse)
    }
}
```

# 13. Optional Chaining

*Rantai opsional* adalah proses untuk menanyakan dan memanggil properti, metode, dan subskrip pada opsional yang mungkin saat ini `nil`. Jika opsional berisi nilai, panggilan properti, metode, atau subskrip berhasil; jika opsional adalah `nil`, panggilan properti, metode, atau subskrip mengembalikan `nil`. Beberapa kueri dapat dirangkai bersama, dan seluruh rantai gagal dengan anggun jika ada tautan dalam rantai yang `nil`.

## 13.1 Optional Chaining as an Alternative to Forced Unwrapping

Anda menentukan rantai opsional dengan menempatkan tanda tanya (`?`) setelah nilai opsional tempat Anda ingin memanggil properti, metode, atau subskrip jika opsional bukan-`nil`. Ini sangat mirip dengan menempatkan tanda seru (`!`) setelah nilai opsional untuk memaksa membuka bungkus nilainya. Perbedaan utamanya adalah bahwa rantai opsional gagal dengan anggun ketika opsional adalah `nil`, sedangkan pembukaan paksa memicu kesalahan runtime ketika opsional adalah `nil`.

```swift
class Person {
    var residence: Residence?
}

class Residence {
    var numberOfRooms = 1
}

let john = Person()
if let roomCount = john.residence?.numberOfRooms {
    print("John's residence has \(roomCount) room(s).")
} else {
    print("Unable to retrieve the number of rooms.")
}
// Prints "Unable to retrieve the number of rooms."
```

# 14. Error Handling

*Penanganan kesalahan* adalah proses menanggapi dan memulihkan dari kondisi kesalahan dalam program Anda. Swift menyediakan dukungan kelas satu untuk melempar, menangkap, menyebarkan, dan memanipulasi kesalahan yang dapat dipulihkan saat runtime.

## 14.1 Representing and Throwing Errors

Di Swift, kesalahan direpresentasikan oleh nilai dari tipe yang sesuai dengan protokol `Error`. Protokol `Error` kosong ini menunjukkan bahwa suatu tipe dapat digunakan untuk penanganan kesalahan.

Enumerasi Swift sangat cocok untuk membuat model sekelompok kondisi kesalahan terkait, dengan nilai terkait yang memungkinkan informasi tambahan tentang sifat kesalahan untuk dikomunikasikan.

```swift
enum VendingMachineError: Error {
    case invalidSelection
    case insufficientFunds(coinsNeeded: Int)
    case outOfStock
}

throw VendingMachineError.insufficientFunds(coinsNeeded: 5)
```

## 14.2 Handling Errors

Saat kesalahan dilemparkan, beberapa bagian kode di sekitarnya harus bertanggung jawab untuk menangani kesalahan tersebut—misalnya, dengan memperbaiki kesalahan, mencoba pendekatan alternatif, atau memberi tahu pengguna tentang kegagalan tersebut.

Ada empat cara untuk menangani kesalahan di Swift. Anda dapat menyebarkan kesalahan dari sebuah fungsi ke kode yang memanggil fungsi itu, menangani kesalahan menggunakan pernyataan `do-catch`, menangani kesalahan sebagai nilai opsional, atau menegaskan bahwa kesalahan tidak akan terjadi.

```swift
func canThrowErrors() throws -> String

func cannotThrowErrors() -> String
```

# 15. Concurrency

Swift memiliki dukungan bawaan untuk menulis kode asinkron dan paralel dengan cara yang terstruktur. Kode asinkron dapat ditangguhkan dan dilanjutkan nanti, meskipun hanya berjalan di satu utas. Kode paralel dapat berjalan di beberapa utas secara bersamaan. Model konkurensi Swift dibangun di atas utas, tetapi Anda tidak berinteraksi langsung dengannya. Sebaliknya, Swift menyediakan abstraksi tingkat bahasa untuk konkurensi.

## 15.1 Defining and Calling Asynchronous Functions

Fungsi asinkron, atau metode asinkron, adalah jenis fungsi atau metode khusus yang dapat ditangguhkan saat sedang berjalan. Ini berbeda dengan fungsi atau metode sinkron biasa, yang berjalan sampai selesai, sampai melempar kesalahan, atau tidak pernah kembali.

Untuk menunjukkan bahwa sebuah fungsi atau metode bersifat asinkron, Anda menulis kata kunci `async` dalam deklarasinya setelah parameternya, mirip dengan cara Anda menulis `throws` untuk menandai fungsi pelemparan. Jika fungsi atau metode mengembalikan nilai, Anda menulis `async` sebelum panah kembali (`->`).

```swift
func listPhotos(inGallery name: String) async -> [String] {
    let result = // ... some asynchronous networking code ...
    return result
}
```

## 15.2 Asynchronous Sequences

Fungsi asinkron dapat mengembalikan urutan asinkron. Anda dapat mengulang urutan asinkron dengan loop `for-await-in`.

```swift
import Foundation

let handle = FileHandle.standardInput
for try await line in handle.bytes.lines {
    print(line)
}
```

## 15.3 Calling Asynchronous Functions in Parallel

Untuk memanggil fungsi asinkron dan membiarkannya berjalan secara paralel dengan kode di sekitarnya, tulis `async` di depan `let` saat Anda mendefinisikan sebuah konstanta. Saat Anda menggunakan nilai konstanta, tulis `await` sebelum namanya. Menunggu konstanta yang didefinisikan dengan `async-let` menangguhkan eksekusi hingga fungsi asinkron kembali.

```swift
async let firstPhoto = downloadPhoto(named: photoNames[0])
async let secondPhoto = downloadPhoto(named: photoNames[1])
async let thirdPhoto = downloadPhoto(named: photoNames[2])

let photos = await [firstPhoto, secondPhoto, thirdPhoto]
```

## 15.4 Tasks and Task Groups

*Tugas* adalah unit kerja yang dapat berjalan secara asinkron sebagai bagian dari program Anda. Semua kode asinkron berjalan sebagai bagian dari beberapa tugas. Anda dapat membuat tugas dengan memanggil `Task.init(priority:operation:)`.

## 15.5 Actors

*Aktor* adalah tipe referensi yang menyediakan sinkronisasi ke datanya. Anda menggunakan aktor untuk mengelola status bersama dengan aman. Tidak seperti kelas, aktor hanya mengizinkan satu tugas untuk mengakses statusnya yang dapat diubah pada satu waktu, yang mencegah beberapa tugas menulis ke properti yang sama secara bersamaan.

```swift
actor TemperatureLogger {
    let label: String
    var measurements: [Int]
    private(set) var max: Int

    init(label: String, measurement: Int) {
        self.label = label
        self.measurements = [measurement]
        self.max = measurement
    }
}
```

# 16. Type Casting

*Type casting* adalah cara untuk memeriksa tipe instance, atau untuk memperlakukan instance itu sebagai superclass atau subclass yang berbeda dari tempat lain dalam hierarki kelasnya sendiri.

## 16.1 Defining a Class Hierarchy for Type Casting

Anda dapat menggunakan type casting dengan hierarki kelas dan subkelas untuk memeriksa tipe instance tertentu dan untuk mentransmisikan instance itu ke kelas lain dalam hierarki.

## 16.2 Checking Type

Gunakan operator *type check* (`is`) untuk memeriksa apakah sebuah instance bertipe subkelas tertentu. Operator type check mengembalikan `true` jika instance bertipe subkelas tersebut dan `false` jika tidak.

```swift
for item in library {
    if item is Movie {
        movieCount += 1
    } else if item is Song {
        songCount += 1
    }
}
```

## 16.3 Downcasting

Sebuah konstanta atau variabel dari tipe kelas tertentu sebenarnya dapat merujuk ke instance subkelas di belakang layar. Jika Anda yakin ini masalahnya, Anda dapat mencoba untuk *downcast* ke tipe subkelas dengan operator *type cast* (`as?` atau `as!`).

Karena downcasting bisa gagal, operator type cast hadir dalam dua bentuk yang berbeda. Bentuk bersyarat, `as?`, mengembalikan nilai opsional dari tipe yang ingin Anda downcast. Bentuk paksa, `as!`, mencoba downcast dan memaksa-membuka hasil sebagai satu tindakan gabungan.

## 16.4 Type Casting for Any and AnyObject

Swift menyediakan dua tipe khusus untuk bekerja dengan tipe non-spesifik:

* `Any` dapat mewakili instance dari tipe apa pun, termasuk tipe fungsi.
* `AnyObject` dapat mewakili instance dari tipe kelas apa pun.

# 17. Nested Types

Swift memungkinkan Anda untuk mendefinisikan tipe bersarang, di mana Anda menyarangkan enumerasi, kelas, dan struktur pendukung di dalam definisi tipe yang mereka dukung.

## 17.1 Nested Types in Action

Contoh di bawah ini mendefinisikan struktur yang disebut `BlackjackCard`, yang memodelkan kartu remi yang digunakan dalam permainan Blackjack. Struktur `BlackjackCard` berisi dua enumerasi bersarang yang disebut `Suit` dan `Rank`.

```swift
struct BlackjackCard {

    // nested Suit enumeration
    enum Suit: Character {
        case spades = "♠", hearts = "♡", diamonds = "♢", clubs = "♣"
    }

    // nested Rank enumeration
    enum Rank: Int {
        case two = 2, three, four, five, six, seven, eight, nine, ten
        case jack, queen, king, ace
        struct Values {
            let first: Int, second: Int?
        }
        var values: Values {
            switch self {
            case .ace:
                return Values(first: 1, second: 11)
            case .jack, .queen, .king:
                return Values(first: 10, second: nil)
            default:
                return Values(first: self.rawValue, second: nil)
            }
        }
    }

    // BlackjackCard properties and methods
    let rank: Rank, suit: Suit
    var description: String {
        var output = "suit is \(suit.rawValue),"
        output += " value is \(rank.values.first)"
        if let second = rank.values.second {
            output += " or \(second)"
        }
        return output
    }
}
```

## 17.2 Referring to Nested Types

Untuk menggunakan tipe bersarang di luar konteks pendefinisiannya, awali namanya dengan nama tipe tempat ia bersarang:

```swift
let heartsSymbol = BlackjackCard.Suit.hearts.rawValue
// heartsSymbol is "♡"
```

# 18. Extensions

*Ekstensi* menambahkan fungsionalitas baru ke kelas, struktur, enumerasi, atau tipe protokol yang ada. Ini termasuk kemampuan untuk memperluas tipe yang Anda tidak memiliki akses ke kode sumber aslinya (dikenal sebagai *retroactive modeling*).

## 18.1 Extension Syntax

Deklarasikan ekstensi dengan kata kunci `extension`:

```swift
extension SomeType {
    // new functionality to add to SomeType goes here
}
```

## 18.2 Computed Properties

Ekstensi dapat menambahkan properti instance terhitung dan properti tipe terhitung ke tipe yang ada.

```swift
extension Double {
    var km: Double { return self * 1_000.0 }
    var m: Double { return self }
    var cm: Double { return self / 100.0 }
    var mm: Double { return self / 1_000.0 }
    var ft: Double { return self / 3.28084 }
}
let oneInch = 25.4.mm
print("One inch is \(oneInch) meters")
// Prints "One inch is 0.0254 meters"
```

## 18.3 Initializers

Ekstensi dapat menambahkan inisialisasi baru yang mudah ke kelas yang ada. Ini memungkinkan Anda untuk memperluas tipe lain untuk menerima tipe kustom Anda sendiri sebagai parameter inisialisasi, atau untuk menyediakan opsi inisialisasi tambahan yang tidak disertakan dengan implementasi asli tipe tersebut.

## 18.4 Methods

Ekstensi dapat menambahkan metode instance baru dan metode tipe baru ke tipe yang ada.

```swift
extension Int {
    func repetitions(task: () -> Void) {
        for _ in 0..<self {
            task()
        }
    }
}
```

## 18.5 Subscripts

Ekstensi dapat menambahkan subskrip baru ke tipe yang ada.

```swift
extension Int {
    subscript(digitIndex: Int) -> Int {
        var decimalBase = 1
        for _ in 0..<digitIndex {
            decimalBase *= 10
        }
        return (self / decimalBase) % 10
    }
}
```

## 18.6 Nested Types

Ekstensi dapat menambahkan tipe bersarang baru ke kelas, struktur, dan enumerasi yang ada:

```swift
extension Character {
    enum Kind {
        case vowel, consonant, other
    }
    var kind: Kind {
        switch String(self).lowercased() {
        case "a", "e", "i", "o", "u":
            return .vowel
        case "b", "c", "d", "f", "g", "h", "j", "k", "l", "m",
             "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z":
            return .consonant
        default:
            return .other
        }
    }
}
```

# 19. Protocols

*Protokol* mendefinisikan cetak biru metode, properti, dan persyaratan lain yang sesuai dengan tugas atau bagian fungsionalitas tertentu. Protokol kemudian dapat diadopsi oleh kelas, struktur, atau enumerasi untuk menyediakan implementasi aktual dari persyaratan tersebut.

## 19.1 Protocol Syntax

Definisi protokol sangat mirip dengan definisi kelas, struktur, dan enumerasi:

```swift
protocol SomeProtocol {
    // protocol definition goes here
}
```

Untuk mendefinisikan kelas, struktur, atau enumerasi yang mengadopsi protokol tertentu, tempatkan nama protokol setelah nama tipe, dipisahkan oleh titik dua, sebagai bagian dari definisinya.

```swift
struct SomeStructure: FirstProtocol, AnotherProtocol {
    // structure definition goes here
}
```

## 19.2 Property Requirements

Protokol dapat mensyaratkan tipe yang sesuai untuk menyediakan properti instance atau properti tipe tertentu. Protokol tidak menentukan apakah properti harus berupa properti yang disimpan atau properti yang dihitung—ia hanya menentukan nama properti dan tipe yang diperlukan.

## 19.3 Method Requirements

Protokol dapat mensyaratkan tipe yang sesuai untuk mengimplementasikan metode instance dan metode tipe tertentu. Metode-metode ini ditulis sebagai bagian dari definisi protokol persis seperti metode instance dan tipe biasa, tetapi tanpa kurung kurawal atau badan fungsi.

## 19.4 Mutating Method Requirements

Terkadang perlu bagi sebuah metode untuk memodifikasi (atau *mutate*) instance yang dimilikinya. Untuk metode instance pada tipe nilai (yaitu, struktur dan enumerasi), tempatkan kata kunci `mutating` sebelum kata kunci `func` metode untuk menunjukkan bahwa metode diizinkan untuk memodifikasi instance yang dimilikinya.

## 19.5 Initializer Requirements

Protokol dapat mensyaratkan tipe yang sesuai untuk mengimplementasikan inisialisasi tertentu. Anda menulis persyaratan inisialisasi ini sebagai bagian dari definisi protokol dengan cara yang sama seperti inisialisasi biasa, tetapi tanpa kurung kurawal atau badan inisialisasi.

# 20. Generics

*Kode generik* memungkinkan Anda untuk menulis fungsi dan tipe yang fleksibel dan dapat digunakan kembali yang dapat bekerja dengan tipe apa pun, sesuai dengan persyaratan yang Anda tentukan. Anda dapat menulis kode yang menghindari duplikasi dan mengekspresikan niatnya dengan cara yang jelas dan diabstraksi.

## 20.1 The Problem That Generics Solve

Berikut adalah fungsi non-generik, `swapTwoInts(_:_:)`, yang menukar dua nilai `Int`:

```swift
func swapTwoInts(_ a: inout Int, _ b: inout Int) {
    let temporaryA = a
    a = b
    b = temporaryA
}
```

Fungsi ini berguna, tetapi hanya dapat digunakan dengan nilai `Int`. Jika Anda ingin menukar dua nilai `String`, atau dua nilai `Double`, Anda harus menulis lebih banyak fungsi, seperti fungsi `swapTwoStrings(_:_:)` dan `swapTwoDoubles(_:_:)`.

## 20.2 Generic Functions

Fungsi generik dapat bekerja dengan tipe apa pun. Berikut adalah versi generik dari fungsi `swapTwoInts(_:_:)` dari atas, yang disebut `swapTwoValues(_:_:)`:

```swift
func swapTwoValues<T>(_ a: inout T, _ b: inout T) {
    let temporaryA = a
    a = b
    b = temporaryA
}
```

## 20.3 Generic Types

Selain fungsi generik, Swift memungkinkan Anda untuk mendefinisikan *tipe generik* Anda sendiri. Ini adalah kelas, struktur, dan enumerasi kustom yang dapat bekerja dengan tipe apa pun, mirip dengan `Array` dan `Dictionary`.

```swift
struct Stack<Element> {
    var items: [Element] = []
    mutating func push(_ item: Element) {
        items.append(item)
    }
    mutating func pop() -> Element {
        return items.removeLast()
    }
}
```

## 20.4 Extending a Generic Type

Saat Anda memperluas tipe generik, Anda tidak menyediakan daftar parameter tipe sebagai bagian dari definisi ekstensi. Sebaliknya, daftar parameter tipe dari definisi tipe asli tersedia dalam badan ekstensi, dan nama parameter tipe asli digunakan untuk merujuk ke parameter tipe dari definisi asli.

## 20.5 Associated Types

*Tipe terkait* memberikan nama placeholder ke sebuah tipe yang digunakan sebagai bagian dari protokol. Tipe aktual untuk tipe terkait itu tidak ditentukan sampai protokol diadopsi.

# 21. Automatic Reference Counting (ARC)

Swift menggunakan *Automatic Reference Counting* (ARC) untuk mengelola penggunaan memori aplikasi Anda. Dalam kebanyakan kasus, ini berarti manajemen memori "bekerja begitu saja" di Swift, dan Anda tidak perlu memikirkan manajemen memori sendiri. ARC secara otomatis membebaskan sumber daya memori yang digunakan oleh instance kelas ketika instance tersebut tidak lagi diperlukan.

## 21.1 How ARC Works

Setiap kali Anda membuat instance baru dari sebuah kelas, ARC mengalokasikan sepotong memori untuk menyimpan informasi tentang instance tersebut. Memori ini menyimpan informasi tentang tipe instance, bersama dengan nilai properti yang disimpan yang terkait dengan instance tersebut. Ketika instance tidak lagi diperlukan, ARC membebaskan memori yang digunakan oleh instance tersebut, sehingga memori tersebut dapat digunakan untuk tujuan lain.

Untuk memastikan bahwa instance yang tidak lagi diperlukan tidak hilang saat masih digunakan, ARC melacak berapa banyak properti, konstanta, dan variabel yang saat ini mereferensikan setiap instance kelas. ARC tidak membatalkan alokasi instance selama setidaknya satu referensi kuat ke instance tersebut masih ada.

## 21.2 ARC in Action

Berikut adalah contoh bagaimana Automatic Reference Counting (ARC) bekerja. Contoh ini dimulai dengan definisi kelas sederhana yang disebut `Person`:

```swift
class Person {
    let name: String
    init(name: String) {
        self.name = name
        print("\(name) is being initialized")
    }
    deinit {
        print("\(name) is being deinitialized")
    }
}
```

## 21.3 Strong Reference Cycles Between Class Instances

Masalah yang dapat terjadi dengan ARC adalah bahwa mungkin untuk menulis kode di mana instance kelas tidak pernah memiliki jumlah referensi kuat nol. Ini dapat terjadi jika dua instance kelas atau lebih saling mereferensikan dengan kuat, sehingga setiap instance tetap hidup meskipun tidak ada referensi kuat lain ke sana.

```swift
class Person {
    let name: String
    init(name: String) { self.name = name }
    var apartment: Apartment?
    deinit { print("\(name) is being deinitialized") }
}

class Apartment {
    let unit: String
    init(unit: String) { self.unit = unit }
    var tenant: Person?
    deinit { print("Apartment \(unit) is being deinitialized") }
}
```

## 21.4 Resolving Strong Reference Cycles Between Class Instances

Swift menyediakan dua cara untuk menyelesaikan siklus referensi kuat saat Anda bekerja dengan properti dari tipe kelas: *referensi lemah* dan *referensi tanpa pemilik*. Referensi lemah dan tanpa pemilik memungkinkan satu instance untuk mereferensikan instance lain tanpa mempertahankan referensi kuat ke sana. Instance kemudian dapat dibatalkan alokasinya oleh ARC.

Gunakan referensi lemah ketika masa pakai referensi lain lebih pendek atau dapat menjadi `nil` di beberapa titik. Gunakan referensi tanpa pemilik ketika masa pakai referensi lain sama atau lebih lama.

# 22. Memory Safety

## 22.1 Understanding Conflicting Access to Memory

## 22.2 Conflicting Access to In-Out Parameters

## 22.3 Conflicting Access to self in Methods

## 22.4 Conflicting Access to Properties

# 23. Access Control

## 23.1 Modules and Source Files

## 23.2 Access Control Syntax

## 23.3 Custom Types

## 23.4 Subclassing

## 23.5 Constants, Variables, Properties, and Subscripts

# 24. Advanced Operators

## 24.1 Bitwise Operators

## 24.2 Overflow Operators

## 24.3 Infix, Prefix, and Postfix Operators

## 24.4 Operator Methods

## 24.5 Custom Operators
