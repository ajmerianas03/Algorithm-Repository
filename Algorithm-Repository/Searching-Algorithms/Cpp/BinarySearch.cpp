// BinarySearch.cpp
// Language: CPP
// Category: Searching Algorithms
// ---------------------------------------------------------
// ✅ Short Description:
// Binary Search is an efficient searching algorithm for sorted arrays. 
// It works by repeatedly dividing the search interval in half. 
// Start with the whole array, check the middle element:
// - If it equals the target → return the index.
// - If it is less than the target → search the right half.
// - If it is greater than the target → search the left half.
// Repeat until the target is found or the interval is empty.
//
// 🧪 How it works:
// 1. Initialize two pointers: left = 0, right = arr.length - 1
// 2. While left <= right:
//    a. Find mid = left + (right - left) / 2 (overflow-safe)
//    b. Compare arr[mid] with target
//    c. If equal → return mid
//    d. If arr[mid] < target → left = mid + 1
//    e. If arr[mid] > target → right = mid - 1
// 3. If target not found → return -1
//
// 🕒 Time Complexity:
// - Best Case: O(1) → target found at middle
// - Worst Case: O(log n) → repeatedly dividing array
// - Average Case: O(log n)
//
// 💾 Space Complexity:
// - O(1) → only uses constant extra space
//
// 📌 Real-life use cases:
// 1. Phonebook Search: Searching a contact's name in a sorted phonebook.
//    Example: Searching for "Anas" in a phonebook sorted alphabetically.
// 2. Inventory Management: Looking up a product ID in a sorted inventory list.
//    Example: A warehouse system checks if product ID 10234 exists in the sorted product catalog.
// 3. Databases and Search Engines: Quick retrieval from sorted index lists.
//
// ⚠️ When to use:
// - Only use on sorted arrays or lists. For unsorted data, use linear search or sort first.
//
// 🧪 Sample Input/Output:
// Input:  arr = [1,2,3,4,5,6,7,8,9], target = 4
// Output: Element found at index: 3
//
// Real-life example:
// Input: Phonebook = ["binod", "karan", "mahesh", "pintu","rahul" ]
// Target: "mahesh"
// Output: Element found at index: 2
// ---------------------------------------------------------

#include<iostream>
using namespace std;

int binarySearch(int arr[], int len,int target){
    int lefty = 0;
    int righty = len - 1;

    while(lefty <= righty){
        int mid = lefty + (righty - lefty) / 2; 

        if(arr[mid] == target){
            return mid; 
        }
        else if(arr[mid] < target){
            lefty = mid + 1; 
        }
        else{
            righty = mid - 1; 
        }
    }
    return -1;
}

int main(){
      int arr[] = { 1,2,3,4,5,6,7,8,9 };
        int target = 4;
        int len = sizeof(arr)/sizeof(arr[0]);
        int ans = binarySearch(arr, len,target); 
        if(ans == -1){
            cout<< "Element not found"<<endl;
        } else {
            cout<< "Element found at index: " << ans<<endl;
        }

}