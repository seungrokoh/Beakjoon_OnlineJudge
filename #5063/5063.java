import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            System.out.println(solve(r, e, c));
        }
    }

    private static String solve(int r, int e, int c) {
        if ((e-c) > r) return "advertise";
        if ((e-c) < r) return "do not advertise";
        return "does not matter";
    }
}
