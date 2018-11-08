#include <stdio.h>
#include <stdlib.h>


int main() {
    int p[2] = {1, 0};
    int n, i,j;
    int p_num, temp;

    scanf("%d", &n);

    for(i = 0; i < n; i++){
        scanf("%d", &p_num);
        p[0] = 1;
        p[1] = 0;
        for(j = 0; j < p_num; j++){
            temp = p[0];
            p[0] = p[1];
            p[1] += temp;
        }
        printf("%d %d\n", p[0], p[1]);
    }

    return 0;
}