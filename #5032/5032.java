import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int emptyBottle = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
        int needNewBottle = Integer.parseInt(input[2]);

        solve(emptyBottle, needNewBottle);
    }

    private static void solve(int emptyBottle, int needNewBottle) {
        int beverage = 0;
        while (emptyBottle >= needNewBottle) {
            int newBottle = emptyBottle / needNewBottle;
            beverage += newBottle;
            emptyBottle %= needNewBottle;
            // 탄산음료를 먹고 나온 빈병을 더해줌
            emptyBottle += newBottle;
        }
        System.out.println(beverage);
    }
}
