# :page_facing_up: 대회 or 인턴 [백준 2875번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232875/2875.java)
:link: [[문제 풀러가기]](https://www.acmicpc.net/problem/2875)
***
__그리디 알고리즘 분류에 있는 문제입니다.__ 문제의 입력은 대회에 참가하는 인원인 **여학생 M명**과 **남학생 N명**이 주어지고 **인턴에 참여해야 하는 인원 K명**이 주어집니다. 인턴쉽에 K명은 **반드시 참가**해야 하기 때문에 대회에 참여하는 인원은 **인턴쉽에 참가해야하는 인원을 뺀 나머지가 참가할 수 있습니다.** 문제의 조건을 나열해보면 다음과 같습니다.

1. 대회는 **팀으로 참가 가능 하며 여자 2명, 남자 1명으로 구성**되어야 한다.
2. 대회에 참가하려는 인원중 K명은 **반드시 인턴쉽에 참가하여야 한다.**
3. 인턴쉽에 참가하는 인원은 **대회를 참여할 수 없다.**
4. 대회에 참가할 수 있는 **최대 팀의 개수를 구한다**

**문제 풀이는 다음과 같이 할 수 있습니다.** 먼저 **인턴에 참여하는 인원은 남, 여 구분이 없습니다.** 따라서 어느쪽에서 인원을 빼도 상관이 없습니다. 즉, **전체 인원에서 만들 수 있는 최대한의 팀을 만들면서 인턴쉽에 참가할 수 있는 사람의 수만 남겨놓으면 됩니다.**  
조금 더 풀어써보면 전체인원(남 + 여)에서 먼저 팀을 구성할 수 있는지 확인합니다.(여자 2, 남자 1) 팀 구성이 가능하다면 **전체 인원에서 팀 인원(총 3명)을 제외하더라도 인턴쉽에 보낼 수 있는 사람이 있는지 확인합니다.** 만약 팀을 구성했을 때 인턴쉽에 보낼 사람이 부족하다면 팀은 구성될 수 없습니다. **반대로 인턴쉽에 보낼 인원이 충분 하다면 팀을 생성하면 됩니다.**

글보단 소스코드를 보면 이해하기 쉽습니다.

### __:seedling: main 함수__
문제의 조건을 입력받고 solve함수를 호출합니다.
```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int femaleNum = Integer.parseInt(input[0]);
    int maleNum = Integer.parseInt(input[1]);
    int needInternNum = Integer.parseInt(input[2]);

    int team = solve(femaleNum, maleNum, needInternNum);
    System.out.println(team);
}
```
### __:seedling: solve 함수__
최대한 만들 수 있는 팀의 개수를 구하는 함수입니다.
```java
private static int solve(int femaleNum, int maleNum, int needInternNum) {
    int team = 0;
    while (femaleNum + maleNum >= needInternNum && femaleNum >= 2 && maleNum >= 1) {
        if (isNotPossibleMakeTeam(femaleNum, maleNum, needInternNum)) break;

        femaleNum-=2;
        maleNum--;

        team++;
    }
    return team;
}
```
### __:seedling: isNotPossibleMakeTeam 함수__
팀이 만들어질 수 있는지 확인하는 함수입니다. 만들어 질 수 없다면 true를 반환합니다.
```java
private static boolean isNotPossibleMakeTeam(int femaleNum, int maleNum, int needInternNum) {
    return ((femaleNum - 2) + (maleNum - 1)) < needInternNum;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
