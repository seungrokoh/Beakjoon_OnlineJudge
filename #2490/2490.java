import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final char[] result = {'D', 'C', 'B', 'A', 'E'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            int sum = 0;

            for (int index = 0; index < input.length; index++) {
                sum += Integer.parseInt(input[index]);
            }

            System.out.println(result[sum]);
        }

    }
}

