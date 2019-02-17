#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

char numA[10001], numB[10001];

void input() {
    scanf("%s", &numA);
    scanf("%s", &numB);
}
void solve(){
    long long sum = 0;
    int lenA = strlen(numA), lenB = strlen(numB);
    for (int i = 0; i < lenA; i++) {
        for (int j = 0; j < lenB; j++) {
            sum += (numA[i] - '0') * (numB[j] - '0');
        }
    }

    cout << sum;
}
int main(){
    input();
    solve();
    return 0;
}
