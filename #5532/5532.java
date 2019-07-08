import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int vacationDays = Integer.parseInt(br.readLine());
        int totalLangPages = Integer.parseInt(br.readLine());
        int totalMathPages = Integer.parseInt(br.readLine());
        int langOneDay = Integer.parseInt(br.readLine());
        int mathOneDay = Integer.parseInt(br.readLine());

        System.out.println(solve(vacationDays, totalMathPages, totalLangPages, langOneDay, mathOneDay));
    }

    private static int solve(int vacationDays, int totalMathPages, int totalLangPages, int langOneDay, int mathOneDay) {
        while(totalLangPages > 0 || totalMathPages > 0) {
            totalLangPages -= langOneDay;
            totalMathPages -= mathOneDay;
            vacationDays--;
        }
        return vacationDays > 0 ? vacationDays : 0;
    }

}
