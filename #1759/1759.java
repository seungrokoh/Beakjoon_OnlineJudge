import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int cryptographyLen;
    private static int numOfAlpha;
    private static String[] alphas;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        cryptographyLen = Integer.parseInt(input[0]);
        numOfAlpha = Integer.parseInt(input[1]);
        alphas = br.readLine().split(" ");

        Arrays.sort(alphas);

        solve(0, "");
    }

    private static void solve(int index, String ret) {
        if (ret.length() == cryptographyLen) {
            if (isPossible(ret)) {
                System.out.println(ret);
            }
            return;
        }
        if (index >= numOfAlpha) return;

        solve(index + 1, ret + alphas[index]);
        solve(index + 1, ret);
    }

    private static boolean isPossible(String ret) {
        int vowel = 0, consonant = 0;
        for (int i = 0; i < ret.length(); i++) {
            if (isVowel(ret.charAt(i))) vowel++;
            else consonant++;
        }

        return vowel >= 1 && consonant >= 2;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
