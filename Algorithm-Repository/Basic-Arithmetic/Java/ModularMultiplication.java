// ModularMultiplication.java
// Language: Java
// Purpose: Perform modular multiplication (a * b) % mod
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in cryptography (RSA), combinatorics, cyclic sequences

import java.util.Scanner;

public class ModularMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers and modulus: ");
        long a = sc.nextLong();
        long b = sc.nextLong();
        int mod = sc.nextInt();

        if(mod <= 0) {
            System.out.println("Modulus must be positive");
            sc.close();
            return;
        }

        long result = ((a % mod) * (b % mod)) % mod;
        if(result < 0) result += mod;

        System.out.println("modular Multiplication: " + result);

        // Example use case: Clock with 12 hours, multiply positions
        int cHour = 3, multi = 4, cMod = 12;
        int ans = ((cHour % cMod) * (multi % cMod)) % cMod;
        System.out.println("clock example: 3 * 4 mod 12 = " + ans);

        sc.close();
    }
}
