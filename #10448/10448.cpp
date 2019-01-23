#include <iostream>
#include <algorithm>

using namespace std;

int triangleNum[51];

int main(){
    int t, num;
    bool isTriangle = false;
    cin >> t;

    for (int i = 1; i < 51; i++) {
        triangleNum[i] = i*(i+1)/2;
    }

    for (int i = 0; i < t; i++) {
        cin >> num;
        isTriangle = false;
        for (int loop1 = 1; loop1 < 51; loop1++) {
            for (int loop2 = 1; loop2 < 51; ++loop2) {
                for (int loop3 = 1; loop3 < 51; ++loop3) {
                    if (triangleNum[loop1] + triangleNum[loop2] + triangleNum[loop3] == num) {
                        isTriangle = true;
                        break;
                    }
                }
                if (isTriangle) break;
            }
            if (isTriangle) break;
        }
        if(isTriangle) cout << 1 << "\n";
        else cout << 0 << "\n";
    }

}
