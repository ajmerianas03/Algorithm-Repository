// Power.cpp
// Language: C++
// Purpose: calculate x^n (power of a number) efficiently
// Time Complexity: O(log n) using binary exponentiation
// Space Complexity: O(1)
// Use Case: Useful in combinatorics, number theory, and modular arithmetic

#include <iostream>
using namespace std;

long long power(long long x, long long n) {
    long long result = 1;
    while(n > 0) {
        if(n % 2 == 1) result *= x;  
        x *= x;
        n /= 2;
    }
    return result;
}

int main() {
    long long x, n;
    cout << "enter base and exponent: ";
    cin >> x >> n;

    long long result = power(x, n);
    cout << x << "^" << n << " = " << result << endl;

    cout << "example: 2^10 = " << power(2, 10) << endl;

    return 0;
}
