#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char str[1000002];

int main(void){

    int count = 1;
    int i;
    fgets (str, 1000001, stdin);
    //gets(str);

    //fgets는 엔터까지 저장
    //따라서 str[strlen(str) - 2] == ' '로 해야함
    //gets는 엔터값을 저장하지 않음
    //따라서 str[strlen(str) - 1] == ' '로 해야함

    for (i = 0; i < strlen(str); i++) {
        if (str[i] == ' ') {
            count++;
        }
    }

    if (str[0] == ' ') {
        count--;
    }
    if (str[strlen(str) - 2] == ' ') {
        count--;
    }

    printf("%d", count);
    return 0;
}
