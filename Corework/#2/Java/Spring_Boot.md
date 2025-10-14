# ☕ Spring Boot

## 核心 Spring Core

### 📖 Pengenalan Spring

Spring adalah framework Java yang paling populer untuk membangun aplikasi enterprise. Fokus utamanya adalah menyediakan infrastruktur yang komprehensif untuk memudahkan developer fokus pada logika bisnis. Prinsip utamanya adalah **Inversion of Control (IoC)** dan **Dependency Injection (DI)**, yang membuat aplikasi menjadi modular, fleksibel, dan mudah diuji.

### 🔄 Inversion of Control (IoC)

Inversion of Control adalah sebuah prinsip di mana alur kerja program "dibalikkan". Alih-alih komponen aplikasi membuat dan mengelola dependensinya sendiri, tugas tersebut diserahkan kepada sebuah kekuatan dari luar, yaitu **Spring IoC Container**. Ini membuat komponen lebih mandiri dan tidak terikat erat satu sama lain.

**Tanpa IoC:**

```java
public class OrderService {
    // OrderService membuat sendiri dependensinya
    private final OrderRepository repository = new OrderRepository();
}
```

**Dengan IoC:**

```java
public class OrderService {
    // Dependensi akan diberikan oleh container
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
}
```

### 📦 Application Context

`ApplicationContext` adalah interface utama untuk Spring IoC Container. Ia bertanggung jawab untuk:

1. Membuat dan mengelola siklus hidup objek (Bean).
2. Merakit konfigurasi aplikasi.
3. Menyediakan dependensi (Dependency Injection).

Di aplikasi Spring Boot, `ApplicationContext` dibuat dan dikonfigurasi secara otomatis.

```java
// Di balik layar, Spring Boot melakukan ini untuk Anda
ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

// Anda bisa meminta bean dari context
OrderService orderService = context.getBean(OrderService.class);
```

### 🥇 Singleton

Secara default, semua bean yang dikelola oleh Spring adalah **singleton**. Artinya, Spring IoC Container hanya akan membuat **satu instans** dari bean tersebut untuk seluruh aplikasi. Setiap kali ada permintaan untuk bean tersebut, container akan mengembalikan instans yang sama.

Ini sangat efisien untuk objek yang *stateless* seperti service, repository, atau controller.

### 🫘 Bean

Bean adalah objek yang diinstansiasi, dirakit, dan dikelola oleh Spring IoC Container. Untuk mendaftarkan sebuah kelas sebagai bean, Anda bisa menggunakan anotasi `@Component` atau variasinya (`@Service`, `@Repository`, `@Controller`).

```java
@Component // Menandai kelas ini sebagai bean
public class MyComponent {
    public String sayHello() {
        return "Hello from MyComponent!";
    }
}
```

### 🎭 Duplicate Bean

Jika Spring menemukan dua atau lebih bean dengan tipe yang sama, aplikasi akan gagal dijalankan karena kebingungan saat melakukan dependency injection. Ini disebut *duplicate bean definition*.

```java
@Component
public class BeanA implements MyInterface {}

@Component
public class BeanB implements MyInterface {}

// Error akan terjadi di sini karena ada dua implementasi MyInterface
@Autowired
private MyInterface myInterface;
```

### 🏆 Primary Bean

Untuk mengatasi masalah *duplicate bean*, Anda bisa menandai salah satu bean sebagai `@Primary`. Bean ini akan menjadi pilihan utama jika ada beberapa kandidat dengan tipe yang sama.

```java
@Primary // Bean ini akan diutamakan
@Component
public class BeanA implements MyInterface {}

@Component
public class BeanB implements MyInterface {}
```

### 🏷️ Mengubah Nama Bean

Secara default, nama bean adalah nama kelasnya dalam format `camelCase` (contoh: `myComponent`). Anda bisa memberikan nama kustom dengan menuliskannya di dalam anotasi.

```java
@Component("customNameForMyBean")
public class MyComponent {
    // ...
}
```

### 💉 Dependency Injection (DI)

Dependency Injection adalah proses di mana Spring IoC Container secara otomatis menyediakan (menyuntikkan) dependensi yang dibutuhkan oleh sebuah bean. Ada tiga cara utama untuk melakukan DI:

1. **Constructor-based DI (Cara Terbaik)**: Dependensi di-inject melalui constructor. Ini memastikan objek selalu dalam keadaan valid setelah dibuat.
2. **Setter-based DI**: Dependensi di-inject melalui method setter.
3. **Field-based DI**: Dependensi di-inject langsung ke field. **Tidak direkomendasikan** karena menyulitkan testing dan bisa menyembunyikan dependensi.

### 🤔 Memilih Dependency

Ketika terjadi ambiguitas (seperti *duplicate bean*), selain menggunakan `@Primary`, Anda bisa menggunakan anotasi `@Qualifier` untuk memilih bean secara spesifik berdasarkan namanya.

```java
@Autowired
@Qualifier("beanB") // Secara eksplisit meminta bean dengan nama "beanB"
private MyInterface myInterface;
```

### 🔄 Circular Dependencies

Circular dependency terjadi ketika dua bean atau lebih saling membutuhkan satu sama lain. Contoh: `BeanA` butuh `BeanB`, dan `BeanB` butuh `BeanA`. Spring bisa menangani *circular dependency* untuk *constructor injection* jika salah satu bean dibuat secara *lazy* (`@Lazy`), tetapi ini adalah pertanda desain yang buruk dan sebaiknya dihindari.

### 🔗 Depends On

Anotasi `@DependsOn` digunakan untuk memaksa sebuah bean diinisialisasi **setelah** bean lain diinisialisasi. Ini jarang digunakan, tetapi berguna jika ada dependensi implisit yang tidak bisa dideteksi oleh Spring.

```java
@Component
@DependsOn("databaseInitializer")
public class MyService {
    // ...
}
```

### 😴 Lazy Bean

Secara default, semua bean singleton dibuat saat aplikasi pertama kali berjalan. Dengan anotasi `@Lazy`, Anda bisa menunda pembuatan bean hingga ia pertama kali dibutuhkan. Ini bisa mempercepat waktu startup aplikasi.

```java
@Lazy
@Component
public class LazyComponent {
    public LazyComponent() {
        System.out.println("LazyComponent created!");
    }
}
```

### 🎯 Scope

Scope menentukan siklus hidup dari sebuah bean.

