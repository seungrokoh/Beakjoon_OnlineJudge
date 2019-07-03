# :page_facing_up: 암호 만들기 [백준 1759번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231759/1759.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1759)
***
# __문제 해설__

문제는 **백 트레킹(Back Tracking)을 이용해 해결하였습니다.** 먼저 문제의 조건을 살펴보며 해결방법을 알아보겠습니다.

## __문제 조건__

1. 암호는 **서로 다른 L개의 알파벳 소문자들로 구성된다.**
2. **최소 한 개의 모음과 최소 두개의 자음으로 구성되어 있다.**
3. 암호를 이루는 **알파벳이 오름차순으로 배열**되어 있다.
4. 주어지는 문자의 종류는 C가지가 있다.
5. **가능한 모든 암호를 구하라**

문제의 조건에서 **알파벳이 오름차순으로 배열** 되어 있다는 점이 문제를 푸는데 조금 쉽게 접근할 수 있게 해줍니다. 암호를 만들 수 있는 모든 경우의 수를 따져가며(DFS) **조건에 부합하는 암호만 출력** 해주면 해결 할 수 있습니다.

## __문제 풀이 순서__

1. 주어진 C가지 문자를 오름차순 정렬한다.
2. 첫 번째 문자부터 **해당 문자를 포함 시켜 암호를 만든경우**와 **포함시키지 않은 암호를 만든 경우** 두 가지를 탐색한다.
3. 만든 암호의 길이가 주어진 L과 같다면 **조건 2에 부합하는지 확인한다.**
4. 조건에 해당한다면 출력하고 함수를 종료한다.

문제의 예시처럼 알파벳이 `a, c, i, s, t, w`로 주어진다면 **첫 번째 문자인 a** 부터 해당 문자를 포함 시켜 암호를 만드는 경우와 포함시키지 않는 경우 두 가지를 생각하며 만듭니다. **여기서 포함시켜 만드는 경우와 포함시키지 않는 경우 두 가지 선택지를 모두 탐색하는 방식을 백 트랙킹이라고 합니다.** 자신이 왔던 길을 다시 되돌아 온 뒤 다른 곳을 향해 이동하는 것입니다.

백 트랙킹은 손으로 직접 써보면서 Function Call이 어떻게 이루어지는지 일일히 확인하면 이해하는데 도움이 많이 됩니다.


## __예제 Function Call 순서__

    주어진 알파벳
    a, c, i, s, t, w

|Function Call 순서|호출 상태|결과|
|:---:|:---:|:---:|
|1|solve(0, "")||
|2|solve(1, a)||
|3|solve(2, ac)||
|4|solve(4, acis)|"acis" 출력 & return|
|5|solve(4, aci)||
|6|solve(5, acit)|"acit" 출력 & return|
|7|solve(5, aci)||
|8|solve(6, aciw)|"aciw" 출력 & return|
|9|solve(6, aci)||
|10|solve(3, ac)||
|11|solve(4, acs)||
|12|olve(5, acst)|"acst" 출력 & return|
|13|solve(5, acs)||
|14|solve(6, acsw)|"acsw" 출력 & return|
|...|...|...|
|...|...|...|

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
// 전역 변수
private static int cryptographyLen;
private static int numOfAlpha;
private static String[] alphas;

public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    cryptographyLen = Integer.parseInt(input[0]);
    numOfAlpha = Integer.parseInt(input[1]);
    alphas = br.readLine().split(" ");

    Arrays.sort(alphas);

    solve(0, "");
}
```

### __:seedling: solve 함수__
가능한 모든 암호조합을 찾아 출력하는 함수입니다.
```java
private static void solve(int index, String ret) {
    if (ret.length() == cryptographyLen) {
        if (isPossible(ret)) {
            System.out.println(ret);
        }
        return;
    }
    if (index >= numOfAlpha) return;

    solve(index + 1, ret + alphas[index]);
    solve(index + 1, ret);
}
```

### __:seedling: isPossible 함수__
주어진 주건 2에 부합하는지 확인하는지 확인하는 함수입니다.
```java
private static boolean isPossible(String ret) {
    int vowel = 0, consonant = 0;
    for (int i = 0; i < ret.length(); i++) {
        if (isVowel(ret.charAt(i))) vowel++;
        else consonant++;
    }

    return vowel >= 1 && consonant >= 2;
}
```

### __:seedling: isVowel 함수__
주어진 문자가 모음인지 확인하는 함수입니다.
```java
private static boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}
```

***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
