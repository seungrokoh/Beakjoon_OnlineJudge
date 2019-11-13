import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        solve(input);
    }

    private static void solve(String[] input) {
        int r1 = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        System.out.println(2 * s - r1);
    }

}
