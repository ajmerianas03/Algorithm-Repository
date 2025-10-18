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

#include <iostream>
using namespace std;
typedef long long ll;

ll factorial(int n) {
    ll fact = 1;
    for(int i = 1; i <= n; i++) {
        fact *= i;
    }
    return fact;
}


ll permutation(int n, int r) {
    return factorial(n) / factorial(n - r);
}

int main() {
    int n, r;
    cout << "Enter Total number of items (n): ";
    cin >> n;
    cout << "Enter number Of items to arrange (r): ";
    cin >> r;

    ll ans = permutation(n, r);
    cout << "Number of permutations P(" << n << ", " << r << ") = " << ans << endl;

    return 0;
}
