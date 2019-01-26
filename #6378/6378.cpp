#include <iostream>
#include <cstring>

using namespace std;

char arr[1001];

void digitalRoot(){
    int sum = 0;

    while(true){
        sum = 0;
        for (int i = 0; i < strlen(arr); i++) {
            sum += arr[i] - '0';
        }

        if (sum < 10) {
            cout << sum << "\n";
            break;
        } else {
            for (int i = 0; i < strlen(arr); i++) {
                arr[i] = '0';
            }
            sprintf(arr, "%d", sum);
        }
    }
}
int main(){

    while(true){
        cin >> arr;
        if (arr[0] == '0') {
            break;
        }
        digitalRoot();
    }
}
