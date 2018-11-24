#include <stdio.h>
#include <stdlib.h>

int arr[101];

int main(void){
	int n, i,j;
	int prime_count = 0;
	int ctn = 0;
	
	scanf("%d", &n);
	
	for(i = 0; i < n; i++){
		scanf("%d", &arr[i]);
	}
	
	for(i = 0; i < n; i++){
		ctn = 0;
		if(arr[i] == 1){
			continue;
		}
		if(arr[i] == 2){
			prime_count++;
			continue;
		}
		
		if(arr[2] % 2 == 0){
			continue;
		}
		for(j = 2; j < arr[i]; j++){
			if(arr[i] % j == 0)
				ctn++;
		}
		if(ctn <= 0)
			prime_count++;
			
	}
	
	printf("%d", prime_count);
	return 0;
}
