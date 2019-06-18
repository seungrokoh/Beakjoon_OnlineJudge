# :page_facing_up: 30 [백준 10610번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2310610/10610.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/10610)
***
문제는 **각 수(0~9)의 개수**를 이용하여 문제를 해결하였습니다. 먼저 30의 배수가 될 수 있는 조건에 대해 살펴보면 다음과 같습니다.  

첫 번째로, **만들어지는 수의 맨 마지막은 무조건 0으로 끝나야 합니다.** 예를 들면, `30, 60, 210`등 모든 수는 0으로 끝이나기 때문에 **0은 적어도 1개 이상 필요합니다.** 따라서 주어진 숫자에 0이 적어도 1개이상 포함되어야 합니다.  

두 번째로, **3의 배수이면서 10의 배수여야 합니다.** 첫 번째 조건에서 0으로 끝나야 하는 조건이 10의 배수임을 나타냅니다. 따라서 2번째 조건에서는 3의 배수인지만 확인하면 됩니다. 여기서 **3의 배수인지 확인**해야하는데 3의 배수를 나열해보면 다음과 같습니다.

    3, 6, 9, 12, 15, 18, 21, ..., 120, 123, 126, ...

3의 배수들을 살펴보면 **공통점**이 보이는데 바로 **각 자리수를 모두 합친 값은 무조건 3으로 나누어 떨어진다**는 점입니다. 따라서 만들 수 있는 최대의 수를 만들고 **3으로 나누어 떨어지는지 확인**하면 문제를 해결할 수 있습니다.

문제를 해결하기 위해 먼저 **주어진 숫자에 포함 된 0~9의 개수를 배열에 저장**합니다. 이 후 **가장 큰 숫자(9)부터 차례대로 이어나가** 최대 숫자를 만들 뒤 **30의 배수가 될 수 있는지 검사**합니다.

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
