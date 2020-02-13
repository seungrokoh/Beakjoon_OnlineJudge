import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = Scanner.readLineToInt();
        solve(n);
    }

    private static void solve(int n) throws IOException {
        int[][] games = new int[n][3];
        int[] result = new int[n];

        for (int player = 0; player < n; player++) {
            games[player] = Scanner.readLineToIntArray(" ");
        }

        for (int round = 0; round < 3; round++) {
            for (int player = 0; player < n; player++) {
                if (isPossibleGetPoint(games, round, player)) {
                    result[player] += games[player][round];
                }
            }
        }

        for (int score : result) {
            System.out.println(score);
        }
    }

    private static boolean isPossibleGetPoint(int[][] games, int round, int player) {
        for (int other = 0; other < games.length; other++) {
            if (player != other) {
                if ((games[player][round] ^ games[other][round]) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Scanner {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        static int readLineToInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }
        static String readLine() throws IOException {
            return br.readLine();
        }
        static String[] readLineToStringArray(String regex) throws IOException {
            return br.readLine().split(regex);
        }
        static int[] readLineToIntArray(String regex) throws IOException {
            String[] temp = readLineToStringArray(regex);
            int length = temp.length;
            int[] array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(temp[i]);
            }
            return array;
        }
    }
}
