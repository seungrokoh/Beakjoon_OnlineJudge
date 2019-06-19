import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int newScore = Integer.parseInt(input[1]);
        int limitNum = Integer.parseInt(input[2]);

        System.out.println(solve(n, limitNum, newScore));
    }

    private static int solve(int n, int limitNum, int newScore) throws IOException {
        if (n == 0) return 1;

        int[] score = getScores(n);

        if (n >= limitNum && score[limitNum - 1] >= newScore) return -1;

        int index = 0;
        int currentRank = 0;
        int preScore = Integer.MAX_VALUE;

        while (index < n) {
            if (score[index] < newScore) break;
            if (preScore > score[index]) {
                currentRank = index + 1;
                preScore = score[index];
            }

            index++;
        }

        return preScore == newScore ? currentRank : index + 1;
    }

    private static int[] getScores(int n) throws IOException {
        String[] inputScore = br.readLine().split(" ");
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(inputScore[i]);
        }
        return score;
    }
}
