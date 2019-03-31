import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (!map.containsKey(num)) {
                // 키가 없을 경우
                map.put(num, 1);
            } else {
                int cnt = map.get(num);
                map.put(num, cnt + 1);
            }
        }

        ArrayList<Number> list = new ArrayList<>();
        for (long key :
                map.keySet()) {
            int val = map.get(key);
            list.add(new Number(key, val));
        }

        Collections.sort(list);

        System.out.print(list.get(0).num);
    }

    static class Number implements Comparable<Number> {
        long num;
        int cnt;

        public Number(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number number) {
            if (this.cnt != number.cnt) {
                return number.cnt - this.cnt;
            } else {
                if (this.num > number.num) {
                    return 1;
                }
            }
            return -1;
        }
    }

}
