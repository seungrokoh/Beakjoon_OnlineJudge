# :page_facing_up: 에라토스테네스의 체 [백준 2960번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232960/2960.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/2960)
***
# __문제 해설__

문제에서 에라토스테네스의 체를 구현하는 방법을 자세하게 설명해 주었으므로 조건을 그대로 코드로 구현할 수 있는지에 대한 문제입니다. 먼저 문제의 조건을 살펴보겠습니다.

## __문제 조건__

1. 2부터 N부터 모든 정수를 적는다.
2. **아직 지우지 않은 수 중 가장 작은수**를 찾는다. 이것을 P라 하고, 이 수는 소수이다.
3. **P를 지우고**, 아직 **지우지 않은 P의 배수를 크기 순서대로 지운다.**
4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.

에라토스테네스의 체는 소수를 빠르게 구할 수 있는 알고리즘 중 하나입니다. 문제가 일반적인 소수를 구하는 것과 다른 것중 하나는 **소수인 P도 지우기 때문에 소수 또한 지워진 수에 포함 시켜야 합니다.** 또한 지워지는 수가 중복되기 때문에 중복되서 지워지는 수에 대한 처리를 해야합니다.

문제에 주어진 조건을 그대로 코드로 구현하는 것이기 때문에 글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    System.out.println(solve(n, k));
}
```

### __:seedling: solve 함수__
K번째 지워지는 수를 찾아내는 함수입니다.
```java
private static int solve(int n, int k) {
    int cnt = 0;
    boolean[] visit = new boolean[n + 1];

    for (int i = 2; i <= n; i++) {
        for (int j = i; j <= n; j += i) {
            if (!visit[j]) {
                cnt++;
                visit[j] = true;
            }

            if (cnt == k) return j;
        }
    }

    return -1;
}
```

***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
