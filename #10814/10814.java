import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Person implements Comparable<Person>{
        int id;
        int age;
        String name;

        public Person(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person person) {
            if (this.age > person.age) {
                return 1;
            } else if (this.age == person.age) {
                if (this.id > person.id) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();
        List<Person> list = new ArrayList<>();

        // input
        for (int i = 0; i < testCase; i++) {
            int age = in.nextInt();
            String name = in.next();

            list.add(new Person(i, age, name));
        }

        Collections.sort(list);

        for (int i = 0; i < testCase; i++) {
            System.out.println(list.get(i).age + " " + list.get(i).name);
        }

    }
}

