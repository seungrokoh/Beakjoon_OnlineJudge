import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] alpha = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(solve(br.readLine()));
        }
    }

    private static String solve(String str) {
        int score = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'A';
            if (index >= 0) score += alpha[index];
        }

        return score == 100 ? "PERFECT LIFE" : String.valueOf(score);
    }


}
