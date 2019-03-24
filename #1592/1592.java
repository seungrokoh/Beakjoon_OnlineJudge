import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, l;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        l = Integer.parseInt(input[2]);

        solve(n, m, l);


    }

    private static void solve(int n, int m, int l) {
        int[] cnt = new int[n + 1];
        int round = 0;

        int index = 1;
        cnt[index]++;

        while (true) {
            round++;

            if (cnt[index] % 2 == 1) {
                // 시계방향
                index = moveRight(index);
            } else if (cnt[index] % 2 == 0){
                // 반 시계방향
                index = moveLeft(index);
            }
            cnt[index]++;

            if (cnt[index] == m) {
                System.out.println(round);
                break;
            }
        }

    }

    private static int moveRight(int index){
        int temp = (index + l) % n;
        return temp == 0 ? n : temp;
    }

    private static int moveLeft(int index) {
        int temp = (index - l);
        if (temp < 1){
            return n + temp;
        } else {
            return temp % n;
        }
    }

}
