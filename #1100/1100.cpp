#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

char board[8][8];

void input() {
    for (int i = 0; i < 8; i++) {
        scanf("%s", &board[i][0]);
    }
}
void solve(){
    int cnt = 0;
    for (int row = 0; row < 8; row++) {
        for (int col = row % 2; col < 8; col = col + 2) {
            if (board[row][col] == 'F') {
                cnt++;
            }
        }
    }

    cout << cnt;
}
int main(){
    input();
    solve();
    return 0;
}
