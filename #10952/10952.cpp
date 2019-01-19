#include <stdio.h>
#include <stdlib.h>

int main(){
	int num1, num2;
	
	while(1){
		scanf("%d%d", &num1, &num2);
		if(num1 == 0 && num2 == 0){
			break;
		}
		printf("%d\n", num1+num2);
	}
	return 0;
}
