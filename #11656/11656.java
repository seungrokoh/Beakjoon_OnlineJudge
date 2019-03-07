import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int len = input.length();

        TreeSet<String> tree = new TreeSet<>(new CompareString());

        for (int i = 0; i < len; i++) {
            tree.add(input.substring(i));
        }

        for (String s : tree) {
            System.out.println(s);
        }

    }

    static class CompareString implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }


}
