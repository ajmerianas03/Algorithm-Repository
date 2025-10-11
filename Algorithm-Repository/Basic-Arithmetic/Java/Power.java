// Power.java
// Language: Java
// Purpose: to calculate x^n (power of a number) efficiently
// Time Complexity: O(log n) using binary exponentiation
// Space Complexity: O(1)
// Use Case: Useful in combinatorics, number theory, and modular arithmetic

import java.util.Scanner;

public class Power {

    
    public static long power(long x, long n) {
        long result = 1;
        while(n > 0) {
            if(n % 2 == 1) result *= x;  
            x *= x;
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base and exponent: ");
        long x = sc.nextLong();
        long n = sc.nextLong();

        long result = power(x, n);
        System.out.println(x + "^" + n + " = " + result);

        System.out.println("Example: 2^10 = " + power(2, 10));

        sc.close();
    }
}
