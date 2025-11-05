# Typescript Programming Language

    ![TypeScript Variables and Data types | by Krishnakumar | Medium](https://miro.medium.com/v2/resize:fit:750/1*C14KuH1nAoQTGQA_mZMQjg.jpeg)

TypeScript adalah superset dari JavaScript yang dikembangkan oleh Microsoft. TypeScript menambahkan static typing (tipe data statis) serta fitur OOP dan modularisasi yang lebih kuat, menjadikannya lebih aman dan terstruktur untuk proyek skala besar. Kode TypeScript dikompilasi menjadi  JavaScript standar , sehingga bisa berjalan di browser atau lingkungan  Node.js, Bun, Deno , dan runtime lainnya.

### Sejarah dan Creator TypeScript

* Dikembangkan oleh: Microsoft
* Dibuat oleh: Anders Hejlsberg (juga pencipta C# dan arsitek utama Delphi).
* Rilis pertama: 1 Oktober 2012
* Tujuan utama: Mempermudah pengembangan JavaScript skala besar dengan fitur  static typing ,  interface ,  OOP , dan  better tooling .

### Runtime yang Mendukung TypeScript

Karena TypeScript dikompilasi menjadi JavaScript, ia bisa berjalan di berbagai runtime, termasuk:

| Runtime         | Deskripsi                                                                        |
| --------------- | -------------------------------------------------------------------------------- |
| Node.js         | Runtime JavaScript berbasis V8, paling umum digunakan.                           |
| Deno            | Runtime modern berbasis V8, dibuat oleh Ryan Dahl (pencipta Node.js).            |
| Bun             | Runtime cepat berbasis JavaScriptCore (JSC), dioptimalkan untuk performa tinggi. |
| Browser         | TypeScript dikompilasi ke JavaScript, sehingga bisa dijalankan di browser.       |
| Cloud Functions | Bisa digunakan dalam AWS Lambda, Google Cloud Functions, dan Azure Functions.    |

TypeScript semakin populer karena mendukung  typed JavaScript , mempermudah debugging, dan meningkatkan keandalan kode dalam pengembangan aplikasi modern. 🚀

## 1. Data Types

| Tipe              | Deskripsi                                                     | Contoh                                                                         |
| ----------------- | ------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| Primitive         | Tipe data dasar bawaan TS.                                    | `string`,`number`,`boolean`,`symbol`,`bigint`                        |
| Special Types     | Tipe khusus dengan perilaku unik.                             | `any`,`unknown`,`never`,`undefined`,`null`                           |
| Array             | Kumpulan nilai dengan tipe yang sama.                         | `number[]`,`Array<string>`                                                 |
| Tuple             | Array dengan panjang tetap dan tipe berbeda di setiap indeks. | `[string, number] = ["Dhimas", 22]`                                          |
| Enum              | Kumpulan nilai konstan yang diberi nama.                      | `enum Role { Admin, User }`                                                  |
| Object            | Struktur data yang berisi properti dengan tipe tertentu.      | `{ name: string; age: number }`                                              |
| Function          | Menentukan tipe parameter dan return dari sebuah fungsi.      | `(x: number, y: number) => number`                                           |
| Union Type        | Variabel bisa memiliki lebih dari satu tipe data.             | ``let value: string \| number``                                                 |
| Intersection Type | Menggabungkan beberapa tipe menjadi satu.                     | `type Employee = Person & { salary: number }; // Harus punya semua properti` |
| Literal Type      | Variabel hanya bisa memiliki nilai tertentu.                  | ``let status: "success" \| "error" \| "loading";``                               |
| Type Alias        | Memberi nama baru untuk tipe data.                            | type UserID = string                                                           |
| Mapped Types      | Membuat tipe baru berdasarkan tipe yang sudah ada.            | `type PartialUser = { [K in keyof User]?: User[K] };`                        |

## 2. Data Items

* Variables: let, var
* Constant: const

## 3. Data Types

| Kategori             | Struktur Data           | Deskripsi                                                                                                   | Contoh                                                                                 |
| -------------------- | ----------------------- | ----------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| Array                | `Array<T>`            | Struktur data untuk menyimpan daftar nilai sejenis.                                                         | `let numbers: number[] = [1, 2, 3];`                                                 |
| Tuple                | `[T1, T2, ...]`       | Array dengan panjang tetap dan tipe tetap per indeks.                                                       | `let person: [string, number] = ["Dhimas", 25];`                                     |
| Object               | `{ key: value }`      | Struktur data berbasis key-value.                                                                           | `let user: { name: string; age: number; } = { name: "Dhimas", age: 25 };`            |
| Set                  | `Set<T>`              | Struktur data yang hanya menyimpan nilai unik.                                                              | `let uniqueNumbers = new Set<number>([1, 2, 3]);`                                    |
| Map                  | `Map<K, V>`           | Struktur data berbasis key-value, mendukung tipe key yang fleksibel.                                        | `let users = new Map<number, string>(); users.set(1, "Dhimas");`                     |
| WeakSet              | `WeakSet<T>`          | Mirip `Set`, tetapi hanya menyimpan referensi ke objek dan tidak mencegah garbage collection.             | `let objSet = new WeakSet<object>(); let obj = {}; objSet.add(obj);`                 |
| WeakMap              | `WeakMap<K, V>`       | Mirip `Map`, tetapi hanya menyimpan referensi ke objek sebagai key dan tidak mencegah garbage collection. | `let objMap = new WeakMap<object, string>(); let obj = {}; objMap.set(obj, "data");` |
| Stack (Custom)       | `class Stack<T>`      | Struktur data LIFO (Last In, First Out).                                                                    | Implementasi menggunakan `class`                                                     |
| Queue (Custom)       | `class Queue<T>`      | Struktur data FIFO (First In, First Out).                                                                   | Implementasi menggunakan `class`                                                     |
| Linked List (Custom) | `class LinkedList<T>` | Struktur data berbasis node yang saling terhubung.                                                          | Implementasi menggunakan `class`                                                     |
| Graph (Custom)       | `class Graph<T>`      | Struktur data yang menyimpan node dan edge untuk merepresentasikan hubungan antar elemen.                   | Implementasi menggunakan `class`                                                     |
| Tree (Custom)        | `class TreeNode<T>`   | Struktur data hierarkis dengan node induk dan anak.                                                         | Implementasi menggunakan `class`                                                     |

## 4. Control Flows

### 1. Conditional Statements)

| Jenis           | Deskripsi                                                        | Contoh                                                                                                                                                           |
| --------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `if`          | Mengeksekusi blok kode jika kondisi bernilai `true`.           | `let x = 10; if (x > 5) { console.log("Lebih besar dari 5"); } `                                                                                               |
| `if...else`   | Menjalankan kode alternatif jika kondisi `false`.              | `if (x > 10) { console.log("Lebih besar dari 10"); } else { console.log("10 atau kurang"); } `                                                                 |
| `else if`     | Mengecek beberapa kondisi bertingkat.                            | `if (x > 15) { console.log("Lebih besar dari 15"); } else if (x > 10) { console.log("Lebih besar dari 10"); } else { console.log("10 atau kurang"); } `        |
| `switch`      | Memilih satu dari banyak kemungkinan berdasarkan nilai variabel. | `let color = "red"; switch (color) { case "red": console.log("Merah"); break; case "blue": console.log("Biru"); break; default: console.log("Warna lain"); } ` |
| Ternary `? :` | Alternatif pendek dari `if...else`.                            | `let age = 18; let status = age >= 18 ? "Dewasa" : "Anak-anak"; `                                                                                              |

### 2. Loopings

| Jenis          | Deskripsi                                                 | Contoh                                                                                              |
| -------------- | --------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `for`        | Loop dengan jumlah iterasi tetap.                         | `for (let i = 0; i < 5; i++) { console.log(i); } `                                                |
| `while`      | Loop selama kondisi bernilai `true`.                    | `let i = 0; while (i < 5) { console.log(i); i++; } `                                              |
| `do...while` | Sama seperti `while`, tetapi dijalankan minimal sekali. | `let i = 0; do { console.log(i); i++; } while (i < 5); `                                          |
| `for...in`   | Loop melaluikeydalam objek.                               | `let user = { name: "Dhimas", age: 25 }; for (let key in user) { console.log(key, user[key]); } ` |
| `for...of`   | Loop melaluielemendalam array atau iterable.              | `let arr = [1, 2, 3]; for (let num of arr) { console.log(num); } `                                |

### 3. Control Flow Modifiers

| Jenis        | Deskripsi                                                    | Contoh                                                                      |
| ------------ | ------------------------------------------------------------ | --------------------------------------------------------------------------- |
| `break`    | Menghentikan loop atau `switch`lebih awal.                 | `for (let i = 0; i < 10; i++) { if (i === 5) break; console.log(i); } `   |
| `continue` | Melompati iterasi saat ini dan lanjut ke iterasi berikutnya. | `for (let i = 0; i < 5; i++) { if (i === 2) continue; console.log(i); } ` |

## 4. Functional Programming

1. ### Function Biasa

   Function dengan parameter dan return type yang jelas.


   ```ts
   function greet(name: string): string {
       return `Hello, ${name}`;
   }
   console.log(greet("Dhimas")); // Hello, Dhimas
   ```
2. ### Arrow Function

   Sintaks lebih ringkas dibanding function biasa.


   ```ts
   const add = (a: number, b: number): number => a + b;
   console.log(add(5, 3)); // 8
   ```
3. ### Anonymous Function

   Function tanpa nama, bisa disimpan dalam variabel.


   ```ts
   const multiply = function (a: number, b: number): number {
       return a * b;
   };
   console.log(multiply(4, 2)); // 8
   ```
4. ### Function dengan Default Parameter

   Parameter bisa memiliki nilai default jika tidak diisi.


   ```ts
   function sayHello(name: string = "Guest") {
       console.log(`Hello, ${name}`);
   }
   sayHello(); // Hello, Guest
   sayHello("Dhimas"); // Hello, Dhimas
   ```
5. ### Function dengan Rest Parameter

   Bisa menerima banyak parameter dalam bentuk array.


   ```ts
   function sum(...numbers: number[]): number {
       return numbers.reduce((total, num) => total + num, 0);
   }
   console.log(sum(1, 2, 3, 4)); // 10
   ```
6. ### Function Overload

   Function yang bisa menerima berbagai tipe input dan mengembalikan hasil berbeda.


   ```ts
   function getValue(x: string): string;
   function getValue(x: number): number;
   function getValue(x: any): any {
       return x;
   }
   console.log(getValue("Hello")); // "Hello"
   console.log(getValue(123)); // 123
   ```
7. ### Callback Function

   Function yang digunakan sebagai parameter untuk function lain.


   ```ts
   function processData(data: number[], callback: (num: number) => void) {
       data.forEach(callback);
   }
   processData([1, 2, 3], (num) => console.log(num * 2));
   // Output: 2, 4, 6
   ```
8. ### Async/Await Function

   Function yang bekerja secara asynchronous.


   ```ts
   async function fetchData(): Promise<string> {
       return new Promise((resolve) => {
           setTimeout(() => resolve("Data fetched!"), 2000);
       });
   }
   fetchData().then(console.log); // Data fetched! (setelah 2 detik)
   ```

## 5. Object Oriented Programming

### 1. Object

Object adalah data yang berisi field / properties / attributes dan method / function / behavior. Model data berorientasi objek dikatakan dapat memberi fleksibilitas yang lebih, kemudahan mengubah program, dan digunakan luas dalam software engineering skala besar. Lebih jauh lagi, pendukung OOP mengklaim bahwa OOP lebih mudah dipelajari bagi pemula dibanding dengan pendekatan sebelumnya, dan pendekatan OOP lebih mudah dikembangkan dan dirawat.

> Object disini bukan tipe data key-value bawaan JS/TS, tapi object yang sama dengan bahasa pemrograman lain seperti C# atau Java.

4 Pilar OOP: Encapsulation, Abstraction, Inheritance, Polymorphism:

- Encapsulation adalah kondisi di mana status atau kondisi di dalam class, dibungkus dan bersifat privat.
- Abstraction berarti sebuah objek hanya menunjukkan operasinya secara high-level.
- Inheritance adalah pewarisan sebuah object dari object utama.
- Polymorphism dalam bahasa Yunani berarti “banyak bentuk.” Sederhananya objek dapat memiliki bentuk atau implementasi yang berbeda-beda pada satu metode yang sama.

### 2. Class

Class adalah blueprint untuk membuat objek.

```ts
class User {
    name: string;
    age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }
}
const person = new User("Dhimas", 25);
console.log(person.name); // Dhimas
```

### 3. Property & Method

Property adalah atribut, method adalah function dalam class.

```ts
class Car {
    brand: string;

    constructor(brand: string) {
        this.brand = brand;
    }

    drive() {
        console.log(`${this.brand} is driving`);
    }
}
const myCar = new Car("Toyota");
myCar.drive(); // Toyota is driving
```

### 4. Access Modifier

Mengontrol akses property dan method.

* `public` → (Default) Bisa diakses dari mana saja.
* `private` → Hanya bisa diakses dalam class itu sendiri.
* `protected` → Bisa diakses dalam class itu sendiri dan subclass.
* `readonly` → Hanya bisa diinisialisasi sekali dan tidak bisa diubah.
* `declare` → Digunakan untuk mendeklarasikan variabel atau properti tanpa memberikan implementasi, biasanya dalam definisi tipe atau ambient declaration.

```ts
class Person {
    public name: string;
    private age: number;
    protected gender: string;

    constructor(name: string, age: number, gender: string) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
const p = new Person("Dhimas", 25, "Male");
console.log(p.name); // ✅ Bisa diakses
// console.log(p.age); // ❌ Error (private)
// console.log(p.gender); // ❌ Error (protected)
```

### 5. Enkapsulasi

Menyembunyikan detail internal dan hanya mengekspos yang perlu.

```ts
class BankAccount {
    private balance: number = 0;

    deposit(amount: number) {
        this.balance += amount;
    }

    getBalance(): number {
        return this.balance;
    }
}
const account = new BankAccount();
account.deposit(100);
console.log(account.getBalance()); // 100
```

### 6. Constructor

Method khusus yang dipanggil saat objek dibuat.

```ts
class Animal {
    constructor(public name: string) {
        console.log(`${name} created`);
    }
}
const dog = new Animal("Dog"); // Dog created
```

### 7. Variable Shadowing

Terjadi ketika variabel dalam method memiliki nama yang sama dengan property class.

```ts
class Example {
    name: string = "Class Name";

    printName(name: string) {
        console.log(name); // Variabel lokal
        console.log(this.name); // Property class
    }
}
const e = new Example();
e.printName("Local Name");
// Output: 
// Local Name
// Class Name
```

### 8. Inheritance

Mewarisi property dan method dari class lain.

```ts
class Animal {
    constructor(public name: string) {}

    makeSound() {
        console.log("Some sound...");
    }
}

class Dog extends Animal {
    makeSound() {
        console.log("Woof!");
    }
}

const dog = new Dog("Bulldog");
dog.makeSound(); // Woof!
```

### 9. Abstract Class

Tidak bisa diinstansiasi langsung, hanya bisa diwarisi.

```ts
abstract class Shape {
    abstract getArea(): number;
}

class Circle extends Shape {
    constructor(public radius: number) {
        super();
    }

    getArea(): number {
        return Math.PI * this.radius ** 2;
    }
}
const c = new Circle(5);
console.log(c.getArea()); // 78.54
```

### 10. Enumerated Types (Enum)

Tipe data khusus dengan nilai tetap.

```ts
enum Color {
    Red = "Red",
    Green = "Green",
    Blue = "Blue"
}
console.log(Color.Red); // Red
```

### 11. Extension Method

Menambahkan method ke class yang sudah ada.

```ts
class Person {
    constructor(public name: string) {}
}

(Person.prototype as any).greet = function() {
    console.log(`Hello, my name is ${this.name}`);
};

const p = new Person("Dhimas");
(p as any).greet(); // Hello, my name is Dhimas
```

### 12. Base Keyword (`super`)

Memanggil method dari parent class.

```ts
class Parent {
    greet() {
        console.log("Hello from Parent");
    }
}

class Child extends Parent {
    greet() {
        super.greet(); // Memanggil method parent
        console.log("Hello from Child");
    }
}
const c = new Child();
c.greet();
// Output:
// Hello from Parent
// Hello from Child
```

### 13. Polymorphism

Method dengan nama yang sama bisa memiliki perilaku berbeda.

```ts
class Animal {
    makeSound() {
        console.log("Animal sound");
    }
}

class Cat extends Animal {
    makeSound() {
        console.log("Meow");
    }
}

const animals: Animal[] = [new Animal(), new Cat()];
animals.forEach(a => a.makeSound());
// Output:
// Animal sound
// Meow
```

### 14. Meta Programming (`Proxy`)

Mengubah perilaku objek secara dinamis.

```ts
const user = {
    name: "Dhimas",
    age: 25
};

const proxy = new Proxy(user, {
    get(target, prop) {
        console.log(`Accessing property: ${String(prop)}`);
        return target[prop as keyof typeof target];
    }
});

console.log(proxy.name); // Accessing property: name -> Dhimas
```

### 15. Static Property & Method

Dapat diakses tanpa perlu membuat instance dari class.

```ts
class MathUtil {
    static PI: number = 3.14;

    static add(a: number, b: number): number {
        return a + b;
    }
}
console.log(MathUtil.PI); // 3.14
console.log(MathUtil.add(2, 3)); // 5
```

### 16. Metadata (`Reflect API`)

Menggunakan Reflect Metadata untuk menambahkan metadata ke class/method.

```ts
import "reflect-metadata";

class Example {
    @Reflect.metadata("info", "This is a test")
    test() {}
}

const meta = Reflect.getMetadata("info", Example.prototype, "test");
console.log(meta); // This is a test
```

## 6. Error Handling

### 1. Try-Catch-Finally

Gunakan `try...catch` untuk menangani error runtime.

```ts
try {
    throw new Error("Terjadi kesalahan!");
} catch (error) {
    console.error("Error:", error.message);
} finally {
    console.log("Blok finally selalu dieksekusi.");
}
```

### 2. Custom Error Class

Membuat error khusus dengan inheritance dari `Error`.

```ts
class ValidationError extends Error {
    constructor(message: string) {
        super(message);
        this.name = "ValidationError";
    }
}

try {
    throw new ValidationError("Data tidak valid!");
} catch (error) {
    if (error instanceof ValidationError) {
        console.error("Validation Error:", error.message);
    }
}
```

### 3. Optional Catch Binding (TS 3.7)

Jika tidak membutuhkan error, `catch` bisa dikosongkan.

```ts
try {
    throw new Error("Kesalahan!");
} catch {
    console.log("Terjadi error.");
}
```

### 4. Handling Asynchronous Errors

Menggunakan `async/await` dengan `try...catch`.

```ts
async function fetchData() {
    try {
        let response = await fetch("https://api.example.com/data");
        let data = await response.json();
        console.log(data);
    } catch (error) {
        console.error("Gagal mengambil data:", error);
    }
}
fetchData();
```

### 5. Global Error Handling

Menangani error yang tidak tertangkap (`Unhandled Errors`).

```ts
window.onerror = function (message, source, lineno, colno, error) {
    console.error("Global Error:", message);
};

throw new Error("Global error test!");
```

### 6. Never Type untuk Error

Tipe `never` digunakan jika function tidak akan mengembalikan nilai (contoh: error).

```ts
function throwError(message: string): never {
    throw new Error(message);
}
```

## 7. Concurency Programming

Konkurensi berarti menjalankan beberapa tugas secara bersamaan tanpa harus selesai satu per satu. Tetapi secara default di Node.js, semua kode tetap berjalan dalam satu thread utama (Event Loop).

### 1. Asynchronous (Asinkron)

Asinkron berarti eksekusi kode tidak harus menunggu satu sama lain . Ini memungkinkan operasi seperti I/O (membaca file, request ke API, database query) tidak memblokir thread utama.

🔹 Callback (Pendekatan Lama)

Sebelum ada Promise & Async/Await, callback digunakan untuk menangani tugas asinkron.

```ts
import fs from "fs";

fs.readFile("file.txt", "utf8", (err, data) => {
    if (err) return console.error("Gagal membaca file:", err);
    console.log("Isi file:", data);
});
```

🚨 Masalah utama: Callback Hell dan kode sulit dibaca.

🔹 Promise (Mengatasi Callback Hell)

Promise memberikan cara yang lebih bersih untuk menangani asinkron.

```ts
const fetchData = (): Promise<string> => {
    return new Promise((resolve) => {
        setTimeout(() => resolve("Data berhasil diambil!"), 2000);
    });
};

fetchData()
    .then((data) => console.log(data))
    .catch((err) => console.error("Error:", err));
```

✅  Promise membuat kode lebih terstruktur , tetapi `.then()` chaining masih bisa menjadi panjang.

🔹 Async/Await (Pendekatan Modern)

Async/Await membuat kode lebih mudah dibaca & ditulis.

```ts
const fetchData = async (): Promise<string> => {
    return new Promise((resolve) => {
        setTimeout(() => resolve("Data berhasil diambil!"), 2000);
    });
};

const getData = async () => {
    try {
        const data = await fetchData();
        console.log(data);
    } catch (error) {
        console.error("Error:", error);
    }
};

getData();
```

### 2. Paralelisme (Parallelism)

Paralelisme berarti beberapa tugas benar-benar berjalan bersamaan di beberapa core CPU. Node.js secara default berjalan dalam satu thread, tetapi kita bisa menggunakan:

* Worker Threads (Multi-threading).
* Cluster (Menjalankan beberapa instance aplikasi).
* PM2 (Process Manager untuk scaling).

Paralelisme dengan Worker Threads (Multi-threading di Node.js) Worker Threads digunakan untuk menjalankan tugas CPU-heavy secara paralel.

```ts
import { Worker, isMainThread, parentPort } from "worker_threads";

if (isMainThread) {
    const worker = new Worker(__filename);
    worker.on("message", (message) => console.log("Dari Worker:", message));
} else {
    parentPort?.postMessage("Halo dari worker!");
}
```

Paralelisme dengan Cluster (Menjalankan Banyak Process). Cluster memungkinkan kita memanfaatkan semua core CPU dengan membuat beberapa process.

```ts
import cluster from "cluster";
import { cpus } from "os";
import http from "http";

if (cluster.isPrimary) {
    cpus().forEach(() => cluster.fork());
} else {
    http.createServer((req, res) => {
        res.writeHead(200);
        res.end("Server berjalan di worker " + process.pid);
    }).listen(3000);
}
```

Scaling dengan PM2 memungkinkan scaling otomatis untuk aplikasi Node.js.

```sh
pm2 start app.js -i max  # Menjalankan di semua core CPU
pm2 list                 # Melihat daftar process
pm2 stop all             # Menghentikan semua process
```

## 8. Generic

Generic memungkinkan kita membuat fungsi, kelas, atau interface yang dapat bekerja dengan berbagai tipe data tanpa kehilangan keamanan tipe (type safety).

1. Generic pada Fungsi

Generic pada fungsi memungkinkan parameter dan return type menyesuaikan tipe yang diberikan saat pemanggilan.

```ts
function identity<T>(value: T): T {
    return value;
}

console.log(identity<number>(10));  // Output: 10
console.log(identity<string>("Hello"));  // Output: Hello
```

* `T` adalah tipe parameter yang bisa diganti dengan tipe apa pun saat dipanggil.
* Bisa ditulis sebagai `identity<number>(10)` atau langsung `identity(10)`, karena TypeScript bisa inference tipe otomatis.

2. Generic pada Interface

Interface dengan generic memungkinkan fleksibilitas dalam menentukan tipe data saat digunakan.

```ts
interface Box<T> {
    value: T;
}

const numberBox: Box<number> = { value: 100 };
const stringBox: Box<string> = { value: "Text" };
```

* `Box<T>` bisa berisi tipe apa saja, seperti `number` atau `string`.

3. Generic pada Class

Kelas generic memungkinkan pembuatan struktur data yang fleksibel dan reusable.

```ts
class DataStorage<T> {
    private data: T[] = [];

    add(item: T) {
        this.data.push(item);
    }

    getAll(): T[] {
        return this.data;
    }
}

const numberStorage = new DataStorage<number>();
numberStorage.add(5);
console.log(numberStorage.getAll()); // Output: [5]
```

* `DataStorage<T>` bisa digunakan dengan berbagai tipe (`number`, `string`, dll.).

4. Generic dengan Batasan (Constraints)

Bisa membatasi tipe yang diperbolehkan dengan `extends`.

```ts
function getLength<T extends { length: number }>(item: T): number {
    return item.length;
}

console.log(getLength("Hello"));  // Output: 5
console.log(getLength([1, 2, 3]));  // Output: 3
// console.log(getLength(10)); // Error: number tidak memiliki property length
```

* `T extends { length: number }` memastikan `T` hanya bisa berupa tipe yang punya property `length` (seperti `string`, `array`).

5. Generic dengan Default Type

Bisa memberikan tipe default jika tidak ada tipe yang ditentukan.

```ts
interface ResponseData<T = string> {
    data: T;
}

const response1: ResponseData = { data: "Success" }; // Default string
const response2: ResponseData<number> = { data: 200 }; // Override default ke number
```

* Jika tidak diberikan tipe, `T` otomatis menjadi `string`.

## 9. Module & Package

TypeScript menggunakan sistem ES Modules (ECMAScript Modules) untuk mengelola file dan modul.

### 1. Exporting (Mengekspor)

Untuk menggunakan kode dari file lain, kita harus mengekspor variabel, fungsi, atau class.

Export Named: Ekspor beberapa nilai secara terpisah.

```ts
// file: mathUtils.ts
export function add(a: number, b: number): number {
    return a + b;
}

export const PI = 3.14;
```

Export Default: Ekspor satu nilai utama dari suatu file.

```ts
// file: logger.ts
export default function log(message: string): void {
    console.log(message);
}
```

### 2. Importing (Mengimpor)

Untuk menggunakan kode yang telah diekspor.

Import Named: Harus menggunakan nama yang sama dengan ekspor.

```ts
// file: app.ts
import { add, PI } from "./mathUtils";

console.log(add(3, 4)); // Output: 7
console.log(PI); // Output: 3.14
```

Import Default: Bisa menggunakan nama apa saja.

```ts
// file: app.ts
import log from "./logger";

log("Hello, TypeScript!"); // Output: Hello, TypeScript!
```

#### Import Semua (Wildcard `*`)

Mengimpor semua ekspor dari suatu modul ke dalam satu objek.

```ts
import * as MathUtils from "./mathUtils";

console.log(MathUtils.add(5, 2)); // Output: 7
console.log(MathUtils.PI); // Output: 3.14
```

### 3. Package Management di TypeScript

Untuk mengelola dependency, TypeScript menggunakan npm atau  yarn , sama seperti JavaScript.
