#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>

using namespace std;

int n, arrA[51], arrB[51];
bool visitB[51];

bool cmp(int a, int b){
    return a < b;
}
void input(){
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arrA[i];
    }



    for (int i = 0; i < n; i++) {
        cin >> arrB[i];
    }
}

void solve(){
    sort(arrA, arrA + n, cmp);
    
    int max;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        int index = 0;
        max = -1;
        for (int j = 0; j < n; j++) {
            if (!visitB[j] && arrB[j] > max) {
                max = arrB[j];
                index = j;
            }
        }
        visitB[index] = true;
        sum += (arrA[i] * arrB[index]);
    }

    cout << sum;
}
int main(){
    input();
    solve();

    return 0;
}
