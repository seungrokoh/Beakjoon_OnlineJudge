import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");

            System.out.println(solve(input, prefixSum));
        }

    }

    private static int solve(String[] input, int[] pSum) {
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int result = pSum[end] - pSum[start - 1];

        return result;

    }
}
