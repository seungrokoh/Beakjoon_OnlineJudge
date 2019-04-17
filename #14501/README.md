# __:bulb: [BOJ #14501번] (퇴사) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2314501/14501.java)
***

간단한 dp문제 입니다. 문제의 풀이는 __오늘 상담을 할 때의 비용과 하지 않을 때의 비용을 비교하여 큰 값을 선택하면 됩니다.__

```java
private static int solve(int day) {
    if (day == n + 1) return 0;
    if (day > n + 1) return Integer.MIN_VALUE;

    if (dp[day] > 0) return dp[day];

    return dp[day] = Math.max(solve(day + 1), price[day] + solve(day + needDays[day]));
}
```
