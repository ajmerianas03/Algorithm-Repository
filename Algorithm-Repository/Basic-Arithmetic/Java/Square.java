// Square.java
// Language: Java
// Purpose: Compute the square of a number (x^2)
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in geometry calculations, physics, and number theory

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double x = sc.nextDouble();

        double result = x * x;
        System.out.println("square of " + x + " = " + result);

        
        System.out.println("example: Area of square with side " + x + " = " + result);

        sc.close();
    }
}
