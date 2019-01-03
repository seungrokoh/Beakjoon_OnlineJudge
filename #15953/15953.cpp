#include <stdio.h>

int arr2017[6] = {5000000, 3000000, 2000000, 500000, 300000, 100000};
int arr2018[5] = {5120000, 2560000, 1280000, 640000, 320000};

int calc2017(int a);
int calc2018(int b);

int main() {
    int t, a = 0, b = 0, i;

    scanf("%d", &t);
    for (i = 0; i < t; i++) {
        scanf("%d", &a);
        scanf("%d", &b);

        printf("%d\n", calc2017(a) + calc2018(b));
    }
    return 0;
}

int calc2017(int a){
    int sum = 0;
    int index = 0;
    int i;

    if (a == 0) {
        return 0;
    }

    for (i = 1; i <= 6; i++) {
        sum += i;
        if(sum >= a){
            index = i;
            break;
        }
    }
    if (index < 0) {
        return 0;
    } else {
        index -= 1;
        return arr2017[index];
    }
}

int calc2018(int b){
    int sum = 1;
    int calc = 1;
    int index = -1;
    int i;

    if (b == 0) {
        return 0;
    }
    for (i = 0; i <= 5; i++) {
        if(sum >= b){
            index = i;
            break;
        }
        calc *= 2;
        sum += calc;
    }
    if (index < 0) {
        return 0;
    } else {
        return arr2018[index];
    }
}
