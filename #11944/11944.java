import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String nnString = getNNString(n);

        System.out.println(solve(nnString, m));

    }

    private static String solve(String nnString, int m) {
        return nnString.length() > m ? nnString.substring(0, m) : nnString;
    }

    private static String getNNString(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(n);
        }
        return builder.toString();
    }
}
