# Reactive Extensions for Javascript

RxJS (Reactive Extensions for JavaScript) adalah library JavaScript yang digunakan untuk mengelola aliran data asinkron dan event-driven. Di NestJS, RxJS digunakan untuk membuat aplikasi yang lebih responsif dan scalable.

Konsep Dasar RxJS

- Observable: Aliran data asinkron yang dapat di-subscribe dan di-olah.
- Observer: Fungsi yang digunakan untuk menghandle data yang diterima dari Observable.
- Operator: Fungsi yang digunakan untuk mengolah dan memanipulasi aliran data Observable.

Contoh Penggunaan RxJS di NestJS

Contoh 1: Menggunakan Observable
```ts
import { Controller, Get } from '@nestjs/common';
import { Observable, of } from 'rxjs';

@Controller('example')
export class ExampleController {
  @Get()
  example(): Observable<string> {
    return of('Hello World!');
  }
}
```

Dalam contoh di atas, kita menggunakan of operator untuk membuat Observable yang mengembalikan string "Hello World!".

Contoh 2: Menggunakan Operator
```ts
import { Controller, Get } from '@nestjs/common';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Controller('example')
export class ExampleController {
  @Get()
  example(): Observable<string> {
    return of('Hello World!').pipe(
      map((value) => value.toUpperCase()),
    );
  }
}
```

Dalam contoh di atas, kita menggunakan map operator untuk mengubah string "Hello World!" menjadi huruf besar.

Contoh 3: Menggunakan Subject
```ts
import { Injectable } from '@nestjs/common';
import { Subject } from 'rxjs';

@Injectable()
export class ExampleService {
  private subject = new Subject<string>();

  sendMessage(message: string) {
    this.subject.next(message);
  }

  getMessage(): Subject<string> {
    return this.subject;
  }
}
```

```ts
import { Controller, Get } from '@nestjs/common';
import { ExampleService } from './example.service';

@Controller('example')
export class ExampleController {
  constructor(private readonly exampleService: ExampleService) {}

  @Get()
  example() {
    this.exampleService.getMessage().subscribe((message) => {
      console.log(message);
    });
  }

  @Get('send')
  sendMessage() {
    this.exampleService.sendMessage('Hello World!');
  }
}
```

Dalam contoh di atas, kita menggunakan Subject untuk mengirimkan pesan antara komponen.

Operator-Operator RxJS

- map: Mengubah nilai Observable.
- filter: Memfilter nilai Observable.
- mergeMap: Menggabungkan Observable.
- switchMap: Mengganti Observable dengan Observable lain.
- catchError: Menangani error Observable.

Kelebihan RxJS di NestJS

- Membuat aplikasi lebih responsif dan scalable.
- Mengelola aliran data asinkron dengan lebih mudah.
- Meningkatkan kinerja aplikasi dengan menggunakan aliran data asinkron.

Dengan menggunakan RxJS di NestJS, Anda dapat membuat aplikasi yang lebih responsif dan scalable. Pastikan untuk mempelajari lebih lanjut tentang RxJS dan cara menggunakannya di NestJS.