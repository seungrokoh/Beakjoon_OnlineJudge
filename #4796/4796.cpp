#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>

using namespace std;

int l, p, v;
int cnt = 0;
void solve(){
    while(true){
        cin >> l >> p >> v;
        if (l == 0 && p == 0 && v == 0) {
            break;
        }

        int period = v / p;
        int remainder = v % p;

        int result = 0;

        if (remainder > l) {
            cout << "Case " << ++cnt << ": " << (period * l) + l << "\n";
        } else {
            cout << "Case " << ++cnt << ": " << (period * l) + remainder << "\n";
        }


    }

}
int main(){

    solve();

    return 0;
}
