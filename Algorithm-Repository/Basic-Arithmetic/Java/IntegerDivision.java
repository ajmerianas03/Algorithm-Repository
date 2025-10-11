// IntegerDivision.java
// Language: Java
// Purpose: perform integer division, floor division, and ceiling division
// Time Complexity: O(1)
// Space Complexity: O(1)
// Use Case: Useful in array partitioning, paging, and problem-solving in competitive programming

import java.util.Scanner;

public class IntegerDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter dividend and divisor: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(b == 0) {
            System.out.println("division by zero is not allowed!");
            sc.close();
            return;
        }

        int iDiv = a / b;                        
        int fDiv = (a >= 0) ? a / b : (a - b + 1) / b;
        int cDiv = (a + b - 1) / b;            
        
        System.out.println("Integer division : " + iDiv);
        System.out.println("Floor division: " + fDiv);
        System.out.println("Ceiling division: " + cDiv);


        sc.close();
    }
}
