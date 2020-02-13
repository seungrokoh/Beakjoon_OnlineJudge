import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] words = Scanner.readLineToStringArray(" ");
        int col = words[0].length();  // col
        int row = words[1].length();  // row

        char[][] puzzle = new char[row][col];
        initializePuzzle(puzzle, col, row);

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (words[0].charAt(i) == words[1].charAt(j)) {
                    drawPuzzle(puzzle, words[0], words[1], i, j);
                    printPuzzle(puzzle, col, row);
                    return;
                }
            }
        }
    }

    private static void printPuzzle(char[][] puzzle, int col, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawPuzzle(char[][] puzzle, String wordA, String wordB, int col, int row) {
        for (int i = 0; i < wordA.length(); i++) {
            puzzle[row][i] = wordA.charAt(i);
        }

        for (int i = 0; i < wordB.length(); i++) {
            puzzle[i][col] = wordB.charAt(i);
        }
    }

    private static void initializePuzzle(char[][] puzzle, int col, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                puzzle[i][j] = '.';
            }
        }
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
