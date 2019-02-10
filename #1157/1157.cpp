#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int alpha[26];
char str[1000001];
int length;

void input(){
    scanf("%s", &str);
    length = strlen(str);
    for (int i = 0; i < length; i++) {
        str[i] = tolower(str[i]);
    }
}
void solve(){
    bool isMax = true;

    for (int i = 0; i < length; i++) {
        alpha[str[i] - 'a']++;
    }

    int max = 0;
    for (int i = 0; i < 26; i++) {
        if (alpha[i] > alpha[max]) {
            max = i;
        }
    }

    for (int i = 0; i < 26; i++) {
        if (alpha[max] == alpha[i] && max != i) {
            isMax = false;
            break;
        }
    }

    if (isMax) {
        printf("%c", max + 'A');
    } else {
        cout << "?";
    }
}
int main(){

    input();
    solve();

    return 0;
}
