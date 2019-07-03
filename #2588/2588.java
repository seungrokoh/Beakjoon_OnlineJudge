import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        solve(num1, num2);
    }

    private static void solve(int num1, int num2) {
        int temp = num2;
        while(temp > 0) {
            System.out.println(num1 * (temp % 10));
            temp /= 10;
        }
        System.out.println(num1 * num2);
    }
}
