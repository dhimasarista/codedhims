# Laravel Dasar
## Pengenalan Laravel
Laravel adalah framework PHP yang elegan untuk pengembangan web. Dikenal karena sintaksisnya yang ekspresif dan fitur-fitur yang kaya, Laravel mempermudah tugas-tugas umum seperti routing, autentikasi, caching, dan banyak lagi.

## Membuat Project
Membuat project Laravel baru sangat mudah menggunakan Composer:
```php
composer create-project laravel/laravel nama-project-anda
```

## Struktur Project
Struktur direktori Laravel dirancang untuk skalabilitas. Beberapa direktori kunci:
*   `app/`: Berisi kode inti aplikasi Anda (Controllers, Models, Providers, dll.).
*   `bootstrap/`: Berisi file bootstrap framework.
*   `config/`: Berisi semua file konfigurasi aplikasi Anda.
*   `database/`: Berisi migrasi database, seeder, dan factory.
*   `public/`: Direktori root web Anda, berisi `index.php`.
*   `resources/`: Berisi view, aset mentah (CSS/JS), dan file bahasa.
*   `routes/`: Berisi semua definisi rute aplikasi Anda.
*   `storage/`: Berisi file yang dibuat oleh framework (cache, log, sesi).
*   `tests/`: Berisi tes otomatis Anda.
*   `vendor/`: Berisi dependensi Composer Anda.

## Menjalankan Laravel
Untuk menjalankan server pengembangan lokal Laravel:
```bash
php artisan serve
```
Aplikasi akan tersedia di `http://127.0.0.1:8000`.

## Git
Integrasi Git penting untuk version control. Setelah membuat project, inisialisasi Git:
```bash
git init
git add .
git commit -m "Initial Laravel project setup"
```

## Artisan
Artisan adalah command-line interface (CLI) yang disertakan dengan Laravel. Ini menyediakan sejumlah perintah yang membantu Anda membangun aplikasi dengan cepat.
Untuk melihat semua perintah Artisan:
```bash
php artisan list
```
Contoh membuat Controller:
```bash
php artisan make:controller NamaController
```

## Request Lifecycle
Memahami siklus hidup request membantu dalam debugging dan optimasi. Secara singkat:
1.  Request masuk ke `public/index.php`.
2.  Kernel HTTP memuat konfigurasi dan service provider.
3.  Middleware memproses request (autentikasi, CSRF, dll.).
4.  Routing mencocokkan URL dengan controller/closure.
5.  Controller memproses request dan mengembalikan response.
6.  Middleware memproses response.
7.  Response dikirim ke browser.

## Testing
Laravel mendukung pengujian unit dan fitur secara out-of-the-box dengan PHPUnit.
Jalankan tes:
```bash
php artisan test
```

## Environment
Laravel menggunakan file `.env` untuk mengelola konfigurasi spesifik lingkungan (database credentials, API keys, dll.).
Contoh `.env`:
```
APP_NAME=LaravelApp
APP_ENV=local
APP_KEY=base64:your_app_key_here
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=laravel
DB_USERNAME=root
DB_PASSWORD=
```

## Application Environment
Anda dapat mengakses environment saat ini menggunakan `App::environment()` atau `env()` helper.
```php
if (App::environment('local')) {
    // The environment is local
}
```

## Configuration
File konfigurasi terletak di direktori `config/`. Anda dapat mengakses nilai konfigurasi menggunakan helper `config()`.
```php
// config/app.php
'timezone' => 'Asia/Jakarta',

// Mengakses di kode Anda
$timezone = config('app.timezone');
```

## Configuration Cache
Untuk mempercepat pemuatan konfigurasi di lingkungan produksi, Anda dapat meng-cache file konfigurasi:
```bash
php artisan config:cache
```

## Dependency Injection
Laravel sangat bergantung pada Dependency Injection (DI) untuk mengelola dependensi kelas. Ini memungkinkan kode yang lebih mudah diuji dan dipelihara.
```php
class UserController extends Controller
{
    protected $userRepository;

    public function __construct(UserRepository $userRepository)
    {
        $this->userRepository = $userRepository;
    }

    public function index()
    {
        return $this->userRepository->getAllUsers();
    }
}
```

## Service Container
Service Container (atau IoC Container) adalah alat yang kuat untuk mengelola dependensi kelas dan melakukan dependency injection.
Binding ke container:
```php
$this->app->bind('HelpSpot\API', function ($app) {
    return new HelpSpot\API($app->make('HttpClient'));
});
```
Resolving dari container:
```php
$api = app('HelpSpot\API');
```

## Service Provider
Service Provider adalah pusat bootstrapping semua layanan aplikasi Anda. Mereka adalah tempat utama untuk mengkonfigurasi aplikasi Anda.
Contoh `AppServiceProvider.php`:
```php
namespace App\Providers;

use Illuminate\Support\ServiceProvider;

class AppServiceProvider extends ServiceProvider
{
    public function register()
    {
        //
    }

    public function boot()
    {
        //
    }
}
```

## Facades
Facades menyediakan antarmuka "statis" ke kelas-kelas yang tersedia di Service Container.
Contoh menggunakan Facade `Cache`:
```php
Cache::put('key', 'value', $minutes);
```

## Routing
Routing adalah cara Laravel mengarahkan request HTTP ke controller atau closure yang sesuai.
Contoh rute dasar:
```php
use Illuminate\Support\Facades\Route;

Route::get('/greeting', function () {
    return 'Hello World';
});
```

## View
View berisi markup HTML aplikasi Anda. Mereka menyediakan pemisahan logika presentasi dari logika aplikasi.
Mengembalikan view dari rute:
```php
Route::get('/welcome', function () {
    return view('welcome');
});
```

## Static File
Aset statis (CSS, JavaScript, gambar) disimpan di direktori `public/`. Anda dapat mereferensikannya menggunakan helper `asset()`.
```html
<link href="{{ asset('css/app.css') }}" rel="stylesheet">
```

## Route Parameter
Anda dapat menangkap segmen URI dalam rute Anda sebagai parameter.
```php
Route::get('/user/{id}', function (string $id) {
    return 'User '.$id;
});
```

## Named Route
Named routes memungkinkan Anda mereferensikan rute dengan nama yang nyaman.
```php
Route::get('/user/profile', function () {
    //
})->name('profile');

// Menggunakan named route
$url = route('profile');
```

## Controller
Controller mengelompokkan logika penanganan request HTTP terkait ke dalam satu kelas.
```php
namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Models\User;

class UserController extends Controller
{
    public function show(string $id)
    {
        return view('user.profile', [
            'user' => User::findOrFail($id)
        ]);
    }
}
```

## Request
Objek `Illuminate\Http\Request` menyediakan cara berorientasi objek untuk berinteraksi dengan informasi request HTTP.
Mengakses data request:
```php
use Illuminate\Http\Request;

Route::post('/profile', function (Request $request) {
    $name = $request->input('name');
    // ...
});
```

## Request Input
Mengakses semua input dari request:
```php
$all = $request->all();
```

## Input Type
Laravel menyediakan berbagai metode untuk mengakses input berdasarkan tipe HTTP.
```php
$name = $request->query('name'); // Dari query string
$email = $request->post('email'); // Dari body POST
```

