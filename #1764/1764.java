import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> userList = new TreeSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            userList.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            list.add(br.readLine());
        }

        solve(userList, list);
    }

    private static void solve(Set<String> userList, List<String> list) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;


        Collections.sort(list);

        for (String name : list) {
            if (userList.contains(name)) {
                cnt++;
                sb.append(name).append("\n");
            }
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

}
