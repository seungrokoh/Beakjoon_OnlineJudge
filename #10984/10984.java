import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int sumOfGrade = 0;
            float sumOfScore = 0;

            for (int j = 0; j < n; j++) {
                String[] information = br.readLine().split(" ");
                int grade = Integer.parseInt(information[0]);
                sumOfGrade += grade;
                sumOfScore +=  Float.parseFloat(information[1]) * grade;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(sumOfGrade).append(" ").append(String.format("%.1f", getAvg(sumOfScore, sumOfGrade)));
            System.out.println(builder);
        }
    }

    private static float getAvg(float totalScore, int n) {
        return totalScore != 0 ? totalScore / n : 0;
    }
}
