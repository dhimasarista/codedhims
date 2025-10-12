# Learn Java Detail

---

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

- int → bilangan bulat (contoh: int x = 10;)
- double → bilangan desimal (contoh: double y = 3.14;)
- long, float, short, byte → variasi ukuran & presisi

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

### #1 Java Date & Time API

```bash
- Pengenalan Date dan Time API
- Date
- Calendar
- TimeZone
- LocalDate
- LocalTime
- LocalDateTime
- Year YearMonth dan MonthDay
- ZoneId dan ZoneOffset
- ZonedDateTime
- OffsetTime dan OffsetDateTime
- Instant
- Clock
- Duration
- Period
- Temporal
- DayOfWeek
- Parsing dan Formatting
- Legacy Date dan Time

```

### #2 Java Logging

```bash
- Logging Library
- Membuat Project
- Logger
- Level
- Log Format
- Configuration
- Appender
- Layout
- Mapped Diagnostic Context

```

### #3 Java Validation

```bash
- Validator
- Constraint
- Constraint Validator
- Nested Validation
- Hibernate Validator Constraint
- Grouping Constraint
- Group Sequence
- Group Conversion
- Payload
- Method Validation
- Constructor Validation
- Message Interpolation
- Message Internationalization
- Custom Constraint
- Constraint Composition
- Class Level Constraint
- Cross Parameter Constraint
- Constraint Validator Context
- Constraint Descriptor
- Container Data
- Value Extraction
- Constraint Violation Exception
- Metadata

```

### #4 Java Internationalization

```bash
- Locale
- Resource Bundle
- I18N di Date dan Time
- I18N di Number
- I18N di Currency
- Message Format
- Message Format Type
- Choice Format

```

---

## 5️⃣ Concurrency & Parallelism

### #1 Java Thread

```bash
- Thread
- Race Condition
- Synchronization
- Deadlock
- Thread Communication
- Timer
- High Level Concurrency Object
- Threadpool
- Executor Service
- Future
- Completable Future
- Completion Service
- Scheduled Executor Service
- Atomic
- Lock
- Synchronizer
- Semaphore
- Count Down Latch
- Cyclic Barrier
- Phaser
- Exchanger
- Concurrent Collection
- Blocking Queue
- Concurrent Map
- Thread Local
- Thread Local Random
- Fork Join
- Parallel Stream
- Reactive Stream

```

### #2 Java Virtual Thread

```bash
- Platform Thread
- Virtual Thread
- Virtual Thread Executor Service

```

### #3 Java Lambda

```bash
- Membuat Lambda
- Java Util Function
- Method Reference
- Lambda di Collection
- Lambda Sebagai Lazy Parameter
- Lambda di Optional

```

---

## 6️⃣ Advanced / Power Tools

### #1 Java Reflection

```bash
- Class
- Field
- Method
- Parameter
- Constructor
- Super Class
- Interface
- Modifier
- Package
- Annotation
- Enum
- Primitive Type
- Array
- Parameterized Type
- Proxy
- Record

```

### #2 Java Record

```bash
- Record
- Property
- Constructor
- Method
- Equals Hash Code dan ToString
- Inheritance
- Static
- Generic
- Annotation
- Reflection
- Record Patterns

```

### #3 Java Sealed Class

```bash
- Sealed Class
- Non Sealed Class
- Sealed Interface
- Record
- Reflection

```

### #4 Java Lombok

```bash
- Getter dan Setter
- Constructor
- ToString
- Equals dan HashCode
- Data
- Builder
- Non Null
- Value
- With
- Cleanup
- Sneaky Throws
- Log
- Synchronized
- Experimental Feature

```

---

## 7️⃣ Frameworks & Ecosystem

### #1 Java Apache Maven

```bash
- Pengenalan Build Automation
- Menginstall Apache Maven
- Membuat Project
- Struktur Project
- Maven Lifecycle
- Build Project
- Dependency
- Maven Properties
- Membuat Distribution File
- Multi Module Project
- Dependency Management

```

### #2 Java Database

```bash
- Pengenalan JDBC
- Membuat Project
- Driver
- Connection
- DataSource
- Statement
- ResultSet
- SQL Injection
- PreparedStatement
- Batch Process
- Auto Increment
- Date, Time dan Timestamp
- Database Transaction
- Repository Pattern
- Materi yang Tidak Dibahas

```

### #3 Java Unit Test

```bash
- Pengenalan Software Testing
- Pengenalan JUnit
- Membuat Test
- Menggunakan Assertions
- Mengubah Nama Test
- Menonaktifkan Test
- Sebelum dan Setelah Test
- Membatalkan Test
- Menggunakan Assumptions
- Test Berdasarkan Kondisi
- Menggunakan Tag
- Urutan Eksekusi Test
- Siklus Hidup Test
- Test di dalam Test
- Informasi Test
- Dependency Injection di Test
- Pewarisan di Test
- Test Berulang
- Test dengan Parameter
- Timeout di Test
- Eksekusi Test Secara Paralel
- Pengenalan Mocking
- Mocking di Test
- Verifikasi di Mocking

```

### #4 Java Resilience4J

```bash
- Retry
- Retry Config
- Retry Registry
- Rate Limiter
- Rate Limiter Config
- Rate Limiter Registry
- Bulkhead
- Bulkhead Config
- Bulkhead Registry
- Time Limiter
- Time Limiter Config
- Time Limiter Registry
- Circuit Breaker
- Circuit Breaker Config
- Circuit Breaker Registry
- Decorators
- Fallback
- Metric
- Event Publisher
- Event Publisher di Registry
- Integrasi Library Lain

```

---
