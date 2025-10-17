// PermutationsOptimized.java
// Language: Java
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Optimized calculation of the number of ways to arrange r items from n distinct items
// (permutations) without computing full factorials.
//
// 🧮 How it works:
// 1. Permutation P(n, r) = n! / (n-r)!
// 2. Instead of calculating full factorials, multiply the sequence:
//    n * (n-1) * (n-2) * ... * (n-r+1)
// 3. Return the product as the number of arrangements
//
// 🕒 Time Complexity:
// - O(r) → only r multiplications needed
//
// 💾 Space Complexity:
// - O(1) → constant extra space
//
// 📌 Real-life use cases:
// - Arranging books, seats, or tasks when order matters
// - Generating possible passwords or codes of given length
//
// ⚠️ When to use:
// - Use when order matters
// - If order doesn’t matter, use combinations instead
//
// 🧪 Sample Input/Output:
// Input: n = 5, r = 3
// Output: Number of permutations P(5,3) = 60
//
// Input: n = 10, r = 4
// Output: Number of permutations P(10,4) = 5040
// ---------------------------------------------------------

public class PermutationsOptimized {

    public static long permutation(int n, int r) {
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);  
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5; 
        int r = 3; 
        System.out.println("P(" + n + ", " + r + ") = " + permutation(n, r));
    }
}
