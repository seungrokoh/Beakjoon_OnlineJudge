#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;

int max(int a, int b){
    return a > b ? a : b;
}
int min(int a, int b){
    return a < b ? a : b;
}
void solve(){
    int n, num, maxResult = -1000001, minResult = 1000001;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> num;
        maxResult = max(num, maxResult);
        minResult = min(num, minResult);
    }
    cout << minResult << " " << maxResult;
}

int main(){
   solve();
}
