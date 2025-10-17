// Permutations.cpp
// Language: C++
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Calculates the number of ways to arrange r items from n distinct items
// where the order of selection matters (permutations).
//
// 🧮 How it works:
// 1. Calculate factorial of a number n: n! = n * (n-1) * ... * 1
// 2. Use the formula for permutations: P(n, r) = n! / (n-r)!
// 3. Return the number of arrangements
//
// 🕒 Time Complexity:
// - factorial(): O(n) → iterates n times
// - permutation(): O(n) → dominated by factorial calculation
//
// 💾 Space Complexity:
// - O(1) → uses constant extra space
//
// 📌 Real-life use cases:
// - Arranging books on a shelf, seats in a row, or tasks in a schedule
// - Calculating possible codes or passwords of given length
//
// ⚠️ When to use:
// - Use when order matters. 
// - If order doesn’t matter, use combinations instead.
//
// 🧪 Sample Input/Output:
// Input: n = 5, r = 3
// Output: Number of permutations P(5,3) = 60
//
// Input: n = 4, r = 2
// Output: Number of permutations P(4,2) = 12
// ---------------------------------------------------------

public class Permutations {

    
    public static long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    
    public static long permutation(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    public static void main(String[] args) {
        int n = 5; 
        int r = 3; 
        System.out.println("P(" + n + ", " + r + ") = " + permutation(n, r));
    }
}