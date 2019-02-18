import java.util.Scanner;

public class Main {

    static int n;

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        s.solution(n);
    }

    static class Solution {
        int index;
        int[] arr = new int[3];
        int cnt = 99;

        public Solution () { }

        void solution(int n){
            if (n < 100) {
                System.out.print(n);
                return;
            }
            if (n == 1000) {
                n = 999;
            }

            for (int i = 100; i <= n; i++) {
                int temp = i;
                index = 0;

                while (temp != 0) {
                    arr[index++] = temp % 10;
                    temp /= 10;
                }

                if (arr[0] - arr[1] == arr[1] - arr[2]) {
                    cnt++;
                }
            }

            System.out.print(cnt);
        }
    }
}

