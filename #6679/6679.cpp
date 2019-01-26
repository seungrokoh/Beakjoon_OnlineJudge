#include <iostream>
#include <cstring>

using namespace std;

int duodecimalSum(int n){
    int arr[20], sum = 0;
    int index = 0;
    while (n > 0) {
        arr[index++] = n % 12;
        n /= 12;
    }
    for (int i = 0; i < index; i++) {
        sum += arr[i];
    }
    return sum;
}

int hexadecimalSum(int n){
    int arr[20], sum = 0;
    int index = 0;
    while (n > 0) {
        arr[index++] = n % 16;
        n /= 16;
    }
    for (int i = 0; i < index; i++) {
        sum += arr[i];
    }
    return sum;
}

int decimalSum(int n){
    int sum = 0;

    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }

    return sum;
}
int main(){
    for (int i = 1000; i <= 9999; i++) {
        if (decimalSum(i) == duodecimalSum(i) && decimalSum(i) == hexadecimalSum(i)) {
            cout << i << "\n";
        }
    }
}
