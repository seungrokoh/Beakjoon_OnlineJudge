import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        char[] num = String.valueOf(number).toCharArray();

        Arrays.sort(num);
        for (int i = num.length - 1; i >= 0; i--) {
            System.out.print(num[i]);
        }
    }
}