## Filter Request Input
Anda dapat memfilter input request menggunakan metode seperti `only()` atau `except()`.
```php
$credentials = $request->only(['email', 'password']);
$ignored = $request->except(['credit_card']);
```

## File Storage
Laravel menyediakan sistem file abstrak yang kuat berkat paket Flysystem.
Menyimpan file:
```php
use Illuminate\Support\Facades\Storage;

Storage::disk('local')->put('file.txt', 'Contents');
```

## File Upload
Menangani upload file:
```php
use Illuminate\Http\Request;

Route::post('/upload', function (Request $request) {
    $path = $request->file('avatar')->store('avatars');
    // ...
});
```

## Response
Mengembalikan response dari rute atau controller.
```php
Route::get('/home', function () {
    return response('Hello World', 200)
                  ->header('Content-Type', 'text/plain');
});
```

## Encryption
Laravel menyediakan mekanisme enkripsi yang kuat menggunakan OpenSSL.
```php
use Illuminate\Support\Facades\Crypt;

$encrypted = Crypt::encryptString('secret');
$decrypted = Crypt::decryptString($encrypted);
```

## Cookie
Mengelola cookie:
```php
use Illuminate\Support\Facades\Cookie;

Cookie::queue('name', 'value', $minutes);
$value = Cookie::get('name');
```

## Redirect
Mengarahkan pengguna ke URL lain.
```php
Route::get('/dashboard', function () {
    return redirect('/home');
});
```

## Middleware
Middleware menyediakan mekanisme yang nyaman untuk memfilter request HTTP yang masuk ke aplikasi Anda.
Contoh middleware autentikasi:
```php
Route::get('/admin', function () {
    // Hanya bisa diakses oleh user yang sudah login
})->middleware('auth');
```

## Cross Site Request Forgery
Laravel secara otomatis menghasilkan token CSRF untuk setiap sesi pengguna aktif yang dikelola oleh aplikasi.
Dalam form HTML:
```html
<form method="POST" action="/profile">
    @csrf
    <!-- ... -->
</form>
```

## Route Group
Route group memungkinkan Anda berbagi atribut rute, seperti middleware atau namespace, di antara sejumlah besar rute.
```php
Route::middleware(['auth'])->group(function () {
    Route::get('/profile', function () {
        //
    });
    Route::get('/settings', function () {
        //
    });
});
```

## URL Generation
Menghasilkan URL ke rute bernama atau tindakan controller.
```php
$url = url('/user/profile');
$url = route('profile');
```

## Session
Session digunakan untuk menyimpan informasi tentang pengguna di antara beberapa request.
```php
use Illuminate\Http\Request;

Route::get('/home', function (Request $request) {
    $value = $request->session()->get('key');
    $request->session()->put('key', 'value');
});
```

## Error Handling
Laravel memiliki penanganan error yang sudah dikonfigurasi. Anda dapat menyesuaikannya di `App\Exceptions\Handler.php`.

## HTTP Exception
Melemparkan HTTP exception:
```php
abort(404); // Melemparkan 404 Not Found
```

## Maintenance Mode
Mengaktifkan mode pemeliharaan:
```bash
php artisan down
```
Mematikan mode pemeliharaan:
```bash
php artisan up
```
# Laravel Logging
## Pengenalan Laravel Logging
Laravel menyediakan layanan logging yang kuat dan fleksibel, dibangun di atas pustaka Monolog. Ini memungkinkan Anda untuk mencatat berbagai pesan ke berbagai tujuan (file, database, Slack, dll.).

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Logging Configuration
Konfigurasi logging utama berada di `config/logging.php`. Anda dapat menentukan "channels" yang berbeda untuk tujuan logging yang berbeda.
Contoh konfigurasi channel `stack`:
```php
'channels' => [
    'stack' => [
        'driver' => 'stack',
        'channels' => ['single', 'daily'],
        'ignore_exceptions' => false,
    ],
    // ...
],
```

## Log Facade
Anda dapat berinteraksi dengan logger melalui Facade `Log`.
```php
use Illuminate\Support\Facades\Log;

Log::info('Ini adalah pesan informasi.');
Log::warning('Ada sesuatu yang perlu diperhatikan.');
Log::error('Terjadi kesalahan serius!');
```

## Multiple Log Channel
Anda dapat mengirim pesan log ke channel tertentu.
```php
Log::channel('slack')->info('Pesan untuk Slack!');
```

## Context
Anda dapat menambahkan data kontekstual ke pesan log.
```php
Log::info('User login gagal.', ['id' => $userId, 'ip' => $ipAddress]);
```

## Selected Channel
Menggunakan channel default atau memilih channel secara spesifik.
```php
// Menggunakan channel default (biasanya 'stack')
Log::info('Pesan default.');

// Menggunakan channel 'daily'
Log::channel('daily')->info('Pesan harian.');
```

## Handler
Monolog menggunakan "handlers" untuk mengirim pesan log ke tujuan tertentu. Anda dapat membuat handler kustom.
(Penjelasan singkat, tidak perlu kode penuh)
Handler didefinisikan dalam konfigurasi channel logging.

## Formatter
"Formatters" digunakan untuk memformat pesan log sebelum dikirim oleh handler.
(Penjelasan singkat, tidak perlu kode penuh)
Formatter juga dikonfigurasi dalam `config/logging.php` untuk setiap channel.
# Laravel Blade
## Pengenalan Blade Template
Blade adalah templating engine sederhana namun powerful yang disediakan dengan Laravel. Tidak seperti templating engine PHP populer lainnya, Blade tidak membatasi Anda untuk menggunakan kode PHP biasa di view Anda. Semua view Blade dikompilasi menjadi kode PHP biasa dan di-cache hingga dimodifikasi, yang berarti Blade menambahkan hampir nol overhead ke aplikasi Anda.

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Menampilkan View
View Blade disimpan di `resources/views`. Anda dapat mengembalikan view dari rute atau controller.
```php
Route::get('/welcome', function () {
    return view('welcome', ['name' => 'Samantha']);
});
```
Dalam `welcome.blade.php`:
```html
<h1>Hello, {{ $name }}</h1>
```

## Comment
Komentar Blade tidak akan disertakan dalam HTML yang dirender.
```html
{{-- Ini adalah komentar Blade --}}
```

## HTML Encoding
Secara default, Blade akan secara otomatis meng-encode entitas HTML untuk mencegah serangan XSS.
```html
Hello, {{ $name }}
```
Untuk menampilkan output yang tidak di-encode:
```html
Hello, {!! $name !!}
```

## Disabled Blade
Anda dapat menonaktifkan Blade untuk bagian tertentu dari file template Anda.
```html
@php
    // Kode PHP biasa
@endphp
```

## If Statement
```html
@if (count($records) === 1)
    Saya punya satu record!
@elseif (count($records) > 1)
    Saya punya banyak record!
@else
    Saya tidak punya record!
@endif
```

## Unless Statement
`@unless` adalah kebalikan dari `@if`.
```html
@unless (Auth::check())
    Anda belum login.
@endunless
```

## Isset dan Empty
```html
@isset($name)
    Nama saya adalah {{ $name }}
@endisset

@empty($records)
    Tidak ada record.
@endempty
```

