#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int n;
int direction[6];
int len[6];

void input(){
    cin >> n;
    for (int i = 0; i < 6; i++) {
        cin >> direction[i] >> len[i];
    }
}
void solve(){
    int max = 0;
    int index;

    for (int i = 0; i < 6; i++) {
        if (max <= len[i] * len[(i + 1) % 6]) {
            max = len[i] * len[(i + 1) % 6];
            index = i;
        }
    }

    int result = max - len[(index + 3) % 6] * len[(index + 4) % 6];

    cout << result * n;

}
int main(){
    input();
    solve();
    return 0;
}
