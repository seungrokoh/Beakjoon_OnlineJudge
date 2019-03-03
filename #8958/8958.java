import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            char[] str = br.readLine().toCharArray();
            int len = str.length;
            int sum = 0, continuity = 0;

            for (int index = 0; index < len; index++) {
                if (str[index] == 'O') {
                    sum += (++continuity);
                } else {
                    continuity = 0;
                }
            }

            System.out.println(sum);
        }

    }
}
