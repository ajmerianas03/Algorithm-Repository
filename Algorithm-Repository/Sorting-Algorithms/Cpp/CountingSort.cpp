// CountingSort.cpp
// Language: cpp
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


#include <iostream>
using namespace std;


void countingSort(int arr[], int n){
    int maxi= arr[0];
    for(int i=1;i<n;i++){
        maxi=max(maxi,arr[i]);
    }

    int count[maxi+1]={0};

    for(int i=0; i <n; i++){
        count[arr[i]]++;

    }

    for(int i =1; i < maxi+1; i++){
        count[i] += count[i-1];
    }
    int output[n];

    for(int i = n-1; i>=0; i--){
        output[count[arr[i]]-1] = arr[i];
        count[arr[i]]--;
    }

    for(int i =0; i <n; i++){
        arr[i] = output[i];
    }
}


void  print_Array(int arr[], int n){
    for(int i=0;i<n;i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}


int main(){
    int arr[]={3, 5,6,1,3,4,7,2};

    int n=sizeof(arr)/sizeof(arr[0]);

    cout << "Array before counting Sort\n";

    print_Array(arr,n);

    countingSort(arr,n);


     cout << "Array After counting Sort\n";

    print_Array(arr,n);
}