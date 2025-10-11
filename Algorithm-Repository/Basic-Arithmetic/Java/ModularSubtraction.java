// ModularSubtraction.java
// Language: Java
// Purpose: Perform ModularSubtraction (a - b) % mod
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in cryptography, hash functions, and cyclic sequences

import java.util.Scanner;

public class ModularSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers and modulus: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mod = sc.nextInt();

        if(mod <= 0) {
            System.out.println("Modulus must be positive");
            sc.close();
            return;
        }

        int result = ((a % mod) - (b % mod)) % mod;
        if(result < 0) result += mod; 
        System.out.println("Modular Subtraction: " + result);
        sc.close();
    }
}
