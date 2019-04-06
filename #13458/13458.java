import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int classNum = Integer.parseInt(br.readLine());
        int[] humanNum = new int[classNum];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < classNum; i++) {
            humanNum[i] = Integer.parseInt(input[i]);
        }

        String[] supervisor = br.readLine().split(" ");
        int major = Integer.parseInt(supervisor[0]);
        int minor = Integer.parseInt(supervisor[1]);

        solve(humanNum, major, minor);
    }

    private static void solve(int[] humanNum, int major, int minor) {
        int len = humanNum.length;
        // 모든 시험장에는 총감독관이 1명씩 있다.
        long supervisorCnt = len;

        for (int i = 0; i < len; i++) {
            humanNum[i] -= major;
            // 필요한 부감독관을 계산함
            supervisorCnt += calcNeedMinor(humanNum[i], minor);
        }

        System.out.println(supervisorCnt);
    }

    static int calcNeedMinor(int humanNum, int minor) {
        // 총감독관으로 모두 감시 가능할 때
        if (humanNum <= 0) return 0;
        // 부감독관이 필요할 때
        if (humanNum % minor != 0) return (humanNum / minor) + 1;
        return humanNum / minor;
    }

}
