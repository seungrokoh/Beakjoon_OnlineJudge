#include <stdio.h>
#include <stdlib.h>

int arr[10];

int main(void){

    int i;
    int num;
    int result = 1;
    int index;

    for (i = 0; i < 3; i++) {
        scanf("%d", &num);
        result *= num;
    }


    while (result != 0) {
        index = result % 10;
        arr[index]++;
        result /= 10;
    }

    for (i = 0; i < 10; i++) {
        printf("%d\n", arr[i]);
    }

    return 0;
}
