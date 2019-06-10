import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<Conference> conferences = getSortedConferenceInfo(n);

        System.out.println(solve(conferences));
    }

    private static int solve(List<Conference> conferences) {
        int ret = 0;
        int start = 0;
        for (int i = 0; i < conferences.size(); i++) {
            if (start <= conferences.get(i).startTime) {
                ret++;
                start = conferences.get(i).endTime;
            }
        }

        return ret;
    }

    static List<Conference> getSortedConferenceInfo(int n) throws IOException {
        List<Conference> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputTime = br.readLine().split(" ");
            temp.add(new Conference(Integer.parseInt(inputTime[0]), Integer.parseInt(inputTime[1])));
        }
        Collections.sort(temp);
        return temp;
    }

    static class Conference implements Comparable<Conference> {
        int startTime;
        int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Conference conference) {
            if (this.endTime < conference.endTime) return -1;
            if (this.endTime == conference.endTime) {
                return this.startTime - conference.startTime;
            }
            return 1;
        }
    }
}
