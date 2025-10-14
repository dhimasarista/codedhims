# ☕ Belajar Java Secara Rinci

## 1️⃣ Dasar-dasar Java

### #1 ☕ Java Dasar

#### 📖 Pengenalan Java

Java adalah bahasa pemrograman berorientasi objek yang serbaguna dan dapat berjalan di berbagai platform (cross-platform) tanpa perlu diubah. Dibuat oleh James Gosling di Sun Microsystems dan dirilis pada tahun 1995, Java dirancang dengan slogan *"Write Once, Run Anywhere"* (Tulis Sekali, Jalankan di Mana Saja).

Kode Java dikompilasi menjadi format perantara yang disebut **bytecode**. Bytecode ini kemudian dijalankan oleh **Java Virtual Machine (JVM)**, yang menerjemahkannya sesuai dengan platform perangkat keras yang digunakan. Inilah yang membuat Java portabel. Sintaksnya banyak terinspirasi dari C dan C++, tetapi dengan model objek yang lebih sederhana dan manajemen memori otomatis melalui *Garbage Collector*.

Saat ini, Java dikelola oleh Oracle dan menjadi salah satu bahasa paling populer untuk pengembangan aplikasi enterprise, aplikasi Android, sistem berskala besar, dan banyak lagi. Oracle menyarankan pengguna untuk selalu memakai versi LTS (Long-Term Support) terbaru seperti 8, 11, 17, atau 21 untuk jaminan keamanan dan dukungan.

#### 🛠️ Menginstall Java

Untuk memulai pemrograman dengan Java, Anda memerlukan:

