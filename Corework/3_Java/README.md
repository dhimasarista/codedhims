# Java Programming Language

![](assets/20251022_023539_JavaOne2025_07-1024x473.webp)

## 1️⃣ Dasar-dasar Java

### #1 Java Dasar

#### Pengenalan Java

Java adalah bahasa pemrograman yang dapat dijalankan di berbagai komputer termasuk telepon genggam. Bahasa ini awalnya dibuat oleh James Gosling saat masih bergabung di Sun Microsystems, yang saat ini merupakan bagian dari Oracle dan dirilis tahun 1995. Bahasa ini banyak mengadopsi sintaksis yang terdapat pada C dan C++ namun dengan sintaksis model objek yang lebih sederhana serta dukungan rutin-rutin aras bawah yang minimal. Aplikasi-aplikasi berbasis Java umumnya dikompilasi ke dalam p-code (bytecode) dan dapat dijalankan pada berbagai Mesin Virtual Java (JVM).

Java merupakan bahasa pemrograman yang bersifat umum/non-spesifik (general purpose), dan secara khusus didesain untuk memanfaatkan dependensi implementasi seminimal mungkin. Karena fungsionalitasnya yang memungkinkan aplikasi Java mampu berjalan di beberapa platform sistem operasi yang berbeda, Java dikenal pula dengan slogannya, "Tulis sekali, jalankan di mana pun". Saat ini Java merupakan bahasa pemrograman yang paling populer digunakan[butuh rujukan], dan secara luas dimanfaatkan dalam pengembangan berbagai jenis perangkat lunak.

Oracle (dan yang lainnya) sangat merekomendasikan untuk menghapus versi lawas dan tidak didukung dari Java, karena masalah keamanan yang belum terselesaikan di versi lama.[16] Oracle menyarankan para penggunanya untuk segera bertransisi ke versi yang didukung, seperti salah satu versi LTS (8, 11, 17).

#### Menginstall Java

Environment yang dibutuhkan:

