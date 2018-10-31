#include <stdio.h>
#include <stdlib.h>

int arr[10001];

int dn(int n){
	int sum = n;
	while(1){
		if(n == 0){
			break;	
		}
		sum += n%10;
		n /= 10;
	}
	return sum;
}

int main(void){
    int i, result;

    for (i = 1; i <= 10000; i++) {
		result = dn(i);
		if(result <= 10000){
			arr[result] = 1;
		}
    }

    for(i = 1; i <= 10000; i++){
        if(!arr[i]){
            printf("%d\n", i);
        }
    }

    return 0;
}
