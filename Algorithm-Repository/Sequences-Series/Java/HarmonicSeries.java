// HarmonicSeries.java
// Language: Java
// Purpose: calculate The sum of the first N Terms of the harmonic series
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Scanner;

public class HarmonicSeries {

    // method to calculate Harmonic Series sum
    public static double harmonicSeries(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i; // Adding the Reciprocal of each term
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number Of Terms: ");
        int n = sc.nextInt();

        double sum = harmonicSeries(n);
        System.out.println("Sum Of the First " + n + " terms of the Harmonic Series: " + sum);

        // Sample Input/Output
        // Input: 5
        // Output: Sum of The first 5 Terms of the Harmonic Series: 2.283333333333333
        sc.close();
    }
}
