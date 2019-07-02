import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] selfNumber;
    private static final int MAX_NUM = 10000;

    public static void main(String[] args) throws IOException {
        selfNumber = new boolean[MAX_NUM + 1];
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= MAX_NUM ; i++) {
            if (!selfNumber[i]) System.out.println(i);

            findNonSelfNumber(i);
        }
    }

    private static void findNonSelfNumber(int number) {

        int constructorNumber = number;
        int dn = constructorNumber;

        while(constructorNumber > 0) {
            dn += constructorNumber % 10;
            constructorNumber /= 10;
        }

        if (dn > MAX_NUM || selfNumber[dn]) return;

        selfNumber[dn] = true;
        findNonSelfNumber(dn);
    }
}
