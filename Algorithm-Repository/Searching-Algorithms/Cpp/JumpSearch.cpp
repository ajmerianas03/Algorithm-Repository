// JumpSearch.cpp
// Language: C++
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Jump Search is an efficient searching algorithm for sorted arrays.
// It works by jumping ahead in fixed steps (usually √n) instead of checking 
// each element one by one (like Linear Search). Once the algorithm finds a block
// where the target element might exist, it performs a linear search inside that block.
//
// 🧪 How it works:
// 1. Choose a fixed jump size = √n (where n = number of elements).
// 2. Jump through the array in steps of size `jump`.
// 3. Stop when the target element is less than or equal to the current element.
// 4. Perform a linear search in the previous block to find the exact index.
// 5. If not found, return -1.
//
// 🕒 Time Complexity:
// - Best Case: O(1)           → element found on first jump
// - Worst Case: O(√n)         → jump through and then linear search
// - Average Case: O(√n)
//
// 💾 Space Complexity:
// - O(1) → uses constant extra space
//
// 📌 Real-life use cases:
// - Searching in sorted arrays stored on disk or sequential storage (e.g., files).
// - Searching in sorted linked lists where random access is costly.
// - Useful when minimizing the number of element comparisons is important.
//
// ⚠️ When to use:
// - Only on sorted arrays.
// - Preferable over Binary Search when random access is expensive.
// - Binary Search is faster in RAM, but Jump Search is useful in sequential access scenarios.
//
// 🧪 Sample Input/Output:
// Array: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25]
// Target: 23
// Output: Element found at index: 11
// ---------------------------------------------------------

#include <iostream>
#include <cmath> 
using namespace std;

int jumpSearch(const int arr[], int len, int target) {
    int jump = static_cast<int>(sqrt(len));  
    int prev = 0;

    while (arr[min(jump, len) - 1] < target) {
        prev = jump;
        jump += static_cast<int>(sqrt(len));
        if (prev >= len) return -1;  
    }

    
    for (int i = prev; i < min(jump, len); i++) {
        if (arr[i] == target) return i;
    }

    return -1;  
}

int main() {
    int arr[] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25};
    int len = sizeof(arr) / sizeof(arr[0]);

    int targets[] = {23, 1, 25, 8, 30};  

    cout << "=== Jump Search ===" << endl;
    for (int t : targets) {
        int index = jumpSearch(arr, len, t);
        if (index != -1)
            cout << "Element " << t << " found at index: " << index << endl;
        else
            cout << "Element " << t << " not found in the array." << endl;
    }

    return 0;
}
