#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int arr[500001];
int target[500001];

int isTargetInArray(int *data, int target, int begin, int end);

int main() {
    int n, k;

    cin >> n;

    for(int i = 0; i < n; i++)
        cin >> arr[i];

    sort(arr, arr+n);

    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> target[i];
    }

    for (int i = 0; i < k; i++) {
        cout << isTargetInArray(arr, target[i], 0, n-1) << " ";
    }

    return 0;
}

int isTargetInArray(int *data, int target, int begin, int end){
    if(begin > end)
        return 0;
    int middle = (begin + end) / 2;
    if(target == data[middle])
        return 1;
    else if (target < data[middle])
        return isTargetInArray(data, target, begin, middle-1);
    else
        return isTargetInArray(data, target, middle+1, end);
}
