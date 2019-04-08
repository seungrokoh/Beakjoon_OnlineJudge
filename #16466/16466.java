import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] soldTickets = br.readLine().split(" ");
        boolean[] tickets = new boolean[1000001];

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(soldTickets[i]);
            tickets[index] = true;
        }

        System.out.println(solve(tickets));
    }

    private static int solve(boolean[] tickets) {
        int len = tickets.length;

        for (int i = 1; i < len; i++) {
            if (!tickets[i]) return i;
        }
        return -1;
    }
}
