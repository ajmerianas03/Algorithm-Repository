// CombinationsOptimized.cpp
// Language: C++
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Calculates number of combinations C(n,r) efficiently without computing full factorials.
//
// 🕒 Time Complexity: O(r) → only r multiplications/divisions
// 💾 Space Complexity: O(1)
// ---------------------------------------------------------

#include <iostream>
using namespace std;
typedef long long ll;


ll combination(int n, int r) {
    if(r > n) return 0;
    if(r > n - r) r = n - r; 
    ll result = 1;
    for(int i = 0; i < r; i++) {
        result *= (n - i);     
        result /= (i + 1);      
    }
    return result;
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
