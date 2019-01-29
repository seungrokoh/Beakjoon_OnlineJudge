#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;

int arr[100000];

bool cmp(int a, int b){
    return a < b;
}
void solve(int n, int k){
    int index = 0;
    for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            arr[index++] = i;
        }
    }

    sort(arr, arr + index, cmp);

    if (index < k) {
        cout << 0;
    } else {
        cout << arr[k - 1];
    }
}
int main(){
   int n, k;
   cin >> n >> k;
   solve(n,k);
}
