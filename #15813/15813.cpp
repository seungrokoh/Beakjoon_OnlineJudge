#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>

using namespace std;

char name[101];
int length;

void input(){
    cin >> length;
    cin >> name;
}
void solve(){
    int sum = 0;
    for (int i = 0; i < length; i++) {
        sum += name[i] - 64;
    }

    cout << sum;
}

int main(){

    input();
    solve();

    return 0;
}