## Env
```html
@env('local')
    Aplikasi berjalan di lingkungan lokal.
@endenv
```

## Switch Statement
```html
@switch($i)
    @case(1)
        Pertama...
        @break
    @case(2)
        Kedua...
        @break
    @default
        Default...
@endswitch
```

## For Loop
```html
@for ($i = 0; $i < 10; $i++)
    The current value is {{ $i }}
@endfor
```

## Raw PHP
Anda dapat menyertakan blok PHP biasa dalam template Anda.
```html
@php
    // Kode PHP biasa
@endphp
```

## While Loop
```html
@while (true)
    <p>Saya berputar tanpa henti.</p>
@endwhile
```

## Loop Variable
Saat melakukan iterasi, variabel `$loop` tersedia di dalam loop.
```html
@foreach ($users as $user)
    @if ($loop->first)
        Ini adalah iterasi pertama.
    @endif
    @if ($loop->last)
        Ini adalah iterasi terakhir.
    @endif
    <p>User {{ $user->name }}</p>
@endforeach
```

## CSS Class
Menambahkan kelas CSS secara kondisional.
```html
<div @class(['p-4', 'bg-red' => $hasError])>
    <!-- ... -->
</div>
```

## Include
Menyertakan view Blade lainnya ke dalam view saat ini.
```html
@include('shared.errors')
```

## Include Condition
Menyertakan view hanya jika kondisi tertentu benar.
```html
@includeWhen($boolean, 'view.name', ['some' => 'data'])
```

## Each dan Once
`@each` untuk merender partial untuk setiap item dalam array. `@once` untuk merender bagian hanya sekali per siklus render.
```html
@each('user.item', $users, 'user')

@once
    <script>
        // Ini hanya akan dirender sekali
    </script>
@endonce
```

## Form
Membuat form dengan token CSRF.
```html
<form method="POST" action="/profile">
    @csrf
    <!-- ... -->
</form>
```

## CSRF
Token CSRF secara otomatis disertakan dengan `@csrf`.

## Error
Menampilkan pesan error validasi.
```html
@error('title')
    <div class="alert alert-danger">{{ $message }}</div>
@enderror
```

## Stack
Stack memungkinkan Anda untuk mendorong konten ke stack bernama yang dapat dirender di view Blade lainnya.
```html
// Di view anak
@push('scripts')
    <script src="/example.js"></script>
@endpush

// Di layout utama
@stack('scripts')
```

## Template Inheritance
Blade mendukung pewarisan template menggunakan `@extends`, `@section`, dan `@yield`.
```html
// layouts/app.blade.php
<html>
    <head>
        <title>App Name - @yield('title')</title>
    </head>
    <body>
        @section('sidebar')
            Ini adalah sidebar utama.
        @show

        <div class="container">
            @yield('content')
        </div>
    </body>
</html>

// child.blade.php
@extends('layouts.app')

@section('title', 'Page Title')

@section('content')
    <p>Ini adalah isi body.</p>
@endsection
```

## Service Injection
Menginjeksikan layanan ke dalam view Blade.
```html
@inject('metrics', 'App\Services\MetricsService')

<div>
    Monthly Revenue: {{ $metrics->getMonthlyRevenue() }}
</div>
```

## Inline Blade Template
Anda dapat mengkompilasi string Blade secara langsung.
```php
$template = 'Hello, {{ $name }}';
$html = Blade::render($template, ['name' => 'John Doe']);
```

## Extending Blade Template
Anda dapat membuat direktif Blade kustom.
```php
Blade::directive('datetime', function (string $expression) {
    return "<?php echo ($expression)->format('m/d/Y H:i'); ?>";
});
```
Penggunaan:
```html
@datetime($user->created_at)
```

## Custom Echo Handler
Anda dapat menyesuaikan bagaimana Blade meng-echo data.

## Optimize Template
Blade mengkompilasi template ke PHP biasa. Tidak ada langkah optimasi manual yang diperlukan selain caching konfigurasi.
# Laravel Collection
## Pengenalan Laravel Collection
Laravel Collections adalah wrapper yang sangat kuat dan nyaman untuk array PHP. Mereka menyediakan API yang fasih dan intuitif untuk bekerja dengan data array, memungkinkan Anda untuk melakukan operasi umum seperti filtering, mapping, dan sorting dengan mudah.

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Membuat Collection
Anda dapat membuat instance Collection baru dari array menggunakan helper `collect()`.
```php
$collection = collect([1, 2, 3, 4, 5]);
```

## For Each
Anda dapat mengulang item dalam collection menggunakan metode `each()`.
```php
$collection->each(function ($item, $key) {
    // Lakukan sesuatu dengan $item dan $key
});
```

## Manipulasi Collection
Collection memiliki banyak metode untuk memanipulasi data.
Contoh: `push()`, `pop()`, `shift()`, `unshift()`.
```php
$collection->push(6); // Menambahkan item ke akhir
$collection->pop();    // Menghapus item terakhir
```

## Mapping
Metode `map()` mengulang collection dan meneruskan setiap item ke callback yang diberikan. Callback harus mengembalikan nilai yang dimodifikasi.
```php
$multiplied = $collection->map(function ($item) {
    return $item * 2;
}); // [2, 4, 6, 8, 10]
```

## Zipping
Metode `zip()` menggabungkan nilai-nilai dari array atau collection yang diberikan dengan nilai-nilai collection asli pada indeks yang sesuai.
```php
$collection = collect(['a', 'b', 'c']);
$zipped = $collection->zip([1, 2, 3]);
// [['a', 1], ['b', 2], ['c', 3]]
```

## Flattening
Metode `flatten()` mengubah collection multi-dimensi menjadi collection satu dimensi.
```php
$collection = collect(['name' => 'taylor', 'hobbies' => ['coding', 'football']]);
$flattened = $collection->flatten();
// ['taylor', 'coding', 'football']
```

## String Representation
Mengubah collection menjadi string.
```php
$collection = collect(['a', 'b', 'c']);
$string = $collection->implode('-'); // "a-b-c"
```

## Filtering
Metode `filter()` memfilter collection menggunakan callback yang diberikan, hanya menyimpan item yang callback-nya mengembalikan `true`.
```php
$filtered = $collection->filter(function ($item) {
    return $item > 3;
}); // [4, 5]
```

## Partitioning
Metode `partition()` memisahkan collection menjadi dua collection baru berdasarkan callback yang diberikan.
```php
list($under3, $over3) = $collection->partition(function ($i) {
    return $i < 3;
}); // $under3 = [1, 2], $over3 = [3, 4, 5]
```

## Testing
Collection memiliki metode `dd()` dan `dump()` untuk membantu debugging.
```php
$collection->dd(); // Dump and die
```

## Grouping
Metode `groupBy()` mengelompokkan item collection berdasarkan kunci yang diberikan.
```php
$collection = collect([
    ['product' => 'Desk', 'price' => 200],
    ['product' => 'Chair', 'price' => 100],
    ['product' => 'Bookcase', 'price' => 150],
    ['product' => 'Desk', 'price' => 175],
]);

$grouped = $collection->groupBy('product');
/*
[
    'Desk' => [
        ['product' => 'Desk', 'price' => 200],
        ['product' => 'Desk', 'price' => 175],
    ],
    'Chair' => [
        ['product' => 'Chair', 'price' => 100],
    ],
    'Bookcase' => [
        ['product' => 'Bookcase', 'price' => 150],
    ],
]
*/
```

