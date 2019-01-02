#include <iostream>
#include <string>

using namespace std;

long arr[46];

long fib(int n){

    if (arr[n] > 0) {
        return arr[n];
    }
    if (n == 1 || n == 2) {
        return arr[n] = 1;
    } else {
        return arr[n] = fib(n - 1) + fib(n - 2);
    }
}

int main() {
    int n;

    cin >> n;

    cout << fib(n);

    return 0;
}
