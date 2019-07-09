# :page_facing_up: 홀수 [백준 2576번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232576/2576.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/2576)
***
매우 간단한 문제입니다. **반복문과 비교연산으로 문제를 해결할 수 있습니다.** 먼저 문제의 조건을 살펴보겠습니다.

# __문제 조건__
1. 총 7개의 자연수가 주어진다.
2. 주어진 자연수 중 **홀수의 합을 구한다.**
3. **홀수 중 가장 작은 값을 구한다.**
4. 만약 홀수가 없다면 -1을 출력한다.

# __문제 접근__
주어지는 **자연수가 홀수라면** 합을 저장하는 변수에 저장함과 동시에 가장 작은 값인지 확인하면 문제를 해결할 수 있습니다.


글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
// 전역변수
private static final int MAX_SIZE = 7;

public static void main(String[] args) throws IOException {
    int[] numbers = getNumbers();
    System.out.println(solve(numbers));
}
```

### __:seedling: solve 함수__

```java
// 전역변수
private static String solve(int[] numbers) {
    int sum = 0;
    int minOddNum = Integer.MAX_VALUE;
    for (int i = 0; i < MAX_SIZE; i++) {
        if (numbers[i] % 2 == 1) {
            sum += numbers[i];
            minOddNum = Math.min(minOddNum, numbers[i]);
        }
    }

    return sum > 0 ? String.format("%d\n%d", sum, minOddNum) : "-1";
}
```

### __:seedling: getNumbers 함수__

```java
// 전역변수
private static int[] getNumbers() throws IOException {
    int[] temp = new int[MAX_SIZE];
    for (int i = 0; i < MAX_SIZE; i++) {
        temp[i] = Integer.parseInt(br.readLine());
    }
    return temp;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
