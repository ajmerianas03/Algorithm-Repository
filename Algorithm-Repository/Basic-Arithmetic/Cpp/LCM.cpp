// LCM.cpp
// Language: C++
// Purpose: Compute the Least Common Multiple (LCM) of two integers using GCD
// Time Complexity: O(log(min(a, b))) — dominated by GCD computation
// Space Complexity: Iterative: O(1)

#include <bits/stdc++.h>
using namespace std;

/*
 * ✅ Description:
 * LCM (Least Common Multiple) finds the smallest positive integer divisible by both numbers.
 * Formula: lcm(a, b) = |a * b| / gcd(a, b)
 *
 * 🧼 Clean and optimized implementation:
 *   - Handles negative numbers using llabs()
 *   - Efficient via Euclidean GCD
 *   - Works for large integers using long long
 *
 * 🧪 Sample Input / Output:
 *   Input:
 *     12 18
 *   Output:
 *     LCM of 12 and 18 is: 36
 *
 * 🧰 Use Case:
 *   - Scheduling problems (finding common intervals)
 *   - Simplifying fractions
 *   - Problems involving multiples and modular arithmetic
 */
long long gcd(long long a, long long b) {
    a = llabs(a);
    b = llabs(b);
    while (b != 0) {
        long long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

long long lcm(long long a, long long b) {
    if (a == 0 || b == 0) return 0;
    return llabs(a * b) / gcd(a, b);
}

int main() {
    long long a, b;
    cout << "Enter 1st number: ";
    cin >> a;
    cout << "enter 2nd number: ";
    cin >> b;

    long long ans = lcm(a, b);
    cout << "LCM of " << a << ", " << b << " = " << ans << "\n";
    return 0;
}
