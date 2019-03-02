import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int repeat = Integer.parseInt(input[0]);
            char[] str = input[1].toCharArray();
            int len = str.length;
            
            for (int index = 0; index < len; index++) {
                for (int j = 0; j < repeat; j++) {
                    builder.append(str[index]);
                }
            }
            builder.append("\n");
        }

        System.out.print(builder);
    }
}
