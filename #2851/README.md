# :page_facing_up: 슈퍼 마리오 [백준 2851번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232851/2851.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/2851)
***
# __문제 풀이__
문제는 **단순 비교를 통해 해결하였습니다.** 총 10개의 버섯을 차례대로 먹을 때 **현재까지 먹은 버섯 점수**와 **다음 버섯을 먹었을 때 점수**를 **비교**해서 100에 가까운 값을 찾는 방법입니다. 먼저 문제의 조건을 살펴보겠습니다.

# __문제 조건__
1. 10개의 버섯이 일렬로 놓아져 있다.
2. 버섯을 처음부터 나온 **순서대로 먹는다.**
3. 모든 버섯을 먹을 필요는 없고 **중간에 중단할 수 있다.**
4. 중간에 먹는것을 **중단하면 이 후에 나온 버섯은 모두 먹을 수 없다.**
5. 먹은 버섯의 **합을 최대한 100에 가깝게** 만들어라.

# __문제 접근__
문제 접근 방법은 **지금까지 먹은 버섯의 합**과 **다음 버섯을 먹었을 때의 합**을 비교해 100과 가까운지 체크하면 쉽게 해결할 수 있습니다. 다음에 나오는 버섯을 먹지 않는다면 **이후 모든 버섯을 먹을 수 없기 때문에** 현재까지 먹은 버섯의 합이 100과 가깝다면 그게 답입니다. 따라서 프로그램의 종료 조건은 **다음 버섯을 먹지 않았을 때 입니다.**

# __주의 사항__
문제에서 주의해야 할 점은 **만약 100에 가까운 수가 2개라면 (예: 98, 102) 큰 값을 선택한다.** 라고 되어있습니다. 즉, **절댓 값이 100과 가까운 수를 찾는다면 큰 수를 찾을 수 있습니다.**


글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
// 전역 변수
private static final int GOAL_NUMBER = 100;

public static void main(String[] args) throws IOException {
    int currentSum = 0;

    for (int i = 0; i < 10; i++) {
        int temp = currentSum;
        currentSum = min(currentSum, currentSum + Integer.parseInt(br.readLine()));
        if (temp == currentSum) break;
    }
    System.out.println(currentSum);
}
```
### __:seedling: min 함수__
100과 가장 가까운 값을 찾는 함수 입니다.
```java
private static int min(int currentSum, int nextSum) {
    return Math.abs(GOAL_NUMBER - currentSum) < Math.abs(GOAL_NUMBER - nextSum) ? currentSum : nextSum;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
