import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int numCnt = Integer.parseInt(input[0]);
        int resultCnt = Integer.parseInt(input[1]);

        String[] inputNum = br.readLine().split(" ");
        int[] num = new int[numCnt + 1];
        int[] pSum = new int[numCnt + 2];
        for (int i = 1; i <= numCnt; i++) {
            num[i] = Integer.parseInt(inputNum[i-1]);
        }

        for (int i = 1; i <= numCnt; i++) {
            pSum[i + 1] = pSum[i] + num[i];
        }

        for (int i = 0; i < resultCnt; i++) {
            String[] in = br.readLine().split(" ");
            int start = Integer.parseInt(in[0]);
            int end = Integer.parseInt(in[1]);
            System.out.println(pSum[start + 1] - pSum[end]);
        }
    }


}
