// PascalsTriangle.java
// Language: Java
// Category: Combinatorics / Counting
// ---------------------------------------------------------
// ✅ Short Description:
// Generates Pascal's Triangle up to a fixed number of rows in two ways:
// 1. Normal method using factorials to compute combinations
// 2. Optimized method using iterative addition (no factorials)
//
// 🕒 Time Complexity:
// - Normal method: O(n^2 * n) → factorials for each element
// - Optimized method: O(n^2) → simple addition of previous row
//
// 💾 Space Complexity:
// - Normal method: O(1) for calculation
// - Optimized method: O(n^2) to store triangle
//
// 📌 Real-life use cases:
// - Binomial expansions
// - Counting combinations
// - Probability problems
//
// ⚠️ When to use:
// - Normal method: when rows are small (factorials manageable)
// - Optimized method: for large rows, avoids overflow and faster
//
// 🧪 Sample Output (first 5 rows):
// Normal Method:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
//
// Optimized Method:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// ---------------------------------------------------------

public class PascalsTriangle {

    public static Long factorial(int n){
        Long fact = 1L;
        for(int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    public static Long combination(int n, int r){
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void pascalNormal(int rows){
        System.out.println("-------- Pascal's Triangle (Normal Method) --------");
        for(int i=0; i <rows; i++){
            for(int j=0; j <=i; j++){
                System.out.println(combination(i, j));
            }
        }
    }

    public static void pascalOptimized(int rows){
        System.out.println("-------- Pascal's Triangle optimized method--------");
        Long[][] trinagle = new Long[rows][];
        for(int i =0; i<rows;i++){
            trinagle[i]= new Long[i+1];
            trinagle[i][0] = trinagle[i][i] = 1L;
            for(int j=1;j<i;j++){
                trinagle[i][j]= trinagle[i-1][j-1] + trinagle[i-1][j]; 
            }
            for(Long x : trinagle[i]){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }




    
    public static void main(String[] args){
        int row = 10;

        pascalNormal(row);
        System.out.println();
        pascalOptimized(row);
        
    }
}
