import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Set<String> systemLogs = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[1].equals("enter")) {
                systemLogs.add(input[0]);
            } else {
                systemLogs.remove(input[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String userName : systemLogs) {
            sb.append(userName).append("\n");
        }
        System.out.println(sb.toString());
        
    }

}
