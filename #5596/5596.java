import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] mingukScore = br.readLine().split(" ");
        String[] manseScore = br.readLine().split(" ");

        System.out.println(solve(mingukScore, manseScore));
    }

    private static int solve(String[] mingukScore, String[] manseScore) {
        int mingukSum = 0;
        int manseSum =0;
        for (int i = 0; i < mingukScore.length; i++) {
            mingukSum += Integer.parseInt(mingukScore[i]);
            manseSum += Integer.parseInt(manseScore[i]);
        }
        return mingukSum >= manseSum ? mingukSum : manseSum;
    }

}
