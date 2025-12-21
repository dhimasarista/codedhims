## ⚙️ Zig Memory Management
> Aturan utamanya: Siapa yang melakukan alloc, dia yang bertanggung jawab untuk free / destroy.
### Skenario Sederhana
Sebuah Service yang membuat resource dari allocator (misal array, struct, buffer, dsb),
maka Service harus punya fungsi cleanup sendiri, misalnya deinit().

Controller cukup memanggil service.deinit() saat selesai.

#### Service : akan di inject oleh controller
```zig
const Service = struct {
    alloc: std.mem.Allocator,
    buffer: []u8,

    pub fn init(alloc: std.mem.Allocator) !*Service {
        const self = try alloc.create(Service);
        self.* = .{
            .alloc = alloc,
            .buffer = try alloc.alloc(u8, 1024),
        };
        return self;
    }

    pub fn doSomething(self: *Service) void {
        // pakai self.buffer
    }

    pub fn deinit(self: *Service) void {
        self.alloc.free(self.buffer);
        self.alloc.destroy(self);
    }
};
```
#### Controller : bertugas memanggil dealloc
```zig
pub fn controller(alloc: std.mem.Allocator) !void {
    const service = try Service.init(alloc);
    defer service.deinit();

    try service.doSomething();
}
```
### 🔍 Kenapa pattern ini ideal?

- Ownership jelas: Service punya buffer, maka Service juga yang tahu cara cleanup-nya.
- Controller hanya orkestrator: tugasnya cuma memanggil init() dan deinit().
- Aman dari leak: pakai defer service.deinit() memastikan cleanup tetap jalan bahkan kalau ada return atau error.


| Action                  | Function                          | Example                                                                                      | Notes                                                                         |
| ----------------------- | --------------------------------- | -------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| **Allocate (Array)**    | `allocator.alloc(T, n)`           | `const buf = try alloc.alloc(u8, 256);`                                                      | Alokasi `n` elemen bertipe `T` di heap.                                       |
| **Free (Array)**        | `allocator.free(ptr)`             | `allocator.free(buf);`                                                                       | Wajib dipanggil untuk tiap `alloc()`.                                         |
| **Allocate (Single)**   | `allocator.create(T)`             | `const item = try alloc.create(Node);`                                                       | Buat 1 instance struct/class.                                                 |
| **Destroy (Single)**    | `allocator.destroy(ptr)`          | `allocator.destroy(item);`                                                                   | Padanan `free()` untuk hasil `create()`.                                      |
| **Reallocate**          | `allocator.realloc(ptr, new_len)` | `ptr = try alloc.realloc(ptr, 512);`                                                         | Ubah ukuran buffer tanpa kehilangan data (jika muat).                         |
| **Scoped Free**         | `defer allocator.free(ptr)`       | `const data = try alloc.alloc(u8, 64);\ndefer alloc.free(data);\n`                      | Pastikan cleanup otomatis walau `return` atau `error`.                        |
| **Temporary Allocator** | `std.heap.ArenaAllocator`         | `var arena = std.heap.ArenaAllocator.init(alloc);\ndefer arena.deinit();\n`             | Berguna buat alokasi banyak sementara, semua dihapus sekali lewat `deinit()`. |
| **Stack Allocator**     | `std.heap.FixedBufferAllocator`   | `var buf: [1024]u8 = undefined;\nvar fba = std.heap.FixedBufferAllocator.init(&buf);\n` | Alokasi di buffer statis — tanpa `free()`.                                    |
| **Deinit Struct**       | Custom `.deinit()`                | `fn deinit(self: *MyStruct) void {\n  self.alloc.free(self.data);\n}`                   | Bersihkan internal resource sebelum `destroy()`.                              |
| **Error Safety**        | `defer` + `errdefer`              | `errdefer allocator.free(ptr);`                                                              | `errdefer` hanya dieksekusi jika fungsi error.                                |
| **No GC**               | —                                 | —                                                                                            | Zig tidak punya GC, semua resource manual.                                    |
| **Thread-safe alloc**   | `std.heap.ThreadSafeAllocator`    | `var tsa = std.heap.ThreadSafeAllocator.init(base);`                                         | Aman untuk multi-threading.                                                   |

