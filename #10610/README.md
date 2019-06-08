# :page_facing_up: 30 [백준 10610번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2310610/10610.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/10610)
***
해설 작성중입니다..

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String inputNum = br.readLine();
    int[] countOfNum = countingOfNum(inputNum);

    System.out.print(solve(countOfNum));
}
```

### __:seedling: countingOfNum 함수__
주어진 문자에서 각 숫자들(0~9)의 갯수를 세어주는 함수입니다.
```java
private static int[] countingOfNum(String inputNum) {
    int[] temp = new int[10];
    for (int i = 0; i < inputNum.length(); i++) {
        temp[inputNum.charAt(i) - '0']++;
    }
    return temp;
}
```

### __:seedling: solve 함수__
30의 배수인지 확인하는 함수입니다.
```java
private static String solve(int[] countOfNum) {
    if (countOfNum[0] == 0) return String.valueOf(-1);

    StringBuilder result = new StringBuilder();
    int index = 9;
    int sum = 0;
    while(index >= 0) {
        if (countOfNum[index] > 0) {
            result.append(index);
            countOfNum[index]--;
            sum += index;
        } else {
            index--;
        }
    }

    return sum % 3 == 0 ? result.toString() : String.valueOf(-1);
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
