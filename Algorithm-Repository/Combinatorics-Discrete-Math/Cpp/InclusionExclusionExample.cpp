/*
InclusionExclusionExample.cpp
Language: C++
Category: Combinatorics / Counting
---------------------------------------------------------
✅ Short Description:
Calculates the number of integers from 1 to N that are divisible by either of two numbers A or B
using the Inclusion–Exclusion Principle.

🧠 Formula Used:
|A ∪ B| = |A| + |B| - |A ∩ B|

🕒 Time Complexity:
- O(1) — Constant time for arithmetic operations

💾 Space Complexity:
- O(1) — Uses only scalar variables

📌 Real-life use cases:
- Count numbers divisible by multiple values (e.g., 3 or 5)
- Avoid double-counting in overlapping sets
- Useful in scheduling, offers, inventory filtering, etc.

⚠️ When to use:
- When you have multiple overlapping sets and want to count unique elements

🧪 Sample Output for n = 100:
Numbers from 1 to 100 divisible by 3 or 5: 47
---------------------------------------------------------
*/

#include <iostream>
using namespace std;

// ⚙️ Compute Greatest Common Divisor (GCD) using Euclidean algorithm
int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);
}

// ⚙️ Compute Least Common Multiple (LCM) using GCD
int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}

// 🧠 Inclusion-Exclusion: Count numbers divisible by a or b from 1 to n
int countDivisibleByAorB(int n, int a, int b) {
    int countA = n / a;           // Multiples of a
    int countB = n / b;           // Multiples of b
    int countAB = n / lcm(a, b);  // Multiples of both a and b (overlap)

    return countA + countB - countAB;  // Inclusion–Exclusion correction
}

int main() {
    int n = 100;
    int a = 3;
    int b = 5;

    // 🔢 output result
    cout << "Numbers from 1 to " << n << " divisible by "
         << a << " or " << b << ": "
         << countDivisibleByAorB(n, a, b) << endl;

    return 0;
}
