import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            solve(n);

        }
    }

    private static int check(int num){
        switch (num){
            case 0 : return 4;
            case 1 : return 2;
            default: return 3;
        }
    }
    private static void solve(int num) {
        int len = String.valueOf(num).length();
        int sum = 0;
        while (num > 0) {
            sum += check(num % 10);
            num /= 10;
        }
        sum += len - 1 + 2;

        System.out.println(sum);
    }

}
