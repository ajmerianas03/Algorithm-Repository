// CountingSort.java
// Language: Java
// Category: Sorting Algorithms
// ---------------------------------------------------------
// 🧠 Short Description:
// Counting Sort is a non-comparison-based sorting algorithm that works by counting 
// the number of occurrences of each unique element. It then uses this count to 
// place elements directly into their correct sorted position.
//
// 📌 How it works:
// 1. Find the maximum value in the array.
// 2. Initialize a count array of size (max + 1).
// 3. Store the frequency of each element in the count array.
// 4. Transform count array to store cumulative sums.
// 5. Place each element from the original array into its sorted position using the count array.
// 6. Copy the sorted elements back to the original array.
//
// ✨ Why it works well:
// - It’s very efficient when the range of input numbers is not significantly larger 
//   than the number of elements to sort.
// - It doesn’t use comparisons, making it faster than comparison-based sorts for 
//   suitable datasets.
//
// 🧪 Example:
//  Input:  [3, 5, 6, 1, 3, 4, 7, 2]
//  Count:  [0,1,1,2,1,1,1,1]   (Frequency of elements)
//  Prefix: [0,1,2,4,5,6,7,8]   (Cumulative count)
//  Output: [1,2,3,3,4,5,6,7]
// ---------------------------------------------------------
// 🕒 Time Complexity:
//  - Best Case:    O(n + k)
//  - Average Case: O(n + k)
//  - Worst Case:   O(n + k)
//  where n = number of elements, k = range of input values
//
// 💾 Space Complexity:
//  - O(n + k) → Uses additional arrays for count and output
//
// ✅ Stable sort (preserves the relative order of equal elements)
//
// 📌 Real-life use cases:
//  - Sorting data with small integer ranges efficiently
//  - Digit sorting step in Radix Sort
//  - Counting occurrences in statistical analysis or frequency tables
// ---------------------------------------------------------

public class CountingSort{
    public static void countingSort(int[] arr){
        int arrLen = arr.length;
        int max = arr[0];
        for(int i=1; i<arrLen; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        for(int i=0; i<arrLen; i++){
            count[arr[i]]++;
        }
        for(int i=1; i<=max; i++){
            count[i] += count[i-1];
        }
        int[] output = new int[arrLen];
        for(int i=arrLen-1; i>=0; i--){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for(int i=0; i<arrLen; i++){
            arr[i] = output[i];
        }
    }

    public static void print_Array(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        } 
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {3, 5,6,1,3,4,7,2};

        System.out.println("Array before Counting Sort:");

        print_Array(arr);

        countingSort(arr);

         System.out.println("Array After Counting Sort:");
        print_Array(arr);
    }
}