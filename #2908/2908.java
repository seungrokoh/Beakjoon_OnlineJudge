import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");

        char[] num1 = input[0].toCharArray();
        char[] num2 = input[1].toCharArray();

        for (int i = 2; i >= 0; i--) {
            if (num1[i] == num2[i]) continue;
            if (num1[i] > num2[i]){
                printNum(num1);
                break;
            } else {
                printNum(num2);
                break;
            }
        }
    }

    public static void printNum(char[] num) {
        for (int i = 2; i >= 0; i--) {
            System.out.print(num[i]);
        }
    }
}

