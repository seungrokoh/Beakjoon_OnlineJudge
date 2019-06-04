import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    private static boolean isPossibleTravel(int[][] map, int[] cities) {
        int len = cities.length;
        for (int i = 0; i < len - 1; i++) {
            int fromIdx = cities[i] - 1;
            int toIdx = cities[i + 1] - 1;
            if (!isPossibleRoute(map, len, fromIdx, toIdx)) return false;
        }
        return true;
    }

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

    private static int[] getCities(int m) throws IOException {
        String[] input = br.readLine().split(" ");
        int[] ret = new int[m];
        for (int i = 0; i < m; i++) {
            ret[i] = Integer.parseInt(input[i]);
        }
        return ret;
    }

    private static int[][] getMap(int n) throws IOException {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputMap = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(inputMap[j]);
            }
        }
        return map;
    }
}
