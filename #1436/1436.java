import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String INFIX_STR = "666";
    
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        System.out.println(solve(num));
    }

    private static int solve(int num) {
        int cnt = 0;
        int index = 0;
        while(cnt != num) {
            if (String.valueOf(++index).contains(INFIX_STR)) cnt++;
        }
        return index;
    }

}
