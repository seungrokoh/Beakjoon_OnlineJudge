#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

bool col[15];
bool increase[31];
bool decrease[31];
int n;
int cnt = 0;

void solve(int row){
    if (row == n) {
        cnt++;
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!col[i] && !increase[row + i] && !decrease[n - row + i]) {
            col[i] = increase[row + i] = decrease[n - row + i] = true;
            solve(row + 1);
            col[i] = increase[row + i] = decrease[n - row + i] = false;
        }
    }
}

int main(){
    cin >> n;
    solve(0);
    cout << cnt;
}
