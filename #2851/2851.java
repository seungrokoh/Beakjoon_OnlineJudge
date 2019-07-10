import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int GOAL_NUMBER = 100;
    public static void main(String[] args) throws IOException {
        int totalScore = 0;

        for (int i = 0; i < 10; i++) {
            int temp = totalScore;
            totalScore = min(totalScore, totalScore + Integer.parseInt(br.readLine()));
            if (temp == totalScore) break;
        }
        System.out.println(totalScore);
    }

    private static int min(int a, int b) {
        return Math.abs(GOAL_NUMBER - a) < Math.abs(GOAL_NUMBER - b) ? a : b;
    }
}
