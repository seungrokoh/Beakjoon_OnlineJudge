import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        dp = new int[row + 1][col + 1];

        System.out.println(solve(row, col));
    }

    static int solve(int row, int col) {
        if (row == 1 && col == 1) return 0;

        if (dp[row][col] != 0) return dp[row][col];

        if (col == 1) return dp[row][col] = solve(row / 2, col) + solve(row - row / 2, col) + 1;

        return dp[row][col] = solve(row, col / 2) + solve(row, col - col / 2) + 1;
    }

}