1. Java Development Kit (JDK):

   Unduh JDK (misalnya, OpenJDK atau Oracle JDK) dari situs resmi:

   * [OpenJDK](https://openjdk.java.net/install/)
   * [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
   * GraalVM

   Pilih versi terbaru atau yang sesuai dengan kebutuhan Anda.
2. Code Editor:

   * IntelliJ IDEA (disarankan untuk Java):

     [Unduh IntelliJ IDEA](https://www.jetbrains.com/idea/)
   * Eclipse:

     [Unduh Eclipse IDE](https://www.eclipse.org/downloads/)
   * Visual Studio Code (dengan plugin Java):

     [Unduh Visual Studio Code](https://code.visualstudio.com/)

     Setelah mengunduh, instal plugin Java untuk VS Code:

     * Cari dan instal Java Extension Pack di Visual Studio Code Marketplace.

**Aturan dan Penamaan Sintaks di Java**

⚠️ Catatan: Hati-hati dengan case-sensitive terutama penggunaan camelCase dan  PascalCase .

Penamaan File

Do:

* `FileName.java`

  (Pastikan nama file sesuai dengan nama kelas publik di dalamnya.)

Avoid:

* `file_name.java`

Penamaan Kelas dan Interface

* Kelas dan Interface sebaiknya menggunakan PascalCase (setiap kata dimulai dengan huruf besar tanpa spasi).
  Do:

  * `MyClass`
  * `CustomerService`

  Avoid:

  * `myClass`
  * `customer_service`

Penamaan Variabel dan Metode

* Variabel dan Metode sebaiknya menggunakan camelCase (huruf pertama kecil, kata selanjutnya dimulai dengan huruf besar).
  Do:

  * `myVariable`
  * `getData()`

  Avoid:

  * `MyVariable`
  * `method_name()`

Konstanta

* Konstanta sebaiknya menggunakan UPPER_SNAKE_CASE (semua huruf besar, dipisahkan dengan tanda garis bawah).
  Do:

  * `MAX_VALUE`
  * `PI`

  Avoid:

  * `MaxValue`
  * `Pi`

#### Program Hello World

Untuk menjalankan kode Java, Anda memerlukan beberapa alat dan lingkungan pengembangan yang tepat.

Langkah-langkah untuk Menjalankan Kode Java:

1. Install JDK (Java Development Kit) :

* Java membutuhkan JDK untuk mengkompilasi dan menjalankan kode Java. Anda bisa mengunduhnya dari situs resmi Oracle atau menggunakan OpenJDK.
  * Download JDK : [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html)

1. Install Text Editor atau IDE :

* Anda dapat menggunakan editor teks seperti VS Code atau IDE seperti IntelliJ IDEA atau Eclipse untuk menulis kode Java. IDE ini menyediakan banyak fitur tambahan seperti auto-completion, debugging, dan integrasi build tools.
  * Visual Studio Code : [https://code.visualstudio.com/](https://code.visualstudio.com/)
  * IntelliJ IDEA : [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)
  * Eclipse : [https://www.eclipse.org/](https://www.eclipse.org/)

1. Tulis Program Java Pertama :

* Program Java yang sederhana untuk mencetak teks ke layar:
  ```java
  public class HelloWorld {
      public static void main(String[] args) {
          System.out.println("Hello, World!");
      }
  }
  ```
* Simpan file ini dengan nama `HelloWorld.java`.

1. Kompilasi Kode Java :

* Setelah menulis kode Java, Anda harus mengkompilasinya dengan perintah `javac` di terminal atau command prompt.
  ```bash
  javac HelloWorld.java
  ```
* Ini akan menghasilkan file bytecode `HelloWorld.class`.

1. Jalankan Program Java :

* Untuk menjalankan program Java, gunakan perintah `java` di terminal atau command prompt.
  ```bash
  java HelloWorld
  ```
* Anda akan melihat output `Hello, World!` pada terminal.

1. Menjalankan Kode di IDE :

* Jika menggunakan IDE, Anda cukup klik Run setelah menulis kode, dan IDE akan otomatis mengkompilasi dan menjalankan kode tersebut.

#### JVM Tuning

1. Menggunakan JVM Tuning di CLI (Command Line Interface)

Jika Anda ingin menjalankan aplikasi Java dengan JVM tuning menggunakan perintah  CLI , Anda bisa menambahkan argumen JVM langsung ketika menjalankan aplikasi menggunakan `java -jar` atau perintah lain yang relevan.

Contoh: Misalnya, untuk menjalankan aplikasi dengan JVM tuning menggunakan `java -jar`, Anda bisa menambahkan argumen tuning di bagian perintah:

```bash
java -Xms512m -Xmx2g -XX:MaxMetaspaceSize=512m -XX:+UseG1GC -jar your-application.jar
```

* `-Xms512m` : Mengatur ukuran awal heap memory (heap size) menjadi 512 MB.
* `-Xmx2g` : Mengatur ukuran maksimum heap memory menjadi 2 GB.
* `-XX:MaxMetaspaceSize=512m` : Mengatur ukuran maksimum metaspace menjadi 512 MB.
* `-XX:+UseG1GC` : Menggunakan  G1 Garbage Collector .

2. Menggunakan JVM Tuning di Maven (CLI)

Jika Anda menggunakan Maven untuk menjalankan aplikasi Java, Anda dapat menambahkan argumen JVM langsung ke dalam perintah `mvn` dengan menggunakan  `MAVEN_OPTS` .

Langkah-langkah:

1. Setel `MAVEN_OPTS` di terminal:

   ```bash
   export MAVEN_OPTS="-Xms512m -Xmx2g -XX:MaxMetaspaceSize=512m -XX:+UseG1GC"
   ```

   Ini akan menambahkan argumen JVM setiap kali Anda menjalankan perintah Maven. Sebagai contoh, untuk menjalankan aplikasi dengan Maven:

   ```bash
   mvn clean install
   ```

   Jika Anda ingin hanya menjalankan aplikasi Java menggunakan Maven, gunakan perintah berikut:

   ```bash
   mvn exec:java
   ```
2. Menggunakan JVM Tuning di pom.xml

Di  `pom.xml` , Anda dapat menambahkan konfigurasi JVM untuk Maven dengan menggunakan plugin seperti  exec-maven-plugin . Berikut adalah cara untuk menambahkan JVM tuning di dalam `pom.xml`:

Langkah-langkah:

1. Tambahkan konfigurasi `exec-maven-plugin` di dalam  `pom.xml` :

   ```xml
   <configuration>
                       <mainClass>app.App</mainClass>
                       <arguments>
                           <argument>-Xss32k</argument>
                           <argument>-Xms64m</argument>
                           <argument>-Xmx128m</argument>
                           <argument>-XX:+UseEpsilonGC</argument>
                           <argument>-XX:+PrintGCDetails</argument>
                           <argument>-XX:MaxGCPauseMillis=200</argument>
                       </arguments>
                   </configuration>
   ```
2. JVM Tuning di Maven:
   Dengan pengaturan di atas, Anda dapat menjalankan aplikasi menggunakan perintah:

   ```bash
   mvn exec:java
   ```

   Maven akan menggunakan pengaturan JVM Tuning yang telah Anda tentukan dalam  `pom.xml` .

💡 Argumen JVM Tuning untuk Garbage Collection (GC)

1. `-XX:+UseG1GC`
   * Fungsi: Mengaktifkan  Garbage First (G1GC) , cocok untuk aplikasi dengan heap besar yang menginginkan pengumpulan sampah terkontrol dan latensi rendah.
   * Contoh: `-XX:+UseG1GC`
2. `-XX:+UseZGC`
   * Fungsi: Mengaktifkan  Z Garbage Collector (ZGC) , yang cocok untuk aplikasi dengan heap sangat besar dan kebutuhan latensi rendah.
   * Contoh: `-XX:+UseZGC`
3. `-XX:+UseShenandoahGC`
   * Fungsi: Mengaktifkan Shenandoah GC yang dirancang untuk latensi rendah, cocok untuk aplikasi dengan kebutuhan respon cepat dan memori besar.
   * Contoh: `-XX:+UseShenandoahGC`
4. `-XX:+UseParallelGC`
   * Fungsi: Mengaktifkan  Parallel GC , mengoptimalkan throughput dengan melakukan garbage collection secara paralel.
   * Contoh: `-XX:+UseParallelGC`
5. `-XX:+UseSerialGC`
   * Fungsi: Mengaktifkan  Serial GC , ideal untuk aplikasi dengan heap kecil dan sumber daya terbatas.
   * Contoh: `-XX:+UseSerialGC`
6. `-XX:+UseEpsilonGC`
   * Fungsi: Mengaktifkan Epsilon GC yang tidak melakukan garbage collection sama sekali, cocok untuk aplikasi yang tidak memerlukan pengelolaan memori otomatis.
   * Contoh: `-XX:+UseEpsilonGC`

🧠 Argumen JVM Tuning untuk Memori dan Heap

7. `-Xms<size>`
   * Fungsi: Menentukan ukuran awal dari heap JVM. Heap ini akan digunakan oleh aplikasi saat pertama kali dijalankan.
   * Contoh: `-Xms512m` (memulai dengan 512 MB heap)
8. `-Xmx<size>`
   * Fungsi: Menentukan ukuran maksimum dari heap JVM yang dapat digunakan aplikasi.
   * Contoh: `-Xmx4g` (maksimal 4 GB heap)
9. `-XX:MaxMetaspaceSize=<size>`
   * Fungsi: Menentukan ukuran maksimum untuk Metaspace (memori untuk class metadata).
   * Contoh: `-XX:MaxMetaspaceSize=512m`
10. `-XX:InitialCodeCacheSize=<size>`
    * Fungsi: Menentukan ukuran cache awal untuk kompilasi JIT (Just-In-Time).
    * Contoh: `-XX:InitialCodeCacheSize=32m`
11. `-XX:CodeCacheExpansionSize=<size>`
    * Fungsi: Menentukan ukuran untuk ekspansi cache kode JIT.
    * Contoh: `-XX:CodeCacheExpansionSize=8m`
12. `-XX:+UseCompressedOops`
    * Fungsi: Mengaktifkan Compressed Object Pointers untuk mengurangi penggunaan memori dengan memanfaatkan pointer yang lebih kecil pada JVM 64-bit.
    * Contoh: `-XX:+UseCompressedOops`

⚡ Argumen JVM Tuning untuk Garbage Collection Pause Times

13. `-XX:MaxGCPauseMillis=<ms>`
    * Fungsi: Menentukan waktu maksimum pause GC yang diizinkan oleh JVM (dalam milidetik).
    * Contoh: `-XX:MaxGCPauseMillis=200`
14. `-XX:GCTimeRatio=<ratio>`
    * Fungsi: Menentukan rasio waktu GC dibandingkan dengan waktu aplikasi. Misalnya, nilai `4` berarti waktu GC hanya akan menghabiskan 1/5 dari waktu total.
    * Contoh: `-XX:GCTimeRatio=4`
15. `-XX:ParallelGCThreads=<threads>`
    * Fungsi: Menentukan jumlah thread yang digunakan untuk proses garbage collection paralel.
    * Contoh: `-XX:ParallelGCThreads=4`
16. `-XX:ConcGCThreads=<threads>`
    * Fungsi: Menentukan jumlah thread yang digunakan untuk proses garbage collection  concurrent .
    * Contoh: `-XX:ConcGCThreads=2`
17. `-XX:+PrintGCDetails`
    * Fungsi: Mencetak detail GC dalam log untuk analisis mendalam mengenai waktu dan status setiap pengumpulan sampah.
    * Contoh: `-XX:+PrintGCDetails`
18. `-XX:+PrintGCDateStamps`
    * Fungsi: Mencetak timestamp setiap kali garbage collection terjadi.
    * Contoh: `-XX:+PrintGCDateStamps`

⚙️ Argumen JVM Tuning untuk Performance

19. `-XX:+AggressiveOpts`
    * Fungsi: Mengaktifkan optimasi JVM yang lebih agresif untuk meningkatkan kinerja aplikasi.
    * Contoh: `-XX:+AggressiveOpts`
20. `-XX:+OptimizeStringConcat`
    * Fungsi: Mengoptimalkan operasi konkatenasi string di aplikasi.
    * Contoh: `-XX:+OptimizeStringConcat`
21. `-XX:MaxInlineLevel=<level>`
    * Fungsi: Menentukan tingkat maksimal penyisipan inline untuk fungsi atau metode pada JIT.
    * Contoh: `-XX:MaxInlineLevel=15`
22. `-XX:+UseFastAccessorMethods`
    * Fungsi: Mengaktifkan akses method cepat pada objek untuk mempercepat akses data.
    * Contoh: `-XX:+UseFastAccessorMethods`
23. `-XX:CompileThreshold=<threshold>`
    * Fungsi: Menentukan jumlah panggilan metode sebelum metode tersebut dikompilasi oleh JIT.
    * Contoh: `-XX:CompileThreshold=1000`
24. `-XX:+UseLargePages`
    * Fungsi: Mengaktifkan penggunaan large pages untuk pengelolaan memori yang lebih efisien pada JVM.
    * Contoh: `-XX:+UseLargePages`

🔧 Argumen JVM Tuning untuk Debugging dan Logging

25. `-XX:+HeapDumpOnOutOfMemoryError`
    * Fungsi: Menghasilkan heap dump ketika terjadi  OutOfMemoryError , untuk membantu analisis penyebab error.
    * Contoh: `-XX:+HeapDumpOnOutOfMemoryError`
26. `-XX:HeapDumpPath=<path>`
    * Fungsi: Menentukan lokasi untuk menyimpan  heap dump .
    * Contoh: `-XX:HeapDumpPath=/var/log/heapdump.hprof`
27. `-XX:+PrintGC`
    * Fungsi: Mencetak informasi dasar mengenai proses garbage collection setiap kali terjadi.
    * Contoh: `-XX:+PrintGC`
28. `-XX:+PrintGCApplicationStoppedTime`
    * Fungsi: Menampilkan waktu aplikasi dihentikan selama garbage collection.
    * Contoh: `-XX:+PrintGCApplicationStoppedTime`

🧑‍💻 Argumen JVM Tuning untuk Multi-threading

29. `-XX:ThreadStackSize=<size>`

    * Fungsi: Menentukan ukuran stack untuk setiap thread. Ukuran stack dapat mempengaruhi jumlah thread yang dapat dijalankan secara bersamaan.
    * Contoh: `-XX:ThreadStackSize=256k`
30. `-XX:CICompilerCount=<count>`

    * Fungsi: Menentukan jumlah JIT compiler yang digunakan oleh JVM untuk kompilasi.
    * Contoh: `-XX:CICompilerCount=4`
31. `-Xss<size>`

* Fungsi: Menentukan ukuran stack untuk setiap thread di JVM.
* Deskripsi: Argumen ini juga digunakan untuk menentukan ukuran stack, dan lebih sering digunakan di aplikasi JVM daripada `-XX:ThreadStackSize`. Ini sangat penting ketika aplikasi menggunakan banyak thread.

🌍 Argumen JVM Tuning untuk Platform dan Operating System

31. `-Duser.timezone=<timezone>`
    * Fungsi: Menentukan zona waktu untuk aplikasi Java.
    * Contoh: `-Duser.timezone=UTC`
32. `-Djava.net.preferIPv4Stack=true`
    * Fungsi: Memilih penggunaan IPv4 daripada IPv6 pada aplikasi Java.
    * Contoh: `-Djava.net.preferIPv4Stack=true`
33. `-Djava.io.tmpdir=<directory>`
    * Fungsi: Menentukan direktori temporary files yang digunakan oleh aplikasi.
    * Contoh: `-Djava.io.tmpdir=/tmp`

#### Tipe Data Number

* **Integers (whole numbers):**

  * `byte`: 8-bit, range from -128 to 127. Useful for memory conservation.
  * `short`: 16-bit, range from -32,768 to 32,767.
  * `int`: 32-bit, range from approximately -2 billion to 2 billion. This is the most commonly used integer type.
  * `long`: 64-bit, a much larger range than `int`. When assigning a `long` literal, it should be suffixed with `L` (e.g., `1234567890123L`).
* **Floating-point numbers (decimal numbers):**

  * `float`: 32-bit, single-precision. When assigning a `float` literal, it should be suffixed with `f` (e.g., `3.14f`).
  * `double`: 64-bit, double-precision. This is generally preferred for decimal values due to its higher accuracy and larger range.

#### Tipe Data Character

- char → satu huruf saja, pakai tanda '
- Contoh: char grade = 'A';

#### Tipe Data Boolean

- boolean → hanya dua nilai: true atau false
- Contoh: boolean isOn = true;

#### Tipe Data String

- String → teks (kumpulan karakter)
- Contoh: String name = "Red Horizon";
- Beda dengan char karena bisa lebih dari satu huruf.


| Primitive / Concept | Wrapper Class | Notes                                                   |
| --------------------- | --------------- | --------------------------------------------------------- |
| `byte`              | `Byte`        | immutable, -128 → 127, extends`Number`                 |
| `short`             | `Short`       | immutable, -32,768 → 32,767, extends`Number`           |
| `int`               | `Integer`     | immutable, commonly used, extends`Number`               |
| `long`              | `Long`        | immutable, large whole numbers, extends`Number`         |
| `float`             | `Float`       | immutable, single-precision, extends`Number`            |
| `double`            | `Double`      | immutable, double-precision, extends`Number`            |
| (no primitive)      | `BigInteger`  | arbitrary-size integer, immutable, extends`Number`      |
| (no primitive)      | `BigDecimal`  | arbitrary-precision decimal, immutable, extends`Number` |
| `char`              | `Character`   | immutable, single character                             |
| `boolean`           | `Boolean`     | immutable, true/false                                   |
| `void`              | `Void`        | type token for generics/reflection, no instance         |

#### Variable

* Tempat nyimpan data di memori.
* Format: `tipe nama = nilai;`

- Contoh:

```java
int umur = 21;
String nama = "Red";
```

#### Konstanta

Jika Anda ingin mendeklarasikan variabel yang nilainya tidak bisa diubah setelah inisialisasi, Anda bisa menggunakan kata kunci `final` untuk membuat variabel menjadi konstanta.

```java
final double PI = 3.14159;
```

Variabel `PI` di atas tidak bisa diubah setelah diberi nilai.

#### Tipe Data Bukan Primitif

* Bukan bawaan langsung dari bahasa Java, tapi objek/class.
* Bisa punya method & null.

- Contoh:

```java
String teks = "Halo";     // class String
Integer angka = 10;       // wrapper dari int
Double nilai = 3.14;      // wrapper dari double
```


| Kategori       | Tipe Primitif                   | Tipe Referensi                                   |
| ---------------- | --------------------------------- | -------------------------------------------------- |
| Contoh         | `int`,`double`,`boolean`,`char` | `String`,`Integer`,`Double`,`Array`,`List`       |
| Penyimpanan    | Langsung di memori              | Menyimpan alamat referensi                       |
| Fitur Tambahan | Tidak ada                       | Ada metode bawaan                                |
| Performa       | Lebih cepat                     | Lebih berat karena butuh alokasi memori tambahan |

#### Tipe Data Array

* Menyimpan banyak nilai dengan tipe sama.
  Contoh:

```java
int[] angka = {1, 2, 3, 4};
String[] nama = {"Red", "Horizon"};
System.out.println(angka[0]); // Output: 1

// Indeks mulai dari 0.
```

#### Operasi Matematika

int a = 10;
int b = 3;

int tambah = a + b;   // 13
int kurang = a - b;   // 7
int kali = a * b;     // 30
int bagi = a / b;     // 3
int sisa = a % b;     // 1

#### Operasi Perbandingan

int x = 5;
int y = 8;

boolean sama = x == y;     // false
boolean tidakSama = x != y; // true
boolean lebihBesar = x > y; // false
boolean lebihKecil = x < y; // true
boolean lebihBesarSama = x >= y; // false
boolean lebihKecilSama = x <= y; // true

#### Operasi Boolean

boolean p = true;
boolean q = false;

boolean dan = p && q;  // false (AND)
boolean atau = p || q; // true  (OR)
boolean tidak = !p;    // false (NOT)

Baik, ini versi rapi dan terformat:

---

#### Expression, Statement, Block

Expression menghasilkan nilai, Statement adalah satu perintah, dan Block adalah kumpulan Statement dalam `{}`.

```java
int x = 5 + 2;
x = x * 3;
{
    int y = 10;
    System.out.println(y);
}
```

---

#### If Statement

Digunakan untuk mengecek kondisi tertentu.

```java
if (x > 5) {
    System.out.println("Lebih besar");
} else {
    System.out.println("Lebih kecil atau sama");
}
```

---

#### Switch Statement

Memilih aksi berdasarkan nilai variabel.

```java
int hari = 2;
switch (hari) {
    case 1 -> System.out.println("Senin");
    case 2 -> System.out.println("Selasa");
    default -> System.out.println("Tidak dikenal");
}
```

---

#### Ternary Operator

Versi singkat dari `if-else` untuk ekspresi sederhana.

```java
int umur = 18;
String status = (umur >= 18) ? "Dewasa" : "Anak-anak";
```

---

#### For Loop

Digunakan untuk perulangan dengan jumlah langkah yang pasti.

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

---

#### While Loop

Berulang selama kondisi bernilai `true`.

```java
int a = 0;
while (a < 5) {
    System.out.println(a);
    a++;
}
```

---

#### Do While Loop

Menjalankan isi loop minimal sekali sebelum memeriksa kondisi.

```java
int b = 0;
do {
    System.out.println(b);
    b++;
} while (b < 5);
```

---

#### Break dan Continue

`break` menghentikan loop, `continue` melewati satu iterasi.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    if (i % 2 == 0) continue;
    System.out.println(i);
}
```

---

#### For Each

Digunakan untuk membaca langsung setiap elemen dari array.

```java
String[] nama = {"Red", "Horizon"};
for (String n : nama) {
    System.out.println(n);
}
```

#### Method

Kumpulan kode yang bisa dipanggil berulang untuk melakukan tugas tertentu.

```java
void sapa() {
    System.out.println("Halo!");
}

sapa();
```

---

#### Method Parameter

Digunakan untuk menerima input dari pemanggil method.

```java
void sapa(String nama) {
    System.out.println("Halo, " + nama);
}

sapa("Red");
```

---

#### Method Return Value

Mengembalikan nilai dari sebuah method menggunakan `return`.

```java
int tambah(int a, int b) {
    return a + b;
}

int hasil = tambah(3, 5);
System.out.println(hasil);
```

---

#### Method Variable Argument

Memungkinkan method menerima jumlah argumen yang tidak terbatas.

```java
int total(int... angka) {
    int sum = 0;
    for (int n : angka) sum += n;
    return sum;
}

System.out.println(total(1, 2, 3, 4));
```

---

#### Method Overloading

Membuat beberapa method dengan nama sama tapi parameter berbeda.

```java
void cetak(String teks) {
    System.out.println(teks);
}

void cetak(int angka) {
    System.out.println(angka);
}

cetak("Halo");
cetak(123);
```

---

#### Recursive Method

Method yang memanggil dirinya sendiri.

```java
int faktorial(int n) {
    if (n == 1) return 1;
    return n * faktorial(n - 1);
}

System.out.println(faktorial(5));
```

---

#### Scope

Menentukan di mana variabel bisa diakses.

```java
int x = 10;

void tampil() {
    int y = 5;
    System.out.println(x + y);
}

tampil();
```

---

#### Komentar

Digunakan untuk memberi catatan di kode, tidak dieksekusi.

```java
// Komentar satu baris

/*
Komentar
beberapa baris
*/

/**
 * Komentar dokumentasi (JavaDoc)
 */
```

### #2 Java Object-Oriented Programming

#### Class

Blueprint atau cetakan untuk membuat objek.

```java
class Mobil {
    String merk;
    void jalan() {
        System.out.println("Mobil berjalan");
    }
}
```

---

#### Object

Instance dari class.

```java
Mobil m = new Mobil();
m.jalan();
```

---

#### Field

Variabel yang ada di dalam class.

```java
class Mobil {
    String merk = "Toyota";
}
```

---

#### Method

Fungsi yang ada di dalam class.

```java
class Mobil {
    void nyalakan() {
        System.out.println("Mesin dinyalakan");
    }
}
```

---

#### Constructor

Method khusus yang dipanggil saat objek dibuat.

```java
class Mobil {
    String merk;
    Mobil(String merk) {
        this.merk = merk;
    }
}
```

---

#### Constructor Overloading

Beberapa constructor dengan parameter berbeda.

```java
class Mobil {
    String merk;
    Mobil() {}
    Mobil(String merk) {
        this.merk = merk;
    }
}
```

---

#### Variable Shadowing

Variabel lokal menutupi variabel class dengan nama sama.

```java
class Mobil {
    String merk = "Default";
    void setMerk(String merk) {
        System.out.println(merk);         // lokal
        System.out.println(this.merk);    // milik objek
    }
}
```

---

#### this Keyword

Menunjuk ke objek saat ini.

```java
class Mobil {
    String merk;
    Mobil(String merk) {
        this.merk = merk;
    }
}
```

---

#### Inheritance

Mewarisi properti dan method dari class lain.

```java
class Kendaraan {
    void jalan() { System.out.println("Berjalan"); }
}
class Mobil extends Kendaraan {}
```

---

#### Method Overriding

Mengubah implementasi method dari class induk.

```java
class Kendaraan {
    void jalan() { System.out.println("Kendaraan berjalan"); }
}
class Mobil extends Kendaraan {
    @Override
    void jalan() { System.out.println("Mobil berjalan"); }
}
```

---

#### super Keyword

Digunakan untuk mengakses class induk.

```java
class Kendaraan {
    void info() { System.out.println("Kendaraan"); }
}
class Mobil extends Kendaraan {
    void tampil() { super.info(); }
}
```

---

#### super Constructor

Memanggil constructor dari class induk.

```java
class Kendaraan {
    Kendaraan(String nama) {
        System.out.println("Kendaraan: " + nama);
    }
}
class Mobil extends Kendaraan {
    Mobil() {
        super("Mobil");
    }
}
```

---

#### Object Class

Semua class di Java adalah turunan dari `Object`.

```java
class Mobil {}
Mobil m = new Mobil();
System.out.println(m.toString());
```

---

#### Polymorphism

Objek bisa dianggap sebagai tipe induknya.

```java
Kendaraan k = new Mobil();
k.jalan();
```

---

#### Type Check dan Casts

Memeriksa atau mengubah tipe objek.

```java
if (k instanceof Mobil) {
    Mobil m = (Mobil) k;
}
```

---

#### Variable Hiding

Field di subclass menutupi field superclass.

```java
class A { int x = 10; }
class B extends A { int x = 20; }
```

---

#### Package

Tempat pengelompokan class.

```java
package com.asyncra.app;
```

---

#### Access Modifier

Menentukan akses ke class, field, dan method (`public`, `protected`, `private`, `default`).

```java
public class Mobil {}
```

---

#### Import

Mengimpor class dari package lain.

```java
import java.util.Scanner;
```

---

#### Abstract Class

Class yang tidak bisa dibuat objeknya.

```java
abstract class Hewan {
    abstract void suara();
}
```

---

#### Abstract Method

Method tanpa implementasi di abstract class.

```java
abstract class Hewan {
    abstract void suara();
}
```

---

#### Getter dan Setter

Akses data field secara aman.

```java
class Orang {
    private String nama;
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
}
```

---

#### Interface

Kontrak yang harus diimplementasikan class.

```java
interface Kendaraan {
    void jalan();
}
```

---

#### Interface Inheritance

Interface bisa mewarisi interface lain.

```java
interface A { void test(); }
interface B extends A { void run(); }
```

---

#### Default Method

Method dengan implementasi di dalam interface.

```java
interface Kendaraan {
    default void info() {
        System.out.println("Ini kendaraan");
    }
}
```

---

#### toString Method

Mengubah representasi objek menjadi teks.

```java
class Mobil {
    public String toString() {
        return "Mobil keren";
    }
}
```

---

#### equals Method

Membandingkan dua objek berdasarkan nilai, bukan referensi.

```java
public boolean equals(Object obj) {
    return this == obj;
}
```

---

#### hashCode Method

Mengembalikan kode hash unik untuk objek.

```java
public int hashCode() {
    return 12345;
}
```

---

#### Final Class

Class yang tidak bisa diwarisi.

```java
final class Konstanta {}
```

---

#### Final Method

Method yang tidak bisa dioverride.

```java
class A {
    final void tampil() {}
}
```

---

#### Inner Class

Class di dalam class lain.

```java
class Luar {
    class Dalam {
        void sapa() { System.out.println("Halo"); }
    }
}
```

---

#### Anonymous Class

Class tanpa nama yang langsung didefinisikan.

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Jalan");
    }
};
```

---

#### static Keyword

Menandakan anggota milik class, bukan objek.

```java
class Util {
    static void info() {
        System.out.println("Static method");
    }
}
```

---

#### Record Class

Class sederhana untuk data immutable.

```java
record Point(int x, int y) {}
```

---

#### Enum Class

Daftar nilai konstan.

```java
enum Hari { SENIN, SELASA, RABU }
```

---

#### Exception

Kesalahan saat runtime yang bisa ditangani.

```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

#### Runtime Exception

Kesalahan yang terjadi saat program berjalan.

```java
throw new NullPointerException();
```

---

#### Error

Masalah serius yang tidak bisa ditangani program.

```java
throw new OutOfMemoryError();
```

---

#### StackTraceElement Class

Menampilkan jejak error di runtime.

```java
e.printStackTrace();
```

---

#### Try with Resource

Menutup resource otomatis setelah selesai digunakan.

```java
try (Scanner sc = new Scanner(System.in)) {
    System.out.println(sc.nextLine());
}
```

---

#### Annotation

Memberi metadata pada kode.

```java
@Override
void jalan() {}
```

---

#### Reflection

Memeriksa atau memodifikasi class saat runtime.

```java
Class<?> c = Mobil.class;
System.out.println(c.getName());
```

#### String Class

Digunakan untuk menyimpan dan memanipulasi teks.

```java
String teks = "Halo Dunia";
System.out.println(teks.toUpperCase());
System.out.println(teks.length());
```

---

#### String Buffer dan String Builder Class

Digunakan untuk memodifikasi string secara efisien.
`StringBuilder` lebih cepat, tapi tidak thread-safe;
`StringBuffer` aman untuk thread.

```java
StringBuilder sb = new StringBuilder("Halo");
sb.append(" Dunia");
System.out.println(sb.toString());
```

---

#### StringJoiner Class

Menggabungkan string dengan pemisah tertentu.

```java
import java.util.StringJoiner;

StringJoiner sj = new StringJoiner(", ");
sj.add("Red");
sj.add("Horizon");
System.out.println(sj.toString());
```

---

#### StringTokenizer Class

Memecah string menjadi token berdasarkan pemisah.

```java
import java.util.StringTokenizer;

StringTokenizer st = new StringTokenizer("Java Is Fun", " ");
while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
```

---

#### Number Class

Kelas induk dari wrapper numerik seperti `Integer`, `Double`, dan `Long`.

```java
Integer angka = 10;
Double desimal = 3.14;
System.out.println(angka.doubleValue());
```

---

#### Math Class

Berisi fungsi matematika seperti akar, pangkat, dan trigonometri.

```java
System.out.println(Math.sqrt(16));
System.out.println(Math.pow(2, 3));
System.out.println(Math.random());
```

---

#### Big Number Class

`BigInteger` dan `BigDecimal` untuk angka sangat besar atau presisi tinggi.

```java
import java.math.BigInteger;
import java.math.BigDecimal;

BigInteger a = new BigInteger("999999999999");
BigInteger b = new BigInteger("2");
System.out.println(a.multiply(b));

BigDecimal c = new BigDecimal("0.1");
BigDecimal d = new BigDecimal("0.2");
System.out.println(c.add(d));
```

---

#### Scanner Class

Membaca input dari pengguna.

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
System.out.print("Masukkan nama: ");
String nama = sc.nextLine();
System.out.println("Halo " + nama);
```

---

#### Date dan Calendar Class

Digunakan untuk memanipulasi tanggal dan waktu.

```java
import java.util.Date;
import java.util.Calendar;

Date sekarang = new Date();
System.out.println(sekarang);

Calendar cal = Calendar.getInstance();
System.out.println(cal.get(Calendar.YEAR));
```

---

#### System Class

Menyediakan akses ke resource sistem.

```java
System.out.println(System.currentTimeMillis());
System.out.println(System.getenv("PATH"));
```

---

#### Runtime Class

Merepresentasikan lingkungan eksekusi Java.

```java
Runtime rt = Runtime.getRuntime();
System.out.println(rt.availableProcessors());
System.out.println(rt.totalMemory());
```

---

#### UUID Class

Membuat ID unik.

```java
import java.util.UUID;

UUID id = UUID.randomUUID();
System.out.println(id.toString());
```

---

#### Base64 Class

Meng-encode dan decode data ke format Base64.

```java
import java.util.Base64;

String teks = "Asyncra";
String encoded = Base64.getEncoder().encodeToString(teks.getBytes());
String decoded = new String(Base64.getDecoder().decode(encoded));
System.out.println(encoded);
System.out.println(decoded);
```

---

#### Objects Class

Berisi method utilitas untuk bekerja dengan objek.

```java
import java.util.Objects;

String a = "Red";
String b = "Red";
System.out.println(Objects.equals(a, b));
System.out.println(Objects.hash(a, b));
```

---

#### Random Class

Menghasilkan angka acak.

```java
import java.util.Random;

Random r = new Random();
System.out.println(r.nextInt(10));
System.out.println(r.nextDouble());
```

---

#### Properties Class

Menyimpan pasangan key-value berbasis string.

```java
import java.util.Properties;

Properties p = new Properties();
p.setProperty("app.name", "Asyncra");
System.out.println(p.getProperty("app.name"));
```

---

#### Arrays Class

Berisi method untuk manipulasi array.

```java
import java.util.Arrays;

int[] data = {3, 1, 2};
Arrays.sort(data);
System.out.println(Arrays.toString(data));
```

---

#### Regular Expression

Digunakan untuk pencocokan pola teks.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

Pattern p = Pattern.compile("[a-z]+");
Matcher m = p.matcher("asyncra");
System.out.println(m.matches());
```

---

## 2️⃣ Collection & Data

### #1 Java Collections

#### Iterable dan Iterator

`Iterable` memungkinkan objek diiterasi (`for-each`). `Iterator` digunakan untuk iterasi manual.

```java
List<String> list = List.of("A", "B", "C");
for (String s : list) System.out.println(s);
```

---

#### Collection

Interface dasar dari semua struktur data koleksi seperti `List`, `Set`, dan `Queue`.

---

#### List

Koleksi berurutan dan bisa menyimpan elemen duplikat.

```java
List<Integer> nums = new ArrayList<>();
nums.add(1); nums.add(2);
```

---

#### Immutable List

List yang tidak bisa diubah.

```java
List<String> names = List.of("A", "B");
```

---

#### Set

Tidak menyimpan elemen duplikat.

```java
Set<String> set = new HashSet<>(List.of("A", "B"));
```

---

#### Immutable Set

Tidak bisa dimodifikasi.

```java
Set<String> set = Set.of("A", "B");
```

---

#### SortedSet

Set yang otomatis terurut.

```java
SortedSet<Integer> sorted = new TreeSet<>(List.of(3,1,2));
```

---

#### NavigableSet

Versi `SortedSet` dengan navigasi tambahan (higher, lower, dsb).

```java
NavigableSet<Integer> nav = new TreeSet<>(List.of(1,2,3));
```

---

#### Queue

Koleksi dengan konsep FIFO (First In First Out).

```java
Queue<String> q = new LinkedList<>();
q.add("A"); q.add("B");
```

---

#### Deque

Double-ended queue (bisa dari dua arah).

```java
Deque<String> dq = new ArrayDeque<>();
dq.addFirst("A"); dq.addLast("B");
```

---

#### Map

Menyimpan pasangan key-value.

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
```

---

#### Immutable Map

Map yang tidak bisa diubah.

```java
Map<String, Integer> map = Map.of("A", 1, "B", 2);
```

---

#### SortedMap

Map dengan key yang terurut.

```java
SortedMap<String, Integer> sm = new TreeMap<>();
```

---

#### NavigableMap

Map dengan navigasi tambahan (higherKey, lowerKey).

```java
NavigableMap<String, Integer> nm = new TreeMap<>();
```

---

#### Entry Map

Representasi pasangan key-value dalam Map.

```java
for (Map.Entry<String,Integer> e : map.entrySet()) System.out.println(e.getKey());
```

---

#### Legacy Collection

Kelas lama seperti `Vector`, `Hashtable`, `Stack` sebelum Java Collections Framework.

---

#### Sorting

Mengurutkan koleksi.

```java
Collections.sort(nums);
```

---

#### Binary Search

Mencari elemen dalam list terurut.

```java
int index = Collections.binarySearch(nums, 2);
```

---

#### Collections Class

Kelas utilitas untuk operasi koleksi.

```java
Collections.reverse(nums);
```

---

#### Abstract Collection

Kelas dasar untuk mempermudah implementasi koleksi kustom.

---

#### Default Method

Metode bawaan dalam interface (Java 8+).

```java
interface A { default void hi(){ System.out.println("Hi"); } }
```

---

#### Spliterator

Iterator dengan dukungan parallel traversal (stream).

```java
list.spliterator().forEachRemaining(System.out::println);
```

---

#### Konversi ke Array

Mengubah koleksi menjadi array.

```java
String[] arr = list.toArray(new String[0]);
```

---

### #2 Sequenced Collection

#### Sequenced Collection

Interface baru (Java 21+) yang memperluas `Collection`, mendukung akses elemen pertama dan terakhir, serta traversal dua arah.

```java
SequencedCollection<String> sc = new ArrayList<>(List.of("A", "B", "C"));
System.out.println(sc.getFirst());
System.out.println(sc.getLast());
```

---

#### Sequenced Set

Turunan dari `Set` + `SequencedCollection`, menjaga urutan elemen saat dimasukkan.

```java
SequencedSet<String> ss = new LinkedHashSet<>(List.of("X", "Y", "Z"));
System.out.println(ss.getFirst());
```

---

#### Sequenced Map

Turunan dari `Map` + `SequencedCollection`, mendukung urutan key-value dan akses entry pertama atau terakhir.

```java
SequencedMap<String, Integer> sm = new LinkedHashMap<>();
sm.put("A", 1);
sm.put("B", 2);
System.out.println(sm.firstEntry());
System.out.println(sm.lastEntry());
```

### #3 Java Generic

#### Pengenalan Generic

Generic memungkinkan pembuatan class atau method yang bekerja dengan berbagai tipe data tanpa kehilangan keamanan tipe.

```java
List<String> list = new ArrayList<>();
list.add("Halo");
```

---

#### Generic Class

Class dengan parameter tipe agar dapat digunakan fleksibel untuk berbagai tipe data.

```java
class Box<T> {
    T value;
    Box(T value) { this.value = value; }
    T get() { return value; }
}
Box<Integer> box = new Box<>(10);
```

---

#### Generic Method

Method yang memiliki parameter tipe sendiri.

```java
class Util {
    static <T> void print(T data) {
        System.out.println(data);
    }
}
Util.print("Test");
```

---

#### Invariant

Tipe generic tidak bisa saling menggantikan meski tipe dasarnya berhubungan.

```java
List<Number> nums = new ArrayList<>();
// List<Integer> ints tidak bisa dianggap List<Number>
```

---

#### Covariant

Dapat membaca data dari turunan, tapi tidak bisa menulis.

```java
List<? extends Number> list = List.of(1, 2, 3);
Number n = list.get(0);
```

---

#### Contravariant

Dapat menulis data turunan, tapi tidak bisa membaca spesifik.

```java
List<? super Integer> list = new ArrayList<>();
list.add(10);
```

---

#### Bounded Type Parameter

Membatasi tipe parameter agar hanya menerima tipe tertentu.

```java
class Data<T extends Number> {
    T value;
}
```

---

#### Wildcard

Digunakan untuk tipe generic yang tidak diketahui.

```java
List<?> data = List.of("A", "B");
Object obj = data.get(0);
```

---

#### Type Erasure

Informasi tipe generic dihapus saat runtime — hanya ada di compile time.

```java
List<String> a = new ArrayList<>();
List<Integer> b = new ArrayList<>();
System.out.println(a.getClass() == b.getClass()); // true
```

---

#### Comparable Interface

Digunakan untuk membandingkan objek berdasarkan urutan alami.

```java
class Person implements Comparable<Person> {
    String name;
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
```

---

#### Comparator Interface

Digunakan untuk membandingkan objek dengan aturan kustom.

```java
Comparator<String> cmp = (a, b) -> a.length() - b.length();
System.out.println(cmp.compare("Hi", "Hello"));
```

### #4 Java Stream

Java Stream adalah fitur di Java 8+ yang digunakan untuk memproses data secara deklaratif (seperti SQL atau functional programming).
Daripada menulis loop manual, kamu cukup menulis urutan operasi seperti filter, map, dan collect.

#### Stream Builder

Digunakan untuk membuat stream secara manual.

```java
Stream<String> stream = Stream.<String>builder()
    .add("A").add("B").add("C")
    .build();
stream.forEach(System.out::println);
```

---

#### Stream Operations

Operasi dibagi menjadi dua: **intermediate** (menghasilkan stream baru) dan **terminal** (menghasilkan hasil akhir).

---

#### Stream Pipeline

Urutan operasi stream dari sumber hingga hasil akhir.

```java
List.of(1, 2, 3, 4)
    .stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * 10)
    .forEach(System.out::println);
```

---

#### Lazy Evaluation

Operasi intermediate tidak dijalankan hingga ada operasi terminal.

---

#### Transformation Operations

Mengubah data dalam stream, seperti `map()` atau `flatMap()`.

```java
List.of("a", "b").stream()
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

---

#### Filtering Operations

Menyaring elemen yang memenuhi kondisi.

```java
List.of(1, 2, 3, 4).stream()
    .filter(n -> n > 2)
    .forEach(System.out::println);
```

---

#### Retrieving Operations

Mengambil sebagian elemen, seperti `limit()` dan `skip()`.

```java
List.of(10, 20, 30, 40).stream()
    .skip(1)
    .limit(2)
    .forEach(System.out::println);
```

---

#### Ordering Operations

Mengurutkan elemen dalam stream.

```java
List.of(3, 1, 2).stream()
    .sorted()
    .forEach(System.out::println);
```

---

#### Aggregate Operations

Menghitung nilai agregat seperti jumlah, rata-rata, atau maksimum.

```java
int sum = List.of(1, 2, 3).stream()
    .mapToInt(Integer::intValue)
    .sum();
```

---

#### Check Operations

Memeriksa kondisi pada elemen, seperti `anyMatch()`, `allMatch()`, atau `noneMatch()`.

```java
boolean result = List.of(1, 2, 3).stream()
    .anyMatch(n -> n > 2);
```

---

#### For Each Operations

Menjalankan aksi untuk setiap elemen stream.

```java
List.of("A", "B", "C").stream()
    .forEach(System.out::println);
```

---

#### Primitive Stream

Stream khusus tipe primitif (`IntStream`, `LongStream`, `DoubleStream`).

```java
IntStream.range(1, 4).forEach(System.out::println);
```

---

#### Collectors

Mengumpulkan hasil stream ke bentuk lain seperti List, Set, atau Map.

```java
List<Integer> list = List.of(1, 2, 3).stream()
    .collect(Collectors.toList());
```

---

#### Grouping By

Mengelompokkan data berdasarkan kriteria tertentu.

```java
Map<Integer, List<String>> grouped = 
    List.of("aa", "bbb", "cc").stream()
        .collect(Collectors.groupingBy(String::length));
```

---

#### Parallel Stream

Memproses stream secara paralel untuk meningkatkan performa.

```java
List.of(1, 2, 3, 4).parallelStream()
    .forEach(System.out::println);
```

---

## 3️⃣ Input/Output & Data Format

### #1 Java Input/Output

#### File

Representasi abstrak dari file atau folder di sistem.

```java
File file = new File("data.txt");
System.out.println(file.exists());
```

---

#### Path

Digunakan untuk memanipulasi path secara modern (sejak Java NIO).

```java
Path path = Paths.get("data.txt");
System.out.println(path.toAbsolutePath());
```

---

#### Manipulasi File

Operasi membuat, menyalin, memindah, atau menghapus file.

```java
Files.copy(Paths.get("a.txt"), Paths.get("b.txt"), StandardCopyOption.REPLACE_EXISTING);
```

---

#### Manipulasi Directory

Membuat atau membaca direktori.

```java
Files.createDirectory(Paths.get("folderBaru"));
Files.list(Paths.get(".")).forEach(System.out::println);
```

---

#### Closable Interface

Digunakan oleh class yang perlu ditutup setelah digunakan.

```java
try (FileInputStream fis = new FileInputStream("data.txt")) {
    System.out.println(fis.read());
}
```

---

#### Numeric dan Character Data

Input/output bisa berbasis **byte (numeric)** atau **karakter (text)**.
`InputStream`/`OutputStream` untuk byte,
`Reader`/`Writer` untuk karakter.

---

#### Menulis File Kecil

Menulis teks langsung ke file.

```java
Files.writeString(Paths.get("test.txt"), "Halo Dunia");
```

---

#### Membaca File Kecil

Membaca teks langsung dari file.

```java
String content = Files.readString(Paths.get("test.txt"));
System.out.println(content);
```

---

#### Input Stream

Membaca data biner dari sumber.

```java
InputStream in = new FileInputStream("input.bin");
int data = in.read();
in.close();
```

---

#### Output Stream

Menulis data biner ke tujuan.

```java
OutputStream out = new FileOutputStream("output.bin");
out.write(65);
out.close();
```

---

#### Reader

Membaca data berbasis karakter.

```java
Reader reader = new FileReader("text.txt");
int c = reader.read();
reader.close();
```

---

#### Writer

Menulis data berbasis karakter.

```java
Writer writer = new FileWriter("text.txt");
writer.write("Halo");
writer.close();
```

---

#### Open Option

Menentukan opsi saat membuka file seperti `CREATE`, `APPEND`, atau `TRUNCATE_EXISTING`.

```java
Files.writeString(Paths.get("log.txt"), "Data", StandardOpenOption.APPEND);
```

---

#### Object Stream

Digunakan untuk menyimpan dan membaca objek Java (serialization).

```java
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("obj.bin"));
out.writeObject("Hello");
out.close();
```

---

#### Memory Stream

Menyimpan data sementara di memori, bukan file.

```java
ByteArrayOutputStream mem = new ByteArrayOutputStream();
mem.write(65);
System.out.println(mem.toString());
```

---

#### Print Stream

Menulis output dengan format mirip `System.out`.

```java
PrintStream ps = new PrintStream("print.txt");
ps.println("Halo Dunia");
ps.close();
```

---

#### Scanner

Membaca input teks dengan mudah dari berbagai sumber.

```java
Scanner sc = new Scanner(new File("text.txt"));
while (sc.hasNextLine()) System.out.println(sc.nextLine());
```

---

#### IO Stream Lainnya

Java menyediakan stream tambahan seperti `BufferedReader`, `BufferedWriter`, dan `DataOutputStream` untuk efisiensi dan format data tertentu.

### #2 Java CSV

#### Pengenalan Apache Commons CSV

Library populer untuk membaca dan menulis file CSV secara mudah dan aman.

---

#### Membuat Project

Tambahkan dependency berikut ke `pom.xml`:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>1.10.0</version>
</dependency>
```

---

#### Membuat CSV

Menulis data ke file CSV.

```java
try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data.csv"));
     CSVPrinter csv = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
    csv.printRecord("Nama", "Umur");
    csv.printRecord("Red", 22);
    csv.printRecord("Horizon", 25);
}
```

---

#### Membaca CSV

Membaca isi file CSV baris per baris.

```java
try (Reader reader = Files.newBufferedReader(Paths.get("data.csv"));
     CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
    for (CSVRecord record : parser) {
        System.out.println(record.get("Nama") + " - " + record.get("Umur"));
    }
}
```

---

#### CSV Header

Menentukan nama kolom agar mudah diakses.

```java
CSVFormat format = CSVFormat.DEFAULT
    .builder()
    .setHeader("Nama", "Umur")
    .setSkipHeaderRecord(true)
    .build();
```

---

#### CSV Format

Mengatur format seperti delimiter, quote, atau escape character.

```java
CSVFormat format = CSVFormat.DEFAULT
    .withDelimiter(';')
    .withQuote('"')
    .withRecordSeparator("\n");
```

### #3 Java JSON

#### Pengenalan JSON

JSON (JavaScript Object Notation) adalah format ringan untuk pertukaran data antar sistem, berbasis key-value dan mudah dibaca manusia.

---

#### Pengenalan Jackson

Jackson adalah library populer untuk membaca, menulis, dan memetakan data JSON ke objek Java (dan sebaliknya).

---

#### Membuat Project

Tambahkan dependency berikut ke `pom.xml`:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

---

#### Object Mapper

Kelas utama di Jackson untuk konversi JSON dan Object.

```java
ObjectMapper mapper = new ObjectMapper();
```

---

#### Membuat JSON Object

Membuat JSON menggunakan `ObjectNode`.

```java
ObjectMapper mapper = new ObjectMapper();
ObjectNode obj = mapper.createObjectNode();
obj.put("nama", "Red");
obj.put("umur", 22);
System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
```

---

#### Membaca JSON Object

Membaca string JSON menjadi `JsonNode`.

```java
String json = "{\"nama\":\"Red\",\"umur\":22}";
JsonNode node = mapper.readTree(json);
System.out.println(node.get("nama").asText());
```

---

#### Membuat JSON Array

Membuat array JSON menggunakan `ArrayNode`.

```java
ArrayNode arr = mapper.createArrayNode();
arr.add("Red");
arr.add("Horizon");
System.out.println(mapper.writeValueAsString(arr));
```

---

#### Membaca JSON Array

Membaca data array dari JSON.

```java
String json = "[\"A\", \"B\", \"C\"]";
ArrayNode arr = (ArrayNode) mapper.readTree(json);
System.out.println(arr.get(0).asText());
```

---

#### Konversi Object ke JSON

Mengubah object Java ke string JSON.

```java
record User(String name, int age) {}
String json = mapper.writeValueAsString(new User("Red", 22));
System.out.println(json);
```

---

#### Konversi JSON ke Object

Mengubah JSON menjadi object Java.

```java
String json = "{\"name\":\"Red\",\"age\":22}";
User user = mapper.readValue(json, User.class);
System.out.println(user.name());
```

---

#### Mapper Feature

Mengaktifkan atau menonaktifkan fitur pada `ObjectMapper`.

```java
mapper.enable(SerializationFeature.INDENT_OUTPUT);
```

---

#### Deserialization Feature

Mengatur perilaku saat membaca JSON.

```java
mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
```

---

#### Serialization Feature

Mengatur perilaku saat menulis JSON.

```java
mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
```

---

#### Serialization Inclusion

Mengatur agar hanya field tertentu yang diserialisasi.

```java
mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
```

---

#### Date Time

Jackson dapat mengonversi `LocalDateTime` otomatis.

```java
mapper.registerModule(new JavaTimeModule());
```

---

#### Jackson Annotation

Anotasi untuk mengontrol perilaku JSON pada class.

```java
class User {
    @JsonProperty("nama")
    String name;
    @JsonIgnore
    int age;
}
```

---

## 4️⃣ Date, Time & Utility

Java menyediakan berbagai kelas untuk bekerja dengan tanggal, waktu, dan utilitas lainnya.

### `java.util.Date`

Kelas `Date` merepresentasikan tanggal dan waktu tertentu.

```java
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        // Membuat objek Date saat ini
        Date currentDate = new Date();
        System.out.println("Current Date: " + currentDate);

        // Membuat objek Date dari milidetik sejak Epoch (1 Januari 1970, 00:00:00 GMT)
        Date epochDate = new Date(0L); // 0 milidetik
        System.out.println("Epoch Date: " + epochDate);

        // Membandingkan dua tanggal
        Date anotherDate = new Date(currentDate.getTime() + 3600 * 1000); // Satu jam setelahnya
        System.out.println("Another Date: " + anotherDate);

        boolean isAfter = currentDate.after(epochDate);
        System.out.println("Current Date is after Epoch Date: " + isAfter);

        boolean isBefore = currentDate.before(anotherDate);
        System.out.println("Current Date is before Another Date: " + isBefore);
    }
}
```

### `java.time.LocalDate` (Java 8 ke atas)

Dengan Java 8, diperkenalkan API Tanggal dan Waktu baru (`java.time`) yang lebih modern dan mudah digunakan. `LocalDate` merepresentasikan tanggal tanpa waktu dan zona waktu.

```java
import java.time.LocalDate;
import java.time.Month;

public class LocalDateExample {
    public static void main(String[] args) {
        // Tanggal saat ini
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        // Tanggal tertentu
        LocalDate specificDate = LocalDate.of(2023, Month.JANUARY, 15);
        System.out.println("Specific Date: " + specificDate);

        // Mendapatkan bagian dari tanggal
        int year = specificDate.getYear();
        Month month = specificDate.getMonth();
        int dayOfMonth = specificDate.getDayOfMonth();
        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + dayOfMonth);

        // Menambah atau mengurangi hari, bulan, tahun
        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("Next Week: " + nextWeek);

        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Last Month: " + lastMonth);

        // Membandingkan tanggal
        boolean isBefore = specificDate.isBefore(today);
        System.out.println("Specific Date is before Today: " + isBefore);
    }
}
### #1 Java Date & Time API

Java 8 memperkenalkan Date and Time API baru (`java.time`) yang lebih modern, immutable, dan thread-safe dibandingkan dengan `java.util.Date` dan `java.util.Calendar` yang lama.

#### Pengenalan Date dan Time API

API ini dirancang untuk mengatasi kekurangan dari API tanggal dan waktu sebelumnya, seperti masalah thread-safety dan desain yang kurang intuitif.

#### `LocalDate`

Merepresentasikan tanggal tanpa waktu dan zona waktu.

```java
import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); // Tanggal saat ini
        System.out.println("Today: " + today);

        LocalDate specificDate = LocalDate.of(2023, 1, 15); // Tanggal tertentu
        System.out.println("Specific Date: " + specificDate);

        System.out.println("Year: " + specificDate.getYear());
        System.out.println("Month: " + specificDate.getMonth());
        System.out.println("Day of Month: " + specificDate.getDayOfMonth());
    }
}
```

#### `LocalTime`

Merepresentasikan waktu tanpa tanggal dan zona waktu.

```java
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now(); // Waktu saat ini
        System.out.println("Current Time: " + now);

        LocalTime specificTime = LocalTime.of(10, 30, 45); // Waktu tertentu
        System.out.println("Specific Time: " + specificTime);

        System.out.println("Hour: " + specificTime.getHour());
        System.out.println("Minute: " + specificTime.getMinute());
        System.out.println("Second: " + specificTime.getSecond());
    }
}
```

#### `LocalDateTime`

Kombinasi `LocalDate` dan `LocalTime`, merepresentasikan tanggal dan waktu tanpa zona waktu.

```java
import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // Tanggal dan waktu saat ini
        System.out.println("Current DateTime: " + now);

        LocalDateTime specificDateTime = LocalDateTime.of(2023, 1, 15, 10, 30, 45);
        System.out.println("Specific DateTime: " + specificDateTime);

        // Menambah atau mengurangi
        LocalDateTime future = now.plusDays(5).plusHours(2);
        System.out.println("Future DateTime: " + future);
    }
}
```

#### `Year`, `YearMonth`, dan `MonthDay`

Kelas-kelas ini merepresentasikan bagian tertentu dari tanggal.

```java
import java.time.Year;
import java.time.YearMonth;
import java.time.MonthDay;

