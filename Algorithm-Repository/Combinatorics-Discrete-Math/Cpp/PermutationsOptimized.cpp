// PermutationsOptimized.cpp
// Language: C++
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

#include <iostream>
using namespace std;
typedef long long ll;

ll permutation(int n, int r) {
    ll result = 1;
    for(int i = 0; i < r; i++) {
        result *= (n - i);  
    }
    return result;
}

int main() {
    int n, r;
    cout << "Enter total number of items (n): ";
    cin >> n;
    cout << "Enter number of items to arrange (r): ";
    cin >> r;

    if(r > n) {
        cout << "Error: r cannot be greater than n." << endl;
        return 0;
    }

    ll ans = permutation(n, r);
    cout << "Number of permutations P(" << n << ", " << r << ") = " << ans << endl;

    return 0;
}
