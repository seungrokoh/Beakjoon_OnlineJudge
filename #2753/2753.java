import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int year = Integer.parseInt(br.readLine());
        System.out.println(solve(year));
    }

    private static int solve(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return 1;
        }

        return 0;
    }

}
