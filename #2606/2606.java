import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        graph = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }


        for (int i = 1; i <= pair; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        System.out.print(bfs(1) - 1);
    }

    public static int bfs(int node){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (!visited[node]) {
                visited[node] = true;
                count++;

                for (int nextNode : graph[node]) {
                    queue.add(nextNode);
                }
            }
        }
        return count;
    }

}
