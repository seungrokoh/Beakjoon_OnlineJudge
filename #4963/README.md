# __:bulb: [BOJ #4963번] (섬의 개수) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%234963/4963.java)
***

__BFS 문제__ 입니다. 현재 주어진 섬(1로 된 지점)에서 8가지 방향을 확인해 섬이 존재한다면 계속해서 탐색하는 방식으로 문제를 해결할 수 있습니다.

##### :seedling: 입력된 map에서 섬의 개수를 찾는 함수
```java
private static int solve(int[][] map, int width, int height) {
    boolean[][] visited = new boolean[height][width];

    int ans = 0;
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (map[i][j] == 1 && !visited[i][j]) {
                ans += searchAdjacentIsland(map, i, j, width, height, visited);
            }
        }
    }

    return ans;
}
```
##### :seedling: 인접한 섬을 찾는 함수
```java
private static int searchAdjacentIsland(int[][] map, int curX, int curY, int width, int height, boolean[][] visited) {
    Queue<Position> queue = new LinkedList<>();
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    queue.add(new Position(curX, curY));
    visited[curX][curY] = true;

    while(!queue.isEmpty()) {
        Position p = queue.poll();

        for (int direction = 0; direction < dx.length; direction++) {
            int newX = p.x + dx[direction];
            int newY = p.y + dy[direction];
            if (isSafe(newX, newY, width, height) && map[newX][newY] == 1 && !visited[newX][newY]) {
                queue.add(new Position(newX, newY));
                visited[newX][newY] = true;
            }
        }
    }
    return 1;
}
```
