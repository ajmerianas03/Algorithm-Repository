// ModularInverse.cpp
// Language: C++
// Purpose: finding modular inverse of a modulo m
// Time Complexity: O(log m)
// Space Complexity: O(1)
// Use Case: Cryptography (RSA), solving linear congruences

#include <iostream>
using namespace std;

// extended Euclidean Algorithm
int gcdExtended(int a, int b, int &x, int &y) {
    if(a == 0) {
        x = 0; y = 1;
        return b;
    }
    int x1, y1;
    int gcd = gcdExtended(b % a, a, x1, y1);
    x = y1 - (b / a) * x1;
    y = x1;
    return gcd;
}

int modInverse(int a, int m) {
    int x, y;
    int g = gcdExtended(a, m, x, y);
    if(g != 1) {
        cout << "inverse doesn't exist (a and m are not coprime)" << endl;
        return -1;
    } else {
        x = (x % m + m) % m; // for positive result
        return x;
    }
}

int main() {
    int a, mod;
    cout << "enter number And modulus: ";
    cin >> a >> mod;

    int inverse = modInverse(a, mod);
    if(inverse != -1) 
        cout << "modular Inverse: " << inverse << endl;

    // example use case: Solving 3*x ≡ 1 (mod 11)
    int x = modInverse(3, 11); 
    if(x != -1) cout << "for example: 3 * " << x << " % 11 = 1" << endl;

    return 0;
}