1.  **Java Development Kit (JDK)**: Ini adalah paket perangkat lunak yang berisi compiler, JVM, dan library standar untuk mengembangkan aplikasi Java.
    *   [OpenJDK](https://openjdk.java.net/install/) (Versi open-source, gratis)
    *   [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) (Gratis untuk penggunaan pribadi dan pengembangan)
    *   [GraalVM](https://www.graalvm.org/) (JDK performa tinggi)

2.  **Code Editor atau IDE**:
    *   **IntelliJ IDEA**: IDE paling populer dan sangat direkomendasikan untuk pengembangan Java profesional.
    *   **Visual Studio Code**: Editor kode ringan dengan dukungan Java yang kuat melalui ekstensi.
    *   **Eclipse**: IDE klasik yang masih banyak digunakan untuk pengembangan Java.

#### 📜 Aturan dan Penamaan Sintaks di Java

Java bersifat **case-sensitive**, artinya huruf besar dan kecil dianggap berbeda. Mengikuti konvensi penamaan standar sangat penting agar kode mudah dibaca.

*   **Nama File**: Harus sama persis dengan nama `public class` di dalamnya dan menggunakan `PascalCase`. Contoh: `MyApplication.java`.
*   **Kelas dan Interface**: Gunakan `PascalCase`. Setiap kata diawali huruf kapital. Contoh: `CustomerService`, `FileParser`.
*   **Method dan Variabel**: Gunakan `camelCase`. Kata pertama diawali huruf kecil, kata berikutnya diawali huruf kapital. Contoh: `getUserName`, `totalAmount`.
*   **Konstanta**: Gunakan `UPPER_SNAKE_CASE`. Semua huruf kapital, dipisahkan oleh garis bawah. Contoh: `MAX_CONNECTIONS`, `DEFAULT_PORT`.

#### 👋 Program Hello World

Berikut langkah-langkah dasar untuk membuat dan menjalankan program Java pertama Anda.

1.  **Tulis Kode**:
    Buat file bernama `HelloWorld.java`. Nama file harus sama dengan nama kelasnya.

    ```java
    // Deklarasi kelas publik bernama HelloWorld
    public class HelloWorld {
        // Method utama (main) yang menjadi titik masuk program
        public static void main(String[] args) {
            // Mencetak teks ke konsol
            System.out.println("Hello, World!");
        }
    }
    ```

2.  **Kompilasi Kode**:
    Buka terminal atau command prompt, navigasikan ke direktori file, lalu kompilasi menggunakan `javac`.

    ```bash
    javac HelloWorld.java
    ```

    Jika berhasil, ini akan menghasilkan file `HelloWorld.class` yang berisi bytecode.

3.  **Jalankan Program**:
    Gunakan perintah `java` untuk menjalankan bytecode. Nama file `.class` tidak perlu ditulis.

    ```bash
    java HelloWorld
    ```

    Output `Hello, World!` akan muncul di konsol. Jika menggunakan IDE, langkah 2 dan 3 biasanya dilakukan otomatis dengan menekan tombol "Run".

#### ⚙️ JVM Tuning

JVM Tuning adalah proses menyesuaikan pengaturan Java Virtual Machine (JVM) untuk mengoptimalkan performa aplikasi, baik dari segi kecepatan, penggunaan memori, maupun latensi. Ini dilakukan dengan memberikan argumen (flags) saat menjalankan aplikasi Java.

**Contoh Penggunaan di Command Line:**

```bash
# Menjalankan aplikasi JAR dengan alokasi memori awal 512MB, maksimum 2GB, dan menggunakan G1 GC
java -Xms512m -Xmx2g -XX:+UseG1GC -jar your-application.jar
```

**Argumen Umum JVM Tuning:**

*   **Pengaturan Memori (Heap):**
    *   `-Xms<size>`: Mengatur ukuran memori awal (initial heap size). Contoh: `-Xms512m`.
    *   `-Xmx<size>`: Mengatur ukuran memori maksimum (maximum heap size). Contoh: `-Xmx2g`.
    *   `-XX:MaxMetaspaceSize=<size>`: Mengatur ukuran maksimum untuk Metaspace (area penyimpanan metadata kelas).

*   **Garbage Collector (GC):**
    *   `-XX:+UseG1GC`: Menggunakan Garbage-First Collector, ideal untuk aplikasi dengan heap besar dan memerlukan latensi rendah.
    *   `-XX:+UseZGC`: Menggunakan Z Garbage Collector, untuk heap sangat besar dengan jeda (pause) yang sangat singkat.
    *   `-XX:+UseParallelGC`: Menggunakan Parallel GC, fokus pada throughput (jumlah pekerjaan) yang tinggi.

*   **Logging dan Debugging:**
    *   `-XX:+HeapDumpOnOutOfMemoryError`: Membuat file *heap dump* saat terjadi `OutOfMemoryError` untuk analisis.
    *   `-XX:HeapDumpPath=<path>`: Menentukan lokasi penyimpanan file heap dump.
    *   `-Xlog:gc*`: Mencatat aktivitas Garbage Collector secara detail (di Java 9+).

#### 🔢 Tipe Data Primitif

Tipe data primitif adalah tipe data paling dasar yang disediakan oleh Java. Mereka menyimpan nilai langsung di dalam memori dan bukan merupakan objek.

*   **Numerik Bilangan Bulat:**
    *   `byte`: 8-bit, untuk angka kecil (-128 hingga 127).
    *   `short`: 16-bit.
    *   `int`: 32-bit, tipe data standar untuk bilangan bulat.
    *   `long`: 64-bit, untuk bilangan bulat yang sangat besar.

*   **Numerik Bilangan Desimal (Floating-Point):**
    *   `float`: 32-bit, presisi tunggal. Gunakan akhiran `f`. Contoh: `float nilai = 98.5f;`
    *   `double`: 64-bit, presisi ganda. Tipe data standar untuk desimal.

*   **Karakter:**
    *   `char`: 16-bit, untuk menyimpan satu karakter Unicode, diapit kutip tunggal. Contoh: `char grade = 'A';`

*   **Logika:**
    *   `boolean`: Hanya memiliki dua nilai, `true` atau `false`.

#### 📦 Tipe Data Bukan Primitif (Tipe Referensi)

Berbeda dengan tipe data primitif, tipe data ini adalah **objek** yang dibuat dari sebuah *class*. 

*   **Karakteristik Utama**:
    *   Menyimpan **referensi** (alamat) ke lokasi objek di memori, bukan nilai langsung.
    *   Bisa bernilai `null`, yang artinya tidak menunjuk ke objek mana pun.
    *   Memiliki *method* (perilaku) yang bisa dipanggil.
    *   Contohnya termasuk `String`, `Array`, `List`, dan semua kelas yang Anda buat sendiri.

```java
String nama = "Java"; // Objek dari kelas String
Integer angka = 100;  // Objek wrapper untuk primitif int
Object data = null;   // Variabel referensi yang tidak menunjuk ke objek
```

#### 🏷️ Variabel

Variabel adalah "wadah" di dalam memori yang digunakan untuk menyimpan sebuah nilai. Setiap variabel di Java harus dideklarasikan dengan tipe data yang spesifik sebelum digunakan.

*   **Deklarasi**: `tipeData namaVariabel = nilai;`

```java
// Mendeklarasikan variabel 'umur' dengan tipe int dan nilai 25
int umur = 25;

// Mendeklarasikan variabel 'nama' dengan tipe String
String nama = "Dhimas Arista";
```

#### 📌 Konstanta

Konstanta adalah variabel yang nilainya **tidak dapat diubah** setelah pertama kali diinisialisasi. Untuk membuatnya, gunakan kata kunci `final`. Berdasarkan konvensi, nama konstanta ditulis dengan huruf kapital semua (`UPPER_SNAKE_CASE`).

```java
// Deklarasi konstanta untuk jumlah hari dalam seminggu
final int JUMLAH_HARI = 7;

// Baris di bawah ini akan menyebabkan error kompilasi jika uncomment
// JUMLAH_HARI = 8;
```

#### ⛓️ Tipe Data Array

Array adalah struktur data yang digunakan untuk menyimpan kumpulan elemen dengan **tipe data yang sama** dalam satu variabel. Ukuran array bersifat tetap setelah dibuat.

*   Elemen diakses menggunakan **indeks** yang dimulai dari 0.

```java
// Membuat array integer dengan 3 elemen
int[] angka = {10, 20, 30};

// Membuat array string berukuran 5 (nilai awal null)
String[] nama = new String[5];
nama[0] = "Red";
nama[1] = "Horizon";

// Mengakses elemen pertama
System.out.println(angka[0]); // Output: 10
```

#### ➕ Operasi Matematika

Operasi aritmetika dasar yang didukung di Java:

```java
int a = 10;
int b = 3;

int tambah = a + b;   // 13 (Penjumlahan)
int kurang = a - b;   // 7  (Pengurangan)
int kali = a * b;     // 30 (Perkalian)
int bagi = a / b;     // 3  (Pembagian integer, hasil desimal diabaikan)
double bagiDesimal = (double) a / b; // 3.333... (Pembagian desimal)
int sisa = a % b;     // 1  (Modulo / Sisa bagi)
```

#### ⚖️ Operasi Perbandingan

Digunakan untuk membandingkan dua nilai dan menghasilkan nilai `boolean` (`true` atau `false`).

```java
int x = 5;
int y = 8;

boolean samaDengan = x == y;     // false
boolean tidakSama = x != y; // true
boolean lebihBesar = x > y; // false
boolean lebihKecil = x < y; // true
boolean lebihBesarSama = x >= y; // false
boolean lebihKecilSama = x <= y; // true
```

#### 🔀 Operasi Boolean

Digunakan untuk mengombinasikan beberapa kondisi boolean.

*   `&&` (AND): Menghasilkan `true` hanya jika kedua kondisi `true`.
*   `||` (OR): Menghasilkan `true` jika salah satu kondisi `true`.
*   `!` (NOT): Membalik nilai boolean.

```java
boolean A = true;
boolean B = false;

boolean hasilAnd = A && B;  // false
boolean hasilOr = A || B; // true
boolean hasilNot = !A;    // false
```

#### 🧱 Expression, Statement, dan Block

*   **Expression**: Bagian dari kode yang dievaluasi untuk menghasilkan sebuah nilai. Contoh: `2 + 3` (menghasilkan `5`) atau `a > b` (menghasilkan `true` atau `false`).
*   **Statement**: Satu unit perintah lengkap yang diakhiri dengan titik koma (`;`). Contoh: `int x = 10;`.
*   **Block**: Kumpulan dari nol atau lebih *statement* yang diapit oleh kurung kurawal (`{}`). Block digunakan untuk mengelompokkan logika, misalnya di dalam method, `if`, atau `for`.

#### ❓ If-Else Statement

Struktur kontrol untuk membuat keputusan. Blok kode akan dieksekusi hanya jika kondisi yang diberikan terpenuhi.

```java
int nilai = 85;

if (nilai >= 90) {
    System.out.println("Predikat A");
} else if (nilai >= 80) {
    System.out.println("Predikat B");
} else {
    System.out.println("Predikat C");
}
```

#### 🎛️ Switch Statement

Alternatif dari `if-else if` yang lebih rapi untuk percabangan dengan banyak kondisi berdasarkan satu nilai variabel. Sejak Java 14, `switch` bisa digunakan sebagai *expression*.

```java
int hari = 2;
String namaHari = switch (hari) {
    case 1 -> "Senin";
    case 2 -> "Selasa";
    case 3 -> "Rabu";
    default -> "Hari tidak valid";
};
System.out.println(namaHari); // Output: Selasa
```

#### 💡 Ternary Operator

Operator `? :` adalah versi singkat dari `if-else` yang digunakan untuk memberikan nilai pada variabel berdasarkan suatu kondisi.

*   **Format**: `kondisi ? nilaiJikaTrue : nilaiJikaFalse;`

```java
int umur = 20;
String status = (umur >= 17) ? "Dewasa" : "Anak-anak";
System.out.println(status); // Output: Dewasa
```

#### 🔄 For Loop

Digunakan untuk melakukan perulangan (iterasi) dengan jumlah yang sudah ditentukan. Terdiri dari inisialisasi, kondisi, dan *post-statement* (biasanya increment/decrement).

```java
// Perulangan dari 0 hingga 4
for (int i = 0; i < 5; i++) {
    System.out.println("Iterasi ke-" + i);
}
```

#### 🔁 While Loop

Melakukan perulangan selama kondisi yang diberikan bernilai `true`. Kondisi dicek **sebelum** blok kode dieksekusi.

```java
int i = 0;
while (i < 5) {
    System.out.println("Iterasi ke-" + i);
    i++;
}
```

#### ▶️ Do-While Loop

Sama seperti `while loop`, tetapi blok kode dieksekusi **minimal satu kali** sebelum kondisi dicek.

```java
int i = 5;
do {
    System.out.println("Iterasi ke-" + i); // Akan dieksekusi sekali
    i++;
} while (i < 5);
```

#### ⏭️ Break dan Continue

*   `break`: Menghentikan eksekusi loop secara paksa.
*   `continue`: Menghentikan iterasi saat ini dan langsung loncat ke iterasi berikutnya.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // Loop berhenti saat i = 5
    }
    if (i % 2 != 0) {
        continue; // Lewati angka ganjil
    }
    System.out.println(i); // Hanya mencetak 0, 2, 4
}
```

#### 🚶 For-Each Loop

Bentuk perulangan yang lebih sederhana untuk mengakses setiap elemen dalam array atau collection tanpa perlu menggunakan indeks.

```java
String[] namaBuah = {"Apel", "Jeruk", "Mangga"};

for (String buah : namaBuah) {
    System.out.println(buah);
}
```

#### 🔧 Method

Method (atau fungsi) adalah blok kode yang dapat dipanggil berulang kali untuk melakukan tugas tertentu. Ini membantu memecah program menjadi bagian-bagian yang lebih kecil dan terorganisir.

```java
// Mendefinisikan method tanpa nilai balik
void sapaPengguna() {
    System.out.println("Halo, selamat datang!");
}

// Memanggil method
sapaPengguna();
```

#### 📥 Method Parameter

Parameter adalah variabel yang didefinisikan di dalam method untuk menerima nilai (argumen) saat method tersebut dipanggil.

```java
// Method dengan satu parameter String
void sapa(String nama) {
    System.out.println("Halo, " + nama);
}

