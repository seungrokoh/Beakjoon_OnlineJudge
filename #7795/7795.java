import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int aNum = Integer.parseInt(input[0]);
            int bNum = Integer.parseInt(input[1]);

            String[] aInput = br.readLine().split(" ");
            int[] arrA = new int[aNum];
            for (int j = 0; j < aNum; j++) {
                arrA[j] = Integer.parseInt(aInput[j]);
            }

            String[] bInput = br.readLine().split(" ");
            int[] arrB = new int[bNum];
            for (int j = 0; j < bNum; j++) {
                arrB[j] = Integer.parseInt(bInput[j]);
            }

            solve(arrA, arrB);
        }
    }

    private static void solve(int[] arrA, int[] arrB) {
        int cnt = 0;

        int aLen = arrA.length;
        int bLen = arrB.length;

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int bIndex = 0;
        for (int i = 0; i < aLen; i++) {
            while (bIndex < bLen && arrB[bIndex] < arrA[i]) {
                bIndex++;
            }
            cnt += bIndex;
        }

        System.out.println(cnt);
    }

}
