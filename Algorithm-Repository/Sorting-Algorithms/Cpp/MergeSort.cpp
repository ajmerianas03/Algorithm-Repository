// MergeSort.cpp
// Language: cpp
// Category: Sorting Algorithms
// ---------------------------------------------------------
// 🧠 Short Description:
// Merge Sort is a classic Divide and Conquer sorting algorithm.
// It works in three main steps:
// 1. Divide → Recursively split the array into two halves
// 2. Conquer → Sort each half individually
// 3. Combine → Merge the sorted halves to produce the final sorted array
//
// Why it works well:
// - Each subarray of size 1 is already sorted.
// - Merging two sorted arrays can be done efficiently in linear time.
// - Because we divide the array logarithmically, the overall time is O(n log n).
//
// Example:
//  Input:  [8, 7, 2, 4, 6, 3, 1, 5]
//  Divide: [8,7,2,4] [6,3,1,5]
//  Merge & Sort step by step
//  Output: [1, 2, 3, 4, 5, 6, 7, 8]
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Best Case: O(n log n)
//  - Average Case: O(n log n)
//  - Worst Case: O(n log n)
//
// 💾 Space Complexity:
//  - O(n) → because of the temporary arrays used during merging
//
// ✅ Stable Sort (preserves the order of equal elements)
// ---------------------------------------------------------

#include <iostream>
#include <vector>
using namespace std;

void merge(int arr[], int l, int mid, int r) {
    int len1 = mid - l + 1;
    int len2 = r - mid;

    vector<int> left(len1);
    vector<int> right(len2);

    for (int i = 0; i < len1; i++) {
        left[i] = arr[l + i];
    }

    for (int j = 0; j < len2; j++) {
        right[j] = arr[mid + 1 + j];
    }

    int i = 0, j = 0, k = l;

    
    while (i < len1 && j < len2) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }
        k++;
    }

    while (i < len1) {
        arr[k] = left[i];
        i++;
        k++;
    }

    while (j < len2) {
        arr[k] = right[j];
        j++;
        k++;
    }
}

void merge_sort(int arr[], int l, int r) {
    if (l >= r) {
        return;
    }

    int mid = l + (r - l) / 2;

    merge_sort(arr, l, mid);
    merge_sort(arr, mid + 1, r);

    if (arr[mid] <= arr[mid + 1]) return;

    merge(arr, l, mid, r);
}

void print_Array(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    cout << "code for merge sort" << endl;
    int arr[] = {8, 7, 2, 4, 6, 3, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    cout << "Array before sorting: ";
    print_Array(arr, n);

    merge_sort(arr, 0, n - 1);

    cout << "Array after sorting: ";
    print_Array(arr, n);

    return 0;
}
