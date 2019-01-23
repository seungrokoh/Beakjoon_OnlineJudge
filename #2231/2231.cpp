#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n, sum = 0;
    int temp;
    bool flag = true;

    cin >> n;

    for (int i = 1; i < n; i++) {
        temp = i;
        sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        sum += i;
        if (sum == n) {
            cout << i;
            flag = false;
            break;
        }
    }

    if (flag) cout << 0;

}
