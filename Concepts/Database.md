# Database Concepts

## 1. Types of Databases

**Relational (SQL / RDBMS).**

Tabel berbasis schema, ACID, kuat untuk transactional workloads. Cocok untuk data dengan struktur jelas, relasi stabil, dan kebutuhan konsistensi tinggi.

**Non-Relational (NoSQL).**

Longgar soal schema, fokus pada fleksibilitas dan scale-out. Cocok untuk event-heavy apps, big data, atau struktur data yang berubah-ubah.

**Graph DB.**

Optimized untuk relationship-heavy workloads, misalnya social graph, recommendation, atau dependency analysis.

**Time-Series DB.**

Terbaik untuk metrics, telemetry, IoT, observability.

**Columnar / OLAP DB.**

Dioptimalkan untuk analisis, bukan transaksi. Dipakai untuk data warehouse, BI, ML pipelines.

## 2. RDBMS Best Practices

**Use stable unique identifiers.**

UUID/ULID untuk distribusi; int/bigint untuk simplicity; pilih sesuai domain, bukan ego.

**Normalize until it hurts, denormalize until it works.**

Keseimbangan antara integrity & performance, bukan ideologi.

**Soft deletes when domain requires history.**

Gunakan flag `deleted_at` untuk auditability, hindari hard delete kecuali data benar-benar disposable.

**Define explicit constraints.**

Foreign keys, unique constraints, check constraints. Ini bukan opsional; ini alat supaya data tetap waras.

**Always index with intent.**

Index mempercepat query, tetapi memperlambat write. Jangan asal checklist.

**Avoid nullable ambiguity.**

Bedakan state “unknown”, “unset”, “none”. Null yang salah bikin data busuk.

**Model relations explicitly.**

* 1-to-1 untuk pemisahan domain khusus.
* 1-to-many sebagai default modeling.
* many-to-many pakai junction table, bukan array hack.

**Migrate with discipline.**

Schema migration harus deterministic, reversible, dan diuji sebelum deploy.

## 3. NoSQL Best Practices

**Design for access patterns, not elegance.**

Dalam NoSQL, bentuk data mengikuti cara Anda mengaksesnya, bukan teori desain.

**Use document DB untuk entities with flexible shape.**

Berubah cepat? Semi-structured? Document DB wins.

**Key-value stores for hot-path lookups.**

Simple, predictable, and insanely fast.

**Eventual consistency is not an excuse for chaos.**

Define consistency boundaries: apa yang harus strong, apa yang boleh late.

**Avoid over-nesting.**

Document terlalu dalam = write berat, partial updates mahal.

**Model denormalization intentionally.**

Duplicated data = boleh, asal tahu siapa “source of truth”-nya.

**Partitioning & sharding are real constraints.**

Key selection salah → cluster imbalance → bottleneck permanen.

## 4. Cross-DB Principles (SQL + NoSQL)

**Idempotency everywhere.**

Tulis ulang aman → sistem lebih tahan failure.

**Auditability by design.**

Log perubahan penting. Tanpa jejak, debugging hanya berjudi.

**Strong data contracts.**

Schemas, JSON schema, protobuf, Avro. Tanpa ini, data akan membusuk.

**Latency & throughput trade-offs are non-negotiable.**

Tidak ada database yang “bisa semuanya”.

**Backups must be tested, not assumed.**

Backup yang tidak pernah diuji = tidak punya backup.
