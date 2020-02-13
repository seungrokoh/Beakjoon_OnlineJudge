import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] dot = new int[3][2];
        for (int i = 0; i < 3; i++) {
            dot[i] = Scanner.readLineToIntArray();
        }
        System.out.println((dot[0][0] ^ dot[1][0] ^ dot[2][0]) + " " + (dot[0][1] ^ dot[1][1] ^ dot[2][1]));
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
