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

    private static void solve(int n) throws IOException {
        String[] input = br.readLine().split(" ");
        int score = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (input[i].equals("1")) {
                sum += score++;
            } else {
                score = 1;
            }
        }

        System.out.println(sum);
    }
}
