#include <stdio.h>

int main(void){
	int n = 1;
	int key;
	int sum = 0;
	int a, b;
	
	scanf("%d", &key);
	
	while(sum < key){
		sum += n;
		n++;
	}
	
	a = 1 + (sum - key);
	b = n - 1 -(sum -key);
	
	printf("%d/%d", a, b);
	
	return 0;
}
