#include <stdio.h>

int main(int argc, char* argv[]) {
    int color[200001] = {0,};
    int weight[200001] = {0,};
    int score[200001] = {0,};
    int ball = 0;
    int i,j;

    scanf("%d",&ball);
    for(i = 0; i < ball; i++){
        scanf("%d%d",&color[i], &weight[i]);
    }

    for(i = 0; i < ball-1; i++){
        for(j = i+1; j < ball; j++){
            if(color[i] != color[j]){
                if(weight[i] > weight[j]){
                    score[i] += weight[j];
                }else {
                    score[j] += weight[i];
                }
            }
        }
    }

    for(i = 0; i < ball; i++){
        printf("%d\n", score[i]);
    }

    return 0;
}
