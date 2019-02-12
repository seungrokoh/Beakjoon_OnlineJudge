#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

char name[31];
int alpha[26];

int n;

void input(){
    cin >> n;
}
void solve(){
    bool isGiveup = true;

    for (int i = 0; i < n; i++) {
        scanf("%s", &name);
        int index = name[0] - 'a';
        alpha[index]++;
    }

    for (int i = 0; i < 26; i++) {
        if (alpha[i] > 4) {
            isGiveup = false;
            char name = (char) i + 'a';
            cout << name;
        }
    }

    if (isGiveup) {
        cout << "PREDAJA";
    }
}
int main(){

    input();
    solve();

    return 0;
}
