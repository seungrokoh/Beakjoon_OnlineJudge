#include <stdio.h>
#include <stdlib.h>

int arr[3];

int main(void){

    int n,i ,num, index;
    int count = 0;

    scanf("%d", &n);

    if (n < 100) {
        printf("%d", n);
        return 0;
    }

    for (i = 100; i <= n; i++) {
        if (i == 1000) {
            break;
        }

        index = 0;
        num = i;
        while (num != 0) {
            arr[index] = num % 10;
            num = num / 10;
            index++;
        }
        if (arr[2] - arr[1] == arr[1] - arr[0]) {
            count++;
        }
    }

    printf("%d", 99+count);


    return 0;
}
