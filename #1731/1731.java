import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(solve(nums));

    }

    private static int solve(int[] nums) {
        if (nums[2] - nums[1] == nums[1] - nums[0]) {
            // 등차수열
            return nums[n - 1] + (nums[1] - nums[0]);
        }

        return nums[n - 1] * (nums[1] / nums[0]);
    }
}
