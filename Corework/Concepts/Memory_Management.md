❌ : Apapun memory-manage saat runtime, tidak lebih baik saat compile-time.

- Masalah utama bahasa seperti C# atau Java adalah Tracing GC.
- Tapi ini jelas memudahkan developer ketimbang harus berurusan dengan memory leaks.
- Berbeda dengan Zig atau Rust, lebih zero abstraction dan overhead karena tidak ada GC/ARC.

### C# :

- Workstation GC (single-thread) fokus untuk optimalisasi client-side seperti desktop.
- Server GC cocok untuk server-side atau backend dengan tujuan throughput tinggi.
- Background GC aktif pada kedua GC sebelumnya dan bisa dinonaktifkan.

### NodeJS (V8) :

- V8 hanya menggunakan 1 pendekatan GC dengan area kerja yang luas, dimulai dari :
    - Minor GC (Scavenger), petugas sapu harian pada bagian young gen.
    - Major GC (Mark-Sweep-Compact), fokus pada objek yang jarang disentuh atau disebut old generation.
    - Incremental & Concurrent, ibaratnya adalah petugas shift malam yang tidak menggangu aktivitas sama sekali fokus pada semua area atau young dan old gen.
    - Idle-time GC juga fokus pada semua area dengan tugas saat program sedang idle.

### Java :

- Serial GC : single-thread cocok untuk program kecil.
- Parallel GC : multi-thread cocok untuk throughput tinggi.
- G1GC : default pada runtime, dimana performa lebih seimbang.
- ZGC : latency rendah <1 ms, dipakai untuk realtime proses.
- Shenandoah GC : buatan redhat, mirip ZGC
- Epsilon GC : mode-off cocok untuk testing

### Swift :

- Berbeda dengan ke-3 bahasa barusan, Swift menggunakan Automatic Reference Counting.
    - Retain (+1) saat ada referensi baru.
    - Release (-1) saat referensi hilang.
    - Jika 0, maka objek di-deallocate segera

## Runtime (GC/ARC) vs Compile-Time

### Compile-Time

- Semua logika termasuk aturan memori ditentukan sebelum program jalan tanpa butuh petugas lagi, bisa disebut self-cleaning.
    - ✅ tidak ada overhead, performa kasta atas
    - ⛔ butuh skill tinggi dari programmer biasa

### Garbage Collection : *deferred cleaning*

- Secara flow kerja, GC hanya menghapus memory pada waktu-waktu tertentu.
    - ✅ aman dari memory leaks, througput bisa tinggi.
    - ⛔ jika tidak ada mode konkuren, aplikasi terjadi jeda.
- Java ZGC adalah GC paling canggih bahkan bisa setara performa aplikasi compile-time.

### Automatic Reference Counting : *immediate release*

- Aplikasi segera menghapus objek setelah dipakai, ini mirip pada Rust cuman bedanya butuh petugas tambahan yang juga menambah overhead tentunya.
    - ✅ determinasi dan lebih predictable, serta tidak ada pause aplikasi
    - ⛔ overhead lebih tinggi dari GC karena dilakukan tiap waktu, cost kena di CPU jadi lebih tinggi.
- ⛔ Secara teori ARC susah dioptimalkan atau di-*scale* ketimbang GC, karena desainnya tidak melihat seluruh object-graph. Ujung-ujungnya harus mengikuti pendekatan GC seperti :
    - menunda pelepasan dan melakukan batch-wise.
    - objek disatukan pada satu area agar bisa dialokasikan dan dihapus sekaligus.
    - ARC fokus pada objek yang hidupnya pendek, GC fokus pada long-lived objek
        - pernah dipakai Obj-C oleh Apple tapi dibatalkan.
- ✅ Swift 6, sama seperti rust yaitu memindahkan ownership objek tanpa perlu retain/release. Kalo ini stabil, swift bakal menjadi bahasa yang lebih performance kedepannya.

<aside>
💡

Never choose a language for its power, but for its ecosystem. strength means nothing if the industry doesn’t speak its syntax.

</aside>