// ModularAddition.cpp
// Language: C++
// Purpose: perform modularAaddition (a + b) % mod
// Time Complexity: O(1)
// Space Complexity: O(1)

#include <iostream>
using namespace std;

int main() {
    int a, b, mod;
    cout << "enter Two numbers and modulus: ";
    cin >> a >> b >> mod;

    if(mod <= 0) {
        cout << "modulus must be positive" << endl;
        return 1;
    }

    int result = ( (a % mod) + (b % mod) ) % mod;
    
    if(result < 0) result += mod;

    cout << "Modular Addition: " << result << endl;
    return 0;
}
