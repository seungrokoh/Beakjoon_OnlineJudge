#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

vector<vector<int>> v;

int arr[9];

int main(){
    for (int i = 0; i < 9; i++) {
        cin >> arr[i];
    }

    int max = 0;
    int index = 0;
    for (int i = 0; i < 9; i++) {
        if (max < arr[i]) {
            max = arr[i];
            index = i + 1;
        }
    }
    cout << max << "\n" << index;
}
