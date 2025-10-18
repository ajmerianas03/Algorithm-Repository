// BellNumber.java
// Language: Java
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// This class implements 4 different approaches to compute Bell Numbers,
// which count the number of ways to partition a set of n elements into non-empty subsets.
//
// Approaches included:
// 1. Bell Triangle (Dynamic Programming)
// 2. Stirling Numbers of the Second Kind (with Memoization)
// 3. Dobinski’s Formula (Infinite Series, Approximation)
// 4. Recursive Formula with Binomial Coefficients + Memoization
//
// 🕒 Time Complexities:
// 1. Bell Triangle: O(n²)
// 2. Stirling Numbers: O(n²) with memoization
// 3. Dobinski's Formula: Approximate, depends on convergence (~O(n))
// 4. Recursive + Binomial Coefficients: O(n²) with memoization
//
// 💾 Space Complexities:
// 1. Bell Triangle: O(n²)
// 2. Stirling Numbers: O(n²)
// 3. Dobinski: O(1) or minimal
// 4. Recursive: O(n²) (memo tables)
//
// 📌 Real-life use cases:
// - Grouping people into teams (unordered)
// - Clustering in machine learning
// - Functional decomposition in software design
//
// ⚠️ When to use:
// - Use DP (Bell Triangle) for fast and reliable calculations
// - Use Stirling when you need exact partitions into k subsets
// - Dobinski is more theoretical / for math purposes
// - Recursive approach is educational, not optimal for large n
// ---------------------------------------------------------

public class BellNumber {
    // 1. Bell Triangle (DP)
    public static int bellNumberDP(int n) {
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }
        return dp[n][0];
    }

    // 2. Stirling Numbers of the Second Kind with Memoization
    private static long[][] memo;

    public static long stirling2ndKind(int n, int k) {
        if (n == 0 && k == 0)
            return 1;
        if (n == 0 || k == 0)
            return 0;
        if (memo[n][k] != -1)
            return memo[n][k];
        return memo[n][k] = k * stirling2ndKind(n - 1, k) + stirling2ndKind(n - 1, k - 1);
    }

    public static long bellNumberStirling(int n) {
        memo = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        long sum = 0;

        for (int k = 0; k <= n; k++) {
            sum += stirling2ndKind(n, k);
        }

        return sum;
    }

    // 3. Dobinski's Formula (approximate)

    public static double bellNumberDobinski(int n) {
        double e = Math.exp(1);
        double sum = 0.0;
        double term;
        int k = 1;

        do {
            term = Math.pow(k, n) / factorial(k);
            sum += term;
            k++;
        } while (term > 1e-15);

        return sum / e;
    }

    public static double factorial(int x) {
        double ans = 1;
        for (int i = 2; i <= x; i++)
            ans *= i;
        return ans;
    }

    // 4. Recursive formula with Binomial Coefficients + Memoization

    private static long[][] binomialMemo;
    private static long[] bellMemo;

    public static long binomialCoeff(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        if (binomialMemo[n][k] != -1)
            return binomialMemo[n][k];
        binomialMemo[n][k] = binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
        return binomialMemo[n][k];
    }

    public static long bellNumberRecursive(int n) {
        if (n == 0)
            return 1;
        if (bellMemo[n] != -1)
            return bellMemo[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += binomialCoeff(n - 1, i) * bellNumberRecursive(i);
        }
        bellMemo[n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        int n = 6;

        System.out.println("Bell number for: " + n);

        // 1. bell Triangle approach
        System.out.println("1. Bell Triangle (DP): " + bellNumberDP(n));

        // 2. Stirling Numbers
        System.out.println("2. Stirling Numbers of Second Kind: " + bellNumberStirling(n));

        // 3. Dobinski's Formula (approximate)
        System.out.println("3. Dobinski's Formula (approx.): " + bellNumberDobinski(n));

        // 4. Recursive formula + memoization
        binomialMemo = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                binomialMemo[i][j] = -1;

        bellMemo = new long[n + 1];
        for (int i = 0; i <= n; i++)
            bellMemo[i] = -1;

        System.out.println("4. Recursive Formula with Memoization: " + bellNumberRecursive(n));
    }
}
