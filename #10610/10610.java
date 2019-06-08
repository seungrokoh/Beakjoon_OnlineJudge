import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String inputNum = br.readLine();
        int[] countOfNum = countingOfNum(inputNum);

        System.out.print(solve(countOfNum));
    }

    private static int[] countingOfNum(String inputNum) {
        int[] temp = new int[10];
        for (int i = 0; i < inputNum.length(); i++) {
            temp[inputNum.charAt(i) - '0']++;
        }
        return temp;
    }

    private static String solve(int[] countOfNum) {
        if (countOfNum[0] == 0) return String.valueOf(-1);

        StringBuilder result = new StringBuilder();
        int index = 9;
        int sum = 0;
        while(index >= 0) {
            if (countOfNum[index] > 0) {
                result.append(index);
                countOfNum[index]--;
                sum += index;
            } else {
                index--;
            }
        }

        return sum % 3 == 0 ? result.toString() : String.valueOf(-1);
    }
}
