#include<iostream>
#include <vector>
using namespace std;

// ---------------------------------------------------------
// 🧠 Short Description:
// Stirling Numbers of the Second Kind count the ways to partition 
// a set of n elements into k non-empty subsets. This program 
// computes S(n, k) using three methods:
//
// 1) Recursive method (inefficient due to repeated calculations)
// 2) Memoized recursion (top-down dynamic programming)
// 3) Tabulation (bottom-up dynamic programming)
//
// Approach:
// - Uses recurrence: S(n, k) = k * S(n-1, k) + S(n-1, k-1)
// - Base cases: S(0, 0) = 1, and zero otherwise when n=0 or k=0 but not both
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Recursive: exponential (inefficient for large n, k)
//  - Memoized and Tabulation: O(n*k)
// 💾 Space Complexity:
//  - O(n*k) for memo and dp tables
//
// ✅ Suitable for moderate input sizes and educational purposes
// ---------------------------------------------------------

int stirlingRecursive(int n, int k){
    if(n == 0 && k == 0) return 1;
    if(n == 0 || k == 0) return 0;
    return k * stirlingRecursive(n-1,k) + stirlingRecursive(n-1,k-1);
}

vector<vector<int>> memo;
int stirlingMemoHelper(int n, int k){
     if(n < 0 || k < 0) return 0;
    if(n == 0 && k == 0) return 1;
    if(n == 0 || k == 0) return 0;
    if(memo[n][k] != -1) return memo[n][k];
    memo[n][k] = k * stirlingMemoHelper(n-1,k) + stirlingMemoHelper(n-1,k -1);
    return memo[n][k];
}
int stirlingMemoized(int n, int k){
    memo.assign(n + 1, vector<int>(k + 1,-1));

    return stirlingMemoHelper(n,k);
}

int stirlingTabulation(int n, int k){
    vector<vector<int>> dp(n + 1, vector<int>(k + 1, -1));
    dp[0][0] = 1;
for (int i = 1; i <= n; i++) {
    dp[i][0] = 0; 
}
for (int j = 1; j <= k; j++) {
    dp[0][j] = 0;  
}

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= k; j++)
        {
            dp[i][j] = j * dp[i-1][j] + dp[i-1][j-1];
        }
        
    }
    return dp[n][k];
    
}


int main(){
    int n =5;
    int k = 3;

    cout << "=== Stirling Numbers of the Second Kind ===" << endl;
    cout << "S(" << n << ", " << k << ") using Recursive:  " << stirlingRecursive(n, k) << endl;
    cout << "S(" << n << ", " << k << ") using Memoized:   " << stirlingMemoized(n, k) << endl;
    cout << "S(" << n << ", " << k << ") using Tabulation: " << stirlingTabulation(n, k) << endl;
}