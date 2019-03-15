import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int width = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            char[][] map = new char[height][width];

            for (int h = 0; h < height; h++) {
                char[] in = br.readLine().toCharArray();
                for (int w = 0; w < width; w++) {
                    map[h][w] = in[w];
                }
            }

            System.out.println(solve(map));

        }

    }

    private static String solve(char[][] map) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int row = map.length;
        int col = map[0].length;

        int move = 0;

        Queue<Position> fire = new LinkedList<>();
        Queue<Position> person = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == '*') {
                    fire.add(new Position(i, j));
                }
                if (map[i][j] == '@') {
                    person.add(new Position(i, j));
                }
            }
        }


        while (!fire.isEmpty() || !person.isEmpty()) {

            // 불의 움직임
            int size = fire.size();
            for (int cycle = 0; cycle < size; cycle++) {
                Position position = fire.poll();

                for (int i = 0; i < dx.length; i++) {
                    int x = position.x + dx[i];
                    int y = position.y + dy[i];
                    if ((x >= 0 && x < row) && (y >= 0 && y < col) && (map[x][y] == '.' || map[x][y] == '@')) {
                        fire.add(new Position(x, y));
                        map[x][y] = '*';
                    }
                }
            }


            // 사람의 움직임

            int personSize = person.size();

            if (personSize != 0) {
                for (int n = 0; n < personSize; n++) {
                    Position position = person.poll();

                    for (int i = 0; i < dx.length; i++) {
                        int x = position.x + dx[i];
                        int y = position.y + dy[i];
                        try {
                            if (map[x][y] == '.') {
                                person.add(new Position(x, y));
                                map[x][y] = '@';
                            }
                        } catch (Exception e) {
                            return String.valueOf(move + 1);
                        }
                    }
                }
                move++;
            } else {
                return "IMPOSSIBLE";
            }

        }

        return "IMPOSSIBLE";

    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