* `singleton`: (Default) Satu instans per Spring container.
* `prototype`: Instans baru dibuat setiap kali bean diminta.
* `request`: Satu instans per HTTP request (hanya di aplikasi web).
* `session`: Satu instans per HTTP session (hanya di aplikasi web).

```java
@Component
@Scope("prototype")
public class PrototypeBean {}
```

### ✨ Membuat Scope

Anda bisa membuat scope kustom dengan mengimplementasikan interface `Scope` dari Spring. Ini adalah fitur lanjutan yang jarang dibutuhkan.

### ♻️ Life Cycle

Bean di Spring memiliki siklus hidup yang bisa kita masuki menggunakan:

1. **Callback Interface**: Mengimplementasikan `InitializingBean` (`afterPropertiesSet()`) dan `DisposableBean` (`destroy()`).
2. **Lifecycle Annotations**: Menggunakan `@PostConstruct` dan `@PreDestroy`.

### 🏁 Life Cycle Annotation

Menggunakan anotasi adalah cara yang lebih modern dan disarankan.

* `@PostConstruct`: Method dengan anotasi ini akan dieksekusi **setelah** dependency injection selesai.
* `@PreDestroy`: Method dengan anotasi ini akan dieksekusi **sebelum** bean dihancurkan.

```java
@Component
public class MyBean {
    @PostConstruct
    public void init() {
        System.out.println("MyBean has been initialized.");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("MyBean is about to be destroyed.");
    }
}
```

### 📥 Import

Anotasi `@Import` digunakan untuk mengimpor satu atau lebih kelas konfigurasi (`@Configuration`) ke dalam konfigurasi utama.

```java
@Configuration
@Import(DatabaseConfig.class)
public class AppConfig {
    // ...
}
```

### 🗺️ Component Scan

Spring secara otomatis memindai (scan) package di bawah kelas aplikasi utama (`@SpringBootApplication`) untuk mencari kelas dengan anotasi `@Component` (dan variasinya). Anda bisa menyesuaikan lokasi pemindaian dengan `@ComponentScan`.

```java
@SpringBootApplication
@ComponentScan(basePackages = {"com.codedhims.service", "com.codedhims.repository"})
public class MyApplication {}
```

### 🧩 Component

`@Component` adalah anotasi stereotype generik. Semua anotasi stereotype lain (`@Service`, `@Repository`, `@Controller`, `@Configuration`) secara internal juga ditandai sebagai `@Component`.

### 🏗️ Constructor-based Dependency Injection

Cara DI yang paling direkomendasikan. Dependensi dideklarasikan sebagai `final` dan diinisialisasi melalui constructor. Ini menjamin *immutability* dan mencegah *null state*.

```java
@Service
public class MyService {
    private final MyRepository repository;

    @Autowired // Anotasi ini opsional jika hanya ada satu constructor
    public MyService(MyRepository repository) {
        this.repository = repository;
    }
}
```

### 🔧 Setter-based Dependency Injection

DI melalui method setter. Berguna untuk dependensi yang opsional.

```java
@Service
public class MyService {
    private MyRepository repository;

    @Autowired
    public void setRepository(MyRepository repository) {
        this.repository = repository;
    }
}
```

### 📝 Field-based Dependency Injection

DI langsung pada field. **Tidak direkomendasikan** karena membuat kode sulit diuji dan menyembunyikan dependensi.

```java
@Service
public class MyService {
    @Autowired
    private MyRepository repository; // Hindari cara ini
}
```

### 🏅 Qualifier

Digunakan bersama `@Autowired` untuk memilih bean spesifik berdasarkan namanya ketika ada beberapa kandidat dengan tipe yang sama.

```java
public interface MessageService {
    String getMessage();
}

@Component("smsService")
public class SmsService implements MessageService { ... }

@Component("emailService")
public class EmailService implements MessageService { ... }

// Penggunaan
@Autowired
@Qualifier("emailService")
private MessageService messageService;
```

### ❓ Optional Dependency

Jika sebuah dependensi mungkin tidak selalu ada, Anda bisa membuatnya opsional. Di C# 8+, Anda bisa menggunakan `required = false` pada `@Autowired` atau menggunakan `Optional<T>` dari Java 8.

```java
// Cara 1: required = false
@Autowired(required = false)
private OptionalService optionalService;

// Cara 2: Java Optional (lebih disarankan)
private final Optional<OptionalService> optionalService;

public MyComponent(Optional<OptionalService> optionalService) {
    this.optionalService = optionalService;
}
```

### 🏭 Factory Bean

`FactoryBean` adalah sebuah interface yang bisa Anda implementasikan untuk membuat bean dengan logika yang kompleks. Ini berguna ketika proses pembuatan objek tidak sederhana.

### 👨‍👩‍👧‍👦 Inheritance

Konfigurasi bean juga mendukung pewarisan. Jika sebuah bean anak tidak mendefinisikan properti tertentu, ia bisa mewarisinya dari konfigurasi bean induk.

### 🏭 Bean Factory

`BeanFactory` adalah interface dasar dari IoC container. `ApplicationContext` adalah sub-interface dari `BeanFactory` yang menyediakan lebih banyak fitur enterprise.

### 🛠️ Bean Post Processor

`BeanPostProcessor` adalah interface yang memungkinkan Anda untuk menambahkan logika kustom **sebelum** dan **sesudah** inisialisasi sebuah bean. Ini adalah mekanisme ekstensi yang sangat kuat di Spring.

### 🔢 Ordered

Interface `Ordered` atau anotasi `@Order` bisa digunakan untuk menentukan urutan eksekusi dari komponen seperti `BeanPostProcessor` atau `EventListener`.

### 🧠 Aware

Spring menyediakan serangkaian interface `Aware` (seperti `ApplicationContextAware`, `BeanNameAware`) yang memungkinkan sebuah bean untuk "sadar" akan lingkungannya di dalam container.

### 🏭 Bean Factory Post Processor

Mirip `BeanPostProcessor`, tetapi `BeanFactoryPostProcessor` beroperasi pada **definisi bean** (metadata konfigurasi), bukan pada instans bean itu sendiri. Ini dieksekusi sebelum bean mulai dibuat.

### 🎧 Event Listener

Spring memiliki mekanisme *event-driven*. Anda bisa mempublikasikan event kustom dan membuat listener untuk menangani event tersebut.

