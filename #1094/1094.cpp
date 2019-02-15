#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int x;

void input(){
    cin >> x;
}

void solve(){
    int stick = 64;
    int small = stick;
    int piece = 0;

    while(true){
        if (small > x){
            small /= 2;
        } else {
            x -= small;
            small /= 2;
            piece++;
        }

        if (x == 0) {
            break;
        }
    }

    cout << piece;
}
int main(){
    input();
    solve();
    return 0;
}
