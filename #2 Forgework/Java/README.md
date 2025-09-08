# Java Programming Language

![1739685631211](https://fossbytes.com/wp-content/uploads/2017/09/Why-is-Java-the-best-programming-Language.png)

Java adalah bahasa pemrograman yang dapat dijalankan di berbagai komputer termasuk telepon genggam. Bahasa ini awalnya dibuat oleh James Gosling saat masih bergabung di Sun Microsystems, yang saat ini merupakan bagian dari Oracle dan dirilis tahun 1995. Bahasa ini banyak mengadopsi sintaksis yang terdapat pada C dan C++ namun dengan sintaksis model objek yang lebih sederhana serta dukungan rutin-rutin aras bawah yang minimal. Aplikasi-aplikasi berbasis Java umumnya dikompilasi ke dalam p-code (bytecode) dan dapat dijalankan pada berbagai Mesin Virtual Java (JVM).

Java merupakan bahasa pemrograman yang bersifat umum/non-spesifik (general purpose), dan secara khusus didesain untuk memanfaatkan dependensi implementasi seminimal mungkin. Karena fungsionalitasnya yang memungkinkan aplikasi Java mampu berjalan di beberapa platform sistem operasi yang berbeda, Java dikenal pula dengan slogannya, "Tulis sekali, jalankan di mana pun". Saat ini Java merupakan bahasa pemrograman yang paling populer digunakan[butuh rujukan], dan secara luas dimanfaatkan dalam pengembangan berbagai jenis perangkat lunak.

Oracle (dan yang lainnya) sangat merekomendasikan untuk menghapus versi lawas dan tidak didukung dari Java, karena masalah keamanan yang belum terselesaikan di versi lama.[16] Oracle menyarankan para penggunanya untuk segera bertransisi ke versi yang didukung, seperti salah satu versi LTS (8, 11, 17).

### Installation

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

### Aturan dan Penamaan Sintaks di Java

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

# 0. Introduction

Java adalah bahasa pemrograman berorientasi objek yang terkenal karena portabilitas, skalabilitas, dan kemampuannya dalam pengembangan aplikasi baik untuk web, desktop, maupun mobile. Java banyak digunakan di dunia industri, khususnya untuk aplikasi enterprise besar. Untuk memulai dengan Java, Anda perlu mengetahui beberapa hal dasar yang akan memudahkan Anda untuk menjalankan kode Java dan memahami konsep dasarnya.

![1739685679731](image/README/1739685679731.png)

#### 0.1 Menjalankan Kode Java

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

#### 0.2 JVM Tunning

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

# 1. Basic

## 1.1 Data Types & Variables

### 1. Tipe Data Primitif

Tipe data ini menyimpan nilai langsung dalam memori dan tidak memiliki metode tambahan.

* `byte` → Menyimpan bilangan kecil (-128 hingga 127)
* `short` → Menyimpan bilangan lebih besar dari `byte` (-32,768 hingga 32,767)
* `int` → Menyimpan bilangan bulat lebih besar (-2,147,483,648 hingga 2,147,483,647)
* `long` → Menyimpan bilangan bulat lebih besar dari `int` (-9 quintillion hingga 9 quintillion)
* `float` → Menyimpan angka desimal dengan presisi lebih rendah (hingga 7 digit)
* `double` → Menyimpan angka desimal dengan presisi lebih tinggi (hingga 16 digit)
* `char` → Menyimpan satu karakter seperti `'A'`, `'9'`, atau `'@'`
* `boolean` → Menyimpan nilai `true` atau `false`

💡 Perbedaan `int` vs `Integer`

* `int` adalah tipe data primitif yang langsung menyimpan nilai.
* `Integer` adalah tipe data referensi (kelas `java.lang.Integer`) yang membungkus `int` dan menyediakan metode tambahan seperti `.parseInt()`, `.valueOf()`, dll.

Contoh:

```java
int angka1 = 10; // Tipe primitif
Integer angka2 = 20; // Tipe referensi
```

### 2. Tipe Data Non-Primitif

Tipe ini tidak menyimpan nilai langsung, tetapi menyimpan alamat memori dari objek yang dibuat.

* `String` → Menyimpan kumpulan karakter (`"Hello World"`)
* `Array` (`int[]`, `double[]`, dll.) → Menyimpan kumpulan nilai bertipe sama
* `Class` (misalnya `Person`) → Digunakan untuk membuat objek dengan atribut dan metode
* `Interface` → Mirip dengan class, tapi hanya mendefinisikan kontrak
* `Wrapper Class` (`Integer`, `Double`, `Boolean`, dll.) → Membungkus tipe primitif dengan fitur tambahan

💡 Perbedaan `int[]` vs `Array`

* `int[]` adalah array primitif yang hanya menyimpan nilai `int`.
* `Array` dalam bentuk `List<Integer>` (dari `java.util.ArrayList`) adalah referensi yang menyimpan objek `Integer`.

Contoh:

```java
int[] angkaPrimitif = {1, 2, 3}; // Array tipe primitif
List<Integer> angkaReferensi = new ArrayList<>(Arrays.asList(1, 2, 3)); // ArrayList tipe referensi
```

Kesimpulan


| Kategori       | Tipe Primitif                   | Tipe Referensi                                   |
| ---------------- | --------------------------------- | -------------------------------------------------- |
| Contoh         | `int`,`double`,`boolean`,`char` | `String`,`Integer`,`Double`,`Array`,`List`       |
| Penyimpanan    | Langsung di memori              | Menyimpan alamat referensi                       |
| Fitur Tambahan | Tidak ada                       | Ada metode bawaan                                |
| Performa       | Lebih cepat                     | Lebih berat karena butuh alokasi memori tambahan |

### 3. Deklarasi dan Inisialisasi Variabel

Untuk mendeklarasikan dan menginisialisasi variabel di Java, Anda perlu menentukan tipe data dan memberi nilai awal pada variabel tersebut.

```java
// Mendeklarasikan dan menginisialisasi variabel
int number = 10;          // tipe int
double pi = 3.14159;      // tipe double
String message = "Hello"; // tipe String
boolean isActive = true;  // tipe boolean
```

### 4. Konstanta

Jika Anda ingin mendeklarasikan variabel yang nilainya tidak bisa diubah setelah inisialisasi, Anda bisa menggunakan kata kunci `final` untuk membuat variabel menjadi konstanta.

```java
final double PI = 3.14159;
```

Variabel `PI` di atas tidak bisa diubah setelah diberi nilai.

## 1.2 Convert Data Types

Di Java, konversi tipe data digunakan untuk mengubah nilai dari satu tipe data ke tipe data lainnya. Ada dua jenis konversi tipe data:

1. Konversi Otomatis (Implicit Type Conversion)
2. Konversi Manual (Explicit Type Conversion)
3. Konversi Otomatis (Implicit Type Conversion)

Konversi otomatis terjadi ketika Java secara otomatis mengubah tipe data yang lebih kecil menjadi tipe data yang lebih besar. Ini biasanya dilakukan saat Anda mengoperasikan dua variabel dengan tipe data yang berbeda.

Misalnya, jika Anda mengoperasikan `int` dengan `double`, Java akan mengonversi `int` ke `double` secara otomatis.

Contoh:

```java
public class Main {
    public static void main(String[] args) {
        int a = 10;
        double b = 5.5;
  
        // Konversi otomatis: int -> double
        double result = a + b;
  
        System.out.println("Hasil: " + result);
    }
}
```

Output:

```
Hasil: 15.5
```

Penjelasan: Variabel `a` yang bertipe `int` dikonversi secara otomatis ke `double` karena variabel `b` bertipe `double`. Kemudian hasilnya disimpan dalam variabel `result` yang bertipe `double`.

2. Konversi Manual (Explicit Type Conversion)

Konversi manual, atau casting, terjadi ketika Anda secara eksplisit mengonversi nilai dari tipe data yang lebih besar ke tipe data yang lebih kecil. Hal ini sering dilakukan dengan menggunakan tanda kurung di depan tipe data yang diinginkan.

Contoh:

```java
public class Main {
    public static void main(String[] args) {
        double a = 9.99;
        // Konversi manual: double -> int
        int b = (int) a;
  
        System.out.println("Nilai a: " + a);
        System.out.println("Nilai b setelah konversi: " + b);
    }
}
```

Output:

```
Nilai a: 9.99
Nilai b setelah konversi: 9
```

Penjelasan: Variabel `a` yang bertipe `double` dikonversi secara manual ke `int` menggunakan casting `(int)`, yang membuang bagian desimalnya.

3. Konversi Antar Tipe Data Primitif

Berikut adalah beberapa contoh konversi antar tipe data primitif di Java:

a. Konversi antara `byte`, `short`, `int`, `long`

* `byte` ke `short`, `int`, atau `long` (dalam konversi ini tidak ada kehilangan data karena tipe data yang lebih besar).
* `int` ke `long` (dilakukan secara otomatis).

b. Konversi antara `float`, `double`

* `float` dapat dikonversi ke `double` secara otomatis (karena `double` memiliki presisi lebih besar).
* `double` ke `float` memerlukan casting manual karena ada kemungkinan kehilangan presisi.

c. Konversi antara `char` dan `int`

* Anda dapat mengonversi `char` ke `int`, karena `char` di Java adalah representasi angka Unicode.
* `int` ke `char` memerlukan casting manual.

Contoh:

```java
public class Main {
    public static void main(String[] args) {
        // byte -> int (konversi otomatis)
        byte b = 10;
        int i = b;
  
        // int -> byte (casting manual)
        int x = 300;
        byte y = (byte) x;
  
        // char -> int
        char c = 'A';
        int code = c;
  
        // int -> char
        int z = 65;
        char ch = (char) z;
  
        System.out.println("byte to int: " + i);
        System.out.println("int to byte: " + y);
        System.out.println("char to int: " + code);
        System.out.println("int to char: " + ch);
    }
}
```

Output:

```
byte to int: 10
int to byte: 44
char to int: 65
int to char: A
```

4. Konversi String ke Tipe Data Lain

Anda dapat mengonversi `String` ke tipe data lain dengan menggunakan metode parsing seperti `Integer.parseInt()`, `Double.parseDouble()`, dll.

Contoh:

```java
public class Main {
    public static void main(String[] args) {
        String str = "123";
        int number = Integer.parseInt(str); // String ke int
        System.out.println("Nilai integer: " + number);

        String strDouble = "3.14";
        double d = Double.parseDouble(strDouble); // String ke double
        System.out.println("Nilai double: " + d);
    }
}
```

Output:

```
Nilai integer: 123
Nilai double: 3.14
```

5. Konversi Tipe Data Wrapper ke Primitif

Java menyediakan *wrapper classes* untuk tipe data primitif, seperti `Integer`, `Double`, `Character`, dll. Anda dapat mengonversi objek wrapper ke tipe data primitif menggunakan metode `xxxValue()`, misalnya `intValue()`, `doubleValue()`, dll.

Contoh:

```java
public class Main {
    public static void main(String[] args) {
        Integer i = 100;
        int x = i.intValue(); // Integer ke int
  
        Double d = 10.5;
        double y = d.doubleValue(); // Double ke double
  
        System.out.println("Integer ke int: " + x);
        System.out.println("Double ke double: " + y);
    }
}
```

Output:

```
Integer ke int: 100
Double ke double: 10.5
```

## 1.3 Data Structures

1. Array

Array adalah struktur data yang menyimpan elemen-elemen dengan tipe data yang sama dalam urutan tertentu. Array memiliki ukuran tetap dan indeks yang digunakan untuk mengakses elemen-elemen di dalamnya.

* Contoh :

```java
  int[] arr = {1, 2, 3, 4};
  System.out.println(arr[0]); // Output: 1
```

2. List

List adalah struktur data yang menyimpan elemen-elemen secara berurutan. Berbeda dengan array, List memiliki ukuran dinamis yang dapat berubah-ubah.

* Tipe List:
  * ArrayList : Menyediakan akses cepat dan lebih efisien dalam penambahan elemen di akhir list.
  * LinkedList : Menyimpan elemen dalam bentuk node yang terhubung satu sama lain, sehingga lebih efisien saat melakukan penambahan atau penghapusan elemen di tengah list.
* Contoh :

```java
  List<Integer> list = new ArrayList<>();
  list.add(1);
  list.add(2);
  System.out.println(list.get(0)); // Output: 1
```

* Deklarasi Langsung:

```java
List<String> cars = List.of("Toyota", "BMW", "Audi");

for (int i = 0; i < cars.size(); i++) {
    System.out.println(cars.get(i));
}
```

* Deklarasi + Immutable

```java
List<String> cars = new ArrayList<>(List.of("Toyota", "BMW", "Audi"));

cars.add(cars.size(), "Nissan");
cars.add(cars.size(), "Subaru");
```

4. Set

Set adalah struktur data yang menyimpan elemen-elemen unik, tanpa urutan tertentu (tidak ada duplikasi elemen). Tipe data ini lebih cepat dalam pengecekan keberadaan elemen.

* Tipe Set:
  * HashSet : Tidak mempertahankan urutan elemen, menggunakan hashing untuk penyimpanan.
  * TreeSet : Menyimpan elemen-elemen secara terurut (sorted).
* Contoh :

```java
  Set<Integer> set = new HashSet<>();
  set.add(1);
  set.add(2);
  set.add(1); // Tidak akan ada duplikasi
  System.out.println(set); // Output: [1, 2]
```

4. Map

Map adalah struktur data yang menyimpan pasangan key-value (kunci-nilai). Map memungkinkan kita untuk mengakses elemen berdasarkan kunci unik.

* Tipe Map:
  * HashMap : Menggunakan hashing untuk penyimpanan dan tidak mempertahankan urutan elemen.
  * TreeMap : Menyimpan elemen-elemen berdasarkan urutan kunci.
* Contoh :

```java
  Map<String, Integer> map = new HashMap<>();
  map.put("apple", 3);
  map.put("banana", 5);
  System.out.println(map.get("apple")); // Output: 3
```

5. Queue

Queue adalah struktur data yang menyimpan elemen secara urut sesuai dengan prinsip  First In First Out (FIFO) . Elemen pertama yang masuk akan menjadi elemen pertama yang keluar.

* Tipe Queue:
  * LinkedList : Dapat digunakan sebagai Queue dengan metode `add()`, `remove()`, dan `peek()`.
  * PriorityQueue : Elemen-elemen disusun berdasarkan prioritas tertentu.
* Contoh :

```java
  Queue<Integer> queue = new LinkedList<>();
  queue.add(1);
  queue.add(2);
  System.out.println(queue.poll()); // Output: 1
```

6. Stack

Stack adalah struktur data yang menyimpan elemen sesuai dengan prinsip  Last In First Out (LIFO) . Elemen yang terakhir dimasukkan adalah elemen pertama yang keluar.

* Contoh :

```java
  Stack<Integer> stack = new Stack<>();
  stack.push(1);
  stack.push(2);
  System.out.println(stack.pop()); // Output: 2
```

7. Deque (Double Ended Queue)

Deque adalah struktur data yang memungkinkan penambahan atau penghapusan elemen di kedua ujungnya (depan dan belakang). Ini adalah kombinasi dari Stack dan Queue.

* Tipe Deque:
  * ArrayDeque : Implementasi Deque menggunakan array.
  * LinkedList : Dapat digunakan sebagai Deque.
* Contoh :

```java
  Deque<Integer> deque = new ArrayDeque<>();
  deque.addFirst(1);
  deque.addLast(2);
  System.out.println(deque.pollFirst()); // Output: 1
```

8. Priority Queue

Priority Queue adalah struktur data yang menyimpan elemen-elemen berdasarkan prioritas tertentu, bukan berdasarkan urutan inputnya. Elemen dengan prioritas tertinggi akan keluar terlebih dahulu.

* Contoh :

```java
  PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
  pq.add(5);
  pq.add(2);
  pq.add(8);
  System.out.println(pq.poll()); // Output: 8 (prioritas tertinggi)
```

9. LinkedList

LinkedList adalah struktur data yang terdiri dari serangkaian elemen yang terhubung, di mana setiap elemen menyimpan referensi ke elemen berikutnya dan sebelumnya (untuk LinkedList dua arah).

* Contoh :

```java
  LinkedList<Integer> linkedList = new LinkedList<>();
  linkedList.add(1);
  linkedList.add(2);
  System.out.println(linkedList.get(0)); // Output: 1
```

10. Tree

Tree adalah struktur data hierarkis yang terdiri dari simpul (node) yang terhubung. Setiap node dapat memiliki lebih dari satu anak. Salah satu jenis tree yang umum digunakan adalah  Binary Search Tree (BST) .

* Contoh :
* Binary Tree : Setiap node memiliki maksimal dua anak (left dan right).
* AVL Tree : Variasi dari BST dengan aturan keseimbangan.

11. Trie

Trie (atau Prefix Tree) adalah struktur data yang digunakan untuk menyimpan sekumpulan string. Trie sangat efisien dalam pencarian awalan atau prefix dari string.

* Contoh : Digunakan dalam aplikasi pencarian teks atau autocomplete.

## 1.4 Controls Flow

* If statement :

```java
  if (x > 10) {
      System.out.println("x is greater than 10");
  }
```

* If-else statement :

```java
  if (x > 10) {
      System.out.println("x is greater than 10");
  } else {
      System.out.println("x is less than or equal to 10");
  }
```

* Else-if ladder :

```java
  if (x > 10) {
      System.out.println("x is greater than 10");
  } else if (x == 10) {
      System.out.println("x is equal to 10");
  } else {
      System.out.println("x is less than 10");
  }
```

* Switch statement :

```java
  switch (day) {
      case 1:
          System.out.println("Monday");
          break;
      case 2:
          System.out.println("Tuesday");
          break;
      default:
          System.out.println("Invalid day");
  }
```

* For loop :

```java
  for (int i = 0; i < 5; i++) {
      System.out.println(i);
  }
```

* Enhanced for loop (foreach) :

```java
  String[] cars = {"Toyota", "BMW", "Audi"};
  for (String car : cars) {
      System.out.println(car);
  }
```

* While loop :

```java
  while (x < 10) {
      System.out.println(x);
      x++;
  }
```

* Do-while loop :

```java
  do {
      System.out.println(x);
      x++;
  } while (x < 10);
```

* Break statement :

```java
  for (int i = 0; i < 10; i++) {
      if (i == 5) {
          break;
      }
      System.out.println(i);
  }
```

* Continue statement :

```java
  for (int i = 0; i < 10; i++) {
      if (i == 5) {
          continue;
      }
      System.out.println(i);
  }
```

* Return statement :

```java
  public int sum(int a, int b) {
      return a + b;
  }
```

* Throw statement :

```java
  throw new IllegalArgumentException("Invalid argument");
```

* Try-catch block :

```java
  try {
      int result = 10 / 0;
  } catch (ArithmeticException e) {
      System.out.println("Error: " + e.getMessage());
  }
```

## 1.5 Null Safety

Di Java, null safety merujuk pada praktik penghindaran atau penanganan nilai `null` untuk menghindari NullPointerException yang sering terjadi jika kita mencoba mengakses metode atau properti pada objek yang bernilai `null`. Berikut adalah beberapa cara untuk menangani null safety di Java:

1. Null Checks :
   Menambahkan pemeriksaan `null` sebelum mengakses objek atau memanggil metode.

```java
   String name = null;
   if (name != null) {
       System.out.println(name.length());
   } else {
       System.out.println("Name is null");
   }
```

1. Optional (Java 8+) :
   `Optional` adalah kelas yang digunakan untuk menyatakan bahwa nilai bisa ada (non-null) atau tidak ada (null).

```java
   Optional<String> optionalName = Optional.ofNullable(name);
   optionalName.ifPresent(n -> System.out.println(n.length()));
```

1. Null Object Pattern :
   Pola ini menggunakan objek yang tidak bernilai `null` namun memiliki implementasi standar untuk menghindari pengecekan `null`.

```java
   interface Vehicle {
       void start();
   }

   class NullVehicle implements Vehicle {
       @Override
       public void start() {
           System.out.println("No vehicle to start");
       }
   }

   Vehicle vehicle = new NullVehicle();
   vehicle.start(); // No vehicle to start
```

1. Java Annotations (Nullability Annotations) :
   Beberapa framework atau pustaka (misalnya, `@NotNull`, `@Nullable`) digunakan untuk memberikan petunjuk kepada pengembang mengenai apakah sebuah parameter atau nilai bisa `null` atau tidak.

```java
   @NotNull
   public String greet(String name) {
       return "Hello " + name;
   }
```

1. Using `Objects.requireNonNull()` :
   Ini digunakan untuk memeriksa apakah objek yang diteruskan adalah `null`. Jika `null`, akan melemparkan `NullPointerException`.

```java
   String name = null;
   Objects.requireNonNull(name, "Name cannot be null");
```

1. Using `@NonNull` and `@Nullable` annotations (with tools like Checker Framework) :
   Anotasi ini membantu mencegah nilai `null` yang tidak diinginkan, serta meningkatkan kesadaran pengembang tentang potensi kesalahan terkait `null`.

```java
   public void greet(@NonNull String name) {
       System.out.println("Hello " + name);
   }
```

1. Default Values :
   Menggunakan nilai default saat nilai yang seharusnya dikembalikan mungkin `null`.

```java
   String name = getName();
   String displayName = (name == null) ? "Unknown" : name;
   System.out.println(displayName);
```

## 1.6 Input-Output

Di Java, input/output (I/O) digunakan untuk membaca data dari sumber eksternal (seperti file atau keyboard) dan menulis data ke tempat tujuan (seperti file atau layar). Java menyediakan berbagai cara untuk melakukan I/O menggunakan kelas-kelas di dalam paket `java.io` dan `java.nio` (untuk I/O yang lebih modern). Berikut adalah beberapa contoh dasar untuk input dan output di Java:

1. Input dari Keyboard (Console)

Untuk mengambil input dari pengguna melalui konsol, kita dapat menggunakan kelas `Scanner`.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input

        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();  // Membaca satu baris input string

        System.out.println("Halo, " + name);
    }
}
```

2. Output ke Console

Untuk menampilkan output ke konsol, kita bisa menggunakan `System.out.println()` atau `System.out.print()`.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Ini adalah output dengan baris baru.");
        System.out.print("Ini adalah output tanpa baris baru.");
    }
}
```

