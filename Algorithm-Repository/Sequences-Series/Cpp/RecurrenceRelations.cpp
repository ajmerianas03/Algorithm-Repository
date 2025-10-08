// RecurrenceRelations.cpp
// Language: C++
// Purpose: Demonstrate linear, homogeneous, and inhomogeneous recurrence relations
// Time Complexity: O(n) for iterative solution
// Space Complexity: O(1) if only storing necessary previous terms

/*
✅ Short description:
A recurrence relation defines each term of a sequence using its previous terms.

Types:
1️⃣ Linear: Each term is a linear combination of previous terms (coefficients multiply terms)
   Example: T(n) = 2*T(n-1) + 3*T(n-2)

2️⃣ Homogeneous: Linear recurrence with no extra constant term (depends only on previous terms)
   Example: Fibonacci: F(n) = F(n-1) + F(n-2)

3️⃣ Inhomogeneous (non-homogeneous): Linear recurrence with an extra additive function/constant
   Example: T(n) = 2*T(n-1) + n
*/

#include <iostream>
using namespace std;
// adding some more thing in features

// Homogeneous linear recurrence: Fibonacci sequence
int fibonacci(int n) {
    if (n <= 1) return n;
    int a = 0, b = 1, c = 0;
    for (int i = 2; i <= n; i++) {
        c = a + b; // F(n) = F(n-1) + F(n-2)
        a = b;
        b = c;
    }
    return b;
}

// Linear homogeneous recurrence: T(n) = 2*T(n-1) + 3*T(n-2)
int linear_Homogeneous(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    int t0 = 0, t1 = 1, tn = 0;
    for (int i = 2; i <= n; i++) {
        tn = 2 * t1 + 3 * t0;
        t0 = t1;
        t1 = tn;
    }
    return tn;
}

// Linear inhomogeneous recurrence: T(n) = 2*T(n-1) + n
int linear_Inhomogeneous(int n) {
    if (n == 0) return 0;
    int t = 0;
    for (int i = 1; i <= n; i++) {
        t = 2 * t + i;
    }
    return t;
}

int main() {
    int n;
    cout << "Enter n: ";
    cin >> n;

    cout << "Fibonacci F(" << n << ") = " << fibonacci(n) << endl;
    cout << "Linear Homogeneous T(" << n << ") = " << linear_Homogeneous(n) << endl;
    cout << "Linear Inhomogeneous T(" << n << ") = " << linear_Inhomogeneous(n) << endl;

    /*
    Sample Input/Output:
    Input: n = 5
    Output:
    Fibonacci F(5) = 5
    Linear Homogeneous T(5) = 61
    Linear Inhomogeneous T(5) = 57
    */

    return 0;
}
