#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;

int t, a, b;

void solve(){
    cin >> t;
    for (int i = 0; i < t; i++) {
        int result = 1;
        cin >> a >> b;
        for (int j = 0; j < b; j++) {
            result = (result * a) % 10;
        }
        result == 0 ? cout << 10 : cout << result;
        cout << "\n";
    }
}
int main(){
    solve();
}
