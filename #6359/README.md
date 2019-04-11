# __:bulb: [BOJ #6359] (만취한 상범) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%236359/6359.java)
***

문제는 `다이나믹 프로그래밍`으로 분류되어 있지만 도저히.. 다이나믹으로는 생각이 나질 않아서 `야매?`로 풀었다.

먼저 모든 방의 문의 상태를 나타내는 `boolean[] stateOfRoom`을 정의한다. 각 index는 방의 번호이며 `false`일 경우 문이 열려 있다고 가정한다.

문제를 보면 각 방의 번호의 `배수가 되는 방의 문`을 열고 닫는 문제이므로 `2중 for문`을 돌며 방 문의 상태를 바꿔주면 되는 쉬운문제다. 여기서 굳이 if문으로 방의 상태를 확인 할 필요 없이 무조건 `열려 있으면 닫고, 닫혀 있으면 연다`

```java
for (int i = 2; i <= numOfRoom; i++) {
    for (int j = i; j <= numOfRoom; j += i) {
        stateOfRoom[j] = !stateOfRoom[j];
    }
}
```

다이나믹으로 풀게 된다면 다시 업데이트를 해야겠다...
