// LCM.java
// Language: Java
// Purpose: Compute the Least Common Multiple (LCM) of two integers using GCD
// Time Complexity: O(log(min(a, b))) — dominated by GCD computation
// Space Complexity: O(1)
/*
 * ✅ Description:
 * LCM (Least Common Multiple) finds the smallest positive integer that is divisible by both numbers.
 * Uses the formula: lcm(a, b) = |a * b| / gcd(a, b)
 *
 * 🧼 Clean and optimized implementation:
 *   - Handles negative numbers
 *   - Uses gcd function to ensure efficiency
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
import java.util.Scanner;
public class GCD {
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    static long gcdRecursive(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        long a,b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        a = sc.nextLong();
        b = sc.nextLong();
        System.out.println("GCD of "+a+" and "+b+" is: "+gcd(a,b));
        sc.close();
        
    }
}
