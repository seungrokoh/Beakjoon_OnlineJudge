import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] shapeOfBoong = new int[n][m];

        inputShapeOfBoong(shapeOfBoong, n, m);

        solve(shapeOfBoong, n, m);
        printBoong(shapeOfBoong);
    }

    public static void inputShapeOfBoong(int[][] shapeOfBoong, int n, int m) throws IOException{
        for (int i = 0; i < n; i++) {
            String inputMap = br.readLine();
            for (int j = 0; j < m; j++) {
                shapeOfBoong[i][j] = inputMap.charAt(j) - '0';
            }
        }
    }

    public static void solve(int[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                int temp = map[i][j];
                map[i][j] = map[i][m - 1 - j];
                map[i][m - 1 - j] = temp;
            }
        }
    }

    private static void printBoong(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}
