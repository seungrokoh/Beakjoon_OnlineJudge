import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] str = br.readLine().toCharArray();
        int[] alpha = new int[26];

        for (int i = 0; i < str.length; i++) {
            alpha[str[i] - 'a']++;
        }

        for (int i = 0; i < alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }
    }

}
