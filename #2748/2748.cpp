#include <iostream>

using namespace std;

long long dp[91];

long long fibo(int n){
    if(dp[n]) return dp[n];

    if (n == 1 || n == 2) return dp[n] = 1;

    return dp[n] = fibo(n-1) + fibo(n-2);
}
int main(){
    int n;

    cin >> n;

    cout << fibo(n);
}
