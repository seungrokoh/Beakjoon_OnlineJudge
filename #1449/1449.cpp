#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>

using namespace std;

int leak, l, cnt = 0;
bool isLeak[1001];

void input(){
    cin >> leak >> l;

    for (int i = 0; i < leak; i++) {
        int num;
        cin >> num;
        isLeak[num] = true;
    }
}

void solve(){
    for (int i = 0; i < 1001; i++) {
        if (isLeak[i]) {
            cnt++;
            i = i + l - 1;
        }
    }

    cout << cnt;
}
int main(){
    input();
    solve();

    return 0;
}
