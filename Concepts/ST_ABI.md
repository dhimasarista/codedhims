# Ecosystem Build

Platform seperti Windows dan Unix menyediakan toolchain dasar yang memungkinkan software di-compile, di-link, dan dijalankan. Toolchain ini adalah fondasi yang *mendahului* bahasa pemrograman.Platform seperti Windows dan Unix membutuhkan tool

Bahasa pemrograman seperti C# jika diwindows membutuhkan toolchain seperti MSVC begitu juga Java jika ingin dibuild ke native binary. Bahkan Rust juga menggunakan MSVC walaupun ada opsi GNU yang sama di kernel Unix. Berbeda dengan Zig walaupun sama-sama menggunakan LLVM dengan Rust, tapi Zig bisa compile/build tanpa membutuhkan toolchain tambahan tadi.


| Bahasa        | Compile sendiri | Butuh linker host          | Butuh runtime host   | Self-contained? |
| --------------- | ----------------- | ---------------------------- | ---------------------- | ----------------- |
| C# IL         | Ya              | Tidak (kecuali AOT)        | Ya (.NET runtime)    | Tidak           |
| Java bytecode | Ya              | Tidak                      | Ya (JVM)             | Tidak           |
| Java native   | Ya              | Ya (MSVC/Linux toolchain)  | CRT host             | Tidak           |
| Rust          | Ya              | Ya (MSVC/MinGW/binutils)   | CRT host             | Tidak           |
| Zig           | Ya              | Tidak (pakai LLD internal) | Bisa internal (musl) | **Ya**          |

### **Windows**

* **Windows SDK** → header + libs Win32 API + UCRT
* **MSVC toolchain** → `cl.exe`, `link.exe`, CRT
* **VC Runtime** → runtime C++
* **Clang/LLVM** (opsional) → compiler modern
* **MinGW-w64** (opsional) → GCC untuk Windows
* **CMake + Ninja** → build system mayoritas proyek
* **PowerShell + Win32 tools** → `signtool`, `mt`, `rc`

Jika ingin build ke native binary (C#/Java) setidaknya install visual studio, jika ingin tanpa workload dengan penyimpanan terbatas cukup fokus ke poin berikut :
- Microsoft.VisualStudio.Component.Windows11SDK.22621 
- Microsoft.VisualStudio.Component.VC.Tools.x86.x64
- Microsoft.VisualStudio.Component.VC.Tools.ARM64"

**Inti:** Windows memerlukan kombinasi SDK + native toolchain (MSVC/LLVM/MinGW) untuk build software.

---

### **Linux**

* **glibc atau musl** → C runtime + system ABI
* **GCC / Clang/LLVM** → compiler
* **binutils** → linker (`ld`), assembler, objcopy
* **pkg-config** → dependency resolution
* **make / Ninja**
* **CMake/Meson/Autotools**
* **system headers** dari distro (linux-headers)

**Inti:** Linux toolchain lebih modular, compiler + glibc + binutils sudah cukup sebagai fondasi.
