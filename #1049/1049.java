import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int NUMBER_IN_SET = 6;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int needGuitarString = Integer.parseInt(input[0]);
        int numberOfBrands = Integer.parseInt(input[1]);

        int[] minPrices = getMinPrices(numberOfBrands);

        System.out.println(solve(minPrices, needGuitarString));
    }

    private static int solve(int[] minPrices, int needGuitarString) {
        int minSetPrice = minPrices[0];
        int minPiecePrice = minPrices[1];

        if (minSetPrice == 0 || minPiecePrice == 0) return 0;

        return min((needGuitarString / NUMBER_IN_SET) * minSetPrice, (needGuitarString - (needGuitarString % NUMBER_IN_SET)) * minPiecePrice)
                + min(minSetPrice, (needGuitarString % NUMBER_IN_SET) * minPiecePrice);
    }

    private static int[] getMinPrices(int numberOfBrands) throws IOException {
        int minSetPrice = Integer.MAX_VALUE;
        int minPiecePrice = Integer.MAX_VALUE;

        for (int i = 0; i < numberOfBrands; i++) {
            String[] priceInfo = br.readLine().split(" ");
            int setPrice = Integer.parseInt(priceInfo[0]);
            int piecePrice = Integer.parseInt(priceInfo[1]);

            if (setPrice < minSetPrice) minSetPrice = setPrice;
            if (piecePrice < minPiecePrice) minPiecePrice = piecePrice;
        }
        return new int[] {minSetPrice, minPiecePrice};
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
