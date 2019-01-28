#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
#include <utility>

using namespace std;

int t, n, m, mask = 2;
int map[101][101];
bool visited[101][101];
queue<pair<int, int>> q;
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};

bool safe(int x, int y){
    return (0 <= x && x < n) && (0 <= y && y < m);
}

void input(){
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &map[i][j]);
        }
    }
}

void output(){
    cout << map[n-1][m-1];
}

void bfs(int x, int y){
    q.push(make_pair(x, y));
    visited[x][y] = true;
    while (!q.empty()) {
        int row = q.front().first;
        int col = q.front().second;
        q.pop();

        if (row == n && col == m) {
            break;
        }

        for (int i = 0; i < 4; i++) {
            if (safe(row + dx[i], col + dy[i]) && map[row + dx[i]][col + dy[i]] == 1 && !visited[row + dx[i]][col + dy[i]]) {
                map[row + dx[i]][col + dy[i]] = map[row][col] + 1;
                q.push(make_pair(row + dx[i], col + dy[i]));
            }
        }
    }
}

int main(){
    input();
    bfs(0, 0);
    output();
}


