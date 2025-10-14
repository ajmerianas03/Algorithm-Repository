// TernarySearch.java
// Language: Java
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Ternary Search is a divide-and-conquer searching algorithm for sorted arrays.
// It splits the array into three parts instead of two (like Binary Search) 
// and compares the target with two mid points to decide which part to search.
//
// 🧪 How it works:
// 1. Initialize low = 0, high = arr.length - 1
// 2. While low <= high:
//    a. Find two mid points:
//       mid1 = low + (high - low) / 3
//       mid2 = high - (high - low) / 3
//    b. Compare target with arr[mid1] and arr[mid2]
//       - If target == arr[mid1] → return mid1
//       - If target == arr[mid2] → return mid2
//       - If target < arr[mid1] → search left third
//       - If target > arr[mid2] → search right third
//       - Else → search middle third
// 3. If target not found → return -1
//
// 🕒 Time Complexity:
// - Best Case: O(1)
// - Worst Case: O(log3 n)
// - Average Case: O(log3 n)
//
// 💾 Space Complexity:
// - Iterative: O(1)
// - Recursive: O(log3 n) due to recursion stack
//
// 📌 Real-life use cases:
// - Searching a student roll number in a sorted list.
// - Finding max/min in a unimodal function (optimization problems).
//
// ⚠️ When to use:
// - Use only on sorted arrays or unimodal functions.
// - Binary Search is usually simpler for arrays; Ternary Search shines in function optimization.
//
// 🧪 Sample Input/Output:
// Array: [1,3,5,7,9,11,13,15,17]
// Target: 11
// Output: Element found at index: 5
// ---------------------------------------------------------

public class TernarySearch {

    
    public static int ternarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            if (arr[mid1] == target) return mid1;
            if (arr[mid2] == target) return mid2;

            if (target < arr[mid1]) {
                high = mid1 - 1; 
            } else if (target > arr[mid2]) {
                low = mid2 + 1; 
            } else {
                low = mid1 + 1; 
                high = mid2 - 1;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 11;

        int index = ternarySearch(arr, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        target = 4;
        index = ternarySearch(arr, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
