// RecurrenceRelations.java
// Language: Java
// Purpose: Demonstrate linear, homogeneous, and inhomogeneous recurrence relations
// Time Complexity: O(n) for iterative solution
// Space Complexity: O(1) if only storing necessary previous terms

/*
✅ Short description:
A recurrence relation defines each term of a sequence using its previous terms.

Types:
1️⃣ Linear: Each term is a linear combination of previous terms (coefficients multiply terms)
   Example: T(n) = 2*T(n-1) + 3*T(n-2)

2️⃣ Homogeneous: Linear recurrence with no extra constant term (depends only on previous terms)
   Example: Fibonacci: F(n) = F(n-1) + F(n-2)

3️⃣ Inhomogeneous (non-homogeneous): Linear recurrence with an extra additive function/constant
   Example: T(n) = 2*T(n-1) + n
*/

import java.util.Scanner;

public class RecurrenceRelations {
    // adding some more thing in features

    // Homogeneous linear recurrence: Fibonacci sequence
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b; // T(n) = T(n-1) + T(n-2)
            a = b;
            b = c;
        }
        return b;
    }

    // Linear homogeneous recurrence: T(n) = 2*T(n-1) + 3*T(n-2)
    public static int linearHomogeneous(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int t0 = 0, t1 = 1, tn = 0;
        for (int i = 2; i <= n; i++) {
            tn = 2 * t1 + 3 * t0;
            t0 = t1;
            t1 = tn;
        }
        return tn;
    }

    // Linear inhomogeneous recurrence: T(n) = 2*T(n-1) + n
    public static int linearInhomogeneous(int n) {
        if (n == 0) return 0;
        int t = 0;
        for (int i = 1; i <= n; i++) {
            t = 2 * t + i;
        }
        return t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci F(" + n + ") = " + fibonacci(n));
        System.out.println("Linear Homogeneous T(" + n + ") = " + linearHomogeneous(n));
        System.out.println("Linear Inhomogeneous T(" + n + ") = " + linearInhomogeneous(n));

        /*
        Sample Input/Output:
        Input: n = 5
        Output:
        Fibonacci F(5) = 5
        Linear Homogeneous T(5) = 61
        Linear Inhomogeneous T(5) = 57
        */

        sc.close();
    }
}