public class PartialDateExample {
    public static void main(String[] args) {
        Year currentYear = Year.now();
        System.out.println("Current Year: " + currentYear);

        YearMonth currentYearMonth = YearMonth.now();
        System.out.println("Current YearMonth: " + currentYearMonth);

        MonthDay currentMonthDay = MonthDay.now();
        System.out.println("Current MonthDay: " + currentMonthDay);
    }
}
```

#### `ZoneId` dan `ZoneOffset`

`ZoneId` merepresentasikan identifikasi zona waktu (misalnya "Asia/Jakarta"), sedangkan `ZoneOffset` merepresentasikan offset dari UTC (misalnya "+07:00").

```java
import java.time.ZoneId;
import java.time.ZoneOffset;

public class ZoneExample {
    public static void main(String[] args) {
        ZoneId jakartaZone = ZoneId.of("Asia/Jakarta");
        System.out.println("Jakarta ZoneId: " + jakartaZone);

        ZoneOffset offset = ZoneOffset.of("+07:00");
        System.out.println("Offset +07:00: " + offset);
    }
}
```

#### `ZonedDateTime`

Merepresentasikan tanggal dan waktu dengan zona waktu.

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime nowInJakarta = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
        System.out.println("Current time in Jakarta: " + nowInJakarta);

        ZonedDateTime specificZoned = ZonedDateTime.of(2023, 1, 15, 10, 30, 0, 0, ZoneId.of("Europe/London"));
        System.out.println("Specific time in London: " + specificZoned);
    }
}
```

#### `OffsetTime` dan `OffsetDateTime`

Merepresentasikan waktu atau tanggal-waktu dengan offset dari UTC/Greenwich, tanpa informasi zona waktu lengkap.

```java
import java.time.OffsetTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetExample {
    public static void main(String[] args) {
        OffsetTime offsetTime = OffsetTime.now(ZoneOffset.ofHours(7));
        System.out.println("Offset Time (+07:00): " + offsetTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneOffset.ofHours(-5));
        System.out.println("Offset DateTime (-05:00): " + offsetDateTime);
    }
}
```

#### `Instant`

Merepresentasikan titik waktu pada garis waktu dalam UTC, dengan presisi nanodetik. Berguna untuk merekam timestamp.

```java
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now(); // Waktu saat ini dalam UTC
        System.out.println("Current Instant: " + now);

        Instant epoch = Instant.EPOCH; // 1970-01-01T00:00:00Z
        System.out.println("Epoch Instant: " + epoch);
    }
}
```

#### `Clock`

Abstraksi untuk mendapatkan waktu saat ini. Berguna untuk pengujian karena bisa dimock.

```java
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ClockExample {
    public static void main(String[] args) {
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Current Instant from Default Clock: " + defaultClock.instant());

        Clock fixedClock = Clock.fixed(Instant.parse("2023-01-15T10:00:00Z"), ZoneId.of("UTC"));
        System.out.println("Fixed Instant from Fixed Clock: " + fixedClock.instant());
    }
}
```

#### `Duration`

Merepresentasikan durasi waktu dalam satuan detik dan nanodetik.

```java
import java.time.Duration;
import java.time.LocalTime;

public class DurationExample {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(9, 0, 0);
        LocalTime end = LocalTime.of(10, 30, 0);

        Duration duration = Duration.between(start, end);
        System.out.println("Duration in hours: " + duration.toHours());
        System.out.println("Duration in minutes: " + duration.toMinutes());

        Duration oneHour = Duration.ofHours(1);
        System.out.println("One Hour Duration: " + oneHour);
    }
}
```

#### `Period`

Merepresentasikan durasi waktu dalam satuan tahun, bulan, dan hari.

```java
import java.time.Period;
import java.time.LocalDate;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 5, 10);

        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");

        Period fiveDays = Period.ofDays(5);
        System.out.println("Five Days Period: " + fiveDays);
    }
}
```

#### `Temporal`

Interface dasar yang merepresentasikan objek tanggal dan waktu. Semua kelas `java.time` mengimplementasikan interface ini.

```java
import java.time.temporal.Temporal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TemporalExample {
    public static void main(String[] args) {
        Temporal date = LocalDate.now();
        Temporal dateTime = LocalDateTime.now();

        System.out.println("Is LocalDate a Temporal? " + (date instanceof Temporal));
        System.out.println("Is LocalDateTime a Temporal? " + (dateTime instanceof Temporal));
    }
}
```

#### `DayOfWeek`

Enum yang merepresentasikan hari dalam seminggu (Senin hingga Minggu).

```java
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DayOfWeek day = today.getDayOfWeek();
        System.out.println("Today is: " + day);
        System.out.println("Is today a weekend? " + (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY));
    }
}
```

#### Parsing dan Formatting

Menggunakan `DateTimeFormatter` untuk mengonversi objek tanggal/waktu ke string dan sebaliknya.

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        // Parsing
        String dateString = "15-01-2023 10:30:00";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateString, formatter);
        System.out.println("Parsed DateTime: " + parsedDateTime);
    }
}
```

#### Legacy Date dan Time

Meskipun API baru lebih disarankan, terkadang perlu berinteraksi dengan kelas `java.util.Date` dan `java.util.Calendar` yang lama.

```java
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Calendar;

