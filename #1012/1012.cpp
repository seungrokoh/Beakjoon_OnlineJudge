#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int g[51][51];
int t, n, m, k;
int mask = 1;

bool safe(int a, int b){
    return (0 <= a && a < m) && (0 <= b && b < n);
}

bool cmp(int a, int b){
    return a > b;
}

void dfs(int x, int y, int mask) {
    g[x][y] = mask;

    if (safe(x + 1, y) && g[x + 1][y] == 1) {
        dfs(x + 1, y, mask);
    }
    if (safe(x - 1, y) && g[x - 1][y] == 1) {
        dfs(x - 1, y, mask);
    }
    if (safe(x, y + 1) && g[x][y + 1] == 1) {
        dfs(x, y + 1, mask);
    }
    if (safe(x, y - 1) && g[x][y - 1] == 1) {
        dfs(x, y - 1, mask);
    }
}

void solve(){
    mask = 1;

    for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
            if(g[row][col] == 1) {
                mask++;
                dfs(row, col, mask);
            }
        }
    }

    cout << mask - 1 << "\n";
}

void showMap(){
    cout << "\n\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << g[i][j] << " ";
        }
        cout << "\n";
    }

}

void input(){
    cin >> m >> n >> k;

    for (int i = 0; i < k; i++) {
        int x, y;
        cin >> x >> y;
        g[x][y] = 1;
    }
}

void initArr(){
    for (int i = 0; i < m; i++) {
        memset(g[i], 0, sizeof(int) * n);
    }
}

int main(){
    cin >> t;

    for (int i = 0; i < t; i++) {
        initArr();
        input();
        solve();
        //showMap();
    }
}
