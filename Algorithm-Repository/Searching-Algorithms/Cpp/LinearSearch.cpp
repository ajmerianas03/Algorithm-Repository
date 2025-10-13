// LinearSearch.cpp
// Language: CPP
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

#include <iostream>
using namespace std;
void linearSearch(int arr[], int n, int target){
    if (n == 0)
    {
        cout << "Array is empty" << endl;
        return;
    }
    
    for(int i=0; i<n; i++){
        if(arr[i] == target){
            cout << "Element found at index: " << i << endl;
            return;
        }
    }
    cout << "Element not found in the array" << endl;
}

int main(){
    int arr[]={ 3, 5, 2, 4, 9, 6 };
    int n=sizeof(arr)/sizeof(arr[0]);
    int target=4;
    linearSearch(arr, n, target);

    return 0;
}