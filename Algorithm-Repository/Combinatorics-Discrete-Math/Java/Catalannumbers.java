
// CatalanNumbers.java
// Language: Java
// Category: Combinatorics / Dynamic Programming
// ---------------------------------------------------------
// 🧠 Short Description:
// Catalan Numbers form a sequence of natural numbers with wide applications in combinatorics.
// This program calculates the nth Catalan number using two approaches:
//
// 1) Direct factorial formula:
//     C(n) = (2n)! / ((n + 1)! * n!)
//
// 2) Binomial coefficient formula:
//     C(n) = binomialCoefficient(2n, n) / (n + 1)
//
// Approach:
// - Compute factorials (or binomial coefficients) using BigInteger for precision.
// - Use the closed-form formulas to calculate the nth Catalan number directly.
// - Accept user input and output the corresponding Catalan number.
//
// Why it works well:
// - BigInteger handles very large intermediate values without overflow.
// - Direct formulas provide accurate and efficient computation for moderate to large n.
//
// Example:
//  Input:  n = 5
//  Calculation: (10)! / (6! * 5!) = 3628800 / (720 * 120) = 42
//  Output: Catalan number for 5: 42
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Factorial or binomial coefficient computation: O(n)
//  - Overall: O(n)
//
// 💾 Space Complexity:
//  - O(1) auxiliary space (ignoring BigInteger internal storage)
//
// ✅ Computes exact values for large n using BigInteger arithmetic.
//
// 📌 Real-life use cases:
//  - Counting valid expressions with balanced parentheses
//  - Number of unique Binary Search Trees (BSTs)
//  - Ways to triangulate a polygon
//  - Parsing expressions in compilers
// ---------------------------------------------------------


import java.math.BigInteger;
import java.util.Scanner;

public class Catalannumbers {

     public static BigInteger binomialCoefficient(int n, int k) {
        BigInteger result = BigInteger.ONE;

        for (int i = 0; i < k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
            result = result.divide(BigInteger.valueOf(i + 1));
        }

        return result;
    }

    // Catalan number using binomial coefficient: C(n) = binomial(2n, n) / (n + 1)
    public static BigInteger catalanNumber(int n) {
        BigInteger binCoeff = binomialCoefficient(2 * n, n);
        return binCoeff.divide(BigInteger.valueOf(n + 1));
    }

    public static BigInteger factorial(int n){
        BigInteger ans = BigInteger.ONE;
        for(int i=2; i<=n;i++){
            ans = ans.multiply(BigInteger.valueOf(i));

        }
        return ans;
    }
    public static BigInteger catalanNumbers(int n){
        BigInteger fac1 = factorial(2* n);
        BigInteger fac2 = factorial(n);
        BigInteger fac3 = factorial(n + 1);

        
        return fac1.divide(fac3.multiply(fac2));
    } 
    public static void main(String[] args) {
        int n = 5;

        BigInteger ans = catalanNumbers(n);

        System.out.println("catalanNumbers for 5: "+ ans);

        Scanner sc= new Scanner(System.in);
        int num;
        System.out.println("Enter the Number: ");
        num = sc.nextInt();

         BigInteger res = catalanNumbers(n);

        System.out.println("catalanNumbers for " +num+ " : "+ res);


        sc.close();


    }


    
}