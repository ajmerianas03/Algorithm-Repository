// Addition.cpp
// Language: C++
// Purpose: Perform addition of two numbers (integer or floating-point)
// Time Complexity: O(1)
// Space Complexity: O(1)

#include <iostream>
using namespace std;

int main() {
    double a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;

    double sum = a + b;
    cout << "Sum: " << sum << endl;
    return 0;
}
