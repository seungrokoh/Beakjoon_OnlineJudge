import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] needDays, price, dp;
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        needDays = new int[n + 1];
        price = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            needDays[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);
        }

        System.out.println(solve(1));
    }

    private static int solve(int day) {
        if (day == n + 1) return 0;
        if (day > n + 1) return Integer.MIN_VALUE;

        if (dp[day] > 0) return dp[day];

        return dp[day] = Math.max(solve(day + 1), price[day] + solve(day + needDays[day]));
    }
}
