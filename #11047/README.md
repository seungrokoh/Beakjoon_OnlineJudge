# __:bulb: [BOJ #11047번] (동전 0) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2311047/11047.java)
***

##### __:seedling: 문제 풀이__

전형적인 `그리디 알고리즘` 문제라고 할 수 있습니다. 문제의 조건에서 친절하게도 __동전의 가치가 오름차순으로 주어진다__ 라고 말하고 있습니다. 또 중요한 점이 있는데 __A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수__ 라고 명시되어 있습니다. `그리디 알고리즘`을 적용하기 위해선 __반드시 큰쪽은 작은 쪽의 배수__ 여야만 가능합니다.

```java
while(target != 0){
    ans += target / coins[index];
    target %= coins[index--];
}
```
