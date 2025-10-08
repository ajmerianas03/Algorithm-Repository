// GeometricProgressionSum.cpp
// Language: C++
// Purpose: Calculate the sum of the first n terms of a geometric progression (GP)
// Time Complexity: O(1)
// Space Complexity: O(1)

#include <iostream>
#include <cmath> // For Power
using namespace std;

// method to calculate sum of first n terms of GP
long long geometricProgressionSum(int a, int r, int n) {
    // a: first term, r: common ratio, n: number of terms
    if (r == 1) {
        return (long long)a * n; // all terms are the same if ratio = 1
    }
    return (long long)a * (1 - pow(r, n)) / (1 - r); // GP sum formula
}

int main() {
    int a = 2; // first term
    int r = 3; // common ratio
    int n = 5; // number of terms

    long long sum = geometricProgressionSum(a, r, n);
    cout << "Sum of the first " << n << " terms of the geometric progression: " << sum << endl;

    return 0;
}