## Slicing
Metode `slice()` mengembalikan bagian dari collection.
```php
$collection = collect([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
$slice = $collection->slice(4); // [5, 6, 7, 8, 9, 10]
```

## Take dan Skip
Metode `take()` mengembalikan sejumlah item pertama dari collection. Metode `skip()` mengembalikan semua kecuali sejumlah item pertama.
```php
$collection->take(3); // [1, 2, 3]
$collection->skip(3); // [4, 5, 6, 7, 8, 9, 10]
```

## Chunked
Metode `chunk()` memecah collection menjadi beberapa collection yang lebih kecil.
```php
$collection->chunk(4);
// [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10]]
```

## Retrieve
Metode `first()` mengembalikan item pertama dalam collection yang memenuhi kondisi tertentu.
```php
$first = $collection->first(function ($key, $value) {
    return $value > 5;
}); // 6
```

## Random
Metode `random()` mengembalikan item acak dari collection.
```php
$random = $collection->random();
```

## Checking Existence
Metode `contains()` menentukan apakah collection berisi item tertentu.
```php
$collection->contains(5); // true
```

## Ordering
Metode `sortBy()` mengurutkan collection berdasarkan nilai kunci yang diberikan.
```php
$sorted = $collection->sortBy('price');
```

## Aggregate
Metode `sum()`, `avg()`, `max()`, `min()` untuk melakukan operasi agregasi.
```php
$sum = $collection->sum();
$average = $collection->avg();
```

## Reduce
Metode `reduce()` mengurangi collection menjadi satu nilai dengan meneruskan setiap item ke callback.
```php
$total = $collection->reduce(function ($carry, $item) {
    return $carry + $item;
}, 0);
```

## Method Lainnya
Laravel Collection memiliki banyak metode lain seperti `unique()`, `merge()`, `diff()`, `intersect()`, dll.

## Lazy Collection
Lazy Collections memungkinkan Anda bekerja dengan dataset yang sangat besar sambil menjaga penggunaan memori tetap rendah.
```php
use App\Models\User;

$users = User::cursor()->filter(function ($user) {
    return $user->id > 500;
})->map(function ($user) {
    return $user->name;
});
```
# Laravel Database
## Pengenalan Laravel Database
Laravel membuat interaksi database menjadi sangat mudah dengan menyediakan berbagai alat untuk bekerja dengan database Anda. Ini termasuk Query Builder yang kuat, Eloquent ORM, dan dukungan untuk migrasi database.

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Konfigurasi Database
Konfigurasi database Anda terletak di `config/database.php`. Anda juga dapat mengkonfigurasi koneksi database di file `.env` Anda.
Contoh `.env` untuk MySQL:
```
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=nama_database_anda
DB_USERNAME=root
DB_PASSWORD=
```

## Membuat Database
Anda perlu membuat database secara manual di server database Anda (misalnya, menggunakan phpMyAdmin atau command line MySQL).

## DB Facade
Facade `DB` menyediakan akses langsung ke database.
```php
use Illuminate\Support\Facades\DB;

$users = DB::select('select * from users where active = ?', [1]);
```

## Debug Query
Untuk melihat query SQL yang dieksekusi, Anda dapat menggunakan `DB::listen()`.
```php
DB::listen(function ($query) {
    dump($query->sql);
    dump($query->bindings);
    dump($query->time);
});
```

## CRUD SQL
Melakukan operasi CRUD (Create, Read, Update, Delete) menggunakan SQL mentah.
```php
// Insert
DB::insert('insert into users (name, email, password) values (?, ?, ?)', ['Taylor', 'taylor@example.com', 'password']);

// Update
DB::update('update users set name = "Dhimas" where id = ?', [1]);

// Delete
DB::delete('delete from users where id = ?', [1]);
```

## Database Transaction
Menjalankan operasi database dalam transaksi untuk memastikan integritas data.
```php
DB::transaction(function () {
    DB::update('update users set votes = 1');
    DB::delete('delete from posts');
});
```

## Database Commands
Laravel menyediakan perintah Artisan untuk berinteraksi dengan database.
```bash
php artisan migrate       # Menjalankan migrasi
php artisan db:seed       # Menjalankan seeder
php artisan migrate:rollback # Mengembalikan migrasi terakhir
```

## Query Builder
Query Builder Laravel menyediakan antarmuka yang nyaman dan fasih untuk membuat dan menjalankan query database.
```php
use Illuminate\Support\Facades\DB;

$users = DB::table('users')->where('id', 1)->first();
```

## Query Builder Insert
```php
DB::table('users')->insert([
    'name' => 'John Doe',
    'email' => 'john@example.com',
    'password' => bcrypt('password')
]);
```

## Query Builder Select
```php
$users = DB::table('users')->select('name', 'email')->get();
```

## Query Builder Where
```php
$users = DB::table('users')->where('votes', '>', 100)->get();
```

## Query Builder Update
```php
DB::table('users')
    ->where('id', 1)
    ->update(['votes' => 1]);
```

## Query Builder Delete
```php
DB::table('users')->where('votes', '<', 100)->delete();
```

## Query Builder Join
```php
$users = DB::table('users')
    ->join('contacts', 'users.id', '=', 'contacts.user_id')
    ->join('orders', 'users.id', '=', 'orders.user_id')
    ->select('users.*', 'contacts.phone', 'orders.price')
    ->get();
```

## Query Builder Ordering
```php
$users = DB::table('users')
    ->orderBy('name', 'desc')
    ->get();
```

## Query Builder Paging
```php
$users = DB::table('users')->skip(10)->take(5)->get();
```

## Chunk Results
Memproses hasil dalam "chunks" untuk menghemat memori saat bekerja dengan dataset besar.
```php
DB::table('users')->chunk(100, function ($users) {
    foreach ($users as $user) {
        // ...
    }
});
```

## Lazy Results
Menggunakan `cursor()` untuk mengambil hasil satu per satu.
```php
foreach (DB::table('users')->cursor() as $user) {
    // ...
}
```

## Cursor
Metode `cursor()` mengembalikan instance `LazyCollection`, yang hanya akan menjalankan satu query ke database.

## Query Builder Aggregate
Melakukan fungsi agregat seperti `count`, `max`, `min`, `avg`, `sum`.
```php
$count = DB::table('users')->count();
$maxPrice = DB::table('orders')->max('price');
```

## Query Builder Raw
Menyuntikkan ekspresi SQL mentah ke dalam query.
```php
$users = DB::table('users')
    ->select(DB::raw('count(*) as user_count, status'))
    ->where('status', '<>', 1)
    ->groupBy('status')
    ->get();
```

## Query Builder Grouping
```php
$users = DB::table('users')
    ->where('name', '=', 'John')
    ->orWhere(function ($query) {
        $query->where('votes', '>', 100)
              ->where('title', '<>', 'Admin');
    })
    ->get();
```

## Query Builder Locking
Mengunci baris yang dipilih selama transaksi.
```php
DB::transaction(function () {
    $user = DB::table('users')
                ->where('votes', '>', 100)
                ->lockForUpdate()
                ->first();
    // ...
});
```

