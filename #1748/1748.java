import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        System.out.println(solve(num));
    }

    private static int solve(int num) {
        // @param cnt : 자리수의 개수
        // @param nums : 자리수의 시작점
        int[] cnt = {0, 9, 90, 900, 9000, 90000, 900000, 9000000, 90000000, 900000000};
        int[] nums = {0, 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        // 총 길이
        int sum = 0;
        int len = String.valueOf(num).length();

        // 처음 자리수 만큼 길이를 더해줌
        sum += (len * (num + 1 - nums[len]));

        // 자리수를 내려가며 모두 더해줌
        while (len != 0) {
            len--;
            sum += (len * cnt[len]);
        }
        return sum;
    }
}
