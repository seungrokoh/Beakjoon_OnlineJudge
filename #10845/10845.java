import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine());

        solve(testCase);
    }

    static void solve(int testCase) throws IOException {
        QueueImpl queue = new QueueImpl();
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                queue.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                System.out.println(queue.pop());
            } else if (input[0].equals("size")) {
                System.out.println(queue.size());
            } else if (input[0].equals("empty")){
                System.out.println(queue.empty());
            } else if (input[0].equals("front")) {
                System.out.println(queue.front());
            } else if (input[0].equals("back")) {
                System.out.println(queue.back());
            }
        }
    }
}


interface MyQueue {
    int MAX_SIZE = 10000;
    void push(int num);
    int pop();
    int size();
    int empty();
    int front();
    int back();
}

class QueueImpl implements MyQueue {

    int[] item = new int[MAX_SIZE];
    int head = 0;
    int curSize = 0;

    @Override
    public void push(int num) {
        if (curSize != MAX_SIZE) {
            item[curSize++] = num;
        }
    }

    @Override
    public int pop() {
        return curSize - head > 0 ? item[head++] : -1;
    }

    @Override
    public int size() {
        return curSize - head;
    }

    @Override
    public int empty() {
        return curSize - head > 0 ? 0 : 1;
    }

    @Override
    public int front() {
        return curSize - head > 0 ? item[head] : -1;
    }

    @Override
    public int back() {
        return curSize - head > 0 ? item[curSize - 1] : -1;
    }
}
