import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //useScanner();
        useBufferedReader();
    }

    public static void useScanner(){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(in.nextLine());
        }
        in.close();
    }

    public static void useBufferedReader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}

