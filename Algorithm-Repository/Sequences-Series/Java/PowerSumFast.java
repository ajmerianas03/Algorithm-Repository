// PowerSumFast.java
// Language: Java
// Purpose: calculate The Sum of the first n natural numbers raised to the k-th power using formula-based Approach for small k
// Time Complexity: O(1) for k ≤ 5, O(n) for k > 5
// Space Complexity: O(1)

import java.util.Scanner;

public class PowerSumFast {

    // Method to calculate Power Sum
    public static double powerSum(int n, int k) {
        switch(k) {
            case 1: return n * (n + 1) / 2.0;
            case 2: return n * (n + 1) * (2 * n + 1) / 6.0;
            case 3: {
                double temp = n * (n + 1) / 2.0;
                return temp * temp;
            }
            case 4: return n * (n + 1) * (2*n + 1) * (3*n*n + 3*n -1) / 30.0;
            case 5: return n * n * (n + 1) * (n + 1) * (2*n*n + 2*n -1) / 12.0;
            default: {
                // Fallback for k > 5
                double sum = 0.0;
                for(int i = 1; i <= n; i++)
                    sum += Math.pow(i, k);
                return sum;
            }
            //more optimization requir?? If yes then we do latter
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (number of terms): ");
        int n = sc.nextInt();
        System.out.print("Enter k (power): ");
        int k = sc.nextInt();

        double sum = powerSum(n, k);
        System.out.println("Sum of " + k + "-th powers of first " + n + " natural numbers: " + sum);

        // Sample Input/Output
        // Input: n = 5, k = 2
        // Output: 55.0

        sc.close();
    }
}
