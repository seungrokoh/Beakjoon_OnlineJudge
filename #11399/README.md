# __:bulb: [BOJ #11399번] (ATM) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2311399/11399.java)
***

문제의 조건을 살펴보면 __가장 작은 running time을 가진 사람__ 먼저 ATM을 이용하는 것이 가장 효과적인 방법입니다.

```java
private static void solve(int[] times) {
    Arrays.sort(times);

    int sum = 0;
    int ans = 0;
    for (int i = 0; i < times.length; i++) {
        sum += times[i];
        ans += sum;
    }

    System.out.println(ans);
}
```
