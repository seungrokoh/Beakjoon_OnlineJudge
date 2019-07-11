import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(true) {
            int[] sides = getSides();
            Arrays.sort(sides);

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) break;

            if (Math.pow(sides[0], 2) + Math.pow(sides[1], 2) == Math.pow(sides[2], 2)) System.out.println("right");
            else System.out.println("wrong");
        }
    }

    private static int[] getSides() throws IOException {
        String[] input = br.readLine().split(" ");
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = Integer.parseInt(input[i]);
        }
        return temp;
    }

}
