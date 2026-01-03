# Low Level Onboarding

**Choose low-level languages**

* **Rust** : ✅ produktif, transferable, industry-ready
* **Assembly** : ✅ pendamping wajib untuk CPU & ABI
* **C/C++** : ⚠️ good as background knowledge, not primary
* **Zig** : ⚠️ konsep menarik, tapi learning ROI rendah saat ini

---

> Kenapa Rust? **Rust dipilih karena memberi *low-level understanding* + *high productivity* + *career transferability* secara bersamaan.**

---

### 1️⃣ Produktivitas Nyata, Bukan Teoretis

Low-level onboarding gagal kalau:

* terlalu lama di bug memory
* terlalu banyak waktu habis debugging UB
* output lambat → motivasi turun

Rust:

* compile-time error > runtime bug
* ownership & lifetime mencegah bug kelas paling mahal
* tooling (cargo, clippy, fmt) matang

➡️ **Waktu belajar dialihkan ke understanding sistem, bukan firefighting.**

---

### 2️⃣ Rust Tetap Low-Level (Tidak Mengaburkan Hardware)

Rust **tidak menyembunyikan** :

* memory layout
* alignment
* stack vs heap
* cache behavior
* syscall & FFI
* data race

Rust hanya **memaksa reasoning eksplisit** .

Kalau kode Rust terasa “ribet”, itu sinyal:

> kamu belum paham constraint low-level-nya

Ini *fitur* , bukan kelemahan.

---

### 3️⃣ Zig & C: Asumsi Umum yang Keliru (Realita Lapangan)

#### ❌ Asumsi:

> “Belajar Zig atau C dulu → Rust jadi gampang”

#### ✅ Kenyataan:

* Zig → **tidak otomatis** paham ownership & lifetime
* C → membentuk habit *trust yourself* bukan *prove correctness*

Akibatnya:

* Transisi ke Rust justru **lebih sulit**
* Banyak developer Zig/C mentok di mental model Rust

➡️ **Rust bukan superset C/Zig.
Rust adalah paradigma berbeda.**

Belajar Rust **lebih efektif dari nol** , dengan:

* Assembly sebagai grounding hardware
* C hanya sebagai referensi ABI / FFI

---

### 4️⃣ Transferability (Onboarding Bukan Akademik)

Rust dipakai di:

* kernel & driver
* embedded / RTOS
* networking
* storage engine
* VM / blockchain
* cloud infra

Zig:

* belum stabil
* sedikit production code
* onboarding industri rendah

C:

* banyak legacy
* sedikit greenfield
* high maintenance cost

➡️ **Rust memberi leverage lintas domain.**

---

### 5️⃣ Assembly + Rust = Kombinasi Optimal

Assembly:

* memahami CPU, register, calling convention
* membaca output compiler
* reasoning performa nyata

Rust:

* produksi kode aman & maintainable
* tetap bisa `unsafe`, inline asm, no_std

➡️ **Assembly = microscope
Rust = production tool**

---

## Step Learning Low-Level (Concrete)

### Phase 0 — Mental Reset

* proses vs thread
* virtual memory
* user vs kernel space
* stack frame

---

### Phase 1 — Rust Core (Systems Perspective)

* ownership & borrowing
* lifetimes (manual reasoning, bukan hafalan)
* memory layout (`repr(C)`)
* allocators
* `unsafe` basics
* zero-cost abstraction

---

### Phase 2 — Assembly & ABI

* x86_64 / ARM64
* calling convention
* stack & register usage
* syscall interface
* baca assembly hasil Rust

---

### Phase 3 — OS & Concurrency

* syscalls
* file descriptor
* epoll / io_uring (conceptual)
* threads vs async
* atomics & memory ordering

---

### Phase 4 — Rust Advanced

* `no_std`
* custom allocator
* FFI dengan C
* unsafe pattern yang benar
* benchmarking & profiling

---

## Project-Based Learning (Wajib)

### PBL 1 — Memory Allocator (Rust + unsafe)

* manual heap management
* alignment
* fragmentation
* thread safety

> Ini menggantikan “belajar C malloc” tanpa kehilangan esensi.

---

### PBL 2 — Minimal HTTP Server (Rust, no framework)

* raw socket
* epoll
* zero-copy
* bandingkan dengan Node / Java

---

### PBL 3 — Syscall Explorer

* wrapper syscall manual
* write/read tanpa libc
* inspect assembly output

---

### PBL 4 — Rust + Assembly Integration

* hot path di asm
* measure perf vs pure Rust
* cache behavior

#### next paling berguna:

* daftar **anti-pattern Rust yang sering bikin stuck**
* mapping **Rust → kernel / embedded / high-perf backend**
