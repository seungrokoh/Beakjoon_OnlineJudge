#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;

int arr[9][9];

bool max(int a, int b){
    return a > b;
}
void solve(){
    int result = -1;
    int x, y;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if(max(arr[i][j], result)) {
                result = arr[i][j];
                x = i, y = j;
            }
        }
    }

    cout << result << "\n";
    cout << x + 1 << " " << y + 1;
}

void input(){
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            cin >> arr[i][j];
        }
    }
}
int main(){
   input();
   solve();
}
