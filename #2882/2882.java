import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Score[] nums = new Score[8];

        for (int i = 0; i < 8; i++) {
            nums[i] = new Score(i + 1, Integer.parseInt(br.readLine()));
        }

        solve(nums);
    }

    private static void solve(Score[] nums) {
        int len = nums.length;
        int sum = 0;

        Arrays.sort(nums, (score, t1) -> {
            if (t1.score < score.score) {
                return -1;
            }
            return 1;
        });

        boolean[] include = new boolean[len];
        for (int i = 0; i < 5; i++) {
            sum += nums[i].score;
            include[nums[i].position - 1] = true;
        }

        System.out.println(sum);
        for (int i = 0; i < len; i++) {
            if (include[i]) System.out.print(i + 1 + " ");
        }
    }

    static class Score {
        public int position;
        public int score;

        public Score(int position, int score) {
            this.position = position;
            this.score = score;
        }
    }
}
