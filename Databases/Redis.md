
### **Penjelasan Redis**

Redis (Remote Dictionary Server) adalah penyimpanan data dalam memori yang digunakan sebagai  **key-value store** . Redis sangat cepat dan mendukung berbagai struktur data seperti string, hash, list, set, dan sorted set. Redis sering digunakan untuk caching, antrian, dan publikasi/subskripsi pesan.

 **Fitur Utama Redis** :

1. **Penyimpanan dalam Memori** : Data disimpan langsung di memori (RAM), membuatnya sangat cepat.
2. **Dukungan Struktur Data** : Mendukung string, list, hash, set, sorted set, bitmaps, dan banyak lagi.
3. **Persistensi** : Redis memungkinkan data di-dump ke disk untuk mencegah kehilangan data.
4. **Cluster & Replication** : Mendukung replikasi dan clustering untuk skala besar.

---

### **Perintah Dasar Redis di CLI**

Berikut adalah beberapa perintah CLI Redis beserta penjelasan dan contohnya:

#### **1. Start Redis CLI**

Untuk menggunakan Redis di CLI, pastikan Redis server sudah berjalan. Jalankan:

```bash
redis-cli
```

#### **2. Perintah Dasar**

##### **SET dan GET (Menyimpan dan Mengambil Data)**

* **SET** : Menyimpan nilai dengan key tertentu.
* **GET** : Mengambil nilai dari key tertentu.

```bash
# Simpan nilai
SET nama "Dhimas"

# Ambil nilai
GET nama
# Output: "Dhimas"
```

---

##### **3. DELETE (Menghapus Data)**

```bash
# Hapus data
DEL nama

# Cek apakah data masih ada
GET nama
# Output: (nil)
```

---

##### **4. LIST (Menyimpan Data dalam List)**

Redis mendukung list (antrian). Anda bisa menambahkan item ke depan atau belakang.

```bash
# Tambahkan data ke list
LPUSH tasks "task1"
LPUSH tasks "task2"
RPUSH tasks "task3"

# Ambil semua data dari list
LRANGE tasks 0 -1
# Output: 
# 1) "task2"
# 2) "task1"
# 3) "task3"

# Ambil item pertama
LPOP tasks
# Output: "task2"
```

---

##### **5. HASH (Menyimpan Data Key-Value dalam Key Lainnya)**

Hash adalah key yang menyimpan pasangan key-value.

```bash
# Tambahkan data ke hash
HSET user:1 nama "Dhimas"
HSET user:1 usia "25"

# Ambil data dari hash
HGET user:1 nama
# Output: "Dhimas"

# Ambil semua pasangan key-value
HGETALL user:1
# Output:
# 1) "nama"
# 2) "Dhimas"
# 3) "usia"
# 4) "25"
```

---

##### **6. SET (Kumpulan Data Unik)**

Set adalah struktur data yang menyimpan elemen unik.

```bash
# Tambahkan elemen ke set
SADD fruits "apple"
SADD fruits "banana"
SADD fruits "apple" # Duplikat tidak akan ditambahkan

# Ambil semua elemen di set
SMEMBERS fruits
# Output:
# 1) "apple"
# 2) "banana"

# Hapus elemen dari set
SREM fruits "banana"

# Cek anggota set
SISMEMBER fruits "apple"
# Output: 1 (true)
```

---

##### **7. Sorted Set (Set dengan Urutan dan Skor)**

Sorted set menyimpan elemen unik dengan skor.

```bash
# Tambahkan elemen dengan skor
ZADD leaderboard 100 "player1"
ZADD leaderboard 150 "player2"
ZADD leaderboard 120 "player3"

# Ambil elemen berdasarkan skor
ZRANGE leaderboard 0 -1 WITHSCORES
# Output:
# 1) "player1"
# 2) "100"
# 3) "player3"
# 4) "120"
# 5) "player2"
# 6) "150"
```

---

##### **8. EXPIRE (Set Waktu Kadaluarsa)**

Key dapat diatur agar otomatis dihapus setelah waktu tertentu.

```bash
# Set key dengan waktu kadaluarsa 10 detik
SET session "active"
EXPIRE session 10

# Cek waktu tersisa
TTL session
# Output: 8 (misalnya 8 detik tersisa)

# Tunggu 10 detik, kemudian coba GET
GET session
# Output: (nil)
```

---

##### **9. PUBLISH & SUBSCRIBE (Pub/Sub)**

Redis mendukung sistem **Publish/Subscribe** untuk mengirim dan menerima pesan.

```bash
# Terminal 1: Subscribe ke channel
SUBSCRIBE news

# Terminal 2: Publish pesan ke channel
PUBLISH news "Breaking News: Redis is amazing!"
# Output di Terminal 1: 
# 1) "message"
# 2) "news"
# 3) "Breaking News: Redis is amazing!"
```

---

##### **10. KEYS (Mencari Semua Key)**

```bash
# Menampilkan semua key
KEYS *
# Output: Daftar key yang ada di Redis
```

---

### **Tips Penting:**

* Gunakan Redis hanya untuk data yang membutuhkan kecepatan tinggi (cache, sesi, dll.).
* Redis CLI sangat kuat untuk debugging.
* Pastikan Redis terkonfigurasi dengan benar jika digunakan dalam aplikasi produksi (seperti dengan password, clustering, dll.).

Jika Anda memiliki pertanyaan atau butuh bantuan lebih lanjut, beri tahu saya! 😊
