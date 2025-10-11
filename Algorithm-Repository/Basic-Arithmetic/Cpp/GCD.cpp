// GCD.cpp
// Language: C++
// Purpose: Compute the Greatest Common Divisor (GCD) of two integers using Euclidean Algorithm
// Time Complexity: O(log(min(a, b)))
// Space Complexity: Iterative: O(1), Recursive: O(log(min(a, b))) due to recursion stack

/*
 * ✅ Description:
 * GCD (Greatest Common Divisor) finds the largest integer that divides both numbers without remainder.
 * Includes both iterative and recursive implementations for clarity.
 *
 * 🧼 Clean and optimized implementation:
 *   - Handles negative numbers using llabs()
 *   - Works with large integers using long long
 *
 * 🧪 Sample Input / Output:
 *   Input:
 *     48 18
 *   Output:
 *     GCD of 48 and 18 is: 6
 *
 * 🧰 Use Case:
 *   - Simplifying fractions
 *   - Computing LCM (lcm(a,b) = |a*b| / gcd(a,b))
 *   - Modular arithmetic, cryptography (modular inverse, RSA)
 */


#include <bits/stdc++.h>
using namespace std;

long long gcd(long long a, long long b){
     a = llabs(a);
    b = llabs(b);

    while(b !=0){
        long long temp =b;
        b = a%b;
        a = temp;

    }
    return a;

}

// recursion approach
long long gcdRecursive(long long a, long long b) {
    if (b == 0) return llabs(a);
    return gcdRecursive(b, a % b);
}
int main(){
    long long a, b;
    cin >> a >> b;

     cout << "GCD(" << a << ", " << b << ") = " << gcd(a, b) << "\n";
    return 0;
}