// SelectionSort.java
// Language: Java
// ✅ Short Description:
// Selection Sort is a simple comparison-based sorting algorithm.
// It divides the array into a sorted and an unsorted part.
// Repeatedly, it selects the minimum element from the unsorted part 
// and moves it to the end of the sorted part. It is easy to implement
// but not efficient for large datasets.
//
// 🕒 Time Complexity:
// - Worst Case: O(n^2)  (array in reverse order)
// - Average Case: O(n^2)
// - Best Case: O(n^2)   (even if array is already sorted, comparisons are made)
// 💾 Space Complexity: O(1) (in-place sorting)
//
// 🧼 Clean and Optimized Implementation:
// - Uses in-place swapping, no extra arrays required
// - Simple nested loop structure
//
// 🧪 Sample Input/Output:
// Input:  [64, 25, 12, 22, 11]
// Output: [11, 12, 22, 25, 64]
public class SelectionSort {
    public static void selectionSort(int[] arr){
        // her taking the arr size
        int n = arr.length;

        // her actual thing done
        for(int i=0; i<n-1; i++){
            // her we taking the min index
            int min_Index=i;
            for(int j=i+1; j<n; j++){
                // her we checking the min index
                if(arr[j] < arr[min_Index]){
                    min_Index = j;
                }
            }
            // her we are swaping the values
            int temp = arr[min_Index];
            arr[min_Index] = arr[i];
            arr[i] = temp;
        }

    }
    // this is for print
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] array = {64, 25, 12, 22, 11};

        System.out.println(" Array Before Sorted:");
        printArray(array);
        selectionSort(array);
        System.out.println(" Array After Sorted:");
        printArray(array);
    }
    
}
