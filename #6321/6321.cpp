#include <iostream>
#include <cstring>

using namespace std;

char arr[51];

int main(){
    int n;

    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> arr;
        cout << "String #" << i << "\n";
        for (int j = 0; j < strlen(arr); j++) {
            if (arr[j] == 'Z') {
                cout << 'A';
            } else {
                cout << (char) (arr[j] + 1);
            }
        }
        cout << "\n\n";
        memset(arr, '0', 51);
    }
}
