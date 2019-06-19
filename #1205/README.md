# :page_facing_up: 등수 구하기 [백준 1205번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231205/1205.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1205)
***
# __문제 해설__

문제는 **반복문을 이용해 해결하였습니다.** `이분탐색(Binary Search)`으로도 해결할 수 있으므로 따로 시도해보시면 좋습니다.

문제를 해결할 때 조건이 생각보다 많기 때문에 잘 살펴보아야 합니다. 먼저 문제의 조건을 살펴보겠습니다.

### __문제 조건__
1. 이미 게임을 하고 얻은 점수 N개가 **비오름차순으로 주어진다.**
2. 랭킹 리스트에 등록될 수 있는 점수는 P개 이다.
3. 등수는 위에서부터 몇 번쨰 있는 점수인지로 결정하지만 **같은 점수가 있을 때에는 그러한 점수의 등수 중에 가장 작은 등수가 된다.**
4. 새로운 점수의 등수를 구하여라. **(랭킹 리스트안에 들어갈 수 없다면 -1을 출력한다.)**

여기서 살펴보아야 할 첫 번째 사항은 **조건 1에서 비오름차순으로 주어진다.** 라고 이야기 했으므로 주어지는 점수 N개는 **내림차순으로 주어집니다.** 또한 **조건 3**의 말을 조금 풀어보면 **같은 점수일 경우 같은 등수가 된다** 라는 말과 같습니다. 예제에서 친절하게 설명하였습니다.

그렇다면 문제를 해결할 때 예외사항을 처리해야하는데 처리해야 할 사항은 아래와 같습니다.

### __예외 사항__

1. 새로운 점수가 랭킹리스트 안에 들지 못하는 경우 (return -1)
2. 새로운 점수가 랭킹리스트 안에 들지만 맨 마지막인 경우
3. 이미 게임을 하고 주어진 점수가 0개인 경우 (N == 0)

**예외 1번의 경우** 주어진 점수의 P번째 점수가 **새로 주어진 점수보다 크다면** 랭킹리스트에 들 수 없기 때문에 -1을 반환해야 합니다.  
**예외 2번의 경우** 새로운 점수가 들어 갈 자리의 **이전 점수가 새로운 점수와 같다면** 이전 점수와 랭킹이 같아지며, **다를 경우 들어갈 수 있는 자리의 index값과 같습니다.**  
**예외 3번의 경우** N이 0일 경우 입력을 받을 필요가 없기 때문에 따로 예외 처리를 해줘야 합니다.  

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int newScore = Integer.parseInt(input[1]);
    int limitNum = Integer.parseInt(input[2]);

    System.out.println(solve(n, limitNum, newScore));
}
```

### __:seedling: solve 함수__
새로운 점수의 등수를 계산하는 함수입니다.
```java
private static int solve(int n, int limitNum, int newScore) throws IOException {
    if (n == 0) return 1;

    // N이 0이 아닐 경우만 입력받음
    int[] score = getScores(n);

    // 예외 1 처리
    if (n >= limitNum && score[limitNum - 1] >= newScore) return -1;

    int index = 0;
    int currentRank = 0;
    int preScore = Integer.MAX_VALUE;

    while (index < n) {
        if (score[index] < newScore) break;
        if (preScore > score[index]) {
            currentRank = index + 1;
            preScore = score[index];
        }

        index++;
    }

    return preScore == newScore ? currentRank : index + 1;
}
```

### __:seedling: getScores 함수__
N이 0일 경우를 대비해야 하기 때문에 입력을 따로 분리하였습니다.
```java
private static int[] getScores(int n) throws IOException {
    String[] inputScore = br.readLine().split(" ");
    int[] score = new int[n];
    for (int i = 0; i < n; i++) {
        score[i] = Integer.parseInt(inputScore[i]);
    }
    return score;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
