import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);

        System.out.println(makeOne(n));
    }

    private static int makeOne(int n) {
        if (n == 1) return 0;

        if (dp[n] != -1) return dp[n];
        int ret = Integer.MAX_VALUE;

        if (n % 3 == 0) ret = Math.min(ret, makeOne(n / 3) + 1);
        if (n % 2 == 0) ret = Math.min(ret, makeOne(n / 2) + 1);

        return dp[n] = Math.min(ret, makeOne(n - 1) + 1);
    }
}
