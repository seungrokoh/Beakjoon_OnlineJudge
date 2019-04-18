import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(true){
            String[] input = br.readLine().split(" ");
            int width = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);

            if (width == 0 && height == 0) break;

            int[][] map = new int[height][width];

            for (int i = 0; i < height; i++) {
                String[] mapStatus = br.readLine().split(" ");
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(mapStatus[j]);
                }
            }
            System.out.println(solve(map, width, height));
        }
    }

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

    // 인접한 섬들을 찾는 함수
    private static int searchAdjacentIsland(int[][] map, int curX, int curY, int width, int height, boolean[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        // 8가지 방향
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

    // 맵을 벗어나는지 확인하는 함수
    public static boolean isSafe(int x, int y, int width, int height) {
        return (x >= 0 && x < height) && (y >= 0 && y < width);
    }
    public static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
