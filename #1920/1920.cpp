#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int arr[100001];
int findNum[100001];
int size;

bool binary_search(int n){
    int start = 0;
    int end = size - 1;
    int middle = (start + end) / 2;

    while(start <= end) {
        middle = (start + end) / 2;
        if (arr[middle] == n) {
            return true;
        }
        if(n <= arr[middle]) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
    }
    return false;
}
int main(){
    int n, m;
    int num;
    cin >> n;

    size = n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr, arr + n);

    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> findNum[i];
    }

    for (int i = 0; i < m; i++) {
        cout << binary_search(findNum[i]) << "\n";
    }
}
