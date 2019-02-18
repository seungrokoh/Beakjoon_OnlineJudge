import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str = in.next().toCharArray();
        int[] alpha = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};


        for (int i = 0; i < str.length; i++) {
            int index = str[i] - 'a';
            if (alpha[index] < 0) {
                alpha[str[i] - 'a'] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}

