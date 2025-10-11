// Multiplication.cpp
// Language: C++
// Purpose: Perform Multiplication of two numbers 
// Time Complexity: O(1)
// Space Complexity: O(1)

#include <iostream>
using namespace std;

int main() {
    double a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;

    double ans = a * b;
    cout << "Multiplication: " << ans << endl;
    return 0;
}