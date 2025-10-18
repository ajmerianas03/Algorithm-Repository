// StirlingNumber.java
// Language: Java
// Category: Combinatorics / Dynamic Programming
// ---------------------------------------------------------
// 🧠 Short Description:
// Stirling Numbers of the Second Kind count the ways to partition 
// a set of n elements into k non-empty subsets. This class provides 
// three methods to compute S(n, k):
//
// 1) Recursive method (simple but inefficient due to overlapping subproblems)
// 2) Memoized recursion (top-down dynamic programming to avoid recomputation)
// 3) Tabulation (bottom-up dynamic programming for efficient iterative computation)
//
// Approach:
// - Uses the recurrence relation:
//       S(n, k) = k * S(n-1, k) + S(n-1, k-1)
// - Base cases:
//       S(0, 0) = 1; S(n, 0) = 0 for n > 0; S(0, k) = 0 for k > 0
// - Memoization stores computed values to prevent repeated work
// - Tabulation fills a dp table from base cases up to desired n and k
//
// Why it works well:
// - Dynamic programming drastically reduces the time complexity compared 
//   to naive recursion.
// - Tabulation method is generally the fastest and most memory efficient.
//
// Example:
// Input: n = 5, k = 3
// Output: 25 (ways to partition a set of 5 elements into 3 non-empty subsets)
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  Recursive: exponential
//  Memoized / Tabulation: O(n*k)
// 💾 Space Complexity:
//  Memoized / Tabulation: O(n*k)
//
// ✅ Efficient and exact computation for typical input sizes.
//
// 📌 Real-life use cases:
// - Grouping objects into clusters
// - Counting equivalence relations
// - Combinatorial enumeration in probability and statistics
// 

public class StirlingNumber {

    // 1. recursive Method (Inefficient)
    public static int stirlingRecursive(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (n == 0 || k == 0) return 0;
        return k * stirlingRecursive(n - 1, k) + stirlingRecursive(n - 1, k - 1);
    }

    // 2. memoized Method (top-down DP Approach)
    static int[][] memo;

    public static int stirlingMemoized(int n, int k) {
        memo = new int[n + 1][k + 1];

        // Initialize memo table with -1
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                memo[i][j] = -1;

        return stirlingMemoHelper(n, k);
    }

    private static int stirlingMemoHelper(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (n == 0 || k == 0) return 0;
        if (memo[n][k] != -1) return memo[n][k];

        memo[n][k] = k * stirlingMemoHelper(n - 1, k) + stirlingMemoHelper(n - 1, k - 1);
        return memo[n][k];
    }

    // 3. tabulation Method (Bottom-up DP Approach)
    public static int stirlingTabulation(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        return dp[n][k];
    }

    // main method to test all approaches
    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        System.out.println("=== Stirling Numbers of the Second Kind ===");
        System.out.println("S(" + n + ", " + k + ") using Recursive:  " + stirlingRecursive(n, k));
        System.out.println("S(" + n + ", " + k + ") using Memoized:   " + stirlingMemoized(n, k));
        System.out.println("S(" + n + ", " + k + ") using Tabulation: " + stirlingTabulation(n, k));
    }
}
