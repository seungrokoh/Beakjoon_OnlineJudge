#include <stdio.h>
#include <stdlib.h>

int main(){
	int m , n;
	int i, j;
	int arr[10001] = {0,};
	int sum = 0;
	int index = 0;
	int count = 0;
	
	scanf("%d", &m);
	scanf("%d", &n);
	
	for(i = m; i <= n; i++){
		count = 0;
		if(i == 1)
			continue;
		if(i == 2){
			arr[index] = i;
			sum += i;
			index++;
			continue;
		}
		if(i % 2 == 0){
			continue;
		}
		for(j = 2; j < i; j++){
			if(i % j == 0)
				count++;
		}
		if(count == 0){
			arr[index] = i;
			sum += i;
			index++;
		}
	}
	
	if(index == 0)
		printf("-1");
	else
		printf("%d\n%d",sum, arr[0]);
		
		
	return 0;
}
