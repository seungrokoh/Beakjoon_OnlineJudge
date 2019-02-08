#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>

using namespace std;

int arr[51];
int n;

bool cmp(int a, int b){
    return a < b;
}
void input(){
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
}
void solve(){
    sort(arr, arr + n, cmp);
    cout << arr[0] * arr[n - 1];
}

int main(){

    input();
    solve();

    return 0;
}
