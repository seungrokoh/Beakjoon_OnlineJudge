import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        Country[] countries = new Country[n];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int num = Integer.parseInt(in[0]);
            int gold = Integer.parseInt(in[1]);
            int silver = Integer.parseInt(in[2]);
            int bronze = Integer.parseInt(in[3]);
            countries[i] = new Country(num, gold, silver, bronze);
        }

        solve(countries, target);


    }

    private static void solve(Country[] countries, int target) {
        int len = countries.length;

        Arrays.sort(countries);

        int curRank = 1;
        countries[0].setRank(curRank++);

        if (countries[0].isNum(target)) {
            System.out.println(countries[0].getRank());
            return;
        }

        for (int i = 1; i < len; i++, curRank++) {
            Country pre = countries[i - 1];
            Country cur = countries[i];
            if (pre.isEqualAll(cur)) {
                cur.setRank(pre.getRank());
            } else {
                cur.setRank(curRank);
            }

            if (cur.isNum(target)) {
                System.out.println(cur.getRank());
                return;
            }
        }
    }

    static class Country implements Comparable<Country> {
        private int num, gold, silver, bronze, rank;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public boolean isNum(int target) {
            return this.num == target;
        }

        public boolean isEqualAll(Country country) {
            return this.gold == country.gold &&
                    this.silver == country.silver &&
                    this.bronze == country.bronze;
        }

        @Override
        public int compareTo(Country country) {
            if (country.gold > this.gold){
                return 1;
            } else if (this.gold == country.gold && this.silver == country.silver) {
                return country.bronze - this.bronze;
            } else if (this.gold == country.gold) {
                return country.silver - this.silver;
            }

            return -1;
        }
    }
}