public class LegacyDateTimeExample {
    public static void main(String[] args) {
        // Konversi dari Legacy ke New API
        Date legacyDate = new Date();
        LocalDateTime newDateTime = legacyDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Legacy Date to New API: " + newDateTime);

        // Konversi dari New API ke Legacy
        LocalDateTime currentNewDateTime = LocalDateTime.now();
        Date newToLegacyDate = Date.from(currentNewDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("New API to Legacy Date: " + newToLegacyDate);

        // Contoh Calendar
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar Year: " + calendar.get(Calendar.YEAR));
    }
}


### #2 Java Logging

Logging adalah mekanisme penting dalam pengembangan aplikasi untuk merekam informasi tentang eksekusi program, seperti pesan error, peringatan, atau informasi debug. Java memiliki API logging bawaan (`java.util.logging`), tetapi banyak proyek menggunakan library logging pihak ketiga yang lebih canggih seperti Log4j atau SLF4J/Logback.

#### Logging Library

Java menyediakan `java.util.logging` (JUL) sebagai API logging bawaan. Namun, library pihak ketiga seperti Log44j2 dan Logback (sering digunakan bersama SLF4J sebagai facade) lebih populer karena fitur yang lebih kaya dan fleksibilitas.

#### Membuat Project (dengan Log4j2 sebagai contoh)

Untuk menggunakan Log4j2, tambahkan dependency berikut ke `pom.xml` Anda:

```xml
<dependencies>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.23.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.23.1</version>
    </dependency>
</dependencies>
```

#### Logger

Objek `Logger` digunakan untuk mengeluarkan pesan log. Anda bisa mendapatkan instance logger untuk class tertentu.

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyClass {
    private static final Logger logger = LogManager.getLogger(MyClass.class);

    public void doSomething() {
        logger.info("Melakukan sesuatu...");
        logger.debug("Variabel x: {}", 10);
    }

    public static void main(String[] args) {
        new MyClass().doSomething();
    }
}
```

#### Level

Level log menunjukkan tingkat keparahan atau kepentingan pesan log. Urutan dari yang paling spesifik ke paling umum:

* `TRACE`: Informasi yang sangat detail, biasanya hanya untuk debugging internal.
* `DEBUG`: Informasi debugging yang lebih umum.
* `INFO`: Pesan informatif tentang kemajuan aplikasi.
* `WARN`: Potensi masalah yang tidak menghentikan aplikasi.
* `ERROR`: Kesalahan yang mungkin menghentikan sebagian fungsionalitas.
* `FATAL`: Kesalahan kritis yang menyebabkan aplikasi berhenti.

```java
logger.trace("Pesan TRACE");
logger.debug("Pesan DEBUG");
logger.info("Pesan INFO");
logger.warn("Pesan WARN");
logger.error("Pesan ERROR");
logger.fatal("Pesan FATAL");
```

#### Log Format

Format pesan log dapat dikonfigurasi untuk menyertakan informasi seperti timestamp, level, nama logger, thread, dan pesan itu sendiri.

#### Configuration

Library logging biasanya dikonfigurasi melalui file eksternal (misalnya `log4j2.xml`, `logback.xml`) atau secara programatik. Ini memungkinkan Anda menentukan level log, appender, dan layout tanpa mengubah kode aplikasi.

Contoh `log4j2.xml` (tempatkan di `src/main/resources`):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="File" fileName="logs/app.log">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="File"/>
        </Root>
    </Loggers>
</Configuration>
```

#### Appender

Appender menentukan tujuan output log (misalnya, konsol, file, database, atau remote server).

* `ConsoleAppender`: Mengirim log ke konsol.
* `FileAppender`: Mengirim log ke file.
* `RollingFileAppender`: Mengirim log ke file dengan rotasi (misalnya, berdasarkan ukuran atau waktu).

#### Layout

Layout menentukan format pesan log. `PatternLayout` adalah yang paling umum, menggunakan pola untuk memformat output.

* `%d`: Tanggal dan waktu
* `%t`: Nama thread
* `%-5level`: Level log (rata kiri, lebar 5 karakter)
* `%logger{36}`: Nama logger (maksimal 36 karakter)
* `%msg`: Pesan log
* `%n`: Baris baru

#### Mapped Diagnostic Context (MDC)

MDC memungkinkan Anda untuk menyimpan informasi kontekstual (misalnya, ID transaksi, ID pengguna) yang secara otomatis akan disertakan dalam setiap pesan log yang dikeluarkan oleh thread saat ini. Ini sangat berguna untuk melacak alur eksekusi dalam aplikasi multi-threaded.

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class MDCExample {
    private static final Logger logger = LogManager.getLogger(MDCExample.class);

    public void processOrder(String orderId, String userId) {
        ThreadContext.put("orderId", orderId);
        ThreadContext.put("userId", userId);

        logger.info("Memproses pesanan.");
        // Log lain dalam metode ini akan otomatis menyertakan orderId dan userId

        ThreadContext.remove("orderId"); // Penting untuk membersihkan MDC
        ThreadContext.remove("userId");
    }

    public static void main(String[] args) {
        new MDCExample().processOrder("ORD-123", "USER-456");
    }
}
```

Untuk melihat output MDC, Anda perlu menambahkan `%X{key}` ke `PatternLayout` di konfigurasi Log4j2 Anda:

```xml
<PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - [orderId=%X{orderId}, userId=%X{userId}] %msg%n"/>
```

### #3 Java Validation

Validasi data adalah proses memastikan bahwa input atau data yang digunakan dalam aplikasi memenuhi kriteria atau aturan tertentu. Java menyediakan Bean Validation API (JSR 380) yang merupakan standar untuk validasi objek Java. Hibernate Validator adalah implementasi referensi dari Bean Validation.

#### Validator

Interface utama dalam Bean Validation API yang digunakan untuk melakukan validasi pada objek.

#### Constraint

Anotasi yang digunakan untuk mendefinisikan aturan validasi pada field, method, atau class. Contoh: `@NotNull`, `@Size`, `@Min`, `@Max`, `@Email`.

#### Constraint Validator

Implementasi logika validasi untuk sebuah constraint. Setiap anotasi constraint memiliki `ConstraintValidator` yang sesuai.

#### Membuat Project (dengan Hibernate Validator)

Tambahkan dependency berikut ke `pom.xml` Anda:

```xml
<dependencies>
    <dependency>
        <groupId>org.hibernate.validator</groupId>
        <artifactId>hibernate-validator</artifactId>
        <version>8.0.1.Final</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish</groupId>
        <artifactId>jakarta.el</artifactId>
        <version>4.0.2</version>
    </dependency>
</dependencies>
```

#### Contoh Validasi Dasar

```java
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

public class User {

    @NotBlank(message = "Nama tidak boleh kosong")
    @Size(min = 3, max = 50, message = "Nama harus antara 3 dan 50 karakter")
    private String name;

    @Min(value = 18, message = "Usia harus minimal 18 tahun")
    private int age;

    @Email(message = "Format email tidak valid")
    @NotBlank(message = "Email tidak boleh kosong")
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        User user1 = new User("Red", 17, "red@example.com"); // Usia kurang dari 18
        Set<ConstraintViolation<User>> violations1 = validator.validate(user1);
        violations1.forEach(v -> System.out.println("User1 Error: " + v.getMessage()));

        User user2 = new User("", 20, "invalid-email"); // Nama kosong, email tidak valid
        Set<ConstraintViolation<User>> violations2 = validator.validate(user2);
        violations2.forEach(v -> System.out.println("User2 Error: " + v.getMessage()));

        User user3 = new User("Horizon", 25, "horizon@example.com"); // Valid
        Set<ConstraintViolation<User>> violations3 = validator.validate(user3);
        if (violations3.isEmpty()) {
            System.out.println("User3 Valid: " + user3.getName());
        }
    }
}
```

#### Nested Validation

Memvalidasi objek yang merupakan properti dari objek lain. Gunakan `@Valid`.

```java
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

class Address {
    @NotBlank
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

class Customer {
    @NotBlank
    private String name;

    @Valid // Penting untuk validasi nested object
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Customer customer = new Customer("", new Address(""));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        violations.forEach(v -> System.out.println("Customer Error: " + v.getMessage()));
    }
}
```

#### Hibernate Validator Constraint

Hibernate Validator menyediakan constraint tambahan selain yang ada di Bean Validation API, seperti `@URL`, `@CreditCardNumber`, dll.

#### Grouping Constraint

Memungkinkan Anda untuk mengelompokkan constraint dan memvalidasi hanya grup tertentu. Berguna untuk skenario seperti validasi saat membuat (`Create.class`) atau memperbarui (`Update.class`) objek.

```java
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.groups.Default;

interface Create {}
interface Update {}

@GroupSequence({Create.class, Default.class}) // Urutan validasi
class Product {
    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private String id;

    @NotBlank(groups = {Create.class, Default.class})
    private String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        // Validasi untuk Create
        Product newProduct = new Product(null, "Laptop");
        Set<ConstraintViolation<Product>> createViolations = validator.validate(newProduct, Create.class);
        System.out.println("Create Violations: " + createViolations.size());

        // Validasi untuk Update
        Product existingProduct = new Product("P001", "Monitor");
        Set<ConstraintViolation<Product>> updateViolations = validator.validate(existingProduct, Update.class);
        System.out.println("Update Violations: " + updateViolations.size());
    }
}
```

#### Group Sequence

Menentukan urutan validasi grup. Jika ada kegagalan dalam grup pertama, grup berikutnya tidak akan divalidasi.

#### Group Conversion

Mengonversi grup validasi dari objek induk ke objek anak.

#### Payload

Memungkinkan Anda untuk melampirkan objek arbitrer ke constraint violation, berguna untuk informasi tambahan seperti kode error.

#### Method Validation

Validasi parameter dan return value dari method. Membutuhkan AOP (Aspect-Oriented Programming) atau proxy.

```java
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.executable.ValidateOnExecution;

public class UserService {

    @ValidateOnExecution
    public String createUser(@NotBlank String username, @Min(18) int age) {
        // Logika pembuatan user
        return "User " + username + " created.";
    }

    public static void main(String[] args) {
        // Method validation biasanya diintegrasikan dengan framework seperti Spring
        // atau menggunakan ValidatorFactory untuk mendapatkan ExecutableValidator
    }
}
```

#### Constructor Validation

Validasi parameter constructor.

#### Message Interpolation

Proses mengganti placeholder dalam pesan validasi (misalnya `{message}`) dengan nilai aktual.

#### Message Internationalization

Menggunakan `ResourceBundle` untuk menyediakan pesan validasi dalam berbagai bahasa.

#### Custom Constraint

Membuat anotasi constraint kustom Anda sendiri untuk logika validasi yang spesifik.

1. **Anotasi Constraint:**

   ```java
   import jakarta.validation.Constraint;
   import jakarta.validation.Payload;
   import java.lang.annotation.*;

   @Documented
   @Constraint(validatedBy = EvenNumberValidator.class)
   @Target({ElementType.FIELD, ElementType.PARAMETER})
   @Retention(RetentionPolicy.RUNTIME)
   public @interface EvenNumber {
       String message() default "Harus angka genap";
       Class<?>[] groups() default {};
       Class<? extends Payload>[] payload() default {};
   }
   ```
2. **Implementasi Validator:**

   ```java
   import jakarta.validation.ConstraintValidator;
   import jakarta.validation.ConstraintValidatorContext;

   public class EvenNumberValidator implements ConstraintValidator<EvenNumber, Integer> {
       @Override
       public boolean isValid(Integer value, ConstraintValidatorContext context) {
           if (value == null) {
               return true; // @NotNull harus digunakan secara terpisah jika tidak boleh null
           }
           return value % 2 == 0;
       }
   }
   ```
3. **Penggunaan:**

   ```java
   class MyData {
       @EvenNumber
       private Integer number;

       public MyData(Integer number) {
           this.number = number;
       }

       public Integer getNumber() {
           return number;
       }

       public static void main(String[] args) {
           Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
           MyData data = new MyData(7);
           Set<ConstraintViolation<MyData>> violations = validator.validate(data);
           violations.forEach(v -> System.out.println("Error: " + v.getMessage()));
       }
   }
   ```

#### Constraint Composition

Menggabungkan beberapa constraint yang sudah ada menjadi satu constraint kustom.

#### Class Level Constraint

Constraint yang memvalidasi seluruh objek, bukan hanya satu field. Membutuhkan anotasi pada level class dan `ConstraintValidator` yang menerima objek class tersebut.

#### Cross Parameter Constraint

Validasi yang melibatkan beberapa parameter method atau constructor.

#### Constraint Validator Context

Objek yang disediakan untuk `ConstraintValidator` untuk mengontrol pesan error, menonaktifkan pesan default, atau menambahkan pesan kustom.

#### Constraint Descriptor

Memberikan metadata tentang constraint yang diterapkan.

#### Container Data

Validasi elemen dalam koleksi atau `Optional`.

#### Value Extraction

Mengekstrak nilai dari container untuk validasi.

#### Constraint Violation Exception

Exception yang dilemparkan ketika validasi gagal, berisi set `ConstraintViolation`.

#### Metadata

Informasi tentang constraint yang diterapkan pada bean, dapat diakses melalui `ValidatorFactory`.

### #4 Java Internationalization

Internationalization (i18n) adalah proses merancang aplikasi agar dapat diadaptasi ke berbagai bahasa dan wilayah tanpa perubahan rekayasa. Ini melibatkan penanganan teks, format tanggal/waktu, angka, mata uang, dan lainnya sesuai dengan `Locale` pengguna.

#### `Locale`

Objek `Locale` merepresentasikan wilayah geografis, bahasa, dan varian budaya tertentu. Ini adalah dasar untuk i18n di Java.

```java
import java.util.Locale;

public class LocaleExample {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        System.out.println("Default Locale: " + defaultLocale);

        Locale usLocale = new Locale("en", "US"); // Bahasa Inggris, Amerika Serikat
        System.out.println("US Locale: " + usLocale);

        Locale idLocale = new Locale("in", "ID"); // Bahasa Indonesia, Indonesia
        System.out.println("ID Locale: " + idLocale);
    }
}
```

#### `ResourceBundle`

Digunakan untuk menyimpan teks atau pesan yang berbeda untuk setiap `Locale`. Ini memungkinkan aplikasi menampilkan teks yang sesuai dengan bahasa pengguna.

1. **Buat file properti:**

   * `messages.properties` (default):

     ```properties
     greeting=Hello
     farewell=Goodbye
     ```
   * `messages_in_ID.properties` (untuk Bahasa Indonesia):

     ```properties
     greeting=Halo
     farewell=Sampai jumpa
     ```
2. **Gunakan di kode Java:**

   ```java
   import java.util.Locale;
   import java.util.ResourceBundle;

   public class ResourceBundleExample {
       public static void main(String[] args) {
           // Menggunakan default locale
           ResourceBundle bundleDefault = ResourceBundle.getBundle("messages");
           System.out.println("Default Greeting: " + bundleDefault.getString("greeting"));

           // Menggunakan locale Indonesia
           Locale indonesia = new Locale("in", "ID");
           ResourceBundle bundleID = ResourceBundle.getBundle("messages", indonesia);
           System.out.println("Indonesian Greeting: " + bundleID.getString("greeting"));
       }
   }
   ```

#### I18N di Date dan Time

Menggunakan `DateFormat` atau `DateTimeFormatter` untuk memformat tanggal dan waktu sesuai dengan `Locale`.

```java
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class DateTimeI18nExample {
    public static void main(String[] args) {
        Date now = new Date();
        Locale usLocale = new Locale("en", "US");
        Locale idLocale = new Locale("in", "ID");

        // Legacy DateFormat
        DateFormat usDateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, usLocale);
        DateFormat idDateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, idLocale);

        System.out.println("US Date: " + usDateFormat.format(now));
        System.out.println("ID Date: " + idDateFormat.format(now));

        // Modern DateTimeFormatter (Java 8+)
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter usFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(usLocale);
        DateTimeFormatter idFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(idLocale);

        System.out.println("US LocalDateTime: " + localDateTime.format(usFormatter));
        System.out.println("ID LocalDateTime: " + localDateTime.format(idFormatter));
    }
}
```

#### I18N di Number

Menggunakan `NumberFormat` untuk memformat angka sesuai dengan `Locale`.

```java
import java.text.NumberFormat;
import java.util.Locale;

public class NumberI18nExample {
    public static void main(String[] args) {
        double number = 1234567.89;
        Locale usLocale = new Locale("en", "US");
        Locale idLocale = new Locale("in", "ID");

        NumberFormat usFormat = NumberFormat.getNumberInstance(usLocale);
        NumberFormat idFormat = NumberFormat.getNumberInstance(idLocale);

        System.out.println("US Number: " + usFormat.format(number));
        System.out.println("ID Number: " + idFormat.format(number));
    }
}
```

#### I18N di Currency

Menggunakan `NumberFormat` dengan gaya mata uang untuk memformat nilai mata uang sesuai dengan `Locale`.

```java
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyI18nExample {
    public static void main(String[] args) {
        double amount = 1234.56;
        Locale usLocale = new Locale("en", "US");
        Locale idLocale = new Locale("in", "ID");

        NumberFormat usCurrency = NumberFormat.getCurrencyInstance(usLocale);
        NumberFormat idCurrency = NumberFormat.getCurrencyInstance(idLocale);

        System.out.println("US Currency: " + usCurrency.format(amount));
        System.out.println("ID Currency: " + idCurrency.format(amount));
    }
}
```

#### `MessageFormat`

Digunakan untuk membuat pesan yang terinternasionalisasi dengan placeholder yang dapat diganti dengan nilai dinamis.

```java
import java.text.MessageFormat;
import java.util.Locale;

public class MessageFormatExample {
    public static void main(String[] args) {
        String pattern = "Pada {0}, {1} memiliki {2,number,integer} pesan baru.";
        MessageFormat mf = new MessageFormat(pattern, new Locale("in", "ID"));

        Object[] arguments = {
            new Date(),
            "Red Horizon",
            10
        };

        String result = mf.format(arguments);
        System.out.println(result);
    }
}
```

#### Message Format Type

`MessageFormat` mendukung berbagai tipe format untuk placeholder, seperti `number`, `date`, `time`, `choice`.

#### `ChoiceFormat`

Subclass dari `MessageFormat` yang memungkinkan Anda memilih format pesan berdasarkan nilai numerik. Berguna untuk pluralisasi (misalnya, "1 file", "2 files").

```java
import java.text.ChoiceFormat;
import java.text.MessageFormat;

public class ChoiceFormatExample {
    public static void main(String[] args) {
        double[] limits = {0, 1, 2};
        String[] formats = {"tidak ada file", "satu file", "{2,number} file"};
        ChoiceFormat cf = new ChoiceFormat(limits, formats);

        MessageFormat mf = new MessageFormat("Anda memiliki {0}.", Locale.ENGLISH);
        mf.setFormatByArgumentIndex(0, cf);

        System.out.println(mf.format(new Object[]{0, ""}));
        System.out.println(mf.format(new Object[]{1, ""}));
        System.out.println(mf.format(new Object[]{5, ""}));
    }
}
```

## 5️⃣ Concurrency & Parallelism

Concurrency dan Parallelism adalah konsep penting dalam pengembangan aplikasi modern untuk meningkatkan responsivitas dan performa. Concurrency berarti beberapa tugas dapat berjalan secara bersamaan (overlapping), sedangkan Parallelism berarti beberapa tugas benar-benar berjalan pada saat yang sama (simultan).

### #1 Java Thread

Thread adalah unit eksekusi terkecil dalam sebuah proses. Java menyediakan dukungan bawaan untuk multi-threading, memungkinkan aplikasi untuk melakukan beberapa tugas secara bersamaan.

#### Thread

Ada dua cara utama untuk membuat thread di Java:

1. **Mewarisi dari class `Thread`:**

   ```java
   class MyThread extends Thread {
       public void run() {
           System.out.println("Thread berjalan: " + Thread.currentThread().getName());
       }
   }

   public class ThreadExample {
       public static void main(String[] args) {
           MyThread thread1 = new MyThread();
           thread1.start(); // Memulai eksekusi thread
       }
   }
   ```
2. **Mengimplementasikan interface `Runnable`:** (Lebih disarankan karena memungkinkan class Anda mewarisi class lain)

   ```java
   class MyRunnable implements Runnable {
       public void run() {
           System.out.println("Runnable berjalan: " + Thread.currentThread().getName());
       }
   }

   public class RunnableExample {
       public static void main(String[] args) {
           Thread thread2 = new Thread(new MyRunnable());
           thread2.start();
       }
   }
   ```

#### Race Condition

Terjadi ketika dua atau lebih thread mengakses dan memanipulasi data yang sama secara bersamaan, dan hasil akhir tergantung pada urutan eksekusi thread. Ini dapat menyebabkan hasil yang tidak konsisten atau tidak terduga.

```java
public class RaceConditionExample {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join(); // Menunggu thread t1 selesai
        t2.join(); // Menunggu thread t2 selesai

        System.out.println("Final Counter: " + counter); // Hasil mungkin tidak 2000
    }
}
```

#### Synchronization

Mekanisme untuk mengontrol akses ke sumber daya bersama oleh beberapa thread, mencegah race condition. Ini dapat dicapai dengan menggunakan kata kunci `synchronized` pada method atau block kode.

```java
public class SynchronizedExample {
    private static int counter = 0;
    private static final Object lock = new Object(); // Objek kunci untuk synchronized block

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) { // Synchronized block
                    counter++;
                }
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter (Synchronized): " + counter); // Hasil akan 2000
    }
}
```

#### Deadlock

Situasi di mana dua atau lebih thread saling menunggu satu sama lain untuk melepaskan sumber daya yang mereka butuhkan, sehingga tidak ada thread yang dapat melanjutkan eksekusinya.

```java
public class DeadlockExample {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Mengunci resource 1");
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("Thread 1: Menunggu resource 2");
                synchronized (resource2) {
                    System.out.println("Thread 1: Mengunci resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Mengunci resource 2");
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("Thread 2: Menunggu resource 1");
                synchronized (resource1) {
                    System.out.println("Thread 2: Mengunci resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

#### Thread Communication

Thread seringkali perlu berkomunikasi satu sama lain. Mekanisme seperti `wait()`, `notify()`, dan `notifyAll()` (dari class `Object`) digunakan untuk ini.

```java
public class ThreadCommunicationExample {
    private static final Object monitor = new Object();
    private static boolean dataReady = false;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            synchronized (monitor) {
                System.out.println("Producer: Menghasilkan data...");
                try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
                dataReady = true;
                System.out.println("Producer: Data siap, memberitahu consumer.");
                monitor.notify(); // Memberitahu satu thread yang menunggu
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (monitor) {
                while (!dataReady) {
                    try {
                        System.out.println("Consumer: Menunggu data...");
                        monitor.wait(); // Menunggu sampai diberitahu
                    } catch (InterruptedException e) { e.printStackTrace(); }
                }
                System.out.println("Consumer: Data diterima dan diproses.");
            }
        });

        producer.start();
        consumer.start();
    }
}
```

#### Timer

Class `java.util.Timer` dan `java.util.TimerTask` digunakan untuk menjadwalkan tugas agar berjalan sekali atau berulang kali setelah penundaan tertentu.

```java
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tugas dijalankan setelah 2 detik.");
                timer.cancel(); // Menghentikan timer setelah tugas pertama
            }
        };

        timer.schedule(task, 2000); // Jadwalkan tugas untuk berjalan setelah 2000 ms
    }
}
```

#### High Level Concurrency Object

Paket `java.util.concurrent` menyediakan utilitas tingkat tinggi untuk concurrency, seperti `ExecutorService`, `Future`, `Semaphore`, `CountDownLatch`, dll.

#### Threadpool

Kumpulan thread yang sudah dibuat sebelumnya dan siap untuk menjalankan tugas. Ini mengurangi overhead pembuatan/penghancuran thread dan meningkatkan manajemen sumber daya.

#### Executor Service

Interface untuk mengelola eksekusi tugas secara asinkron. `ExecutorService` adalah pengganti yang lebih fleksibel untuk membuat thread secara manual.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Membuat thread pool dengan 2 thread

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Menjalankan tugas " + taskId + " di thread: " + Thread.currentThread().getName());
                try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
        }

        executor.shutdown(); // Menghentikan penerimaan tugas baru
        executor.awaitTermination(1, TimeUnit.MINUTES); // Menunggu semua tugas selesai
        System.out.println("Semua tugas selesai.");
    }
}
```

#### Future

Merepresentasikan hasil dari komputasi asinkron. Anda bisa memeriksa apakah komputasi sudah selesai, menunggu hasilnya, atau membatalkannya.

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "Hasil dari tugas yang panjang";
        };

        Future<String> future = executor.submit(task);

        System.out.println("Melakukan pekerjaan lain...");
        // Lakukan pekerjaan lain di sini

        System.out.println("Menunggu hasil...");
        String result = future.get(); // Memblokir sampai hasil tersedia
        System.out.println(result);

        executor.shutdown();
    }
}
```

#### Completable Future

Diperkenalkan di Java 8, `CompletableFuture` adalah alat yang lebih kuat untuk pemrograman asinkron dan non-blocking. Ini memungkinkan Anda untuk merangkai beberapa operasi asinkron dan menangani hasilnya.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            return "Hello";
        }).thenApply(s -> s + " World");

        System.out.println("Melakukan pekerjaan lain...");
        String result = future.get(); // Memblokir untuk mendapatkan hasil
        System.out.println(result);
    }
}
```

#### Completion Service

Memisahkan tugas yang disubmit ke `Executor` dari hasil yang sudah selesai. Berguna ketika Anda ingin memproses hasil tugas segera setelah selesai, tanpa harus menunggu semua tugas selesai.

#### Scheduled Executor Service

`ExecutorService` yang dapat menjadwalkan perintah untuk dijalankan setelah penundaan tertentu, atau untuk dieksekusi secara berkala.

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Tugas berulang dijalankan pada: " + System.currentTimeMillis());

        // Jadwalkan tugas untuk berjalan setiap 2 detik setelah penundaan awal 1 detik
        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // Biarkan berjalan selama 10 detik lalu shutdown
        Thread.sleep(10000);
        scheduler.shutdown();
        System.out.println("Scheduler dimatikan.");
    }
}
```

