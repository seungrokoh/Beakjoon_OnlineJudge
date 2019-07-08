import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        String num1 = br.readLine();
        String operator = br.readLine();
        String num2 = br.readLine();

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        System.out.println(solve(num1, operator, num2));
    }

    private static String solve(String num1, String oper, String num2) {
        if (oper.equals("+")) return calcPlusOperation(num1, num2);

        return calcMultipleOperation(num1, num2);
    }

    private static String calcMultipleOperation(String num1, String num2) {
        return num1 + num2.substring(1);
    }

    private static String calcPlusOperation(String num1, String num2) {
        if (num1.length() == num2.length())
            return "2" + num1.substring(1);

        return num1.substring(0, num1.length() - num2.length()) + num2;
    }
}
