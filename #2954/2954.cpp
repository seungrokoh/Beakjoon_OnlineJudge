#include <iostream>
#include <cstring>

using namespace std;

char str[101];

void print(int n);

int main(){
    cin.getline(str, 101);

    print(strlen(str) - 1);
}


void print(int n) {
    if (n < 0) {
        return;
    }

    if (str[n] == 'a' || str[n] == 'e' || str[n] == 'i' || str[n] == 'o' || str[n] == 'u') {
        print(n-3);
    } else {
        print(n-1);
    }

    cout << str[n];
}
