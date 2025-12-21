## 🏗️ Build Scalable Performant System
- ☕ **Corework** : C# & Zig | Java Rust
- 🏇🏻 **Workhorse** : NodeJS, Laravel 

### 🏗️ Be Expert Programmer :
+ Minimize stack, maximize leverage
+ Scale-first, Predictable Performance
+ Optimize for long-term maintenance
- Over-minimalism leading to rigidity
- Slow in Raw, duck typing risks
- Limited ecosystem and adoption

> no gap, no pain. depth over breadth. avoid the `master of none` trap.

### Choose and Decision
ada 3 jenis kebutuhan berdasarkan :
- Client Tidak Mengerti Technical
- Client dengan Legacy System
- Client Non Technical, Tapi ngerti Coding (little)

#### 1. Client Non Technical
paling mudah menentukan hal teknis diluar kebutuhan bisnis
#### 2. Client with Legacy System
- Big Pain jika project-nya diluar kapasitas kita, di rewrite salah dilanjutkan salah.
- Tapi jika berani rewrite, ingat beberapa kunci ini : 
    - Incremental Migration: tulis modul baru terisolasi, jangan rewrite full.
    - Anti-Corruption Layer: jaga sistem baru dari bug/keanehan legacy.
    - Test & Benchmark: setiap modul diuji & performanya diukur sebelum produksi.
    - Prioritize Compatibility: backward compatibility > code elegance.
    -  Document Everything: proses, dependency, dan risk mitigation jelas.
> Goal: minimal downtime, mitigasi risiko, delivery aman.
#### 3. Client Non-Technical, Understood Coding
Kita butuh sistem yang menggunakan A, karena B belum tentu capable.


### ⛔ Less Preferred
- 🐹 GC Jitter, Minimalist
- 🐍 Slow in Raw, Duck Typing
- 🕊️ Weak Ecosystem/Adaption
- 🪻 Overhead/Abstraction Leakage