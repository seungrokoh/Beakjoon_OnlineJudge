#include <stdio.h>
#include <stdlib.h>

int arr[10];

int main() {
    int number;
    int index, max = 1;

    scanf("%d", &number);

    if(number <= 10){
        printf("1");
        return 0;
    }
    while(1){
        if(number == 0){
            break;
        }
        index = number % 10;
        arr[index] += 1;
        number /= 10;
    }

    arr[6] += arr[9];
    if (arr[6] % 2 == 0) {
        arr[6] /= 2;
    } else {
        arr[6] = (arr[6] / 2) + 1;
    }

    for(index = 0; index < 10; index++){
        if(max < arr[index]){
            max = arr[index];
        }
    }

    for(index = 0; index < 10; index++){
        printf("%d ", arr[index]);
    }
    printf("\n%d", max);
    return 0;
}
