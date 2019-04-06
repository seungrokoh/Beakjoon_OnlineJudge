import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        long start = Long.parseLong(input[0]);
        long end = Long.parseLong(input[1]);

        solve(start, end);
    }

    private static void solve(long start, long end) {

        if (start == end){
            System.out.println(0);
            return;
        }

        if (start > end) {
            long temp = start;
            start = end;
            end = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for (long i = start + 1; i < end; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(end - start - 1);
        System.out.println(sb.toString());
    }
}