```java
// Membuat event
public class MyCustomEvent extends ApplicationEvent { ... }

// Membuat listener
@Component
public class MyCustomEventListener implements ApplicationListener<MyCustomEvent> {
    @Override
    public void onApplicationEvent(MyCustomEvent event) {
        System.out.println("Event diterima: " + event.getMessage());
    }
}

// Mempublikasikan event
@Autowired
private ApplicationEventPublisher publisher;
publisher.publishEvent(new MyCustomEvent(this, "Pesan penting!"));
```

### 🎧 Event Listener Annotation

Cara yang lebih mudah untuk membuat listener adalah dengan anotasi `@EventListener`.

```java
@Component
public class MyAnnotatedListener {
    @EventListener
    public void handleMyCustomEvent(MyCustomEvent event) {
        System.out.println("Event diterima (anotasi): " + event.getMessage());
    }
}
```

### 🚀 Spring Boot Application

Anotasi `@SpringBootApplication` adalah anotasi utama yang terdiri dari tiga anotasi:

1. `@EnableAutoConfiguration`: Mengaktifkan mekanisme auto-configuration Spring Boot.
2. `@ComponentScan`: Memindai komponen (bean) di package saat ini dan sub-package-nya.
3. `@Configuration`: Menandai kelas sebagai sumber definisi bean.

### 💥 Startup Failure

Spring Boot menyediakan `FailureAnalyzers` yang akan memberikan laporan diagnostik yang jelas jika aplikasi gagal dijalankan, misalnya karena port sudah digunakan atau ada *duplicate bean*.

### 🖼️ Banner

Anda bisa mengubah banner startup Spring Boot dengan menambahkan file `banner.txt` di `src/main/resources`.

### ⚙️ Customizing Spring Application

Anda bisa mengkustomisasi perilaku `SpringApplication` menggunakan `SpringApplicationBuilder` atau dengan memanggil method setter sebelum `run()`.

```java
new SpringApplicationBuilder(MyApplication.class)
    .bannerMode(Banner.Mode.OFF) // Mematikan banner
    .run(args);
```

### 🎉 Spring Application Event

Spring Boot mempublikasikan beberapa event selama siklus hidup aplikasi, seperti `ApplicationStartingEvent`, `ApplicationReadyEvent`, yang bisa Anda tangani dengan `EventListener`.

### 🏃 Command Line Runner

Interface `CommandLineRunner` digunakan untuk mengeksekusi kode **setelah** `ApplicationContext` selesai dimuat. Berguna untuk tugas inisialisasi data.

```java
@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplikasi siap, menjalankan command line runner...");
    }
}
```

### 🏃 Application Runner

Sama seperti `CommandLineRunner`, tetapi `ApplicationRunner` menyediakan akses ke argumen aplikasi dalam bentuk yang lebih terstruktur (`ApplicationArguments`).

### 🔌 Spring Boot Plugin

Plugin Maven (`spring-boot-maven-plugin`) atau Gradle (`org.springframework.boot`) sangat penting. Plugin ini bertanggung jawab untuk:

1. Mem-build satu file JAR/WAR yang *executable*.
2. Menjalankan aplikasi.
3. Mengelola dependensi.

---

## ⚙️ Spring Config Properties

### 📖 Pengenalan Config Properties

Spring Boot memungkinkan konfigurasi aplikasi dieksternalisasi, sehingga Anda bisa menjalankan aplikasi yang sama dengan konfigurasi berbeda di environment yang berbeda (development, production).

### 📦 Resource

Spring memiliki abstraksi `Resource` untuk mengakses file dari berbagai sumber, seperti classpath, filesystem, atau URL.

### 🔎 Resource Loader

`ResourceLoader` adalah komponen yang digunakan untuk mendapatkan `Resource`. `ApplicationContext` sendiri adalah sebuah `ResourceLoader`.

### 💬 Message Source

`MessageSource` adalah interface untuk mendukung internasionalisasi (i18n), memungkinkan aplikasi menggunakan pesan teks yang berbeda untuk bahasa yang berbeda.

### 🚀 Spring Boot Message Source

Spring Boot secara otomatis mengonfigurasi `MessageSource` jika menemukan file `messages.properties` di `src/main/resources`.

### 📝 Application Properties

File utama untuk konfigurasi eksternal. Spring Boot akan otomatis memuat properti dari file `application.properties` atau `application.yml`.

### 🌳 Environment

Abstraksi `Environment` di Spring merepresentasikan lingkungan di mana aplikasi berjalan. Ini mencakup *profiles* dan *properties*.

### 밸 Value

Anotasi `@Value` adalah cara paling sederhana untuk meng-inject satu nilai properti ke dalam sebuah field di bean.

```java
@Value("${app.version}")
private String appVersion;
```

### 📜 Property Source

`@PropertySource` digunakan untuk menambahkan file properti tambahan selain `application.properties` ke dalam `Environment` Spring.

```java
@Configuration
@PropertySource("classpath:custom.properties")
public class CustomConfig {}
```

### ✅ Test Property Source

`@TestPropertySource` adalah anotasi untuk pengujian yang memungkinkan Anda meng-override properti aplikasi khusus untuk sebuah tes.

### 👤 Profile

Profil adalah cara untuk memisahkan bagian-bagian dari konfigurasi aplikasi dan membuatnya aktif hanya di environment tertentu. Contoh profil umum: `dev`, `qa`, `prod`.

Anda bisa menandai bean agar hanya aktif di profil tertentu dengan `@Profile`.

```java
@Component
@Profile("prod") // Bean ini hanya aktif jika profil 'prod' aktif
public class ProductionComponent {}
```

### 📄 Profile Properties File

Anda bisa menyediakan file properti spesifik untuk setiap profil dengan format `application-{profile}.properties`. Contoh: `application-dev.properties` akan aktif jika profil `dev` aktif.

### 🧩 Configuration Properties

Cara yang lebih modern dan *type-safe* untuk mengelola properti adalah dengan `@ConfigurationProperties`. Ini memungkinkan Anda mem-binding sekelompok properti ke dalam sebuah objek (POJO).

```java
// POJO untuk menampung properti
@ConfigurationProperties(prefix = "app.datasource")
public class AppDataSource {
    private String url;
    private String username;
    // getter & setter
}

// Mengaktifkannya di kelas konfigurasi utama
@EnableConfigurationProperties(AppDataSource.class)
```

