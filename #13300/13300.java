import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int studentNum = Integer.parseInt(input[0]);
        int capacity = Integer.parseInt(input[1]);
        int[][] students = getStudents(studentNum);

        System.out.println(solve(students, capacity));
    }

    private static int solve(int[][] students, int capacity) {
        int roomCount = 0;
        for (int i = 0; i < students.length; i++) {
            for (int j = 1; j < students[0].length; j++) {
                if (students[i][j] != 0) roomCount += calcNeedRoom(students[i][j], capacity);
            }
        }
        return roomCount;
    }

    private static int calcNeedRoom(int numberOfStudent, int capacity) {
        return numberOfStudent % capacity == 0 ? numberOfStudent / capacity : (numberOfStudent / capacity) + 1;
    }

    private static int[][] getStudents(int studentNum) throws IOException {
        int[][] temp = new int[2][7];
        for (int i = 0; i < studentNum; i++) {
            String[] input = br.readLine().split(" ");
            int sex = Integer.parseInt(input[0]);
            int grade = Integer.parseInt(input[1]);
            temp[sex][grade] += 1;
        }
        return temp;
    }
}