#### Atomic

Kelas-kelas di paket `java.util.concurrent.atomic` menyediakan operasi atomik pada variabel tunggal. Ini berarti operasi tersebut dijamin akan selesai sepenuhnya tanpa gangguan dari thread lain, mencegah race condition tanpa perlu `synchronized` secara eksplisit.

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Operasi atomik
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter (Atomic): " + counter.get()); // Hasil akan 2000
    }
}
```

#### Lock

Interface `Lock` (dari `java.util.concurrent.locks`) menyediakan fungsionalitas penguncian yang lebih fleksibel dan canggih daripada kata kunci `synchronized`.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock(); // Mengunci
                try {
                    counter++;
                } finally {
                    lock.unlock(); // Penting untuk selalu membuka kunci di blok finally
                }
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter (Lock): " + counter); // Hasil akan 2000
    }
}
```

#### Synchronizer

Kelas-kelas seperti `Semaphore`, `CountDownLatch`, `CyclicBarrier`, dan `Exchanger` yang membantu mengoordinasikan aktivitas antar thread.

#### Semaphore

Mengontrol akses ke sejumlah sumber daya. Semaphore mempertahankan sejumlah "izin" (permits). Thread harus mendapatkan izin untuk mengakses sumber daya dan melepaskannya setelah selesai.

```java
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final Semaphore semaphore = new Semaphore(2); // Hanya 2 thread yang bisa mengakses bersamaan

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                semaphore.acquire(); // Meminta izin
                System.out.println(Thread.currentThread().getName() + " sedang mengakses sumber daya.");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " selesai mengakses sumber daya.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release(); // Melepaskan izin
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
```

#### Count Down Latch

Memungkinkan satu atau lebih thread untuk menunggu sampai sejumlah operasi yang dilakukan oleh thread lain selesai.

```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // Menunggu 3 event

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " sedang bekerja...");
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            System.out.println(Thread.currentThread().getName() + " selesai.");
            latch.countDown(); // Mengurangi hitungan latch
        };

        new Thread(worker, "Worker-1").start();
        new Thread(worker, "Worker-2").start();
        new Thread(worker, "Worker-3").start();

        System.out.println("Main Thread: Menunggu semua worker selesai...");
        latch.await(); // Main thread menunggu sampai hitungan latch menjadi nol
        System.out.println("Main Thread: Semua worker telah selesai.");
    }
}
```

#### Cyclic Barrier

Memungkinkan sejumlah thread untuk menunggu satu sama lain pada "titik penghalang" (barrier point) tertentu sebelum melanjutkan. Berguna untuk skenario di mana beberapa thread perlu mencapai titik tertentu secara bersamaan.

```java
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("Semua pihak telah mencapai titik pertemuan! Melanjutkan...");
        });

        Runnable party = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " sedang menuju titik pertemuan.");
                Thread.sleep((long) (Math.random() * 3000));
                System.out.println(Thread.currentThread().getName() + " telah mencapai titik pertemuan, menunggu yang lain.");
                barrier.await(); // Menunggu thread lain
                System.out.println(Thread.currentThread().getName() + " melanjutkan setelah titik pertemuan.");
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(party, "Pihak-1").start();
        new Thread(party, "Pihak-2").start();
        new Thread(party, "Pihak-3").start();
    }
}
```

#### Phaser

Mirip dengan `CyclicBarrier` tetapi lebih fleksibel, memungkinkan jumlah pihak yang berpartisipasi untuk berubah secara dinamis.

#### Exchanger

Memungkinkan dua thread untuk bertukar objek pada titik sinkronisasi tertentu.

```java
import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Runnable producer = () -> {
            try {
                String data = "Data dari Producer";
                System.out.println("Producer: Mengirim " + data);
                String received = exchanger.exchange(data);
                System.out.println("Producer: Menerima " + received);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                String data = "Data dari Consumer";
                System.out.println("Consumer: Mengirim " + data);
                String received = exchanger.exchange(data);
                System.out.println("Consumer: Menerima " + received);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
```

#### Concurrent Collection

Koleksi yang dirancang untuk digunakan dalam lingkungan multi-threaded, menyediakan operasi yang aman untuk thread tanpa perlu sinkronisasi manual.

* `ConcurrentHashMap`
* `CopyOnWriteArrayList`
* `ConcurrentLinkedQueue`

#### Blocking Queue

Queue yang mendukung operasi yang memblokir ketika mencoba menambahkan elemen ke queue penuh atau mengambil elemen dari queue kosong. Berguna untuk pola Producer-Consumer.

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100);
                    queue.put(i); // Memblokir jika queue penuh
                    System.out.println("Producer: Menambahkan " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    Integer value = queue.take(); // Memblokir jika queue kosong
                    System.out.println("Consumer: Mengambil " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
```

#### Concurrent Map

Implementasi `Map` yang aman untuk thread, seperti `ConcurrentHashMap`.

#### Thread Local

Menyediakan variabel yang hanya dapat diakses oleh thread yang membuatnya. Setiap thread memiliki salinan sendiri dari variabel `ThreadLocal`.

```java
public class ThreadLocalExample {
    private static final ThreadLocal<String> threadLocalName = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            threadLocalName.set("Thread-1 Data");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocalName.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocalName.set("Thread-2 Data");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocalName.get());
        });

        t1.start();
        t2.start();
    }
}
```

#### Thread Local Random

Versi `Random` yang dioptimalkan untuk penggunaan multi-threaded, mengurangi contention dibandingkan `java.util.Random`.

#### Fork Join

Framework untuk mengeksekusi tugas secara paralel yang dapat dipecah menjadi subtugas yang lebih kecil. Berguna untuk algoritma divide-and-conquer.

#### Parallel Stream

Memungkinkan pemrosesan elemen stream secara paralel, memanfaatkan beberapa core CPU. Cukup panggil `.parallelStream()` pada koleksi atau `.parallel()` pada stream.

```java
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.parallelStream()
               .forEach(n -> System.out.println(Thread.currentThread().getName() + ": " + n));
    }
}
```

#### Reactive Stream

Spesifikasi untuk pemrosesan stream asinkron dengan backpressure. Implementasi populer termasuk RxJava dan Project Reactor.

### #2 Java Virtual Thread

Virtual Thread (juga dikenal sebagai Project Loom) adalah fitur baru yang diperkenalkan di Java 19 (sebagai preview) dan menjadi fitur standar di Java 21. Virtual Thread adalah thread ringan yang dikelola oleh JVM, bukan oleh sistem operasi. Ini memungkinkan aplikasi Java untuk membuat dan menjalankan jutaan thread secara efisien, sangat meningkatkan skalabilitas aplikasi yang berorientasi I/O.

#### Platform Thread

Ini adalah thread tradisional di Java, yang merupakan wrapper tipis di sekitar thread sistem operasi. Setiap Platform Thread memiliki tumpukan memori (stack) sendiri dan dikelola oleh OS. Membuat terlalu banyak Platform Thread bisa mahal dan membatasi skalabilitas.

```java
public class PlatformThreadExample {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) { // Contoh kecil, membuat banyak akan memakan resource
            Thread platformThread = new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Platform Thread: " + Thread.currentThread().getName());
            });
            platformThread.start();
            platformThread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("Waktu eksekusi Platform Threads: " + (end - start) + " ms");
    }
}
```

#### Virtual Thread

Virtual Thread adalah thread ringan yang tidak dipetakan 1:1 ke thread OS. Mereka "dipasang" (mounted) ke Platform Thread (disebut carrier thread) hanya saat mereka benar-benar berjalan di CPU. Ketika Virtual Thread melakukan operasi blocking I/O, ia "dilepas" (unmounted) dari carrier thread, memungkinkan carrier thread untuk menjalankan Virtual Thread lain. Ini memungkinkan jumlah Virtual Thread yang sangat besar dengan overhead yang minimal.

```java
public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) { // Membuat banyak Virtual Thread
            Thread virtualThread = Thread.ofVirtual().name("virtual-thread-" + i).start(() -> {
                try {
                    Thread.sleep(100); // Simulasi operasi blocking I/O
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // System.out.println("Virtual Thread: " + Thread.currentThread().getName());
            });
            // virtualThread.join(); // Tidak perlu join satu per satu untuk banyak thread
        }
        // Tunggu sebentar agar semua virtual thread memiliki kesempatan untuk berjalan
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("Waktu eksekusi Virtual Threads: " + (end - start) + " ms");
    }
}
```

#### Virtual Thread Executor Service

Anda dapat membuat `ExecutorService` yang menggunakan Virtual Thread, yang sangat memudahkan pengelolaan dan eksekusi tugas asinkron dengan skalabilitas tinggi.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                final int taskId = i;
                executor.submit(() -> {
                    try {
                        Thread.sleep(100); // Simulasi operasi blocking I/O
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    // System.out.println("Task " + taskId + " di Virtual Thread: " + Thread.currentThread().getName());
                });
            }
        }
        // ExecutorService akan otomatis shutdown karena try-with-resources
        long end = System.currentTimeMillis();
        System.out.println("Waktu eksekusi Virtual Thread Executor: " + (end - start) + " ms");
    }
}
```

### #3 Java Lambda

Lambda Expressions (diperkenalkan di Java 8) adalah cara singkat untuk merepresentasikan instance dari interface fungsional (interface dengan satu method abstrak). Ini memungkinkan pemrograman fungsional di Java dan sangat berguna untuk menulis kode yang lebih ringkas dan mudah dibaca, terutama dengan Stream API.

#### Membuat Lambda

Sintaks dasar lambda expression adalah `(parameter) -> { body }`.

```java
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
        // Lambda tanpa parameter
        Runnable hello = () -> System.out.println("Hello from Lambda!");
        hello.run();

        // Lambda dengan satu parameter
        Consumer<String> greet = name -> System.out.println("Hello, " + name + "!");
        greet.accept("Red");

        // Lambda dengan banyak parameter
        Calculator add = (a, b) -> a + b;
        System.out.println("3 + 5 = " + add.calculate(3, 5));

        // Lambda dengan block kode
        Predicate<Integer> isEven = num -> {
            if (num % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println("Is 4 even? " + isEven.test(4));
    }

    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }
}
```

#### Java Util Function

Paket `java.util.function` menyediakan banyak interface fungsional bawaan yang umum digunakan, seperti:

* `Consumer<T>`: Menerima satu argumen, tidak mengembalikan hasil (`void accept(T t)`).
* `Supplier<T>`: Tidak menerima argumen, mengembalikan hasil (`T get()`).
* `Function<T, R>`: Menerima satu argumen, mengembalikan hasil (`R apply(T t)`).
* `Predicate<T>`: Menerima satu argumen, mengembalikan boolean (`boolean test(T t)`).
* `BiConsumer<T, U>`, `BiFunction<T, U, R>`, `BiPredicate<T, U>`: Versi dengan dua argumen.
* `UnaryOperator<T>`, `BinaryOperator<T>`: Versi khusus dari `Function` dan `BiFunction` di mana tipe input dan output sama.

```java
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UtilFunctionExample {
    public static void main(String[] args) {
        Supplier<String> randomString = () -> "Random: " + Math.random();
        System.out.println(randomString.get());

        Function<Integer, String> intToString = i -> "Number: " + i;
        System.out.println(intToString.apply(123));

        Predicate<String> isLong = s -> s.length() > 5;
        System.out.println("Is 'hello' long? " + isLong.test("hello"));

        Consumer<Double> printDouble = d -> System.out.println("Double value: " + d);
        printDouble.accept(3.14);
    }
}
```

#### Method Reference

Cara yang lebih ringkas untuk lambda expression yang hanya memanggil satu method yang sudah ada. Ada empat jenis:

1. **Static method reference:** `ClassName::staticMethodName`
2. **Instance method reference dari objek tertentu:** `object::instanceMethodName`
3. **Instance method reference dari tipe tertentu:** `ClassName::instanceMethodName`
4. **Constructor reference:** `ClassName::new`

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Red", "Horizon", "Asyncra");

        // Static method reference: System.out::println
        names.forEach(System.out::println);

        // Instance method reference dari objek tertentu: String::length
        Function<String, Integer> getLength = String::length;
        System.out.println("Length of 'Red': " + getLength.apply("Red"));

        // Constructor reference: MyClass::new
        Supplier<StringBuilder> stringBuilderSupplier = StringBuilder::new;
        StringBuilder sb = stringBuilderSupplier.get();
        sb.append("Constructed via reference");
        System.out.println(sb.toString());
    }
}
```

#### Lambda di Collection

Lambda sangat sering digunakan dengan Java Collections Framework, terutama dengan method `forEach()` dan Stream API.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaCollectionExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");

        // Menggunakan lambda dengan forEach
        System.out.println("Daftar nama:");
        names.forEach(name -> System.out.println("- " + name));

        // Menggunakan lambda untuk sorting
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println("\nDaftar nama setelah diurutkan:");
        names.forEach(System.out::println);
    }
}
```

#### Lambda Sebagai Lazy Parameter

Lambda dapat digunakan untuk menunda eksekusi kode sampai benar-benar dibutuhkan. Ini sering terlihat dalam logging atau validasi, di mana pesan atau komputasi yang mahal hanya dilakukan jika level log atau kondisi validasi terpenuhi.

```java
import java.util.function.Supplier;

public class LazyParameterExample {

    public static void logIfDebug(boolean isDebugEnabled, Supplier<String> messageSupplier) {
        if (isDebugEnabled) {
            System.out.println("DEBUG: " + messageSupplier.get());
        }
    }

    public static void main(String[] args) {
        boolean debug = true;

        // Pesan akan dibuat hanya jika debug true
        logIfDebug(debug, () -> {
            System.out.println("Membuat pesan debug yang mahal...");
            return "Pesan debug yang sangat panjang dan mahal untuk dibuat.";
        });

        debug = false;
        // Pesan tidak akan dibuat karena debug false
        logIfDebug(debug, () -> {
            System.out.println("Ini tidak akan dicetak karena debug false.");
            return "";
        });
    }
}
```

#### Lambda di Optional

`Optional` (diperkenalkan di Java 8) adalah container yang mungkin berisi nilai non-null atau tidak sama sekali. Lambda sangat cocok digunakan dengan `Optional` untuk operasi seperti `ifPresent()`, `map()`, `filter()`, dan `orElseGet()`.

```java
import java.util.Optional;

public class OptionalLambdaExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Red Horizon");
        Optional<String> emptyName = Optional.empty();

        // ifPresent: menjalankan Consumer jika nilai ada
        name.ifPresent(s -> System.out.println("Hello, " + s));
        emptyName.ifPresent(s -> System.out.println("Ini tidak akan dicetak."));

        // map: mengubah nilai jika ada
        String upperCaseName = name.map(String::toUpperCase).orElse("N/A");
        System.out.println("Uppercase Name: " + upperCaseName);

        // filter: menyaring nilai
        Optional<String> longName = name.filter(s -> s.length() > 10);
        longName.ifPresent(s -> System.out.println("Long Name: " + s));

        // orElseGet: menyediakan nilai default secara lazy jika Optional kosong
        String defaultName = emptyName.orElseGet(() -> {
            System.out.println("Mendapatkan nama default secara lazy...");
            return "Default User";
        });
        System.out.println("Default Name: " + defaultName);
    }
}
```

## 6️⃣ Advanced / Power Tools

Bagian ini membahas fitur-fitur Java yang lebih canggih atau "power tools" yang memungkinkan manipulasi kode pada runtime, penulisan kode yang lebih ringkas, dan fitur-fitur modern lainnya.

### #1 Java Reflection

Java Reflection adalah API yang memungkinkan program Java untuk memeriksa atau memodifikasi perilaku class, method, dan field pada saat runtime. Ini adalah fitur yang sangat kuat dan sering digunakan oleh framework (seperti Spring, Hibernate) untuk melakukan injeksi dependensi, ORM, dan lain-lain.

#### Class

Objek `Class` adalah pintu gerbang utama ke Reflection API. Anda bisa mendapatkan objek `Class` untuk tipe data apa pun.

```java
public class ReflectionClassExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // Cara 1: Menggunakan .class literal
        Class<String> stringClass = String.class;
        System.out.println("Class Name (String): " + stringClass.getName());

        // Cara 2: Menggunakan getClass() dari objek
        String s = "Hello";
        Class<?> sClass = s.getClass();
        System.out.println("Class Name (from object): " + sClass.getName());

        // Cara 3: Menggunakan Class.forName() (untuk nama class dinamis)
        Class<?> listClass = Class.forName("java.util.ArrayList");
        System.out.println("Class Name (from forName): " + listClass.getName());
    }
}
```

#### Field

Mengakses dan memodifikasi field (variabel) dari sebuah class, termasuk field `private`.

```java
import java.lang.reflect.Field;

class Person {
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ReflectionFieldExample {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Red", 25);
        Class<?> personClass = person.getClass();

        // Mengakses field public
        Field ageField = personClass.getField("age");
        System.out.println("Age: " + ageField.get(person));
        ageField.set(person, 26);
        System.out.println("New Age: " + person.age);

        // Mengakses field private
        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true); // Mengizinkan akses ke field private
        System.out.println("Name: " + nameField.get(person));
        nameField.set(person, "Horizon");
        System.out.println("New Name: " + nameField.get(person));
    }
}
```

#### Method

Mengakses dan memanggil method dari sebuah class, termasuk method `private`.

```java
import java.lang.reflect.Method;

class Greeter {
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    private void secretMessage() {
        System.out.println("Ini pesan rahasia.");
    }
}

public class ReflectionMethodExample {
    public static void main(String[] args) throws Exception {
        Greeter greeter = new Greeter();
        Class<?> greeterClass = greeter.getClass();

        // Memanggil method public
        Method sayHelloMethod = greeterClass.getMethod("sayHello", String.class);
        String result = (String) sayHelloMethod.invoke(greeter, "Red");
        System.out.println(result);

        // Memanggil method private
        Method secretMethod = greeterClass.getDeclaredMethod("secretMessage");
        secretMethod.setAccessible(true); // Mengizinkan akses ke method private
        secretMethod.invoke(greeter);
    }
}
```

#### Parameter

Mengakses informasi tentang parameter dari sebuah method atau constructor.

```java
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionParameterExample {
    public void myMethod(String param1, int param2) {}

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ReflectionParameterExample.class.getMethod("myMethod", String.class, int.class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println("Parameter Name: " + parameter.getName() + ", Type: " + parameter.getType().getName());
        }
    }
}
```

#### Constructor

Mengakses dan memanggil constructor untuk membuat instance objek secara dinamis.

```java
import java.lang.reflect.Constructor;

class MyObject {
    private String value;

    public MyObject() {
        this.value = "Default";
    }

    public MyObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public class ReflectionConstructorExample {
    public static void main(String[] args) throws Exception {
        Class<MyObject> myObjectClass = MyObject.class;

        // Memanggil constructor tanpa argumen
        Constructor<MyObject> defaultConstructor = myObjectClass.getConstructor();
        MyObject obj1 = defaultConstructor.newInstance();
        System.out.println("Obj1 Value: " + obj1.getValue());

        // Memanggil constructor dengan argumen
        Constructor<MyObject> paramConstructor = myObjectClass.getConstructor(String.class);
        MyObject obj2 = paramConstructor.newInstance("Custom Value");
        System.out.println("Obj2 Value: " + obj2.getValue());
    }
}
```

#### Super Class

Mengakses class induk dari sebuah class.