3. Input/Output Menggunakan `BufferedReader` dan `InputStreamReader`

Ini adalah alternatif yang lebih efisien untuk membaca input menggunakan stream.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukkan nama: ");
            String name = reader.readLine();  // Membaca input dari pengguna
            System.out.println("Halo, " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

4. Input/Output ke File

Java memungkinkan kita untuk membaca dan menulis data ke file menggunakan berbagai kelas di `java.io`. Berikut adalah cara menulis dan membaca file menggunakan `FileWriter` dan `BufferedReader`.

Menulis ke File:

```java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Hello, this is a test file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Membaca dari File:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

5. File I/O dengan `Files` API (Java 7 ke atas)

Java 7 memperkenalkan `java.nio.file.Files` untuk operasi file yang lebih sederhana dan lebih fleksibel.

Menulis ke File menggunakan `Files`:

```java
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("output.txt");
            String content = "Hello, NIO File API!";
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Membaca dari File menggunakan `Files`:

```java
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("output.txt");
            String content = new String(Files.readAllBytes(path));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

6. Binary I/O

Jika kita bekerja dengan data biner (misalnya gambar atau file audio), kita bisa menggunakan `FileInputStream` dan `FileOutputStream`.

Menulis Data Biner ke File:

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.bin")) {
            byte[] data = { 1, 2, 3, 4, 5 };
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Membaca Data Biner dari File:

```java
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("output.bin")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print(data + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

7. Standard Output dan Error

Selain `System.out`, kita juga bisa menggunakan `System.err` untuk menulis pesan kesalahan.

```java
public class Main {
    public static void main(String[] args) {
        System.err.println("This is an error message.");
    }
}
```

# 2. Object-Oriented Programming

### 1. Object

Objek adalah instance dari kelas. Setiap objek memiliki keadaan (properties/fields) dan perilaku (metode) yang ditentukan oleh kelasnya.

```java
public class Car {
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", 2020);
        car.displayInfo();
    }
}
```

### 2. Class

Kelas adalah blueprint atau template untuk membuat objek. Kelas mendefinisikan properti dan metode yang dimiliki oleh objek.

```java
public class Car {
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
}
```

### 3. Property & Method

Properti adalah variabel dalam sebuah kelas.

```java
public class Car {
    String model;  // property
    int year;      // property

    // Method
    public void startEngine() {
        System.out.println(model + " engine started.");
    }
}
```

Di Java, method adalah fungsi yang didefinisikan dalam sebuah kelas dan merupakan bagian dari  Object-Oriented Programming (OOP) . Walaupun Java tidak mendukung functional programming secara langsung seperti bahasa pemrograman fungsional (misalnya, Haskell atau Scala), Java tetap memungkinkan penggunaan konsep fungsi dalam bentuk method dalam kelas.

Apa Itu Method di Java?

Method adalah sebuah blok kode yang menerima input (parameter) dan dapat mengembalikan output (nilai). Method didefinisikan dalam sebuah kelas dan digunakan untuk mengoperasikan data yang ada di dalam objek kelas tersebut.

Sebuah method bisa dianggap sebagai implementasi dari sebuah fungsi dalam pemrograman berbasis objek, yang bekerja pada data yang dimiliki oleh objek tersebut.

Main Method

`main` adalah metode utama dalam aplikasi Java, yang menjadi titik masuk pertama kali program dijalankan.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

Struktur Dasar Method di Java

Berikut adalah struktur dasar dari sebuah method di Java:

```java
return_type method_name(parameters) {
    // body of the method
    // Optional: return some value of return_type
}
```

* return_type : Jenis data yang dikembalikan oleh method. Jika method tidak mengembalikan nilai, maka menggunakan `void`.
* method_name : Nama dari method.
* parameters : Parameter yang diterima oleh method. Ini adalah nilai yang digunakan di dalam method untuk melakukan operasi tertentu.

Contoh Penggunaan Method di Java

Berikut adalah contoh sederhana dari method yang menerima parameter dan mengembalikan hasil.

```java
public class Calculator {

    // Method tanpa parameter dan mengembalikan nilai
    public static int add(int a, int b) {
        return a + b;
    }

    // Method tanpa return value
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        // Memanggil method add
        int result = add(5, 10);
        System.out.println("Hasil penjumlahan: " + result);

        // Memanggil method displayMessage
        displayMessage("Hello, Java!");
    }
}
```

Penjelasan:

* Method `add(int a, int b)` : Ini adalah method dengan dua parameter (`a` dan `b`), yang mengembalikan hasil penjumlahan dari kedua parameter tersebut.
* Method `displayMessage(String message)` : Ini adalah method yang hanya mencetak pesan ke layar dan tidak mengembalikan nilai, sehingga menggunakan `void` sebagai tipe kembalian.

Fungsi dan Cara Kerja Method di Java

1. Fungsi Sebagai Pengorganisasian Kode :

* Method memungkinkan Anda untuk mengorganisasi kode menjadi bagian-bagian yang lebih kecil. Ini meningkatkan keterbacaan dan memudahkan pemeliharaan kode.
* Anda bisa menggunakan method untuk menghindari pengulangan kode (reusability), yaitu dengan mendefinisikan logika yang sama dalam satu tempat dan memanggilnya di berbagai tempat di program.

1. Parameter dan Argument :

* Method dapat menerima  parameter , yang merupakan nilai input yang dibutuhkan oleh method untuk melakukan operasi. Parameter ini bisa berupa tipe data primitif atau objek.
* Argument adalah nilai yang diberikan pada saat memanggil method. Nilai ini akan digunakan sebagai input di dalam method.

  Contoh:

```java
   public void greet(String name) {
       System.out.println("Hello, " + name);
   }

   public static void main(String[] args) {
       greet("John");  // "John" adalah argument yang diberikan pada parameter name
   }
```

1. Return Value :

* Method dapat mengembalikan nilai yang bisa digunakan oleh kode lain setelah method dijalankan. Jika method bertipe `void`, maka method tersebut tidak mengembalikan nilai.
* Method yang memiliki return type harus menggunakan perintah `return` untuk mengembalikan nilai tersebut.

  Contoh:

```java
   public int multiply(int a, int b) {
       return a * b;
   }
```

1. Method Overloading :

* Java mendukung  method overloading , yaitu kemampuan untuk mendefinisikan beberapa method dengan nama yang sama tetapi dengan parameter yang berbeda.
* Ini memungkinkan Anda untuk memanggil method dengan cara yang berbeda tergantung pada jenis dan jumlah argumen yang diberikan.

  Contoh:

```java
   public int add(int a, int b) {
       return a + b;
   }

   public double add(double a, double b) {
       return a + b;
   }
```

1. Method Overriding :

* Overriding adalah konsep di mana subclass (kelas turunan) dapat memberikan implementasi baru untuk method yang sudah ada di superclass (kelas induk).
* Ini digunakan untuk memodifikasi perilaku dari method yang diwarisi dari kelas induk.

  Contoh:

```java
   class Animal {
       public void sound() {
           System.out.println("Animal makes a sound");
       }
   }

   class Dog extends Animal {
       @Override
       public void sound() {
           System.out.println("Dog barks");
       }
   }

   public static void main(String[] args) {
       Animal animal = new Dog();
       animal.sound();  // Output: Dog barks
   }
```

1. Method dengan Parameter Default :

* Java tidak mendukung parameter default langsung, namun Anda bisa menggunakan method overloading untuk mensimulasikan parameter default.

  Contoh:

```java
   public void greet(String name, String greeting) {
       System.out.println(greeting + ", " + name);
   }

   public void greet(String name) {
       greet(name, "Hello");
   }
```

1. Static Method :

* Method yang dideklarasikan dengan kata kunci `static` adalah milik kelas, bukan objek.
* Static method dapat dipanggil tanpa membuat instance objek dari kelas tersebut.

  Contoh:

```java
   public class MathUtils {
       public static int square(int x) {
           return x * x;
       }
   }

   public static void main(String[] args) {
       int result = MathUtils.square(4);  // Memanggil static method tanpa objek
       System.out.println(result);
   }
```

1. Method yang Mengubah State Objek (Mutator) dan Membaca State Objek (Accessor) :

* Mutator method mengubah state objek, seperti setter.
* Accessor method membaca state objek, seperti getter.

  Contoh:

```java
   class Person {
       private String name;
   
       // Setter method
       public void setName(String name) {
           this.name = name;
       }

       // Getter method
       public String getName() {
           return this.name;
       }
   }
```

### 4. Access Modifiers

Access modifier digunakan untuk mengatur visibilitas dari properti dan metode dalam sebuah kelas. Ada empat access modifiers di Java: `public`, `private`, `protected`, dan `default`.

```java
public class Car {
    public String model;  // Accessible from anywhere
    private int year;     // Accessible only within this class

    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
}
```

### 5. Package

Di Java, package adalah mekanisme untuk mengorganisasi kode agar lebih terstruktur dan modular. Package memungkinkan pengelompokan kelas, interface, dan sub-package ke dalam direktori tertentu, sehingga kode lebih mudah dipahami dan dikelola. Selain itu, package membantu dalam menghindari konflik nama antara kelas yang berbeda, terutama dalam proyek besar dengan banyak pengembang.

Meskipun Java tidak memiliki namespace seperti di C# atau C++, konsep package di Java menawarkan cara untuk menciptakan ruang lingkup khusus untuk kelas dan interface. Dengan package, kita dapat memberikan nama yang unik untuk setiap kelas, sehingga konflik nama dapat diminimalkan.

> Nama package adalah nama direktori dimana file java berada

1. Deklarasi Package

```java
package vehicle; 

public class Car {
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
}
```

2. Nesting Package

Java tidak mendukung nested namespace, tetapi kita bisa menggunakan sub-paket untuk tujuan serupa.

```java
package vehicle.sedan;

public class Sedan {
    String model;
    int year;

    public Sedan(String model, int year) {
        this.model = model;
        this.year = year;
    }
}
```

Manfaat Package

1. Menghindari Konflik Nama:
   Package memberikan ruang lingkup untuk nama-nama kelas dan interface. Jika dua kelas memiliki nama yang sama, tetapi berada di package yang berbeda, keduanya dapat digunakan dalam proyek yang sama.
   * ```java
     import java.util.Date;
     import java.sql.Date;

     public class Example {
         public static void main(String[] args) {
             java.util.Date utilDate = new java.util.Date();
             java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

             System.out.println("Util Date: " + utilDate);
             System.out.println("SQL Date: " + sqlDate);
         }
     }
     ```
2. Organisasi Kode:
   Dengan package, kita dapat mengelompokkan kode berdasarkan fungsionalitas, seperti  model ,  service ,  repository , dll. Ini membuat kode lebih terstruktur dan mempermudah pengelolaan.
3. Keamanan:
   Package bekerja bersama access modifiers (seperti `public`, `protected`, `private`, dan default) untuk membatasi akses ke kelas dan anggota kelas tertentu.
4. Modularitas:
   Package memungkinkan proyek besar dibagi menjadi bagian-bagian kecil yang lebih mudah dikelola.
5. Pemeliharaan dan Skalabilitas:
   Struktur package yang baik mempermudah penambahan fitur baru atau perbaikan tanpa mengganggu bagian lain dari proyek.

---

Standar Membuat Package

1. Deklarasi Package:
   Setiap file Java dapat dimasukkan ke dalam package tertentu dengan menambahkan pernyataan `package` di awal file.

   ```java
   package com.example.myapp;

   public class MyClass {
       public void display() {
           System.out.println("Hello from MyClass!");
       }
   }
   ```
2. Menyimpan File:
   File yang dideklarasikan dalam package tertentu harus disimpan di dalam direktori yang sesuai dengan nama package.
   Jika package adalah `com.example.myapp`, maka file harus disimpan di dalam direktori:

   ```
   com/
     example/
       myapp/
         MyClass.java
   ```
3. Mengimpor Package:
   Untuk menggunakan kelas dari package lain, kita dapat menggunakan kata kunci `import`.

   ```java
   import com.example.myapp.MyClass;

   public class Main {
       public static void main(String[] args) {
           MyClass myClass = new MyClass();
           myClass.display();
       }
   }
   ```
4. Tanpa Import:
   Sebagai alternatif, kita juga bisa menggunakan nama lengkap kelas (Fully Qualified Name) tanpa menggunakan `import`.

   ```java
   public class Main {
       public static void main(String[] args) {
           com.example.myapp.MyClass myClass = new com.example.myapp.MyClass();
           myClass.display();
       }
   }
   ```

---

Struktur Package

Struktur package mencerminkan struktur direktori pada sistem file. Misalnya, jika Anda memiliki package `com.example.project`, maka struktur file harus terlihat seperti ini:

```
src/
└── com/
    └── example/
        └── project/
            ├── Main.java
            ├── Service.java
            └── User.java
```

---

### 6. Enkapsulasi (Encapsulation)

Enkapsulasi adalah prinsip OOP di mana data atau variabel dalam kelas hanya dapat diakses atau dimodifikasi melalui metode getter dan setter.

```java
public class Car {
    private String model;
    private int year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
```

### 7. Constructor

Konstruktor digunakan untuk menginisialisasi objek ketika objek dibuat.

```java
public class Car {
    String model;
    int year;

    // Constructor
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
}
```

### 8. Inheritance

Inheritance memungkinkan kita membuat kelas baru dengan mewarisi properti dan metode dari kelas yang ada.

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {
    void stop() {
        System.out.println("Car stopped");
    }
}
```

### 9. Abstract Class & Abstract Method

Kelas abstrak adalah kelas yang tidak bisa diinstansiasi, dan dapat memiliki metode abstrak (tanpa implementasi).

```java
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }
}
```

### 10. Interface & Multiple Interface

Antarmuka (interface) adalah kontrak yang mendefinisikan metode tanpa implementasi. Sebuah kelas dapat mengimplementasikan lebih dari satu antarmuka.

```java
interface Drivable {
    void drive();
}

