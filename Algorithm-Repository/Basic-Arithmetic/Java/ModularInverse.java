// ModularInverse.java
// Language: Java
// Purpose: Find modular inverse of a modulo m
// Time Complexity: O(log m)
// Space Complexity: O(1)
// Use Case: Cryptography (RSA), solving linear congruences

import java.util.Scanner;

public class ModularInverse {

    // extended Euclidean Algorithm
    static int gcdExtended(int a, int b, int[] xy) {
        if(a == 0) {
            xy[0] = 0; xy[1] = 1;
            return b;
        }
        int[] xy1 = new int[2];
        int gcd = gcdExtended(b % a, a, xy1);
        xy[0] = xy1[1] - (b / a) * xy1[0];
        xy[1] = xy1[0];
        return gcd;
    }

    static int mod_Inverse(int a, int m) {
        int[] xy = new int[2];
        int g = gcdExtended(a, m, xy);
        if(g != 1) {
            System.out.println("Inverse doesn't exist (a and m are not coprime)");
            return -1;
        } else {
            int x = (xy[0] % m + m) % m; //for Ensure positive result
            return x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number and modulus: ");
        int a = sc.nextInt();
        int mod = sc.nextInt();

        int inverse = mod_Inverse(a, mod);
        if(inverse != -1) {
            System.out.println("Modular Inverse: " + inverse);

            // like use case: Solve 3*x ≡ 1 (mod 11)
            int x = mod_Inverse(3, 11);
            if(x != -1) System.out.println("example: 3 * " + x + " % 11 = 1");
        }

        sc.close();
    }
}
