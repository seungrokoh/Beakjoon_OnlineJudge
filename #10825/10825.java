import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            students.add(new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
        }

        Collections.sort(students);

        for (Student item :
                students) {
            System.out.println(item.toString());
        }
    }

    public static class Student implements Comparable<Student> {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student student) {
            if (this.kor == student.kor && this.eng == student.eng && this.math == student.math) {
                return this.name.compareTo(student.name);
            } else if (this.kor == student.kor && this.eng == student.eng) {
                return Integer.compare(student.math, this.math);
            } else if (this.kor == student.kor) {
                return Integer.compare(this.eng, student.eng);
            }
            return Integer.compare(student.kor, this.kor);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}

