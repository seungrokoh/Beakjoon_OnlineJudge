import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("\\-");

        int minResult = 0;

        for (int i = 0; i < input.length; i++) {
            int calcNum = calc(input[i].split("\\+"));

            if (i == 0) calcNum *= -1;
            minResult -= calcNum;
        }

        System.out.println(minResult);
    }

    private static int calc(String[] subNums) {
        int result = 0;
        for (String item : subNums) {
            result += Integer.parseInt(item);
        }
        return result;
    }
}
