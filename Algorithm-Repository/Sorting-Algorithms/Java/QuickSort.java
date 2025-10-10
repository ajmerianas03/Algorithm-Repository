// QuickSort.java
// Language: Java
// Category: Sorting Algorithms
// ---------------------------------------------------------
// 🧠 Short Description:
// Quick Sort is an efficient, in-place, Divide and Conquer sorting algorithm.
// It works in three steps:
//   1. Choose a pivot element (here chosen as the last element).
//   2. Partition the array so that:
//        - Elements <= pivot are on the left
//        - Elements > pivot are on the right
//   3. Recursively sort the left and right partitions.
//
// 📈 Why it works well:
// - Sorting is done in-place → no extra array needed.
// - Fast on average O(n log n).
//
// Example:
//   Input  : [8, 7, 2, 4, 6, 3, 1, 5]
//   Pivot  : 5
//   Partition → [2, 4, 3, 1] 5 [8, 7, 6]
//   Sorted : [1, 2, 3, 4, 5, 6, 7, 8]
//
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Best Case: O(n log n)
//  - Average Case: O(n log n)
//  - Worst Case: O(n²)   → rare with random pivot
//
// 💾 Space Complexity:
//  - O(log n) (recursion stack)
//
// ❌ Unstable Sort
// ✅ In-place sorting
// ---------------------------------------------------------

import java.util.Random;

public class QuickSort {

    private static final Random RAND = new Random();

    /** 
     * i used helper method 
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Partition step:
     * - Select pivot (randomly for better performance)
     * - Move elements <= pivot to the left
     * - Move elements > pivot to the right
     */
    public static int partition(int[] arr, int low, int high) {
        // here we choose Random Pivot to Avoid worst case

        int randomIndex = low + RAND.nextInt(high - low + 1);
        swap(arr, randomIndex, high);

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
    while (low < high) {
        int pi = partition(arr, low, high);

        if (pi - low < high - pi) {
            quickSort(arr, low, pi - 1);
            low = pi + 1;
        } else {
            quickSort(arr, pi + 1, high);
            high = pi - 1;
        }
    }
}

 
    

    public static void print_Array(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 8, 7, 2, 4, 6, 3, 1, 5 };
        int n = arr.length;

        System.out.println("Array Before Sorting: ");
        print_Array(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Array After Sorting: ");
        print_Array(arr);
    }
}