## Pagination
Laravel menyediakan cara yang mudah untuk melakukan pagination hasil database.
```php
$users = DB::table('users')->paginate(15);
```

## Cursor Pagination
Cursor pagination adalah cara yang lebih efisien untuk melakukan pagination pada dataset yang sangat besar.
```php
$users = DB::table('users')->orderBy('id')->cursorPaginate(15);
```

## Database Migration
Migrasi adalah seperti kontrol versi untuk database Anda, memungkinkan tim Anda untuk dengan mudah memodifikasi dan berbagi skema database aplikasi.
Membuat migrasi:
```bash
php artisan make:migration create_users_table
```

## Membuat Database Migration
Contoh file migrasi:
```php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->string('email')->unique();
            $table->timestamp('email_verified_at')->nullable();
            $table->string('password');
            $table->rememberToken();
            $table->timestamps();
        });
    }

    public function down(): void
    {
        Schema::dropIfExists('users');
    }
};
```

## Rollback Database Migration
Mengembalikan migrasi terakhir:
```bash
php artisan migrate:rollback
```

## Database Seeding
Seeding adalah cara untuk mengisi database Anda dengan data dummy.
Membuat seeder:
```bash
php artisan make:seeder UserSeeder
```
Menjalankan seeder:
```bash
php artisan db:seed
```
# Laravel Eloquent
## Pengenalan Laravel Eloquent
Eloquent ORM adalah implementasi ActiveRecord yang indah dan sederhana yang disertakan dengan Laravel. Setiap tabel database memiliki "Model" yang sesuai yang digunakan untuk berinteraksi dengan tabel tersebut. Model memungkinkan Anda untuk mengkueri data dalam tabel Anda, serta menyisipkan record baru ke dalam tabel.

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Membuat Database
(Asumsi database sudah dikonfigurasi dan dibuat, lihat bagian Laravel Database)

## Model
Model Eloquent biasanya berada di direktori `app/Models`.
Membuat model:
```bash
php artisan make:model Post
```
Contoh model `Post.php`:
```php
namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Post extends Model
{
    //
}
```

## Insert
Menyisipkan record baru ke database.
```php
use App\Models\Post;

$post = new Post;
$post->title = 'Judul Post Baru';
$post->content = 'Isi post baru.';
$post->save();
```

## Query Builder
Eloquent juga dapat menggunakan Query Builder.
```php
$posts = Post::where('active', 1)->orderBy('title')->get();
```

## Insert Many
Menyisipkan beberapa record sekaligus.
```php
Post::insert([
    ['title' => 'Post 1', 'content' => 'Content 1'],
    ['title' => 'Post 2', 'content' => 'Content 2'],
]);
```

## Find
Mencari record berdasarkan primary key.
```php
$post = Post::find(1);
```

## Update
Memperbarui record yang ada.
```php
$post = Post::find(1);
$post->title = 'Judul Diperbarui';
$post->save();
```

## Select
Mengambil semua record dari tabel.
```php
$posts = Post::all();
```

## Update Many
Memperbarui beberapa record sekaligus.
```php
Post::where('active', 0)->update(['active' => 1]);
```

## Delete
Menghapus record dari database.
```php
$post = Post::find(1);
$post->delete();
```

## Delete Many
Menghapus beberapa record sekaligus.
```php
Post::where('active', 0)->delete();
```

## UUID
Menggunakan UUID sebagai primary key.
```php
use Illuminate\Database\Eloquent\Concerns\HasUuids;
use Illuminate\Database\Eloquent\Model;

class User extends Model
{
    use HasUuids;
}
```

## Timestamps
Secara default, Eloquent mengharapkan kolom `created_at` dan `updated_at` ada di tabel Anda.
Untuk menonaktifkan timestamps:
```php
class User extends Model
{
    public $timestamps = false;
}
```

## Default Attribute Values
Menentukan nilai default untuk atribut model.
```php
class User extends Model
{
    protected $attributes = [
        'active' => true,
    ];
}
```

## Fillable Attributes
Atribut yang dapat diisi secara massal (mass assignable).
```php
class Post extends Model
{
    protected $fillable = ['title', 'content'];
}
```

## Soft Delete
Menghapus record secara "lunak" (tidak benar-benar dihapus dari database, hanya ditandai sebagai dihapus).
```php
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Post extends Model
{
    use SoftDeletes;
}
```

## Query Scope
Scope memungkinkan Anda untuk mendefinisikan batasan umum yang dapat digunakan kembali dalam aplikasi Anda.
Global Scope:
```php
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\Model;

class User extends Model
{
    protected static function booted(): void
    {
        static::addGlobalScope('active', function (Builder $builder) {
            $builder->where('active', 1);
        });
    }
}
```

## Query Global Scope
Global scope menerapkan batasan ke semua query model.

## Query Local Scope
Local scope memungkinkan Anda untuk mendefinisikan batasan umum yang dapat digunakan kembali.
```php
class User extends Model
{
    public function scopeActive(Builder $query): void
    {
        $query->where('active', 1);
    }
}
```
Penggunaan:
```php
$activeUsers = User::active()->get();
```

## Relationships
Eloquent menyediakan cara yang mudah untuk mengelola hubungan antar model.

## One to One
Satu user memiliki satu phone.
```php
// User model
public function phone()
{
    return $this->hasOne(Phone::class);
}

// Phone model
public function user()
{
    return $this->belongsTo(User::class);
}
```

## One to Many
Satu post memiliki banyak comments.
```php
// Post model
public function comments()
{
    return $this->hasMany(Comment::class);
}

// Comment model
public function post()
{
    return $this->belongsTo(Post::class);
}
```

## Query Builder Relationship
Mengkueri relasi.
```php
$user->posts()->where('active', 1)->get();
```

## Has One of Many
Mengambil satu model terkait dari relasi "has many".
```php
class User extends Model
{
    public function latestOrder()
    {
        return $this->hasOne(Order::class)->latestOfMany();
    }
}
```

## Has One Through
Mengakses relasi "has one" melalui model perantara.
```php
class Mechanic extends Model
{
    public function carOwner()
    {
        return $this->hasOneThrough(Owner::class, Car::class);
    }
}
```

## Has Many Through
Mengakses relasi "has many" melalui model perantara.
```php
class Country extends Model
{
    public function posts()
    {
        return $this->hasManyThrough(Post::class, User::class);
    }
}
```

## Many to Many
Relasi banyak ke banyak (misalnya, user memiliki banyak roles, dan role dimiliki oleh banyak users).
```php
// User model
public function roles()
{
    return $this->belongsToMany(Role::class);
}

// Role model
public function users()
{
    return $this->belongsToMany(User::class);
}
```

## Intermediate Table
Tabel perantara (pivot table) dalam relasi many-to-many.

## Pivot Model
Mendefinisikan model kustom untuk tabel pivot.
```php
class RoleUser extends Pivot
{
    //
}
```

## Polymorphic Relationships
Relasi polimorfik memungkinkan model untuk memiliki satu relasi yang terkait dengan lebih dari satu model lain.
Contoh: `Image` dapat dimiliki oleh `Post` atau `User`.

