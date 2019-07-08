# :page_facing_up: Mini Fantasy War [백준 12790번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2312790/12790.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/12790)
***
**단순 구현 문제 입니다.** 주어지는 조건과 입력을 이해하고 처리할 수 있으면 쉽게 해결 할 수 있습니다.

문제에서 **단, HP와 MP는 1보다 작은 경우 1로 간주하며, 공격력은 0보다 작은 경우 0으로 간주한다. 방어력은 음수 여부에 상관하지 않는다.** 이 부분을 따로 처리하여 계산하면 쉽게 해결 할 수 있습니다. 저는 **hp, mp를 계산하는 함수, attack을 계산하는 함수, guard를 계산하는 함수를 만들어 base 값들을 설정**한 뒤 문제에서 제시하는 **전투력 = 1 * (HP) + 5 * (MP) + 2 * (공격력) + 2 * (방어력)** 에 대입하여 문제를 해결하였습니다.

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
        String[] input = br.readLine().split(" ");
        System.out.println(calcPower(input));
    }
}
```

### __:seedling: calcPower 함수__

```java
private static int calcPower(String[] input) {
    int baseHp = Integer.parseInt(input[0]);
    int baseMp = Integer.parseInt(input[1]);
    int baseAttack = Integer.parseInt(input[2]);
    int baseGuard = Integer.parseInt(input[3]);

    baseHp = calcPhysical(baseHp, Integer.parseInt(input[4]));
    baseMp = calcPhysical(baseMp, Integer.parseInt(input[5]));
    baseAttack = calcAttack(baseAttack, Integer.parseInt(input[6]));
    baseGuard = calcGuard(baseGuard, Integer.parseInt(input[7]));

    return baseHp + (5 * baseMp) + (2 * baseAttack) + (2 * baseGuard);
}
```

### __:seedling: 각 상태를 계산하는 함수들__

```java
private static int calcGuard(int baseGuard, int additional) {
    return baseGuard + additional;
}

private static int calcAttack(int baseAttack, int additional) {
    int temp = baseAttack + additional;
    return temp >= 0 ? temp : 0;
}

private static int calcPhysical(int basePhysical, int additional) {
    int temp = basePhysical + additional;
    return temp > 0 ? temp : 1;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
