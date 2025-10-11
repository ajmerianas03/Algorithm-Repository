// Square.cpp
// Language: C++
// Purpose: Compute the square of a number (x^2)
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in geometry calculations, physics, and number theory

#include <iostream>
using namespace std;

int main() {
    double x;
    cout << "enter a number: ";
    cin >> x;

    double result = x * x;
    cout << "square of " << x << " = " << result << endl;

    cout << "example: Area of square with side " << x << " = " << result << endl;

    return 0;
}
