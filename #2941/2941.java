import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str = in.next().toCharArray();
        int len = str.length;

        int croatiaAlpha = 0;

        for (int i = len - 1; i >= 0;) {
            if (str[i] == '=') {
                if (i > 1 && str[i - 2] == 'd'){
                    i = i - 2;
                } else {
                    i--;
                }
            } else if (str[i] == '-') {
                i--;
            } else if (str[i] == 'j' && i > 0) {
                if (str[i - 1] == 'n' || str[i - 1] == 'l') {
                    i--;
                }
            }
            i--;
            croatiaAlpha++;
        }

        System.out.print(croatiaAlpha);
    }
}

