// PowerSumFast.cpp
// Language: C++
// Purpose: calculate The Sum of the First n Natural Numbers raised to the K-th Power using Formula-Based Approach for Small K
// Time Complexity: O(1) for k <= 5, O(n) for k > 5
// Space Complexity: O(1)

#include <iostream>
#include <cmath> // For pow()(Power)
using namespace std;

// Function To Calculate Power Sum
double power_Sum(int n, int k) {
    switch(k) {
        case 1: return n * (n + 1) / 2.0;
        case 2: return n * (n + 1) * (2 * n + 1) / 6.0;
        case 3: {
            double temp = n * (n + 1) / 2.0;
            return temp * temp;
        }
        case 4: return n * (n + 1) * (2*n + 1) * (3*n*n + 3*n -1) / 30.0;
        case 5: return n * n * (n + 1) * (n + 1) * (2*n*n + 2*n -1) / 12.0;
        default: {
            // fallback for k > 5
            double sum = 0.0;
            for(int i = 1; i <= n; i++)
                sum += pow(i, k);
            return sum;
        } //more optimization requir?? If yes then we do latter
    }
}

int main() {
    int n, k;
    cout << "Enter N (Number of Terms): ";
    cin >> n;
    cout << "Enter K (Power): ";
    cin >> k;

    double sum = power_Sum(n, k);
    cout << "Sum of " << k << "-th powers of first " << n << " natural numbers: " << sum << endl;

    // Sample Input/Output
    // Input: n = 5, k = 2
    // Output: Sum = 55.0

    return 0;
}
