import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n , m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(val[j]);
            }
        }

        int loop = Integer.parseInt(br.readLine());
        for (int i = 0; i < loop; i++) {
            System.out.println(calc());
        }
    }

    static int calc() throws IOException {
        int x1, y1, x2, y2;
        String[] in = br.readLine().split(" ");
        x1 = Integer.parseInt(in[0]);
        y1 = Integer.parseInt(in[1]);
        x2 = Integer.parseInt(in[2]);
        y2 = Integer.parseInt(in[3]);

        int sum = 0;
        for (int row = x1 - 1; row < x2; row++) {
            for (int col = y1 - 1; col < y2; col++) {
                sum += arr[row][col];
            }
        }

        return sum;
    }
}