```java
class Animal {}
class Dog extends Animal {}

public class ReflectionSuperClassExample {
    public static void main(String[] args) {
        Class<?> dogClass = Dog.class;
        Class<?> superClass = dogClass.getSuperclass();
        System.out.println("Superclass of Dog: " + superClass.getName());

        Class<?> objectClass = superClass.getSuperclass();
        System.out.println("Superclass of Animal: " + objectClass.getName());
    }
}
```

#### Interface

Mengakses interface yang diimplementasikan oleh sebuah class.

```java
import java.io.Serializable;

class MyData implements Serializable {}

public class ReflectionInterfaceExample {
    public static void main(String[] args) {
        Class<?> myDataClass = MyData.class;
        Class<?>[] interfaces = myDataClass.getInterfaces();
        for (Class<?> iface : interfaces) {
            System.out.println("Implemented Interface: " + iface.getName());
        }
    }
}
```

#### Modifier

Mengakses informasi tentang modifier (public, private, static, final, dll.) dari class, field, atau method.

```java
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Example {
    public static final int CONSTANT = 10;
    private String data;
}

public class ReflectionModifierExample {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> exampleClass = Example.class;

        int classModifiers = exampleClass.getModifiers();
        System.out.println("Is Example class public? " + Modifier.isPublic(classModifiers));

        Field constantField = exampleClass.getField("CONSTANT");
        int constantModifiers = constantField.getModifiers();
        System.out.println("Is CONSTANT field static? " + Modifier.isStatic(constantModifiers));
        System.out.println("Is CONSTANT field final? " + Modifier.isFinal(constantModifiers));

        Field dataField = exampleClass.getDeclaredField("data");
        int dataModifiers = dataField.getModifiers();
        System.out.println("Is data field private? " + Modifier.isPrivate(dataModifiers));
    }
}
```

#### Package

Mengakses informasi tentang package dari sebuah class.

```java
public class ReflectionPackageExample {
    public static void main(String[] args) {
        Class<?> stringClass = String.class;
        Package stringPackage = stringClass.getPackage();
        System.out.println("Package of String: " + stringPackage.getName());
    }
}
```

#### Annotation

Mengakses anotasi yang diterapkan pada class, method, atau field.

```java
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value() default "default";
}

class AnnotatedClass {
    @MyAnnotation("custom")
    public void annotatedMethod() {}
}

public class ReflectionAnnotationExample {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = AnnotatedClass.class.getMethod("annotatedMethod");
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation Value: " + annotation.value());
        }
    }
}
```

#### Enum

Mengakses informasi tentang enum.

```java
enum Status { ACTIVE, INACTIVE }

public class ReflectionEnumExample {
    public static void main(String[] args) {
        Class<?> statusEnum = Status.class;
        System.out.println("Is Status an enum? " + statusEnum.isEnum());

        for (Object enumConstant : statusEnum.getEnumConstants()) {
            System.out.println("Enum Constant: " + enumConstant);
        }
    }
}
```

#### Primitive Type

Mengakses objek `Class` untuk tipe primitif (int, boolean, dll.).

```java
public class ReflectionPrimitiveExample {
    public static void main(String[] args) {
        Class<Integer> intClass = int.class;
        System.out.println("Is int a primitive? " + intClass.isPrimitive());

        Class<Integer> integerWrapperClass = Integer.class;
        System.out.println("Is Integer a primitive? " + integerWrapperClass.isPrimitive());
    }
}
```

#### Array

Mengakses informasi tentang array dan membuat instance array secara dinamis.

```java
import java.lang.reflect.Array;

public class ReflectionArrayExample {
    public static void main(String[] args) {
        Class<?> intArrayClass = int[].class;
        System.out.println("Is int[] an array? " + intArrayClass.isArray());

        // Membuat array secara dinamis
        int[] newArray = (int[]) Array.newInstance(int.class, 5);
        Array.set(newArray, 0, 100);
        System.out.println("First element of new array: " + Array.get(newArray, 0));
    }
}
```

#### Parameterized Type

Mengakses informasi tentang tipe generik (misalnya, `List<String>`). Ini lebih kompleks dan sering melibatkan `Type`, `ParameterizedType`, `TypeVariable`, dll.

#### Proxy

Membuat objek proxy secara dinamis yang mengimplementasikan satu atau lebih interface. Berguna untuk AOP, mocking, dll.

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyService {
    void doSomething();
}

class MyServiceImpl implements MyService {
    @Override
    public void doSomething() {
        System.out.println("Melakukan sesuatu yang nyata.");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Sebelum memanggil method: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("Setelah memanggil method: " + method.getName());
        return result;
    }
}

public class ReflectionProxyExample {
    public static void main(String[] args) {
        MyService realService = new MyServiceImpl();
        MyService proxyService = (MyService) Proxy.newProxyInstance(
            MyService.class.getClassLoader(),
            new Class<?>[]{MyService.class},
            new MyInvocationHandler(realService)
        );

        proxyService.doSomething();
    }
}
```

#### Record

Mengakses informasi tentang Record Class (diperkenalkan di Java 16).

```java
import java.lang.reflect.RecordComponent;

record Point(int x, int y) {}

public class ReflectionRecordExample {
    public static void main(String[] args) {
        Class<?> pointClass = Point.class;
        System.out.println("Is Point a record? " + pointClass.isRecord());

        for (RecordComponent component : pointClass.getRecordComponents()) {
            System.out.println("Record Component: " + component.getName() + ", Type: " + component.getType().getName());
        }
    }
}
```

### #2 Java Record

Record adalah fitur baru yang diperkenalkan di Java 16 (sebagai fitur standar) yang dirancang untuk menjadi class data yang ringkas dan immutable. Record secara otomatis menyediakan constructor, accessor methods (`getter`), `equals()`, `hashCode()`, dan `toString()` berdasarkan komponen yang dideklarasikan.

#### Record

Deklarasi Record sangat ringkas. Anda hanya perlu mendefinisikan komponen-komponennya.

```java
public record Point(int x, int y) {
    // Record secara otomatis menyediakan:
    // - Constructor: public Point(int x, int y)
    // - Accessor methods: x(), y()
    // - equals(), hashCode(), toString()
}

public class RecordExample {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.println("Point: " + p1); // Menggunakan toString() otomatis
        System.out.println("X: " + p1.x()); // Menggunakan accessor x()
        System.out.println("Y: " + p1.y()); // Menggunakan accessor y()

        Point p2 = new Point(10, 20);
        System.out.println("p1 equals p2? " + p1.equals(p2)); // Menggunakan equals() otomatis
    }
}
```

#### Property

Komponen yang dideklarasikan dalam header record secara otomatis menjadi field `private final` dan memiliki accessor method publik dengan nama yang sama.

```java
public record User(String username, String email) {
    // username dan email adalah properti
}

public class RecordPropertyExample {
    public static void main(String[] args) {
        User user = new User("redhorizon", "red@example.com");
        System.out.println("Username: " + user.username()); // Akses properti
        System.out.println("Email: " + user.email());
    }
}
```

#### Constructor

Record secara otomatis menghasilkan constructor kanonis (canonical constructor) yang menerima semua komponen sebagai parameter. Anda juga bisa menambahkan constructor kustom (compact constructor atau custom canonical constructor) untuk validasi atau inisialisasi tambahan.

```java
public record Product(String id, String name, double price) {
    // Compact constructor untuk validasi
    public Product {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID tidak boleh kosong");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }
    }

    // Anda juga bisa menambahkan constructor lain, asalkan memanggil constructor kanonis
    public Product(String name, double price) {
        this("AUTO_GEN_ID-" + System.nanoTime(), name, price);
    }
}

public class RecordConstructorExample {
    public static void main(String[] args) {
        Product p1 = new Product("P001", "Laptop", 1200.0);
        System.out.println(p1);

        Product p2 = new Product("Keyboard", 75.0);
        System.out.println(p2);

        try {
            new Product(null, "Mouse", 25.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

#### Method

Anda dapat menambahkan method instance atau static ke record, sama seperti class biasa.

```java
public record Rectangle(double length, double width) {
    public double area() {
        return length * width;
    }

    public static Rectangle createSquare(double side) {
        return new Rectangle(side, side);
    }
}

public class RecordMethodExample {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        System.out.println("Area: " + rect.area());

        Rectangle square = Rectangle.createSquare(7);
        System.out.println("Square Area: " + square.area());
    }
}
```

#### Equals, HashCode, dan ToString

Record secara otomatis menghasilkan implementasi `equals()`, `hashCode()`, dan `toString()` yang konsisten berdasarkan semua komponennya.

```java
public record Coordinate(int x, int y) {}

public class RecordEqualsHashCodeToStringExample {
    public static void main(String[] args) {
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(1, 2);
        Coordinate c3 = new Coordinate(3, 4);

        System.out.println("c1: " + c1); // toString()
        System.out.println("c1 equals c2? " + c1.equals(c2)); // true
        System.out.println("c1 equals c3? " + c1.equals(c3)); // false
        System.out.println("c1 hashCode: " + c1.hashCode());
        System.out.println("c2 hashCode: " + c2.hashCode());
    }
}
```

#### Inheritance

Record tidak dapat mewarisi class lain, dan record secara implisit mewarisi `java.lang.Record`. Record juga tidak dapat menjadi superclass bagi class lain.

#### Static

Record dapat memiliki field dan method static, sama seperti class biasa.

```java
public record Settings(String theme) {
    public static final String DEFAULT_THEME = "dark";

    public static Settings defaultSettings() {
        return new Settings(DEFAULT_THEME);
    }
}

public class RecordStaticExample {
    public static void main(String[] args) {
        System.out.println("Default Theme: " + Settings.DEFAULT_THEME);
        Settings s = Settings.defaultSettings();
        System.out.println("Current Settings: " + s);
    }
}
```

#### Generic

Record dapat bersifat generik, memungkinkan mereka bekerja dengan berbagai tipe data.

```java
public record Pair<K, V>(K key, V value) {}

public class RecordGenericExample {
    public static void main(String[] args) {
        Pair<String, Integer> userScore = new Pair<>("Red", 100);
        System.out.println("Key: " + userScore.key() + ", Value: " + userScore.value());

        Pair<Double, String> itemPrice = new Pair<>(99.99, "Laptop");
        System.out.println("Key: " + itemPrice.key() + ", Value: " + itemPrice.value());
    }
}
```

#### Annotation

Record dapat dianotasi, dan komponen record juga dapat dianotasi.

```java
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public record ValidatedUser(
    @NotBlank(message = "Username tidak boleh kosong")
    String username,
    @Min(value = 18, message = "Usia minimal 18")
    int age
) {}

// Untuk validasi, Anda akan menggunakan Bean Validation API seperti yang dijelaskan sebelumnya.
```

#### Reflection

Record mendukung Reflection API, termasuk `isRecord()` dan `getRecordComponents()`.

```java
import java.lang.reflect.RecordComponent;

public record Book(String title, String author) {}

public class RecordReflectionExample {
    public static void main(String[] args) {
        Class<?> bookClass = Book.class;
        System.out.println("Is Book a record? " + bookClass.isRecord());

        System.out.println("Record Components:");
        for (RecordComponent component : bookClass.getRecordComponents()) {
            System.out.println("- " + component.getName() + " (" + component.getType().getName() + ")");
        }
    }
}
```

#### Record Patterns

Diperkenalkan di Java 21, Record Patterns memungkinkan dekonstruksi objek record dalam `instanceof` dan `switch` expressions, membuat kode lebih ringkas dan ekspresif.

```java
public record Person(String name, int age) {}
public record Employee(String id, Person person) {}

public class RecordPatternsExample {
    public static void main(String[] args) {
        Object obj = new Employee("E123", new Person("Alice", 30));

        // Sebelum Record Patterns
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            if (emp.person() instanceof Person) {
                Person p = emp.person();
                System.out.println("Nama Karyawan: " + p.name());
            }
        }

        // Dengan Record Patterns (Java 21+)
        if (obj instanceof Employee(String id, Person(String name, int age))) {
            System.out.println("Nama Karyawan (dengan Record Patterns): " + name);
            System.out.println("ID Karyawan: " + id);
        }

        // Dengan switch expression (Java 21+)
        String description = switch (obj) {
            case Employee(String id, Person(String name, int age)) ->
                "Karyawan: " + name + ", ID: " + id + ", Usia: " + age;
            case Person(String name, int age) ->
                "Orang: " + name + ", Usia: " + age;
            default -> "Objek tidak dikenal";
        };
        System.out.println(description);
    }
}
```

### #3 Java Sealed Class

Sealed Classes dan Interfaces (diperkenalkan di Java 15 sebagai preview, standar di Java 17) memungkinkan Anda untuk membatasi class atau interface mana yang dapat memperluas atau mengimplementasikannya. Ini memberikan kontrol yang lebih granular atas hierarki tipe, yang dapat meningkatkan keamanan, mempermudah pemeliharaan kode, dan memungkinkan pola seperti pattern matching yang lebih komprehensif.

#### Sealed Class

Sebuah `sealed class` dideklarasikan dengan kata kunci `sealed` dan diikuti oleh kata kunci `permits` yang menentukan class mana saja yang diizinkan untuk memperluasnya. Class yang diizinkan harus didefinisikan dalam modul yang sama atau package yang sama.

```java
// Deklarasi Sealed Class
public sealed class Shape permits Circle, Rectangle, Triangle {
    // Common methods or fields for all shapes
    public abstract double area();
}

// Class yang diizinkan untuk memperluas Shape
final class Circle extends Shape {
    double radius;
    public Circle(double radius) { this.radius = radius; }
    @Override
    public double area() { return Math.PI * radius * radius; }
}

// Class yang diizinkan untuk memperluas Shape
final class Rectangle extends Shape {
    double length, width;
    public Rectangle(double length, double width) { this.length = length; this.width = width; }
    @Override
    public double area() { return length * width; }
}

// Class yang diizinkan untuk memperluas Shape
final class Triangle extends Shape {
    double base, height;
    public Triangle(double base, double height) { this.base = base; this.height = height; }
    @Override
    public double area() { return 0.5 * base * height; }
}

public class SealedClassExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 7);

        System.out.println("Area of Circle: " + circle.area());
        System.out.println("Area of Rectangle: " + rectangle.area());
        System.out.println("Area of Triangle: " + triangle.area());

        // Penggunaan dengan switch expression (Java 17+)
        String description = switch (circle) {
            case Circle c -> "Ini lingkaran dengan radius " + c.radius;
            case Rectangle r -> "Ini persegi panjang dengan panjang " + r.length + " dan lebar " + r.width;
            case Triangle t -> "Ini segitiga dengan alas " + t.base + " dan tinggi " + t.height;
        };
        System.out.println(description);
    }
}
```

#### Non Sealed Class

Class yang memperluas `sealed class` harus dideklarasikan sebagai `final`, `sealed`, atau `non-sealed`.

* `final`: Class tidak dapat diperluas lebih lanjut.
* `sealed`: Class dapat diperluas oleh class yang diizinkan saja.
* `non-sealed`: Class dapat diperluas oleh class mana pun (mengakhiri hierarki sealed).

```java
// Contoh non-sealed class
public non-sealed class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

// Square sekarang bisa diperluas oleh class mana pun
class ColoredSquare extends Square {
    String color;
    public ColoredSquare(double side, String color) {
        super(side);
        this.color = color;
    }
}

public class NonSealedClassExample {
    public static void main(String[] args) {
        Square sq = new Square(5);
        System.out.println("Area of Square: " + sq.area());

        ColoredSquare cs = new ColoredSquare(3, "Red");
        System.out.println("Area of Colored Square: " + cs.area() + ", Color: " + cs.color);
    }
}
```

#### Sealed Interface

Sama seperti `sealed class`, `sealed interface` membatasi interface atau class mana yang dapat mengimplementasikannya.

```java
public sealed interface Vehicle permits Car, Truck, Bicycle {
    String getType();
}

final class Car implements Vehicle {
    @Override
    public String getType() { return "Mobil"; }
}

final class Truck implements Vehicle {
    @Override
    public String getType() { return "Truk"; }
}

non-sealed class Bicycle implements Vehicle {
    @Override
    public String getType() { return "Sepeda"; }
}

public class SealedInterfaceExample {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        Vehicle bicycle = new Bicycle();

        System.out.println("Car type: " + car.getType());
        System.out.println("Truck type: " + truck.getType());
        System.out.println("Bicycle type: " + bicycle.getType());
    }
}
```

#### Record

Record dapat memperluas `sealed class` atau mengimplementasikan `sealed interface`. Karena record secara implisit `final`, mereka secara otomatis memenuhi persyaratan untuk menjadi class yang diizinkan.

```java
public sealed interface Status permits Active, Inactive, Pending {}

public record Active(String user) implements Status {}
public record Inactive(String reason) implements Status {}
public record Pending(long timestamp) implements Status {}

public class SealedRecordExample {
    public static void main(String[] args) {
        Status s1 = new Active("Red");
        Status s2 = new Inactive("Expired");

        String message = switch (s1) {
            case Active a -> "User " + a.user() + " aktif.";
            case Inactive i -> "User tidak aktif karena: " + i.reason();
            case Pending p -> "Menunggu sejak: " + p.timestamp();
        };
        System.out.println(message);
    }
}
```

#### Reflection

Reflection API telah diperbarui untuk mendukung Sealed Classes dan Interfaces, memungkinkan Anda untuk memeriksa apakah sebuah class atau interface adalah sealed, dan class mana yang diizinkan untuk memperluas/mengimplementasikannya.

```java
import java.util.Arrays;

public class SealedReflectionExample {
    public static void main(String[] args) {
        Class<?> shapeClass = Shape.class;
        System.out.println("Is Shape sealed? " + shapeClass.isSealed());

        if (shapeClass.isSealed()) {
            System.out.println("Permitted subclasses of Shape: ");
            Arrays.stream(shapeClass.getPermittedSubclasses())
                  .map(Class::getName)
                  .forEach(System.out::println);
        }

        Class<?> circleClass = Circle.class;
        System.out.println("Is Circle sealed? " + circleClass.isSealed());
    }
}
```

### #4 Java Lombok

Project Lombok adalah library Java yang secara otomatis "mencolokkan" dirinya ke dalam proses build Anda dan menghasilkan kode boilerplate seperti getter, setter, constructor, `equals()`, `hashCode()`, dan `toString()` pada waktu kompilasi. Ini membantu menjaga kode Anda tetap bersih, ringkas, dan mudah dibaca dengan mengurangi jumlah kode yang harus Anda tulis secara manual.

#### Membuat Project

Untuk menggunakan Lombok, Anda perlu menambahkan dependency ke `pom.xml` Anda:

```xml
<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Anda juga perlu menginstal plugin Lombok di IDE Anda (misalnya, IntelliJ IDEA, Eclipse) agar IDE dapat mengenali anotasi Lombok dan menghindari error kompilasi di editor.

#### Getter dan Setter

Anotasi `@Getter` dan `@Setter` secara otomatis menghasilkan method getter dan setter untuk field yang dianotasi.

```java
import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int age;

    public static void main(String[] args) {
        User user = new User();
        user.setName("Red");
        user.setAge(25);
        System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
    }
}
```

#### Constructor

Lombok menyediakan anotasi untuk menghasilkan berbagai jenis constructor:

* `@NoArgsConstructor`: Menghasilkan constructor tanpa argumen.
* `@RequiredArgsConstructor`: Menghasilkan constructor dengan argumen untuk semua field `final` atau field yang ditandai `@NonNull`.
* `@AllArgsConstructor`: Menghasilkan constructor dengan argumen untuk semua field.

```java
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor // Constructor tanpa argumen
@AllArgsConstructor // Constructor dengan semua argumen
@RequiredArgsConstructor // Constructor dengan argumen untuk field final/NonNull
public class Product {
    private String id;
    @NonNull private String name; // Field ini akan masuk ke RequiredArgsConstructor
    private double price;

    public static void main(String[] args) {
        Product p1 = new Product(); // Menggunakan @NoArgsConstructor
        // p1.id = "P001"; p1.name = "Laptop"; p1.price = 1200.0; // Perlu setter jika ingin set

        Product p2 = new Product("P002", "Mouse", 25.0); // Menggunakan @AllArgsConstructor
        System.out.println("Product 2: " + p2.name);

        Product p3 = new Product("Keyboard"); // Menggunakan @RequiredArgsConstructor
        System.out.println("Product 3: " + p3.name);
    }
}
```

#### ToString

Anotasi `@ToString` menghasilkan method `toString()` yang mencetak semua field dari class.

```java
import lombok.ToString;

@ToString
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public static void main(String[] args) {
        Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        System.out.println(book); // Output: Book(title=The Lord of the Rings, author=J.R.R. Tolkien, year=1954)
    }
}
```

#### Equals dan HashCode

Anotasi `@EqualsAndHashCode` menghasilkan method `equals()` dan `hashCode()` yang konsisten berdasarkan semua field non-static dan non-transient.

```java
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(1, 2);
        Coordinate c3 = new Coordinate(3, 4);

        System.out.println("c1 equals c2? " + c1.equals(c2)); // true
        System.out.println("c1 equals c3? " + c1.equals(c3)); // false
        System.out.println("c1 hashCode: " + c1.hashCode());
        System.out.println("c2 hashCode: " + c2.hashCode());
    }
}
```

#### Data

Anotasi `@Data` adalah anotasi praktis yang menggabungkan `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, dan `@NoArgsConstructor` (jika tidak ada constructor lain yang didefinisikan).

```java
import lombok.Data;

@Data
public class Employee {
    private String id;
    private String name;
    private double salary;

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId("E001");
        emp.setName("Alice");
        emp.setSalary(50000.0);

        System.out.println(emp.getName()); // Getter
        System.out.println(emp); // ToString

        Employee emp2 = new Employee();
        emp2.setId("E001");
        emp2.setName("Alice");
        emp2.setSalary(50000.0);

        System.out.println("emp equals emp2? " + emp.equals(emp2)); // EqualsAndHashCode
    }
}
```