### 🔗 Complex Configuration Properties

`@ConfigurationProperties` juga mendukung properti yang kompleks, seperti nested object dan list.

### 📚 Collection Configuration Properties

Anda bisa mem-binding properti ke dalam `List` atau `Map`.

**YAML:**

```yaml
app:
  servers:
    - host: server1.com
      port: 8080
    - host: server2.com
      port: 8081
```

**Java:**

```java
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private List<Server> servers;
    // ...
}
```

### 🔄 Conversion

Spring bisa secara otomatis mengonversi properti dari `String` ke tipe data target seperti `int`, `boolean`, atau bahkan `Duration` (contoh: `10s` untuk 10 detik).

### 🛠️ Conversion Service

Anda bisa mendaftarkan `Converter` kustom Anda sendiri jika Spring tidak tahu cara mengonversi tipe data tertentu.

### 📤 Externalized Properties File

Spring Boot mencari file `application.properties` di beberapa lokasi dengan urutan prioritas tertentu, termasuk di luar JAR aplikasi. Ini memungkinkan admin sistem untuk mengubah konfigurasi tanpa perlu membangun ulang aplikasi.

### 🌍 Environment Variable

Properti juga bisa di-override menggunakan *environment variable*. Contoh: `SERVER_PORT=9000` akan meng-override `server.port`.

### 🎭 Mengubah Profile

Profil aktif bisa diatur melalui properti `spring.profiles.active` di `application.properties` atau melalui argumen saat menjalankan aplikasi.

```bash
java -jar myapp.jar --spring.profiles.active=prod
```

### 🌀 Yaml

YAML (`.yml`) adalah alternatif dari `.properties` yang lebih mudah dibaca untuk konfigurasi hierarkis. Jika kedua file ada, `.properties` akan lebih diutamakan.

---

## 🪵 Spring Logging

### 📖 Pengenalan Spring Logging

Spring Boot menggunakan **Commons Logging** sebagai abstraksi dan menyediakan konfigurasi default untuk logging framework populer seperti **Logback** (default), Log4j2, dan Java Util Logging.

### ⚙️ Default Logging Setting

Secara default, Spring Boot mencetak log dengan level `INFO` ke konsol.

### 📊 Logging Level

Anda bisa mengatur level logging (`TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR`) di `application.properties`.

```properties
# Mengatur level logging untuk semua kelas di package com.codedhims menjadi DEBUG
logging.level.com.codedhims=DEBUG

# Mengatur level root logger
logging.level.root=WARN
```

### 📁 File Output

Mencetak log ke file.

```properties
logging.file.name=app.log
logging.file.path=/var/logs/
```

### 🗃️ File Rolling

*File rolling* adalah proses membuat file log baru ketika file log saat ini mencapai ukuran tertentu atau periode waktu tertentu. Ini dikonfigurasi di file konfigurasi logging framework (misal: `logback-spring.xml`).

### 👨‍👩‍👧‍👦 Log Group

Anda bisa mengelompokkan beberapa package untuk diatur level logging-nya secara bersamaan.

```properties
logging.group.my-app=com.codedhims.web, com.codedhims.service
logging.level.my-app=DEBUG
```

### 🎨 Log Pattern

Mengubah format output dari pesan log.

```properties
logging.pattern.console=%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n
```

### ✍️ Custom Log Configuration

Untuk konfigurasi yang lebih kompleks (seperti *file rolling*), buat file `logback-spring.xml` di `src/main/resources`.

---

## ✅ Spring Validation

### 📖 Pengenalan Spring Validation

Spring Boot terintegrasi dengan **Hibernate Validator**, implementasi dari spesifikasi **Bean Validation**. Ini memungkinkan validasi objek secara deklaratif menggunakan anotasi.

### ⚖️ Validator

Untuk memicu validasi, tambahkan anotasi `@Valid` pada objek yang ingin divalidasi di method controller.

```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    // ...
}
```

### 🏷️ Custom Constraint

Anda bisa membuat anotasi validasi kustom Anda sendiri.

### 💬 Message Source

Pesan error validasi bisa di-kustomisasi dan diinternasionalisasi menggunakan `MessageSource`.

### 📜 Method Validation

Anda juga bisa memvalidasi parameter dari sebuah method di dalam bean (misalnya di service) dengan anotasi `@Validated` pada kelasnya.

---

## 🎭 Spring AOP (Aspect-Oriented Programming)

### 📖 Pengenalan AOP

AOP adalah paradigma pemrograman yang bertujuan untuk memisahkan *cross-cutting concerns* (seperti logging, security, transaction management) dari logika bisnis utama. Ini dilakukan dengan menyisipkan *advice* (logika tambahan) pada titik-titik tertentu dalam eksekusi program.

* **Aspect**: Kelas yang membungkus *advice* dan *pointcut*.
* **Join Point**: Titik dalam eksekusi program di mana *advice* bisa disisipkan (misalnya, pemanggilan method).
* **Pointcut**: Ekspresi yang mendefinisikan di mana *advice* harus diterapkan (di *join point* mana saja).
* **Advice**: Aksi yang akan diambil. Jenis-jenisnya: `@Before`, `@After`, `@Around`.

### 🚀 Mengaktifkan AOP

Tambahkan dependensi `spring-boot-starter-aop`.

### ✨ Aspect, Join Point, Pointcut, Advice

```java
@Aspect
@Component
public class LoggingAspect {

    // Pointcut: Terapkan pada semua method di dalam ProductService
    @Pointcut("execution(* com.codedhims.service.ProductService.*(..))")
    public void productServiceMethods() {}

    // Advice: Jalankan sebelum method dieksekusi
    @Before("productServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }
}
```

---

## 🌐 Spring MVC (Model-View-Controller)

### 📖 Pengenalan MVC

MVC adalah pola desain arsitektur yang memisahkan aplikasi menjadi tiga komponen utama:

1. **Model**: Data dan logika bisnis.
2. **View**: Tampilan antarmuka pengguna (UI), seperti halaman HTML.
3. **Controller**: Menerima input dari pengguna dan berinteraksi dengan Model dan View.

### 🚀 Pengenalan Spring Web MVC

Spring Web MVC adalah framework untuk membangun aplikasi web berbasis pola MVC. Di Spring Boot, ini diaktifkan dengan `spring-boot-starter-web`.

