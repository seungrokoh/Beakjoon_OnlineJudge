import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int numOfMatches = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        int height = Integer.parseInt(input[2]);
        int[] matchesLen = new int[numOfMatches];
        for (int i = 0; i < numOfMatches; i++) {
            matchesLen[i] = Integer.parseInt(br.readLine());
        }

        solve(matchesLen, width, height);
    }

    private static void solve(int[] matchesLen, int width, int height) {
        double maxLen = Math.pow(width, 2) + Math.pow(height, 2);
        for (int i = 0; i < matchesLen.length; i++) {
            if (Math.pow(matchesLen[i], 2) <= maxLen) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

}
