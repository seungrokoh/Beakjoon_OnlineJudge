import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        boolean[] check = new boolean[end + 1];

        for (int i = 2; i <= end; i++) {
            if (!check[i]) {
                for (int j = i * 2; j <= end; j += i) {
                    check[j] = true;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            if (!check[i]) System.out.println(i);
        }
    }
}

