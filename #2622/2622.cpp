#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;

int solve(int n){
    int cnt = 0;
    for (int a = 1; a <= n / 3; a++) {
        for (int b = (n-a)/2; b >= a; b--) {
            if (b + a > n - a - b) {
                cnt++;
            } else {
                break;
            }
        }
    }
    return cnt;
}
int main(){
   int n;
   cin >> n;
   cout << solve(n);
}
