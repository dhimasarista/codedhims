# PHP: Programming Language

PHP: Hypertext Preprocessor (sebelumnya disebut Personal Home Pages) atau hanya PHP saja, adalah bahasa skrip dengan fungsi umum yang terutama digunakan untuk pengembangan web. Bahasa ini awalnya dibuat oleh seorang pemrogram Denmark-Kanada Rasmus Lerdorf pada tahun 1994. Implementasi referensi PHP sekarang diproduksi oleh The PHP Group. PHP awalnya merupakan singkatan dari Personal Home Page, tetapi sekarang merupakan singkatan dari inisialisasi rekursif PHP: Hypertext Preprocessor.

Kode PHP biasanya diproses di peladen web oleh interpreter PHP yang diimplementasikan sebagai modul, daemon, atau sebagai Common Gateway Interface (CGI) yang bisa dijalankan. Di server web, hasil dari kode PHP yang ditafsirkan dan dieksekusi (dapat berupa semua jenis data, seperti HTML atau data gambar biner) akan membentuk keseluruhan atau sebagian dari respons HTTP. Berbagai sistem templat web, sistem manajemen konten web, dan kerangka kerja web ada yang dapat digunakan untuk mengatur atau memfasilitasi pembuatan respons itu. Selain itu, PHP dapat digunakan untuk banyak tugas pemrograman di luar konteks web, seperti aplikasi grafis mandiri dan kontrol drone robotik. Kode PHP juga dapat langsung dieksekusi dari baris perintah.

> Sumber: Wikipedia

Alasan-alasan Kenapa Menggunakan PHP:

* Dukungan ekosistem yang besar: PHP memiliki ekosistem yang luas, termasuk berbagai framework seperti Laravel, Symfony, dan CodeIgniter, serta dukungan untuk berbagai database dan server web.
* Fitur, sintaks, dan keyword yang kaya: PHP menawarkan banyak fitur, fungsi built-in, dan sintaks yang memudahkan pengembangan web dan aplikasi server-side.
* Kematangan bahasa dari segi performa dan ekosistem: PHP sudah digunakan dalam pengembangan web sejak awal, sehingga memiliki banyak tools, library, dan pengalaman di industri.

Karakteristik PHP:

* Ekstensi File: PHP menggunakan ekstensi file `.php`.
* Multi-threading: PHP tidak memiliki dukungan native untuk multi-threading, namun dapat menggunakan ekstensi atau library seperti `pthreads` untuk concurrency atau parallelism.
* Dynamically typed: PHP adalah bahasa yang dynamically typed, yang berarti Anda tidak perlu mendefinisikan tipe variabel saat deklarasi.
* Type hinting: PHP mendukung type hinting untuk argumen fungsi dan nilai balik, tetapi tidak seketat bahasa statically typed seperti C#.
* String Concatenation & Interpolation: PHP mendukung string interpolation dengan tanda `{$variable}` dalam string, dan juga menggunakan operator `.` untuk concatenation.
* Paradigma: PHP mendukung paradigma pemrograman berorientasi objek (OOP), dan sejak versi PHP 5 telah mendukung konsep seperti inheritance, interfaces, dan traits.
* Opsi Kompilasi: PHP adalah bahasa yang diinterpretasikan, namun dengan menggunakan alat seperti `PHP OPcache` atau `HipHop Virtual Machine (HHVM)` dapat mempercepat eksekusi kode PHP.
* SDK: PHP memiliki alat seperti Composer untuk manajemen dependensi dan alat lain untuk mengembangkan, menguji, dan membangun aplikasi dengan PHP.

Komentar Di PHP:

```php
<?php

// Komentar satu baris: Menampilkan pesan "Hello, World!"
echo "Hello, World!"; 

# Komentar satu baris lainnya: Menampilkan angka 42
echo 42;

/*
  Komentar beberapa baris:
  Kode berikut ini akan menampilkan pesan 'Welcome to PHP' setelah
  menampilkan angka 42. Ini adalah contoh dari komentar multi-line.
*/
echo "Welcome to PHP";

/**
 * Fungsi ini digunakan untuk menghitung jumlah dua angka
 * @param int $a Angka pertama
 * @param int $b Angka kedua
 * @return int Hasil penjumlahan dari $a dan $b
 */
function addNumbers($a, $b) {
    return $a + $b;
}

echo addNumbers(5, 3); // Memanggil fungsi addNumbers dengan parameter 5 dan 3

?>


```

Installation

Environment yang dibutuhkan:

