import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, target, cnt = 0, sum = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);
        String[] str = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        solve(0);
        System.out.println(cnt);

    }
    private static void solve(int current){
        if (current == n) return;

        if (sum + arr[current] == target) cnt++;

        // 현재 원소를 포함 시키지 않고 탐색
        solve(current + 1);

        // 현재 원소를 포함 시키고 탐색
        sum += arr[current];
        solve(current + 1);

        // 포함 시켰던 원소를 다시 제거
        sum -= arr[current];
    }
}
