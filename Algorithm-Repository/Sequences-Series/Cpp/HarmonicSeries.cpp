// HarmonicSeries.cpp
// Language: C++
// Purpose: Calculate the sum of the first N terms of the Harmonic Series
// Time Complexity: O(n)
// Space Complexity: O(1)

#include <iostream>
using namespace std;

// Function to Calculate Harmonic Series sum
//  use only this function in contest
double harmonic_Series(int n) {
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
        sum += 1.0 / i; // Adding the Reciprocal of each term

    }
    return sum;
    // can We able to inhance?
}

int main() {
    int n;
    cout << "Enter the number of Terms: ";
    cin >> n;

    double sum = harmonic_Series(n);
    cout << "Sum of the First " << n << " Terms of the Harmonic Series: " << sum << endl;

        // Sample Input/Output
        // Input: 5
        // Output: Sum of The first 5 Terms of the Harmonic Series: 2.283333333333333

    return 0;
}
