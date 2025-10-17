// Combinations.java
// Language: java
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Calculates number of ways to choose r items from n distinct items
// where order does NOT matter (combinations), using factorial formula.
//
// 🕒 Time Complexity: O(n) → factorial calculations
// 💾 Space Complexity: O(1)
// ---------------------------------------------------------

public class Combinations {
    public static long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static long combination(int n, int r){
        if(r > n) return 0;
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    public static void main(String[] args) {
        int n = 5; 
        int r = 3; 
        System.out.println("C(" + n + ", " + r + ") = " + combination(n, r));
    }    
}
