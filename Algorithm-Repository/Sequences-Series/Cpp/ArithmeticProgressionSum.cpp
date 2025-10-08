// ArithmeticProgressionSum.cpp
// Language: C++
// Purpose: Calculate the sum of the first n terms of an arithmetic progression (AP)
// Time Complexity: O(1)
// Space Complexity: O(1)

#include <iostream>
using namespace std;

// Function to calculate the sum of the first n terms of an AP
int arithmeticProgressionSum(int a, int d, int n) {
    // a: first term, d: common difference, n: number of terms
    return n * (2 * a + (n - 1) * d) / 2;
}

int main() {
    int a = 5; // first term
    int d = 3; // common difference
    int n = 10; // number of terms

    int sum = arithmeticProgressionSum(a, d, n);
    cout << "Sum of the first " << n << " terms of the arithmetic progression: " << sum << endl;

    return 0;
}
