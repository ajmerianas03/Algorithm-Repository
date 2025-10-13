// LinearSearch.java
// Language: Java
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Linear Search is the simplest searching algorithm that checks each element 
// of the array sequentially until the desired element (target) is found or 
// the end of the array is reached.
//
// 📌 How it works:
//  1. Start from the first element.
//  2. Compare each element with the target.
//  3. If a match is found → return the index.
//  4. If no match is found after traversing the array → element not found.
//
// 🧪 Example:
//  Input Array:  [3, 5, 2, 4, 9, 6]
//  Target:       4
//  Output:       Element found at index: 3
//
// 🕒 Time Complexity:
//  - Best Case:    O(1)    → target found at the beginning
//  - Worst Case:   O(n)    → target not found or at the end
//  - Average Case: O(n/2)  → roughly half the elements checked
//
// 💾 Space Complexity:
//  - O(1) → Only uses constant extra space
//
// 📌 Real-life use cases:
//  - When the dataset is small or unsorted
//  - Searching in unsorted lists like contact names, inventory items, etc.
//  - Useful for linked lists or streams where indexing isn’t available
// ---------------------------------------------------------

public class LinearSearch {
    public static void linearSearch(int[] arr, int target) {
        if (arr.length == 0) {

            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found");

    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 4, 9, 6 };
        int target = 4;
        linearSearch(arr, target);

    }
}
