#include <iostream>

using namespace std;

int main(){
    int l, p;
    int num;
    cin >> l >> p;

    for (int i = 0; i < 5; i++) {
        cin >> num;
        cout << num - l*p << " ";
    }
}
