#include <iostream>

using namespace std;

int memo[1001][1001];

void choose(int n, int r);

int main(){
    int n, k;

    cin >> n >> k;

    choose(n, k);
}

void choose(int n, int r){

    memo[1][0] = 1;
    memo[1][1] = 1;

    for (int i = 2; i <= n; i++) {
        for (int j = 0; j <= i; j++) {
            if(i == j || j == 0)
                memo[i][j] = 1;
            else
                memo[i][j] = memo[i-1][j-1] + memo[i-1][j];

            memo[i][j] %= 10007;
        }
    }

    cout << memo[n][r];

}
