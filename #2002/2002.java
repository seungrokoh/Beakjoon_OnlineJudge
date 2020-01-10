import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = Scanner.readLineToInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) throws IOException {
        LinkedList<String> enterQueue = new LinkedList<>();
        Queue<String> exitQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            enterQueue.add(Scanner.readLine());
        }
        for (int i = 0; i < n; i++) {
            exitQueue.add(Scanner.readLine());
        }

        int answer = 0;

        while (!enterQueue.isEmpty() && !exitQueue.isEmpty()) {
            if (enterQueue.peek().equals(exitQueue.peek())) {
                enterQueue.poll();
                exitQueue.poll();
            } else {
                answer++;
                final String carNumber = exitQueue.peek();
                enterQueue.remove(carNumber);
                enterQueue.addFirst(carNumber);
            }
        }
        return answer;
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
