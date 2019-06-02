import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MONEY = 1000;
    static int[] change = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        int pay = Integer.parseInt(br.readLine());

        System.out.println(solve(MONEY - pay));
    }

    private static int solve(int changeMoney) {
        int result = 0;

        for (int index = 0; index < change.length && changeMoney >= 0; index++) {
            result += changeMoney / change[index];
            changeMoney %= change[index];
        }
        return result;
    }
}
