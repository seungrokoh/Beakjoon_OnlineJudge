import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] pinaryNumber;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    private static long solve(int n) {
        pinaryNumber = new long[n + 1];

        return recursion(n);
    }

    private static long recursion(int n) {
        if (n == 1 || n == 2) return 1;
        if (pinaryNumber[n] == 0)
            return pinaryNumber[n] = recursion(n - 1) + recursion(n - 2);

        return pinaryNumber[n];
    }
}
