#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int arr[5];

void input(){
    for (int i = 0; i < 5; i++) {
        cin >> arr[i];
    }
}
void solve(){
    int sum = 0;
    for (int i = 0; i < 5; i++) {
        sum += arr[i] * arr[i];
    }
    cout << sum % 10;
}
int main(){
    input();
    solve();
    return 0;
}
