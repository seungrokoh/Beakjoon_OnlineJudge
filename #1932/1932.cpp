#include <stdio.h>
#include <stdlib.h>

int arr[500][500];
int main(void){
	int n;
	int i, j, sum = 0;
	
	scanf("%d", &n);
	
	for(i = 0; i < n; i++){
		for(j = 0; j <= i; j++){
			scanf("%d", &arr[i][j]);
		}
	}
	
	for(i = 0; i < n; i++){
		for(j = 0; j <= i; j++){
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
	
	sum += arr[0][0];
	j = 0;
	for(i = 0; i < n; i++){
		if(arr[i+1][j] > arr[i+1][j+1]){
			sum += arr[i+1][j];
		} else {
			sum += arr[i+1][j+1];
			j++;
		}
	}
	
	printf("%d", sum);
	return 0;
}
