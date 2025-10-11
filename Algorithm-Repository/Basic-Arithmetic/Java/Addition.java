// Addition.java
// Language: Java
// Purpose: perform addition of Two numbers
// Time Complexity: O(1)
// Space Complexity: O(1)

// i used nextDouble() so her nextDouble() explanation:
        // 1. Reads the next token (sequence of characters separated by whitespace) from input.
        // 2. Tries to parse it as a double (floating-point number).
        // 3. If successful, returns the double value.
        // 4. If the input is invalid (not a number), it throws InputMismatchException.
        // 5. Does not consume the newline character, so mixing with nextLine() may require extra sc.nextLine().


import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        double sum = a + b;
        System.out.println("Sum: " + sum);

        sc.close();
    }
}
