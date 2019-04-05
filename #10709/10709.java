import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final char CLOUD = 'c';
    static final char NON_CLOUD = '.';

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);

        char[][] sky = new char[height][width];

        for (int i = 0; i < height; i++) {
            String cloudInfo = br.readLine();
            for (int j = 0; j < width; j++) {
                sky[i][j] = cloudInfo.charAt(j);
            }
        }

        solve(sky);

    }

    private static void solve(char[][] sky) {
        int height = sky.length;
        int width = sky[0].length;

        int[][] ret = new int[height][width];

        for (int[] row: ret)
            Arrays.fill(row, -1);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (sky[i][j] == CLOUD) {
                    ret[i][j] = 0;
                } else if (j > 0 && sky[i][j] == NON_CLOUD && ret[i][j - 1] >= 0 ){
                    ret[i][j] = ret[i][j - 1] + 1;
                }
            }
        }

        printSolve(ret, height, width);

    }

    private static void printSolve(int[][] ret, int height, int width) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(ret[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
