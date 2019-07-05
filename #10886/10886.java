import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int numOfPerson = Integer.parseInt(br.readLine());
        System.out.println(solve(numOfPerson));
    }

    private static String solve(int numOfPerson) throws IOException {
        int numOfPositive = 0;
        for (int i = 0; i < numOfPerson; i++) {
            if (Integer.parseInt(br.readLine()) == 1) {
                numOfPositive++;
            }
        }
        return numOfPerson - numOfPositive > numOfPositive ? "Junhee is not cute!" : "Junhee is cute!";
    }
}
