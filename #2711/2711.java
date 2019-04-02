import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            System.out.println(solve(index, input[1]));
        }
    }

    private static String solve(int index, String str) {
        return new StringBuilder().append(str, 0, index - 1).append(str.substring(index)).toString();
    }
}
