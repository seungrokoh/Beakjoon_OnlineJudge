import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] nums = br.readLine().split(" ");

        int[] prefixSum = makePrefixSum(nums, n);

        solve(prefixSum, m);
    }

    private static void solve(int[] prefixSum, int target) {
        int cnt = 0;
        int len = prefixSum.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = prefixSum[j] - prefixSum[i];
                if (sum > target) break;
                if (sum == target) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int[] makePrefixSum(String[] nums, int n) {
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + Integer.parseInt(nums[i]);
        }
        return prefixSum;
    }
}
