// SelectionSort.cpp
// Language: C++
// ✅ Short Description:
// Selection Sort is a simple comparison-based sorting algorithm.
// It divides the array into a sorted and an unsorted part.
// Repeatedly, it selects the minimum element from the unsorted part 
// and moves it to the end of the sorted part. Easy to implement,
// but inefficient for large datasets.
//
// 🕒 Time Complexity:
// - Worst Case: O(n^2)  (array in reverse order)
// - Average Case: O(n^2)
// - Best Case: O(n^2)   (even if array is already sorted)
// 💾 Space Complexity: O(1) (in-place sorting)
//
// 🧼 Clean and Optimized Implementation:
// - Uses in-place swapping, no extra arrays required
// - Simple nested loop structure
//
// 🧪 Sample Input/Output:
// Input:  [64, 25, 12, 22, 11]
// Output: [11, 12, 22, 25, 64]

#include <iostream>
using namespace std;

// this is actual method which sort the array
void selectionSort(int arr[], int size){
    for(int i=0; i < size-1; i++){
        int min_index = i;
        for(int j=i+1; j < size; j++){
            if(arr[j] < arr[min_index]){
                min_index = j;
            }
        }
        swap(arr[i], arr[min_index]);
    }
}

void printArray(int arr[], int size){
    for(int i=0; i < size; i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}
int main(){
    int arr[] = {64, 25, 12, 22, 11};
    int size = sizeof(arr)/sizeof(arr[0]);

    cout << "Array Before Sorted: ";
    printArray(arr, size);

    selectionSort(arr, size);

    cout << "Array After Sorted: ";
    printArray(arr, size);
    return 0;
}