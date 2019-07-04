# :page_facing_up: 한 줄로 서기 [백준 1138번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231138/1138.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1138)
***
# __문제 해설__

문제는 **그리디 알고리즘을 이용해 해결하였습니다.** 문제의 조건인 키가 1인 사람부터 차례대로 정보가 주어지는 점을 이용하여 그리디 알고리즘을 적용할 수 있습니다. 먼저 문제의 조건을 살펴보겠습니다.

## __문제 조건__

1. 총 N명의 사람수가 주어지며, 키는 1부터 N까지 모두 다르다.
2. 사람들은 **자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다.**
3. **키가 1인 사람부터 차례대로** 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다.
4. 줄을 선 순서대로 키를 출력하라.

문제의 조건에서 **키가 1인 사람부터 차례대로** 주어진다는 점이 가장 중요한 포인트 입니다. 문제에서 요구하는 것은 **내가 설 위치를 정하는 것** 입니다. **자신보다 큰 사람이 왼쪽에 몇 명 있었는지가 주어지기 때문에** 줄을 설 때 맨 왼쪽부터 **자신보다 큰 사람들을 지나 친 다음 비어있는 자리에 선다면 문제를 해결할 수 있습니다.**

문제를 해결할 때 **키가 1인 사람부터 차례대로** 라는 조건이 중요하다고 했는데 그 이유는 **키가 작은 사람부터 자리를 채워나가면 줄에서 비어있는 위치의 개수가 자신보다 큰 사람이 들어갈 수 있는 위치이기 때문입니다.** 따라서 내가 설 수 있는 위치를 고르는 것은 **줄의 가장 왼쪽부터 나보다 큰 사람들의 수 만큼 자리를 비워두고** 이후에 내가 설 수 있는 자리에 서는 것입니다.

***
## __문제 풀이 순서__

    사람의 수 : 4
    왼쪽의 사람 수 : 2 1 1 0

__:seedling:초기 줄의 상태__

줄 위치|0|1|2|3|
|:---:|:---:|:---:|:---:|:---:|
줄을 선 사람의 키|||||

초기 줄의 상태는 아무도 서있지 않은 상태입니다. 여기서 **키가 1인 사람보다 키가 큰 사람이 왼쪽에 2명이 있으므로** 키가 1인 사람은 자신이 설 위치 왼쪽 2개의 자리를 남겨놓아야 합니다. 즉, 0, 1번째 위치를 남겨놓고 2번째 위치에 들어가게 됩니다.

__:seedling:키가 1인 사람 위치__

줄 위치|0|1|2|3|
|:---:|:---:|:---:|:---:|:---:|
줄을 선 사람의 키|||1||

키가 1인 사람의 자리를 정했고 이제 **키가 2인 사람을 세울 차례**입니다. 키가 2인 사람보다 키가 큰 사람이 왼쪽에 1명 있으므로 **자신이 설 위치 왼쪽 1개의 자리를 남겨놓아야 합니다.** 따라서 키가 2인 사람은 위치 1에 설 수 있게 됩니다.

__:seedling:키가 2인 사람 위치__

줄 위치|0|1|2|3|
|:---:|:---:|:---:|:---:|:---:|
줄을 선 사람의 키||2|1||

이제 키가 3인 사람의 자리를 정해야 합니다. **키가 3인 사람보다 키가 큰 사람이 왼쪽에 1명이 있으므로 0번째 위치에는 설 수 없으며 비워두어야 합니다.** 하지만 1, 2번째 자리에는 이미 다른 사람이 서 있는 상태이므로 건너뛰어 3번째 위치에 설 수 있게 됩니다.

__:seedling:키가 3인 사람 위치__

줄 위치|0|1|2|3|
|:---:|:---:|:---:|:---:|:---:|
줄을 선 사람의 키||2|1|3|

마지막으로 키가 4인 사람은 자신보다 큰 사람이 0명 이므로 가장 앞에 설 수 있게 됩니다.

__:seedling:키가 4인 사람 위치__

줄 위치|0|1|2|3|
|:---:|:---:|:---:|:---:|:---:|
줄을 선 사람의 키|4|2|1|3|

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    int numOfPerson = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");


    solve(numOfPerson, input);
}
```

### __:seedling: solve 함수__
조건에 맞는 위치를 찾아 줄을 세우는 함수 입니다.
```java
private static void solve(int numOfPerson, String[] input) {
    int[] line = new int[numOfPerson];

    for (int i = 0; i < numOfPerson; i++) {
        int left = Integer.parseInt(input[i]);
        int position = searchPosition(line, left, numOfPerson);
        line[position] = i + 1;
    }

    printLine(line);
}
```

### __:seedling: searchPosition 함수__
각 사람마다의 조건(자신보다 왼쪽에 키가 큰 사람의 수)에 맞는 위치를 찾아 반환하는 함수입니다.
```java
private static int searchPosition(int[] line, int numOfLeftPerson, int numOfPerson) {
    for (int position = 0; position < numOfPerson; position++) {
        if (numOfLeftPerson == 0 && line[position] == 0) {
            return position;
        }
        if (line[position] == 0) numOfLeftPerson--;
    }
    return -1;
}
```

### __:seedling: printLine 함수__
줄을 출력하는 함수입니다.
```java
private static void printLine(int[] line) {
    for (int i = 0; i < line.length; i++) {
        System.out.print(line[i] + " ");
    }
}
```

***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