#### Builder

Anotasi `@Builder` menghasilkan pola Builder untuk class Anda, yang sangat berguna untuk membuat objek dengan banyak parameter secara lebih terbaca.

```java
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Order {
    private String orderId;
    private String customerName;
    private String product;
    private int quantity;
    private double totalAmount;

    public static void main(String[] args) {
        Order order = Order.builder()
                           .orderId("ORD-001")
                           .customerName("Bob")
                           .product("Laptop")
                           .quantity(1)
                           .totalAmount(1200.0)
                           .build();
        System.out.println(order);
    }
}
```

#### Non Null

Anotasi `@NonNull` pada parameter constructor atau method akan menghasilkan pemeriksaan null secara otomatis dan melempar `NullPointerException` jika argumennya null.

```java
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageSender {
    @NonNull private String recipient;

    public void sendMessage(@NonNull String message) {
        System.out.println("Mengirim pesan ke " + recipient + ": " + message);
    }

    public static void main(String[] args) {
        try {
            new MessageSender(null); // Akan melempar NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        MessageSender sender = new MessageSender("Alice");
        try {
            sender.sendMessage(null); // Akan melempar NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

#### Value

Anotasi `@Value` mirip dengan `@Data` tetapi membuat class menjadi immutable (semua field `final` dan tidak ada setter). Ini ideal untuk class yang merepresentasikan nilai.

```java
import lombok.Value;

@Value
public class ImmutablePoint {
    int x;
    int y;

    public static void main(String[] args) {
        ImmutablePoint p = new ImmutablePoint(10, 20);
        System.out.println(p.x()); // Getter otomatis
        System.out.println(p); // ToString otomatis
    }
}
```

#### With

Anotasi `@With` menghasilkan method `withX()` untuk setiap field, yang mengembalikan instance baru dari objek dengan field tersebut diubah. Berguna untuk objek immutable.

```java
import lombok.Value;
import lombok.With;

@Value
@With
public class UserProfile {
    String username;
    String email;
    String status;

    public static void main(String[] args) {
        UserProfile profile = new UserProfile("redhorizon", "red@example.com", "active");
        System.out.println("Original: " + profile);

        UserProfile updatedProfile = profile.withStatus("inactive");
        System.out.println("Updated: " + updatedProfile);
        System.out.println("Original (unchanged): " + profile);
    }
}
```

#### Cleanup

Anotasi `@Cleanup` memastikan bahwa resource yang perlu ditutup (seperti `InputStream`, `OutputStream`) akan ditutup secara otomatis, mirip dengan try-with-resources.

```java
import lombok.Cleanup;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CleanupExample {
    public static void main(String[] args) throws IOException {
        // Tanpa Lombok, perlu try-finally atau try-with-resources
        // Dengan Lombok, cukup @Cleanup
        @Cleanup FileInputStream in = new FileInputStream("input.txt");
        @Cleanup FileOutputStream out = new FileOutputStream("output.txt");

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        System.out.println("File berhasil disalin.");
    }
}
```

#### Sneaky Throws

Anotasi `@SneakyThrows` memungkinkan Anda untuk melempar checked exception tanpa mendeklarasikannya di signature method. Ini harus digunakan dengan hati-hati karena dapat menyembunyikan masalah.

```java
import lombok.SneakyThrows;
import java.io.IOException;

public class SneakyThrowsExample {

    @SneakyThrows(IOException.class)
    public void readFile() {
        // Ini akan melempar IOException, tapi tidak perlu dideklarasikan
        throw new IOException("Simulasi error baca file");
    }

    public static void main(String[] args) {
        SneakyThrowsExample example = new SneakyThrowsExample();
        try {
            example.readFile();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
```

#### Log

Lombok menyediakan anotasi untuk berbagai logger populer (`@Slf4j`, `@Log4j2`, `@CommonsLog`, dll.) yang secara otomatis membuat instance logger `static final` untuk class Anda.

```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogExample {
    public static void main(String[] args) {
        log.info("Ini adalah pesan info dari Lombok Slf4j.");
        log.debug("Ini adalah pesan debug.");
    }
}
```

#### Synchronized

Anotasi `@Synchronized` pada method akan membuat block `synchronized` di sekitar method tersebut, menggunakan objek `this` sebagai monitor.

```java
import lombok.Synchronized;

public class SynchronizedExample {
    private int counter = 0;

    @Synchronized
    public void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + ": " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                example.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter: " + example.counter);
    }
}
```

#### Experimental Feature

Lombok juga memiliki beberapa fitur eksperimental yang mungkin belum stabil atau bisa berubah di masa depan. Gunakan dengan hati-hati dan periksa dokumentasi Lombok untuk detail lebih lanjut.

---

## 7️⃣ Frameworks & Ecosystem

Bagian ini membahas alat dan kerangka kerja penting yang digunakan dalam ekosistem Java untuk manajemen proyek, pengembangan database, pengujian, dan membangun aplikasi yang tangguh.

### #1 Java Apache Maven

Apache Maven adalah alat manajemen proyek dan pemahaman yang komprehensif. Maven menyediakan cara standar untuk membangun proyek, mengelola dependensi, dan mendokumentasikan proyek. Ini menggunakan konsep Project Object Model (POM) berbasis XML.

#### Pengenalan Build Automation

Build automation adalah proses mengotomatiskan pembuatan aplikasi perangkat lunak dari kode sumber. Ini termasuk mengkompilasi kode, mengemasnya, menjalankan tes, dan menyebarkannya. Maven adalah salah satu alat build automation yang paling populer di Java.

#### Menginstall Apache Maven

1. **Unduh Maven:** Kunjungi situs resmi Apache Maven ([https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)) dan unduh arsip biner terbaru.
2. **Ekstrak Arsip:** Ekstrak file yang diunduh ke direktori pilihan Anda (misalnya, `C:\Program Files\Apache\maven` di Windows atau `/opt/maven` di Linux/macOS).
3. **Konfigurasi Environment Variables:**
   * Tambahkan `M2_HOME` atau `MAVEN_HOME` yang menunjuk ke direktori instalasi Maven.
   * Tambahkan `%M2_HOME%\bin` (Windows) atau `$M2_HOME/bin` (Linux/macOS) ke variabel `PATH` Anda.
4. **Verifikasi Instalasi:** Buka terminal atau command prompt dan jalankan `mvn -v`. Anda akan melihat informasi versi Maven jika instalasi berhasil.

#### Membuat Project

Anda dapat membuat proyek Maven baru menggunakan archetype (template proyek).

```bash
mvn archetype:generate \
    -DgroupId=com.mycompany.app \
    -DartifactId=my-app \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.4 \
    -DinteractiveMode=false
```

Perintah ini akan membuat direktori `my-app` dengan struktur proyek dasar dan file `pom.xml`.

#### Struktur Project

Proyek Maven mengikuti struktur direktori standar:

```
my-app/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/mycompany/app/App.java
    │   └── resources/
    └── test/
        ├── java/
        │   └── com/mycompany/app/AppTest.java
        └── resources/
```

* `src/main/java`: Kode sumber aplikasi.
* `src/main/resources`: File konfigurasi atau sumber daya aplikasi.
* `src/test/java`: Kode sumber untuk unit test.
* `src/test/resources`: File konfigurasi atau sumber daya untuk unit test.

#### Maven Lifecycle

Maven memiliki siklus hidup build yang terdefinisi dengan baik, yang terdiri dari fase-fase seperti `validate`, `compile`, `test`, `package`, `install`, dan `deploy`.

* `validate`: Memvalidasi proyek sudah benar dan semua informasi yang diperlukan tersedia.
* `compile`: Mengkompilasi kode sumber proyek.
* `test`: Menjalankan tes menggunakan kerangka kerja pengujian yang sesuai.
* `package`: Mengambil kode yang dikompilasi dan mengemasnya ke dalam format yang dapat didistribusikan (misalnya, JAR, WAR).
* `install`: Menginstal paket ke repositori Maven lokal, untuk digunakan sebagai dependensi di proyek lain secara lokal.
* `deploy`: Menyalin paket akhir ke repositori jarak jauh untuk dibagikan dengan pengembang lain dan proyek.

Anda dapat menjalankan fase dengan `mvn [fase]`, misalnya `mvn clean install`.

#### Build Project

Untuk membangun proyek, navigasikan ke direktori root proyek (tempat `pom.xml` berada) dan jalankan:

```bash
mvn clean install
```

Ini akan membersihkan proyek, mengkompilasi kode, menjalankan tes, mengemasnya, dan menginstalnya ke repositori Maven lokal Anda.

#### Dependency

Maven mengelola dependensi proyek secara otomatis. Anda mendeklarasikan dependensi di file `pom.xml`, dan Maven akan mengunduhnya dari repositori pusat.

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

* `groupId`: ID unik organisasi atau proyek.
* `artifactId`: ID unik proyek.
* `version`: Versi dependensi.
* `scope`: Lingkup dependensi (misalnya, `compile`, `test`, `provided`, `runtime`).

#### Maven Properties

Anda dapat mendefinisikan properti kustom di `pom.xml` untuk mengelola versi dependensi atau konfigurasi lainnya.

```xml
<properties>
    <project.build.sourceEncoding>UTF-8</nproject.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <junit.version>4.13.2</junit.version>
</properties>

<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### Membuat Distribution File

Untuk membuat file JAR yang dapat dieksekusi (executable JAR) yang berisi semua dependensi, Anda dapat menggunakan `maven-assembly-plugin` atau `maven-shade-plugin`.

Contoh dengan `maven-assembly-plugin`:

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>3.6.0</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>com.mycompany.app.App</mainClass>
                    </manifest>
                </archive>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
            </configuration>
            <executions>
                <execution>
                    <id>make-assembly</id>
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

Setelah konfigurasi ini, jalankan `mvn clean package`. Ini akan membuat JAR dengan semua dependensi di direktori `target/`.

#### Multi Module Project

Menganalisis proyek besar menjadi beberapa modul yang lebih kecil, masing-masing dengan `pom.xml` sendiri, tetapi dikelola oleh POM induk.

```xml
<!-- Parent POM -->
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.mycompany.app</groupId>
    <artifactId>my-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>
        <module>module-core</module>
        <module>module-web</module>
    </modules>
</project>
```

#### Dependency Management

Di POM induk, Anda dapat menggunakan `<dependencyManagement>` untuk mengelola versi dependensi secara terpusat, memastikan semua modul menggunakan versi yang sama.

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>3.2.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

#### Key-Value

##### 1. **Project Info**


| Key (Tag)       | Value                                       | Fungsi                                 |
| ----------------- | --------------------------------------------- | ---------------------------------------- |
| `<groupId>`     | com.example                                 | ID unik grup/organisasi/project.       |
| `<artifactId>`  | my-app                                      | Nama project/artifact.                 |
| `<version>`     | 1.0.0                                       | Versi project.                         |
| `<packaging>`   | jar / war / pom                             | Tipe output build (jar, war, dll).     |
| `<name>`        | My Application                              | Nama project yang bisa dibaca manusia. |
| `<description>` | "Project demo"                              | Deskripsi project.                     |
| `<url>`         | [https://example.com](https://example.com/) | URL resmi project.                     |

---

##### 2. **Dependencies**


| Key            | Value                               | Fungsi                                                    |
| ---------------- | ------------------------------------- | ----------------------------------------------------------- |
| `<dependency>` | -                                   | Block utama untuk mendefinisikan library yang dibutuhkan. |
| `<groupId>`    | org.springframework.boot            | Grup library.                                             |
| `<artifactId>` | spring-boot-starter-web             | Nama library.                                             |
| `<version>`    | 3.1.1                               | Versi library.                                            |
| `<scope>`      | compile / test / provided / runtime | Menentukan di mana dependency digunakan.                  |
| `<optional>`   | true / false                        | Jika true, dependency tidak diwariskan ke project lain.   |

**Scope singkat:**

* `compile`: default, digunakan di compile dan runtime.
* `test`: hanya untuk testing.
* `provided`: ada di environment, tidak dibundel.
* `runtime`: hanya runtime, tidak untuk compile.

---

##### 3. **Build & Plugins**


| Key               | Value                    | Fungsi                                                      |
| ------------------- | -------------------------- | ------------------------------------------------------------- |
| `<build>`         | -                        | Block untuk konfigurasi build.                              |
| `<plugins>`       | -                        | Daftar plugin Maven.                                        |
| `<plugin>`        | -                        | Satu plugin spesifik.                                       |
| `<groupId>`       | org.apache.maven.plugins | Grup plugin.                                                |
| `<artifactId>`    | maven-compiler-plugin    | Nama plugin.                                                |
| `<version>`       | 3.10.1                   | Versi plugin.                                               |
| `<configuration>` | -                        | Konfigurasi khusus plugin, misal`source` dan `target` Java. |

---

##### 4. **Repositories**


| Key              | Value                                                                        | Fungsi                           |
| ------------------ | ------------------------------------------------------------------------------ | ---------------------------------- |
| `<repositories>` | -                                                                            | Tempat Maven mencari dependency. |
| `<repository>`   | -                                                                            | Satu repo spesifik.              |
| `<id>`           | central                                                                      | Nama repo.                       |
| `<url>`          | [https://repo.maven.apache.org/maven2](https://repo.maven.apache.org/maven2) | Alamat repo.                     |

---

##### 5. **Properties**


| Key              | Value | Fungsi                                     |
| ------------------ | ------- | -------------------------------------------- |
| `<properties>`   | -     | Mendefinisikan variable global project.    |
| `<java.version>` | 17    | Bisa digunakan di plugin, dependency, dll. |

### #2 Java Database

Java Database Connectivity (JDBC) adalah API standar Java untuk konektivitas database. Ini menyediakan metode untuk query dan memperbarui data dalam database. JDBC adalah dasar untuk banyak framework persistensi Java lainnya seperti Hibernate dan JPA.

#### Pengenalan JDBC

JDBC adalah spesifikasi API yang memungkinkan program Java untuk mengakses database relasional. Ini terdiri dari dua bagian utama:

1. **JDBC API:** Kumpulan interface dan class yang digunakan oleh pengembang aplikasi.
2. **JDBC Driver:** Implementasi dari interface JDBC API oleh vendor database tertentu.

#### Membuat Project

Untuk menggunakan JDBC, Anda perlu menambahkan driver database yang sesuai sebagai dependensi di `pom.xml` Anda. Contoh untuk MySQL:

```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
```

#### Driver

Setiap database memerlukan driver JDBC spesifiknya. Driver ini bertanggung jawab untuk menerjemahkan panggilan JDBC API ke protokol database yang sebenarnya.

#### Connection

Objek `Connection` merepresentasikan sesi komunikasi dengan database. Ini adalah objek pertama yang Anda dapatkan saat berinteraksi dengan database.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Koneksi ke database berhasil!");
            } else {
                System.out.println("Gagal membuat koneksi.");
            }
        } catch (SQLException e) {
            System.err.println("Error koneksi database: " + e.getMessage());
        }
    }
}
```

#### DataSource

`DataSource` adalah alternatif yang lebih disukai untuk `DriverManager` untuk mendapatkan koneksi. Ini sering digunakan dalam lingkungan enterprise dan dengan connection pooling.

```java
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceExample {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setUser("root");
        dataSource.setPassword("password");

        try (Connection conn = dataSource.getConnection()) {
            if (conn != null) {
                System.out.println("Koneksi ke database melalui DataSource berhasil!");
            } else {
                System.out.println("Gagal membuat koneksi.");
            }
        } catch (SQLException e) {
            System.err.println("Error koneksi database: " + e.getMessage());
        }
    }
}
```

#### Statement

Objek `Statement` digunakan untuk mengeksekusi query SQL statis tanpa parameter.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Membuat tabel
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50))");
            System.out.println("Tabel 'users' dibuat atau sudah ada.");

            // Memasukkan data
            stmt.executeUpdate("INSERT INTO users (name) VALUES ('Alice')");
            stmt.executeUpdate("INSERT INTO users (name) VALUES ('Bob')");
            System.out.println("Data dimasukkan.");

            // Membaca data
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            System.err.println("Error Statement: " + e.getMessage());
        }
    }
}
```

#### ResultSet

Objek `ResultSet` berisi hasil dari eksekusi query SQL (misalnya, `SELECT`). Anda dapat mengiterasi melalui baris dan kolom untuk mengambil data.

#### SQL Injection

Kerentanan keamanan di mana penyerang dapat menyuntikkan kode SQL berbahaya ke dalam query. Ini dapat dicegah dengan menggunakan `PreparedStatement`.

#### PreparedStatement

Objek `PreparedStatement` digunakan untuk mengeksekusi query SQL yang sudah dikompilasi sebelumnya dan dapat menerima parameter. Ini adalah cara yang aman dan efisien untuk mengeksekusi query berulang kali dan mencegah SQL Injection.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            // Memasukkan data dengan PreparedStatement
            String insertSQL = "INSERT INTO users (name) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Charlie");
                pstmt.executeUpdate();
                pstmt.setString(1, "David");
                pstmt.executeUpdate();
                System.out.println("Data dimasukkan dengan PreparedStatement.");
            }

            // Membaca data dengan parameter
            String selectSQL = "SELECT id, name FROM users WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                pstmt.setString(1, "Charlie");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Found: ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error PreparedStatement: " + e.getMessage());
        }
    }
}
```

#### Batch Process

Mengeksekusi beberapa pernyataan SQL sebagai satu batch, yang dapat meningkatkan performa karena mengurangi round-trip ke database.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            conn.setAutoCommit(false); // Mulai transaksi

            String insertSQL = "INSERT INTO users (name) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                for (int i = 0; i < 5; i++) {
                    pstmt.setString(1, "User_" + i);
                    pstmt.addBatch(); // Tambahkan ke batch
                }
                int[] updateCounts = pstmt.executeBatch(); // Eksekusi batch
                System.out.println("Batch executed. Rows affected: " + updateCounts.length);
            }
            conn.commit(); // Commit transaksi

        } catch (SQLException e) {
            System.err.println("Error Batch Process: " + e.getMessage());
        }
    }
}
```

#### Auto Increment

Mengambil nilai kunci utama yang dihasilkan secara otomatis oleh database setelah operasi `INSERT`.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoIncrementExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String insertSQL = "INSERT INTO users (name) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, "Eve");
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            System.out.println("Generated ID: " + generatedKeys.getLong(1));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error Auto Increment: " + e.getMessage());
        }
    }
}
```

#### Date, Time dan Timestamp

JDBC menyediakan class `java.sql.Date`, `java.sql.Time`, dan `java.sql.Timestamp` untuk bekerja dengan tipe data tanggal dan waktu database. Sejak Java 8, disarankan untuk mengonversi antara `java.time` API dan tipe `java.sql`.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateTimeJdbcExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Pastikan tabel memiliki kolom datetime
            conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS events (id INT AUTO_INCREMENT PRIMARY KEY, description VARCHAR(255), event_time DATETIME)");

            String insertSQL = "INSERT INTO events (description, event_time) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Meeting");
                pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                pstmt.executeUpdate();
                System.out.println("Event inserted.");
            }

            String selectSQL = "SELECT description, event_time FROM events";
            try (ResultSet rs = conn.createStatement().executeQuery(selectSQL)) {
                while (rs.next()) {
                    System.out.println("Description: " + rs.getString("description") + ", Time: " + rs.getTimestamp("event_time").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            System.err.println("Error Date/Time JDBC: " + e.getMessage());
        }
    }
}
```

#### Database Transaction

Transaksi memastikan bahwa serangkaian operasi database diperlakukan sebagai satu unit kerja. Semua operasi dalam transaksi harus berhasil (commit) atau tidak ada yang berhasil (rollback).

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false); // Matikan auto-commit untuk memulai transaksi

            String update1 = "UPDATE accounts SET balance = balance - 100 WHERE id = 1";
            String update2 = "UPDATE accounts SET balance = balance + 100 WHERE id = 2";

            try (PreparedStatement pstmt1 = conn.prepareStatement(update1);
                 PreparedStatement pstmt2 = conn.prepareStatement(update2)) {

                pstmt1.executeUpdate();
                // Simulasi error
                // int x = 1 / 0;
                pstmt2.executeUpdate();

                conn.commit(); // Commit transaksi jika semua berhasil
                System.out.println("Transaksi berhasil.");
            }

        } catch (SQLException e) {
            System.err.println("Error Transaksi: " + e.getMessage());
            if (conn != null) {
                try {
                    System.out.println("Melakukan rollback.");
                    conn.rollback(); // Rollback jika ada error
                } catch (SQLException ex) {
                    System.err.println("Error rollback: " + ex.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error menutup koneksi: " + e.getMessage());
                }
            }
        }
    }
}
```

#### Repository Pattern

Pola desain yang mengabstraksi logika akses data, menyediakan koleksi objek domain yang mirip dengan koleksi dalam memori. Ini memisahkan logika bisnis dari logika persistensi.

#### Materi yang Tidak Dibahas

JDBC adalah API tingkat rendah. Framework ORM (Object-Relational Mapping) seperti Hibernate atau JPA (Jakarta Persistence API) menyediakan abstraksi yang lebih tinggi untuk interaksi database, memungkinkan Anda bekerja dengan objek Java daripada SQL mentah. Ini tidak dibahas secara detail di sini tetapi merupakan langkah selanjutnya yang umum dalam pengembangan aplikasi Java.

### #3 Java Unit Test

Unit testing adalah proses pengujian unit terkecil dari kode sumber yang dapat diuji secara individual (misalnya, method atau class). Tujuannya adalah untuk memverifikasi bahwa setiap unit kode berfungsi seperti yang diharapkan. JUnit adalah framework unit testing paling populer di Java.

#### Pengenalan Software Testing

Software testing adalah proses mengevaluasi dan memverifikasi bahwa produk atau aplikasi perangkat lunak melakukan apa yang seharusnya dilakukan. Ini membantu mengidentifikasi bug, cacat, atau persyaratan yang hilang. Unit testing adalah salah satu level testing.

#### Pengenalan JUnit

JUnit adalah framework open-source untuk menulis dan menjalankan unit test di Java. JUnit 5 adalah versi terbaru dan modular, terdiri dari beberapa modul seperti JUnit Platform, JUnit Jupiter, dan JUnit Vintage.

#### Membuat Test

Untuk menggunakan JUnit 5, tambahkan dependency berikut ke `pom.xml` Anda:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

Contoh class yang akan diuji:

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
```

