import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] seven = br.readLine().split(" ");
        List<Double> priceList = new ArrayList<>();
        priceList.add(Double.parseDouble(seven[0]) / Double.parseDouble(seven[1]));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] price = br.readLine().split(" ");
            priceList.add(Double.parseDouble(price[0]) / Double.parseDouble(price[1]));
        }

        Collections.sort(priceList);
        System.out.println(String.format("%.2f", priceList.get(0) * 1000));
    }
}
