#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int min(int a, int b){
    return a < b ? a : b;
}
int main(){

    int x, y, w, h;
    cin >> x >> y >> w >> h;

    int row = min(x, w - x);
    int col = min(y, h - y);

    cout << min(row, col);

    return 0;
}
