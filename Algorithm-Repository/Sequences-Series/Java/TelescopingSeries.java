// TelescopingSeries.java
// Language: Java
// Purpose: Calculate the sum of a telescoping series of the form 1/(n*(n+1))
// What is a Telescoping Series?
//   A telescoping series is a series where most terms cancel out when expanded,
//   leaving only a few terms to compute.
// Formula: Sum_{n=1}^{N} 1/(n*(n+1)) = 1 - 1/(N+1)
// Example: N = 5 → 1/1*2 + 1/2*3 + 1/3*4 + 1/4*5 + 1/5*6 = 5/6 ≈ 0.833333
// Time Complexity: O(1)
// Space Complexity: O(1)

import java.util.Scanner;

public class TelescopingSeries {

    // Method to Calculate the telescoping series Sum
    public static double t_Sum(int N) {
        return 1.0 - 1.0 / (N + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (number of terms): ");
        int N = sc.nextInt();

        double sum = t_Sum(N);
        System.out.println("Sum of telescoping series 1/(n*(n+1)) for n = 1 to " + N + " is " + sum);

        // Sample Input/Output
        // Input: N = 5
        // Output: 0.833333

        sc.close();
    }
}
