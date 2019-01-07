#include <iostream>

using namespace std;

long choose(int n, int r);

int main(){
    int n, k;

    cin >> n >> k;

    cout << choose(n, k);
}

long choose(int n, int r){
    if (r == 0 || r == n) {
        return 1;
    }
    return choose(n - 1, r - 1) + choose(n - 1, r);
}
