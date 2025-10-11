// HeapSort.cpp
// Language: C++
// Category: Sorting Algorithms
// ---------------------------------------------------------
// 🧠 Short Description:
// Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure.
// Approach:
// 1. Build a Max Heap from the input array.
// 2. Swap the root (largest element) with the last element in the heap.
// 3. Reduce the heap size by 1 and heapify the root to maintain the max heap.
// 4. Repeat until the heap is of size 1.
//
// Why it works well:
// - Heap allows efficient extraction of the largest element.
// - Sorting is done in-place, so it requires no extra space for sorting.
// - Time complexity is consistently O(n log n), unlike quicksort which can degrade.
//
// Example:
//  Input:  [12, 11, 13, 5, 6, 7]
//  Max Heap: [13, 12, 7, 5, 6, 11]
//  Step by step swaps & heapify
//  Output: [5, 6, 7, 11, 12, 13]
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Best Case: O(n log n)
//  - Average Case: O(n log n)
//  - Worst Case: O(n log n)
//
// 💾 Space Complexity:
//  - O(1) → In-place sorting, only a few variables are used
//
// ✅ Not a stable sort (does not preserve order of equal elements)
//
// 📌 Real-life use case:
//  - Priority scheduling in operating systems
//  - Task management in priority queues
//  - Efficiently finding top-k largest elements in large datasets
// ---------------------------------------------------------

#include <iostream>
using namespace std;

void heapify(int arr[], int n, int i) {
    int largest = i;       
    int left = 2 * i + 1;  
    int right = 2 * i + 2; 
    

    if (left < n && arr[left] > arr[largest])
        largest = left;

    if (right < n && arr[right] > arr[largest])
        largest = right;

        
    if (largest != i) {
        swap(arr[i], arr[largest]);

        
        heapify(arr, n, largest);
    }
}


void heapSort(int arr[], int n) {
    
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

        
    for (int i = n - 1; i > 0; i--) {
        swap(arr[0], arr[i]); 
        
        heapify(arr, i, 0); 
    }
}


void print_Array(int arr[], int n) {
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}


int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = sizeof(arr)/sizeof(arr[0]);

    cout << "Array Before Sorting:" << endl;
    print_Array(arr, n);

    heapSort(arr, n);

    cout << "Array After Sorting:" << endl;
    print_Array(arr, n);

    return 0;
}
