# :page_facing_up: 잃어버린 괄호 [백준 1541번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231541/1541.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1541)
***
문제는 **String배열과 split으로 문자열을 나누어** 문제를 해결하였습니다. 문제를 단순하게 들여다 보면 쉽게 해결할 수 있는 **단순 수학 문제입니다.** `+와- 기호`만 있는 연산에서 **결괏값을 가장 작게 만들기 위한 방법은 `-기호`를 기준으로 괄호를 만드는 것입니다.** 즉 모든 `-기호`를 기준으로 괄호를 만들어 **다음 `-기호`를 만나기 전까지 모든 `+기호`를 `-연산`으로 바꾸는 것**입니다. 아래 예시를 보면 쉽게 이해할 수 있습니다.  

> 문제 예시 : 55-50+40-30+40+30-20

위와 같은 문제가 주어 졌을 때 `-기호`를 기준으로 괄호를 만들면 아래와 같이 만들어 집니다.

> 55 - (50+40) - (30+40+30) - 20

즉, **-기호를 기준으로 괄호를 만들었기 때문에 괄호 안에 있는 모든 + 기호는 -연산으로 바뀌게 됩니다.** 이제 모든 기호가 `-연산`으로 바뀌었으니 모든 값들을 빼주면 최소값을 얻을 수 있습니다. 여기서 주의해야 할 점은 문제의 조건에서 **첫 문자는 무조건 숫자**라고 했으므로 처음 주어지는 문자는 무조건 양수입니다. 따라서 첫 문자는 따로 연산을 해줘야 합니다. 또 다른 예제를 보겠습니다.

> 55+40+50-20+40-20+20

위의 예시를 `-기호` 기준으로 괄호를 만들면 아래와 같습니다.

> 55 + 40 + 50 - (20+40) - (20+20)
> -> 145 - 60 - 40

이처럼 첫 `-기호`를 만나기 전까지는 `+연산`을 하게 됩니다. 따라서 첫 `-기호`를 만나기 전까지 모든 수는 `+연산`을 해줘야 합니다. 이 점을 주의하여 문제를 해결할 때 **문자열 배열에서 0번째 원소는 `-연산`이 아닌 `+연산`으로 처리해줘야 문제를 해결할 수 있습니다.**

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__
주어진 문자열을 입력받고 `-기호`를 기준으로 문자열을 나눈 뒤 연산을 담당하는 calc함수를 호출합니다.
```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split("\\-");

    int minResult = 0;

    for (int i = 0; i < input.length; i++) {
        int calcNum = calc(input[i]);

        if (i == 0) calcNum *= -1;
        minResult -= calcNum;
    }

    System.out.println(minResult);
}
```

### __:seedling: calc 함수__
주어진 문자열에서 숫자만 추출하여 모두 더해주는 연산을 담당합니다.
```java
private static int calc(String str) {
    String[] subNums = str.split("\\+");
    int result = 0;

    for (String item : subNums) {
        result += Integer.parseInt(item);
    }
    return result;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