sapa("Dhimas"); // "Dhimas" adalah argumen
```

#### 📤 Method Return Value

Method dapat mengembalikan sebuah nilai setelah selesai dieksekusi. Tipe data nilai yang dikembalikan harus didefinisikan, dan gunakan kata kunci `return`.

```java
// Method yang mengembalikan hasil penjumlahan
int tambah(int a, int b) {
    return a + b;
}

int hasil = tambah(10, 5);
System.out.println(hasil); // Output: 15
```

#### ... Method Variable Argument (Varargs)

Fitur yang memungkinkan sebuah method menerima jumlah argumen yang bervariasi (nol atau lebih) untuk parameter terakhir. Di dalam method, varargs diperlakukan sebagai array.

```java
// Method ini bisa menerima banyak argumen integer
int hitungTotal(int... angka) {
    int sum = 0;
    for (int n : angka) {
        sum += n;
    }
    return sum;
}

System.out.println(hitungTotal(10, 20));       // Output: 30
System.out.println(hitungTotal(1, 2, 3, 4, 5)); // Output: 15
```

#### ➕ Method Overloading

Kemampuan untuk mendefinisikan beberapa method dengan **nama yang sama** di dalam kelas yang sama, asalkan **parameternya berbeda** (baik jumlah, tipe, atau urutannya).

```java
void cetak(String teks) {
    System.out.println("Teks: " + teks);
}

void cetak(int angka) {
    System.out.println("Angka: " + angka);
}

cetak("Halo"); // Memanggil method pertama
cetak(100);   // Memanggil method kedua
```

#### 🔁 Recursive Method

Method yang memanggil dirinya sendiri. Rekursi harus memiliki *base case* (kondisi berhenti) untuk mencegah perulangan tak terbatas (*infinite loop*).

```java
// Menghitung faktorial menggunakan rekursi
int faktorial(int n) {
    if (n <= 1) {
        return 1; // Base case
    } else {
        return n * faktorial(n - 1); // Recursive call
    }
}

System.out.println(faktorial(5)); // Output: 120
```

#### 🎯 Scope

Scope menentukan di mana sebuah variabel dapat diakses. Variabel yang dideklarasikan di dalam sebuah blok (`{}`) hanya dapat diakses di dalam blok tersebut (dan sub-bloknya).

```java
class Contoh {
    int x = 10; // Variabel global (field), bisa diakses di seluruh method

    void methodA() {
        int y = 5; // Variabel lokal, hanya bisa diakses di methodA
        System.out.println(x + y);
    }

    void methodB() {
        // System.out.println(y); // ERROR! y tidak dikenal di sini
        System.out.println(x);
    }
}
```

#### 💬 Komentar

Komentar adalah teks di dalam kode yang diabaikan oleh compiler. Gunakan komentar untuk memberikan penjelasan atau catatan pada kode Anda.

```java
// Ini adalah komentar satu baris

/*
  Ini adalah
  komentar beberapa baris.
*/

/**
 * Ini adalah komentar dokumentasi (JavaDoc).
 * Biasanya digunakan untuk menjelaskan fungsi kelas atau method.
 */
```

### #2 ☕ Java Object-Oriented Programming

#### 🏛️ Class

Class adalah **blueprint** atau cetakan yang mendefinisikan properti (disebut *fields* atau atribut) dan perilaku (disebut *methods*) dari sebuah objek. Class adalah konsep inti dari OOP.

```java
// Blueprint untuk objek Mobil
class Mobil {
    String warna;
    int tahun;

    void maju() {
        System.out.println("Mobil bergerak maju");
    }
}
```

#### 🚗 Object

Objek adalah **instansiasi** (wujud nyata) dari sebuah class. Jika `Mobil` adalah cetakannya, maka mobil Toyota berwarna merah adalah objeknya. Anda bisa membuat banyak objek dari satu class.

```java
// Membuat dua objek dari class Mobil
Mobil mobilSaya = new Mobil();
mobilSaya.warna = "Merah";

Mobil mobilTeman = new Mobil();
mobilTeman.warna = "Hitam";

mobilSaya.maju(); // Memanggil method dari objek mobilSaya
```

#### 📝 Field

Field adalah variabel yang dideklarasikan di dalam sebuah class. Field menyimpan data atau state dari sebuah objek. Setiap objek dari class yang sama memiliki salinan field-nya sendiri.

```java
class Lingkaran {
    double jariJari; // Field untuk menyimpan jari-jari
    final double PI = 3.14; // Field konstanta
}
```

#### 🔧 Method

Method adalah fungsi yang dideklarasikan di dalam sebuah class. Method mendefinisikan perilaku atau aksi yang bisa dilakukan oleh sebuah objek.

```java
class Kalkulator {
    // Method untuk melakukan penjumlahan
    int tambah(int a, int b) {
        return a + b;
    }
}
```

#### 🏗️ Constructor

Constructor adalah method khusus yang namanya **sama persis** dengan nama class. Method ini dipanggil secara otomatis **saat sebuah objek dibuat** (`new`). Biasanya digunakan untuk inisialisasi nilai awal field.

```java
class Mobil {
    String merk;

    // Constructor dengan satu parameter
    Mobil(String merkMobil) {
        merk = merkMobil; // Mengatur nilai field 'merk'
    }
}

Mobil mobilBaru = new Mobil("Honda"); // Constructor dipanggil di sini
System.out.println(mobilBaru.merk); // Output: Honda
```

#### ➕🏗️ Constructor Overloading

Sama seperti method overloading, sebuah class bisa memiliki beberapa constructor dengan syarat parameternya harus berbeda. Ini memberikan fleksibilitas saat membuat objek.

```java
class Mobil {
    String merk;
    int tahun;

    // Constructor 1 (tanpa parameter)
    Mobil() {
        this.merk = "Belum ada merk";
    }

    // Constructor 2 (dengan parameter)
    Mobil(String merk) {
        this.merk = merk;
    }
}
```

#### 👥 Variable Shadowing

Variable shadowing terjadi ketika variabel lokal (misalnya parameter method) memiliki nama yang sama dengan field class. Variabel lokal akan "menutupi" (shadow) field. Untuk mengatasi ini, gunakan kata kunci `this` untuk merujuk ke field class.

```java
class Contoh {
    String nama = "Class"; // Field class

    void method(String nama) { // Parameter method
        System.out.println(nama);      // Mengakses parameter: "Method"
        System.out.println(this.nama); // Mengakses field: "Class"
    }
}

new Contoh().method("Method");
```

#### 👉 `this` Keyword

`this` adalah kata kunci yang merujuk pada **objek saat ini** (objek di mana method atau constructor sedang dieksekusi). Kegunaan utamanya adalah:
1.  Mengatasi *variable shadowing*.
2.  Memanggil constructor lain dari dalam constructor (`this(...)`).

```java
class Mobil {
    String merk;

    Mobil(String merk) {
        this.merk = merk; // this.merk merujuk ke field, merk merujuk ke parameter
    }
}
```

#### 👪 Inheritance

Inheritance (pewarisan) adalah mekanisme di mana sebuah class (*subclass* atau class anak) dapat mewarisi properti (field) dan perilaku (method) dari class lain (*superclass* atau class induk). Ini mendukung reusabilitas kode. Gunakan kata kunci `extends`.

```java
class Kendaraan { // Superclass
    void bergerak() {
        System.out.println("Kendaraan bergerak");
    }
}

class Mobil extends Kendaraan { // Subclass
    // Mewarisi method bergerak()
}

Mobil m = new Mobil();
m.bergerak(); // Output: Kendaraan bergerak
```

#### 🎭 Method Overriding

Method overriding terjadi ketika *subclass* menyediakan implementasi baru untuk sebuah method yang sudah ada di *superclass*-nya. Signature method (nama, parameter, dan return type) harus sama persis. Anotasi `@Override` sangat disarankan.

```java
class Kendaraan {
    void bergerak() { System.out.println("Kendaraan bergerak"); }
}

class Mobil extends Kendaraan {
    @Override
    void bergerak() { System.out.println("Mobil melaju di jalan raya"); }
}

