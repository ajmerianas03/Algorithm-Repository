// LCM.java
// Language: Java
// Purpose: Compute the Least Common Multiple (LCM) of two integers using GCD
// Time Complexity: O(log(min(a, b))) — dominated by GCD computation
// Space Complexity: O(1)

import java.util.Scanner;

/*
 * ✅ Description:
 * LCM (Least Common Multiple) finds the smallest positive integer divisible by both numbers.
 * Formula used: lcm(a, b) = |a * b| / gcd(a, b)
 *
 * 🧼 Clean and optimized implementation:
 *   - Handles negative numbers using Math.abs()
 *   - Efficient via Euclidean GCD
 *   - Works for large integers using long
 *
 * 🧪 Sample Input / Output:
 *   Input:
 *     12 18
 *   Output:
 *     LCM of 12 and 18 is: 36
 *
 * 🧰 Use Case:
 *   - Scheduling problems (finding common intervals)
 *   - Simplifying fractions
 *   - Problems involving multiples and modular arithmetic
 */
public class LCM {

    
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        long a = sc.nextLong();
        System.out.print("Enter second number: ");
        long b = sc.nextLong();

        long ans = lcm(a, b);
        System.out.println("LCM(" + a + ", " + b + ") = " + ans);
    }
}
