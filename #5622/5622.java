import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] alpha = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        int result = 0;

        String str = in.next();

        for (int i = 0; i < str.length(); i++) {
            result += alpha[str.charAt(i) - 'A'] + 1;
        }

        System.out.print(result);
    }
}

