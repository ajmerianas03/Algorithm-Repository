
// Language: Java
// Purpose: Calculate nth Fibonacci number using Dynamic Programming (iterative)
// Time Complexity: O(n)
// Space Complexity: O(n)
// this contain only Dynamic Programming Iterative approach i am going to add other option ass well in feature
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) return n;

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
    // latter add for entire array return

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }
}
