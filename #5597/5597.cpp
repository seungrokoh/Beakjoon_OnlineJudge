#include <iostream>
#include <cstring>

using namespace std;

int arr[31];

int main(){
    int n;
    for (int i = 0; i < 28; i++) {
        cin >> n;
        arr[n] = n;
    }
    for (int j = 1; j <= 30; j++) {
        if (arr[j] == 0) {
            cout << j << "\n";
        }
    }
}
