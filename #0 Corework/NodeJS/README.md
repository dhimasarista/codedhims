# NodeJS

Node.js adalah **runtime environment** berbasis **JavaScript** yang berjalan di luar browser, dibangun di atas mesin **V8** (Google Chrome). Dengan Node.js, JavaScript bisa dipakai bukan hanya untuk frontend, tapi juga untuk **backend** (misalnya membuat API, server, CLI tools).

Beberapa poin penting:

* **Non-blocking & asynchronous** → pakai event-driven I/O, cocok untuk aplikasi dengan banyak koneksi (misalnya chat, API, streaming).
* **Single-threaded** tapi bisa menangani ribuan request secara efisien.
* Banyak ekosistem library lewat **npm** (Node Package Manager).
* Umumnya dipakai untuk **web backend, real-time apps, microservices, dan API-driven development**

### Runtime Alternative (Compatible)

- BunJS → runtime baru, super cepat, berbasis **JavaScriptCore** (engine Safari/Apple).

### ⚡ Web Framework & API

* **AdoniJS** → framework yang mirip dengan laravel-style.
* **Express.js** → framework paling populer, ringan, fleksibel.
* **NestJS** → arsitektur modular, cocok untuk enterprise & API-driven development.
* **Fastify** → performa tinggi, mirip Express tapi lebih cepat.

### ⚙️ Database

* **Sequelize** → ORM untuk SQL (MySQL, PostgreSQL, dll).
* **TypeORM** → ORM dengan dukungan TypeScript yang kuat.
* **Mongoose** → ODM untuk MongoDB.
* **Prisma** → modern ORM dengan schema-first approach.

### 🔒 Security & Auth

* **bcrypt** → hashing password.
* **jsonwebtoken (JWT)** → autentikasi berbasis token.
* **helmet** → middleware keamanan untuk Express/NestJS.

### 📡 Networking & API Calls

* **axios** → HTTP client modern.
* **node-fetch** → fetch API versi Node.js.
* **socket.io** → real-time communication (chat, live updates).

### 📦 Utility & Tools

* **dotenv** → load konfigurasi dari `.env`.
* **lodash** → helper untuk manipulasi data.
* **moment / dayjs** → manipulasi tanggal/waktu.
* **chalk** → styling teks di terminal (warna, bold, dll).

### 🧪 Testing

* **Jest** → testing framework populer.
* **Mocha + Chai** → kombinasi klasik untuk unit testing.
* **Supertest** → testing API/HTTP.

### 🚀 DevOps & Build Tools

* **pm2** → process manager untuk Node.js.
* **nodemon** → auto-restart server saat ada perubahan file.
* **esbuild / webpack / vite** → bundler & build tool.