Contoh test class:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "2 + 3 should be 5");
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should be 1");
    }
}
```

#### Menggunakan Assertions

JUnit menyediakan berbagai method `assert` untuk memverifikasi hasil tes. Beberapa yang umum:

* `assertEquals(expected, actual, message)`
* `assertTrue(condition, message)`
* `assertFalse(condition, message)`
* `assertNull(object, message)`
* `assertNotNull(object, message)`
* `assertThrows(expectedType, executable, message)`

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionExampleTest {

    @Test
    void testAssertions() {
        String actual = "Hello";
        String expected = "Hello";
        assertEquals(expected, actual, "String should be equal");

        assertTrue(5 > 0, "5 should be greater than 0");
        assertFalse(5 < 0, "5 should not be less than 0");

        Object obj = null;
        assertNull(obj, "Object should be null");
        assertNotNull("Not Null", "Object should not be null");

        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        }, "Should throw ArithmeticException");
    }
}
```

#### Mengubah Nama Test

Anda dapat memberikan nama yang lebih deskriptif untuk test method menggunakan anotasi `@DisplayName`.

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Class untuk Kalkulator")
public class CalculatorDisplayNameTest {

    @Test
    @DisplayName("Penjumlahan dua angka positif")
    void testAddPositiveNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Pengurangan dengan hasil negatif")
    void testSubtractNegativeResult() {
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.subtract(2, 3));
    }
}
```

#### Menonaktifkan Test

Gunakan anotasi `@Disabled` untuk menonaktifkan test method atau seluruh test class.

```java
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTestExample {

    @Test
    @Disabled("Test ini dinonaktifkan sementara")
    void testWillBeSkipped() {
        fail("Seharusnya tidak dieksekusi");
    }

    @Test
    void testWillBeExecuted() {
        assertTrue(true);
    }
}
```

#### Sebelum dan Setelah Test

JUnit menyediakan anotasi untuk menjalankan kode sebelum atau setelah setiap test method atau sebelum/setelah semua test dalam class:

* `@BeforeEach`: Dijalankan sebelum setiap test method.
* `@AfterEach`: Dijalankan setelah setiap test method.
* `@BeforeAll`: Dijalankan sekali sebelum semua test method dalam class (harus static).
* `@AfterAll`: Dijalankan sekali setelah semua test method dalam class (harus static).

```java
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleTest {

    @BeforeAll
    static void setupAll() {
        System.out.println("\n@BeforeAll: Hanya sekali sebelum semua test.");
    }

    @BeforeEach
    void setup() {
        System.out.println("  @BeforeEach: Sebelum setiap test.");
    }

    @Test
    void test1() {
        System.out.println("    Test 1 dijalankan.");
    }

    @Test
    void test2() {
        System.out.println("    Test 2 dijalankan.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("  @AfterEach: Setelah setiap test.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll: Hanya sekali setelah semua test.\n");
    }
}
```

#### Membatalkan Test

Anda dapat membatalkan eksekusi test secara programatik menggunakan `Assumptions`.

#### Menggunakan Assumptions

`Assumptions` digunakan untuk mengkondisikan eksekusi test. Jika asumsi tidak terpenuhi, test akan dibatalkan (skipped), bukan gagal.

* `assumeTrue(condition, message)`
* `assumeFalse(condition, message)`
* `assumingThat(condition, executable)`

```java
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssumptionExampleTest {

    @Test
    void testOnlyOnDevelopmentEnvironment() {
        // Asumsi: test ini hanya berjalan jika environment adalah "DEV"
        Assumptions.assumeTrue("DEV".equals(System.getenv("APP_ENV")), "Melewatkan test karena bukan DEV env");
        assertTrue(true, "Test ini berjalan di DEV env");
    }

    @Test
    void testAlwaysRun() {
        Assumptions.assumingThat("PROD".equals(System.getenv("APP_ENV")), () -> {
            // Kode ini hanya berjalan jika asumsi benar
            System.out.println("Ini berjalan di PROD env");
        });
        assertTrue(true, "Test ini selalu berjalan");
    }
}
```

#### Test Berdasarkan Kondisi

JUnit 5 memungkinkan Anda untuk mengaktifkan atau menonaktifkan test berdasarkan kondisi tertentu (misalnya, versi Java, sistem operasi, properti sistem) menggunakan anotasi seperti `@EnabledOnOs`, `@DisabledOnJre`.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class ConditionalTestExample {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnWindows() {
        System.out.println("Test ini hanya berjalan di Windows");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testNotOnJava8() {
        System.out.println("Test ini tidak berjalan di Java 8");
    }
}
```

#### Menggunakan Tag

Gunakan anotasi `@Tag` untuk mengelompokkan test. Anda dapat menjalankan test berdasarkan tag tertentu dari command line atau IDE.

```java
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TaggedTestExample {

    @Test
    @Tag("fast")
    void fastTest() {
        System.out.println("Ini adalah test cepat.");
    }

    @Test
    @Tag("slow")
    @Tag("integration")
    void slowIntegrationTest() {
        System.out.println("Ini adalah test integrasi yang lambat.");
    }
}
```

#### Urutan Eksekusi Test

Secara default, JUnit menjalankan test dalam urutan yang tidak deterministik. Anda dapat mengontrol urutan eksekusi menggunakan `@TestMethodOrder` dan `@Order`.

```java
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTestExample {

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("First Test");
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Second Test");
    }
}
```

#### Siklus Hidup Test

JUnit 5 memperkenalkan model siklus hidup yang fleksibel, memungkinkan ekstensi untuk mengaitkan ke berbagai titik dalam siklus hidup test.

#### Test di dalam Test

JUnit 5 mendukung nested tests menggunakan anotasi `@Nested`, yang membantu mengorganisir test yang terkait dalam class yang lebih besar.

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Outer Test Class")
public class NestedTestExample {

    @BeforeEach
    void beforeEachOuter() {
        System.out.println("  Before each outer test");
    }

    @Test
    void outerTest() {
        System.out.println("    Outer test executed");
    }

    @Nested
    @DisplayName("Inner Test Class for specific scenario")
    class InnerTest {

        @BeforeEach
        void beforeEachInner() {
            System.out.println("    Before each inner test");
        }

        @Test
        void innerTest1() {
            System.out.println("      Inner test 1 executed");
        }

        @Test
        void innerTest2() {
            System.out.println("      Inner test 2 executed");
        }
    }
}
```

#### Informasi Test

Anda dapat menyuntikkan informasi tentang test yang sedang berjalan ke dalam test method menggunakan `TestInfo` parameter.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class TestInfoExample {

    @Test
    void testWithInfo(TestInfo testInfo) {
        System.out.println("Display Name: " + testInfo.getDisplayName());
        System.out.println("Tags: " + testInfo.getTags());
        System.out.println("Test Class: " + testInfo.getTestClass().orElse(null));
        System.out.println("Test Method: " + testInfo.getTestMethod().orElse(null));
    }
}
```

#### Dependency Injection di Test

JUnit 5 mendukung dependency injection untuk parameter test method, memungkinkan Anda untuk menyuntikkan objek seperti `TestInfo`, `TestReporter`, atau `ExtensionContext`.

#### Pewarisan di Test

Test class dapat mewarisi dari class dasar, memungkinkan berbagi konfigurasi dan test method.

#### Test Berulang

Gunakan `@RepeatedTest` untuk menjalankan test method beberapa kali.

```java
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTestExample {

    @RepeatedTest(5)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
    }
}
```

#### Test dengan Parameter

Gunakan `@ParameterizedTest` dengan sumber argumen (misalnya, `@ValueSource`, `@CsvSource`, `@MethodSource`) untuk menjalankan test yang sama dengan data input yang berbeda.

```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestExample {

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "madam", "level" })
    void palindromes(String candidate) {
        assertTrue(isPalindrome(candidate));
    }

    boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }
}
```

#### Timeout di Test

Gunakan `@Timeout` untuk memastikan test method selesai dalam waktu tertentu. Jika tidak, test akan gagal.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class TimeoutTestExample {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testWithTimeout() throws InterruptedException {
        Thread.sleep(50);
        System.out.println("Test selesai dalam waktu.");
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testWithTimeoutFailure() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("Test ini akan gagal karena timeout.");
    }
}
```

#### Eksekusi Test Secara Paralel

JUnit 5 mendukung eksekusi test secara paralel untuk mempercepat waktu build. Ini dikonfigurasi di `junit-platform.properties`.

#### Pengenalan Mocking

Mocking adalah teknik dalam unit testing di mana objek tiruan (mock object) dibuat untuk mensimulasikan perilaku objek nyata. Ini berguna ketika objek nyata sulit dibuat, memiliki dependensi yang kompleks, atau melakukan operasi yang lambat (misalnya, akses database, panggilan jaringan).

#### Mocking di Test

Mockito adalah framework mocking populer di Java. Tambahkan dependency:

```xml
<dependencies>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>5.7.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

Contoh:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Class yang akan di-mock
interface DataService {
    String fetchData();
}

// Class yang menggunakan DataService
class BusinessLogic {
    private DataService dataService;

    public BusinessLogic(DataService dataService) {
        this.dataService = dataService;
    }

    public String processData() {
        return "Processed: " + dataService.fetchData();
    }
}

@ExtendWith(MockitoExtension.class)
public class MockingExampleTest {

    @Mock
    DataService mockDataService; // Membuat mock object

    @Test
    void testProcessData() {
        // Mendefinisikan perilaku mock
        when(mockDataService.fetchData()).thenReturn("Real Data");

        BusinessLogic businessLogic = new BusinessLogic(mockDataService);
        String result = businessLogic.processData();

        assertEquals("Processed: Real Data", result);

        // Memverifikasi bahwa method fetchData dipanggil sekali
        verify(mockDataService, times(1)).fetchData();
    }
}
```

#### Verifikasi di Mocking

Menggunakan `verify()` dari Mockito untuk memastikan bahwa method tertentu pada mock object dipanggil dengan argumen yang benar dan jumlah panggilan yang diharapkan.

### #4 Java Resilience4J

Resilience4j adalah library fault tolerance ringan yang dirancang untuk pemrograman fungsional. Ini menyediakan fungsionalitas seperti Circuit Breaker, Rate Limiter, Bulkhead, Retry, dan Time Limiter untuk membangun aplikasi mikroservis yang tangguh.

#### Membuat Project

Untuk menggunakan Resilience4j, tambahkan dependency yang relevan ke `pom.xml` Anda. Misalnya, untuk Circuit Breaker dan Retry:

```xml
<dependencies>
    <dependency>
        <groupId>io.github.resilience4j</groupId>
        <artifactId>resilience4j-circuitbreaker</artifactId>
        <version>2.2.0</version>
    </dependency>
    <dependency>
        <groupId>io.github.resilience4j</groupId>
        <artifactId>resilience4j-retry</artifactId>
        <version>2.2.0</version>
    </dependency>
    <!-- Tambahkan modul lain sesuai kebutuhan, misal resilience4j-ratelimiter, resilience4j-bulkhead -->
</dependencies>
```

#### Retry

Retry adalah mekanisme untuk secara otomatis mencoba kembali operasi yang gagal. Ini berguna untuk menangani kegagalan sementara (transient failures) seperti masalah jaringan sesaat.

```java
import io.resilience4j.retry.Retry;
import io.resilience4j.retry.RetryConfig;
import io.resilience4j.retry.RetryRegistry;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class RetryExample {
    private static AtomicInteger callCount = new AtomicInteger(0);

    public static String callExternalService() {
        int currentCount = callCount.incrementAndGet();
        System.out.println("Mencoba memanggil layanan eksternal, percobaan ke-" + currentCount);
        if (currentCount < 3) {
            throw new RuntimeException("Layanan tidak tersedia sementara");
        } else {
            return "Data berhasil diterima!";
        }
    }

    public static void main(String[] args) {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5) // Maksimal 5 percobaan
                .waitDuration(Duration.ofMillis(1000)) // Tunggu 1 detik antar percobaan
                .build();

        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("myServiceRetry");

        Supplier<String> decoratedSupplier = Retry.decorateSupplier(retry, () -> callExternalService());

        try {
            String result = decoratedSupplier.get();
            System.out.println("Hasil: " + result);
        } catch (Exception e) {
            System.err.println("Gagal setelah beberapa percobaan: " + e.getMessage());
        }
    }
}
```

#### Retry Config

Konfigurasi untuk Retry, termasuk jumlah percobaan maksimum, durasi tunggu antar percobaan, dan kondisi kapan harus mencoba kembali.

#### Retry Registry

Manajer untuk instance `Retry`. Memungkinkan Anda untuk membuat dan mengambil instance `Retry` yang telah dikonfigurasi.

#### Rate Limiter

Rate Limiter membatasi jumlah permintaan yang dapat dilakukan ke suatu layanan dalam periode waktu tertentu. Ini mencegah layanan dari kelebihan beban.

```java
import io.resilience4j.ratelimiter.RateLimiter;
import io.resilience4j.ratelimiter.RateLimiterConfig;
import io.resilience4j.ratelimiter.RateLimiterRegistry;
import java.time.Duration;

public class RateLimiterExample {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofSeconds(1)) // Setiap 1 detik
                .limitForPeriod(2) // Hanya 2 permintaan per periode
                .timeoutDuration(Duration.ofSeconds(5)) // Tunggu maksimal 5 detik jika limit tercapai
                .build();

        RateLimiterRegistry registry = RateLimiterRegistry.of(config);
        RateLimiter rateLimiter = registry.rateLimiter("myServiceRateLimiter");

        for (int i = 0; i < 5; i++) {
            try {
                RateLimiter.decorateRunnable(rateLimiter, () -> System.out.println("Permintaan " + (i + 1) + " diproses.")).run();
                Thread.sleep(100); // Simulasi waktu pemrosesan
            } catch (Exception e) {
                System.err.println("Permintaan " + (i + 1) + " ditolak/timeout: " + e.getMessage());
            }
        }
    }
}
```

#### Rate Limiter Config

Konfigurasi untuk Rate Limiter, termasuk periode refresh limit, jumlah permintaan per periode, dan durasi timeout.

#### Rate Limiter Registry

Manajer untuk instance `RateLimiter`.

#### Bulkhead

Bulkhead mengisolasi bagian-bagian aplikasi sehingga kegagalan di satu area tidak akan menjatuhkan seluruh sistem. Ini membatasi jumlah eksekusi bersamaan.

```java
import io.resilience4j.bulkhead.Bulkhead;
import io.resilience4j.bulkhead.BulkheadConfig;
import io.resilience4j.bulkhead.BulkheadRegistry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BulkheadExample {
    public static void main(String[] args) throws InterruptedException {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(2) // Hanya 2 panggilan bersamaan
                .maxWaitDuration(Duration.ofMillis(500)) // Tunggu maksimal 500ms jika penuh
                .build();

        BulkheadRegistry registry = BulkheadRegistry.of(config);
        Bulkhead bulkhead = registry.bulkhead("myServiceBulkhead");

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    Bulkhead.decorateRunnable(bulkhead, () -> {
                        System.out.println("Tugas " + taskId + " dimulai.");
                        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                        System.out.println("Tugas " + taskId + " selesai.");
                    }).run();
                } catch (Exception e) {
                    System.err.println("Tugas " + taskId + " ditolak oleh Bulkhead: " + e.getMessage());
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
```

#### Bulkhead Config

Konfigurasi untuk Bulkhead, termasuk jumlah panggilan bersamaan maksimum dan durasi tunggu maksimum.

#### Bulkhead Registry

Manajer untuk instance `Bulkhead`.

#### Time Limiter

Time Limiter membatasi waktu eksekusi suatu operasi. Jika operasi tidak selesai dalam waktu yang ditentukan, ia akan diinterupsi atau dilemparkan `TimeoutException`.

```java
import io.resilience4j.timelimiter.TimeLimiter;
import io.resilience4j.timelimiter.TimeLimiterConfig;
import io.resilience4j.timelimiter.TimeLimiterRegistry;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TimeLimiterExample {
    public static String longRunningTask() throws InterruptedException {
        System.out.println("Memulai tugas yang panjang...");
        Thread.sleep(3000); // Tugas yang memakan waktu 3 detik
        System.out.println("Tugas yang panjang selesai.");
        return "Hasil tugas panjang";
    }

    public static void main(String[] args) throws Exception {
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(2)) // Timeout setelah 2 detik
                .build();

        TimeLimiterRegistry registry = TimeLimiterRegistry.of(config);
        TimeLimiter timeLimiter = registry.timeLimiter("myServiceTimeLimiter");

        Callable<String> limitedCallable = TimeLimiter.decorateFutureSupplier(timeLimiter,
                () -> Executors.newSingleThreadExecutor().submit(() -> longRunningTask()));

        try {
            String result = limitedCallable.call();
            System.out.println("Hasil: " + result);
        } catch (Exception e) {
            System.err.println("Tugas timeout: " + e.getMessage());
        }
    }
}
```

#### Time Limiter Config

Konfigurasi untuk Time Limiter, termasuk durasi timeout.

#### Time Limiter Registry

Manajer untuk instance `TimeLimiter`.

#### Circuit Breaker

Circuit Breaker mencegah aplikasi berulang kali mencoba operasi yang kemungkinan besar akan gagal. Ini mendeteksi kegagalan, menghentikan panggilan ke layanan yang gagal untuk sementara waktu, dan kemudian memungkinkan panggilan untuk dilanjutkan setelah periode tertentu.

```java
import io.resilience4j.circuitbreaker.CircuitBreaker;
import io.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class CircuitBreakerExample {
    private static AtomicInteger failureCount = new AtomicInteger(0);

    public static String callFailingService() {
        int currentFailure = failureCount.incrementAndGet();
        if (currentFailure <= 3) {
            System.out.println("Layanan gagal, percobaan ke-" + currentFailure);
            throw new RuntimeException("Simulasi kegagalan layanan");
        } else {
            System.out.println("Layanan berhasil!");
            return "Data dari layanan";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50) // Jika 50% panggilan gagal
                .waitDurationInOpenState(Duration.ofSeconds(5)) // Buka selama 5 detik
                .ringBufferSizeInClosedState(2) // Ukuran buffer di keadaan tertutup
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        CircuitBreaker circuitBreaker = registry.circuitBreaker("myServiceCircuitBreaker");

        Supplier<String> decoratedSupplier = CircuitBreaker.decorateSupplier(circuitBreaker, () -> callFailingService());

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Panggilan " + (i + 1) + ": " + decoratedSupplier.get());
            } catch (Exception e) {
                System.err.println("Panggilan " + (i + 1) + ": Gagal - " + e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}
```

#### Circuit Breaker Config

Konfigurasi untuk Circuit Breaker, termasuk ambang batas kegagalan, durasi tunggu dalam keadaan terbuka, dan ukuran buffer.

#### Circuit Breaker Registry

Manajer untuk instance `CircuitBreaker`.

#### Decorators

Resilience4j menggunakan pola decorator untuk membungkus fungsionalitas yang ada dengan fitur fault tolerance. Anda dapat menggabungkan beberapa decorator (misalnya, Retry + Circuit Breaker).

#### Fallback

Menyediakan mekanisme fallback (cadangan) untuk dieksekusi ketika operasi utama gagal atau diblokir oleh salah satu pola fault tolerance.

```java
import io.resilience4j.circuitbreaker.CircuitBreaker;
import io.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import java.time.Duration;
import java.util.function.Supplier;

public class FallbackExample {
    private static int callCount = 0;

    public static String failingService() {
        callCount++;
        if (callCount <= 2) {
            System.out.println("Layanan utama gagal, percobaan ke-" + callCount);
            throw new RuntimeException("Gagal!");
        }
        System.out.println("Layanan utama berhasil.");
        return "Data Utama";
    }

    public static String fallbackService(Throwable throwable) {
        System.out.println("Menggunakan layanan fallback karena: " + throwable.getMessage());
        return "Data Fallback";
    }

    public static void main(String[] args) {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(2))
                .ringBufferSizeInClosedState(2)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        CircuitBreaker circuitBreaker = registry.circuitBreaker("myServiceWithFallback");

        Supplier<String> supplier = CircuitBreaker.decorateSupplier(circuitBreaker, () -> failingService());

        for (int i = 0; i < 5; i++) {
            String result = Try.of(supplier)
                               .recover(FallbackExample::fallbackService)
                               .get();
            System.out.println("Hasil panggilan: " + result);
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
```

#### Metric

Resilience4j menyediakan metrik untuk memantau status dan kinerja setiap instance fault tolerance. Ini dapat diintegrasikan dengan sistem monitoring seperti Prometheus.

#### Event Publisher

Setiap instance fault tolerance (Circuit Breaker, Retry, dll.) menerbitkan event (misalnya, `onSuccess`, `onError`, `onStateTransition`). Anda dapat berlangganan event ini untuk logging, monitoring, atau tindakan lainnya.

#### Event Publisher di Registry

Anda juga dapat berlangganan event di tingkat Registry untuk memantau semua instance dari jenis fault tolerance tertentu.

#### Integrasi Library Lain

Resilience4j dapat diintegrasikan dengan library lain seperti Spring Boot, Reactor, atau RxJava untuk pengalaman pengembangan yang lebih mulus.
