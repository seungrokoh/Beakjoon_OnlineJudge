import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int setCnt = 0;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                break;
            }
            String[] input = br.readLine().split(" ");

            output(++setCnt, solve(n, input));

        }

    }

    private static void output(int count, int moveCnt) {
        System.out.println(String.format("Set #%d", count));
        System.out.println(String.format("The minimum number of moves is %d.\n", moveCnt));
    }

    private static int solve(int n, String[] input) {
        int[] walls = new int[n];
        int sum = 0, avg = 0;

        for (int i = 0; i < n; i++) {
            walls[i] = Integer.parseInt(input[i]);
            sum += walls[i];
        }

        avg = sum / n;

        int move = 0;
        for (int i = 0; i < n; i++) {
            if (walls[i] < avg) {
                move += avg - walls[i];
            }
        }

        return move;
    }
}
