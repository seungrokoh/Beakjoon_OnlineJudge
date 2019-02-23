import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Point implements Comparable<Point>{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (this.y > point.y) {
                return 1;
            } else if (this.y == point.y){
                if (this.x > point.x) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Point> points = new ArrayList<>();
        int testcase = in.nextInt();

        // input
        for (int i = 0; i < testcase; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            points.add(new Point(x, y));
        }

        Collections.sort(points);

        for (int i = 0; i < testcase; i++) {
            System.out.println(points.get(i).x + " " + points.get(i).y);
        }
    }
}