### 🔸 Common Patterns

```zig
const data = try allocator.alloc(u8, 128);
defer allocator.free(data);

const obj = try allocator.create(MyType);
defer allocator.destroy(obj);
```

### 🔸 Common Mistakes

* ❌ Lupa `free()` → memory leak
* ❌ `free()` dua kali → undefined behavior
* ❌ `free()` dari allocator berbeda → runtime crash
* ✅ Gunakan `defer` atau `errdefer` untuk jaminan cleanup

### String Zig
Zig tidak punya tipe string eksplisit, string adalah []u8 (slice) atau array of u8.
Berbeda dengan C#, Java..string adalah immutable reference dan selalu disimpan di heap atau string pool. Sedangkan Zig mutable dan biasanya disimpan di stack dimana ga perlu dibebaskan..tetapi tetap bisa dialokasikan ke heap tentunya dengan cara manual allocate/free.

- Literal → "hello" → tidak free, static memory.
- Slice dari buffer lain → buf[0..4] → tidak free, bukan owner.
- Alloc manual → alloc.alloc / alloc.dupe → harus free.
- Function return allocated string → pemanggil harus free.
---

#### 1. **String literal**

Contoh:

```zig
const s = "hello, world";
const name: []const u8 = "Zig";
```

* Tersimpan di **read-only memory (static data)**.
* **Tidak perlu di-free**.
* Tidak boleh dimodifikasi.

---

#### 2. **Slice yang menunjuk ke memory orang lain**

Contoh:

```zig
const name: []const u8 = someOtherBuffer[0..4];
```

* Ini **tidak meng-own memori**.
* Tidak perlu di-free, karena bukan kita yang allocate.

---

#### 3. **String hasil allocation manual**

Kalau kamu bikin string lewat allocator:

```zig
const allocator = std.heap.page_allocator;

var s = try allocator.alloc(u8, 10);
defer allocator.free(s);

const hello = "Hello";
for (i, c) in hello {
    s[i] = c;
}
```

Atau:

```zig
var s = try allocator.dupe(u8, "hello");
defer allocator.free(s);
```

➡️ **Harus di-free**, karena ini kamu yang allocate.

---

#### 4. **String yang keluar dari functions menggunakan allocator**

Jika function kamu return allocated string:

```zig
fn makeString(allocator: std.mem.Allocator) ![]u8 {
    return try allocator.dupe(u8, "hello");
}
```

Pemanggil harus free:

```zig
const allocator = std.heap.page_allocator;
const s = try makeString(allocator);
defer allocator.free(s);
```

---

# 🧠 Prinsip umum Zig tentang string

Zig pakai konsep **ownership** tanpa GC:

* Kalau kamu **alloc** → kamu **free**.
* Kalau string datang dari **literal**, **const**, atau **slice yang bukan milikmu** → tidak perlu free.
* Kalau kamu **menduplikasi** string (dupe) → kamu harus free.

---

# 🔥 Contoh lengkap

```zig
const std = @import("std");

pub fn main() !void {
    const allocator = std.heap.page_allocator;

    // literal
    const lit = "hello"; // no free

    // allocate
    var dyn = try allocator.dupe(u8, lit);
    defer allocator.free(dyn); // wajib free

    std.debug.print("literal: {s}\n", .{lit});
    std.debug.print("dynamic: {s}\n", .{dyn});
}
```

### Kesimpulan Yang Perlu dan Tidak
| Jenis                      | Disimpan di | Perlu free? | Contoh                               |
| -------------------------- | ----------- | ----------- | ------------------------------------ |
| **Primitif (nilai biasa)** | Stack       | ❌ Tidak     | `var x: i32 = 42;`                   |
| **Array statis**           | Stack       | ❌ Tidak     | `var buf: [64]u8 = undefined;`       |
| **Slice hasil alloc**      | Heap        | ✅ Ya        | `var s = try alloc.alloc(u8, 64);`   |
| **Struct biasa (stack)**   | Stack       | ❌ Tidak     | `var p = Point{ .x = 1, .y = 2 };`   |
| **Struct hasil create()**  | Heap        | ✅ Ya        | `const p = try alloc.create(Point);` |
