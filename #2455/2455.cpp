#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int in, out;

void solve(){
    int max = -1;
    int sum = 0;
    for (int i = 0; i < 4; i++) {
        cin >> in >> out;
        sum += out - in;
        if (sum > max) {
            max = sum;
        }
    }

    cout << max;
}
int main(){
    solve();
    return 0;
}
