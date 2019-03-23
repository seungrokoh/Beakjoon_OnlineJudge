import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] node = br.readLine().split(" ");
            int node1 = Integer.parseInt(node[0]);
            int node2 = Integer.parseInt(node[1]);
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        solve();
    }

    private static void solve() {
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i, visited);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();

            for (int nextNode : graph[node]) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}
