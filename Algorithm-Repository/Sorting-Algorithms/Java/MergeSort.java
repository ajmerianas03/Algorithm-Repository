// MergeSort.java
// Language: Java
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

public class MergeSort{

    // here we are sortting and combine the array
    public static void merge(int[] arr, int l, int mid, int r){
        int len1 = mid - l + 1;
        int len2= r-mid;
        int[] left = new int[len1];
        int[] right = new int[len2];

        for(int i=0; i<len1; i++){
            left[i] = arr[l+i];
        }

        for(int j =0; j<len2; j++){
            right[j] = arr[mid+1+j];

        }
        int i=0, j=0;
        int k = l;

        while(i < len1 && j < len2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }

            k++;
        }

       
         while(i < len1){
            arr[k] = left[i];
            i++;
            k++;
        }

         while(j < len2){
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    // Here We Recursively splits The array
    public static void merge_sort(int[] arr, int l, int r){
        if(l < r){
            int mid = (l+r)/2;
            merge_sort(arr, l, mid);
            merge_sort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    //here we printing the array
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8,7,2,4,6,3,1,5};

        System.out.println("Array Before Sorting:");
        printArray(arr);

        merge_sort(arr, 0, arr.length - 1);

        System.out.println("Array After Sorting:");
        printArray(arr);

    }

}