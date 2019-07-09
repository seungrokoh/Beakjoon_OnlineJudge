import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int MAX_SIZE = 7;
    public static void main(String[] args) throws IOException {
        int[] numbers = getNumbers();
        System.out.println(solve(numbers));
    }

    private static int[] getNumbers() throws IOException {
        int[] temp = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            temp[i] = Integer.parseInt(br.readLine());
        }
        return temp;
    }

    private static String solve(int[] numbers) {
        int sum = 0;
        int minOddNum = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (numbers[i] % 2 == 1) {
                sum += numbers[i];
                minOddNum = Math.min(minOddNum, numbers[i]);
            }
        }

        return sum > 0 ? String.format("%d\n%d", sum, minOddNum) : "-1";
    }

}
