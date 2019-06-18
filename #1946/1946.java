import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCycle = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCycle; i++) {
            List<Employee> employeeList = inputSortedEmployees();
            System.out.println(solve(employeeList));
        }
    }

    private static int solve(List<Employee> employeeList) {
        int cnt = 0;
        int minInterViewRank = Integer.MAX_VALUE;

        for (Employee employee : employeeList) {
            if (employee.interviewRank < minInterViewRank) {
                cnt++;
                minInterViewRank = employee.interviewRank;
            }
        }
        return cnt;
    }

    private static List<Employee> inputSortedEmployees() throws IOException {
        int num = Integer.parseInt(br.readLine());
        List<Employee> employeeList = new ArrayList<>();
        for (int j = 0; j < num; j++) {
            String[] rankInput = br.readLine().split(" ");
            employeeList.add(new Employee(Integer.parseInt(rankInput[0]), Integer.parseInt(rankInput[1])));
        }
        Collections.sort(employeeList);
        return employeeList;
    }


    static class Employee implements Comparable<Employee>{
        int documentRank;
        int interviewRank;

        public Employee(int documentRank, int interviewRank) {
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }

        @Override
        public int compareTo(Employee employee) {
            return this.documentRank - employee.documentRank;
        }
    }
}
