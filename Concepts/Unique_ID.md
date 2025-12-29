# Unique Identifiers

Kita tahu database secara default menggunakan incremental integer sebagai primary key. Tidak ada masalah selama sistem masih satu server, satu instance, satu database. Tetapi begitu kamu bicara soal scale-up atau scale-out, integer autoincrement berubah dari solusi simpel menjadi bottleneck.

* **Autoincrement adalah global contention point** : Satu sequence harus dikelola oleh satu node. Begitu kamu punya banyak writer, sequence jadi choke-point.
* **Tidak bisa melakukan multi-region writes** : Dua region tidak bisa menghasilkan angka berurutan tanpa koordinasi—dan koordinasi = latency + fragility.
* **Tidak cocok untuk event sourcing, message streams, atau distributed logs** : Ordering harus punya konteks, bukan sekadar angka dari satu DB.
* **Masalah keamanan (ID enumeration)** : Incremental IDs mudah ditebak. Untuk API publik, itu fatal.

Unique identifiers (UUID, ULID, TSID, Snowflake, KSUID, NanoID, dsb.) adalah cara untuk memberi *identity* pada entitas di sistem terdistribusi. Pilihan format memengaruhi: ordering, storage cost (index bloat), collision risk, operational complexity, dan interoperabilty.

## Usecase Unique ID

* **Database PK/FK** - hindari global sequence bottleneck dan collision saat scale-out.
* **Event Streams (Kafka/Pulsar/NATS)** - ordering, dedup, partition key; tanpa ID ini event chaos.
* **Distributed Tracing (trace-id/span-id)** - supaya satu request bisa diikuti lintas service.
* **Caching** - cache key deterministik; tanpa unique key, invalidation berantakan.
* **Object Storage / Filename** - mencegah file overwrite, race condition, dan tabrakan antar upload.
* **Message Brokers** - idempotency key untuk mencegah double-processing.
* **Frontend/Client** - public-safe IDs yang tidak bisa ditebak untuk routing dan offline-first.
* **Audit Logs** - id event yang konsisten untuk rekonstruksi timeline.
* **Build/Deploy Systems** - release ID, artifact ID, config snapshot; menghindari mutable tag yang bikin debugging mustahil.
* **Security** - session token, CSRF token, verification tokens; semua butuh randomness + uniqueness.
* **Analytics** - anonymous user/event IDs untuk grouping dan tracking yang stabil.

## Terminology

* **UUID (v1, v3, v4, v5, v6, v7, v8)**
* **ULID** (Universally Unique Lexicographically Sortable Identifier)
* **TSID** (Time-Sorted ID)
* **Snowflake** (Twitter-style Snowflake / Snowflake-like)
* **KSUID** (K-Sortable Unique ID)
* **NanoID** / **CUID** (short, URL-safe random IDs)
* **BigInt vs String representation** (how to store & transport)

---

## Deskripsi singkat

### UUID (varian: v1–v8)

* **Apa:** standar 128-bit. v4 = random, v1 = time+MAC, v7 = time-ordered modern draft.
* **Kelebihan:** universal, banyak library, interoperable.
* **Kekurangan:** panjang (36 chars canonical), index heavy, v4 tidak orderable.

### ULID

* **Apa:** 128-bit, Base32, 26 chars, time-sortable.
* **Kelebihan:** human-friendly, sort by time.
* **Kekurangan:** masih 128-bit → index bloat dibanding 64-bit.

### TSID

* **Apa:** 64-bit time-sorted identifier (representasi umum Base32 ~13 chars).
* **Kelebihan:** time-ordered, compact, index-efficient, mudah generate tanpa central coordinator.
* **Kekurangan:** beberapa implementasi berbeda length; treat as string di aplikasi heterogen.

### Snowflake (Twitter-style)

* **Apa:** 64-bit (timestamp | worker_id | sequence).
* **Kelebihan:** deterministic ordering, no collision if worker_id benar.
* **Kekurangan:** perlu worker-id management; sensitif pada clock drift; operational overhead.

### KSUID

* **Apa:** 160-bit-ish, Base62, ~27 chars, time-sortable for logs/events.
* **Kelebihan:** long lifespan, ordering; dipakai di sistem high-throughput.
* **Kekurangan:** lebih panjang, index cost.

### NanoID / CUID

* **Apa:** short, customizable alphabets, client-side friendly.
* **Kelebihan:** URL-safe, configurable length, good for public IDs.
* **Kekurangan:** lebih cocok untuk public tokens, bukan PK heavy DB indexing.

---

## Praktikal rules & trade-offs (WHAT TO CHOOSE)

1. **Need DB primary key, high throughput, small index cost → choose TSID or Snowflake (64-bit).**

   * Jika you want minimal ops: **TSID** (no worker id).
   * Jika strict ordering across many nodes and you can manage worker IDs: **Snowflake**.
2. **Need standard, compatibility, or external integration → choose UUID (v7 if you want time-order).**
3. **Need human-friendly short IDs for URLs or public tokens → choose NanoID / CUID.**
4. **Need event/log IDs and long-term ordering → KSUID or ULID.**

---

## Storage & transport recommendations (practical)

* **DB column:** prefer `BIGINT UNSIGNED` for 64-bit schemes (TSID/Snowflake). Prefer `CHAR(26)` for ULID, `CHAR(36)` for UUID canonical.
* **Backend (PHP/Laravel) + JS frontend:** **treat TSID/Snowflake as string** in application layer and JSON.

  * Rationale: JS Number safe until 2^53−1; TSID ~2^64 → send as string to avoid precision loss.
* **If language supports native uint64 (Go/Rust/Java)** you may use integer representation internally and in DB.
* **API contract:** always specify `"id": "781381604969166106"` (string) to avoid frontend corruption.

---

## Generation patterns (examples — pseudocode, conceptual)

* **TSID (single-node, no registry):**

  * timestamp (ms) << random_bits → encode Base32 or keep uint64.
* **Snowflake (distributed):**

  * timestamp | worker_id | sequence (increment per ms) → must manage worker_id registry.
* **UUID v7:**

  * unix ms in high bits + randomness → library provided.

---

## Migration notes (if moving from UUID to TSID / Snowflake)

* **Add new PK column** (unsignedBigInt or char) — avoid in-place rewrite to prevent downtime.
* **Backfill with generated TSID** carefully (preserve uniqueness).
* **Use surrogate PK temporarily if necessary** (keep old UUID as alternate key).
* **Update indexes & foreign keys** atomically where possible.
* **Update API contract** and document clients: switch to string ids if needed.

---

## Pitfalls & gotchas (what will bite you)

* **JS precision loss** if you send 64-bit numeric as Number. Always use string.
* **PHP integer overflow** on 32-bit platforms or inconsistent env — keep app-level as string for portability.
* **Clock drift** in Snowflake → out-of-order or duplicates. Monitor NTP.
* **Worker ID collisions** (Snowflake) when VMs are cloned or misconfigured. Use robust worker-id allocation.
* **Index bloat**: 128-bit IDs increase index size; affect cache, IO.

---

## Quick checklist (implementation)

* [ ] Define ID requirements: sortability? length constraint? cross-service reading?
* [ ] If DB PK: prefer 64-bit if performance matters; else use UUID for compatibility.
* [ ] Define transport type: **string** for JS safety.
* [ ] Pick library implementation with tests & cross-language compatibility.
* [ ] Add validation & middleware to enforce ID format at API boundary.
* [ ] Document developer rules in repo README (one-liner): *“TSID used; ID always string in API.”*