Mobil m = new Mobil();
m.bergerak(); // Output: Mobil melaju di jalan raya
```

#### 🦸 `super` Keyword

Kata kunci `super` digunakan di dalam *subclass* untuk mengakses anggota (field atau method) dari *superclass*-nya. Ini berguna ketika method di-override tetapi kita masih butuh fungsionalitas aslinya.

```java
class Kendaraan {
    String getInfo() { return "Ini adalah kendaraan"; }
}

class Mobil extends Kendaraan {
    @Override
    String getInfo() {
        return super.getInfo() + ", jenis mobil."; // Memanggil method induk
    }
}
```

#### 🦸🏗️ `super` Constructor

Dari dalam constructor *subclass*, kita bisa memanggil constructor *superclass* menggunakan `super()`. Panggilan ini **harus** menjadi statement pertama di dalam constructor subclass.

```java
class Kendaraan {
    Kendaraan(String jenis) {
        System.out.println("Constructor Kendaraan: " + jenis);
    }
}

class Mobil extends Kendaraan {
    Mobil() {
        super("Roda Empat"); // Memanggil constructor superclass
        System.out.println("Constructor Mobil dibuat");
    }
}

new Mobil();
```

#### 📦 Object Class

Di Java, semua class secara implisit adalah turunan dari class `java.lang.Object`. Artinya, setiap objek di Java mewarisi method-method dari `Object`, seperti `toString()`, `equals()`, dan `hashCode()`.

```java
class Mobil {}

Mobil m = new Mobil();
// Method toString() diwarisi dari class Object
System.out.println(m.toString());
```

#### 🎭 Polymorphism

Polymorphism (artinya "banyak bentuk") adalah kemampuan sebuah objek untuk diperlakukan sebagai tipe data induknya. Ini memungkinkan kita menulis kode yang lebih fleksibel dan umum, di mana objek dari class turunan yang berbeda bisa diperlakukan secara seragam.

```java
// Mobil dan Motor adalah turunan dari Kendaraan
Kendaraan kendaraan1 = new Mobil();
Kendaraan kendaraan2 = new Motor();

// Memanggil method bergerak() sesuai objek aslinya
kendaraan1.bergerak(); // Memanggil bergerak() milik Mobil
kendaraan2.bergerak(); // Memanggil bergerak() milik Motor
```

#### 🕵️ Type Check dan Casts

*   **Type Check**: Menggunakan operator `instanceof` untuk memeriksa apakah sebuah objek merupakan instansiasi dari class tertentu.
*   **Casting**: Mengubah tipe referensi objek dari superclass kembali ke subclass. Casting diperlukan untuk mengakses anggota spesifik subclass.

```java
Kendaraan k = new Mobil();

if (k instanceof Mobil) {
    // Casting k dari Kendaraan menjadi Mobil
    Mobil m = (Mobil) k;
    m.putarMusik(); // Method spesifik milik Mobil
}
```

#### 🙈 Variable Hiding

Variable hiding terjadi jika *subclass* mendeklarasikan field dengan nama yang sama seperti di *superclass*. Tidak seperti method overriding, field tidak di-override. Field mana yang diakses tergantung pada tipe referensi variabel, bukan tipe objeknya.

```java
class Induk { String nama = "Induk"; }
class Anak extends Induk { String nama = "Anak"; }

Anak anak = new Anak();
System.out.println(anak.nama); // Output: Anak

Induk induk = anak; // Polymorphism
System.out.println(induk.nama); // Output: Induk (karena tipe referensi adalah Induk)
```

#### 📦 Package

Package adalah mekanisme untuk mengorganisir class dan interface ke dalam sebuah namespace (direktori). Package membantu menghindari konflik nama dan mengelompokkan kode yang saling terkait.

```java
// Mendeklarasikan bahwa class ini berada di package com.perusahaan.app
package com.perusahaan.app;
```

#### 🔑 Access Modifier

Access modifier mengontrol tingkat visibilitas (akses) dari class, field, dan method.

*   `public`: Dapat diakses dari mana saja.
*   `protected`: Dapat diakses di dalam package yang sama dan oleh subclass-nya.
*   `default` (tanpa modifier): Hanya dapat diakses di dalam package yang sama.
*   `private`: Hanya dapat diakses di dalam class itu sendiri.

#### 📥 Import

Kata kunci `import` digunakan untuk mengimpor class atau seluruh package agar dapat digunakan di file saat ini tanpa perlu menuliskan nama package lengkapnya.

```java
import java.util.Scanner; // Mengimpor class Scanner
import java.util.*;      // Mengimpor semua class di package java.util
```

#### 👻 Abstract Class

Abstract class adalah class yang **tidak bisa diinstansiasi** (tidak bisa dibuat objeknya). Class ini berfungsi sebagai kerangka dasar untuk subclass-nya. Abstract class bisa memiliki method abstrak dan method konkret.

```java
abstract class Hewan {
    // Method konkret
    void bernafas() {
        System.out.println("Bernafas...");
    }

    // Method abstrak (harus di-override oleh subclass)
    abstract void bersuara();
}
```

#### ✍️ Abstract Method

Abstract method adalah method yang dideklarasikan **tanpa implementasi** (tanpa body `{}`) di dalam sebuah abstract class. Subclass dari abstract class tersebut **wajib** meng-override dan menyediakan implementasi untuk semua method abstrak.

```java
class Kucing extends Hewan {
    @Override
    void bersuara() {
        System.out.println("Meow!");
    }
}
```

#### 🔐 Getter dan Setter

Getter dan Setter adalah method publik yang digunakan untuk mengakses (get) dan mengubah (set) nilai dari field yang bersifat `private`. Pola ini adalah pilar dari **enkapsulasi**, yang menyembunyikan data internal objek dari akses langsung.

```java
class Siswa {
    private String nama;

    // Getter
    public String getNama() {
        return this.nama;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }
}
```

#### 📜 Interface

Interface adalah sebuah "kontrak" yang berisi kumpulan method abstrak (dan bisa juga default/static method). Class yang mengimplementasikan sebuah interface (`implements`) **wajib** menyediakan implementasi untuk semua method abstrak di interface tersebut. Interface mendukung *multiple inheritance*.

```java
interface BisaTerbang {
    void terbang(); // method abstrak
}

class Burung implements BisaTerbang {
    @Override
    public void terbang() {
        System.out.println("Terbang dengan sayap");
    }
}
```

#### 📜👪 Interface Inheritance

Sebuah interface bisa mewarisi (memperluas) interface lain menggunakan kata kunci `extends`. Ini memungkinkan penciptaan hierarki interface.

```java
interface MakhlukHidup { void bernafas(); }
interface Mamalia extends MakhlukHidup { void menyusui(); }

class Manusia implements Mamalia {
    // Harus implementasi bernafas() dan menyusui()
}
```

#### 💡 Default Method

Sejak Java 8, interface bisa memiliki *default method*, yaitu method yang sudah memiliki implementasi. Class yang mengimplementasikan interface ini tidak wajib meng-override default method, tetapi bisa jika perlu.

```java
interface Kendaraan {
    void bergerak();

    default void klakson() {
        System.out.println("Beep!");
    }
}
```

#### 📜 `toString()` Method

Method yang diwarisi dari class `Object` ini digunakan untuk mendapatkan representasi String dari sebuah objek. Sebaiknya di-override untuk memberikan deskripsi objek yang informatif.

```java
class Mobil {
    String merk = "Toyota";

    @Override
    public String toString() {
        return "Mobil merk: " + merk;
    }
}

System.out.println(new Mobil()); // Output: Mobil merk: Toyota
```

#### == `equals()` Method

Digunakan untuk membandingkan **kesetaraan konten** dua objek. Secara default, `equals()` membandingkan referensi memori (sama seperti `==`). Sebaiknya di-override untuk membandingkan nilai field yang relevan.

```java
class Siswa {
    String id;
    // ... constructor, getter, setter

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Siswa other) {
            return this.id.equals(other.id);
        }
        return false;
    }
}
```

#### #️⃣ `hashCode()` Method

Mengembalikan nilai hash (integer) yang merepresentasikan objek. Jika Anda meng-override `equals()`, Anda **wajib** meng-override `hashCode()` juga. Aturannya: jika `a.equals(b)` bernilai true, maka `a.hashCode()` harus sama dengan `b.hashCode()`.

#### 🛑 Final Class

Class yang dideklarasikan dengan `final` **tidak bisa diwarisi** (tidak bisa di-`extends`). Ini berguna untuk class yang desainnya sudah final dan tidak boleh diubah, contohnya class `String`.

```java
final class Utility {
    // ...
}

