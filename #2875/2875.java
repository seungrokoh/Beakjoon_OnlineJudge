import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int femaleNum = Integer.parseInt(input[0]);
        int maleNum = Integer.parseInt(input[1]);
        int needInternNum = Integer.parseInt(input[2]);

        int team = solve(femaleNum, maleNum, needInternNum);
        System.out.println(team);
    }

    private static int solve(int femaleNum, int maleNum, int needInternNum) {
        int team = 0;
        while (femaleNum + maleNum >= needInternNum && femaleNum >= 2 && maleNum >= 1) {
            if (isNotPossibleMakeTeam(femaleNum, maleNum, needInternNum)) break;

            femaleNum-=2;
            maleNum--;

            team++;
        }
        return team;
    }

    private static boolean isNotPossibleMakeTeam(int femaleNum, int maleNum, int needInternNum) {
        return ((femaleNum - 2) + (maleNum - 1)) < needInternNum;
    }
}
