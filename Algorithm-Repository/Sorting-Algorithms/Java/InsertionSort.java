// InsertionSort.java
// Language: Java
// ✅ Short Description:
// Insertion Sort is a simple, stable, comparison-based sorting algorithm.
// It builds the sorted portion of the array one element at a time.
// For each element, it places it in its correct position within the sorted part
// by shifting larger elements to the right. Best for small or nearly sorted arrays.
//
// 🕒 Time Complexity:
// - Worst Case: O(n^2)  (array in reverse order)
// - Average Case: O(n^2)
// - Best Case: O(n)      (array already sorted, only one comparison per element)
// 💾 Space Complexity: O(1) (in-place sorting)
//
// 🧼 Clean and Optimized Implementation:
// - In-place shifting, no extra arrays required
// - Simple nested loop structure
// - Reduces unnecessary swaps by moving elements instead of swapping repeatedly
//
// 🧪 Sample Input/Output:
// Input:  [64, 25, 12, 22, 11]
// Output: [11, 12, 22, 25, 64]

public class InsertionSort {
    // this is actual insertion sort
    public static void insertionSort(int[] arr){
        
        for(int i=1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }

    // for printing the array
   public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Array Before Sorted:");
         printArray(arr);
        insertionSort(arr);
        System.out.println("Array After Sorted:");
         printArray(arr);
    }
    
}
