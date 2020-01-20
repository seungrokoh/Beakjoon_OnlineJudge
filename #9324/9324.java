import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = Scanner.readLineToInt();
        solve(n);
    }

    private static void solve(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String message = Scanner.readLine();
            validateMessage(message);
        }
    }

    private static void validateMessage(String message) {
        int[] alpha = new int[26];
        final int length = message.length();

        for (int j = 0; j < length; j++) {
            final int index = message.charAt(j) - 'A';
            alpha[index]++;
            if (alpha[index] % 3 == 0) {
                if (j + 1 >= length || message.charAt(j + 1) != message.charAt(j)) {
                    System.out.println("FAKE");
                    return;
                }
                j++;
            }
        }
        System.out.println("OK");
    }

    static class Scanner {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        static int readLineToInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
        static String readLine() throws IOException {
            return br.readLine();
        }
        static String[] readLineToStringArray(String regex) throws IOException {
            return br.readLine().split(regex);
        }
        static int[] readLineToIntArray(String regex) throws IOException {
            String[] temp = readLineToStringArray(regex);
            int length = temp.length;
            int[] array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(temp[i]);
            }
            return array;
        }

        static int[] readLineToIntArray() throws IOException {
            String[] temp = readLineToStringArray(" ");
            int length = temp.length;
            int[] array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(temp[i]);
            }
            return array;
        }
    }
}
