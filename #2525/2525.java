import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);

        int time = Integer.parseInt(br.readLine());

        solve(hour, minute, time);
    }

    private static void solve(int hour, int minute, int time) {
        int addHour = time / 60;
        int addMinute = time % 60;

        hour += addHour;
        minute += addMinute;

        if (minute >= 60) {
            hour += minute / 60;
            minute = minute % 60;
        }

        hour %= 24;

        System.out.println(hour + " " + minute);
    }
}
