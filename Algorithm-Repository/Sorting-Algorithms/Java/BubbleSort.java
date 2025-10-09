// BubbleSort.java
// Language: Java
// ✅ Short Description:
// Bubble Sort is a simple comparison-based sorting algorithm. 
// It repeatedly steps through the list, compares adjacent elements, 
// and swaps them if they are in the wrong order. The pass through the list 
// is repeated until the array is Sorted.
//
// 🕒 Time Complexity: 
// - Worst Case: O(n^2)  (When Array is Sorted in reverse order)
// - Average Case: O(n^2)
// - Best Case: O(n)     (when array is already Sorted)
// 💾 Space Complexity: O(1) (in-place sorting)
//
// 🧼 Clean and Optimized Implementation: 
// - Uses a 'swapped' flag to stop early if the array becomes sorted mid-pass.
// - No extra space is required.
//
// 🧪 Sample Input/Output:
// Input:  [30, 25, 20, 15, 10]
// Output: [10, 15, 20, 25, 30]
public class BubbleSort{
    
    // this method to use for sorting the array when need for contests
    public static void bubbleSort(int[] array){
        int n= array.length;
        boolean swapped;
        int temp;
        for(int i=0; i< n-1; i++){
            swapped = false;
            for(int j=0; j< n-i-1; j++){
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                    
                }
            }
            if(!swapped) break;

        }
    }

    // this method for printing the array
      public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array = {30, 25, 20, 15, 10};

        System.out.print("Original array: ");
        printArray(array);


        bubbleSort(array);
        System.out.print("Sorted array:   ");
        printArray(array);
    }
    
    
}