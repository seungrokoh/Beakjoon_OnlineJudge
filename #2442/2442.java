import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        printStar(n);
    }

    private static void printStar(int n) {
        int startCnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            for (int blank = i; blank >= 1; blank--) {
                sb.append(" ");
            }
            for (int star = 1; star <= startCnt; star++) {
                sb.append("*");
            }
            startCnt += 2;
            sb.append("\n");
        }

        System.out.println(sb);
    }


}
