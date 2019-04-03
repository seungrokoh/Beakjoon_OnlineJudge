import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int cardNum = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        int[] card = new int[cardNum];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < cardNum; i++) {
            card[i] = Integer.parseInt(str[i]);
        }
        solve(card, cardNum, target);
    }

    private static void solve(int[] card, int cardNum, int target) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < cardNum - 2; i++) {
            for (int j = i + 1; j < cardNum - 1; j++) {
                for (int k = j + 1; k < cardNum; k++) {
                    int sum = card[i] + card[j] + card[k];
                    if (sum <= target) {
                        min = Math.min(min, target - sum);
                    }
                }
            }
        }

        System.out.println(target - min);
    }
}
