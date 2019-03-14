import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer>[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());


        nodes = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new LinkedList<>();
        }
        String[] input = br.readLine().split(" ");
        int person1 = Integer.parseInt(input[0]);
        int person2 = Integer.parseInt(input[1]);

        int edgeCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < edgeCnt; i++) {
            String[] nodeNum = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodeNum[0]);
            int node2 = Integer.parseInt(nodeNum[1]);

            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }

        int result = solve(person1, person2);
        System.out.print(result);
    }

    private static int solve(int person1, int person2) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(person1, 0));
        visited[person1] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int nodeNum = curNode.nodeNum;
            int relCnt = curNode.relCnt;

            if (nodeNum == person2) {
                return relCnt;
            }

            for (int nextNode : nodes[nodeNum]) {
                if (!visited[nextNode]) {
                    queue.add(new Node(nextNode, relCnt + 1));
                    visited[nextNode] = true;
                }
            }
        }
        return -1;
    }

    static class Node {
        public int nodeNum, relCnt;

        public Node(int nodeNum, int relCnt) {
            this.nodeNum = nodeNum;
            this.relCnt = relCnt;
        }
    }
}
