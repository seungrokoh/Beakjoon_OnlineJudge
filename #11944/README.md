# :page_facing_up: NN [백준 11944번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231194/11944.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/11944)
***
문제는 매우 간단하다. N을 N번 출력하는 프로그램을 작성하여라. **다만, 답이 길어지는 경우 답의 앞 M자리만 출력한다.**

다만 길어지는 경우는 N을 N번 출력했을 때 길이가 M보다 클 경우입니다. 문제에서 얘기한 것 처럼 매우 간단한 문제였습니다.

### __문제 풀이__

1. N을 N번 더해준 문자열 NN을 구한다.
2. NN의 길이가 M보다 작다면 NN 출력
3. NN의 길이가 M보다 크다면 NN의 subString(0, m) 출력

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    String nnString = getNNString(n);

    System.out.println(solve(nnString, m));

}
```

### __:seedling: solve 함수__

```java
private static String solve(String nnString, int m) {
    return nnString.length() > m ? nnString.substring(0, m) : nnString;
}
```
### __:seedling: getNNString 함수__
NN 문자열을 구하는 함수입니다.
```java
private static String getNNString(int n) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
        builder.append(n);
    }
    return builder.toString();
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
