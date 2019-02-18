import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int small = 64;
        int x = in.nextInt();
        int piece = 0;

        while (x != 0) {
            if (small > x){
                small /= 2;
            } else {
                x -= small;
                small /= 2;
                piece++;
            }
        }

        System.out.print(piece);
    }
}

