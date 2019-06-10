# :page_facing_up: 문자열 [백준 1120번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231120/1120.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1120)
***
문제는 **2중 for문으로 해결하였습니다.** 먼저 문제의 조건 및 접근하는 방법에 관하여 살펴보겠습니다.

문제는 **두 문자열의 길이를 같게 만들고 각 차이를 최소로 만드는게 목적**입니다. 여기서 가장 먼저 생각할 수 있는 방법은 **만약 문자를 추가해야 한다면 앞, 뒤 어디든지 추가**할 수 있으므로 **앞에 추가한다면 Y의 첫 번째 문자**를 X에 추가하고, **뒤에 추가한다면 Y의 마지막 문자**를 X에 추가해서 차이를 최소로 해야겠다~ 라고 생각하신 분들은 **저와 같이 잘못 접근한겁니다.**

문제를 다시 살펴보면 문자열을 알고 싶은게 아니고 **최소 차이만** 알고 싶어합니다. 그렇다면 **X의 앞, 뒤에 추가 할 문자는 어차피 내맘대로 넣는거니 신경쓰지 않아도 됩니다.(물론 같은 문자를 넣겠지만)** 문제의 접근은 아래와 같이 할 수 있습니다.

> 처음 주어진 X가 Y의 **어느 부분에 들어가야 차이가 가장 적은지 확인**한다.

처음 주어진 X는 변경될 수 없으며 Y의 일부분이 될겁니다. 그럼 여기서 차이가 가장 적은 부분을 찾은 뒤 남은 부분은 Y와 같은 문자로 채우면 문제를 해결할 수 있습니다. 이해하기 쉽게 표를 이용해 풀이 해보겠습니다.

### __예제 1__
    문자열 X : abc
    문자열 Y : acdabcab

위와 같이 예제가 주어졌을 때 **문자열 X가 문자열 Y의 어느 부분에 들어가야지 차이를 최소로 할 수 있는지** 확인하는 순서 입니다. 여기서 **차이를 최소로 하기 위해선 같은 문자가 가장 많아야 합니다.**

문자열 Y |a|c|d|a|b|c|a|b
:----:|-|-|-|-|-|-|-|-|-|-
문자열 X |a|b|c|

문자열 Y |a|c|d|a|b|c|a|b
:----:|-|-|-|-|-|-|-|-|-|-
문자열 X ||a|b|c|

문자열 Y |a|c|d|a|b|c|a|b
:----:|-|-|-|-|-|-|-|-|-|-
문자열 X |||a|b|c|

문자열 Y |a|c|d|a|b|c|a|b
:----:|-|-|-|-|-|-|-|-|-|-
문자열 X ||||a|b|c|

문자열 Y |a|c|d|a|b|c|a|b
:----:|-|-|-|-|-|-|-|-|-|-
문자열 X |||||a|b|c|

문자열 Y |a|c|d|a|b|c|a|b
:----:|-|-|-|-|-|-|-|-|-|-
문자열 X ||||||a|b|c|

눈에 보이시지 않나요? 위에서 4 번째 표와 같이 **문자열 X가 문자열 Y의 저 위치에 들어가게 된다면 차이를 최소로 할 수 있습니다.** 여기서 왜? 라는 질문을 한다면 4번째 표와 같은 위치에 문자열 X를 넣고 **남은 부분은 어차피 내맘대로 문자를 추가할 수 있으므로 문자열 Y와 같은 문자를 넣으면 됩니다.**

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    System.out.println(solve(input[0], input[1]));
}
```
### __:seedling: solve 함수__

```java
private static int solve(String str1, String str2) {
    int min = Integer.MAX_VALUE;
    for (int startIndex = 0; startIndex <= str2.length() - str1.length(); startIndex++) {
        int cnt = 0;
        for (int j = 0; j < str1.length(); j++) {
            if (str1.charAt(j) != str2.charAt(startIndex + j)) cnt++;
        }
        if (cnt < min) min = cnt;
    }
    return min;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
