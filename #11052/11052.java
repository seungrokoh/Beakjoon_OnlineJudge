import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] card, dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        card = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            card[i + 1] = Integer.parseInt(input[i]);
        }

        System.out.println(topDownSolve(n));
//        System.out.println(bottomUpSolve(n));
    }

    private static int topDownSolve(int n){
        if (n == 0) return 0;
        if (dp[n] != 0) return dp[n];

        for (int i = 1; i <= n; i++) {
            dp[n] = max(dp[n], card[i] + topDownSolve(n - i));
        }

        return dp[n];
    }

    private static int bottomUpSolve(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = max(dp[i], card[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }

}