interface Serviceable {
    void service();
}

class Car implements Drivable, Serviceable {
    public void drive() {
        System.out.println("Car is driving");
    }

    public void service() {
        System.out.println("Car is being serviced");
    }
}
```

### 11. Enumerated Types

Enumerasi adalah tipe data khusus yang mendefinisikan variabel yang hanya dapat memiliki satu nilai dari sejumlah nilai tetap.

```java
enum CarType {
    SEDAN, SUV, TRUCK
}

public class Main {
    public static void main(String[] args) {
        CarType car = CarType.SUV;
        System.out.println(car);
    }
}
```

### 12. Lambda

Lambda Expressions dalam Java diperkenalkan pada Java 8 sebagai fitur utama untuk mendukung pemrograman fungsional. Lambda expressions memungkinkan Anda menulis kode yang lebih singkat dan elegan, terutama saat bekerja dengan antarmuka fungsional atau operasi pada koleksi.

---

Apa itu Lambda Expression?

Lambda expression adalah cara untuk merepresentasikan sebuah fungsi anonim (fungsi tanpa nama) yang dapat diteruskan sebagai parameter atau digunakan di tempat.

Sintaks Lambda Expression:

```java
(parameters) -> expression
```

atau

```java
(parameters) -> { statements; }
```

---

Contoh Lambda Expression

1. Contoh Dasar:
   Sebelum Lambda:

   ```java
   Runnable runnable = new Runnable() {
       @Override
       public void run() {
           System.out.println("Running using Runnable");
       }
   };
   new Thread(runnable).start();
   ```

   Dengan Lambda:

   ```java
   Runnable runnable = () -> System.out.println("Running using Lambda");
   new Thread(runnable).start();
   ```
2. Dengan Parameter:

   ```java
   (int a, int b) -> a + b
   ```

   * Parameter `a` dan `b` adalah input untuk lambda.
   * `a + b` adalah ekspresi yang menghasilkan output.
3. Lambda dengan Koleksi:
   Sebelum Lambda:

   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   for (String name : names) {
       System.out.println(name);
   }
   ```

   Dengan Lambda:

   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   names.forEach(name -> System.out.println(name));
   ```

---

Kapan Menggunakan Lambda Expressions?

Lambda expressions terutama digunakan ketika bekerja dengan antarmuka fungsional seperti `Runnable`, `Comparator`, `Predicate`, atau API `Stream`.

Antarmuka Fungsional

Antarmuka fungsional adalah antarmuka yang hanya memiliki satu metode abstrak (method tanpa implementasi).

Contoh antarmuka fungsional:

```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
```

Menggunakan Lambda:

```java
Greeting greeting = (name) -> System.out.println("Hello, " + name);
greeting.sayHello("Alice");
```

---

Contoh Praktis Lambda dalam Java

1. Menggunakan Comparator:
   Sebelum Lambda:

   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   Collections.sort(names, new Comparator<String>() {
       @Override
       public int compare(String o1, String o2) {
           return o1.compareTo(o2);
       }
   });
   ```

   Dengan Lambda:

   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
   ```
2. Menggunakan Stream API:
   Sebelum Lambda:

   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   for (String name : names) {
       if (name.startsWith("A")) {
           System.out.println(name);
       }
   }
   ```

   Dengan Lambda:

   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   names.stream()
       .filter(name -> name.startsWith("A"))
       .forEach(System.out::println);
   ```
3. Runnable:
   Sebelum Lambda:

   ```java
   new Thread(new Runnable() {
       @Override
       public void run() {
           System.out.println("Running!");
       }
   }).start();
   ```

   Dengan Lambda:

   ```java
   new Thread(() -> System.out.println("Running!")).start();
   ```

---

Keuntungan Lambda Expression

1. Kode Lebih Ringkas:
   Lambda expressions mengurangi boilerplate code, membuat kode lebih singkat dan mudah dibaca.
2. Fungsionalitas yang Ditingkatkan:
   Memungkinkan penulisan kode fungsional yang sangat efisien, terutama saat bekerja dengan koleksi atau operasi aliran data (Stream API).
3. Fleksibel:
   Lambda dapat digunakan di mana saja antarmuka fungsional dibutuhkan.

---

Batasan Lambda Expression

1. Hanya untuk Antarmuka Fungsional:
   Lambda hanya dapat digunakan dengan antarmuka yang memiliki satu metode abstrak.
2. Kurang Familiar untuk Pemula:
   Bagi yang baru belajar Java, sintaks Lambda bisa terlihat kompleks.
3. Debugging Bisa Lebih Sulit:
   Saat ada kesalahan dalam lambda, menemukan akar masalah kadang lebih sulit dibandingkan metode konvensional.

### 13. Base Keyword

`super` digunakan untuk mengakses anggota kelas induk.

```java
class Vehicle {
    String model = "Vehicle Model";

