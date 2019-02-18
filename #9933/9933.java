import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> password = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            password.add(in.next());
        }
        
        for (int i = 0; i < n; i++) {
            String reverse = new StringBuffer(password.get(i)).reverse().toString();
            if (password.contains(reverse)) {
                System.out.print(reverse.length() + " " + reverse.charAt(reverse.length() / 2));
                break;
            }
        }


    }
}