// class MyUtility extends Utility {} // ERROR
```

#### 🚫 Final Method

Method yang dideklarasikan dengan `final` **tidak bisa di-override** oleh subclass-nya. Ini digunakan untuk memastikan bahwa perilaku sebuah method tidak akan pernah berubah di hierarki pewarisan.

```java
class Induk {
    final void metodePenting() {
        // ... implementasi penting
    }
}

class Anak extends Induk {
    // void metodePenting() {} // ERROR
}
```

####  nesting Inner Class

Inner class adalah class yang didefinisikan di dalam class lain. Inner class dapat mengakses semua anggota (termasuk yang `private`) dari class luarnya. Ini berguna untuk mengelompokkan class yang hanya relevan bagi class luarnya.

```java
class Luar {
    private String pesan = "Halo dari Luar";

    class Dalam {
        void sapa() {
            System.out.println(pesan); // Bisa akses field private class Luar
        }
    }
}

Luar.Dalam inner = new Luar().new Dalam();
inner.sapa();
```

#### 🕵️ Anonymous Class

Anonymous class adalah inner class tanpa nama yang dideklarasikan dan diinstansiasi dalam satu langkah. Biasanya digunakan untuk implementasi singkat dari sebuah interface atau abstract class.

```java
// Membuat objek dari interface Runnable menggunakan anonymous class
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Menjalankan tugas di thread baru");
    }
};

new Thread(r).start();
```

#### 🗿 `static` Keyword

`static` adalah modifier yang membuat sebuah anggota (field atau method) menjadi milik **class**, bukan milik objek. Anggota statis dapat diakses langsung menggunakan nama class tanpa perlu membuat objek.

*   **Static Field**: Nilainya sama untuk semua objek dari class tersebut.
*   **Static Method**: Tidak bisa mengakses anggota non-statis (field atau method objek).

```java
class Kalkulator {
    static final double PI = 3.14;

    static int tambah(int a, int b) {
        return a + b;
    }
}

System.out.println(Kalkulator.PI); // Akses static field
System.out.println(Kalkulator.tambah(5, 3)); // Akses static method
```

#### 📝 Record Class

Diperkenalkan di Java 16, `record` adalah cara singkat untuk membuat class yang tujuan utamanya hanya untuk menyimpan data (data carrier) dan bersifat *immutable* (nilainya tidak bisa diubah). Compiler secara otomatis men-generate constructor, getter, `equals()`, `hashCode()`, dan `toString()`.

```java
// Hanya dengan satu baris ini, kita sudah mendapatkan class Point yang immutable
record Point(int x, int y) {}

Point p = new Point(10, 20);
System.out.println(p.x()); // getter otomatis
System.out.println(p);     // toString() otomatis
```

#### 📋 Enum Class

Enum (`enum`) adalah tipe data khusus yang merepresentasikan sekumpulan nilai konstan yang tetap. Enum sangat berguna untuk variabel yang hanya boleh berisi salah satu dari beberapa nilai yang telah ditentukan.

```java
enum Level {
    LOW, MEDIUM, HIGH
}

Level level = Level.HIGH;
System.out.println(level); // Output: HIGH
```

#### 💣 Exception

Exception adalah sebuah peristiwa (error) yang terjadi saat program berjalan, yang mengganggu alur normal program. Java menyediakan mekanisme *exception handling* menggunakan `try-catch` untuk menangani error ini secara elegan tanpa membuat program crash.

```java
try {
    // Blok kode yang berpotensi menimbulkan exception
    int hasil = 10 / 0; // Akan melempar ArithmeticException
} catch (ArithmeticException e) {
    // Blok kode untuk menangani exception
    System.out.println("Error: Tidak bisa membagi dengan nol.");
}
```

#### 🏃 Runtime Exception

Runtime exception (atau *unchecked exception*) adalah exception yang umumnya disebabkan oleh kesalahan logika pemrograman (bug), seperti `NullPointerException`, `ArrayIndexOutOfBoundsException`. Java tidak mewajibkan Anda untuk menangani exception jenis ini, tetapi sebaiknya dihindari dengan kode yang baik.

#### 💥 Error

Error adalah masalah serius yang terjadi di level JVM dan umumnya tidak bisa ditangani oleh aplikasi, seperti `OutOfMemoryError` atau `StackOverflowError`. Ketika Error terjadi, aplikasi biasanya akan berhenti.

#### 👣 StackTraceElement Class

Saat exception terjadi, jejak pemanggilan method (stack trace) akan tercetak. Setiap baris dalam stack trace direpresentasikan oleh objek `StackTraceElement`, yang berisi informasi seperti nama class, nama method, dan nomor baris.

```java
try {
    // ...
} catch (Exception e) {
    e.printStackTrace(); // Mencetak stack trace ke konsol
}
```

#### ♻️ Try-with-Resources

Diperkenalkan di Java 7, ini adalah sintaks `try` yang memastikan bahwa setiap *resource* (seperti file atau koneksi database) yang dibuka akan **ditutup secara otomatis** setelah blok `try` selesai, baik normal maupun karena exception. Resource harus mengimplementasikan interface `AutoCloseable`.

```java
// Scanner akan ditutup otomatis setelah blok try selesai
try (Scanner scanner = new Scanner(System.in)) {
    String input = scanner.nextLine();
    System.out.println(input);
}
```

#### @ Annotation

Annotation adalah label metadata yang bisa ditambahkan ke kode Java. Annotation tidak mengubah eksekusi kode secara langsung, tetapi bisa digunakan oleh compiler atau framework untuk tujuan tertentu. Contohnya `@Override`, `@Deprecated`, atau anotasi dari framework seperti Spring (`@Autowired`).

#### 🔍 Reflection

Reflection adalah API yang memungkinkan sebuah program untuk **memeriksa dan memodifikasi** struktur dan perilaku dirinya sendiri saat runtime. Dengan reflection, kita bisa mendapatkan informasi tentang class, method, field, bahkan memanggil method secara dinamis.

```java
Class<?> myClass = String.class;
System.out.println("Nama Class: " + myClass.getName());
for (Method method : myClass.getDeclaredMethods()) {
    System.out.println("Method: " + method.getName());
}
```

#### 📜 String Class

`String` adalah class untuk merepresentasikan teks. String di Java bersifat *immutable*, artinya sekali dibuat, nilainya tidak bisa diubah. Setiap operasi yang terlihat seperti memodifikasi String sebenarnya membuat objek String baru.

```java
String teks = "Belajar Java";
System.out.println(teks.toUpperCase()); // "BELAJAR JAVA" (objek baru)
System.out.println(teks.substring(8));   // "Java" (objek baru)
System.out.println(teks);                // "Belajar Java" (objek asli tidak berubah)
```

#### 🏗️ StringBuilder dan StringBuffer

Karena String bersifat immutable, memodifikasi string berulang kali (misalnya dalam loop) sangat tidak efisien. Untuk itu, gunakan:
*   `StringBuilder`: Versi yang lebih cepat, tetapi tidak *thread-safe* (tidak aman untuk multi-threading).
*   `StringBuffer`: Versi yang lebih lambat, tetapi *thread-safe*.

Keduanya adalah class untuk membangun string yang **mutable** (bisa diubah).

```java
StringBuilder sb = new StringBuilder("Halo");
sb.append(" Dunia"); // Memodifikasi objek yang sama
sb.append("!");
System.out.println(sb.toString()); // "Halo Dunia!"
```

#### 🤝 StringJoiner Class

Kelas utilitas untuk menggabungkan beberapa string menjadi satu dengan delimiter (pemisah), prefix, dan suffix tertentu. Lebih fleksibel daripada `String.join()`.

```java
import java.util.StringJoiner;

