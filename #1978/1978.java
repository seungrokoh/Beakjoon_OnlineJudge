import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        System.out.println(solve(input));
    }

    private static int solve(String[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if (isPrime(num)) cnt++;
        }

        return cnt;
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


}
