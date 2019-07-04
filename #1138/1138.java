import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int numOfPerson = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");


        solve(numOfPerson, input);
    }

    private static void solve(int numOfPerson, String[] input) {
        int[] line = new int[numOfPerson];

        for (int i = 0; i < numOfPerson; i++) {
            int left = Integer.parseInt(input[i]);
            int position = searchPosition(line, left, numOfPerson);
            line[position] = i + 1;
        }

        printLine(line);
    }

    private static void printLine(int[] line) {
        for (int i = 0; i < line.length; i++) {
            System.out.print(line[i] + " ");
        }
    }

    private static int searchPosition(int[] line, int numOfLeftPerson, int numOfPerson) {
        for (int position = 0; position < numOfPerson; position++) {
            if (numOfLeftPerson == 0 && line[position] == 0) {
                return position;
            }
            if (line[position] == 0) numOfLeftPerson--;
        }
        return -1;
    }
}
