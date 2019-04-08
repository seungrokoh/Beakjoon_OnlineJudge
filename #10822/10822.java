import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] nums = br.readLine().split(",");

        long sum = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            sum += Integer.parseInt(nums[i]);
        }

        System.out.println(sum);
    }

}
