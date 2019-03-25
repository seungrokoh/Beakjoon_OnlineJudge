import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        System.out.println(solve(num));
    }

    static int solve(int num) throws IOException {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        sum -= num - 1;

        return sum;
    }
}