StringJoiner sj = new StringJoiner(", ", "[", "]");
sj.add("Apel").add("Jeruk").add("Mangga");
System.out.println(sj.toString()); // Output: [Apel, Jeruk, Mangga]
```

#### 🔪 StringTokenizer Class

Kelas lawas (*legacy*) untuk memecah string menjadi token-token berdasarkan delimiter. Saat ini, penggunaan `String.split()` atau Regex lebih direkomendasikan.

#### 🔢 Number Class

`java.lang.Number` adalah abstract class induk untuk semua class *wrapper* numerik standar: `Byte`, `Short`, `Integer`, `Long`, `Float`, dan `Double`. Ini menyediakan method untuk mengonversi nilai dari satu tipe numerik ke tipe lainnya (misalnya `intValue()`, `doubleValue()`).

#### 📐 Math Class

`java.lang.Math` adalah class utilitas yang berisi method-method statis untuk operasi matematika fundamental, seperti trigonometri, logaritma, akar kuadrat, dan pembulatan.

```java
System.out.println(Math.max(10, 20));      // 20
System.out.println(Math.pow(2, 3));       // 8.0
System.out.println(Math.round(2.5));    // 3
System.out.println(Math.random());      // Angka acak antara 0.0 dan 1.0
```

#### 🐘 BigNumber Class

Untuk kalkulasi yang membutuhkan presisi atau jangkauan di luar `long` dan `double`, Java menyediakan:
*   `BigInteger`: Untuk bilangan bulat dengan presisi tak terbatas.
*   `BigDecimal`: Untuk bilangan desimal dengan presisi tak terbatas, sangat penting untuk perhitungan finansial agar terhindar dari error pembulatan.

```java
import java.math.BigDecimal;

BigDecimal harga = new BigDecimal("10.1");
BigDecimal jumlah = new BigDecimal("3");
BigDecimal total = harga.multiply(jumlah);
System.out.println(total); // Output: 30.3
```

#### ⌨️ Scanner Class

Kelas yang sangat berguna untuk membaca input dari berbagai sumber, termasuk input dari pengguna di konsol (`System.in`).

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan nama Anda: ");
String nama = scanner.nextLine();
System.out.println("Halo, " + nama);
```

#### 📅 Date dan Calendar Class

*   `Date`: Kelas lawas untuk merepresentasikan tanggal dan waktu. Sebagian besar method-nya sudah *deprecated*.
*   `Calendar`: Kelas lawas yang lebih baik untuk memanipulasi tanggal (menambah hari, bulan, dll). 

**Catatan**: Sejak Java 8, sangat disarankan untuk menggunakan **Java Date and Time API** (`java.time` package) yang baru, seperti `LocalDate`, `LocalDateTime`, dan `ZonedDateTime`, karena lebih modern, immutable, dan lebih mudah digunakan.

#### 💻 System Class

`java.lang.System` adalah class utilitas final yang menyediakan akses ke fungsionalitas level sistem, seperti standard input/output/error streams (`System.in`, `System.out`, `System.err`), mendapatkan variabel lingkungan, dan mengukur waktu.

```java
System.out.println("Pesan error", System.err);
long startTime = System.currentTimeMillis();
String javaHome = System.getenv("JAVA_HOME");
```

#### 🏃 Runtime Class

Setiap aplikasi Java memiliki satu instans `Runtime` yang merepresentasikan lingkungan eksekusi. Class ini dapat digunakan untuk berinteraksi dengan JVM, seperti memeriksa penggunaan memori dan jumlah prosesor yang tersedia.

```java
Runtime runtime = Runtime.getRuntime();
System.out.println("Prosesor tersedia: " + runtime.availableProcessors());
System.out.println("Total memori JVM: " + runtime.totalMemory());
```

#### 🆔 UUID Class

`UUID` (Universally Unique Identifier) adalah class untuk menghasilkan ID 128-bit yang dijamin unik. Sangat berguna untuk ID database, ID sesi, atau di mana pun ID unik diperlukan.

```java
import java.util.UUID;

String uniqueID = UUID.randomUUID().toString();
System.out.println(uniqueID);
```

#### 🧬 Base64 Class

Kelas utilitas di Java 8+ untuk melakukan encoding dan decoding data ke format Base64. Base64 berguna untuk mengirim data biner melalui media teks.

```java
import javat.util.Base64;

String asli = "Teks rahasia";
String encoded = Base64.getEncoder().encodeToString(asli.getBytes());
byte[] decodedBytes = Base64.getDecoder().decode(encoded);
String decoded = new String(decodedBytes);
```

#### 📦 Objects Class

`java.util.Objects` adalah class utilitas yang berisi method-method statis untuk bekerja dengan objek. Method ini seringkali sudah *null-safe* (aman jika objeknya null), sehingga menyederhanakan kode.

```java
import java.util.Objects;

// Cara aman membandingkan dua objek yang mungkin null
boolean isEqual = Objects.equals(obj1, obj2);

// Cara aman menghitung hash code dari objek yang mungkin null
int hashCode = Objects.hashCode(obj);
```

#### 🎲 Random Class

Kelas untuk menghasilkan angka pseudo-acak (pseudorandom). Lebih fleksibel daripada `Math.random()`.

```java
import java.util.Random;

Random random = new Random();
int angkaAcak = random.nextInt(100); // Angka acak dari 0 hingga 99
boolean booleanAcak = random.nextBoolean();
```

#### ⚙️ Properties Class

`Properties` adalah subclass dari `Hashtable` yang digunakan untuk mengelola data konfigurasi dalam bentuk pasangan key-value berbasis string. Data ini dapat dengan mudah dibaca dari atau ditulis ke file `.properties`.

```java
import java.util.Properties;

Properties props = new Properties();
props.setProperty("database.url", "localhost");
props.setProperty("database.user", "admin");
String dbUser = props.getProperty("database.user");
```

#### 🗃️ Arrays Class

`java.util.Arrays` adalah class utilitas yang berisi method-method statis untuk melakukan operasi umum pada array, seperti mengurutkan (`sort`), mencari (`binarySearch`), membandingkan (`equals`), dan mengisi (`fill`).

```java
import java.util.Arrays;

int[] angka = {5, 1, 4, 2, 3};
Arrays.sort(angka);
System.out.println(Arrays.toString(angka)); // [1, 2, 3, 4, 5]
```

#### 🧐 Regular Expression

Regular Expression (Regex) adalah pola teks yang digunakan untuk pencocokan string. Java menyediakan package `java.util.regex` (`Pattern` dan `Matcher`) untuk bekerja dengan Regex, yang sangat kuat untuk validasi input, pencarian, dan manipulasi teks.

```java
import java.util.regex.Pattern;

String email = "test@example.com";
boolean isValid = Pattern.matches("^[\w.-]+@[\w.-]+\.[a-zA-Z]{2,}$", email);
System.out.println("Email valid: " + isValid);
```

## 2️⃣ Collection & Data

### #1 🗃️ Java Collections

Java Collections Framework adalah sekumpulan class dan interface yang menyediakan arsitektur untuk menyimpan dan memanipulasi sekelompok objek.

#### 🚶 Iterable dan Iterator

*   `Iterable`: Interface dasar yang menandakan bahwa objek dari class tersebut dapat diiterasi (diulang), biasanya menggunakan for-each loop. Semua collection di Java adalah `Iterable`.
*   `Iterator`: Objek yang digunakan untuk melakukan iterasi pada sebuah collection secara manual. Iterator memiliki method seperti `hasNext()`, `next()`, dan `remove()`.

#### 📦 Collection Interface

Interface akar dalam hierarki collection. Mendefinisikan method-method dasar yang dimiliki oleh hampir semua collection, seperti `add()`, `remove()`, `size()`, `isEmpty()`, dan `contains()`.

#### 📋 List Interface

*   Koleksi **berurutan** yang elemennya dapat diakses melalui indeks.
*   **Memperbolehkan elemen duplikat**.
*   Implementasi umum: `ArrayList` (cepat untuk akses acak), `LinkedList` (cepat untuk tambah/hapus di tengah).

