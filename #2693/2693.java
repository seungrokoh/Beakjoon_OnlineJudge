import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int len = input.length;
            int[] nums = new int[len];

            for (int j = 0; j < len; j++) {
                nums[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(nums);
            System.out.println(nums[len - 3]);

        }
    }
}
