#include <iostream>

using namespace std;

int arr[21];
int count = 0;
int n, s;

/*
 * index : 배열의 인덱스
 * sum : 합
 * length : 부분집합의 길이
 */
int dfs(int index, int sum, int length){
    // 입력된 정수를 모두 활용
    if (index == n) {
        // 부분집합의 합이 입력과 같고 공집합이 아닐 경우
        if (sum == s && length != 0) {
            count++;
        }
        return 0;
    }

    // 정수를 부분집합으로 선택
    dfs(index + 1, sum + arr[index], length + 1);
    // 정수를 부분집합으로 선택하지 않음
    dfs(index + 1, sum, length);
    return 0;
}
int main(){
    cin >> n >> s;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    dfs(0,0,0);
    cout << count;
    return 0;
}
