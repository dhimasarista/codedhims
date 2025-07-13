class Hello {
  private declare m: string;
  constructor(m: string) {
    this.m = m;
  }

  public World() {
    console.log(`Hello, ${this.m}`);
  }
}

const hello = new Hello("Dhimas").World();
