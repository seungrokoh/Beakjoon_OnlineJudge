#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int n;
int p1, p2;

void input(){
    cin >> n >> p1 >> p2;
}

int calc(int p){
    if (p <= 2){
        return 1;
    }
    if (p % 2 == 0) {
        return p / 2;
    } else {
        return p / 2 + 1;
    }
}
void solve(){
    int round = 0;
    if (p1 > p2){
        int temp = p1;
        p1 = p2;
        p2 = temp;
    }

    while(true){
        round++;
        if (p2 - p1 == 1 && p2 % 2 == 0) {
            break;
        }
        p1 = calc(p1);
        p2 = calc(p2);
    }

    cout << round;
}
int main(){
    input();
    solve();
    return 0;
}
