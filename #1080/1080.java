import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int width;
    static int height;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);

        boolean[][] matrixA = getMatrix();
        boolean[][] matrixB = getMatrix();

        System.out.println(solve(matrixA, matrixB));
    }

    private static int solve(boolean[][] matrixA, boolean[][] matrixB) {
        int ans = 0;
        if (width < 3 || height < 3) {
            return isSameMatrix(matrixA, matrixB) ? ans : -1;
        }

        for (int i = 0; i < height - 2; i++) {
            for (int j = 0; j < width - 2; j++) {
                if (matrixA[i][j] ^ matrixB[i][j]) {
                    togglePartialMatrix(matrixA, i, j);
                    ans++;
                }
            }
        }
        return isSameMatrix(matrixA, matrixB) ? ans : -1;
    }

    private static void togglePartialMatrix(boolean[][] matrixA, int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                matrixA[i][j] = !matrixA[i][j];
            }
        }
    }

    private static boolean isSameMatrix(boolean[][] matrixA, boolean[][] matrixB) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrixA[i][j] != matrixB[i][j]) return false;
            }
        }
        return true;
    }

    private static boolean[][] getMatrix() throws IOException {
        boolean[][] matrix = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String row = br.readLine();
            for (int j = 0; j < width; j++) {
                if (row.charAt(j) == '1') {
                    matrix[i][j] = true;
                } else {
                    matrix[i][j] = false;
                }
            }
        }

        return matrix;
    }
}