    void display() {
        System.out.println("Model: " + model);
    }
}

class Car extends Vehicle {
    String model = "Car Model";

    void show() {
        System.out.println("Car model: " + model);
        System.out.println("Base model: " + super.model);
    }
}
```

### 14. Polymorphism

Polimorfisme memungkinkan kita menggunakan metode yang sama dengan cara yang berbeda.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();  // Polymorphism
    }
}
```

### 15. Static

Anggota statis milik kelas dan bukan objek. Static digunakan untuk variabel dan metode yang tidak bergantung pada objek kelas.

```java
public class Car {
    static int wheels = 4;  // Static variable

    static void displayWheels() {  // Static method
        System.out.println("Wheels: " + wheels);
    }

    public static void main(String[] args) {
        Car.displayWheels();  // Static method called directly from class
    }
}
```

### 16. Metadata

Metadata adalah informasi yang berhubungan dengan data program. Java menyediakan anotasi untuk mendeklarasikan metadata.

```java
@interface MyAnnotation {
    String value();
}

@MyAnnotation(value = "This is a custom annotation")
class Car {
    String model;
}
```

---

# 3. Error Handling

Exception Handling di Java

Exception Handling di Java adalah mekanisme untuk menangani kesalahan (errors) yang terjadi selama eksekusi program. Saat terjadi kesalahan atau masalah, Java melemparkan exception (pengecualian) yang dapat ditangani untuk mencegah program berhenti secara tidak terduga.

