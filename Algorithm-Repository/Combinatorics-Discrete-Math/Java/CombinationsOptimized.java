// CombinationsOptimized.java
// Language: Java
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Calculates number of combinations C(n,r) efficiently without computing full factorials.
//
// 🕒 Time Complexity: O(r) → only r multiplications/divisions
// 💾 Space Complexity: O(1)
// ---------------------------------------------------------

public class CombinationsOptimized {
    public static long combination(int n, int r){
        if(r > n) return 0;
        if(r > n-r) r = n-r;
        long ans = 1;
        for(int i = 0; i < r; i++){
            ans *= (n - i);     
            ans /= (i + 1);      
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 5; 
        int r = 3; 
        System.out.println("C(" + n + ", " + r + ") = " + combination(n, r));
    }
}
