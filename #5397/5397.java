import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            String str = br.readLine();
            Deque<Character> leftQueue = new ArrayDeque<>();
            Deque<Character> rightQueue = new ArrayDeque<>();

            for (int index = 0, len = str.length(); index < len; index++) {
                char c = str.charAt(index);
                switch (c) {
                    case '<':
                        if (!leftQueue.isEmpty()) rightQueue.addFirst(leftQueue.pollLast());
                        break;
                    case '>':
                        if (!rightQueue.isEmpty()) leftQueue.addLast(rightQueue.pollFirst());
                        break;
                    case '-':
                        if (!leftQueue.isEmpty()) leftQueue.pollLast();
                        break;
                    default:
                        leftQueue.add(c);
                }
            }
            while(!leftQueue.isEmpty()) result.append(leftQueue.pollFirst());
            while(!rightQueue.isEmpty()) result.append(rightQueue.pollFirst());
            result.append("\n");
        }

        System.out.println(result);
    }
}
