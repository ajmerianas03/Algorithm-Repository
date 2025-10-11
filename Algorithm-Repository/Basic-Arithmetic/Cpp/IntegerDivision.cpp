// IntegerDivision.cpp
// Language: C++
// Purpose: perform integer division, floor division, and ceiling division
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in array partitioning, paging, and problem-solving in competitive programming

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cout << "enter dividend and divisor: ";
    cin >> a >> b;

    if(b == 0) {
        cout << "division by zero is not allowed!" << endl;
        return 1;
    }

    int iDiv = a / b;                 // this do integer division
    int fDiv = (a >= 0) ? a / b : (a - b + 1) / b;   // this do floor division
    int cDiv = (a + b - 1) / b;      // this do ceiling division

    cout << "integer Division (truncated): " << iDiv << endl;
    cout << "Floor Division: " << fDiv << endl;
    cout << "Ceiling Division: " << cDiv << endl;

    return 0;
}
