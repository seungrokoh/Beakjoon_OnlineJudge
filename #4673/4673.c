#include <stdio.h>
#include <stdlib.h>

int dn[10001];

int main(void){

    int n = 10000;
    int i, a,b,c,d,e = 0;

    for (i = 1; i <= 10000; i++) {
        if(1 <= i && i < 100){
            a =  i / 10;
            b = i % 10;
            dn[i+a+b] = 1;
        } else if(100 <= i && i < 1000){
            a = i / 100;
            b = i / 10 % 10;
            c = i % 10;
            dn[i+a+b+c] = 1;
        } else if (1000 <= i && i < 9999) {
            a = i / 1000;
            b = i / 10 / 10 % 10;
            c = i / 10 % 10;
            d = i % 10;
            dn[i+a+b+c+d] = 1;
        }
    }

    for(i = 1; i <= n; i++){
        if(!dn[i]){
            printf("%d\n", i);
        }
    }

    return 0;
}