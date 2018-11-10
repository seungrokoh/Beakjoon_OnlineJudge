#include <stdio.h>
#include <stdlib.h>

int arr[10];

int main() {
    int number;
    int index, max = 1;

    scanf("%d", &number);

    while(1){
        
        index = number % 10;
        if(number == 0){
            break;
        }
        
        if(index == 9){
			arr[6] += 1;
		} else {
			arr[index] += 1;
		}
        number /= 10;
    }

    arr[6] = arr[6] / 2 + arr[6] % 2;

    for(index = 0; index < 9; index++){
        if(max < arr[index]){
            max = arr[index];
        }
    }

    printf("%d", max);
    return 0;
}
