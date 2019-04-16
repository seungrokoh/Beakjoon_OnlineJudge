import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        solve(coins, target);
    }

    private static void solve(int[] coins, int target) {
        int index = coins.length - 1;

        int ans = 0;

        while(target != 0){
            ans += target / coins[index];
            target %= coins[index--];
        }

        System.out.println(ans);
    }


}
