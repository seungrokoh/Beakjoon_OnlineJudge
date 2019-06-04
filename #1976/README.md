# :page_facing_up: 여행 가자 [백준 1976번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231976/1976.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1976)
***
문제는 BFS로 해결하였습니다. 먼저 문제의 조건을 보면 **여행 계획**이 주어지는데 **주어진 모든 도시를 여행할 수 있는지 여부를 판단**하는 문제 입니다. 여기서 확인해야 할 부분은 **중간에 다른 도시를 경유해서 여행을 할 수도 있다는 점**입니다. 문제풀이는 다음과 같이 진행할 수 있습니다.

BFS를 이용해 문제를 해결하였으므로 **한 도시에서 갈 수 있는 모든 도시를 탐색**합니다. 여기서 갈 수 있는 모든 도시를 **큐에 넣습니다.** 그다음 Queue에서 한 원소씩 빼면서 해당 도시에서 갈 수 있는 모든 도시들을 전부 집어 넣습니다. **이렇게하면 처음 도시에서 중간에 다른 도시를 경유해서 갈 수 있는 모든 도시를 확인할 수 있습니다.**

문제를 풀 때 조심해야 할 점은 **모든 도시는 중복이 가능하기 때문에 자기 자신을 갈 수 있다는 점도 고려해야 문제를 해결할 수 있습니다.** 실제로 코드상에는 문제가 없는데 100%쯤 문제가 안풀리는 경우가 있는데 바로 이 문제 때문입니다.


글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__
도시의 수, 여행 계획 도시의 수, 도시 연결 현황, 여행계획을 입력받고 **여행 가능 여부를 판단하는 isPossibleTravel함수를 호출합니다.**
```java
public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[][] map = getMap(n);
    int[] cities = getCities(m);

    if (isPossibleTravel(map, cities)) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
}
```

### __:seedling: isPossibleTravel 함수__
도시 연결 현황과 여행계획을 입력받아 가능한지 여부를 판단하는 함수 입니다.
```java
private static boolean isPossibleTravel(int[][] map, int[] cities) {
    int len = cities.length;
    for (int i = 0; i < len - 1; i++) {
        int fromIdx = cities[i] - 1;
        int toIdx = cities[i + 1] - 1;
        if (!isPossibleRoute(map, len, fromIdx, toIdx)) return false;
    }
    return true;
}
```
### __:seedling: isPossibleRoute 함수__
A도시에서 B도시로 갈 수 있는지 여부를 판단하는 함수입니다. BFS로 구현되어 있습니다.
```java
private static boolean isPossibleRoute(int[][] map, int len, int fromIdx, int toIdx) {
    if (fromIdx == toIdx) return true;

    boolean[] visited = new boolean[len];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(fromIdx);
    visited[fromIdx] = true;

    while (!queue.isEmpty()) {
        int from = queue.poll();
        for (int i = 0; i < len; i++) {
            if (i == toIdx && map[from][i] == 1) {
                return true;
            }
            if (map[from][i] == 1 && !visited[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }
    }
    return false;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
