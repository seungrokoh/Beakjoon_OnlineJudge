#include <stdio.h>
#include <stdlib.h>

int arr[501][501];
int dp[501][501];

int main(void){
    int n;
    int i, j, sum = 0;
    int max;

    scanf("%d", &n);

    for(i = 0; i < n; i++){
        for(j = 0; j <= i; j++){
            scanf("%d", &arr[i][j]);
        }
    }

    dp[0][0] = arr[0][0];
    for(i = 0; i < n; i++){
        for(j = 0; j <= i; j++){
            if (dp[i + 1][j] < dp[i][j] + arr[i + 1][j]) {
                dp[i + 1][j] = dp[i][j] + arr[i + 1][j];
            }
            if (dp[i + 1][j + 1] < dp[i][j] + arr[i + 1][j + 1]) {
                dp[i + 1][j + 1] = dp[i][j] + arr[i + 1][j + 1];
            }
        }
    }

    max = 0;
    for(i = 0; i < n; i++){
        if(max < dp[n-1][i]){
            max = dp[n-1][i];
        }
    }

    printf("%d", max);
    return 0;
}