Konsep Dasar

* Exception adalah objek yang menyatakan adanya masalah dalam program.
* Error adalah jenis masalah yang biasanya tidak dapat ditangani oleh program, seperti masalah memori yang habis.
* Throwable adalah superclass dari semua objek yang dapat dilemparkan dalam Java, yang meliputi Exception dan  Error .

Struktur Exception Handling di Java

Java menggunakan try-catch untuk menangani exception. Struktur dasarnya adalah sebagai berikut:

```java
try {
    // Kode yang mungkin menyebabkan exception
} catch (ExceptionType1 e1) {
    // Menangani ExceptionType1
} catch (ExceptionType2 e2) {
    // Menangani ExceptionType2
} finally {
    // Kode yang selalu dijalankan, baik terjadi exception atau tidak
}
```

* try block : Di sini Anda menempatkan kode yang mungkin menyebabkan exception.
* catch block : Menangani exception yang dilemparkan oleh kode di dalam `try`.
* finally block : Blok ini dijalankan setelah `try` dan `catch`, terlepas dari apakah terjadi exception atau tidak. Biasanya digunakan untuk menutup sumber daya seperti file atau koneksi jaringan.

Jenis-Jenis Exception

1. Checked Exceptions :

* Exception yang harus ditangani, baik dengan `try-catch` atau dengan `throws` di deklarasi method. Contoh: `IOException`, `SQLException`.
* Biasanya berkaitan dengan situasi yang dapat diprediksi, seperti membaca file atau menghubungi database.

1. Unchecked Exceptions :

* Exception yang tidak perlu ditangani secara eksplisit. Ini adalah subclass dari `RuntimeException`. Contoh: `NullPointerException`, `ArrayIndexOutOfBoundsException`.
* Biasanya berkaitan dengan kesalahan logika dalam kode, yang sering kali dapat dihindari.

1. Errors :

* Merupakan masalah yang tidak dapat diatasi oleh program, seperti kesalahan sistem atau kehabisan memori. Contoh: `OutOfMemoryError`, `StackOverflowError`.

Contoh Exception Handling di Java

Contoh 1: Menangani Exception dengan `try-catch`

```java
public class Main {
    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            arr[5] = 10;  // Ini akan menyebabkan ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception terjadi: " + e);
        }
        System.out.println("Program tetap berjalan setelah exception.");
    }
}
```

Penjelasan :

* Kode mencoba mengakses elemen array yang tidak ada (indeks di luar batas).
* `catch` menangkap dan menangani exception yang terjadi (dalam hal ini `ArrayIndexOutOfBoundsException`).
* Program tetap berjalan setelah exception ditangani.

Contoh 2: Menggunakan `finally`

```java
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Kode di dalam try block.");
        } catch (Exception e) {
            System.out.println("Exception terjadi.");
        } finally {
            System.out.println("Kode di dalam finally block, selalu dijalankan.");
        }
    }
}
```

Penjelasan :

* Kode dalam `finally` akan selalu dieksekusi, baik ada exception maupun tidak.
* Biasanya digunakan untuk membersihkan sumber daya (seperti menutup file, database connection).

Contoh 3: Menggunakan Multiple `catch` Blocks

```java
public class Main {
    public static void main(String[] args) {
        try {
            int num = 10 / 0;  // Ini akan menyebabkan ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Kesalahan: " + e);
        } catch (Exception e) {
            System.out.println("Kesalahan umum: " + e);
        }
    }
}
```

Penjelasan :

* Jika terjadi `ArithmeticException`, blok pertama akan menangkapnya.
* Jika exception lainnya terjadi, blok `catch` kedua akan menangkapnya.

Contoh 4: `throws` untuk Melemparkan Exception ke Method Pemanggil

```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            readFile("file.txt");
        } catch (IOException e) {
            System.out.println("Terjadi masalah dengan file: " + e);
        }
    }

    public static void readFile(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader fileInput = new BufferedReader(file);
        throw new IOException("File tidak ditemukan");
    }
}
```

Penjelasan :

* Method `readFile` melemparkan exception `IOException`.
* Method `main` harus menangani exception ini menggunakan `try-catch`, karena method `readFile` menggunakan kata kunci `throws`.

Custom Exception di Java

Java memungkinkan Anda untuk membuat custom exception dengan membuat subclass dari `Exception` atau `RuntimeException`.

```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            throw new CustomException("Ini adalah custom exception");
        } catch (CustomException e) {
            System.out.println("Custom exception terjadi: " + e.getMessage());
        }
    }
}
```

Penjelasan :

* `CustomException` adalah kelas exception yang Anda buat sendiri.
* `throw` digunakan untuk melemparkan exception kustom ini.

# 4. Concurrency & Parallel Programming

Konkurensi (Concurrency) dan Parallel Programming adalah dua konsep yang sering dikaitkan dengan pemrograman yang melibatkan pelaksanaan beberapa tugas secara bersamaan. Meskipun mereka terdengar mirip, keduanya memiliki perbedaan yang signifikan dalam cara mereka menangani tugas-tugas tersebut.

1. Konkurensi (Concurrency)

Konkurensi adalah kemampuan untuk menangani beberapa tugas dalam waktu yang sama, tetapi tidak selalu secara bersamaan. Ini lebih tentang mengelola banyak tugas secara simultan dengan cara menggilir waktu CPU di antara tugas-tugas tersebut. Meskipun hanya ada satu core CPU, program yang kompeten dalam konkurensi akan mengelola beberapa tugas dalam cara yang membuatnya tampak seperti mereka berjalan secara bersamaan.

Di Java, konkurensi biasanya dicapai dengan menggunakan thread dan  executor services .

2. Parallel Programming

Parallel Programming adalah jenis pemrograman yang benar-benar menjalankan beberapa tugas secara bersamaan, yaitu pada beberapa core atau  beberapa CPU . Dalam parallel programming, tugas-tugas tersebut dapat dijalankan secara fisik simultan, dan ini sering kali meningkatkan kinerja program untuk tugas yang dapat diparalelkan.

### A. Threads Biasa (Legacy)

Thread klasik yang menggunakan `Thread` atau `Runnable` untuk menjalankan tugas dalam thread terpisah.

