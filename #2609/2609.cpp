#include <iostream>

using namespace std;

int gcm(int num1, int num2);
int lcm(int num1, int num2, int gcm);

int main(){
    int num1, num2;
    int resultGcm;

    cin >> num1 >> num2;

    resultGcm = gcm(num1, num2);
    cout << resultGcm << "\n";
    cout << lcm(num1, num2, resultGcm);

}

int gcm(int num1, int num2){
    if (num2 == 0) {
        return num1;
    }
    return gcm(num2, num1%num2);
}

int lcm(int num1, int num2, int gcm){
    return (num1 * num2)/gcm;
}
