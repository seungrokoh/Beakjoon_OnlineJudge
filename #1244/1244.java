import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        boolean[] right = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (Integer.parseInt(input[i - 1]) == 1) {
                right[i] = true;
            }
        }

        // 학생 수
        int studentNum = Integer.parseInt((br.readLine()));

        solve(studentNum, right);
    }

    static void solve(int studentNum, boolean[] right) throws IOException {
        for (int cycle = 0; cycle < studentNum; cycle++) {
            String[] info = br.readLine().split(" ");
            // 성별 과 받은 수
            int sex = Integer.parseInt(info[0]);
            int rightNum = Integer.parseInt(info[1]);

            if (sex == 1){
                calcMan(right, rightNum);
            } else {
                calcWoman(right, rightNum);
            }
        }

        printSolve(right);
    }

    private static void calcWoman(boolean[] right, int rightNum) {
        // 여학생
        int l = rightNum - 1;
        int r = rightNum + 1;
        while(true){
            if (l < 1 || r > right.length - 1) {
                break;
            }
            if ((right[l] ^ right[r])) {
                break;
            } else {
                right[l] = !right[l--];
                right[r] = !right[r++];
            }
        }
        right[rightNum] = !right[rightNum];
    }

    private static void calcMan(boolean[] right, int rightNum) {
        // 남학생
        for (int rightIndex = rightNum; rightIndex < right.length; rightIndex += rightNum) {
            right[rightIndex] = !right[rightIndex];
        }
    }

    public static void printSolve(boolean[] right){
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < right.length; i++) {
            if (right[i]){
                builder.append(1);
            } else {
                builder.append(0);
            }
            if (i % 20 == 0) {
                builder.append("\n");
            } else {
                builder.append(" ");
            }
        }
        System.out.print(builder);
    }
}

