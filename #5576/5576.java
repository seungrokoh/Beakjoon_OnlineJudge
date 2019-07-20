import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] univW = new int[10];
        int[] univK = new int[10];

        for (int i = 0; i < 10; i++) {
            univW[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            univK[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(univW);
        Arrays.sort(univK);

        int maxW = univW[9] + univW[8] + univW[7];
        int maxK = univK[9] + univK[8] + univK[7];

        System.out.println(maxW + " " + maxK);
    }
}
