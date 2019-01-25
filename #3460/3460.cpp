#include <iostream>
#include <cstring>

using namespace std;

int binary[20];

int main(){
    int t, num;
    int index = 0;
    int length;
    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> num;
        index = 0;
        while (num > 0) {
            binary[index++] = num % 2;
            num /= 2;
        }
        length = index - 1;
        for (int j = 0; j <= length; j++) {
            if (binary[j]) cout << j << " ";
        }
        cout << "\n";
    }
}