### 🎮 Controller

Kelas yang ditandai dengan `@Controller` (untuk aplikasi web tradisional) atau `@RestController` (untuk REST API).

### 🗺️ Request Mapping

`@RequestMapping` dan variasinya (`@GetMapping`, `@PostMapping`, dll.) digunakan untuk memetakan URL request ke method controller.

### 🧪 Mock MVC

`MockMvc` adalah utilitas testing yang kuat untuk menguji controller Spring MVC tanpa perlu menjalankan server HTTP sungguhan.

### 🤝 Integration Test

Pengujian integrasi untuk web layer biasanya menggunakan `@SpringBootTest` dan `TestRestTemplate` untuk memanggil endpoint HTTP secara nyata.

### 📦 Request Body & Response Body

* `@RequestBody`: Mengonversi body request (JSON/XML) menjadi objek Java.
* `@ResponseBody`: (Sudah termasuk di `@RestController`) Mengonversi nilai kembalian method menjadi body response (JSON/XML).

### 📄 Form Request & Upload File

Spring MVC menyediakan dukungan untuk menangani data dari form HTML (`application/x-www-form-urlencoded`) dan upload file (`multipart/form-data`).

### 💯 Response Status & Response Entity

* `@ResponseStatus`: Cara mudah untuk mengatur status HTTP response.
* `ResponseEntity`: Objek yang merepresentasikan seluruh respons HTTP, termasuk status, header, dan body. Memberikan kontrol penuh atas respons.

```java
@GetMapping("/products/{id}")
public ResponseEntity<Product> getProduct(@PathVariable Long id) {
    Optional<Product> product = productService.findById(id);
    if (product.isPresent()) {
        return ResponseEntity.ok(product.get()); // Status 200 OK dengan body
    } else {
        return ResponseEntity.notFound().build(); // Status 404 Not Found
    }
}
```

### 🚨 Exception Handler

`@ExceptionHandler` digunakan untuk membuat method yang menangani exception spesifik yang terjadi di dalam controller, memungkinkan Anda mengembalikan respons error yang terstruktur.

### 📄 View & Redirect

Dalam aplikasi web non-API, controller bisa mengembalikan nama *view* (misalnya, nama file template Thymeleaf atau JSP). Anda juga bisa melakukan *redirect* ke URL lain.

---

## 🗃️ Spring Data JPA

### 📖 Pengenalan Spring Data JPA

Spring Data JPA adalah bagian dari proyek Spring Data yang bertujuan untuk menyederhanakan pengembangan layer akses data. Ia dibangun di atas **JPA (Jakarta Persistence API)** dan menyediakan implementasi repository secara otomatis.

### 💧 Data Source

`DataSource` adalah koneksi ke database. Spring Boot akan mengonfigurasinya secara otomatis jika menemukan driver database di classpath dan properti koneksi di `application.properties`.

### 🏛️ Repository

Di Spring Data, repository adalah sebuah interface. Anda cukup mendefinisikan interface yang `extends JpaRepository` atau `CrudRepository`, dan Spring akan menyediakan implementasinya saat runtime.

### transactional Declarative Transaction

Spring menyediakan dukungan transaksi yang kuat. Dengan anotasi `@Transactional` pada sebuah method, Spring akan memastikan bahwa semua operasi database di dalam method tersebut dieksekusi dalam satu transaksi. Jika terjadi error, transaksi akan di-rollback.

```java
@Service
public class TransferService {
    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        // 1. Kurangi saldo pengirim
        // 2. Tambah saldo penerima
        // Jika langkah 2 gagal, langkah 1 akan dibatalkan (rollback)
    }
}
```

### ❓ Query Method

Fitur paling kuat dari Spring Data. Anda cukup mendefinisikan nama method di interface repository Anda, dan Spring Data akan secara otomatis membuat query-nya berdasarkan nama method tersebut.

```java
public interface UserRepository extends JpaRepository<User, Long> {
    // SELECT u FROM User u WHERE u.email = ?1
    Optional<User> findByEmail(String email);

    // SELECT u FROM User u WHERE u.age > ?1
    List<User> findByAgeGreaterThan(int age);
}
```

### ✍️ @Query Annotation

Untuk query yang lebih kompleks, Anda bisa menuliskannya secara manual menggunakan anotasi `@Query` dengan JPQL (Jakarta Persistence Query Language) atau SQL native.

```java
@Query("SELECT u FROM User u WHERE u.status = :status AND u.name LIKE %:name%")
List<User> findUsersByStatusAndName(@Param("status") String status, @Param("name") String name);
```

### 🔄 @Modifying

Untuk query `UPDATE` atau `DELETE`, Anda perlu menambahkan anotasi `@Modifying` selain `@Query`.

### 監査 Auditing

Spring Data JPA menyediakan fitur auditing untuk secara otomatis mengisi properti seperti `createdBy`, `createdDate`, `lastModifiedBy`, dan `lastModifiedDate` pada entitas Anda.

### 📋 Specification

Spesifikasi (menggunakan `Specification` interface) adalah cara untuk membangun query secara dinamis dan *type-safe*. Berguna untuk membuat fitur pencarian dengan banyak kriteria opsional.

---

## 🌐 Spring REST API

Bagian ini akan membahas praktik terbaik dalam membangun REST API menggunakan Spring Boot.

### 成熟度 Richardson Maturity Model

Model ini mengklasifikasikan REST API ke dalam beberapa level kematangan:

* **Level 0**: Menggunakan HTTP sebagai protokol transport, tetapi tidak memanfaatkan mekanisme web (satu URL, satu method HTTP). Ini adalah *Plain Old XML (POX)*.
* **Level 1**: Menggunakan banyak URI untuk merepresentasikan *resource* yang berbeda. Contoh: `/products`, `/users`.
* **Level 2**: Menggunakan method HTTP secara semantik (`GET` untuk membaca, `POST` untuk membuat, `PUT` untuk memperbarui, `DELETE` untuk menghapus) dan menggunakan status code HTTP dengan benar (200, 201, 400, 404, 500).
* **Level 3**: Menggunakan **HATEOAS (Hypermedia as the Engine of Application State)**. Respons dari API tidak hanya berisi data, tetapi juga link (hypermedia) ke aksi atau resource lain yang relevan.

Spring Boot sangat memudahkan implementasi hingga Level 2. Untuk Level 3, Anda bisa menggunakan dependensi `spring-boot-starter-hateoas`.