## One to One Polymorphic
```php
// Image model
public function imageable()
{
    return $this->morphTo();
}

// Post model
public function image()
{
    return $this->morphOne(Image::class, 'imageable');
}

// User model
public function image()
{
    return $this->morphOne(Image::class, 'imageable');
}
```

## One to Many Polymorphic
```php
// Comment model
public function commentable()
{
    return $this->morphTo();
}

// Post model
public function comments()
{
    return $this->morphMany(Comment::class, 'commentable');
}

// Video model
public function comments()
{
    return $this->morphMany(Comment::class, 'commentable');
}
```

## One of Many Polymorphic
Mirip dengan "Has One of Many" tetapi untuk relasi polimorfik.

## Many to Many Polymorphic
```php
// Tag model
public function posts()
{
    return $this->morphedByMany(Post::class, 'taggable');
}

public function videos()
{
    return $this->morphedByMany(Video::class, 'taggable');
}

// Post model
public function tags()
{
    return $this->morphToMany(Tag::class, 'taggable');
}
```

## Polymorphic Types
Secara default, Laravel akan menggunakan nama kelas model untuk menyimpan "tipe" dari model terkait.

## Lazy dan Eager Loading
Lazy loading: Relasi dimuat hanya saat diakses.
Eager loading: Relasi dimuat bersamaan dengan model induk untuk menghindari masalah N+1 query.
```php
$users = User::with('posts')->get();
```

## Querying Relations
Mengkueri keberadaan relasi.
```php
$users = User::has('posts')->get();
```

## Aggregating Relations
Melakukan agregasi pada relasi.
```php
$users = User::withCount('posts')->get();
```

## Eloquent Collection
Ketika Eloquent mengembalikan hasil dari query, mereka akan mengembalikan instance `Illuminate\Database\Eloquent\Collection`.

## Accessors dan Mutators
Accessors: Memodifikasi atribut saat diambil dari model.
Mutators: Memodifikasi atribut saat disimpan ke model.
```php
class User extends Model
{
    // Accessor
    public function getFirstNameAttribute(string $value): string
    {
        return ucfirst($value);
    }

    // Mutator
    public function setPasswordAttribute(string $value): void
    {
        $this->attributes['password'] = bcrypt($value);
    }
}
```

## Attribute Casting
Mengkonversi atribut ke tipe data umum.
```php
class User extends Model
{
    protected $casts = [
        'is_admin' => 'boolean',
    ];
}
```

## Custom Casts
Membuat kelas cast kustom untuk logika casting yang kompleks.

## Serialization
Mengkonversi model dan relasinya ke array atau JSON.

## Factory
Factory digunakan untuk menghasilkan data dummy untuk model Anda.
Membuat factory:
```bash
php artisan make:factory PostFactory
```
# Laravel Validation
## Pengenalan Laravel Validation
Laravel menyediakan berbagai alat yang kuat untuk memvalidasi data yang masuk ke aplikasi Anda. Ini memastikan bahwa data yang Anda terima memenuhi persyaratan yang ditentukan sebelum disimpan ke database atau digunakan dalam logika bisnis Anda.

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Validator
Anda dapat membuat instance validator secara manual menggunakan Facade `Validator`.
```php
use Illuminate\Support\Facades\Validator;

$validator = Validator::make($request->all(), [
    'title' => 'required|unique:posts|max:255',
    'body' => 'required',
]);

if ($validator->fails()) {
    // Handle validasi gagal
}
```

## Menjalankan Validasi
Validasi dapat dijalankan secara otomatis melalui form request atau secara manual menggunakan Facade `Validator`.

## Error Message
Laravel secara otomatis menyediakan pesan error validasi. Anda dapat menyesuaikannya.
```php
$messages = [
    'title.required' => 'Judul wajib diisi.',
    'body.required' => 'Isi post wajib diisi.',
];

$validator = Validator::make($request->all(), [
    'title' => 'required|unique:posts|max:255',
    'body' => 'required',
], $messages);
```

## Validation Exception
Ketika validasi gagal, Laravel akan secara otomatis melemparkan `Illuminate\Validation\ValidationException`.

## Validation Rules
Laravel menyediakan berbagai aturan validasi yang kuat.
Contoh: `required`, `min`, `max`, `email`, `unique`, `confirmed`, dll.
```php
'email' => 'required|email|unique:users',
'password' => 'required|min:8|confirmed',
```

## Valid Data
Setelah validasi berhasil, Anda dapat mengambil data yang telah divalidasi.
```php
$validated = $validator->validated();
```

## Validation Message
Mengakses pesan error validasi.
```php
$errors = $validator->errors();
```

## Additional Validation
Anda dapat menambahkan validasi "after" ke validator.
```php
$validator->after(function ($validator) {
    if ($this->somethingElseIsInvalid()) {
        $validator->errors()->add('field', 'Something is wrong with this field!');
    }
});
```

## Custom Rule
Membuat aturan validasi kustom.
```bash
php artisan make:rule Uppercase
```
Contoh `Uppercase.php`:
```php
namespace App\Rules;

use Closure;
use Illuminate\Contracts\Validation\ValidationRule;

class Uppercase implements ValidationRule
{
    public function validate(string $attribute, mixed $value, Closure $fail): void
    {
        if (strtoupper($value) !== $value) {
            $fail('The :attribute must be uppercase.');
        }
    }
}
```
Penggunaan:
```php
'name' => ['required', new Uppercase],
```

## Custom Function Rule
Anda juga dapat membuat aturan validasi kustom menggunakan closure.
```php
use Illuminate\Validation\Rule;

Validator::make($request->all(), [
    'name' => [
        'required',
        function (string $attribute, mixed $value, Closure $fail) {
            if ($value === 'foo') {
                $fail("The {$attribute} is invalid.");
            }
        },
    ],
]);
```

## Rule Classes
Menggunakan kelas aturan validasi untuk mengorganisir logika validasi yang kompleks.

## Nested Array Validation
Memvalidasi array bersarang.
```php
$request->validate([
    'photos.*.caption' => 'required|max:255',
]);
```

## HTTP Request Validation
Cara paling umum untuk memvalidasi data adalah melalui objek request HTTP.
```php
use Illuminate\Http\Request;

public function store(Request $request)
{
    $validated = $request->validate([
        'title' => 'required|unique:posts|max:255',
        'body' => 'required',
    ]);

    // Data valid
}
```

## Error Page
Laravel secara otomatis mengarahkan kembali pengguna ke halaman sebelumnya dengan error validasi jika validasi gagal.

## Error Directive
Menampilkan error validasi di Blade.
```html
@error('title')
    <div class="alert alert-danger">{{ $message }}</div>
@enderror
```

## Repopulating Forms
Laravel secara otomatis akan mengisi kembali input form dengan data yang terakhir divalidasi.

