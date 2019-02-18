
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] alpha = new int[26];
        char[] word = str.toUpperCase().toCharArray();
        int len = word.length;

        for (int i = 0; i < len; i++) {
            alpha[word[i] - 'A']++;
        }

        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[max] < alpha[i]) {
                max = i;
            }
        }

        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (alpha[max] == alpha[i] && max != i) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.print((char)(max + 'A'));
        } else {
            System.out.print("?");
        }
    }
}

