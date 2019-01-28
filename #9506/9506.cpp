#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;

int arr[100000];

bool cmp(int a, int b){
    return a < b;
}
void solve(int n){
    int sum = 0;
    int index = 0;
    memset(arr, 0, 100000);
    for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            sum += i;
            arr[index++] = i;
        }
    }

    sort(arr, arr + index, cmp);
    if (sum == n) {
        cout << n << " = ";
        for (int i = 0; i < index; i++) {
            (i == 0) ? cout << arr[i] : cout << " + " << arr[i];
        }
        cout << "\n";
    } else {
        cout << n << " is NOT perfect.\n";
    }
}
int main(){
   int n;
   while(true){
       cin >> n;
       if (n < 0) {
           break;
       }
       solve(n);
   }
}
