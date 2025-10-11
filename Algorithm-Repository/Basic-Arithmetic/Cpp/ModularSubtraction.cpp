// ModularSubtraction.cpp
// Language: C++
// Purpose: perform modular subtraction (a - b) % mod
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in cryptography, hash functions, and cyclic sequences

#include <iostream>
using namespace std;

int main() {
    int a, b, mod;
    cout << "Enter two numbers and modulus: ";
    cin >> a >> b >> mod;

    if(mod <= 0) {
        cout << "Modulus must be positive!" << endl;
        return 1;
    }

    int result = ((a % mod) - (b % mod)) % mod;
    if(result < 0) result += mod;  // Ensure non-negative result

    cout << "Modular Subtraction: " << result << endl;

    // example Use case:
    // imagin a Clock with 12 hours (mod = 12)
    // current hour = 3, subtract 5 hour: (3 - 5) % 12 = 10
    int ch = 3, sh = 5, cMod = 12;
    int ans = ((ch % cMod) - (sh % cMod)) % cMod;
    if(ans < 0) ans += cMod;
    cout << "Clock example: 3 - 5 hours mod 12 = " << ans << endl;

    return 0;
}
