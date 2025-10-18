// BellNumber.cpp
// Language: C++
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Computes Bell Numbers, which represent the number of ways to partition
// a set of n elements into non-empty subsets.
//
// Four approaches implemented:
// 1. Bell Triangle (Dynamic Programming)
// 2. Stirling Numbers of the Second Kind (with Memoization)
// 3. Dobinski’s Formula (Approximate Infinite Series)
// 4. Recursive Formula using Binomial Coefficients + Memoization
//
// 🕒 Time Complexities:
// 1. Bell Triangle: O(n²)
// 2. Stirling Numbers: O(n²) with memoization
// 3. Dobinski's Formula: Approximate, depends on convergence (roughly O(n))
// 4. Recursive + Binomial Coefficients: O(n²) with memoization
//
// 💾 Space Complexities:
// 1. Bell Triangle: O(n²)
// 2. Stirling Numbers: O(n²)
// 3. Dobinski: O(1) or minimal
// 4. Recursive: O(n²) (memo tables)
//
// 📌 Real-life use cases:
// - Grouping elements into clusters or teams (unordered partitions)
// - Machine learning clustering
// - Functional decomposition in software engineering
//
// ⚠️ When to use:
// - Use Bell Triangle for efficient and exact computation
// - Use Stirling Numbers when interested in partitions into k subsets
// - Dobinski’s formula is mostly theoretical / approximation
// - Recursive approach is useful for understanding and small n
// ---------------------------------------------------------

#include<iostream>
#include <cmath>
#include<vector>
using namespace std;
typedef long long ll;


    // 1. Bell Triangle (DP)

ll bellNumberDP(int n){
      ll dp[n + 1][n + 1] = {0};
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++)
    {
        dp[i][0] = dp[i-1][i-1];
        for(int j =1; j <=i;j++){
            dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
        }
    }
    return dp[n][0];
    
}

    // 2. Stirling Numbers of the Second Kind with Memoization
    vector<vector<ll>> memo;

    ll stirling2ndKind(int n, int k){
        if(n ==0 && k ==0) return 1;
        if(n==0 || k == 0) return 0;
        if(memo[n][k] != -1) return memo[n][k];
        return memo[n][k]= k * stirling2ndKind(n-1,k) + stirling2ndKind(n-1,k-1);
    }

    ll bellNumberStirling(int n){
       memo.assign(n + 1, vector<ll>(n + 1, -1));
       ll sum =0;

       for(int i=0; i <= n;i++){
         sum += stirling2ndKind(n, i);
       }
       return sum;
    }


    const double EPS = 1e-15;

// 3. Dobinski’s Formula (Approximate)
double factorial(int x) {
    double ans = 1.0;
    for (int i = 2; i <= x; i++)
        ans *= i;
    return ans;
}

double bellNumberDobinski(int n) {
    double e = exp(1.0);
    double sum = 0.0;
    double term;
    int k = 1;

    do {
        term = pow(k, n) / factorial(k);
        sum += term;
        k++;
    } while (term > EPS);

    return sum / e;
}

// 4. Recursive Bell Number using Binomial Coefficients + Memoization
vector<vector<ll>> binomialMemo;
vector<ll> bellMemo;

ll binomialCoeff(int n, int k) {
    if (k == 0 || k == n)
        return 1;
    if (binomialMemo[n][k] != -1)
        return binomialMemo[n][k];
    return binomialMemo[n][k] = binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
}

ll bellNumberRecursive(int n) {
    if (n == 0)
        return 1;
    if (bellMemo[n] != -1)
        return bellMemo[n];

    ll sum = 0;
    for (int i = 0; i < n; i++) {
        sum += binomialCoeff(n - 1, i) * bellNumberRecursive(i);
    }

    bellMemo[n] = sum;
    return sum;
}



int main(){
    int n =6;

    cout << "Bell number for " << n << " : " << bellNumberDP(n) <<endl;
    cout << "Bell number for " << n << " using Stirling numbers: " << bellNumberStirling(n) << endl;

        // dobinski's formula (approx.)
    cout << "3. Dobinski's Formula (approx): " << bellNumberDobinski(n) << endl;

    // recursive formula with binomial coefficients
    binomialMemo.assign(n + 1, vector<ll>(n + 1, -1));
    bellMemo.assign(n + 1, -1);

    cout << "4. Recursive Formula with Memoization: " << bellNumberRecursive(n) << endl;


    return 0;
}