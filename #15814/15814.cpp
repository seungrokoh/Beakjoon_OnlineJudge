#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

char str[101];

void swap(int in1, int in2){
    char temp;
    temp = str[in1];
    str[in1] = str[in2];
    str[in2] = temp;
}
int main(){
    int t;
    cin >> str;
    cin >> t;


    for (int i = 0; i < t; i++) {
        int in1, in2;
        cin >> in1 >> in2;
        swap(in1, in2);
    }

    cout << str;
}