```java
public class ContohThread extends Thread {
    public void run() {
        System.out.println("Thread berjalan: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ContohThread t1 = new ContohThread();
        t1.start(); // Menjalankan thread baru
    }
}
```

> Kekurangan: Membuat dan mengelola thread ini mahal karena tiap thread memiliki stack memory sendiri.

### B. Executor Framework (Thread Pool)

Menggunakan `ExecutorService` untuk mengelola pool thread yang bisa digunakan kembali.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContohExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " dijalankan oleh " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // Menutup executor setelah semua tugas selesai
    }
}
```

> Kelebihan: Lebih efisien dibanding thread biasa karena menggunakan kembali thread yang ada.

### C. ForkJoinPool (Untuk Paralelisme)

Digunakan untuk tugas yang dapat dipecah menjadi sub-tugas (`divide and conquer`).

```java
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ContohForkJoin extends RecursiveTask<Integer> {
    private final int n;

    public ContohForkJoin(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) return n;
        ContohForkJoin task1 = new ContohForkJoin(n - 1);
        task1.fork(); // Memproses di thread lain
        return new ContohForkJoin(n - 2).compute() + task1.join();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new ContohForkJoin(10));
        System.out.println("Hasil: " + result);
    }
}
```

> Kelebihan: Memanfaatkan paralelisme dengan membagi tugas secara rekursif.

### D. Parallel Stream

Digunakan untuk memproses koleksi secara paralel.

```java
import java.util.List;

public class ContohParallelStream {
    public static void main(String[] args) {
        List<Integer> angka = List.of(1, 2, 3, 4, 5);

        angka.parallelStream()
            .forEach(num -> System.out.println(num + " di thread " + Thread.currentThread().getName()));
    }
}
```

> Kelebihan: Mudah digunakan tanpa harus mengelola thread secara manual.

### E. CompletableFuture (Asynchronous)

Digunakan untuk menjalankan tugas secara async dan menangani hasilnya nanti.

```java
import java.util.concurrent.CompletableFuture;

public class ContohCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Halo, Async!")
            .thenApply(str -> str + " dari CompletableFuture")
            .thenAccept(System.out::println);

        // Tunggu sejenak agar tidak langsung selesai
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
```

> Kelebihan: Menyediakan cara yang lebih elegan untuk menangani operasi async dibandingkan callback biasa.

### F. Virtual Threads (Java 21) - Konkurensi Ringan

Virtual Threads adalah fitur baru di Java 21 yang memungkinkan pembuatan jutaan thread secara efisien.

```java
public class ContohVirtualThread {
    public static void main(String[] args) {
        Thread.startVirtualThread(() -> {
            System.out.println("Virtual Thread berjalan: " + Thread.currentThread().getName());
        });
    }
}
```

> Kelebihan: Virtual Threads sangat ringan dibandingkan thread OS, cocok untuk aplikasi web atau layanan berskala besar.

Kapan Menggunakan Apa?


| Kebutuhan                       | Gunakan                    |
| --------------------------------- | ---------------------------- |
| Multi-thread sederhana          | `Thread` atau `Runnable`   |
| Pengelolaan thread otomatis     | `ExecutorService`          |
| Tugas rekursif atau paralelisme | `ForkJoinPool`             |
| Proses koleksi secara paralel   | `ParallelStream`           |
| Operasi async (I/O bound)       | `CompletableFuture`        |
| Konkurensi ringan               | `Virtual Threads`(Java 21) |

# 5. Standard Classes

Java Standard Class mengacu pada kelas bawaan (built-in) yang tersedia di Java  Standard Library (Java API) . Kelas-kelas ini mencakup berbagai fungsionalitas umum seperti manipulasi string, koleksi, input/output, jaringan, konkurensi, dan lain-lain.

Kategori Java Standard Class

Berikut adalah beberapa kategori utama kelas standar di Java:

1. Kelas Dasar (java.lang)

Paket `java.lang` otomatis diimpor dalam setiap program Java.


| Kelas                            | Deskripsi                                                              |
| ---------------------------------- | ------------------------------------------------------------------------ |
| `Object`                         | Superclass dari semua kelas di Java.                                   |
| `String`                         | Immutable class untuk representasi teks.                               |
| `StringBuilder`/`StringBuffer`   | Mutable string untuk manipulasi teks yang efisien.                     |
| `Math`                           | Operasi matematika seperti`sqrt()`,`pow()`,`random()`.                 |
| `Integer`,`Double`,`Float`, dll. | Wrapper class untuk tipe primitif.                                     |
| `System`                         | Berisi metode`System.out.println()`,`System.currentTimeMillis()`, dll. |
| `Thread`                         | Untuk pembuatan thread secara manual.                                  |

Contoh penggunaan `String` dan `Math`:

```java
public class JavaStandardClass {
    public static void main(String[] args) {
        String text = "Hello, Java!";
        System.out.println(text.toUpperCase()); // HELLO, JAVA!

        double result = Math.sqrt(25);
        System.out.println(result); // 5.0
    }
}
```

2. Koleksi dan Struktur Data (java.util)

Paket `java.util` menyediakan berbagai kelas untuk manipulasi data.


| Kelas         | Deskripsi                                                    |
| --------------- | -------------------------------------------------------------- |
| `ArrayList`   | List dinamis yang bisa bertambah ukurannya.                  |
| `LinkedList`  | Implementasi list berbasis linked list.                      |
| `HashMap`     | Struktur data berbasis key-value.                            |
| `HashSet`     | Kumpulan elemen unik, tidak terurut.                         |
| `Collections` | Kelas utilitas untuk operasi koleksi (`sort()`,`shuffle()`). |
| `Arrays`      | Operasi pada array (`Arrays.sort()`,`Arrays.asList()`).      |

Contoh penggunaan `ArrayList` dan `HashMap`:

```java
import java.util.ArrayList;
import java.util.HashMap;

public class CollectionExample {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        System.out.println(list); // [Java, Python]

        // HashMap
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        System.out.println(ages.get("Alice")); // 25
    }
}
```

3. Input/Output (java.io, java.nio)

Paket `java.io` dan `java.nio` digunakan untuk operasi file, stream, dan jaringan.


| Kelas                                | Deskripsi                               |
| -------------------------------------- | ----------------------------------------- |
| `File`                               | Untuk manipulasi file.                  |
| `BufferedReader`/`BufferedWriter`    | Membaca/menulis file dengan buffer.     |
| `FileInputStream`/`FileOutputStream` | Membaca/menulis file dalam bentuk byte. |
| `Scanner`                            | Membaca input dari pengguna atau file.  |
| `Path`(java.nio.file)                | Manipulasi path file/folder modern.     |

Contoh membaca file dengan `BufferedReader`:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
```

4. Konkurensi & Multithreading (java.util.concurrent)

Paket `java.util.concurrent` menyediakan kelas untuk pemrograman konkurensi.


| Kelas                               | Deskripsi                       |
| ------------------------------------- | --------------------------------- |
| `ThreadPoolExecutor`                | Mengelola kumpulan thread.      |
| `Executors`                         | Membantu pembuatan thread pool. |
| `CompletableFuture`                 | Operasi async yang fleksibel.   |
| `Semaphore`,`Lock`,`CountDownLatch` | Sinkronisasi thread.            |

Contoh penggunaan `ExecutorService`:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> System.out.println("Task 1"));
        executor.submit(() -> System.out.println("Task 2"));

        executor.shutdown();
    }
}
```

5. Jaringan (java.net)

Paket `java.net` memungkinkan komunikasi jaringan.


| Kelas               | Deskripsi                 |
| --------------------- | --------------------------- |
| `URL`               | Mengambil data dari URL.  |
| `Socket`            | Komunikasi client-server. |
| `HttpURLConnection` | Mengirim HTTP request.    |

Contoh request HTTP dengan `HttpURLConnection`:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
```

6. Date & Time (java.time)

Paket `java.time` digunakan untuk manipulasi tanggal dan waktu.


| Kelas           | Deskripsi                         |
| ----------------- | ----------------------------------- |
| `LocalDate`     | Representasi tanggal tanpa waktu. |
| `LocalTime`     | Representasi waktu tanpa tanggal. |
| `LocalDateTime` | Gabungan tanggal dan waktu.       |
| `ZonedDateTime` | Waktu dengan zona waktu.          |
| `Duration`      | Selisih antara dua waktu.         |

Contoh penggunaan `LocalDateTime`:

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Waktu sekarang: " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted: " + now.format(formatter));
    }
}
```

Kesimpulan

Java menyediakan berbagai Standard Class dalam paket  java.lang, java.util, java.io, java.net, java.time , dan lainnya untuk mempermudah pengembangan aplikasi.

* Manipulasi teks & angka → `String`, `Math`
* Struktur data → `ArrayList`, `HashMap`
* File & I/O → `File`, `BufferedReader`
* Konkurensi → `ExecutorService`, `CompletableFuture`
* Jaringan → `URL`, `HttpURLConnection`
* Tanggal & waktu → `LocalDateTime`

# 6. Generic

Generic di Java

Generic adalah fitur di Java yang memungkinkan kita membuat kelas, antarmuka (interface), dan metode yang parameterizabel. Generic memberikan kemampuan untuk bekerja dengan tipe data yang berbeda tanpa perlu menduplikasi kode. Dengan menggunakan Generic, kita dapat memastikan type safety di waktu kompilasi, sehingga mengurangi kemungkinan error di runtime.

Keuntungan Generic:

1. Type Safety: Kesalahan tipe data dapat dicegah pada waktu kompilasi.
2. Code Reusability: Generic memungkinkan kita menulis kode yang dapat digunakan dengan berbagai tipe data.
3. Eliminasi Casting: Tidak perlu melakukan casting eksplisit.
4. Peningkatan Readability dan Maintenability: Kode lebih bersih dan mudah dipahami.

Contoh Penggunaan Generic

1. Generic Class

```java
// Generic class dengan parameter T
public class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// Menggunakan Generic class
public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setValue(123);
        System.out.println("Integer value: " + intBox.getValue());

        Box<String> strBox = new Box<>();
        strBox.setValue("Hello, Generics!");
        System.out.println("String value: " + strBox.getValue());
    }
}
```

2. Generic Method

```java
public class GenericMethodExample {
    // Generic method dengan parameter T
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C", "D"};

