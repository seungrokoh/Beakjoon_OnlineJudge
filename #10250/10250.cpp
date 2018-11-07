#include <stdio.h>
#include <stdlib.h>

int main(void){

	int h,w,n,t;
	int i , j ;
	int number, layer;
	char result[10];
	
	scanf("%d", &t);
	
	for(i = 1; i <= t; i++){
		scanf("%d%d%d", &h,&w,&n);
		number = (n/h);	//È£¼ö 
		layer = n%h;	//Ãþ¼ö 
		if(layer == 0){
			layer = h;
		} else {
			number += 1;
		}
		
		if(number < 10){
			sprintf(result, "%d0%d", layer, number);
		} else {
			sprintf(result, "%d%d", layer, number);
		}
		printf("%s\n", result);
	}	
}