```java
List<String> names = new ArrayList<>();
names.add("Dhimas");
names.add("Arista");
names.add("Dhimas"); // Duplikat diizinkan
System.out.println(names.get(0)); // "Dhimas"
```

#### 🛡️ Immutable List

List yang elemennya **tidak bisa diubah** (ditambah, dihapus, atau diganti) setelah dibuat. Dibuat menggunakan `List.of()`.

```java
List<String> immutableNames = List.of("A", "B", "C");
// immutableNames.add("D"); // Akan melempar UnsupportedOperationException
```

#### 🚫 Set Interface

*   Koleksi yang **tidak berurutan** (pada umumnya).
*   **Tidak memperbolehkan elemen duplikat**.
*   Implementasi umum: `HashSet` (cepat, tidak terurut), `LinkedHashSet` (terurut berdasarkan urutan insersi), `TreeSet` (terurut secara alami).

```java
Set<String> uniqueNames = new HashSet<>();
uniqueNames.add("Dhimas");
uniqueNames.add("Arista");
uniqueNames.add("Dhimas"); // Akan diabaikan
System.out.println(uniqueNames); // [Arista, Dhimas] (urutan tidak dijamin)
```

#### 🔀 SortedSet Interface

Sub-interface dari `Set` yang menjamin bahwa elemen-elemennya akan selalu dalam keadaan **terurut**, baik urutan alami (natural order) maupun urutan kustom menggunakan `Comparator`.

*   Implementasi utama: `TreeSet`.

```java
SortedSet<Integer> sortedNumbers = new TreeSet<>(List.of(5, 1, 3));
System.out.println(sortedNumbers.first()); // 1
System.out.println(sortedNumbers.last());  // 5
```

####  FIFO Queue Interface

Koleksi yang didesain untuk memproses elemen dalam urutan **FIFO (First-In, First-Out)**, seperti antrean. Elemen ditambahkan di akhir (`add`/`offer`) dan dihapus dari depan (`remove`/`poll`).

*   Implementasi umum: `LinkedList`, `ArrayDeque`.

```java
Queue<String> antrean = new LinkedList<>();
antrean.offer("Orang 1");
antrean.offer("Orang 2");
System.out.println(antrean.poll()); // "Orang 1"
```

#### ↕️ Deque Interface

`Deque` (dibaca "deck") adalah singkatan dari *double-ended queue*. Ini adalah antrean dua ujung, di mana elemen bisa ditambah atau dihapus dari **depan maupun belakang**.

*   Implementasi umum: `ArrayDeque` (lebih efisien), `LinkedList`.

```java
Deque<String> tumpukan = new ArrayDeque<>();
tumpukan.addFirst("Buku 1");
tumpukan.addFirst("Buku 2");
System.out.println(tumpukan.removeFirst()); // "Buku 2"
```

#### 🗺️ Map Interface

*   Struktur data yang menyimpan data dalam bentuk pasangan **key-value**.
*   Setiap **key harus unik**.
*   Implementasi umum: `HashMap` (cepat, tidak terurut), `LinkedHashMap` (terurut berdasarkan urutan insersi), `TreeMap` (terurut berdasarkan key).

```java
Map<String, Integer> nilaiUjian = new HashMap<>();
nilaiUjian.put("Matematika", 90);
nilaiUjian.put("Fisika", 85);
System.out.println(nilaiUjian.get("Matematika")); // 90
```

#### 🛡️🗺️ Immutable Map

Map yang key-value pair-nya **tidak bisa diubah** setelah dibuat. Dibuat menggunakan `Map.of()`.

```java
Map<String, Integer> immutableMap = Map.of("A", 1, "B", 2);
// immutableMap.put("C", 3); // Akan melempar UnsupportedOperationException
```

#### 🔀🗺️ SortedMap Interface

Sub-interface dari `Map` yang menjamin bahwa pasangan key-value akan selalu **terurut berdasarkan key**.

*   Implementasi utama: `TreeMap`.

#### 🔑-value Entry Map

`Map.Entry` adalah interface inner di dalam `Map` yang merepresentasikan satu pasangan key-value. Iterasi pada `Map` seringkali dilakukan melalui `entrySet()` yang mengembalikan `Set<Map.Entry>`.

```java
for (Map.Entry<String, Integer> entry : nilaiUjian.entrySet()) {
    System.out.println("Kunci: " + entry.getKey() + ", Nilai: " + entry.getValue());
}
```

#### 📜 Legacy Collection

Kelas-kelas collection dari Java versi awal (sebelum Java 2), seperti `Vector`, `Hashtable`, dan `Stack`. Kelas-kelas ini umumnya sudah *thread-safe* (tersinkronisasi) tetapi kinerjanya lebih lambat. Penggunaan `ArrayList`, `HashMap`, dan `ArrayDeque` lebih direkomendasikan untuk kasus single-threaded.

#### 🔀 Sorting

Pengurutan collection dapat dilakukan menggunakan:
*   `Collections.sort(list)`: Untuk mengurutkan `List`.
*   `list.sort(comparator)`: Method pada `List` itu sendiri.
*   `TreeSet` dan `TreeMap`: Struktur data yang secara otomatis menjaga urutan elemen.

#### 🔍 Binary Search

Algoritma pencarian yang sangat efisien untuk mencari elemen di dalam **list yang sudah terurut**. Gunakan `Collections.binarySearch()`.

```java
List<Integer> sortedList = List.of(10, 20, 30, 40);
int index = Collections.binarySearch(sortedList, 30);
System.out.println(index); // 2
```

#### 🛠️ Collections Class

`java.util.Collections` (dengan 's') adalah class utilitas yang berisi method-method statis untuk beroperasi pada collection, seperti `sort()`, `reverse()`, `shuffle()`, `binarySearch()`, dan membuat collection yang *thread-safe* atau *unmodifiable*.

### #2 ⛓️ Sequenced Collection (Java 21+)

Fitur baru di Java 21 yang menyatukan API untuk collection yang memiliki urutan elemen yang terdefinisi.

#### ⛓️ SequencedCollection Interface

Interface baru yang menyediakan method untuk mengakses elemen **pertama** (`getFirst()`) dan **terakhir** (`getLast()`) dari sebuah collection, serta method untuk mendapatkan view terbalik (`reversed()`). Diimplementasikan oleh `List`, `Deque`, `LinkedHashSet`, dll.

#### ⛓️🚫 SequencedSet Interface

Sub-interface dari `Set` yang juga mengimplementasikan `SequencedCollection`. Menjamin urutan elemen dan menyediakan akses ke elemen pertama/terakhir. `LinkedHashSet` adalah implementasi utamanya.

#### ⛓️🗺️ SequencedMap Interface

Sub-interface dari `Map` yang menjamin urutan entry dan menyediakan akses ke entry pertama/terakhir (`firstEntry()`, `lastEntry()`). `LinkedHashMap` adalah implementasi utamanya.

### #3 🧬 Java Generic

#### 🧬 Pengenalan Generic

Generic adalah fitur yang memungkinkan class, interface, dan method untuk beroperasi pada berbagai tipe data dengan tetap menjaga **type safety** (keamanan tipe) saat kompilasi. Ini menghilangkan kebutuhan untuk melakukan *casting* secara manual dan mengurangi risiko `ClassCastException` saat runtime.

*   **Tujuan**: Membuat kode yang lebih fleksibel dan dapat digunakan kembali.
*   **Sintaks**: Tipe parameter ditulis di dalam kurung sudut (`<T>`). `T` adalah singkatan dari *Type* dan bisa diganti dengan huruf lain.

```java
// List<String> berarti List ini hanya boleh berisi objek String.
List<String> daftarNama = new ArrayList<>();
daftarNama.add("Dhimas");
// daftarNama.add(123); // Ini akan error saat kompilasi
```

#### 📦 Generic Class

Class yang dapat bekerja dengan tipe data yang berbeda-beda. Tipe datanya ditentukan saat objek dari class tersebut dibuat.

