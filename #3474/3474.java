import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            System.out.println(solve(num));
        }
    }

    private static long solve(int num) {
        long sum = 0;

        for (int i = 5; i <= num; i *= 5) {
            sum += num / i;
        }
        return sum;
    }
}
