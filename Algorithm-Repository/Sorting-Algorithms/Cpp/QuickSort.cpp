// QuickSort.cpp
// Language: C++
// Category: Sorting Algorithms
// ---------------------------------------------------------
// 🧠 Short Description:
// Quick Sort is an efficient, in-place, Divide and Conquer sorting algorithm.
// It works in three steps:
//  1. Choose a pivot element (here chosen randomly to avoid worst case).
//  2. Partition the array so that:
//     - Elements <= pivot are on the left
//     - Elements > pivot are on the right
//  3. Recursively sort the left and right partitions.
//
// 📈 Why it works well:
// - Sorting is done in-place → no extra array needed.
// - Random pivot avoids worst-case for sorted arrays.
// - On average, it's faster than many other sorting algorithms.
//
// Example:
//   Input : [8, 7, 2, 4, 6, 3, 1, 5]
//   Pivot : 5
//   Partition → [2, 4, 3, 1] 5 [8, 7, 6]
//   Sorted : [1, 2, 3, 4, 5, 6, 7, 8]
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Best Case: O(n log n)
//  - Average Case: O(n log n)
//  - Worst Case: O(n²)   → but very rare due to random pivot
//
// 💾 Space Complexity:
//  - O(log n) (due to recursion stack only)
//
// ❌ Unstable Sort
// ✅ In-place sorting
// ---------------------------------------------------------
#include <iostream>
#include <cstdlib>  // i take this for rand()
#include <ctime>    // i take this for time()
using namespace std;


int partition(int arr[], int low, int high){
    int randomIndex = low + rand() % (high - low + 1);
    swap(arr[randomIndex], arr[high]);

    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return i + 1;
} 

void quick_Sort(int arr[], int low, int high) {
    while (low < high) {
        int pi = partition(arr, low, high);

        if (pi - low < high - pi) {
            quick_Sort(arr, low, pi - 1);
            low = pi + 1;
        } else {
            quick_Sort(arr, pi + 1, high);
            high = pi - 1;
        }
    }
}

void print_Array(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(){
     srand(time(0)); 

    cout << "Quick Sort Algorithm " << endl;
     int arr[] = {8, 7, 2, 4, 6, 3, 1, 5};

     int n = sizeof(arr)/ sizeof(arr[0]);

       cout << "Array before sorting: ";
    print_Array(arr, n);

    quick_Sort(arr, 0, n - 1);

    cout << "Array after sorting: ";
    print_Array(arr, n);

    return 0;

}