#include <stdio.h>
#include <stdlib.h>

int main() {
    int arr[15][14];
    int i, j;
    int t, k, n;
    for(i = 0; i < 14; i++){
        arr[i][0] = 1;
        arr[0][i] = i+1;
    }

    for(i = 1; i < 15; i++){
        for(j = 1; j < 14; j++){
            arr[i][j] = arr[i][j-1] + arr[i-1][j];
        }
    }

    scanf("%d", &t);

    for(i = 0; i < t; i++){
        scanf("%d%d", &k, &n);
        printf("%d\n", arr[k][n-1]);
    }
    return 0;
}