        System.out.print("Integer Array: ");
        printArray(intArray);

        System.out.print("String Array: ");
        printArray(strArray);
    }
}
```

3. Bounded Type Parameters

```java
// Membatasi tipe parameter menggunakan `extends`
public class GenericBound<T extends Number> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// Menggunakan kelas dengan bounded type
public class Main {
    public static void main(String[] args) {
        GenericBound<Integer> intBox = new GenericBound<>();
        intBox.setValue(10);
        System.out.println("Value: " + intBox.getValue());

        // GenericBound<String> strBox = new GenericBound<>(); // Error karena String bukan subclass dari Number
    }
}
```

4. Wildcards in Generics

* Unbounded Wildcard (`?`) : Mengizinkan semua tipe.
* Upper Bounded Wildcard (`? extends T`) : Membatasi tipe untuk subclass dari `T`.
* Lower Bounded Wildcard (`? super T`) : Membatasi tipe untuk superclass dari `T`.

Contoh:

```java
import java.util.List;

public class WildcardExample {
    // Unbounded wildcard
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // Upper bounded wildcard
    public static void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        List<String> strList = List.of("A", "B", "C");

        System.out.print("Integer List: ");
        printList(intList); // Unbounded wildcard

        System.out.print("String List: ");
        printList(strList);

        System.out.print("Numbers: ");
        printNumbers(intList); // Upper bounded wildcard
    }
}
```

5. Generic Interface

```java
// Generic Interface
public interface GenericInterface<T> {
    void display(T value);
}

// Implementing the interface
public class GenericClass<T> implements GenericInterface<T> {
    @Override
    public void display(T value) {
        System.out.println("Value: " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<String> stringClass = new GenericClass<>();
        stringClass.display("Hello");

        GenericClass<Integer> intClass = new GenericClass<>();
        intClass.display(123);
    }
}
```

# 7. Java Collection

Java Collection Framework (`java.util`) menyediakan struktur data yang dinamis, efisien, dan siap pakai untuk menyimpan dan memanipulasi data.

## 1. Hirarki Java Collections

Interface Utama dalam Collections

* `Collection<E>` → Induk dari semua struktur koleksi.
  * `List<E>` → Koleksi  berurutan , bisa duplikat.
  * `Set<E>` → Koleksi  unik , tanpa urutan pasti.
  * `Queue<E>` → Koleksi FIFO (First-In-First-Out).
* `Map<K, V>` → Struktur  key-value , tanpa turunan dari `Collection` langsung.

## 2. List (Menyimpan Data Berurutan & Bisa Duplikat)

List memiliki indeks (`0-based`) dan mendukung elemen duplikat.


| Implementasi | Ciri Khas                                            |
| -------------- | ------------------------------------------------------ |
| `ArrayList`  | List berbasis array, cepat untuk akses indeks.       |
| `LinkedList` | List berbasis linked list, efisien untuk penyisipan. |
| `Vector`     | Mirip`ArrayList`, tapi thread-safe .                 |

Contoh Penggunaan `ArrayList` dan `LinkedList`

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Menggunakan ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);

        // Menggunakan LinkedList
        List<String> linkedList = new LinkedList<>(arrayList);
        linkedList.addFirst("Mango");
        System.out.println("LinkedList: " + linkedList);
    }
}
```

## 3. Set (Menyimpan Data Unik & Tanpa Duplikat)

Set tidak mengizinkan duplikat dan tidak memiliki indeks.


| Implementasi    | Ciri Khas                           |
| ----------------- | ------------------------------------- |
| `HashSet`       | Tidak terurut, berbasishash table . |
| `LinkedHashSet` | Mempertahankanurutan penambahan .   |
| `TreeSet`       | Terurutsecara alami(ascending).     |

Contoh Penggunaan `HashSet` dan `TreeSet`

```java
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // HashSet (Tidak berurutan)
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Cherry");
        hashSet.add("Banana"); // Tidak akan ditambahkan (duplikat)
        System.out.println("HashSet: " + hashSet);

        // TreeSet (Terurut secara alami)
        Set<String> treeSet = new TreeSet<>(hashSet);
        System.out.println("TreeSet: " + treeSet);
    }
}
```

## 4. Map (Penyimpanan Key-Value)

Map menyimpan pasangan kunci-nilai (`key-value`),  key harus unik .


| Implementasi    | Ciri Khas                              |
| ----------------- | ---------------------------------------- |
| `HashMap`       | Tidak terurut, berbasishash table .    |
| `LinkedHashMap` | Mempertahankanurutan penambahan .      |
| `TreeMap`       | Terurut berdasarkankunci (ascending) . |

Contoh Penggunaan `HashMap` dan `TreeMap`

```java
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        // HashMap (Tidak berurutan)
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(2, "Banana");
        hashMap.put(1, "Apple");
        hashMap.put(3, "Cherry");
        System.out.println("HashMap: " + hashMap);

        // TreeMap (Terurut berdasarkan key)
        Map<Integer, String> treeMap = new TreeMap<>(hashMap);
        System.out.println("TreeMap: " + treeMap);
    }
}
```

## 5. Queue (Antrian FIFO - First In First Out)

Queue digunakan untuk  struktur antrean .


| Implementasi    | Ciri Khas                                  |
| ----------------- | -------------------------------------------- |
| `PriorityQueue` | Antrian denganprioritasberdasarkan elemen. |
| `ArrayDeque`    | Implementasidouble-ended queue (Deque) .   |

Contoh Penggunaan `PriorityQueue`

```java
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(15);
  
        System.out.println(priorityQueue.poll()); // 5 (karena prioritas rendah duluan keluar)
        System.out.println(priorityQueue.poll()); // 10
    }
}
```

## 6. Collections Utility (`java.util.Collections`)

Kelas `Collections` menyediakan metode utilitas untuk  mengelola koleksi .


| Metode                      | Kegunaan                |
| ----------------------------- | ------------------------- |
| `Collections.sort(list)`    | Mengurutkan list.       |
| `Collections.reverse(list)` | Membalik urutan list.   |
| `Collections.shuffle(list)` | Mengacak elemen list.   |
| `Collections.max(set)`      | Mencari nilai maksimum. |

Contoh `Collections.sort()` dan `Collections.shuffle()`

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
  
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers); // [1, 2, 3]
  
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);
    }
}
```

Kesimpulan


| Struktur | Kegunaan                  | Implementasi                 |
| ---------- | --------------------------- | ------------------------------ |
| List     | Berurutan, bisa duplikat  | `ArrayList`,`LinkedList`     |
| Set      | Unik, tanpa indeks        | `HashSet`,`TreeSet`          |
| Map      | Key-Value, key unik       | `HashMap`,`TreeMap`          |
| Queue    | FIFO (First-In-First-Out) | `PriorityQueue`,`ArrayDeque` |

# 8. Package Management

Java Package Manager adalah alat yang membantu developer mengelola  dependencies , library, dan framework ketika membangun aplikasi Java. Package manager ini mengotomatisasi proses seperti mengunduh, menginstal, memperbarui, dan mengelola library pihak ketiga, sehingga mempermudah pengelolaan proyek Java secara efisien.

Kenapa Harus Menggunakan Package Manager?

1. Manajemen Dependency yang Mudah:
   Tidak perlu lagi mengunduh file JAR secara manual dan mengatur classpath secara manual.
2. Kontrol Versi:
   Menjamin versi library yang digunakan kompatibel dan menghindari konflik dependency.
3. Repositori Terpusat:
   Memungkinkan akses ke ribuan library Java di repositori seperti Maven Central atau JitPack.
4. Otomatisasi:
   Secara otomatis mengelola transitive dependencies (library yang dibutuhkan oleh library lain).

Java Package Manager Populer

1. Maven

* Website: [Maven](https://maven.apache.org/)
* Maven adalah tool otomatisasi build dan manajemen dependency yang paling banyak digunakan untuk proyek Java.

Fitur Utama:

* Menggunakan file konfigurasi XML (`pom.xml`).
* Memiliki repositori Maven Central.
* Mendukung proses build, testing, dan packaging aplikasi.

Contoh: `pom.xml`

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>2.6.0</version>
    </dependency>
</dependencies>
```

Perintah:

```bash
mvn clean install
```

2. Gradle

