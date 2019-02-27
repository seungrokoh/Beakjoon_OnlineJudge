import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visitedDfs, visitedBfs;
    static StringBuilder dfsBuilder, bfsBuilder;
    static LinkedList<Integer>[] nodes;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int nodeCnt = Integer.parseInt(input[0]);
        int edgeCnt = Integer.parseInt(input[1]);
        int startNode = Integer.parseInt(input[2]);
        nodes = new LinkedList[nodeCnt + 1];
        for (int i = 0; i <= nodeCnt; i++) {
            nodes[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < edgeCnt; i++) {
            String[] val = br.readLine().split(" ");

            int node1 = Integer.parseInt(val[0]);
            int node2 = Integer.parseInt(val[1]);

            nodes[node1].add(node2);
            nodes[node2].add(node1);

            Collections.sort(nodes[node1]);
            Collections.sort(nodes[node2]);
        }

        visitedDfs = new boolean[nodeCnt + 1];
        visitedBfs = new boolean[nodeCnt + 1];
        dfsBuilder = new StringBuilder();
        bfsBuilder = new StringBuilder();

        dfs(startNode);
        bfs(startNode);
        System.out.println(dfsBuilder);
        System.out.println(bfsBuilder);
    }

    public static void dfs(int node) {
        if (visitedDfs[node]) return;

        visitedDfs[node] = true;
        dfsBuilder.append(node).append(" ");
        for (int nextNode : nodes[node] ) {
            dfs(nextNode);
        }
    }

    public static void bfs(int node){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (!visitedBfs[node]){
                visitedBfs[node] = true;
                bfsBuilder.append(node).append(" ");

                for (int nextNode : nodes[node]) {
                    queue.add(nextNode);
                }
            }
        }
    }
}
