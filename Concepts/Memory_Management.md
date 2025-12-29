# Memory Management

> Empat paradigma berbeda yang mempengaruhi cara kita menulis, mendesain, dan mengoptimalkan software: C#, Zig, Java, dan Rust.

## Premis

Tidak ada sistem memori yang “benar” atau “salah”. Yang ada hanya *trade-off*. Compile-time memberi kontrol dan performa; runtime memberi kemudahan dan safety-dengan harga tertentu.

---

## C# - *Tracing GC dengan tuning yang fleksibel*

C# mengandalkan **generational tracing GC** yang menekankan kemudahan developer dan throughput tinggi.

**Model:**

* **Workstation GC** - fokus responsivitas untuk desktop/client.
* **Server GC** - memaksimalkan throughput dengan multi-threaded GC.
* **Background GC** - menjalankan koleksi secara paralel agar jeda (pause) lebih kecil.

**Konsekuensi:**

* Overhead runtime tak terhindarkan.
* Latency masih ada, meski sudah jauh membaik.
* Sangat produktif untuk sistem yang tidak butuh kontrol ultra presisi.

---
## Zig - *Manual but safer, no hidden behavior*

Zig menawarkan kontrol penuh tanpa gimmick. Tidak ada GC, tidak ada ARC, tidak ada runtime yang ikut campur.

**Model:**

* **Manual memory management** dengan allocator eksplisit.
* **Comptime execution** memperkuat safety sebelum runtime.
* **No implicit allocations** - semua terlihat jelas.

**Konsekuensi:**

* Zero abstraction penalty.
* Performa maksimal pada sistem.
* Error handling memaksa disiplin.
* Risiko memory leaks sepenuhnya tanggung jawab developer.

---
## Java - *GC ecosystem paling matang di industri*

Java bermain di liga berbeda: pilihan GC-nya dirancang untuk berbagai skenario produksi, dari throughput hingga ultra-low latency.

**GC options:**

* **Parallel GC** - throughput maksimal.
* **G1GC** - default seimbang, minim fragmentation.
* **ZGC** - sub-millisecond pause (<1ms).
* **Shenandoah** - low-pause buatan RedHat.
* **Epsilon** - no-GC (stress testing).

**Konsekuensi:**

* Runtime overhead tetap ada.
* Latency dapat ditekan ekstrem (ZGC/Shenandoah).
* Cocok untuk infrastruktur besar yang butuh runtime yang bisa “menyembuhkan dirinya sendiri”.

---

## Rust - *Ownership + Borrowing sebagai compile-time memory management*

Rust mencapai apa yang Zig lakukan, tapi dengan keamanan yang lebih tinggi melalui sistem tipe yang agresif.

**Model:**

* **Ownership / Borrow Checker** memastikan alokasi dan free terjadi deterministic.
* **No GC, no runtime**, keputusan memory ditentukan compiler.
* **Zero-cost abstraction** sangat dekat dengan Zig, tapi lebih aman.

**Konsekuensi:**

* Kurva belajar paling curam.
* Compile-time lebih berat karena analisis borrow.
* Runtime bersih, stabil, dan bisa menyaingi C/C++ bahkan di sistem besar.

---

## GC/Runtime vs Compile-Time - Trade-Off Inti

### Compile-Time (Zig, Rust)

* Memory lifecycle dipastikan sebelum program berjalan.
* **Kelebihan:** performa tertinggi, zero overhead, kontrol absolut.
* **Kekurangan:** disiplin tinggi, error lebih tajam, development lebih lambat di awal.

### Runtime/GC (C#, Java)

* Memory dibersihkan ketika diperlukan melalui strategi generational.
* **Kelebihan:** developer experience jauh lebih nyaman, risiko leak lebih kecil.
* **Kekurangan:** overhead, pause time, dan ketergantungan pada heuristik runtime.