1. PHP : Pastikan PHP sudah terinstall di sistem, dapat diunduh di [situs resmi PHP](https://www.php.net/downloads).
2. Code Editor :

* Visual Studio Code: [https://code.visualstudio.com/](https://code.visualstudio.com/)
* PhpStorm: [https://www.jetbrains.com/phpstorm/](https://www.jetbrains.com/phpstorm/)

Aturan dan Penamaan Sintaks
⚠️  Catatan : Hati-hati dengan case-sensitive terutama camelCase dan PascalCase.

Penamaan File:

* Do : Gunakan format `FileName.php`
* Avoid : Hindari penggunaan `file_name.php`

Dengan aturan di atas, Anda dapat menjaga konsistensi penamaan file dan kode PHP Anda agar sesuai dengan standar terbaik yang ada.

# 0. Introduction

> Menjalankan Kode PHP

Menjalankan di command-line:

```php
php index.php
```

Menjalankan sebagai web server:

```php
php -S localhost:8000
```

# 1. Data Types

### 1. Numerik

a. Integer

Merupakan tipe data yang digunakan untuk angka bulat, baik positif maupun negatif, tanpa desimal.

Contoh:

```php
$integer = 42;
$negative_integer = -10;
```

b. Float (Double)

Tipe data ini digunakan untuk angka yang memiliki nilai desimal.

Contoh:

```php
$float = 3.14;
$negative_float = -10.5;
```

### 2. String

Tipe data string digunakan untuk menyimpan teks atau serangkaian karakter.

Contoh:

```php
$string = "Hello, World!";
$single_quote_string = 'Hello, PHP!';
```

1. String Interpolation

String interpolation adalah teknik di mana variabel disisipkan langsung ke dalam string. Interpolasi ini hanya berlaku untuk string yang menggunakan double quotes (`" "`). Variabel atau ekspresi yang ada di dalam string secara otomatis akan dievaluasi dan nilainya akan dimasukkan ke dalam string tersebut.

Contoh String Interpolation:

```php
$name = "Dhimas";
$age = 25;

// Menggunakan string interpolation
$greeting = "Hello, my name is $name and I am $age years old.";
echo $greeting;  // Output: Hello, my name is Dhimas and I am 25 years old.
```

Jika kita perlu mengekspresikan variabel yang lebih kompleks atau ekspresi dalam string, kita dapat menggunakan kurung kurawal `{}` untuk memisahkan ekspresi variabel:

```php
$city = "Jakarta";
$message = "I live in {$city}.";
echo $message;  // Output: I live in Jakarta.
```

2. String Concatenation

String concatenation adalah teknik penggabungan dua atau lebih string dengan operator titik (`.`). Dalam metode ini, kita secara eksplisit menggabungkan string satu per satu.

Contoh String Concatenation:

```php
$name = "Dhimas";
$age = 25;

// Menggunakan string concatenation
$greeting = "Hello, my name is " . $name . " and I am " . $age . " years old.";
echo $greeting;  // Output: Hello, my name is Dhimas and I am 25 years old.
```

### 3. Boolean

Tipe data boolean digunakan untuk menyimpan nilai benar (true) atau salah (false).

Contoh:

```php
$isTrue = true;
$isFalse = false;
```

### 4. Array

Array adalah tipe data yang dapat menyimpan beberapa nilai dalam satu variabel. PHP mendukung array numerik dan asosiatif.

Contoh array numerik:

```php
$fruits = ["Apple", "Banana", "Cherry"];
```

Contoh array asosiatif:

```php
$person = [
    "name" => "John",
    "age" => 30
];
```

### 5. Object

Tipe data objek digunakan untuk mendefinisikan kelas dan objek. Objek adalah instance dari kelas yang memiliki properti dan metode.

Contoh:

```php
class Car {
    public $make;
    public $model;

    public function __construct($make, $model) {
        $this->make = $make;
        $this->model = $model;
    }
}

$car = new Car("Toyota", "Camry");
```

### 6. NULL

Tipe data `NULL` digunakan untuk menunjukkan bahwa sebuah variabel tidak memiliki nilai atau tidak terdefinisi.

Contoh:

```php
$var = NULL;
```

### 7. Resource

Tipe data resource digunakan untuk menyimpan referensi ke sumber daya eksternal seperti koneksi database, file, atau socket. Biasanya, tipe ini digunakan dalam konteks manajemen sumber daya eksternal.

Contoh:

```php
$file = fopen("file.txt", "r");
```

# 2. Data Items

### 1. Variabel

Di PHP, variabel dideklarasikan menggunakan tanda dolar (`$`) dan nilainya dapat berubah.

```php
<?php
// Variabel menggunakan tanda dolar
$greeting = "Hello";
$number = 42;

// Menampilkan nilai variabel
echo $greeting . " World!<br>";
echo "Angka: " . $number . "<br>";
?>
```

### 2. Konstanta dengan `const`

Konstanta yang dideklarasikan dengan `const` tidak dapat diubah nilainya setelah ditetapkan.

```php
<?php
// Mendeklarasikan konstanta menggunakan const
const PI = 3.14159;

// Menampilkan nilai konstanta
echo "Nilai PI: " . PI . "<br>";
?>
```

### 3. Konstanta dengan `define()`

`define()` juga digunakan untuk mendeklarasikan konstanta global di PHP.

```php
<?php
// Mendeklarasikan konstanta menggunakan define()
define("SITE_NAME", "My Cool Site");

// Menampilkan nilai konstanta
echo "Nama situs: " . SITE_NAME . "<br>";
?>
```

# 3. Data Structures

### 1. Array

* Indexed Array : Array dengan indeks numerik.

```php
  $colors = ["red", "green", "blue"];
  echo $colors[0]; // Output: red
```

* Associative Array : Array dengan kunci berupa string.

```php
  $person = ["name" => "John", "age" => 30];
  echo $person["name"]; // Output: John
```

### 2. Multidimensional Array

Array yang berisi array lainnya.

```php
$students = [["name" => "John", "age" => 20], ["name" => "Jane", "age" => 22]];
echo $students[0]["name"]; // Output: John
```

### 3. Object (Class)

Objek adalah instansi dari sebuah kelas.

```php
class Car {
    public $make;
    public $model;
  
    public function __construct($make, $model) {
        $this->make = $make;
        $this->model = $model;
    }
}

$myCar = new Car("Toyota", "Corolla");
echo $myCar->make; // Output: Toyota
```

### 4. Stack (Menggunakan Array)

Stack adalah struktur data LIFO (Last In First Out).

```php
$stack = [];
array_push($stack, "apple");
array_push($stack, "banana");
echo array_pop($stack); // Output: banana
```

### 5. Set (Menggunakan Array)

Set adalah himpunan unik.

```php
$set = array_unique([1, 2, 2, 3, 4, 4, 5]);
print_r($set); // Output: Array ( [0] => 1 [1] => 2 [3] => 3 [4] => 4 [6] => 5 )
```

# 4. Operators

### 1. Aritmatika

Digunakan untuk operasi matematika dasar.

```php
+   // Penjumlahan
-   // Pengurangan
*   // Perkalian
/   // Pembagian
%   // Sisa bagi (modulus)
```

### 2.  Penugasan

Digunakan untuk memberikan nilai pada variabel.

```php
=   // Penugasan sederhana
+=  // Penugasan penjumlahan
-=  // Penugasan pengurangan
*=  // Penugasan perkalian
/=  // Penugasan pembagian
```

### 3. Pembanding

Digunakan untuk membandingkan dua nilai.

```php
==  // Sama dengan
=== // Sama dengan dan tipe data sama
!=  // Tidak sama dengan
<>  // Tidak sama dengan
>   // Lebih besar dari
<   // Lebih kecil dari
>=  // Lebih besar atau sama dengan
<=  // Lebih kecil atau sama dengan
```

### 4. Logika

Digunakan untuk operasi logika.

```php
&&  // AND
||  // OR
!   // NOT
```

### 5. Inkrementasi & Dekrementasi

Digunakan untuk menambah atau mengurangi nilai variabel.

```php
++  // Inkrementasi (menambah 1)
--  // Dekrementasi (mengurangi 1)
```

### 6.  Ternary

Operator kondisional dalam satu baris.

```php
(condition) ? true : false;
```

### 7. Operator Array

Digunakan untuk operasi dengan array.

```php
+   // Menggabungkan array
[]  // Menambahkan elemen ke array
```

### 8. Operator Eksistensi

Memeriksa apakah variabel atau elemen ada.

```php
isset()   // Memeriksa apakah variabel telah diset
empty()   // Memeriksa apakah variabel kosong
```

# 5. Control Flows

### 1. Percabangan

Digunakan untuk mengeksekusi kode berdasarkan kondisi tertentu.

* `if` statement

  Menjalankan blok kode jika kondisi bernilai `true`.

  ```php
  if ($x > 10) {
      echo "x lebih besar dari 10";
  }
  ```
* `else` statement

  Menjalankan blok kode jika kondisi `if` sebelumnya bernilai `false`.

  ```php
  if ($x > 10) {
      echo "x lebih besar dari 10";
  } else {
      echo "x kurang atau sama dengan 10";
  }
  ```
* `elseif` statement

  Menyediakan alternatif kondisi yang akan diuji jika kondisi sebelumnya gagal.

  ```php
  if ($x > 10) {
      echo "x lebih besar dari 10";
  } elseif ($x == 10) {
      echo "x sama dengan 10";
  } else {
      echo "x kurang dari 10";
  }
  ```
* `switch` statement

  Berguna ketika memeriksa beberapa kondisi yang berbeda.

  ```php
  switch ($x) {
      case 1:
          echo "Satu";
          break;
      case 2:
          echo "Dua";
          break;
      default:
          echo "Tidak diketahui";
  }
  ```

### 2. Perulangan

Digunakan untuk menjalankan blok kode berulang kali.

* `for` loop

  Menjalankan blok kode sejumlah iterasi yang ditentukan.

  ```php
  for ($i = 0; $i < 10; $i++) {
      echo $i;
  }
  ```
* `while` loop

  Menjalankan blok kode selama kondisi bernilai `true`.

  ```php
  $i = 0;
  while ($i < 10) {
      echo $i;
      $i++;
  }
  ```
* `do-while` loop

  Mirip dengan `while`, tetapi selalu mengeksekusi blok kode setidaknya sekali, meskipun kondisi `false`.

  ```php
  $i = 0;
  do {
      echo $i;
      $i++;
  } while ($i < 10);
  ```
* `foreach` loop

  Digunakan untuk iterasi melalui elemen dalam array.

  ```php
  $arr = [1, 2, 3];
  foreach ($arr as $value) {
      echo $value;
  }
  ```

### 3. Kontrol Aliran dalam Loop

Mengontrol jalannya eksekusi dalam perulangan.

* `break`

  Keluar dari loop atau switch.

  ```php
  for ($i = 0; $i < 10; $i++) {
      if ($i == 5) {
          break; // keluar dari loop
      }
      echo $i;
  }
  ```
* `continue`

  Melanjutkan iterasi berikutnya dalam loop, melewatkan eksekusi kode setelahnya.

  ```php
  for ($i = 0; $i < 10; $i++) {
      if ($i == 5) {
          continue; // lewati sisa loop ketika $i == 5
      }
      echo $i;
  }
  ```

### 4. Return

Mengontrol jalannya eksekusi dalam fungsi.

* `return`

  Menghentikan eksekusi fungsi dan mengembalikan nilai.

  ```php
  function tambah($a, $b) {
      return $a + $b;
  }
  ```

### 5. `exit()` atau `die()`

Menghentikan eksekusi skrip PHP.

```php
exit("Program dihentikan.");
```

### 6. `goto`

Menyebabkan program melompat ke label tertentu dalam skrip. Penggunaannya umumnya tidak disarankan karena bisa membuat kode sulit dipahami.

```php
goto here;
echo 'Hello';
here:
echo 'World';
```

Itulah kontrol aliran yang umum digunakan dalam PHP. Pemilihan kontrol aliran yang tepat membantu dalam pembuatan logika program yang efisien dan mudah dipahami.

# 6. Input-Output

### 1. Output

Untuk menampilkan informasi atau hasil ke browser atau terminal, PHP menyediakan beberapa fungsi output.

#### a. `echo`

Digunakan untuk menampilkan satu atau lebih string.

```php
echo "Hello, World!";
```

#### b. `print`

Mirip dengan `echo`, tetapi hanya bisa menampilkan satu argumen dan mengembalikan nilai 1.

```php
print "Hello, World!";
```

#### c. `print_r()`

Digunakan untuk menampilkan informasi tentang variabel (terutama array atau objek).

```php
$array = ["apple", "banana", "cherry"];
print_r($array);
```

#### d. `var_dump()`

Menampilkan tipe data dan nilai dari variabel.

```php
$var = 42;
var_dump($var);
```

#### e. `printf()` / `sprintf()`

Untuk format output yang lebih kompleks.

```php
$age = 25;
printf("I am %d years old.", $age);  // Output: I am 25 years old.
```

---

### 2. Input

Untuk mendapatkan data dari pengguna atau input eksternal tanpa menggunakan `$_POST` atau `$_GET`, kita bisa menggunakan metode lain, seperti input dari command line atau file.

#### a. `fgets()`

Digunakan untuk membaca input dari pengguna melalui command line.

```php
echo "Enter your name: ";
$name = fgets(STDIN);
echo "Hello, " . $name;
```

#### b. `readline()`

Alternatif untuk `fgets()` pada CLI untuk mendapatkan input.

```php
$name = readline("Enter your name: ");
echo "Hello, " . $name;
```

#### c. `file_get_contents()`

Membaca data dari file, misalnya untuk mengambil data dari file JSON atau teks.

```php
$data = file_get_contents("data.txt");
echo $data;
```

#### d. `fopen()` dan `fgets()`

Membaca file baris demi baris.

```php
$file = fopen("data.txt", "r");
while (($line = fgets($file)) !== false) {
    echo $line . "<br>";
}
fclose($file);
```

# 7. Functional Programming

#### Functions are First-Class Citizens and Can be Higher-Order

* Di dalam pemrograman fungsional, fungsi dapat diperlakukan seperti nilai lainnya, seperti variabel atau objek. Fungsi dapat diteruskan sebagai argumen, dikembalikan dari fungsi lain, atau disimpan dalam variabel.
  ```php
  $add = function($a, $b) {
      return $a + $b;
  };
  echo $add(2, 3); // Output: 5
  ```

#### Main Function

* Di PHP, tidak ada fungsi `Main` secara eksplisit seperti di bahasa lain. Namun, kode PHP akan dieksekusi dari atas ke bawah dalam file.
  ```php
  echo "Hello, World!";
  ```

#### Pure Function

* Fungsi murni adalah fungsi yang output-nya hanya bergantung pada input dan tidak mengubah status program atau data eksternal.
  ```php
  function add($a, $b) {
      return $a + $b;
  }
  ```

#### Recursion

* Rekursi adalah teknik pemrograman di mana fungsi memanggil dirinya sendiri untuk menyelesaikan masalah.
  ```php
  function factorial($n) {
      if ($n == 0) return 1;
      return $n * factorial($n - 1);
  }
  ```

#### Immutable Variables di Function

* PHP tidak mendukung variabel immutable secara langsung, tetapi kita bisa menggunakan `const` atau `define` untuk mendeklarasikan nilai yang tidak bisa diubah.
  ```php
  define('PI', 3.14);
  ```

#### Fungsi dengan Return Value dan Tidak

* Fungsi bisa mengembalikan nilai atau tidak mengembalikan nilai.
  ```php
  function printMessage($message) {
      echo $message;
  }

  function add($a, $b) {
      return $a + $b;
  }
  ```

#### Function Parameter

* Fungsi dapat menerima parameter untuk memproses data.
  ```php
  function greet($name) {
      echo "Hello, $name!";
  }
  ```

#### Main Function Parameter

* PHP tidak memiliki fungsi `Main`, tetapi kita bisa menggunakan parameter untuk menerima input dalam sebuah script.
  ```php
  $args = $argv;
  foreach ($args as $arg) {
      echo $arg . "\n";
  }
  ```

#### Function Short Expression

* Fungsi bisa didefinisikan dengan ekspresi yang lebih ringkas menggunakan anonymous functions atau arrow functions (PHP 7.4+).
  ```php
  $multiply = fn($a, $b) => $a * $b;
  echo $multiply(2, 3); // Output: 6
  ```

#### Higher-Order Function

* Fungsi yang menerima fungsi lain sebagai parameter atau mengembalikan fungsi.
  ```php
  function multiplyBy($factor) {
      return function($x) use ($factor) {
          return $x * $factor;
      };
  }

  $multiplyByTwo = multiplyBy(2);
  echo $multiplyByTwo(5); // Output: 10
  ```

# 8. Object-Oriented Programming

#### 1. Object

* Objek adalah instansi dari kelas.

```php
class Car {
    public $brand;
    public $model;

    public function __construct($brand, $model) {
        $this->brand = $brand;
        $this->model = $model;
    }
}

$car = new Car('Toyota', 'Corolla');
echo $car->brand; // Output: Toyota
```

#### 2. Class

* Kelas adalah blueprint untuk objek.

```php
class Animal {
    public $name;

    public function __construct($name) {
        $this->name = $name;
    }

    public function speak() {
        echo "I am " . $this->name;
    }
}
```

#### 3. Property & Method

* Property adalah variabel dalam kelas.
* Method adalah fungsi dalam kelas.

```php
class Dog {
    public $name;
    public $breed;

    public function __construct($name, $breed) {
        $this->name = $name;
        $this->breed = $breed;
    }

    public function bark() {
        echo $this->name . " says Woof!";
    }
}

$dog = new Dog("Buddy", "Golden Retriever");
$dog->bark(); // Output: Buddy says Woof!
```

Access Modifier:

* public : Dapat diakses dari mana saja.
* private : Hanya bisa diakses dalam kelas itu sendiri.
* protected : Dapat diakses dalam kelas itu sendiri dan kelas turunannya.

```php
class Person {
    public $name;
    private $age;

    public function __construct($name, $age) {
        $this->name = $name;
        $this->age = $age;
    }

    public function getAge() {
        return $this->age;
    }
}

$person = new Person("John", 25);
echo $person->name;  // Output: John
// echo $person->age; // Error: Cannot access private property
echo $person->getAge(); // Output: 25
```

Namespace

* Digunakan untuk mengorganisir kode.

```php
namespace Animals;

class Cat {
    public $name;
    public function __construct($name) {
        $this->name = $name;
    }

    public function speak() {
        echo $this->name . " says Meow!";
    }
}

$cat = new Cat("Whiskers");
$cat->speak(); // Output: Whiskers says Meow!
```

#### 4. Enkapsulasi

* Menggunakan getter dan setter untuk mengakses properti.

```php
class Product {
    private $price;

    public function setPrice($price) {
        if ($price > 0) {
            $this->price = $price;
        }
    }

    public function getPrice() {
        return $this->price;
    }
}

$product = new Product();
$product->setPrice(100);
echo $product->getPrice(); // Output: 100
```

Constructor

* Konstruktor digunakan untuk inisialisasi objek.

```php
class User {
    public $username;

    public function __construct($username) {
        $this->username = $username;
    }
}

$user = new User("john_doe");
echo $user->username; // Output: john_doe
```

Destructor

* Destructor digunakan untuk membersihkan sumber daya ketika objek dihancurkan.

```php
class FileHandler {
    public function __construct() {
        echo "File handler created\n";
    }

    public function __destruct() {
        echo "File handler destroyed\n";
    }
}

$file = new FileHandler();
unset($file); // Output: File handler created \n File handler destroyed
```

#### 5. Inheritance

* Kelas anak mewarisi properti dan metode dari kelas induk.

```php
class Animal {
    public $name;

    public function __construct($name) {
        $this->name = $name;
    }

    public function speak() {
        echo $this->name . " makes a sound!";
    }
}

class Dog extends Animal {
    public function speak() {
        echo $this->name . " barks!";
    }
}

$dog = new Dog("Buddy");
$dog->speak(); // Output: Buddy barks!
```

#### 6. Abstract Class

* Kelas abstrak tidak bisa diinstansiasi dan harus di-extend.

```php
abstract class Shape {
    abstract public function area();
}

class Rectangle extends Shape {
    public $width, $height;

    public function __construct($width, $height) {
        $this->width = $width;
        $this->height = $height;
    }

    public function area() {
        return $this->width * $this->height;
    }
}

$rectangle = new Rectangle(5, 10);
echo $rectangle->area(); // Output: 50
```

#### 7. Interface

Selain abstract class, cara lain yang bisa kita gunakan untuk menerapkan abstraksi dalam OOP adalah dengan interface. Interface atau antarmuka merupakan set instruksi yang bisa diimplementasi oleh objek. Secara sederhana, interface adalah kontrak bagaimana class diimplementasikan.

```php
interface AnimalInterface {
    public function speak();
}

class Cat implements AnimalInterface {
    public function speak() {
        echo "Meow!";
    }
}

$cat = new Cat();
$cat->speak(); // Output: Meow!
```

#### 8. Traits

Traits adalah mekanisme di PHP yang memungkinkan pengembang untuk mendefinisikan kembali metode yang dapat digunakan di beberapa kelas tanpa harus menggunakan pewarisan (inheritance) secara langsung. Perbedaan Interface dan Traits secara jelas pada bagaimana traits langsung memiliki logika pada body method.

```php
<?php
trait Logger {
    public function info($message) {
        echo "[INFO]::$message";
    }
}
class User {
    use Logger;
}
$user = new User();
$user->info("Trait Berhasil Dibuat!");
```

#### 9. Polymorphism

* Polimorfisme memungkinkan penggunaan objek dari kelas yang berbeda secara seragam.

```php
class Bird {
    public function speak() {
        echo "Chirp!\n";
    }
}

class Dog {
    public function speak() {
        echo "Bark!\n";
    }
}

function makeSound($animal) {
    $animal->speak();
}

$bird = new Bird();
$dog = new Dog();

makeSound($bird); // Output: Chirp!
makeSound($dog);  // Output: Bark!
```

#### 10. Static

* Properti dan metode statis milik kelas itu sendiri, bukan instansi objek.

```php
class Counter {
    public static $count = 0;

    public static function increment() {
        self::$count++;
    }
}

Counter::increment();
echo Counter::$count; // Output: 1
```

#### 11. Meta Programming

Meta programming adalah teknik pemrograman di mana kode dapat  menciptakan ,  mengubah , atau menginterpretasi kode lainnya secara dinamis. Dalam PHP, meta programming sering digunakan untuk  mendefinisikan perilaku dinamis , seperti manipulasi objek, fungsi, atau properti secara runtime.

Berikut adalah konsep utama dalam meta programming di PHP:

1. Magic Methods

PHP memiliki sejumlah magic methods yang memungkinkan pengembang menangani operasi yang tidak secara eksplisit didefinisikan dalam kode.

Contoh Magic Methods:

* `__get($name)`: Dipanggil ketika properti yang tidak tersedia diakses.
* `__set($name, $value)`: Dipanggil ketika properti yang tidak tersedia di-set.
* `__call($name, $arguments)`: Dipanggil ketika metode yang tidak tersedia dipanggil.
* `__callStatic($name, $arguments)`: Dipanggil ketika metode statis yang tidak tersedia dipanggil.
* `__invoke()`: Dipanggil ketika sebuah objek digunakan seperti fungsi.
* `__toString()`: Mengubah objek menjadi string.

Contoh Implementasi:

```php
class DynamicClass {
    private $properties = [];

    public function __get($name) {
        return $this->properties[$name] ?? "Property '$name' does not exist.";
    }

    public function __set($name, $value) {
        $this->properties[$name] = $value;
    }

    public function __call($name, $arguments) {
        return "Method '$name' with arguments " . implode(', ', $arguments) . " does not exist.";
    }
}

$obj = new DynamicClass();
$obj->name = "PHP Meta Programming";
echo $obj->name; // Output: PHP Meta Programming
echo $obj->undefinedProperty; // Output: Property 'undefinedProperty' does not exist.
echo $obj->undefinedMethod('arg1', 'arg2'); // Output: Method 'undefinedMethod' with arguments arg1, arg2 does not exist.
```

2. Reflection

Reflection adalah fitur bawaan PHP yang memungkinkan Anda untuk menganalisis dan memodifikasi struktur program secara runtime.

Contoh Implementasi:

```php
class Example {
    public $property;
    public function method() {
        return "This is a method!";
    }
}

$reflect = new ReflectionClass('Example');

// Mendapatkan informasi tentang properti
$properties = $reflect->getProperties();
print_r($properties);

// Mendapatkan informasi tentang metode
$methods = $reflect->getMethods();
print_r($methods);

// Membuat instance secara dinamis
$instance = $reflect->newInstance();
$instance->property = "Dynamic Value";
echo $instance->property; // Output: Dynamic Value
```

3. Dynamic Code Execution

PHP memungkinkan Anda menjalankan kode secara dinamis melalui fungsi seperti `eval()`.

Contoh:

```php
$code = '$x = 10; echo $x * 2;';
eval($code); // Output: 20
```

Catatan: Penggunaan `eval()` tidak disarankan karena risiko keamanan, terutama jika input berasal dari pengguna.

4. Traits

Traits memungkinkan Anda mendefinisikan metode yang dapat digunakan ulang di berbagai kelas, yang mirip dengan konsep pewarisan, tetapi lebih fleksibel.

Contoh Implementasi:

```php
trait Logger {
    public function log($message) {
        echo "[LOG]: $message";
    }
}

class MyClass {
    use Logger;
}

$obj = new MyClass();
$obj->log("This is a meta programming example."); // Output: [LOG]: This is a meta programming example.
```

5. Anonymous Classes

PHP mendukung anonymous classes (kelas tanpa nama) yang memungkinkan Anda membuat objek sekali pakai secara runtime.

Contoh Implementasi:

```php
$object = new class {
    public function greet() {
        return "Hello from anonymous class!";
    }
};

echo $object->greet(); // Output: Hello from anonymous class!
```

6. Dynamic Method and Property Creation

PHP memungkinkan Anda untuk menambahkan metode atau properti ke objek secara runtime menggunakan `Closure` dan `__call()`.

Contoh:

```php
class DynamicObject {
    public function __call($name, $arguments) {
        return "You called method '$name' with arguments " . implode(', ', $arguments);
    }
}

$obj = new DynamicObject();
echo $obj->undefinedMethod('arg1', 'arg2'); 
// Output: You called method 'undefinedMethod' with arguments arg1, arg2
```

7. Application in Frameworks

Meta programming digunakan secara luas di framework PHP seperti  Laravel ,  Symfony , dan lainnya untuk:

* Dependency Injection
* Dynamic Routing
* ORM (Object-Relational Mapping) seperti Eloquent
* Middleware

Contoh di Laravel:

```php
Route::get('/user/{id}', function ($id) {
    return User::find($id);
});
```

Kode ini menggunakan meta programming di backend untuk memetakan URL ke fungsi tertentu secara dinamis.

Library Pendukung untuk Meta Programming

1. opis/closure : Untuk serialisasi dan manipulasi closures.

```bash
   composer require opis/closure
```

1. roave/better-reflection : Untuk refleksi tingkat lanjut.

```bash
   composer require roave/better-reflection
```

1. symfony/var-dumper : Untuk menganalisis variabel dan struktur objek.

```bash
   composer require symfony/var-dumper
```

## 12. Exception Handling

#### 1. Membuat Error (Exception)

* Exception adalah mekanisme untuk menangani kesalahan atau error dalam aplikasi PHP. Anda bisa melemparkan `Exception` dengan menggunakan `throw` dan menangani error dengan `try-catch`.

```php
class CustomException extends Exception {}

function checkAge($age) {
    if ($age < 18) {
        throw new CustomException("Age must be 18 or older.");
    } else {
        return "Age is valid.";
    }
}

try {
    echo checkAge(15); // Akan memunculkan Exception
} catch (CustomException $e) {
    echo "Caught exception: " . $e->getMessage(); // Output: Caught exception: Age must be 18 or older.
}
```

#### 2. Menangani Error (Error Handling)

* PHP menyediakan cara untuk menangani error menggunakan `try-catch` untuk `Exception`, serta `set_error_handler()` untuk menangani error level yang lebih rendah.

Contoh menggunakan try-catch untuk Exception:

```php
try {
    $result = 10 / 0;  // Akan menimbulkan division by zero
} catch (DivisionByZeroError $e) {
    echo "Caught exception: " . $e->getMessage(); // Output: Caught exception: Division by zero
}
```

Contoh menggunakan set_error_handler untuk menangani error level:

```php
function customErrorHandler($errno, $errstr) {
    echo "Error [$errno]: $errstr\n";
}

// Mengatur error handler kustom
set_error_handler("customErrorHandler");

// Contoh error
echo $undefinedVar; // Akan memunculkan warning dan ditangani oleh custom error handler
```

#### 3. Cara Menghindari dan Mengatasi Error

* Penggunaan `try-catch` untuk menangani Exception:
  Dengan menggunakan `try-catch`, kita bisa memastikan bahwa program tidak akan berhenti ketika terjadi error, melainkan menangani error tersebut sesuai dengan yang diinginkan.
  ```php
  try {
      // Menjalankan kode yang bisa menimbulkan error
      $num = 10 / 0;
  } catch (DivisionByZeroError $e) {
      echo "Caught DivisionByZeroError: " . $e->getMessage(); // Output: Caught DivisionByZeroError: Division by zero
  }
  ```
* Menangani Error dengan `set_error_handler`:
  Jika Anda ingin menangani error level selain `Exception`, Anda bisa menggunakan `set_error_handler`. Fungsi ini memungkinkan Anda untuk menetapkan fungsi penanganan error kustom.
  ```php
  // Fungsi untuk menangani error
  function customError($errno, $errstr) {
      echo "Error [$errno]: $errstr\n";
  }

  // Menetapkan custom error handler
  set_error_handler("customError");

  // Menimbulkan error
  echo $undefinedVar;  // Error akan ditangani oleh customError
  ```
* Menangani Error Fatal dengan `register_shutdown_function`:
  Jika aplikasi Anda mengalami error fatal yang tidak dapat ditangani dengan `try-catch`, Anda dapat menggunakan `register_shutdown_function()` untuk menangani hal ini sebelum aplikasi berhenti.
  ```php
  function shutdownHandler() {
      $error = error_get_last();
      if ($error) {
          echo "Fatal error: " . $error['message'];
      }
  }

  // Menetapkan shutdown handler
  register_shutdown_function('shutdownHandler');

  // Contoh menyebabkan fatal error
  echo $undefinedVar;  // Fatal error akan ditangani oleh shutdownHandler
  ```

## 13. Magic Method

Magic method di PHP adalah metode bawaan yang diawali dengan dua garis bawah (`__`) dan dipanggil secara otomatis dalam kondisi tertentu. Mereka digunakan untuk menangani operasi khusus seperti mengakses properti yang tidak tersedia, serialisasi objek, atau menangani pemanggilan metode yang tidak ada.

14 Magic Method di PHP

1. **`__construct()`** – Dipanggil saat objek dibuat, berfungsi sebagai constructor untuk inisialisasi.
2. **`__destruct()`** – Dipanggil saat objek dihapus atau program selesai berjalan, berguna untuk membersihkan sumber daya.
3. **`__call()`** – Menangani pemanggilan metode yang tidak ada dalam objek.
4. **`__callStatic()`** – Menangani pemanggilan metode statis yang tidak ada dalam objek.
5. **`__get()`** – Dipanggil saat mencoba mengakses properti yang tidak tersedia.
6. **`__set()`** – Dipanggil saat mencoba menetapkan nilai ke properti yang tidak ada.
7. **`__isset()`** – Menangani pengecekan `isset()` atau `empty()` pada properti yang tidak tersedia.
8. **`__unset()`** – Menangani penghapusan properti yang tidak ada dengan `unset()`.
9. **`__toString()`** – Memungkinkan objek dikonversi menjadi string.
10. **`__invoke()`** – Memungkinkan objek dipanggil seperti fungsi.
11. **`__clone()`** – Dipanggil saat objek disalin menggunakan `clone`.
12. **`__sleep()`** – Menentukan properti yang akan disimpan saat objek diserialisasi.
13. **`__wakeup()`** – Dipanggil setelah objek di-unserialize untuk inisialisasi ulang.
14. **`__debugInfo()`** – Menentukan data yang ditampilkan saat `var_dump()` digunakan pada objek.
