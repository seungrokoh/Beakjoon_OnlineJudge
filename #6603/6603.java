import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] nums;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        while(true){
            String[] input = br.readLine().split(" ");
            if (Integer.parseInt(input[0]) == 0) {
                break;
            }
            n = Integer.parseInt(input[0]);
            nums = new int[n];
            visited = new boolean[n];
            sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input[i + 1]);
            }

            backtrack(0, 0);
            System.out.println(sb);
        }
    }

    private static void backtrack(int index, int length) {
        // base case
        if (length == 6) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) sb.append(nums[i] + " ");
            }
            sb.append("\n");
            return;
        }
        // recursion
        if (index >= n) return;

        visited[index] = true;
        backtrack(index + 1, length + 1); // 해당 인덱스를 포함 하는 경우
        visited[index] = false;
        backtrack(index + 1, length); // 해당 인덱스를 포함하지 않는 경우
    }
}
