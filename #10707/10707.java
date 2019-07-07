import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int feeOfA = Integer.parseInt(br.readLine());
        int baseFeeOfB = Integer.parseInt(br.readLine());
        int limit = Integer.parseInt(br.readLine());
        int additionalFee = Integer.parseInt(br.readLine());
        int waterUsage = Integer.parseInt(br.readLine());

        System.out.println(solve(feeOfA, baseFeeOfB, limit, additionalFee, waterUsage));
    }

    private static int solve(int feeOfA, int baseFeeOfB, int limit, int additionalFee, int waterUsage) {
        int payX = feeOfA * waterUsage;
        int payB = baseFeeOfB;

        if (waterUsage > limit) payB += ((waterUsage - limit) * additionalFee);

        return payX < payB ? payX : payB;
    }

}
