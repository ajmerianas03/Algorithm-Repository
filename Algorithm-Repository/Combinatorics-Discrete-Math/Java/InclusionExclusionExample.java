/*
InclusionExclusionExample.java
Language: Java
Category: Combinatorics / Counting
---------------------------------------------------------
✅ Short Description:
Demonstrates the use of the Inclusion–Exclusion Principle to count the number of integers between 1 and N that are divisible by either of two numbers A or B.

🧠 Formula Used:
|A ∪ B| = |A| + |B| - |A ∩ B|

🕒 Time Complexity:
- O(1) — constant time arithmetic

💾 Space Complexity:
- O(1) — no extra space needed beyond variables

📌 Real-life use cases:
- Counting problems with overlapping sets
- Calculating unique occurrences (e.g. promotions, event participation)
- Database filtering (e.g. students in one or more activities)
- Number theory problems involving multiples or divisibility

⚠️ When to use:
- Any time you're counting overlapping categories (e.g. "divisible by 3 or 5")
- Especially effective when working with unions of sets

🧪 Sample Output (n = 100, a = 3, b = 5):
Numbers from 1 to 100 divisible by 3 or 5: 47
---------------------------------------------------------
*/

public class InclusionExclusionExample {

    /**
     * Counts numbers from 1 to n that are divisible by a or b using Inclusion-Exclusion Principle.
     *
     * @param n upper limit (inclusive)
     * @param a first divisor
     * @param b second divisor
     * @return number of integers divisible by a or b
     */
    public static int countDivisibleByAorB(int n, int a, int b) {
        int countA = n / a;               // Count of multiples of a
        int countB = n / b;               // Count of multiples of b
        int countAB = n / lcm(a, b);      // Count of numbers divisible by both a and b (overlap)

        return countA + countB - countAB; // Apply Inclusion-Exclusion to remove double counts
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) using Euclidean algorithm.
     *
     * @param a first number
     * @param b second number
     * @return gcd of a and b
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * Calculates the Least Common Multiple (LCM) using GCD.
     *
     * @param a first number
     * @param b second number
     * @return lcm of a and b
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int n = 100;
        int a = 3;
        int b = 5;

        // 🔢 Display result using inclusion-exclusion
        System.out.println("Numbers from 1 to " + n + " divisible by " + a + " or " + b + ": " +
            countDivisibleByAorB(n, a, b));
    }
}
