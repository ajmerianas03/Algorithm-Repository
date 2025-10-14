// FibonacciSearch.java
// Language: Java
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Fibonacci Search is a searching algorithm for sorted arrays.
// It uses Fibonacci numbers to determine the position to compare,
// making it useful when sequential access is faster than random access.
//
// 🧮 How it works:
// 1. Generate the smallest Fibonacci number greater than or equal to n.
// 2. Use Fibonacci numbers (fibM, fibMm1, fibMm2) to determine comparison positions.
// 3. Compare the target with the element at index (offset + fibMm2):
//    - If target > arr[i] → eliminate the front portion and shift Fibonacci numbers down.
//    - If target < arr[i] → eliminate the portion after i and shift Fibonacci numbers down.
//    - If arr[i] == target → return i (element found).
// 4. After the loop, check if the last element equals the target.
// 5. If not found, return -1.
//
// 🕒 Time Complexity:
// - Best Case: O(1)
// - Average/Worst Case: O(log n)
//
// 💾 Space Complexity:
// - O(1) → constant extra space
//
// 📌 Real-life use cases:
// - Searching in sorted datasets where random access is expensive.
// - Suitable for data stored on sequential media (like magnetic tapes).
//
// ⚠️ When to use:
// - Works only on sorted arrays.
// - Prefer Binary Search for general use in RAM.
//
// 🧪 Sample Input/Output:
// Array:  [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
// Target: 85
// Output: Element found at index: 8
//
// Array:  [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
// Target: 30
// Output: Element not found
// ---------------------------------------------------------

public class FibonacciSearch {

    public static int fibonacciSearch(int[] arr, int n, int target) {
        int fibMm2 = 0;  
        int fibMm1 = 1;  
        int fibM = fibMm2 + fibMm1; 
        
        
        while (fibM < n) {
            fibMm2 = fibMm1;
            fibMm1 = fibM;
            fibM = fibMm2 + fibMm1;
        }

        
        int offset = -1;

        
        while (fibM > 1) {
            
            int i = Math.min(offset + fibMm2, n - 1);

            
            if (arr[i] < target) {
                fibM = fibMm1;
                fibMm1 = fibMm2;
                fibMm2 = fibM - fibMm1;
                offset = i;
            }
            
            else if (arr[i] > target) {
                fibM = fibMm2;
                fibMm1 = fibMm1 - fibMm2;
                fibMm2 = fibM - fibMm1;
            }
            
            else {
                return i;
            }
        }

        
        if (fibMm1 == 1 && offset + 1 < n && arr[offset + 1] == target)
            return offset + 1;

            
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        int n = arr.length;
        int[] targets = {85, 10, 100, 30};

        System.out.println("=== Fibonacci Search ===");
        for (int t : targets) {
            int index = fibonacciSearch(arr, n, t);
            if (index != -1)
                System.out.println("Element " + t + " found at index: " + index);
            else
                System.out.println("Element " + t + " not found in the array.");
        }
    }
}
