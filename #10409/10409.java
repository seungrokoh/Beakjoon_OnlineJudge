import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] input = Scanner.readLineToIntArray(" ");
        int numOfRequest = input[0];
        int totalMinute = input[1];
        int[] times = Scanner.readLineToIntArray(" ");
        System.out.println(solve(times, numOfRequest, totalMinute));
    }

    private static int solve(int[] times, int numOfRequest, int totalMinute) {
        for (int i = 0; i < numOfRequest; i++) {
            if ((totalMinute -= times[i]) < 0) {
                return i;
            }
        }
        return numOfRequest;
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
    }
}
