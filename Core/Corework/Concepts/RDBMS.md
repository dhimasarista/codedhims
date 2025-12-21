# Relational Database Management System

## Database Design (High-Level)

Saat merancang RDBMS, fokusnya bukan pada “pakai PostgreSQL atau MySQL”, tapi *bagaimana* struktur data dibentuk agar konsisten, predictable, dan scalable. Pilar desain fundamental:

### 1) **Unique ID (Non-Guessable Identifiers)**

Setiap tabel wajib punya **ID unik** (UUID, ULID, Snowflake).
Tujuan: global uniqueness, aman untuk public-facing API, tidak bisa ditebak.

**Contoh struktur:**

```
User
- id
- email
- created_at
- deleted_at (soft delete)
```

---

### 2) **Soft Deletes (deleted_at atau is_deleted)**

Data tidak langsung dihapus, tetapi ditandai sebagai tidak aktif.
Tujuan: audit, recovery, keamanan, menjaga integritas relasi.

**Contoh:**

```
Article
- id
- title
- content
- deleted_at   // null = aktif
```

---

### 3) **One-to-One (1:1)**

Satu entitas punya satu pasangan unik.
Biasanya dipakai untuk data yang sifatnya opsional atau memanjang (extends data).

```
User
- id
- email

UserProfile
- id
- user_id (unique)
- full_name
- bio
```

---

### 4) **One-to-Many (1:N)**

Satu entitas memiliki banyak turunan.

```
User
- id
- email

Order
- id
- user_id
- total
- status
```

Use case: transaksi, log, aktivitas.

---

### 5) **Many-to-Many (N:N)**

Kedua entitas bisa memiliki banyak pasangan.
Selalu pakai **join table**—kalau tidak, desainnya pasti salah.

```
Post
- id
- title

Tag
- id
- name

PostTag
- post_id
- tag_id
```

---

### 6) **Timestamps (created_at, updated_at)**

Memberikan jejak historis waktu. Penting untuk query temporal, debugging, audit.

---

### 7) **Normalization (but not religiously)**

Pisahkan data agar tidak redundant.
Gabungkan kembali jika performa jadi masalah.
Aturannya sederhana:

* Normalize dulu → Hindari duplikasi liar
* Denormalize hanya jika benar-benar perlu

---

### 8) **Indexing (the silent performance multiplier)**

Index pada kolom: id, foreign key, unique key, timestamp untuk sorting.
Tanpa index, relasi dan query lambat.

---

### 9) **Relational Integrity**

Tujuan RDBMS adalah **consistency**, jadi relasi harus eksplisit, bukan “diasumsikan”.

Prinsip dasar:

* Setiap relasi harus punya foreign key
* Jangan biarkan orphan data
* Gunakan cascading delete hanya jika benar-benar aman

### 10) **Bad Practices**

Kesalahan klasik yang terlihat “aman” di awal, tapi mematikan saat sistem tumbuh.

* **N+1 Query**

  Terjadi ketika kamu mengambil parent → lalu query child berkali-kali.

  Gejala: load lambat, query ratusan tanpa alasan.
* **No Foreign Keys**

  Mengandalkan “kepercayaan” antar tabel. Akibatnya: orphan records, inkonsistensi data, migrasi berantakan.
* **Using Natural Keys**

  Menggunakan email, username, atau nomor HP sebagai primary key. Buruk untuk keamanan, tidak stabil, sulit di-refactor.
* **Storing Non-Atomic Fields**

  Satu field berisi banyak data (CSV dalam kolom). Sulit di-query, tidak bisa di-index.
* **Too Many Nullables Without Thought**

  Kolom null di mana-mana berarti desain tidak jelas. Nullable harus punya alasan, bukan default.
* **Over-Normalizing**

  Tabel sampai pecah jadi 10 layer hanya untuk “kemurnian teori”. Query jadi kompleks tanpa manfaat nyata.
* **Under-Normalizing**

  Semua data dicampur dalam 1–2 tabel. Tidak scalable, sulit migrate, query tidak efisien.
* **Storing Unindexed Timestamps for Sorting**

  Query time-series tanpa index = database terbakar.
* **Mixing Soft Delete + Hard Delete Tanpa Aturan**

  Berakhir dengan data hilang acak dan relasi patah.
