import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int row, col;
    public static void main(String[] args) throws IOException {
        String[] mapSize = br.readLine().split(" ");
        // mapSize
        row = Integer.parseInt(mapSize[1]);
        col = Integer.parseInt(mapSize[0]);

        int[][] map = new int[row][col];
        boolean[][] visit = new boolean[row][col];
        // 초기 상태에 익은 토마토들을 저장
        List<Point> start = new ArrayList<>();

        // 익혀야 하는 토마토들
        int ans = 0;
        for (int i = 0; i < row; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                int val = Integer.parseInt(input[j]);
                if (val == 1){
                    start.add(new Point(i, j));
                } else if (val == 0) {
                    ans++;
                }
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 토마토가 처음부터 다 익어 있다면 return 0
        if (ans == 0) {
            System.out.print(0);
            return;
        }

        int result = searchMap(map, start, visit) == ans ? max(map) : -1;
        System.out.print(result);
    }

    static boolean safeMap(int x, int y){
        return (x >= 0 && x < row) && (y >= 0 && y < col);
    }

    static int searchMap(int[][] map, List<Point> start, boolean[][] visit) {
        int cnt = 0;
        // 동, 남, 서, 북
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Point> queue = new LinkedList<>();

        for (Point item : start) {
            queue.add(item);
            visit[item.x][item.y] = true;
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                if (safeMap(point.x + dx[i], point.y + dy[i]) && map[point.x + dx[i]][point.y + dy[i]] == 0 && !visit[point.x + dx[i]][point.y + dy[i]]){
                    cnt++;
                    map[point.x + dx[i]][point.y + dy[i]] = map[point.x][point.y] + 1;
                    visit[point.x + dx[i]][point.y + dy[i]] = true;
                    queue.add(new Point(point.x + dx[i], point.y + dy[i]));
                }
            }
        }

        return cnt;
    }

    static int max(int[][] map){
        int max = map[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        return max - 1;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

