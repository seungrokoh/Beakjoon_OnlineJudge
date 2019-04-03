import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        System.out.println(solve(num));
    }

    private static int solve(int num) {
        for (int i = num; i >= 0; i--) {
            if (check(i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean check(int num) {
        while(num > 0){
            if (num % 10 == 4 || num % 10 == 7) {
                num /= 10;
            } else {
                return false;
            }
        }
        return true;
    }
}
