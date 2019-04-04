import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        solve(input, n);
    }

    private static void solve(String[] input, int n) {
        boolean[] check = new boolean[101];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            if (check[num]) cnt++;
            check[num] = true;
        }

        System.out.print(cnt);
    }

}
