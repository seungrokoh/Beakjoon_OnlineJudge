#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

char arr[11];

bool cmp(int a, int b){
    return a > b;
}
void input(){
    scanf("%s", &arr);
}

void solve(){
    int len = strlen(arr);
    sort(arr, arr + len, cmp);

    for (int i = 0; i < len; i++) {
        cout << arr[i];
    }
}
int main(){

    input();
    solve();
    return 0;
}
