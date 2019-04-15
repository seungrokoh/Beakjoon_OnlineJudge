import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] times;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(input[i]);
        }

        solve(times);
        
    }

    private static void solve(int[] times) {
        Arrays.sort(times);

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < times.length; i++) {
            sum += times[i];
            ans += sum;
        }

        System.out.println(ans);
    }


}
