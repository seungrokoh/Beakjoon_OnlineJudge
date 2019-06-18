# :page_facing_up: 수들의 합 [백준 1789번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231789/1789.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1789)
***
# __문제 해설__

문제는 **for문을 이용하여 해결하였습니다.** 문제를 처음 봤을 때 어려워 보일 수 있지만 조금만 쉽게 생각하면 해결하기 쉽습니다. 먼저 문제의 조건을 살펴보겠습니다.

### __문제 조건__
    서로 다른 N개의 자연수의 합이 S라고 할 때 자연수 N의 최댓값을 구하여라.

즉, **가장 많은 자연수를 사용해서 S를 만들어라** 라고 이야기 하는 것과 같습니다. 문제의 예제를 보면 **S가 200**이라고 주어져 있는데 200을 만들 수 있는 가지수는 아래와 같습니다.

    1 + 199
    1 + 2 + 197
    1 + 2 + 3 + 194
    ...

문제의 풀이는 가장 많은 수를 사용해야 하기 때문에 **1부터 더해가면서 주어진 S를 넘지 않는 선까지 모두 더했을 때 마지막 더한 값이 됩니다.**

여기서 주의해야 할 점은 **1부터 모든 수를 더했을 때 주어진 S보다 커질 때 입니다.** 만약 모든 수를 더했을 때 주어진 S보다 크다면 N까지 더한 수에서 S를 만들기 위해 **어떤 자연수 하나를 빼면 됩니다.**

### __예제 1__
    주어진 S = 50
    1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55

    즉, 만들어진 수는 55이기 때문에 50을 만들기 위해선 모두 더한 수에서 5만 빼주면 50을 만들 수 있다.

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    long n = Long.parseLong(br.readLine());

    System.out.println(solve(n));
}
```

### __:seedling: solve 함수__
주어진 n을 만들 수 있는 최대 자연수 N을 구하는 함수입니다.
```java
static int solve(long n) {
    long sum = 0;
    int addNum = 0;
    while(n >= sum) {
        sum += (++addNum);
    }

    return sum == n ? addNum : addNum - 1;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
