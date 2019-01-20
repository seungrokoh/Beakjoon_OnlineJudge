#include <stdio.h>

int p[1001];

int dp(int n){
    if(n == 1) return 1;
    if(n == 2) return 3;
    if (p[n] != 0) return p[n];
    return p[n] = (dp(n - 1) + dp(n - 2) + dp(n-2)) % 10007;
}

int main(){

    int n;
    scanf("%d", &n);
    
    printf("%d", dp(n));
    return 0;
}
