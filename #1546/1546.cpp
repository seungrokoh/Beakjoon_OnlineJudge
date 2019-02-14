#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int n;
int score[1001];

bool cmp(int a, int b){
    return a > b;
}

void input(){
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> score[i];
    }
}

void solve(){
    int max;
    double sum = 0;
    sort(score, score + n, cmp);
    max = score[0];
    for (int i = 0; i < n; i++) {
        sum += (double) score[i] / max * 100;
    }

    cout << sum / n;
}
int main(){

    input();
    solve();
    return 0;
}
