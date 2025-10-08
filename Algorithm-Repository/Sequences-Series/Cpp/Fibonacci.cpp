
// Language: C++
// Purpose: Calculate nth Fibonacci number using Dynamic Programming (iterative)
// Time Complexity: O(n)
// Space Complexity: O(n)
// this contain only Dynamic Programming Iterative approach i am going to add other option ass well in feature
#include <iostream>
#include <vector>
using namespace std;

int fibonacci(int n) {
    if (n <= 1) return n;

    vector<int> fib(n + 1, 0);
    fib[1] = 1;

    for (int i = 2; i <= n; ++i) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
    return fib[n];
}
// latter add for entire array return
int main() {
    int n = 10;
    cout << "Fibonacci(" << n << ") = " << fibonacci(n) << endl;
    return 0;
}
