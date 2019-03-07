import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = "";
        while ((input = br.readLine()) != null) {
            char[] str = input.toCharArray();
            int lowerCase = 0, upperCase = 0, number = 0, blank = 0;

            for (int i = 0; i < str.length; i++) {
                if (str[i] >= 'a' && str[i] <= 'z') {
                    lowerCase++;
                } else if (str[i] >= 'A' && str[i] <= 'Z') {
                    upperCase++;
                } else if (str[i] >= '0' && str[i] <= '9') {
                    number++;
                } else {
                    blank++;
                }
            }

            System.out.println(lowerCase + " " + upperCase + " " + number + " " + blank);
        }

    }

}
