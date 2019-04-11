# __:bulb: [BOJ #11052번] (카드 구매하기) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2311052/11052.java)
***

`다이나믹 프로그래밍` 입니다. 많은 문제를 접해봐야지 쉽게 접근할 수 있을거 같습니다. 문제를 풀기전에는 쉬워 보였지만 시간이 너무 오래 걸렸네요. 문제를 풀면서 느낀건 `Bottom-Up`과 `Top-Down` 두 방식 모두 풀어봐야 한다는 점이었습니다. 문제에 접근하는 방식을 한 번 살펴봅시다.

문제에서 구하고자 하는 것은 `카드를 구매하는데 최댓값`을 구하는 문제입니다. 카드를 구매할 수 있는 방법은 `카드 팩`을 구매하는 것인데 `i개의 카드가 들어있는 팩 ~ N개의 카드가 들어있는 팩`로 구성되어 있습니다. 각 팩마다 `value`가 정해져 있는데 문제에서 원하는 것은 N개의 카드를 구매하는데 `어떤 팩의 조합`이 가장 큰 value값을 가지냐는 것입니다.

예를들어 총 4개의 카드를 구매한다고 가정해보면 카드를 구매할 수 있는 방법은 다음과 같습니다.

    1개 짜리 팩 + 3개를 살 수 있는 최댓값
    2개 짜리 팩 + 2개를 살 수 있는 최댓값
    3개 짜리 팩 + 1개를 살 수 있는 최댓값
    4개 짜리 팩

나열 된 4가지 방법 중 최댓값을 찾으면 문제의 정답이 됩니다. 이를 코드로 나타내면 다음과 같습니다.

##### :seedling: Top-Down 방식
```java
private static int topDownSolve(int n){
    if (n == 0) return 0;
    if (dp[n] != 0) return dp[n];

    for (int numOfCard = 1; numOfCard <= n; numOfCard++) {
        dp[n] = max(dp[n], card[numOfCard] + topDownSolve(n - numOfCard));
    }

    return dp[n];
}
```

numOfCard는 현재 사려고 하는 card의 개수 입니다. 문제에서 `int[] card`의 `인덱스 == 카드의 개수`이며 card[index]의 값은 가격 입니다.

코드만 보고 이해하기가 힘들어 문제에서 주어진 예제를 보고 `dp표 와 함수의 call stack`을 직접 따라가며 확인하니 이해가 더 잘되었습니다. 이해가 가질 않는다면 `call stack`을 직접 따라가보시기 바랍니다.
