import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += str.charAt(i) - '0';
        }

        System.out.print(sum);
    }
}

