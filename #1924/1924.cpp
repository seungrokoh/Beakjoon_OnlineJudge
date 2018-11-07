#include <stdio.h>
#include <stdlib.h>

int main(void){

	int month, day;
	int date[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	int total = 0, i;
	
	scanf("%d%d", &month, &day);
	
	for(i = 0; i < month-1; i++){
		total += date[i];
	}
	
	total += day;
	
	switch(total%7){
		case 0 : printf("SUN");
					break;
		case 1 : printf("MON");
					break;
		case 2 : printf("TUE");
					break;
		case 3 : printf("WED");
					break;
		case 4 : printf("THU");
					break;
		case 5 : printf("FRI");
					break;
		case 6 : printf("SAT");
					break;
	}
}
