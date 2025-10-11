// ModularAddition.java
// Language: Java
// Purpose: Perform modular addition (a + b) % mod
// Time Complexity: O(1)
// Space Complexity: O(1)

import java.util.Scanner;

public class ModularAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter two numbers and modulus: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mod = sc.nextInt();

        if(mod <= 0) {
            System.out.println("modulus Must be positive");
            sc.close();
            return;
        }

        int result = ((a % mod) + (b % mod)) % mod;
        if(result < 0) result += mod; // Handle negative numbers

        System.out.println("Modular Addition: " + result);
        sc.close();
    }
}
