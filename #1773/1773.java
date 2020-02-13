import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] input = Scanner.readLineToIntArray();
        int numOfStudent = input[0];
        int endTime = input[1];
        int[] periodOfStudent = new int[numOfStudent];
        boolean[] burst = new boolean[endTime + 1];

        for (int i = 0; i < numOfStudent; i++) {
            periodOfStudent[i] = Scanner.readLineToInt();
        }

        for (int i = 0; i < numOfStudent; i++) {
            int period = periodOfStudent[i];
            int burstTime = period;
            while(burstTime <= endTime) {
                burst[burstTime] = true;
                burstTime += period;
            }
        }

        int result = 0;
        for (int i = 1; i <= endTime; i++) {
            if (burst[i]) result++;
        }

        System.out.println(result);
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
