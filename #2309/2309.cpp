#include <iostream>
#include <algorithm>

using namespace std;

int arr[9];
bool c[9];

int main(){
    int sum = 0;
    bool endflag = false;

    for (int i = 0; i < 9; ++i) {
        cin >> arr[i];
        sum += arr[i];
    }

    sort(arr, arr+9);

    for (int i = 0; i < 8; i++) {
        for (int j = i + 1; j < 9; j++) {
            if (sum - (arr[i] + arr[j]) == 100) {
                c[i] = c[j] = true;
                endflag = true;
                break;
            }
        }
        if(endflag)
            break;
    }

    for (int i = 0; i < 9; ++i) {
        if (!c[i]) cout << arr[i] << "\n";
    }
    return 0;
}
