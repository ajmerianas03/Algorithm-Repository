// ExponentialSearch.cpp
// Language: C++
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Exponential Search is an efficient searching algorithm for sorted arrays,
// especially useful when the target element is near the beginning of the array
// or when the array size is unknown (e.g., infinite or streaming data).
// It works by first finding the range where the element may lie and then
// applying Binary Search within that range.
//
// 🧮 How it works:
// 1. Check the first element (arr[0]). If it matches the target, return 0.
// 2. Start with bound = 1 and keep doubling it (1, 2, 4, 8, ...) until:
//    - bound >= n (array length), or
//    - arr[bound] >= target
// 3. Once the range is found (bound/2 to min(bound, n-1)),
//    perform a Binary Search within that range.
// 4. Return the index if found, otherwise -1.
//
// 🕒 Time Complexity:
// - Best Case: O(1)            → element found at index 0
// - Average Case: O(log i)     → i = index of target
// - Worst Case: O(log n)       → similar to Binary Search
//
// 💾 Space Complexity:
// - O(1) → constant extra space (iterative version)
//
// 📌 Real-life use cases:
// - Searching in large sorted datasets or unbounded arrays.
// - Data streams or external storage where size is unknown.
// - Faster than Binary Search if the target is near the beginning.
//
// ⚠️ When to use:
// - Works only on sorted arrays.
// - Very efficient when the target is expected to be close to the start.
// - When the array length is unknown or expensive to compute.
//
// 🧪 Sample Input/Output:
// Array:  [1, 3, 5, 7, 9, 13, 15, 17, 19, 25]
// Target: 13
// Output: Element found at index: 5
//
// Array:  [1, 3, 5, 7, 9, 13, 15, 17, 19, 25]
// Target: 8
// Output: Element not found
// ---------------------------------------------------------

#include <iostream>
#include <algorithm>
using namespace std;

int binarySearch(int arr[], int left, int right, int target) {
    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; 
}

int exponentialSearch(int arr[], int n, int target) {
   if (arr[0] == target) {
        return 0;
    }

    
    int bound = 1;
    while (bound < n && arr[bound] <= target) {
        bound *= 2;
    }

    int left = bound / 2;
    int right = min(bound, n - 1);
    return binarySearch(arr, left, right, target);
}

int main() {
    int arr[] = {1, 3, 5, 7, 9, 13, 15, 17, 19, 25};
    int n = sizeof(arr) / sizeof(arr[0]);
    int targets[] = {13, 1, 25, 8, 50};

    cout << "=== Exponential Search ===" << endl;
    for (int t : targets) {
        int index = exponentialSearch(arr, n, t);
        if (index != -1)
            cout << "Element " << t << " found at index: " << index << endl;
        else
            cout << "Element " << t << " not found in the array." << endl;
    }

    return 0;
}
