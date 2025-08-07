public class Main {
    public static long fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        long result = fib(40);

        long endTime = System.currentTimeMillis();

        System.out.println("Result: " + result);
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}
