# Why C# & Zig?

- C# adalah bahasa pemrograman yang apa saja bisa
  - Multi-paradgima: OOP, Struct, Functional
  - Multi-purpose: Frontend, Backend, IoT, dan lainnya
  - Compile options : JIT, R2R dan AOT/Native Build
- Zig adalah bahasa low level dengan slogan "Better C"
  - Dibackend ada JetZig, performa setara Rust
  - Bisa interop bahkan compile C/C++ tanpa compiler tambahan

---

- NodeJS => daily-driver yang cukup menopang kebutuhan sebagai developer
  - !Ok : harus tahu cara optimalisasinya karena JS adalah single-thread
- Java => enterprise dan ekosistem sangat besar karena 30 tahun exist
  - !Ok : berat dan harus tahu tuning, dan mode AOT di GraalVM CE cuman bisa single-thread di garbage collection-nya.
- Swift => sama seperti Zig, compiler menggunakan LLVM tetapi tetap pakai runtime di memori manajemen yaitu ARC bukan GC.
  - !Ok : ekosistem tidak se-mature NodeJS/Java, terlebih masih kena stigma vendor lock (Apple) padahal multi-platform, belum lagi ada beberapa sumber mengatakan ARC tidak optimal untuk throughput tinggi.
- PHP => seeking job terutama laravel sangat gampang dan mudah dipelajari
  - !Ok : performa tidak seoptimal lainnya tanpa ganti runtime (Swoole, Workerman, etc)

---

Memilih C# dan Zig sebagai foundasi mempelajari programming karena keduanya mewakili kombinasi unik antara performa, fleksibilitas, dan kontrol.

C# memungkinkan menulis kode yang multi-paradigma : object-oriented, functional, bahkan struct-oriented, sekaligus multi-purpose dari backend hingga frontend, IoT, atau native application. Compile option yang lengkap, mulai dari JIT, R2R, hingga AOT/native build, memberi saya kebebasan untuk menyeimbangkan performa dan produktivitas.

Zig, di sisi lain, memberikan kendali low-level yang sangat mendekati C, namun dengan keamanan dan kejelasan sintaks yang lebih modern. Dengan Zig, membuat sistem yang benar-benar deterministik dalam memori dan performa, yang esensial untuk aplikasi embedded, IoT, atau sistem high-throughput.

Bahasa lain yang digunakan juga sesuai kebutuhan: NodeJS sebagai daily-driver dan rapid development tool; Java untuk ekosistem enterprise yang mature; Swift untuk niche gateway IoT dan integrasi Apple ecosystem; PHP untuk outer stack web/API layer, terutama Laravel. Namun, bagi saya, C# & Zig tetap menjadi inti karena mereka memungkinkan saya membangun sistem yang scalable, performant, dan future-proof, di mana concurrency, memory management, dan arsitektur modular bukan sekadar teori, tapi implementasi nyata.