* Website: [Gradle](https://gradle.org/)
* Gradle adalah build tool modern yang fleksibel dan mendukung berbagai bahasa pemrograman termasuk Java.

Fitur Utama:

* Menggunakan DSL berbasis Groovy atau Kotlin (`build.gradle` atau `build.gradle.kts`).
* Proses build lebih cepat menggunakan incremental compilation dan caching.
* Cocok untuk proyek besar yang kompleks.

Contoh: `build.gradle`

```groovy
plugins {
    id 'java'
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web:2.6.0'
}
```

Perintah:

```bash
gradle build
```

3. Ivy

* Website: [Ivy](https://ant.apache.org/ivy/)
* Ivy adalah dependency manager yang terintegrasi dengan Apache Ant.

Fitur Utama:

* Memberikan kemampuan dependency management pada Ant.
* Menggunakan file konfigurasi XML.

Contoh: `ivy.xml`

```xml
<dependencies>
    <dependency org="org.springframework.boot" name="spring-boot-starter-web" rev="2.6.0" />
</dependencies>
```

4. JitPack

* Website: [JitPack](https://jitpack.io/)
* JitPack memungkinkan penggunaan proyek GitHub sebagai dependency tanpa harus mempublikasikannya ke repositori seperti Maven Central.

Fitur Utama:

* Mendukung tag Git, branch, dan commit untuk versi library.
* Mudah digunakan untuk proyek open-source di GitHub.

Contoh: Menambahkan Dependency dari GitHub
Di `build.gradle`:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.User:Repo:Tag'
}
```

5. SBT (Scala Build Tool)

* Website: [SBT](https://www.scala-sbt.org/)
* Meskipun utamanya digunakan untuk Scala, SBT juga mendukung proyek Java.

Fitur Utama:

* Resolusi dependency melalui Maven atau Ivy.
* Build process yang sangat customizable.

Struktur Repositori

Semua package manager ini menggunakan repositori online untuk menyimpan dan mengambil dependency, seperti:

* Maven Central: Repositori default untuk Maven.
* JCenter: Digunakan oleh Gradle (sebelum ditutup pada 2022).
* JitPack: Mengambil dependency langsung dari GitHub.

Repositori ini memungkinkan developer untuk mencari, mengunduh, dan mengelola dependency mereka dengan lebih mudah dan terstruktur.

# 9. Java Lambda

Lambda expression di Java digunakan untuk menulis kode lebih ringkas dan mendukung paradigma  functional programming . Lambda memungkinkan kita mendefinisikan fungsi tanpa harus membuat kelas atau metode eksplisit.

1. Sintaks Lambda Expression

```java
(parameters) -> { expression/body }
```

Contoh Dasar

```java
// Lambda tanpa parameter
() -> System.out.println("Hello Lambda");

// Lambda dengan satu parameter
x -> x * x;

// Lambda dengan dua parameter
(x, y) -> x + y;
```

2. Lambda dalam Functional Interface

Lambda hanya bisa digunakan dalam Functional Interface (interface dengan  satu metode abstrak ).

Contoh dengan `Runnable`

```java
public class LambdaRunnable {
    public static void main(String[] args) {
        // Sebelum Lambda (Anonymous Class)
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running with Anonymous Class");
            }
        };

        // Dengan Lambda
        Runnable r2 = () -> System.out.println("Running with Lambda");

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
```

3. Lambda dengan `FunctionalInterface` Custom

```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Lambda untuk penjumlahan
        MathOperation add = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;

        System.out.println("Addition: " + add.operate(5, 3)); // 8
        System.out.println("Multiplication: " + multiply.operate(5, 3)); // 15
    }
}
```

4. Lambda dengan Java Collections

Lambda sering digunakan dalam operasi  stream, sorting, dan filtering .

Sorting dengan Lambda

```java
import java.util.*;

public class LambdaSorting {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Banana", "Apple", "Cherry");

        // Sorting tanpa Lambda
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        // Sorting dengan Lambda
        names.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println(names);
    }
}
```

5. Lambda dengan `Streams`

Lambda sering digunakan dengan Stream API untuk filtering, mapping, dan reducing data.

Filtering dengan Stream API

```java
import java.util.Arrays;
import java.util.List;

public class StreamLambda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 8, 9, 12);

        // Filter angka genap dengan Lambda
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);  // Output: 2, 4, 8, 12
    }
}
```

Kesimpulan


| Konsep                | Deskripsi                                                                       |
| ----------------------- | --------------------------------------------------------------------------------- |
| Lambda                | Ekspresi ringkas untuk fungsi anonim.                                           |
| Functional Interface  | Interface dengan satu metode abstrak yang bisa diimplementasikan dengan Lambda. |
| Sorting dengan Lambda | Mempermudah sorting di`Collections.sort()`.                                     |
| Streams & Lambda      | Digunakan untuk filtering, mapping, dan reducing data.                          |

# 10. Java Streams

Java Stream API diperkenalkan di Java 8 untuk memudahkan pemrosesan koleksi data secara deklaratif (mirip functional programming). Stream memungkinkan operasi seperti  filtering, mapping, sorting, reducing , dan banyak lagi dengan kode yang lebih ringkas.

## 1. Konsep Dasar Java Stream

* Stream ≠ Data Structure → Stream hanya membantu mengolah data, tidak menyimpan data.
* Tidak Mengubah Data Asli → Stream bekerja secara  immutable .
* Operasi Berantai → Stream dapat digabungkan dengan beberapa operasi.
* Lazy Evaluation → Eksekusi hanya terjadi saat diperlukan.

## 2. Cara Membuat Stream di Java

Sebelum menggunakan  Stream API , kita harus membuat Stream terlebih dahulu. Ada beberapa cara untuk membuatnya:

1.1 Dari List atau Collection

```java
import java.util.List;
import java.util.stream.Stream;

public class StreamFromList {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        Stream<String> stream = names.stream(); // Membuat Stream dari List

        stream.forEach(System.out::println);
    }
}
```

1.2 Dari Array

```java
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromArray {
    public static void main(String[] args) {
        String[] array = {"Apple", "Banana", "Cherry"};

        Stream<String> stream = Arrays.stream(array);

        stream.forEach(System.out::println);
    }
}
```

1.3 Dari `Stream.of()`

```java
import java.util.stream.Stream;

public class StreamOfExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        stream.forEach(System.out::println);
    }
}
```

1.4 Dari `Stream.iterate()` (Tak Terbatas)

```java
import java.util.stream.Stream;

public class StreamIterateExample {
    public static void main(String[] args) {
        Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 2); // Angka ganjil

        infiniteStream.limit(5).forEach(System.out::println);
    }
}
```

Output:

```
1  
3  
5  
7  
9  
```

1.5 Dari `Stream.generate()` (Tak Terbatas)

```java
import java.util.Random;
import java.util.stream.Stream;

public class StreamGenerateExample {
    public static void main(String[] args) {
        Stream<Double> randomStream = Stream.generate(Math::random);

        randomStream.limit(3).forEach(System.out::println);
    }
}
```

## Intermediate Operations (Transformasi Stream)

Intermediate operations mengembalikan Stream baru dan bisa dirantai ( chaining ).


| Method                            | Deskripsi                                        |
| ----------------------------------- | -------------------------------------------------- |
| `filter(Predicate<T>)`            | Memfilter elemen yang memenuhi kondisi.          |
| `map(Function<T, R>)`             | Mengubah elemen menjadi bentuk lain.             |
| `flatMap(Function<T, Stream<R>>)` | Meratakan elemen yang merupakan List atau Array. |
| `sorted()`                        | Mengurutkan elemen berdasarkan`Comparable`.      |
| `sorted(Comparator<T>)`           | Mengurutkan dengan aturan khusus.                |
| `distinct()`                      | Menghapus elemen duplikat.                       |
| `limit(n)`                        | Mengambil`n`elemen pertama.                      |
| `skip(n)`                         | Melewati`n`elemen pertama.                       |
| `peek(Consumer<T>)`               | Debugging tanpa mengubah elemen.                 |

Contoh `filter()`

```java
import java.util.List;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        numbers.stream()
               .filter(n -> n % 2 == 0)  // Ambil angka genap
               .forEach(System.out::println);
    }
}
```

Contoh `map()`

```java
import java.util.List;

public class StreamMapExample {
    public static void main(String[] args) {
        List<String> names = List.of("alice", "bob", "charlie");

        names.stream()
             .map(String::toUpperCase)  // Ubah ke huruf besar
             .forEach(System.out::println);
    }
}
```

Contoh `flatMap()`

```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static void main(String[] args) {
        List<List<String>> nestedList = List.of(
            List.of("Apple", "Banana"),
            List.of("Cherry", "Date")
        );

        List<String> flatList = nestedList.stream()
                                          .flatMap(List::stream)
                                          .collect(Collectors.toList());

        System.out.println(flatList);
    }
}
```

## Terminal Operations (Eksekusi)

Terminal operations menghasilkan nilai atau efek samping dan  mengakhiri stream .


| Method                         | Deskripsi                                          |
| -------------------------------- | ---------------------------------------------------- |
| `forEach(Consumer<T>)`         | Menjalankan aksi untuk setiap elemen.              |
| `collect(Collectors.toList())` | Mengubah Stream ke List.                           |
| `count()`                      | Menghitung jumlah elemen.                          |
| `findFirst()`                  | Mengambil elemen pertama.                          |
| `findAny()`                    | Mengambil elemen acak.                             |
| `allMatch(Predicate<T>)`       | Cek apakah semua elemen memenuhi kondisi.          |
| `anyMatch(Predicate<T>)`       | Cek apakah ada elemen yang memenuhi kondisi.       |
| `noneMatch(Predicate<T>)`      | Cek apakah tidak ada elemen yang memenuhi kondisi. |
| `reduce(BinaryOperator<T>)`    | Menggabungkan elemen menjadi satu nilai.           |
| `min(Comparator<T>)`           | Mengambil elemen dengan nilai minimum.             |
| `max(Comparator<T>)`           | Mengambil elemen dengan nilai maksimum.            |

Contoh `collect()`

```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        List<String> uppercaseNames = names.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

        System.out.println(uppercaseNames);
    }
}
```

Contoh `reduce()`

```java
import java.util.List;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                         .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
```

## Parallel Stream (Pemrosesan Paralel)

Parallel Stream memungkinkan eksekusi lebih cepat dengan  multi-threading .

```java
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.parallelStream()
               .forEach(System.out::println); // Tidak berurutan karena parallel
    }
}
```

Kesimpulan 🚀

✅ Membuat Stream → Dari List, Array, `Stream.of()`, `Stream.iterate()`, `Stream.generate()`.

✅ Intermediate Operations → `filter()`, `map()`, `flatMap()`, `sorted()`, `distinct()`, dll.

✅ Terminal Operations → `forEach()`, `collect()`, `count()`, `reduce()`, `findFirst()`, dll.

✅ Parallel Stream → Memproses data lebih cepat dengan  multi-threading .
