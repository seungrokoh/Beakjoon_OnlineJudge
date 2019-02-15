#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int arr[1000];
int a, b, idx = 0;
void input() {
    cin >> a >> b;
}
void solve(){
    for (int i = 1; idx < 1000; i++) {
        for (int j = 0; j < i; j++) {
            arr[idx++] = i;
            if (idx == 1000) {
                break;
            }
        }
    }

    int sum = 0;
    for (int i = a - 1; i <= b - 1; i++) {
        sum += arr[i];
    }

    cout << sum;
}
int main(){
    input();
    solve();
    return 0;
}
