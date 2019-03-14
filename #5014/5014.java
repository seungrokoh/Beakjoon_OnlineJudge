import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int maxFloor, startFloor, targetFloor, upFloor, downFloor;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        maxFloor = Integer.parseInt(input[0]);
        startFloor = Integer.parseInt(input[1]);
        targetFloor = Integer.parseInt(input[2]);
        upFloor = Integer.parseInt(input[3]);
        downFloor = Integer.parseInt(input[4]);

        Floor curFloor = new Floor(startFloor, 0);

        solve(curFloor);
    }

    private static void solve(Floor curFloor) {
        int[] df = {upFloor, -downFloor};
        Queue<Floor> queue = new LinkedList<>();
        boolean[] visited = new boolean[maxFloor + 1];

        queue.add(curFloor);
        visited[curFloor.curFloor] = true;

        while (!queue.isEmpty()) {
            Floor floor = queue.poll();

            if (floor.curFloor == targetFloor) {
                System.out.println(floor.moveCnt);
                return;
            }

            for (int i = 0; i < df.length; i++) {
                if (isSafe(floor.curFloor + df[i]) && !visited[floor.curFloor + df[i]]) {
                    queue.add(new Floor(floor.curFloor + df[i], floor.moveCnt + 1));
                    visited[floor.curFloor + df[i]] = true;
                }
            }
        }
        System.out.println("use the stairs");
    }

    static boolean isSafe(int floor) {
        return (floor >= 1 && floor <= maxFloor);
    }

    static class Floor {
        int curFloor, moveCnt;

        public Floor(int curFloor, int moveCnt) {
            this.curFloor = curFloor;
            this.moveCnt = moveCnt;
        }
    }
}
