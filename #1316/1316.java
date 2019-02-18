import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char[] str = in.next().toCharArray();
            int len = str.length;
            boolean flag = true;
            int[] alpha = new int[26];
            
            for (int index = 0; index < len; index++) {
                alpha[str[index] - 'a']++;
		// 해당 알파벳이 1번 이라도 사용 했는지 확인
                if (index > 0 && alpha[str[index] - 'a'] > 1) {
                    if (str[index] != str[index - 1]) {
                        flag = false;
                    }
                }
            }
            if (flag) cnt++;
        }

        System.out.print(cnt);
    }
}

