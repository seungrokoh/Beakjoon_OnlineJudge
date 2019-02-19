import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long temp = n + 1;
        long sum = 0;

        for (int i = 1; i < n; i++) {
            sum += temp * i;
        }

        System.out.print(sum);
    }
}