## Custom Request
Membuat kelas form request kustom untuk mengisolasi logika validasi.
```bash
php artisan make:request StorePostRequest
```
Contoh `StorePostRequest.php`:
```php
namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class StorePostRequest extends FormRequest
{
    public function authorize(): bool
    {
        return true; // Atau logika otorisasi
    }

    public function rules(): array
    {
        return [
            'title' => 'required|unique:posts|max:255',
            'body' => 'required',
        ];
    }
}
```
Penggunaan di controller:
```php
use App\Http\Requests\StorePostRequest;

public function store(StorePostRequest $request)
{
    $validated = $request->validated();
    // Data valid
}
```
# Laravel Security
## Pengenalan Laravel Security
Laravel menyediakan berbagai fitur keamanan out-of-the-box untuk melindungi aplikasi web Anda dari kerentanan umum seperti serangan XSS, CSRF, dan injeksi SQL. Ini mencakup sistem autentikasi, otorisasi, enkripsi, dan hashing yang kuat.

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## User Model
Model `User` adalah titik awal untuk autentikasi.
```php
namespace App\Models;

use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;

class User extends Authenticatable
{
    use Notifiable;

    protected $fillable = [
        'name', 'email', 'password',
    ];

    protected $hidden = [
        'password', 'remember_token',
    ];
}
```

## Laravel Breeze
Laravel Breeze adalah implementasi minimal dan sederhana dari semua fitur autentikasi Laravel, termasuk login, registrasi, reset password, verifikasi email, dan konfirmasi password.
Instalasi:
```bash
composer require laravel/breeze --dev
php artisan breeze:install
php artisan migrate
npm install && npm run dev
```

## Authentication
Laravel menyediakan sistem autentikasi yang lengkap.
Mengecek apakah user sudah login:
```php
if (Auth::check()) {
    // User sudah login
}
```
Mengakses user yang sedang login:
```php
$user = Auth::user();
```

## User Session
Informasi user yang terautentikasi disimpan dalam session.

## Hash Facade
Facade `Hash` menyediakan hashing Bcrypt dan Argon2 yang aman untuk menyimpan password.
```php
use Illuminate\Support\Facades\Hash;

$hashedPassword = Hash::make('plain_text_password');

if (Hash::check('plain_text_password', $hashedPassword)) {
    // Password cocok
}
```

## Auth Config
Konfigurasi autentikasi utama berada di `config/auth.php`.

## Authentication Middleware
Middleware `auth` digunakan untuk melindungi rute agar hanya dapat diakses oleh user yang sudah login.
```php
Route::get('/profile', function () {
    // Hanya user yang login yang bisa mengakses
})->middleware('auth');
```

## Guard
Guard mendefinisikan bagaimana user diautentikasi dan bagaimana mereka disimpan untuk setiap request. Defaultnya adalah `web` dan `api`.

## User Provider
User provider mendefinisikan bagaimana user diambil dari penyimpanan persisten Anda (biasanya database).

## Authorization
Otorisasi adalah tentang menentukan apakah user yang diautentikasi memiliki izin untuk melakukan tindakan tertentu.

## Gates
Gates adalah closure sederhana yang menentukan apakah user diizinkan untuk melakukan tindakan tertentu.
Mendefinisikan Gate di `AuthServiceProvider`:
```php
use Illuminate\Support\Facades\Gate;

Gate::define('update-post', function (User $user, Post $post) {
    return $user->id === $post->user_id;
});
```

## Gate Facade
Menggunakan Gate Facade untuk memeriksa otorisasi.
```php
if (Gate::allows('update-post', $post)) {
    // User diizinkan
}
```

## Gate Response
Gate dapat mengembalikan instance `Illuminate\Auth\Access\Response` untuk memberikan pesan error kustom.

## Policies
Policies adalah kelas yang mengorganisir logika otorisasi pada resource atau model tertentu.
Membuat Policy:
```bash
php artisan make:policy PostPolicy --model=Post
```
Contoh `PostPolicy.php`:
```php
namespace App\Policies;

use App\Models\User;
use App\Models\Post;

class PostPolicy
{
    public function update(User $user, Post $post): bool
    {
        return $user->id === $post->user_id;
    }
}
```

## Authorizable
Trait `Authorizable` pada model `User` menyediakan helper untuk memeriksa otorisasi.

## Authorize Request
Menggunakan policy di controller:
```php
public function update(Request $request, Post $post)
{
    $this->authorize('update', $post);

    // Update post
}
```

## Blade Template
Menggunakan direktif Blade untuk otorisasi.
```html
@can('update-post', $post)
    <button>Update Post</button>
@endcan
```

## Guest Access
Memeriksa apakah user adalah guest (belum login).
```html
@guest
    <a href="/login">Login</a>
@endguest
```

## Before dan After
Metode `before` dan `after` dalam policy dapat digunakan untuk memberikan izin superuser atau melakukan logging.

## Encryption
Laravel menyediakan layanan enkripsi yang kuat untuk mengenkripsi nilai menggunakan OpenSSL.
```php
use Illuminate\Support\Facades\Crypt;

$encrypted = Crypt::encryptString('data rahasia');
$decrypted = Crypt::decryptString($encrypted);
```
# Laravel Redis
## Laravel Redis
Laravel menyediakan integrasi yang mulus dengan Redis, database key-value store open-source yang cepat. Redis dapat digunakan sebagai cache, antrean, atau database umum.

## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Redis Facade
Anda dapat berinteraksi dengan Redis menggunakan Facade `Redis`.
```php
use Illuminate\Support\Facades\Redis;

Redis::set('name', 'Taylor');
$name = Redis::get('name');
```

## String
Operasi dasar pada tipe data string.
```php
Redis::set('key', 'value');
$value = Redis::get('key');
Redis::incr('counter'); // Increment
Redis::decr('counter'); // Decrement
```

## List
Operasi pada tipe data list.
```php
Redis::rpush('list', 'item1', 'item2'); // Push ke kanan
$item = Redis::lpop('list'); // Pop dari kiri
```

## Set
Operasi pada tipe data set (kumpulan unik).
```php
Redis::sadd('myset', 'member1', 'member2');
$members = Redis::smembers('myset');
```

## Sorted Set
Operasi pada tipe data sorted set (set dengan skor).
```php
Redis::zadd('myzset', 1, 'member1', 2, 'member2');
$members = Redis::zrange('myzset', 0, -1, 'WITHSCORES');
```

## Hash
Operasi pada tipe data hash (objek).
```php
Redis::hset('user:1', 'name', 'John', 'email', 'john@example.com');
$user = Redis::hgetall('user:1');
```

## Geo Point
Menyimpan koordinat geografis.
```php
Redis::geoadd('locations', 13.361389, 38.115556, 'Palermo');
```

## Hyper Log Log
Untuk menghitung perkiraan jumlah elemen unik.
```php
Redis::pfadd('visitors', 'user1', 'user2', 'user1');
$count = Redis::pfcount('visitors');
```

## Pipeline
Mengirim beberapa perintah Redis dalam satu round trip untuk meningkatkan performa.
```php
$results = Redis::pipeline(function ($pipe) {
    $pipe->set('foo', 'bar');
    $pipe->get('foo');
});
```

## Transaction
Menjalankan beberapa perintah sebagai operasi atomik.
```php
$results = Redis::transaction(function ($tx) {
    $tx->set('foo', 'bar');
    $tx->get('foo');
});
```

## PubSub
Menerbitkan dan berlangganan pesan.
```php
// Subscribe
Redis::subscribe(['channel'], function ($message) {
    echo $message;
});

// Publish
Redis::publish('channel', 'Hello world!');
```

