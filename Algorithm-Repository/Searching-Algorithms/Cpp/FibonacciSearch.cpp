// FibonacciSearch.cpp
// Language: C++
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Fibonacci Search is a searching algorithm for sorted arrays.
// It uses Fibonacci numbers to determine the probe position,
// making it efficient when sequential access is faster than random access.
//
// 🧮 How it works:
// 1. Find the smallest Fibonacci number greater than or equal to n.
// 2. Use Fibonacci numbers (fibM, fibMm1, fibMm2) to split the array.
// 3. Compare the element at index (offset + fibMm2):
//    - If target is greater, move the offset forward and shift Fibonacci numbers down.
//    - If target is smaller, move Fibonacci numbers down without shifting offset.
//    - If match found, return index.
// 4. After the loop, check if the last element equals the target.
// 5. If not found, return -1.
//
// 🕒 Time Complexity:
// - Best Case: O(1)
// - Average/Worst Case: O(log n)
//
// 💾 Space Complexity:
// - O(1) → only a few variables stored.
//
// 📌 Real-life use cases:
// - Useful for sorted data stored on slower sequential-access storage.
// - Suitable when minimizing random access improves performance.
//
// ⚠️ When to use:
// - Works only on sorted arrays.
// - Prefer Binary Search for general in-memory arrays.
//
// 🧪 Sample Input/Output:
// Array:  [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
// Target: 85
// Output: Element found at index: 8
//
// Array:  [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
// Target: 30
// Output: Element not found
// ---------------------------------------------------------

#include <iostream>
#include <algorithm>
using namespace std;

int fibonacciSearch(int arr[], int n, int target) {
    
    int fibMm2 = 0;  
    int fibMm1 = 1; 
    int fibM = fibMm2 + fibMm1;  
    
    
    while (fibM < n) {
        fibMm2 = fibMm1;
        fibMm1 = fibM;
        fibM = fibMm2 + fibMm1;
    }

    
    int offset = -1;

    
    while (fibM > 1) {
        
        int i = min(offset + fibMm2, n - 1);

        if (arr[i] < target) {
            fibM = fibMm1;
            fibMm1 = fibMm2;
            fibMm2 = fibM - fibMm1;
            offset = i;
        }
        else if (arr[i] > target) {
            fibM = fibMm2;
            fibMm1 = fibMm1 - fibMm2;
            fibMm2 = fibM - fibMm1;
        }
        
        else {
            return i;
        }
    }

    
    if (fibMm1 && arr[offset + 1] == target)
        return offset + 1;

    return -1;
}

int main() {
    int arr[] = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
    int n = sizeof(arr) / sizeof(arr[0]);
    int targets[] = {85, 10, 100, 30};

    cout << "=== Fibonacci Search ===" << endl;
    for (int t : targets) {
        int index = fibonacciSearch(arr, n, t);
        if (index != -1)
            cout << "Element " << t << " found at index: " << index << endl;
        else
            cout << "Element " << t << " not found in the array." << endl;
    }
    return 0;
}
