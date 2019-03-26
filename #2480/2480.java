import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    public static void main(String[] args) throws IOException {

        solve(n);
    }

    private static void solve(int n) throws IOException {
        String[] input = br.readLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);
        int num3 = Integer.parseInt(input[2]);

        int sum = 0;
        if (num1 == num2 && num2 == num3) {
            // case 1
            sum = 10000 + (num1 * 1000);
        } else if (num1 == num2 || num1 == num3) {
            // case 2
            sum = 1000 + (num1 * 100);
        } else if (num2 == num3) {
            // case 2
            sum = 1000 + (num2 * 100);
        } else {
            // case 3
            int max = Math.max(num1, Math.max(num2, num3));
            sum = max * 100;
        }
        System.out.println(sum);
    }
}
