import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            int inputNum = in.nextInt();
            maxNum = max(maxNum, inputNum);
        }
        System.out.println(maxNum);
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
