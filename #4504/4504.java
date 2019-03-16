import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while(true){
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            if ((num % n) == 0) {
                System.out.println(String.format("%d is a multiple of %d.", num, n));
            } else {
                System.out.println(String.format("%d is NOT a multiple of %d.", num, n));
            }
        }
    }
}
