import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static char[] alpha = {'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'};

    public static void main(String[] args) throws IOException {
        
        char[] cipher = new char[101];
        while (true) {

            String str = br.readLine();
            if (str.equals("START")) {
                cipher = br.readLine().toCharArray();

                for (int i = 0; i < cipher.length; i++) {
                    char c = cipher[i];
                    if (c >= 65 && c <= 90) {
                        cipher[i] = alpha[c - 'A'];
                    }
                }
            }

            if (str.equals("ENDOFINPUT")) {
                break;
            }

            if (str.equals("END")) {
                System.out.println(cipher);
            }
        }

    }
}
