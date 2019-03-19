import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int taget = Integer.parseInt(input[1]);

        System.out.println(solve(start, taget));

    }

    private static int solve(int start, int taget) {
        int[] dx = {-1, 1, 2};
        boolean[] visited = new boolean[100001];
        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(new User(start, 0));
        visited[start] = true;

        while (!userQueue.isEmpty()) {
            User user = userQueue.poll();

            if (user.x == taget) {
                return user.time;
            }
            for (int i = 0; i < 2; i++) {
                if (safe(user.x + dx[i]) && !visited[user.x + dx[i]]) {
                    userQueue.add(new User(user.x + dx[i], user.time + 1));
                    visited[user.x + dx[i]] = true;
                }
            }

            if (safe(user.x * dx[2]) && !visited[user.x * dx[2]]) {
                userQueue.add(new User(user.x * dx[2], user.time + 1));
                visited[user.x * dx[2]] = true;
            }
        }
        return -1;
    }

    static boolean safe(int x) {
        return x >= 0 && x < 100001;
    }

    static class User {
        int x, time;

        public User(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
