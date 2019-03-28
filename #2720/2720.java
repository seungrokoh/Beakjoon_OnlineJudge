import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] charge = new int[n];

        for (int i = 0; i < n; i++) {
            charge[i] = Integer.parseInt(br.readLine());
        }

        solve(charge);
    }

    private static void solve(int[] charge) {
        int[] coin = {25, 10, 5, 1};
        int coinLen = coin.length;
        int[][] result = new int[n][coinLen];

        for (int i = 0; i < n; i++) {
            int index = 0;
            int temp = charge[i];

            while (temp != 0) {
                result[i][index] = temp / coin[index];
                temp %= coin[index++];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < coinLen; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
