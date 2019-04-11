import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            sb.append(solve(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int solve(int numOfRoom) {
        boolean[] stateOfRoom = new boolean[numOfRoom + 1];
        for (int i = 2; i <= numOfRoom; i++) {
            for (int j = i; j <= numOfRoom; j += i) {
                stateOfRoom[j] = !stateOfRoom[j];
            }
        }

        int cnt = 0;
        for (int i = 1; i <= numOfRoom; i++) {
            if (!stateOfRoom[i]) cnt++;
        }

        return cnt;
    }

}
