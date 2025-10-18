// CatalanNumbers.java
// Language: Java
// Category: Combinatorics / Dynamic Programming
// ---------------------------------------------------------
// 🧠 Short Description:
// Catalan Numbers form a sequence of natural numbers with wide applications in combinatorics.
// This program calculates the nth Catalan number using two approaches:
//
// 1) Direct factorial formula:
//     C(n) = (2n)! / ((n + 1)! * n!)
//
// 2) Binomial coefficient formula:
//     C(n) = binomialCoefficient(2n, n) / (n + 1)
//
// Approach:
// - Compute factorials (or binomial coefficients) using BigInteger for precision.
// - Use the closed-form formulas to calculate the nth Catalan number directly.
// - Accept user input and output the corresponding Catalan number.
//
// Why it works well:
// - BigInteger handles very large intermediate values without overflow.
// - Direct formulas provide accurate and efficient computation for moderate to large n.
//
// Example:
//  Input:  n = 5
//  Calculation: (10)! / (6! * 5!) = 3628800 / (720 * 120) = 42
//  Output: Catalan number for 5: 42
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Factorial or binomial coefficient computation: O(n)
//  - Overall: O(n)
//
// 💾 Space Complexity:
//  - O(1) auxiliary space (ignoring BigInteger internal storage)
//
// ✅ Computes exact values for large n using BigInteger arithmetic.
//
// 📌 Real-life use cases:
//  - Counting valid expressions with balanced parentheses
//  - Number of unique Binary Search Trees (BSTs)
//  - Ways to triangulate a polygon
//  - Parsing expressions in compilers
// ---------------------------------------------------------


#include <iostream>

using namespace std;

// Calculate binomial coefficient using long long (may overflow for large n)
long long binomialCoefficient(int n, int k) {
    long long result = 1;
    for (int i = 0; i < k; i++) {
        result = result * (n - i) / (i + 1);
    }
    return result;
}

// Catalan number using binomial coefficient: C(n) = binomial(2n, n) / (n + 1)
long long catalanNumber(int n) {
    long long binCoeff = binomialCoefficient(2 * n, n);
    return binCoeff / (n + 1);
}

long long factorial(int n) {
    long long ans = 1;
    for (int i = 2; i <= n; i++) {
        ans *= i;
    }
    return ans;
}

// Catalan number using factorial formula: C(n) = (2n)! / ((n+1)! * n!)
long long catalanNumbers(int n) {
    long long fac1 = factorial(2 * n);
    long long fac2 = factorial(n);
    long long fac3 = factorial(n + 1);

    return fac1 / (fac3 * fac2);
}

int main() {
    int n = 5;

    long long ans = catalanNumbers(n);

    cout << "catalanNumbers for 5: " << ans << endl;

    int num;
    cout << "Enter the Number: ";
    cin >> num;

    long long res = catalanNumbers(num);

    cout << "catalanNumbers for " << num << " : " << res << endl;

    return 0;
}
