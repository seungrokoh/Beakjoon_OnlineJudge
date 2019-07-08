# :page_facing_up: 소음 [백준 2935번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232935/2935.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/2935)
***

# __문제 풀이__

문제는 **문자열 처리를 통해 해결하였습니다.** 주어지는 수의 최대 자리수가 100자리수 이기 때문에 BigInteger를 통해 해결 할 수도 있지만 문자열이 더 쉽게 접근 할 수 있을 거 같아 문자열로 해결하였습니다. 먼저 문제의 조건을 살펴보겠습니다.

# __문제 조건__
1. 두 수는 **무조건 10의 제곱꼴로 주어진다.**
2. 연산자는 ' + '와 ' * ' 두 개뿐이다.
3. 수는 **최대 100자리까지 주어진다.**

문제의 조건에서 수는 **최대 100자리까지 주어진다.** 라는 말이 있으므로 int, long 형으로는 숫자를 처리할 수 없습니다. 그렇다면 두 가지 방법이 있는데 **BigInteger를 이용하는 것**과 **문자열을 이용하는 것** 입니다. 이번 풀이는 **문자열로 해결하는 방법에 대해 알아보겠습니다.**

# __문제 접근__
문제 풀이의 키워드를 먼저 살펴보면 **숫자는 무조건 10의 제곱 꼴로 주어지는 것** 입니다. 즉, 주어지는 형태는 무조건 **첫 번째 숫자는 1이고 뒤의 모든 숫자는 0입니다.** 이게 왜 키워드지? 라고 생각하시는 분은 아래 예제를 보면 쉽게 이해하실 수 있습니다.

먼저 곱셈 연산에 대해 살펴보겠습니다. 무조건 두 수 모두 10의 제곱꼴이기 때문에 **어떤 수를 곱해도 두 수의 첫 자리수는 1입니다.** 그리고 다음으로 나오는 0의 개수는 두 수의 뒤에 나오는 0의 개수를 붙이면 답이 나옵니다.

## __곱셈 연산 예제__

    입력
    10000
    *
    100

    결과
    1000000

    접근 방법
    -> "10000" + "00"

위의 예제를 살펴보면 **어차피 두 수의 첫 자리수는 1입니다.** 따라서 첫 번째 수 뒤에 두 번째 수의 0을 쭉 이어 붙이면 원하는 결과를 얻을 수 있습니다. 다음으로 **덧셈 연산 예제를 살펴보겠습니다.**

덧셈 연산의 경우 **작은 수의 길이만큼 큰 수 뒤에 포함되는 형태입니다.** 즉, 10000 + 10의 경우는 10010이 되며 10000에서 **작은 수인 10이 치환(포함) 되는 형태 입니다.** 즉, 큰 수의 뒤에서부터 **작은 수의 길이만큼 위치에 있는 0을 1로 치환하는 형태입니다.**


## __덧셈 연산 예제__

    입력
    10000
    +
    100

    결과
    10100

    접근 방법
    -> "10" + "100"

# __예외 사항__
덧셈의 경우 예외 사항이 발생하는데 **만약 두 수의 길이가 같다면 맨 앞의 수는 2로 바뀌게 됩니다.** 즉 10 + 10의 경우 20의 결괏값이 나와야 합니다. 이 경우 맨 앞을 2로 만든 다음 뒤에 0의 갯수를 붙여주면 됩니다.


글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String num1 = br.readLine();
    String operator = br.readLine();
    String num2 = br.readLine();

    if (num1.length() < num2.length()) {
        String temp = num1;
        num1 = num2;
        num2 = temp;
    }

    System.out.println(solve(num1, operator, num2));
}
```

### __:seedling: solve 함수__

```java
private static String solve(String num1, String oper, String num2) {
    if (oper.equals("+")) return calcPlusOperation(num1, num2);

    return calcMultipleOperation(num1, num2);
}
```

### __:seedling: calcMultipleOperation 함수__

```java
private static String calcMultipleOperation(String num1, String num2) {
    return num1 + num2.substring(1);
}
```

### __:seedling: calcPlusOperation 함수__

```java
private static String calcPlusOperation(String num1, String num2) {
    if (num1.length() == num2.length())
    return "2" + num1.substring(1);

    return num1.substring(0, num1.length() - num2.length()) + num2;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
