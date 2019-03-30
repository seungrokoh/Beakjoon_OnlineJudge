import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        solve(n);
    }

    private static void solve(int n) {
        int[] ret = new int[n + 1];
        ret[1] = 3;
        for (int i = 2; i <= n; i++) {
            ret[i] = ret[i-1] * 2 - 1;
        }
        System.out.println(ret[n]*ret[n]);
    }


}
