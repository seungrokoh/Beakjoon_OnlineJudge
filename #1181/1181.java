import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<String> words = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이 순 정렬
                if (s1.length() < s2.length()) {
                    return -1;
                } else if (s1.length() > s2.length()){
                    return 1;
                } else {
                    // 길이가 같으면 사전 순 정렬
                    return s1.compareTo(s2);
                }
            }
        });

        for (int i = 0; i < n; i++) {
            words.add(in.next());
        }

        StringBuilder builder = new StringBuilder();
        for (String it : words) {
            builder.append(it).append("\n");
        }

        System.out.print(builder.toString());
    }
}

