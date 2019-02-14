#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int E, S, M;

void input(){
    cin >> E >> S >> M;
}

void solve(){
    int year = 0;
    int earth = 0, sun = 0, moon = 0;

    while(true){
        year++;
        earth++;
        sun++;
        moon++;

        if (earth % 16 == 0) earth = 1;
        if (sun % 29 == 0) sun = 1;
        if (moon % 20 == 0) moon = 1;

        if (earth == E && sun == S && moon == M) {
            break;
        }
    }

    cout << year;
}
int main(){

    input();
    solve();
    return 0;
}
