import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final int MAX_SIZE = 246913;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            boolean[] check = new boolean[MAX_SIZE];
            Arrays.fill(check, false);
            int cnt = 0;

            int start = n;
            int end = 2 * n;

            for (int i = 2; i < Math.sqrt(MAX_SIZE); i++) {
                for (int j = i * 2; j < MAX_SIZE; j += i){
                    check[j] = true;
                }
            }
            start = start == 1 ? 2 : n + 1;
            for (int i = start == 1 ? 2 : n + 1; i <= end; i++) {
                if (!check[i]) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }


    }
}

