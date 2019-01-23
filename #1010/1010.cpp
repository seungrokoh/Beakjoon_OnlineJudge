#include <iostream>
#include <cstring>

using namespace std;

int memo[31][31];

int choose(int m, int n){
    if (n == 0 || m == n)
        return memo[m][n] = 1;
    if (memo[m][n] > 0)
        return memo[m][n];

    return memo[m][n] = choose(m - 1, n - 1) + choose(m - 1, n);
}

int main(){
    int t, n, m;

    cin >> t;

    for (int i = 0; i < t; ++i) {
        memset(memo, 0, sizeof(memo));

        cin >> n >> m;
        cout << choose(m, n) << "\n";
    }

}
