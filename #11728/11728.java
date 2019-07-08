import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int sizeA = Integer.parseInt(input[0]);
        int sizeB = Integer.parseInt(input[1]);
        int[] arrA = getArray(sizeA);
        int[] arrB = getArray(sizeB);

        solve(arrA, arrB, sizeA, sizeB);
    }

    private static void solve(int[] arrA, int[] arrB, int sizeA, int sizeB) {
        int[] temp = new int[sizeA + sizeB];

        int index = 0;
        for (int i = 0; i < sizeA; i++) {
            temp[index++] = arrA[i];
        }
        for (int i = 0; i < sizeB; i++) {
            temp[index++] = arrB[i];
        }
        Arrays.sort(temp);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            builder.append(temp[i]).append(" ");
        }
        System.out.println(builder.toString());
    }

    private static int[] getArray(int size) throws IOException {
        int[] temp = new int[size];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            temp[i] = Integer.parseInt(input[i]);
        }
        return temp;
    }
}