### 📦 DTO (Data Transfer Object)

Sangat disarankan untuk **tidak** mengekspos entitas JPA (`@Entity`) secara langsung di API. Gunakan DTO, yaitu objek Java sederhana (POJO) yang dirancang khusus untuk membawa data antara client dan server. Ini memberikan beberapa keuntungan:

1. **Pemisahan Layer**: Memisahkan representasi API dari representasi database.
2. **Keamanan**: Mencegah eksposur field internal atau sensitif.
3. **Fleksibilitas**: API bisa mengembalikan data gabungan dari beberapa entitas.

```java
// DTO untuk request pembuatan produk
public record ProductRequest(String name, double price) {}

// DTO untuk respons
public record ProductResponse(Long id, String name) {}
```

### 🔢 Versioning

Sangat penting untuk me-versi-kan API Anda agar perubahan di masa depan tidak merusak aplikasi client yang sudah ada. Beberapa strategi versioning:

1. **URI Versioning (Paling Umum)**: `https://api.example.com/v1/products`
2. **Query Parameter Versioning**: `https://api.example.com/products?version=1`
3. **Header Versioning**: Menggunakan header kustom seperti `X-API-VERSION: 1`.

---

## ⚡ Spring Async

### 📖 Pengenalan Spring Async

Spring menyediakan kemampuan untuk menjalankan method secara asinkron (di thread yang berbeda) dengan anotasi `@Async`. Ini berguna untuk operasi yang memakan waktu dan tidak perlu ditunggu hasilnya secara langsung, seperti mengirim email atau memproses file.

### ✅ Enable Async

Aktifkan dukungan async dengan menambahkan `@EnableAsync` di kelas konfigurasi utama Anda.

```java
@SpringBootApplication
@EnableAsync
public class MyApplication {}
```

### 💨 @Async

Tambahkan `@Async` pada method publik yang ingin Anda jalankan secara asinkron.

```java
@Service
public class EmailService {
    @Async
    public void sendEmail(String to, String subject, String body) {
        // Logika pengiriman email yang mungkin lambat
        System.out.println("Mengirim email ke " + to);
        // ...
        System.out.println("Email terkirim.");
    }
}
```

### 🔮 Future

Jika Anda butuh hasil dari method async, method tersebut bisa mengembalikan objek `Future<T>` atau, lebih baik lagi, `CompletableFuture<T>` dari Java 8.

```java
@Async
public CompletableFuture<User> findUser(String username) {
    // ... operasi database yang lambat
    return CompletableFuture.completedFuture(user);
}
```

### 🕒 Scheduling

Spring juga mendukung eksekusi tugas terjadwal.

### ✅ @Scheduled

Aktifkan dengan `@EnableScheduling` dan gunakan `@Scheduled` pada method untuk menjalankannya secara periodik. Mendukung `fixedRate`, `fixedDelay`, dan ekspresi `cron`.

```java
@Component
public class MyScheduledTasks {
    // Jalankan setiap 5 detik
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("Waktu sekarang: " + new Date());
    }

    // Jalankan setiap jam 1 pagi
    @Scheduled(cron = "0 0 1 * * ?")
    public void runDailyReport() {
        // ...
    }
}
```

---

## 🔬 Spring Monitoring

### 📖 Pengenalan Monitoring

Monitoring sangat penting untuk memahami bagaimana aplikasi Anda berperilaku di lingkungan produksi. Spring Boot Actuator adalah fondasi untuk monitoring di ekosistem Spring.

### 🩺 Actuator Web Endpoint

Actuator menyediakan endpoint HTTP untuk monitoring. Beberapa yang paling berguna:

* `/actuator/health`: Status kesehatan aplikasi (UP/DOWN).
* `/actuator/info`: Informasi kustom tentang aplikasi.
* `/actuator/metrics`: Berbagai metrik performa (CPU, memori, request, dll).
* `/actuator/loggers`: Melihat dan mengubah level logging saat runtime.
* `/actuator/heapdump` & `/actuator/threaddump`: Untuk analisis memori dan thread.

### 📏 Micrometer

Micrometer adalah fasad (abstraksi) untuk metrik aplikasi yang terintegrasi dengan Actuator. Ia memungkinkan Anda mengirim metrik ke berbagai sistem monitoring seperti **Prometheus**, **Datadog**, atau **Graphite** hanya dengan menambahkan dependensi dan konfigurasi yang sesuai.

---

## 🗃️ Spring Migrations

Manajemen skema database secara manual sangat rentan terhadap error. Tools migrasi database seperti **Flyway** dan **Liquibase** mengotomatiskan proses ini, membuat perubahan database menjadi version-controlled, terstruktur, dan dapat diulang.

### Flyway vs. Liquibase

* **Flyway**: Lebih sederhana, berbasis SQL. Anda menulis skrip SQL murni (`V1__Create_table.sql`, `V2__Add_column.sql`), dan Flyway akan mengeksekusinya secara berurutan.
* **Liquibase**: Lebih powerful dan fleksibel. Perubahan didefinisikan dalam format abstrak (XML, YAML, atau JSON) yang disebut *changelog*. Liquibase kemudian menerjemahkannya ke SQL yang sesuai untuk database target. Ini memungkinkan migrasi yang sama berjalan di database yang berbeda (misal: PostgreSQL dan H2).

### Detail Implementasi Liquibase

1. **Tambahkan Dependensi**: Tambahkan `liquibase-core` ke `pom.xml` atau `build.gradle`.
2. **Buat Master Changelog**: Buat file `db/changelog/db.changelog-master.xml` di `src/main/resources`. File ini akan menjadi titik masuk untuk semua skrip migrasi Anda.

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <databaseChangeLog
           xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                               http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-latest.xsd">

       <!-- Include file changelog lain di sini -->
       <include file="db/changelog/2025-10-14-01-initial-schema.xml"/>

   </databaseChangeLog>
   ```
3. **Buat Changeset**: Buat file changelog spesifik (contoh: `2025-10-14-01-initial-schema.xml`) yang berisi satu atau lebih *changeset*.

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <databaseChangeLog
           xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                               http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-latest.xsd">

       <changeSet id="1" author="dhimas">
           <createTable tableName="products">
               <column name="id" type="bigint" autoIncrement="true">
                   <constraints primaryKey="true" nullable="false"/>
               </column>
               <column name="name" type="varchar(255)">
                   <constraints nullable="false"/>
               </column>
               <column name="price" type="double"/>
           </createTable>
       </changeSet>

   </databaseChangeLog>
   ```
