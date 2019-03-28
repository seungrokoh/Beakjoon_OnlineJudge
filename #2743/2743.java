import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        solve(str);
    }

    private static void solve(String str) {
        System.out.print(str.length());
    }

}
