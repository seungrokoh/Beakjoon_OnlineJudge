import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while(true){
            String[] input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]);
            int pNum = Integer.parseInt(input[1]);

            if (t == 0 && pNum == 0) {
                return;
            }
            int[] rank = new int[10001];

            // 랭킹 취합
            for (int i = 0; i < t; i++) {
                String[] info = br.readLine().split(" ");
                for (int j = 0; j < pNum; j++) {
                    int index = Integer.parseInt(info[j]);
                    rank[index]++;
                }
            }

            printPlayer(rank);

            System.out.println();

        }


    }
    static void printPlayer(int[] rank){
        PriorityQueue<Player> pQueue = new PriorityQueue<>(new PlayerComp());

        ArrayList<Player> pList = new ArrayList<>();

        for (int i = 1; i < 10001; i++) {
            if (rank[i] != 0) pList.add(new Player(i, rank[i]));
        }

        pQueue.addAll(pList);

        // 1등 제거
        pQueue.poll();

        Player second = pQueue.poll();
        System.out.print(second.id + " ");
        int preScore = second.rank;

        while (!pQueue.isEmpty()) {
            Player p = pQueue.poll();
            if (preScore != p.rank) {
                break;
            }
            System.out.print(p.id + " ");
            preScore = p.rank;
        }
    }

    static class Player {
        int id, rank;

        public Player(int id, int rank) {
            this.id = id;
            this.rank = rank;
        }
    }

    static class PlayerComp implements Comparator<Player> {

        @Override
        public int compare(Player p1, Player p2) {
            if (p1.rank == p2.rank) {
                if ((p1.id > p2.id)) {
                    return 1;
                }
            } else {
                if (p1.rank < p2.rank) {
                    return 1;
                }
            }
            return -1;
        }
    }

}
