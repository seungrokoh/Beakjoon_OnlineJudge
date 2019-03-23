import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] map;
    static int[][] ret;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        map = new int[n + 1][n + 1];
        ret = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        solve();

        output();
    }

    private static void solve() {

        for (int from = 1; from <= n; from++) {
            for (int to = 1; to <= n; to++) {
                bfs(from, to);
            }
        }
    }

    private static void bfs(int from, int to) {
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited[from] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if ((i == to && map[node][i] == 1) || map[node][i] == 1 && map[i][to] == 1) {
                        ret[from][to] = 1;
                        visited[to] = true;
                        return;
                    }

                    if (map[node][i] == 1) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    private static void output(){
        for (int from = 1; from <= n; from++) {
            for (int to = 1; to <= n; to++) {
                System.out.print(ret[from][to] + " ");
            }
            System.out.println();
        }
    }

}
