import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        System.out.println(solve(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
    }

    private static String solve(int num1, int num2) {
        return num1 == num2 ? "==" : num1 < num2 ? "<" : ">";
    }

}
