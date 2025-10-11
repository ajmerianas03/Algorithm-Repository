// ModularMultiplication.cpp
// Language: C++
// Purpose: Perform modular multiplication (a * b) % mod
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in cryptography (RSA), combinatorics, cyclic sequences

#include <iostream>
using namespace std;

int main() {
    long long a, b;
    int mod;
    cout << "enter two numbers and modulus: ";
    cin >> a >> b >> mod;

    if(mod <= 0) {
        cout << "podulus must be positive" << endl;
        return 1;
    }

    long long result = ((a % mod) * (b % mod)) % mod;
    if(result < 0) result += mod;  

    cout << "Modular Multiplication: " << result << endl;

    // example of use case: clock with 12 hour, multiply his positions
    int ch = 3, multi = 4, cMod = 12;
    int ans = ((ch % cMod) * (multi % cMod)) % cMod;
    cout << "Clock example: 3 * 4 mod 12 = " << ans << endl;

    return 0;
}
