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
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; i * j <= n; j++) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
