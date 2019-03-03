import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[8];
        int asc = 0, des = 0;


        for (int i = 0; i < 8; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) {
                asc++;
            } else if (arr[i] > arr[i + 1]) {
                des++;
            }
        }

        if (asc == 7) {
            System.out.print("ascending");
        } else if (des == 7) {
            System.out.print("descending");
        } else {
            System.out.print("mixed");
        }
    }
}
