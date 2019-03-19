import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        char[][] map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String in = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = in.charAt(j);
            }
        }

        System.out.println(solve(map));
    }

    private static String solve(char[][] map) {
        int row = map.length;
        int col = map[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Point> waterQueue = new LinkedList<>();
        Queue<Point> gosmQueue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == '*') {
                    // 물
                    waterQueue.add(new Point(i, j));
                } else if (map[i][j] == 'S') {
                    // 고슴도치
                    gosmQueue.add(new Point(i, j));
                }
            }
        }


        int time = 0;
        while (!waterQueue.isEmpty() || !gosmQueue.isEmpty()) {

            // 물의 움직임
            int waterSize = waterQueue.size();
            for (int size = 0; size < waterSize; size++) {
                Point water = waterQueue.poll();
                for (int i = 0; i < dx.length; i++) {
                    int x = water.x + dx[i];
                    int y = water.y + dy[i];
                    if (safe(x, y, row, col) && (map[x][y] == '.' || map[x][y] == 'S')) {
                        // 물이 이동 가능 할 때
                        waterQueue.add(new Point(x, y));
                        map[x][y] = '*';
                    }
                }
            }

            // 고슴도치의 움직임
            int gosmSize = gosmQueue.size();
            if (gosmSize != 0) {
                for (int size = 0; size < gosmSize; size++) {
                    Point gosm = gosmQueue.poll();
                    for (int i = 0; i < dx.length; i++) {
                        int x = gosm.x + dx[i];
                        int y = gosm.y + dy[i];
                        if (safe(x, y, row, col)) {
                            if (map[x][y] == 'D') {
                                return String.valueOf(time + 1);
                            }
                            if (map[x][y] == '.') {
                                gosmQueue.add(new Point(x, y));
                                map[x][y] = 'S';
                            }
                        }
                    }
                }
            } else {
                // 고슴이 비었을 때
                return "KAKTUS";
            }
            time++;
        }

        return "KAKTUS";
    }

    static boolean safe(int x, int y, int row, int col) {
        return (x >= 0 && x < row) && (y >= 0 && y < col);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
