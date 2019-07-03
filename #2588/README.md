# :page_facing_up: 곱셈 [백준 2588번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232588/2588.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/2588)
***
# __문제 해설__

문제는 **단순 구현을 통해 문제를 해결하였습니다.** 정말 간단한 수학 연산을 프로그래밍으로 옮길 수 있는지 물어보는 문제였습니다. 먼저 문제 조건을 보겠습니다.

## __문제 조건__

1. 세 자리수 자연수 2개가 주어진다.
2. 두 자연수의 곱셈 과정에서 나오는 수들을 출력하라.
3. 두 자연수의 곱셈 값을 구하여라.

곱셈의 방식을 모르시는 분은 없다고 생각하겠습니다. **첫 번째 자연수 * 두번째 자연수의 각 자리수**가 각 과정에서 나오는 수들 입니다. 마지막 값은 **첫 번째 자연수 * 두 번째 자연수**를 출력하면 됩니다.

문제를 풀기 위해선 **자연수의 각 자리수를 뽑아낼 수 있는지가** 주요 관건이었습니다.

    * 자연수의 각 자리수 뽑아내기

    temp : 1의 자리수부터 자연수의 자리수를 가져옴

    while(num > 0) {
        int temp = num % 10;
        num /= 10;
    }

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    int num1 = Integer.parseInt(br.readLine());
    int num2 = Integer.parseInt(br.readLine());

    solve(num1, num2);
}
```

### __:seedling: solve 함수__
곱셍 과정에서 나오는 값들과 최종값을 구하는 함수입니다.
```java
private static void solve(int num1, int num2) {
    int temp = num2;
    while(temp > 0) {
        System.out.println(num1 * (temp % 10));
        temp /= 10;
    }
    System.out.println(num1 * num2);
}
```

***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
