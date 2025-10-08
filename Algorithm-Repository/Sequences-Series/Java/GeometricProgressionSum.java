// GeometricProgressionSum.java
// Language: Java
// Purpose: calculate the sum of the first n terms of a geometric progression (GP)
// Time Complexity: O(1)
// Space Complexity: O(1)

public class GeometricProgressionSum {

    // method to calculate sum of first n terms of GP
    public static int geometricProgressionSum(int a, int r, int n){
        // a: first term, r: common ratio, n: number of terms

        if (r == 1) {
            return a * n; // all terms are The same if ratio = 1
        }

        return a * (1 - (int)Math.pow(r, n)) / (1 - r); // GP sum formula
    }

    public static void main(String[] args) {
        int a = 2; // first term
        int r = 3; // common ratio
        int n = 5; // number of terms

        int sum = geometricProgressionSum(a, r, n); 
        System.out.println("Sum of the first " + n + " terms of the geometric progression: " + sum);
    }
}
