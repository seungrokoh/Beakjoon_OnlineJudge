import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        System.out.println(getMinBurgerPrice() + getMinBeveragePrice() - 50);
    }

    private static int getMinBurgerPrice() throws IOException {
        int minBurgerPrice = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            minBurgerPrice = minPrice(minBurgerPrice, Integer.parseInt(br.readLine()));
        }
        return minBurgerPrice;
    }

    private static int getMinBeveragePrice() throws IOException {
        int minBeveragePrice = Integer.MAX_VALUE;

        for (int i = 0; i < 2; i++) {
            minBeveragePrice = minPrice(minBeveragePrice, Integer.parseInt(br.readLine()));
        }
        return minBeveragePrice;
    }
    private static int minPrice(int a, int b) {
        return a < b ? a : b;
    }
}
