#include <iostream>
#include <cstring>

using namespace std;

char str[101];

int main(){
    cin.getline(str, 101);

    for (int i = 0; i < strlen(str);) {
        if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
            cout << str[i];
            i = i + 3;
        } else {
            cout << str[i];
            i++;
        }
    }
}

