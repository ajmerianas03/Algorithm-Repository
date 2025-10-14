// InterpolationSearch.java
// Language: Java
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Interpolation Search is an efficient searching algorithm for sorted arrays
// with values distributed uniformly. Unlike Binary Search (which always checks
// the middle), it estimates the position of the target based on its value.
//
// 🧮 How it works:
// 1. Let low = 0 and high = n - 1
// 2. While target is between arr[low] and arr[high]:
//    - Estimate position using:
//        pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low])
//    - If arr[pos] == target → return pos
//    - Else if arr[pos] < target → move low to pos + 1
//    - Else → move high to pos - 1
// 3. If target not found, return -1
//
// 🕒 Time Complexity:
// - Best Case: O(1)              → element found on first estimate
// - Average Case: O(log log n)   → for uniform distribution
// - Worst Case: O(n)            → for skewed distribution
//
// 💾 Space Complexity:
// - O(1) → constant extra space
//
// 📌 Real-life use cases:
// - Searching in large, sorted datasets where values are evenly distributed.
// - Ideal for searching records like sorted numeric IDs, timestamps, or prices.
//
// ⚠️ When to use:
// - Only works efficiently on sorted and uniformly distributed data.
// - If data is skewed, prefer Binary Search for consistent performance.
//
// 🧪 Sample Input/Output:
// Array:  [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
// Target: 80
// Output: Element found at index: 7
//
// Array:  [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
// Target: 55
// Output: Element not found
// ---------------------------------------------------------


public class InterpolationSearch {

    public static int interpolationSearch(int arr[], int n, int target){
        int low =0, high = n-1;
        while(low <= high && target >= arr[low] && target <= arr[high]){
            int posi = low +((target - arr[low])* (high-low))/(arr[high]-arr[low]);
            if(arr[posi] == target){
                return posi;
            }
            else if(arr[posi] < target){
                low = posi +1;
            }else{
                high = posi -1;
            }

        }
        return -1;

    }
    public static void main(String[] args) {
        int[] arr= {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int n = arr.length;

         int targets[] = {80, 10, 55, 100, 15};

         for(int t: targets){
            int index = interpolationSearch(arr, n, t);
            if(index != -1){
                System.out.println("Element " + t + " found at index: " + index);
            }else{
                System.out.println("Element " + t + " not found in the array.");
            }
         }

    }
}
