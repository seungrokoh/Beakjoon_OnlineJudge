import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int gcd(int a, int b){
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int lcm(int a, int b){
        return a * b / (gcd(a, b));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int num1, num2;

        for (int i = 0; i < t; i++) {
            num1 = in.nextInt();
            num2 = in.nextInt();

            System.out.println(lcm(num1, num2));
        }
    }
}

