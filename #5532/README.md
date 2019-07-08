# :page_facing_up: 방학 숙제 [백준 5532번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%235532/5532.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/5532)
***

문제는 **단순 반복문을 통해 해결하였습니다.** 문제에서 주어지는 변수들은 다음과 같습니다.

1. 총 방학 일수
2. 풀어야 할 총 국어 페이지
3. 풀어야 할 총 수학 페이지
4. 하루에 풀 수 있는 국어 페이지
5. 하루에 풀 수 있는 수학 페이지

문제 설명에서 주어지는 순서가 **총 수학페이지, 총 국어 페이지, 하루 국어 페이지, 하루 수학 페이지** 이지만, 입력 순서는 **총 국어페이지, 총 수학페이지, 하루 국어 페이지, 하루 수학 페이지** 입니다. 입력 부분만 주의한다면 쉽게 해결할 수 있습니다. ~~(제가 실수를 해서..)~~

각 과목별 **총 풀어야 할 페이지 -= 하루 가능한 페이지**를 반복하며 **방학 일수를 하루씩 빼면 됩니다.** 이때 종료 조건은 **각 풀어야 할 총 페이지 수가 둘 다 0이하가 될 때 입니다.**

글보단 코드를 보면 더 이해하기 쉽습니다.

***

### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    int vacationDays = Integer.parseInt(br.readLine());
    int totalLangPages = Integer.parseInt(br.readLine());
    int totalMathPages = Integer.parseInt(br.readLine());
    int langOneDay = Integer.parseInt(br.readLine());
    int mathOneDay = Integer.parseInt(br.readLine());

    System.out.println(solve(vacationDays, totalMathPages, totalLangPages, langOneDay, mathOneDay));
}
```
### __:seedling: solve 함수__

```java
private static int solve(int vacationDays, int totalMathPages, int totalLangPages, int langOneDay, int mathOneDay) {
    while(totalLangPages > 0 || totalMathPages > 0) {
        totalLangPages -= langOneDay;
        totalMathPages -= mathOneDay;
        vacationDays--;
    }
    return vacationDays > 0 ? vacationDays : 0;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
