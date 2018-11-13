#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char str[1000002];

int main(void){

    int count = 1;
    int i;
    //fgets (str, 1000001, stdin);
    gets(str);

    for (i = 0; i < strlen(str); i++) {
        if (str[i] == ' ') {
            count++;
        }
    }

    if (str[0] == ' ') {
        count--;
    }
    if (str[strlen(str) - 1] == ' ') {
        count--;
    }

    printf("%d", count);
    return 0;
}
