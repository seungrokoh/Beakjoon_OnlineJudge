import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int startNum = Integer.parseInt(input[0]);
        int modNum = Integer.parseInt(input[1]);

        System.out.println(solve(startNum, modNum));
    }

    private static int solve(int startNum, int modNum) {
        // 나머지로 나올 수 있는 수는 modNum보다 무조건 작기 때문
        Number[] nums = new Number[modNum];

        int output = startNum;
        int cycle = 0;

        while(true){
            output = (output * startNum) % modNum;

            if (nums[output] == null) {
                // null 이라면 나타난 시간을 저장
                nums[output] = new Number(output, ++cycle);
            } else {
                // 이미 나왔던 수
                return ++cycle - nums[output].appear;
            }
        }
    }

    static class Number {
        int num;
        int appear;

        public Number(int num, int appear) {
            this.num = num;
            this.appear = appear;
        }
    }
}
