import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split("-");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            result.append(str[i].charAt(0));
        }
        System.out.println(result);
    }
}
