import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            System.out.println(calcPower(input));
        }
    }

    private static int calcPower(String[] input) {
        int baseHp = Integer.parseInt(input[0]);
        int baseMp = Integer.parseInt(input[1]);
        int baseAttack = Integer.parseInt(input[2]);
        int baseGuard = Integer.parseInt(input[3]);

        baseHp = calcPhysical(baseHp, Integer.parseInt(input[4]));
        baseMp = calcPhysical(baseMp, Integer.parseInt(input[5]));
        baseAttack = calcAttack(baseAttack, Integer.parseInt(input[6]));
        baseGuard = calcGuard(baseGuard, Integer.parseInt(input[7]));

        return baseHp + (5 * baseMp) + (2 * baseAttack) + (2 * baseGuard);
    }

    private static int calcGuard(int baseGuard, int additional) {
        return baseGuard + additional;
    }

    private static int calcAttack(int baseAttack, int additional) {
        int temp = baseAttack + additional;
        return temp >= 0 ? temp : 0;
    }

    private static int calcPhysical(int basePhysical, int additional) {
        int temp = basePhysical + additional;
        return temp > 0 ? temp : 1;
    }
}
