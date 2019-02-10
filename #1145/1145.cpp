#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int arr[5];

void input(){
    for (int i = 0; i < 5; i++) {
        cin >> arr[i];
    }
}

void solve(){
    int cnt = 0;
    int number = 0;
    while(true){
        number++;
        cnt = 0;
        
        for (int i = 0; i < 5; i++) {
            if (number % arr[i] == 0) {
                cnt++;
            }
        }

        if (cnt > 2) {
            break;
        }
    }

    cout << number;
}
int main(){

    input();
    solve();

    return 0;
}
