# :page_facing_up: 거스름돈 [백준 5585번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%235585/5585.java)
:link: [[문제 풀러가기]](https://www.acmicpc.net/problem/5585)
***
그리디 알고리즘의 __기본적인? 문제 입니다.__ 문제의 조건을 살펴보면 __거스름돈을 거슬러 줄 때 동전의 개수를 최소로 만들어야 합니다.__ 동전 개수를 최소로 만들려면 __단위가 큰 동전의 개수가 많아야 합니다.__ 문제의 예시를 보면 설명을 해보겠습니다.  

문제에서 내야 할 금액은 380엔 입니다. 그러면 **거스름돈은 620엔을 거슬러 줘야 합니다.** 먼저 가장 큰 금액인 **500엔 1개를 사용해** 120원을 남길 수 있습니다. 그 다음 **100엔 1개를 사용해** 20원을 남길 수 있습니다. 그 다음 50엔은 **남은 금액보다 크기 때문에 사용할 수 없으며 10엔 2개로 남은 금액을 모두 거슬러 줄 수 있습니다.** 따라서 최소 개수는 4개 입니다.  

그리디 알고리즘에서 **중요한 점이 하나 있습니다.** 바로 **반드시 큰수는 작은 수의 배수여야 합니다.** 이 성질이 깨지게 되면 그리디 알고리즘을 사용할 수 없습니다. 큰 수가 작은 수의 배수여야 **작은 수를 여러개 모아 큰 수를 만들어 개수를 줄일 수 있기 때문입니다.**

글보단 소스코드를 보면 이해하기 쉽습니다.

### __:seedling: main 함수__
지불해야 할 금액을 입력받고 solve함수를 호출합니다.
```java
public static void main(String[] args) throws IOException {
    int pay = Integer.parseInt(br.readLine());

    System.out.println(solve(1000 - pay));
}
```
### __:seedling: solve 함수__
최소 거스름돈 개수를 구하는 함수입니다.
```java
private static int solve(int changeMoney) {
    int[] change = {500, 100, 50, 10, 5, 1};
    int result = 0;

    for (int index = 0; index < change.length && changeMoney >= 0; index++) {
        result += changeMoney / change[index];
        changeMoney %= change[index];
    }
    return result;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
