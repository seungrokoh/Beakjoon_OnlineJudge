import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        input();

        int cluster = bfsSolve();
        int[] houseCntArr = new int[cluster];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    houseCntArr[map[i][j] - 1]++;
                }
            }
        }
        Arrays.sort(houseCntArr);

        System.out.println(cluster);
        for (Integer item : houseCntArr) {
            System.out.println(item);
        }

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        br.close();
    }

    static boolean isSafe(int x, int y){
        return (x >= 0 && x < n) && (y >= 0 && y < n);
    }
    static int bfsSolve() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !visit[i][j]) {
                    searchNearBy(i, j, ++cnt);
                }
            }
        }

        return cnt;
    }

    static void searchNearBy(int x, int y, int mark) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        marking(x, y, mark);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                if (isSafe(p.x + dx[i], p.y + dy[i])) {
                    if (map[p.x + dx[i]][p.y + dy[i]] > 0 && !visit[p.x + dx[i]][p.y + dy[i]]) {
                        queue.add(new Point(p.x + dx[i], p.y + dy[i]));
                        marking(p.x + dx[i], p.y + dy[i], mark);
                    }
                }
            }
        }
    }

    static void marking(int x, int y, int mark){
        visit[x][y] = true;
        map[x][y] = mark;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