## Stream
Tipe data stream untuk log dan event.

## Cache
Redis sering digunakan sebagai driver cache default di Laravel.
Konfigurasi di `config/cache.php` dan `.env`:
```
CACHE_DRIVER=redis
```
Menggunakan cache:
```php
use Illuminate\Support\Facades\Cache;

Cache::put('key', 'value', $minutes);
$value = Cache::get('key');
```

## Session
Redis juga dapat digunakan sebagai driver session.
Konfigurasi di `config/session.php` dan `.env`:
```
SESSION_DRIVER=redis
```

## Rate Limiting
Menggunakan Redis untuk implementasi rate limiting.
```php
use Illuminate\Support\Facades\RateLimiter;

$executed = RateLimiter::attempt(
    'send-message:'.$user->id,
    $perMinute = 5,
    function () {
        // Kirim pesan
    }
);

if (! $executed) {
    return 'Terlalu banyak pesan dikirim!';
}
```
# Laravel HTTP
## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## HTTP Client
Laravel menyediakan HTTP client yang ekspresif dan minimalis untuk melakukan request HTTP ke layanan lain.
```php
use Illuminate\Support\Facades\Http;

$response = Http::get('http://example.com');
```

## HTTP Method
Melakukan request dengan berbagai metode HTTP.
```php
$response = Http::post('http://example.com/users', [
    'name' => 'John Doe',
    'email' => 'john@example.com',
]);

$response = Http::put('http://example.com/users/1', [
    'name' => 'Jane Doe',
]);

$response = Http::delete('http://example.com/users/1');
```

## Response
Mengakses response dari request HTTP.
```php
$response = Http::get('http://example.com/users/1');

$data = $response->json(); // Mengambil response JSON
$status = $response->status(); // Mengambil status code
$ok = $response->ok(); // Mengecek apakah status code 2xx
```

## Query Parameter
Menambahkan query parameter ke request.
```php
$response = Http::get('http://example.com/search', ['name' => 'Taylor']);
```

## Header
Menambahkan header ke request.
```php
$response = Http::withHeaders([
    'X-First' => 'foo',
    'X-Second' => 'bar'
])->post('http://example.com/users', [
    'name' => 'Taylor',
]);
```

## Cookie
Mengirim cookie dengan request.
```php
$response = Http::withCookies(['name' => 'value'], 'example.com')
                ->get('http://example.com');
```

## Form Post
Mengirim data form-urlencoded.
```php
$response = Http::asForm()->post('http://example.com/users', [
    'name' => 'Taylor',
    'role' => 'Developer',
]);
```

## Multipart
Mengirim request multipart (misalnya, untuk upload file).
```php
$response = Http::attach(
    'attachment', file_get_contents('photo.jpg'), 'photo.jpg'
)->post('http://example.com/attachments');
```

## JSON
Mengirim request JSON.
```php
$response = Http::post('http://example.com/users', [
    'name' => 'Taylor',
    'email' => 'taylor@example.com',
]);
```

## Timeout
Menentukan batas waktu untuk request.
```php
$response = Http::timeout(3)->get('http://example.com');
```

## Retry
Mencoba kembali request jika gagal.
```php
$response = Http::retry(3, 100)->post('http://example.com/users', [
    'name' => 'Taylor',
]);
```

## Throw Error
Secara otomatis melemparkan `Illuminate\Http\Client\RequestException` jika status code adalah 4xx atau 5xx.
```php
$response = Http::get('http://example.com/non-existent-page')->throw();
```
# Laravel 11
## Membuat Project
(Asumsi project sudah dibuat, jika belum, gunakan `composer create-project laravel/laravel nama-project-anda`)

## Struktur Folder Lebih Sederhana
Laravel 11 memperkenalkan struktur folder yang lebih ramping, dengan beberapa file konfigurasi dipindahkan ke dalam file `config/app.php` atau dihapus jika tidak lagi diperlukan.

## Config File Lebih Sederhana
Banyak file konfigurasi default telah disederhanakan atau digabungkan untuk mengurangi boilerplate.

## Service Provider Lebih Sederhana
Beberapa service provider default telah dihapus atau digabungkan, membuat `AppServiceProvider` lebih bersih.

## Routing Lebih Sederhana
File routing default telah disederhanakan, dengan `web.php` dan `api.php` menjadi lebih minimalis.

## API Route Optional
File `api.php` sekarang bersifat opsional dan hanya akan dimuat jika Anda mengaktifkannya.

## Middleware Lebih Sederhana
Middleware default telah disederhanakan, dan beberapa middleware yang kurang umum telah dihapus.

## Health Check
Laravel 11 menyertakan fitur health check bawaan untuk memantau status aplikasi Anda.
```php
Route::get('/up', function () {
    return response('OK', 200);
});
```

## Perintah Artisan Baru
Beberapa perintah Artisan baru telah ditambahkan untuk meningkatkan pengalaman developer.

## Integrasi dengan Pest Unit Test
Pest menjadi framework pengujian default untuk project Laravel baru.

## Default Database Sqlite
Project Laravel baru sekarang menggunakan SQLite sebagai database default.

## Exception Handler Lebih Sederhana
Penanganan exception telah disederhanakan, dengan `Handler.php` yang lebih ringkas.

## Once Helper Method
Helper `once()` baru memungkinkan Anda untuk menjalankan closure hanya sekali selama siklus hidup request.
```php
$value = once(function () {
    return rand(1, 100);
});
```

## Model Casts
Peningkatan pada model casts untuk penanganan tipe data yang lebih baik.

## Upgrade dari Laravel 10
Proses upgrade dari Laravel 10 ke Laravel 11 telah disederhanakan dengan panduan yang jelas.

# Laravel 12
## Pengenalan Laravel 12
Laravel 12 adalah versi terbaru dari framework PHP Laravel, yang membawa berbagai peningkatan, fitur baru, dan optimasi untuk pengalaman pengembangan yang lebih baik.

## Fitur Baru Laravel 12
*   **Peningkatan Performa:** Optimasi internal untuk kecepatan eksekusi yang lebih cepat.
*   **Penyederhanaan Konfigurasi:** Lebih banyak opsi konfigurasi yang disederhanakan atau dihapus untuk mengurangi boilerplate.
*   **Peningkatan Keamanan:** Perbaikan dan fitur keamanan baru untuk melindungi aplikasi dari ancaman terbaru.
*   **Peningkatan Developer Experience:** Alat-alat baru dan perbaikan pada alat yang sudah ada untuk membuat pengembangan lebih menyenangkan dan efisien.

## Peningkatan Performa
Laravel 12 fokus pada peningkatan performa di berbagai area, termasuk waktu booting aplikasi, pemrosesan request, dan operasi database.

## Perubahan Breaking
Seperti setiap rilis mayor, Laravel 12 mungkin memiliki beberapa perubahan breaking. Penting untuk meninjau dokumentasi resmi untuk daftar lengkap perubahan ini sebelum melakukan upgrade.

## Upgrade dari Laravel 11
Proses upgrade dari Laravel 11 ke Laravel 12 akan didokumentasikan dengan baik di panduan upgrade resmi Laravel, yang mencakup langkah-langkah yang diperlukan untuk memigrasikan aplikasi Anda dengan lancar.