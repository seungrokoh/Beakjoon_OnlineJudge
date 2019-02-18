import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] arrA;
    static int[] arrB;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        arrA = new int[n];
        arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = in.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < n; i++) {
            sum += arrA[i] * arrB[n - 1 - i];
        }

        System.out.print(sum);
    }

}

