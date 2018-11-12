#include <stdio.h>
#include <stdlib.h>

#define max(a,b) ((a) > (b) ? (a) : (b));

int arr[301];
int dp[301];

int main(void){

    int n, i;

    scanf("%d", &n);
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    //마지막 전 계단을 밟았을 경우
    //dp[n] = dp[n - 3] + arr[n - 1] + arr[n]
    //마지막 전 계단을 밟지 않을 경우
    //dp[n] = dp[n - 2] + arr[n]

    dp[0] = arr[0];
    dp[1] = max(dp[0] + arr[1], arr[1]);
    dp[2] = max(dp[0] + arr[2], arr[1] + arr[2]);

    for (i = 3; i < n; i++) {
        dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
    }

    printf("%d", dp[n - 1]);
    return 0;
}
