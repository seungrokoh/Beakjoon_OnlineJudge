import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        String number = br.readLine();
        StringTokenizer st = new StringTokenizer(number, " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Solve problem = new Solve(n, arr);
        System.out.print(problem.solve(k));
    }

    public static class Solve {
        int size;
        int[] arr;

        public Solve(int size, int[] arr) {
            this.size = size;
            this.arr = arr;
        }

        public int solve(int index){
            Arrays.sort(this.arr);
            return arr[index - 1];
        }
    }
}

