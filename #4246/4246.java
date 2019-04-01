import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String encryptedLetter = br.readLine();
            System.out.println(solve(encryptedLetter, n));
        }

    }

    private static String solve(String encryptedLetter, int n) {
        int len = encryptedLetter.length();
        int row = len/n, col = n;
        char[][] rectangleLeeter = new char[row][col];

        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i % 2 == 0) {
                    // 오른 방향으로 저장
                    rectangleLeeter[i][j] = encryptedLetter.charAt(index++);
                } else {
                    // 왼쪽 방향으로 저장
                    rectangleLeeter[i][col - j - 1] = encryptedLetter.charAt(index++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                sb.append(rectangleLeeter[j][i]);
            }
        }
        return sb.toString();
    }

}
