// PascalsTriangle.cpp
// Language: C++
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Generates Pascal's Triangle up to a fixed number of rows in two ways:
// 1. Normal method using factorials to compute combinations
// 2. Optimized method using iterative addition (no factorials)
//
// 🕒 Time Complexity:
// - Normal method: O(n^2 * n) → factorials for each element
// - Optimized method: O(n^2) → simple addition of previous row
//
// 💾 Space Complexity:
// - Normal method: O(1) for calculation
// - Optimized method: O(n^2) to store triangle
//
// 📌 Real-life use cases:
// - Binomial expansions
// - Counting combinations
// - Probability problems
//
// ⚠️ When to use:
// - Normal method: when rows are small (factorials manageable)
// - Optimized method: for large rows, avoids overflow and faster
//
// 🧪 Sample Output (first 5 rows):
// Normal Method:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
//
// Optimized Method:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// ---------------------------------------------------------

#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;


ll factorial(int n) {
    ll fact = 1;
    for(int i = 1; i <= n; i++) fact *= i;
    return fact;
}


ll combination(int n, int r) {
    return factorial(n) / (factorial(r) * factorial(n - r));
}


void pascalNormal(int rows) {
    cout << "=== Pascal's Triangle (Normal Method) ===" << endl;
    for(int n = 0; n < rows; n++) {
        for(int r = 0; r <= n; r++) {
            cout << combination(n, r) << " ";
        }
        cout << endl;
    }
}


void pascalOptimized(int rows) {
    cout << "=== Pascal's Triangle (Optimized Method) ===" << endl;
    vector<vector<ll>> triangle(rows); 
    for(int n = 0; n < rows; n++) {
        triangle[n].resize(n + 1);
        triangle[n][0] = triangle[n][n] = 1;
        for(int r = 1; r < n; r++) {
            triangle[n][r] = triangle[n-1][r-1] + triangle[n-1][r]; 
        }
        for(ll x : triangle[n]) cout << x << " ";
        cout << endl;
    }
}

int main() {
    int rows = 10; 
    
    pascalNormal(rows);
    cout << endl;
    pascalOptimized(rows);   
    
    return 0;
}
