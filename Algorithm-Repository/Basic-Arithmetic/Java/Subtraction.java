// Subtraction.java
// Language: Java
// Purpose: Perform subtraction of two numbers (integer or floating-point)
// Time Complexity: O(1)
// Space Complexity: O(1)
import java.util.Scanner;
public class Subtraction {
    public static void main(String[] args) {
        int first, second;

        Scanner take = new Scanner(System.in);


        System.out.println("Enter two numbers: ");
        first = take.nextInt();
        second = take.nextInt();

        int ans = first - second;
        System.out.println("Subtraction: " + ans);

    }
}
