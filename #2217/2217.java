import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];

        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        System.out.println(solve(rope));

    }

    public static int solve(int[] rope) {
        int size = rope.length - 1;
        int result = 0;
        for (int i = 0; i <= size; i++) {
            result = max(result, rope[size - i] * (i + 1));
        }
        return result;
    }

    public static int max(int a, int b){
        return a > b ? a : b;
    }
}
