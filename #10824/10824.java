import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        String num1 = input[0] + input[1];
        String num2 = input[2] + input[3];
        
        long result = Long.parseLong(num1) + Long.parseLong(num2);
        System.out.println(result);
    }

}
