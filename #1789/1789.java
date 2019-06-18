import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());

        System.out.println(solve(n));
    }

    static int solve(long n) {
        long sum = 0;
        int addNum = 1;
        while(n >= sum) {
            sum += addNum++;
        }

        return sum == n ? addNum - 1 : addNum - 2;
    }
}
