#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>

using namespace std;

char map[250][250];

char str[51];
int row, col, n;
int dx[4] = {}, dy = {};
char state[4] = {'N', 'E', 'S', 'W'};
char direction = 2;

int sx, sy ,minx, miny, maxx, maxy;

int max(int a, int b){
    return a > b ? a : b;
}

int min(int a, int b) {
    return a < b ? a : b;
}

void minMax(){
    maxx = max(maxx, row);
    minx = min(minx, row);
    maxy = max(maxy, col);
    miny = min(miny, col);
}
void input(){
    cin >> n;
    cin >> str;
}

void initMap(){
    for (int i = 0; i < 250; i++) {
        for (int j = 0; j < 250; j++) {
            map[i][j] = '#';
        }
    }
}

void moveMap(int direction){
    if (state[direction] == 'N') {
        row--;
        map[row][col] = '.';
    } else if (state[direction] == 'W') {
        col--;
        map[row][col] = '.';
    } else if (state[direction] == 'E') {
        col++;
        map[row][col] = '.';
    } else {
        row++;
        map[row][col] = '.';
    }
    minMax();
}

void solve(int x, int y) {
    row = sx = minx = maxx = x;
    col = sy = miny = maxy = y;

    map[row][col] = '.';

    for (int i = 0; i < n; i++) {
        if (str[i] == 'R') {
            direction + 1 == 4 ? direction = 0 : direction++;
        }
        if (str[i] == 'L') {
            direction - 1 == -1 ? direction = 3 : direction--;
        }
        if (str[i] == 'F') {
            moveMap(direction);
        }
    }
}

void showMap(){
    for (int i = minx; i <= maxx; i++) {
        for (int j = miny; j <= maxy; j++) {
            cout << map[i][j];
        }
        cout << "\n";
    }
}

int main(){
    input();
    initMap();
    solve(50,50);
    showMap();
}
