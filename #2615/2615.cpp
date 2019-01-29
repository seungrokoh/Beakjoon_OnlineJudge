#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;

int map[21][21];

void input(){
    for (int i = 1; i <= 19; i++) {
        for (int j = 1; j <= 19; j++) {
            cin >> map[i][j];
        }
    }
}

// 오른쪽 방향 검사
bool case1(int x, int y){
    int cnt = 0;
    while(map[x][y] == map[x][y+1]) {
        cnt++;
        y++;
    }
    return cnt == 4;
}

// 오른 아래 대각 방향 검사
bool case2(int x, int y){
    int cnt = 0;
    while (map[x][y] == map[x + 1][y + 1]) {
        cnt++;
        x++;
        y++;
    }
    return cnt == 4;
}

// 아래 방향 검사
bool case3(int x, int y){
    int cnt = 0;
    while (map[x][y] == map[x + 1][y]) {
        cnt++;
        x++;
    }
    return cnt == 4;
}

// 오른 위 대각 방향 검사
bool case4(int x, int y){
    int cnt = 0;
    while (map[x][y] == map[x - 1][y + 1]) {
        cnt++;
        x--;
        y++;
    }
    return cnt == 4;
}

void output(int x, int y){
    cout << map[x][y] << "\n";
    cout << x << " " << y;
}

void solve(){
    for (int i = 1; i <= 19; i++) {
        for (int j = 1; j <= 19; j++) {
            // 돌이 놓여져 있고
            // 검사 시작 돌 반대편에 같은돌이 없는 경우
            // 같은 돌이 놓여져 있다면 이미 검사 한 돌이기 때문에
            if(map[i][j]) {
                if(map[i][j-1] != map[i][j] && case1(i, j)) {
                    output(i,j);
                    return;
                }
                if (map[i - 1][j - 1] != map[i][j] && case2(i, j)) {
                    output(i,j);
                    return;
                }
                if (map[i - 1][j] != map[i][j] && case3(i, j)) {
                    output(i,j);
                    return;
                }
                if (map[i + 1][j - 1] != map[i][j] && case4(i, j)) {
                    output(i,j);
                    return;
                }
            }
        }
    }
    cout << 0;
}


int main(){
    input();
    solve();
}
