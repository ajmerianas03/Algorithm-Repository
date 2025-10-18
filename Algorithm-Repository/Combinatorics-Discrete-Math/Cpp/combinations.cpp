// Combinations.cpp
// Language: C++
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Calculates number of ways to choose r items from n distinct items
// where order does NOT matter (combinations), using factorial formula.
//
// 🕒 Time Complexity: O(n) → factorial calculations
// 💾 Space Complexity: O(1)
// ---------------------------------------------------------

#include <iostream>
using namespace std;
typedef long long ll;


ll factorial(int n) {
    ll fact = 1;
    for(int i = 1; i <= n; i++)
        fact *= i;
    return fact;
}


ll combination(int n, int r) {
    if(r > n) return 0;
    return factorial(n) / (factorial(r) * factorial(n - r));
}

int main() {
    int n, r;
    cout << "Enter total number of items (n): ";
    cin >> n;
    cout << "Enter number of items to choose (r): ";
    cin >> r;

    ll ans = combination(n, r);
    cout << "Number of combinations C(" << n << ", " << r << ") = " << ans << endl;

    return 0;
}
