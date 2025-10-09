// BubbleSort.cpp
// Language: C++
// Topic: Sorting Algorithms
// Purpose: Sort an array of integers in ascending order using Bubble Sort.
// Time Complexity: O(n^2) in worst & average case, O(n) in best case (already sorted)
// Space Complexity: O(1) — In-place sorting (no extra memory required)


#include <iostream>
using namespace std;

/**
 * 🧠 Topic Explanation — Bubble Sort
 * ------------------------------------
 * Bubble Sort is a simple comparison-based sorting algorithm.
 * The algorithm repeatedly steps through the array, compares adjacent elements,
 * and swaps them if they are in the wrong order (e.g., arr[j] > arr[j+1] for ascending order).
 * 
 * This process continues until no more swaps are needed, meaning the array is sorted.
 * After each pass:
 *  - The largest unsorted element “bubbles up” to its correct position at the end.
 *  - The next pass can ignore the last sorted elements.
 * 
 * ✅ Stable Algorithm — does not change the relative order of equal elements.
 * ✅ In-place Algorithm — requires no extra space beyond the input array.
 * ⚠️ Not efficient for large datasets — better algorithms like Merge Sort or Quick Sort are preferred.
 *
 * 📊 Time Complexity:
 * -------------------
 * - Best Case (Already Sorted):       O(n)       → thanks to the early exit check.
 * - Average Case (Random Order):      O(n^2)
 * - Worst Case (Reverse Order):       O(n^2)
 *
 * 🧮 Space Complexity:
 * -------------------
 * - O(1) — only a few extra variables, sorting is done in-place.
 *
 * 📌 Use Cases:
 * ------------
 * - Teaching/learning basic sorting concepts.
 * - Sorting very small arrays.
 * - Useful when array is nearly sorted (early termination gives O(n) time).
 */
void bubbleSort(int arr[], int n)
{

    bool swap;
    for (int i = 0; i < n - 1; i++)
    {
        swap = false;
        for (int j = 0; j < n - i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap = true;
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        if (!swap) break;
    }
}

/**
 * Utility function to print an array
 */
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}

/**
 * 🧪 Sample Input/Output:
 * -----------------------
 * Input:
 *  Array before sorting: 30 25 20 15 10
 * 
 * Output:
 *  Array after sorting:  10 15 20 25 30
 */

int main()
{
    int arr[] = {30, 25, 20, 15, 10};
    int n = sizeof(arr) / sizeof(arr[0]);
    
    cout << "Array before sorting: ";
    printArray(arr, n);

    bubbleSort(arr, n);

    cout << "Array after sorting: ";
    printArray(arr, n);

    return 0;
}