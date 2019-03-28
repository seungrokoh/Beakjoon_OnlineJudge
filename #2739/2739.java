import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        solve(n);
    }

    private static void solve(int n) {
        for (int i = 1; i <= 9; i++) {
            String gugu = String.format("%d * %d = %d", n, i, n * i);
            System.out.println(gugu);
        }
    }

}
