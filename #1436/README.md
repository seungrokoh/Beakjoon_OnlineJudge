# :page_facing_up: 영화감독 숌 [백준 1436번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231436/1436.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1436)
***
# __문제 풀이__
문제는 **String 클래스의 contains를 이용해 해결하였습니다.** 먼저 문제의 조건을 살펴보겠습니다.

# __문제 조건__
1. 종말의 숫자란 어떤 수에 **6이 적어도 3개이상 연속으로 들어가는 수를 말한다.**
2. 첫 번째 종말의 숫자는 666이다.
3. N번째 종말의 숫자를 구하여라.

# __문제 접근__
처음 문제를 보았을 때 **수가 나타내는 규칙을 찾아보자** 라고 생각하였습니다. 하지만 마땅한 규칙이 나타나지 않아서 패스. **두 번째 생각은** 6이 들어가는 숫자를 카운팅해서 6이 3개 이상 들어가는지 확인하는 방법이었습니다. **하지만 연속으로 나타나는지에 대한 검사를 해야하기 때문에 패스.** ~~(귀찮아서..)~~ 결국 **String 클래스에 구현되어 있는 contains함수를 이용해 "666"을 포함하는 숫자면 카운팅** 해주는 방법으로 해결하였습니다.  

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__

```java
private static final String INFIX_STR = "666";
public static void main(String[] args) throws IOException {
    int num = Integer.parseInt(br.readLine());
    System.out.println(solve(num));
}
```
### __:seedling: solve 함수__

```java
private static int solve(int num) {
    int cnt = 0;
    int index = 0;
    while(cnt != num) {
        if (String.valueOf(++index).contains(INFIX_STR)) cnt++;
    }
    return index;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
