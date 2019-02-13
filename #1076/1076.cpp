#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

string color[] = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
long long value[] = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

string in[3];
int colorIndex[3];

void input(){
    for (int i = 0; i < 3; i++) {
        cin >> in[i];
    }
}
void solve(){
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j <= 9; j++) {
            if (color[j] == in[i]){
                colorIndex[i] = j;
                break;
            }
        }
    }

    long long result = ((10*colorIndex[0] + colorIndex[1]) * value[colorIndex[2]]);

    cout << result;
}
int main(){

    input();
    solve();
    return 0;
}