4. **Konfigurasi Spring Boot**: Aktifkan Liquibase di `application.properties`.

   ```properties
   spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml
   spring.liquibase.enabled=true
   ```

Saat aplikasi berjalan, Spring Boot akan otomatis menjalankan Liquibase, yang akan memeriksa tabel `DATABASECHANGELOG` dan menerapkan *changeset* yang belum pernah dijalankan.

---

## 🛡️ Spring Security

Spring Security adalah framework yang sangat kuat dan dapat dikustomisasi untuk mengamankan aplikasi. Konsep utamanya meliputi:

* **Authentication**: Proses memverifikasi identitas seseorang (Siapa Anda?). Contoh: login dengan username dan password.
* **Authorization**: Proses menentukan apakah seseorang memiliki izin untuk mengakses resource tertentu (Apa yang boleh Anda lakukan?). Contoh: hanya user dengan role `ADMIN` yang bisa mengakses endpoint `/admin`.
* **Filter Chain**: Spring Security bekerja dengan serangkaian filter Servlet yang mencegat setiap request untuk menerapkan aturan keamanan.
* **Konfigurasi**: Sejak Spring Boot 3, konfigurasi keamanan dilakukan menggunakan `SecurityFilterChain` bean.

---

## ⚙️ Spring Boot DevTools

Dependensi `spring-boot-devtools` sangat berguna selama development. Fitur utamanya:

* **Automatic Restart**: Aplikasi akan otomatis di-restart setiap kali ada perubahan pada file di classpath.
* **LiveReload**: Otomatis me-refresh browser saat resource (HTML, CSS, JS) berubah.
* **Default Properti yang Masuk Akal**: Menonaktifkan caching template untuk memudahkan development.

---

# 🌐 Spring Web (Imperatif) vs. Spring WebFlux (Reaktif)

Spring menyediakan dua stack utama untuk pengembangan web modern:
**Spring Web MVC** (imperatif, blocking) dan **Spring WebFlux** (reaktif, non-blocking).
Berikut perbandingan dan daftar komponen masing-masing.

---

## ⚖️ Perbandingan Singkat

| Aspek                      | Spring Web (MVC)                | Spring WebFlux                     |
| :------------------------- | :------------------------------ | :--------------------------------- |
| **Paradigma**              | Imperatif / Blocking            | Reaktif / Non-Blocking             |
| **Thread Model**           | 1 thread per request            | Event Loop dengan thread sedikit   |
| **Dependency Utama**       | `spring-boot-starter-web`       | `spring-boot-starter-webflux`      |
| **Server Default**         | Tomcat                          | Netty                              |
| **Tipe API**               | Synchronous (return langsung)   | Asynchronous (`Mono`, `Flux`)      |
| **Data Type**              | `User` / `List<User>`           | `Mono<User>` / `Flux<User>`        |
| **Eksekusi**               | Blocking calls                  | Reactive streams                   |
| **Kinerja Optimal**        | Beban rendah–menengah           | Beban tinggi, I/O intensif         |
| **Integrasi Database**     | JDBC (blocking)                 | R2DBC (non-blocking)               |
| **Model Pemrograman**      | Controller + View (Servlet API) | Reactive Handler / Router Function |
| **WebClient/RestTemplate** | `RestTemplate` (blocking)       | `WebClient` (non-blocking)         |
| **Streaming**              | Terbatas (SSE manual)           | Native SSE dan WebSocket           |
| **Skalabilitas**           | Thread-bound (tergantung pool)  | Event-loop based (lebih efisien)   |

---

## 🧩 Komponen Inti

### 🧱 Spring Web (MVC)

| Layer                         | Komponen                                  | Deskripsi Singkat                                 |
| :---------------------------- | :---------------------------------------- | :------------------------------------------------ |
| **Core Servlet**              | `DispatcherServlet`                       | Entry point utama untuk request HTTP              |
|                               | `HandlerMapping`                          | Mencari controller sesuai URL                     |
|                               | `HandlerAdapter`                          | Menjalankan method handler                        |
|                               | `HandlerInterceptor`                      | Intercept sebelum/akhir request                   |
| **Controller Layer**          | `@Controller`, `@RestController`          | Mendefinisikan endpoint HTTP                      |
| **View Layer**                | `ViewResolver`, `ModelAndView`            | Render view (JSP, Thymeleaf, dll)                 |
| **Data Binding & Validation** | `@RequestBody`, `@Valid`, `BindingResult` | Parsing dan validasi data                         |
| **Exception Handling**        | `@ControllerAdvice`, `@ExceptionHandler`  | Global error handling                             |
| **HTTP Message Conversion**   | `HttpMessageConverter`                    | JSON/XML converter untuk request/response         |
| **Async (opsional)**          | `Callable`, `DeferredResult`              | Dukungan async parsial (tetap thread-per-request) |
| **Client-side**               | `RestTemplate`                            | HTTP client synchronous                           |
| **Filter/Interceptor**        | `Filter`, `HandlerInterceptor`            | Manipulasi request & response                     |
| **Server Container**          | Tomcat / Jetty / Undertow                 | Servlet Container tradisional                     |

---

### ⚙️ Spring WebFlux (Reactive)

