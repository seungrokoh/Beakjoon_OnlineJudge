import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int separate = Integer.parseInt(br.readLine());
            String[] words = br.readLine().split(" ");

            System.out.println(solve(separate, words));
        }
    }

    private static String solve(int separate, String[] words) {
        boolean arabic = false, eng = false;
        int engIndex = 0;

        for (int i = 0; i < separate; i++) {
            if (words[i].charAt(0) == '#') {
                arabic = true;
            } else {
                eng = true;
                engIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (arabic && eng) {
            // 섞여 있을 경우
            for (int i = engIndex + 1; i < separate; i++) {
                sb.append(words[i]).append(" ");
            }
            sb.append(words[engIndex]).append(" ");
            for (int i = 0; i < engIndex; i++) {
                sb.append(words[i]).append(" ");
            }

            return sb.toString();
        }

        for (int i = 0; i < separate; i++) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString();
    }
}