```java
// Membuat class Box yang bisa menampung tipe data apa pun.
class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

// Menggunakan Box untuk Integer
Box<Integer> integerBox = new Box<>();
integerBox.setContent(10);

// Menggunakan Box untuk String
Box<String> stringBox = new Box<>();
stringBox.setContent("Hello World");
```

#### 🔧 Generic Method

Method yang memiliki parameter tipe sendiri, yang dideklarasikan sebelum *return type* method. Ini memungkinkan method untuk bekerja dengan tipe yang berbeda untuk setiap pemanggilan.

```java
class ArrayHelper {
    // Method generik untuk mencetak elemen array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
    }
}

String[] names = {"Dhimas", "Arista"};
Integer[] numbers = {1, 2, 3};

ArrayHelper.printArray(names);   // Dhimas Arista
ArrayHelper.printArray(numbers); // 1 2 3
```

#### 🔒 Invariant

Secara default, generic di Java bersifat **invariant**. Artinya, sebuah tipe generic tidak memiliki hubungan pewarisan dengan tipe generic lain, meskipun tipe argumennya memiliki hubungan pewarisan. Contoh: `List<String>` **bukan** turunan dari `List<Object>`.

```java
List<String> stringList = new ArrayList<>();
// List<Object> objectList = stringList; // ERROR: Incompatible types
```

#### ↘️ Covariant

Covariant memungkinkan sebuah generic untuk menerima tipe turunan (*subclass*). Ini bersifat **read-only** (producer). Kita bisa mengambil data dari struktur, tetapi tidak bisa menambahkan data ke dalamnya untuk menjaga keamanan tipe.

*   **Sintaks**: Menggunakan `? extends TipeInduk` (disebut *upper-bounded wildcard*).
*   **Guna**: Berguna saat kita hanya perlu **membaca** data dari sebuah koleksi.

```java
// Method ini bisa menerima List<Integer>, List<Double>, dll.
public void proses(List<? extends Number> list) {
    for (Number n : list) { // AMAN (read)
        System.out.println(n);
    }
    // list.add(123); // ERROR (write)
}
```

#### ↗️ Contravariant

Contravariant memungkinkan sebuah generic untuk menerima tipe induk (*superclass*). Ini bersifat **write-only** (consumer). Kita bisa menambahkan data (yang merupakan tipe turunan) ke dalam struktur, tetapi saat membaca, kita hanya bisa yakin bahwa itu adalah `Object`.

*   **Sintaks**: Menggunakan `? super TipeTurunan` (disebut *lower-bounded wildcard*).
*   **Guna**: Berguna saat kita hanya perlu **menambahkan** data ke sebuah koleksi.

```java
// Method ini bisa menerima List<Integer>, List<Number>, atau List<Object>
public void tambahAngka(List<? super Integer> list) {
    list.add(10); // AMAN (write)
    list.add(20);
    // Object obj = list.get(0); // Read hanya menghasilkan Object
}
```

#### ⛓️ Bounded Type Parameter

Membatasi tipe parameter generik agar hanya bisa menerima tipe tertentu atau turunannya. Ini mirip dengan *covariant wildcard*, tetapi didefinisikan di level class atau method.

```java
// Class ini hanya bisa digunakan dengan tipe data turunan Number
class Data<T extends Number> {
    private T value;
    public Data(T value) { this.value = value; }
    // ...
}

Data<Integer> data1 = new Data<>(10);
// Data<String> data2 = new Data<>("Test"); // ERROR
```

#### ❓ Wildcard (`?`)

Wildcard (`?`) merepresentasikan tipe yang tidak diketahui. Berguna ketika logika method tidak bergantung pada tipe spesifik dari elemen dalam collection.

```java
// Method ini bisa mencetak list apa saja, tidak peduli tipenya
void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

#### 👻 Type Erasure

Informasi tipe generik **dihapus oleh compiler** saat kompilasi (prosesnya disebut *type erasure*). Tipe generik diubah menjadi tipe batasannya atau `Object`. Ini berarti informasi generik tidak ada saat runtime, yang bertujuan untuk kompatibilitas dengan Java versi lama.

```java
List<String> listA = new ArrayList<>();
List<Integer> listB = new ArrayList<>();

// Saat runtime, JVM hanya melihat keduanya sebagai List
System.out.println(listA.getClass() == listB.getClass()); // true
```

#### ⚖️ Comparable & Comparator Interface

*   `Comparable`: Diimplementasikan oleh sebuah class untuk mendefinisikan **urutan alaminya** (natural order). Memiliki satu method, `compareTo()`.
*   `Comparator`: Dibuat sebagai class terpisah untuk mendefinisikan **urutan kustom**. Berguna untuk mengurutkan objek dari class yang tidak bisa kita modifikasi atau untuk menyediakan beberapa aturan pengurutan.

### #4 🌊 Java Stream

Java Stream adalah API yang diperkenalkan di Java 8 untuk memproses sekuens elemen (misalnya dari collection) secara **deklaratif**. Stream memungkinkan kita untuk melakukan operasi kompleks seperti filter, map, dan reduce dengan cara yang ringkas dan ekspresif.

#### ➡️ Stream Pipeline

Stream pipeline adalah urutan operasi yang dilakukan pada stream. Terdiri dari:
1.  **Sumber (Source)**: Collection, array, atau sumber data lain.
2.  **Operasi Intermediate (Intermediate Operations)**: Nol atau lebih operasi yang mengubah stream menjadi stream lain (misalnya `filter()`, `map()`, `sorted()`). Operasi ini bersifat *lazy*.
3.  **Operasi Terminal (Terminal Operation)**: Satu operasi yang mengakhiri pipeline dan menghasilkan hasil akhir (misalnya `forEach()`, `collect()`, `sum()`).

```java
List.of("apel", "jeruk", "mangga", "anggur")
    .stream() // 1. Sumber
    .filter(s -> s.length() > 4) // 2. Intermediate
    .map(String::toUpperCase)      // 2. Intermediate
    .forEach(System.out::println); // 3. Terminal
```

#### 😴 Lazy Evaluation

Operasi intermediate pada stream bersifat *lazy*. Artinya, operasi tersebut tidak akan dieksekusi sampai ada operasi terminal yang dipanggil. Ini memungkinkan JVM untuk melakukan optimisasi, seperti menggabungkan beberapa operasi menjadi satu proses.

#### ✨ Transformation Operations

Operasi yang mengubah setiap elemen dalam stream menjadi elemen baru.
*   `map()`: Mengubah setiap elemen menjadi elemen lain (transformasi satu-ke-satu).
*   `flatMap()`: Mengubah setiap elemen menjadi stream baru, lalu menggabungkan semua stream tersebut menjadi satu stream tunggal (transformasi satu-ke-banyak).

#### 🗑️ Filtering Operations

Operasi untuk menyaring elemen berdasarkan kondisi tertentu.
*   `filter()`: Memilih elemen yang memenuhi predikat.
*   `distinct()`: Menghapus elemen duplikat.

#### 🎣 Retrieving Operations

Operasi untuk mengambil sebagian elemen dari stream.
*   `limit(n)`: Mengambil `n` elemen pertama.
*   `skip(n)`: Melewatkan `n` elemen pertama.

#### 🔀 Ordering Operations

*   `sorted()`: Mengurutkan elemen stream berdasarkan urutan alaminya atau menggunakan `Comparator`.

#### ➕ Aggregate Operations

Operasi terminal yang menghasilkan satu nilai ringkasan dari semua elemen stream.
*   `count()`: Menghitung jumlah elemen.
*   `max(comparator)`: Mencari elemen maksimum.
*   `min(comparator)`: Mencari elemen minimum.
*   `sum()`, `average()`: Tersedia pada stream numerik (`IntStream`, `DoubleStream`).
*   `reduce()`: Operasi agregasi umum.

#### ✅ Check Operations

Operasi terminal yang memeriksa apakah elemen stream memenuhi kondisi tertentu dan mengembalikan `boolean`.
*   `anyMatch()`: `true` jika **minimal satu** elemen cocok.
*   `allMatch()`: `true` jika **semua** elemen cocok.
*   `noneMatch()`: `true` jika **tidak ada** elemen yang cocok.
