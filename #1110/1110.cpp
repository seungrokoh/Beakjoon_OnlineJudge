#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int original;

int createCycleNum(int num){
    int cycleNum = 0;
    int newNum = 0;

    cycleNum += num % 10 * 10;

    while (num != 0) {
        newNum += num % 10;
        num /= 10;
    }

    cycleNum += newNum % 10;

    return cycleNum;
}
int main(){
    int temp;
    int cycle = 0;
    cin >> original;

    temp = original;

    while(true){
        cycle++;

        temp = createCycleNum(temp);

        if (temp == original) {
            break;
        }
    }

    cout << cycle;
    return 0;
}
