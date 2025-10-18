/*
PartitionFunctions.java
Language: Java
Category: Combinatorics / Integer Partitions
---------------------------------------------------------
✅ Short Description:
Calculates the number of ways to partition an integer n into sums of positive integers (order does not matter).
Implements three approaches:
1. Top-Down Recursive DP with Memoization
2. Bottom-Up 2D Dynamic Programming
3. Bottom-Up Optimized 1D Dynamic Programming

🕒 Time Complexity:
- Top-Down Memoized Recursion: O(n^2)
- Bottom-Up 2D DP: O(n^2)
- Bottom-Up Optimized 1D DP: O(n^2)

💾 Space Complexity:
- Top-Down: O(n^2) for memo table
- Bottom-Up 2D DP: O(n^2) for dp table
- Bottom-Up Optimized 1D DP: O(n) for dp array

📌 Real-life use cases:
- Number theory and combinatorics (partition theory)
- Cryptography (key splitting and secret sharing)
- Statistical physics (energy distributions)
- Algorithmic problems involving integer compositions

⚠️ When to use:
- Top-down: intuitive, easier to implement, good for moderate n
- Bottom-up 2D: clear tabulation, good for understanding subproblems
- Bottom-up optimized 1D: best for performance and memory efficiency on large inputs

🧪 Sample Output for n=6:
Number of partitions of 6 = 11
Number of partitions of 6 Using Bottom Up = 11
Number of partitions of 6 (optimized) = 11
---------------------------------------------------------
*/

public class PartitionFunctions {
    static int[][] memo;

    // 1. Top-Down Recursive DP with Memoization
    public static int partitionCount(int n, int k) {
        if (n == 0) return 1;        // Base case: one way to partition 0
        if (n < 0 || k == 0) return 0;  // No valid partition

        if (memo[n][k] != -1) return memo[n][k];

        // Include k or exclude k
        memo[n][k] = partitionCount(n - k, k) + partitionCount(n, k - 1);
        return memo[n][k];
    }

    // 2. Bottom-Up 2D DP Approach
    public static int partitionBottomUp(int n) {
        int[][] dp = new int[n + 1][n + 1];

        // There is 1 way to partition 0 (empty sum)
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i - j >= 0) {
                    dp[i][j] += dp[i - j][j];
                }
            }
        }
        return dp[n][n];
    }

    // 3. Bottom-Up Optimized 1D DP Approach
    public static int partitionCountOptimized(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;  // One way to partition 0

        for (int num = 1; num <= n; num++) {
            for (int i = num; i <= n; i++) {
                dp[i] += dp[i - num];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println("Number of partitions of " + n + " = " + partitionCount(n, n));
        System.out.println("Number of partitions of " + n + " Using Bottom Up = " + partitionBottomUp(n));
        System.out.println("Number of partitions of " + n + " (optimized) = " + partitionCountOptimized(n));
    }
}
