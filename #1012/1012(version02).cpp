#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
#include <utility>

using namespace std;

int t, n, m, k, mask = 1;
int map[51][51];
queue<pair<int, int>> q;
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};
bool safe(int x, int y){
    return (0 <= x && x < m) && (0 <= y && y < n);
}

void input(){
    cin >> m >> n >> k;
    for (int i = 0; i < k; i++) {
        int x, y;
        cin >> x >> y;
        map[x][y] = 1;
    }
}

void output(){
    cout << mask - 1 << "\n";
    mask = 1;
}

void bfs(int x, int y, int mask){
    map[x][y] = mask;
    q.push(make_pair(x, y));

    while (!q.empty()) {
        int row = q.front().first;
        int col = q.front().second;

        q.pop();

        for (int i = 0; i < 4; i++) {
            if (safe(row + dx[i], col + dy[i]) && map[row + dx[i]][col + dy[i]] == 1) {
                map[row + dx[i]][col + dy[i]] = mask;
                q.push(make_pair(row + dx[i], col + dy[i]));
            }
        }
    }
}

void solve(){
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if(map[i][j] == 1) {
                mask++;
                bfs(i, j, mask);
            }
        }
    }
}

void initMap(){
    for (int i = 0; i < m; i++) {
        memset(map[i], 0, sizeof(int) * n);
    }
}
int main(){
    cin >> t;
    for (int testcase = 0; testcase < t; testcase++) {
        initMap();
        input();
        solve();
        output();
    }
}
