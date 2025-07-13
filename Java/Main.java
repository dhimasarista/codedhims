public class Main {
    public static void main(String[] args) {
        int n = 40;
        int loops = 10;

        System.out.println("===== Virtual Threads =====");
        runMultipleFibWithVirtualThreads(loops, n);

        System.out.println("\n===== Platform Threads =====");
        runMultipleFibWithPlatformThreads(loops, n);
    }

    public static long fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void runMultipleFibWithVirtualThreads(int loops, int n) {
        Thread[] threads = new Thread[loops];
        long startTime = System.currentTimeMillis();
        long beforeMemory = getUsedMemory();

        System.out.printf("Before memory (Virtual Threads): %.2f MB%n", beforeMemory / 1024.0 / 1024.0);

        for (int i = 0; i < loops; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                long start = System.currentTimeMillis();
                long result = fib(n);
                long end = System.currentTimeMillis();
                System.out.printf("VT Result: %d, Time: %d ms, Thread: %s%n", result, (end - start), Thread.currentThread().getName());
            });
        }

        joinAll(threads);

        long endTime = System.currentTimeMillis();
        long afterMemory = getUsedMemory();

        System.out.printf("After memory (Virtual Threads): %.2f MB%n", afterMemory / 1024.0 / 1024.0);
        System.out.printf("Virtual Threads total time: %d ms%n", (endTime - startTime));
        System.out.printf("Memory used by Virtual Threads: %.2f MB%n", (afterMemory - beforeMemory) / 1024.0 / 1024.0);
    }

    public static void runMultipleFibWithPlatformThreads(int loops, int n) {
        Thread[] threads = new Thread[loops];
        long startTime = System.currentTimeMillis();
        long beforeMemory = getUsedMemory();

        System.out.printf("Before memory (Platform Threads): %.2f MB%n", beforeMemory / 1024.0 / 1024.0);

        for (int i = 0; i < loops; i++) {
            threads[i] = new Thread(() -> {
                long start = System.currentTimeMillis();
                long result = fib(n);
                long end = System.currentTimeMillis();
                System.out.printf("PT Result: %d, Time: %d ms, Thread: %s%n", result, (end - start), Thread.currentThread().getName());
            });
            threads[i].start();
        }

        joinAll(threads);

        long endTime = System.currentTimeMillis();
        long afterMemory = getUsedMemory();

        System.out.printf("After memory (Platform Threads): %.2f MB%n", afterMemory / 1024.0 / 1024.0);
        System.out.printf("Platform Threads total time: %d ms%n", (endTime - startTime));
        System.out.printf("Memory used by Platform Threads: %.2f MB%n", (afterMemory - beforeMemory) / 1024.0 / 1024.0);
    }

    public static void joinAll(Thread[] threads) {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // optional: run garbage collector to get more stable measurements
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
