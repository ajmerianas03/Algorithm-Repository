// Subtraction.cpp
// Language: C++
// Purpose: Perform subtraction of two numbers (integer or floating-point)
// Time Complexity: O(1)
// Space Complexity: O(1)

#include <iostream>
using namespace std;

int main() {
    double a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;

    double ans = a - b;
    cout << "Difference: " << ans << endl;
    return 0;
}