import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = Scanner.readLineToInt();
        int[] nums = Scanner.readLineToIntArray(" ");
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]).append(" ");
        int preSum = nums[0];
        for (int i = 1; i < n; i++) {
            int currentNum = (nums[i] * (i + 1)) - preSum;
            builder.append(currentNum).append(" ");
            preSum += currentNum;
        }
        System.out.println(builder);
    }

    static class Scanner {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        static int readLineToInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
        static String readLine() throws IOException {
            return br.readLine();
        }
        static String[] readLineToStringArray(String regex) throws IOException {
            return br.readLine().split(regex);
        }
        static int[] readLineToIntArray(String regex) throws IOException {
            String[] temp = readLineToStringArray(regex);
            int length = temp.length;
            int[] array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(temp[i]);
            }
            return array;
        }
    }
}