| Layer                        | Komponen                                                          | Deskripsi Singkat                                   |
| :--------------------------- | :---------------------------------------------------------------- | :-------------------------------------------------- |
| **Core Reactive**            | `Mono<T>` / `Flux<T>`                                             | Publisher stream (0..1 / 0..N)                      |
|                              | `Publisher`, `Subscriber`                                         | Interface dari Reactive Streams                     |
|                              | `Schedulers`                                                      | Pengatur thread model                               |
|                              | `Project Reactor`                                                 | Engine reaktif bawaan                               |
| **Dispatcher Layer**         | `DispatcherHandler`                                               | Pengganti `DispatcherServlet` (non-blocking)        |
|                              | `HandlerMapping`                                                  | Mencari handler function                            |
|                              | `HandlerAdapter`                                                  | Menjalankan handler (`@Controller` / functional)    |
|                              | `HandlerResultHandler`                                            | Mengonversi hasil reactive menjadi `ServerResponse` |
| **Controller Layer**         | `@RestController`, `@GetMapping`, `@PostMapping`                  | Deklarasi endpoint reaktif                          |
| **Functional Routing Layer** | `RouterFunction`, `HandlerFunction`                               | Deklarasi rute berbasis fungsi                      |
| **HTTP Server Layer**        | `Reactor Netty`                                                   | Default non-blocking server                         |
|                              | `Jetty`, `Undertow`                                               | Alternatif runtime                                  |
| **Codec Layer**              | `HttpMessageReader`, `HttpMessageWriter`                          | Serialisasi/deserialisasi reaktif                   |
| **Client Layer**             | `WebClient`                                                       | HTTP client reaktif (ganti `RestTemplate`)          |
| **WebSocket / SSE**          | `WebSocketHandler`, `SseEmitter`                                  | Streaming real-time                                 |
| **Error Handling**           | `@ControllerAdvice`, `ResponseStatusException`                    | Error handling reaktif                              |
| **Security (opsional)**      | `spring-boot-starter-security` + `ReactiveSecurityWebFilterChain` | Reaktif security chain                              |
| **Data Layer**               | R2DBC, Mongo Reactive, Redis Reactive                             | Driver non-blocking                                 |
| **Backpressure Control**     | `Flux` operators (`limitRate`, `onBackpressureBuffer`)            | Pengaturan arus data                                |
| **Test Layer**               | `WebTestClient`                                                   | Testing reaktif untuk endpoint WebFlux              |

---

## 🧠 Layered Architecture (WebFlux)

```
┌──────────────────────────────────────┐
│            Client (WebClient)        │
├──────────────────────────────────────┤
│         DispatcherHandler            │
│     ├─ HandlerMapping                │
│     ├─ HandlerAdapter                │
│     └─ HandlerResultHandler          │
├──────────────────────────────────────┤
│   @Controller / RouterFunction       │
├──────────────────────────────────────┤
│   Reactive Data Layer (R2DBC, etc.)  │
├──────────────────────────────────────┤
│   Reactor Core (Mono, Flux)          │
└──────────────────────────────────────┘
```

---

## 🔌 Server Runtime Support

| Server        | Web MVC |    WebFlux   | Blocking | Catatan                                 |
| :------------ | :-----: | :----------: | :------: | :-------------------------------------- |
| Tomcat        |    ✅    | ⚠️ (partial) |     ✅    | Servlet-based, tidak sepenuhnya reaktif |
| Jetty         |    ✅    |       ✅      |   ✅/⚙️   | Mendukung reaktif                       |
| Undertow      |    ✅    |       ✅      |   ✅/⚙️   | Performant, cocok untuk microservices   |
| Reactor Netty |    ❌    |       ✅      |     ❌    | Default untuk WebFlux                   |
| GlassFish     |    ✅    |       ❌      |     ✅    | Hanya untuk Servlet stack               |

---

## 🧩 Reactive Stack Tambahan (opsional)

| Komponen                         | Fungsi                          | Paket                                          |
| :------------------------------- | :------------------------------ | :--------------------------------------------- |
| **Spring Data R2DBC**            | Reactive SQL database access    | `org.springframework.data.r2dbc`               |
| **Spring Data Reactive MongoDB** | Non-blocking MongoDB access     | `spring-boot-starter-data-mongodb-reactive`    |
| **Spring Security Reactive**     | Non-blocking security filters   | `spring-boot-starter-security`                 |
| **Spring Cloud Gateway**         | Reactive API Gateway            | `spring-cloud-starter-gateway`                 |
| **Spring WebSocket (Reactive)**  | Real-time channel dengan `Flux` | `spring-boot-starter-webflux`                  |
| **WebTestClient**                | Reactive testing client         | `org.springframework.test.web.reactive.server` |

---

## 📦 Dependency Utama (Maven)

### Spring MVC

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### Spring WebFlux

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

---

## 🧩 Kombinasi Tidak Disarankan

| Kombinasi                                                 | Keterangan                                        |
| :-------------------------------------------------------- | :------------------------------------------------ |
| `spring-boot-starter-web` + `spring-boot-starter-webflux` | ❌ Menyebabkan konflik servlet vs reactive runtime |
| `RestTemplate` dalam WebFlux                              | ❌ Blocking call dalam reactive loop               |
| `JDBC` dengan WebFlux                                     | ❌ Blocking driver (gunakan R2DBC)                 |

---

## 🧭 Use Case Guidance

| Skenario                          | Pilihan                    | Alasan                                 |
| :-------------------------------- | :------------------------- | :------------------------------------- |
| Aplikasi CRUD biasa               | **Spring MVC**             | Model blocking sederhana               |
| Web app tradisional (HTML render) | **Spring MVC + Thymeleaf** | Butuh view rendering                   |
| API Gateway / Proxy               | **WebFlux**                | Non-blocking, streaming                |
| Streaming data / SSE / WebSocket  | **WebFlux**                | Native support                         |
| Microservice reactive (R2DBC)     | **WebFlux**                | Full reactive chain                    |
| Integrasi library blocking        | **MVC**                    | WebFlux tidak cocok untuk blocking I/O |

---

## 🧪 Tools & Testing

| Tool                            | Spring MVC | WebFlux |
| :------------------------------ | :--------: | :-----: |
| `MockMvc`                       |      ✅     |    ❌    |
| `WebTestClient`                 |      ❌     |    ✅    |
| `Mockito`                       |      ✅     |    ✅    |
| `Reactor Test` (`StepVerifier`) |      ❌     |    ✅    |

---

## 🧩 Integrasi Tambahan

| Komponen                 |     MVC     |       WebFlux      | Catatan               |
| :----------------------- | :---------: | :----------------: | :-------------------- |
| Spring Security          |      ✅      |    ✅ (Reactive)    | Ada 2 stack berbeda   |
| Spring Data JPA          |      ✅      |          ❌         | Gunakan R2DBC         |
| Spring Data R2DBC        |      ❌      |          ✅         | Reactive SQL          |
| Spring Cloud Gateway     |      ❌      |          ✅         | Full reactive gateway |
| Spring Session           |      ✅      | ✅ (Reactive Redis) | Stateful session      |
| WebSocket                |      ✅      |  ✅ (Reactive Core) |                       |
| SSE (Server Sent Events) | ⚙️ (manual) |      ✅ native      |                       |

---