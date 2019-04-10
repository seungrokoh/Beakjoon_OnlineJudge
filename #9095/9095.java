import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.println(solve(Integer.parseInt(br.readLine())));
        }

    }

    private static int solve(int n) {
        if (dp[n] != 0) return dp[n];

        if (n == 1) return dp[n] = 1;
        if (n == 2) return dp[n] = 2;
        if (n == 3) return dp[n] = 4;

        return dp[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
    }
}
