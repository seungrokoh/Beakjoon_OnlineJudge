import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        System.out.println(solve(n, k));
    }

    private static int solve(int n, int k) {
        int cnt = 0;
        boolean[] visit = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (!visit[j]) {
                    cnt++;
                    visit[j] = true;
                }

                if (cnt == k) return j;
            }
        }

        return -1;
    }
}
