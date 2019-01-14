#include <iostream>
#include <cstring>

using namespace std;

int arr[31];

int main(){
    int n;
    int count = 0;

    cin >> n;

    while(true){
        if (n % 5 == 0) {
            cout << n/5 + count;
            break;
        } else if (n < 0) {
            cout << -1;
            break;
        }
        n -= 3;
        count++;
    }
}
