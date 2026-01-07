# General Backend Scaffold

```
/src = pure software (deterministik, bisa dites, bisa di-container)
/storage = runtime state (boleh dihapus, tidak memengaruhi logic)
/docs = alasan & kontrak
/scripts = tooling operasional
/tests = verifikasi, bukan delivery
/infra & /ops = siap produksi, bukan vendor-lock
```

- /src : tidak ada file random
    - business logic
    - domain
    - application layer
    - delivery (HTTP, RPC, CLI)
- /storage : source of truth, bisa dihapus tanp merusak sistem
    - uploads
    - cache
    - temp files
    - generated artifacts
- /docs : menjawab why, bukan how
    - architecture decision record (ADR)
    - API contract
    - README teknis
    - migration notes
- /scripts : bukan app runtime
    - db migration helper
    - seeding
    - maintenance tasks
- /tests : bukan bagian dari delivery
    - unit
    - integration
    - e2e
