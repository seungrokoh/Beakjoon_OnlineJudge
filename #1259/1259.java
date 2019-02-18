import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            String str = in.next();
            if (str.equals("0")) {
                break;
            }
            boolean isPal = true;
            int len = str.length();
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1)) {
                    isPal = false;
                }
            }

            if (isPal) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

