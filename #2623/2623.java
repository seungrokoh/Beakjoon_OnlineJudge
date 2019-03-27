import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        int[] inDegree = new int[n];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int nodeCnt = Integer.parseInt(input[0]);

            // 그래프의 시작점
            int prev = Integer.parseInt(input[1]);
            for (int j = 1; j < nodeCnt; j++) {
                int curr = Integer.parseInt(input[j + 1]);
                // 들어오는 간선의 개수를 늘려준다
                inDegree[curr - 1]++;
                adj[prev - 1].add(curr - 1);
                prev = curr;
            }
        }
        solve(adj, inDegree);
    }

    private static void solve(LinkedList<Integer>[] adj, int[] inDegree) {
        LinkedList<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 들어오는 간선의 개수가 0개인 경우 queue에 넣어줌
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        // 위상정렬
        for (int i = 0; i < n; i++) {
            // n개의 노드를 모두 방문하지 못한다면 위상정렬 불가능
            if (queue.isEmpty()) {
                System.out.println(0);
                return;
            }

            int curr = queue.poll();
            // queue에서 꺼내는 순서가 위상정렬 결과
            result.add(curr + 1);
            for (int next : adj[curr]) {
                if (--inDegree[next] == 0) queue.add(next);
            }
        }

        for (int next : result) {
            System.out.println(next);
        }
    }
}
