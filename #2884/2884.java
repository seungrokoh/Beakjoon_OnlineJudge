import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);

        if (minute - 45 < 0) {
            hour--;
            minute += 15;
        } else {
            minute -= 45;
        }

        if (hour < 0) hour = 23;

        StringBuilder builder = new StringBuilder();
        builder.append(hour).append(" ").append(minute);
        System.out.print(builder);
    }
}

