#include <iostream>
#include <cstring>

using namespace std;

char arr[101];

int main(){
    int index = 0;

    cin >> arr;

    while (index < strlen(arr)) {
        cout << arr[index];
        index++;
        if (index % 10 == 0) {
            cout << "\n";
        }

    }
}
