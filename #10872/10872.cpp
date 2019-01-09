#include <iostream>

using namespace std;

int memo[13];

int factorial(int n);

int main(){
    int n;

    cin >> n;

    cout << factorial(n);


}

int factorial(int n){
    if (memo[n] > 0) {
        return memo[n];
    }

    if (n == 0 || n == 1) {
        return memo[n] = 1;
    }

    return memo[n] = n * factorial(n - 1);
}
