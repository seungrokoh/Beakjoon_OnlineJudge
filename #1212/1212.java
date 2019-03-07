import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String[] octalToBinary = {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        String octalNum = br.readLine();
        int len = octalNum.length();
        StringBuilder builder = new StringBuilder();

        if (octalNum.equals("0")) {
            System.out.print(0);
            return;
        }
        for (int i = 0; i < len; i++) {
            builder.append(octalToBinary[octalNum.charAt(i) - '0']);
        }

        for (int i = 0; i < len; i++) {
            if (builder.charAt(i) - '0' != 0) {
                System.out.print(builder.substring(i));
                break;
            }
        }
    }

}
