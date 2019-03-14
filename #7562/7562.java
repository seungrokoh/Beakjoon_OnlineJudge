import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //static boolean[][] visited;
    static int size;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < n; testCase++) {
            size = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[size][size];

            String[] curKnight = br.readLine().split(" ");
            String[] solvePosition = br.readLine().split(" ");

            int curX = Integer.parseInt(curKnight[0]);
            int curY = Integer.parseInt(curKnight[1]);

            int solveX = Integer.parseInt(solvePosition[0]);
            int solveY = Integer.parseInt(solvePosition[1]);

            int result = solve(new Knight(curX, curY, 0), solveX, solveY, visited);
            System.out.println(result);
        }
    }

    static public int solve(Knight knight, int solveX, int solveY, boolean[][] visited) {
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        Queue<Knight> queue = new LinkedList<>();
        queue.add(knight);
        visited[knight.x][knight.y] = true;

        while (!queue.isEmpty()) {
            Knight curKnight = queue.poll();
            int x = curKnight.x;
            int y = curKnight.y;

            if (x == solveX && y == solveY) {
                return curKnight.moveCnt;
            }

            // 이동 가능 8방향 확인하고 queue에 넣기
            for (int i = 0; i < dx.length; i++) {
                if (isSafe(curKnight.x + dx[i], curKnight.y + dy[i]) && !visited[curKnight.x + dx[i]][curKnight.y + dy[i]]) {
                    queue.add(new Knight(curKnight.x + dx[i], curKnight.y + dy[i], curKnight.moveCnt + 1));
                    visited[curKnight.x + dx[i]][curKnight.y + dy[i]] = true;
                }
            }
        }
        return -1;
    }

    static boolean isSafe(int x, int y){
        return (x >= 0 && x < size) && (y >= 0 && y < size);
    }
    static class Knight {
        int x, y, moveCnt;

        public Knight(int x, int y, int moveCnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
        }
    }
}
