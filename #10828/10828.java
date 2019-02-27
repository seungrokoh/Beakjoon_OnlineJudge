import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine());

        solve(testCase);
    }

    static void solve(int testCase) throws IOException {
        StackImpl stack = new StackImpl();
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                stack.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                System.out.println(stack.pop());
            } else if (input[0].equals("size")) {
                System.out.println(stack.size());
            } else if (input[0].equals("empty")){
                System.out.println(stack.empty());
            } else if (input[0].equals("top")) {
                System.out.println(stack.top());
            }
        }
    }
}


interface MyStack {
    int MAX_SIZE = 10000;
    void push(int num);
    int pop();
    int size();
    int empty();
    int top();
}

class StackImpl implements MyStack {

    int[] item = new int[MAX_SIZE];
    int curSize = 0;

    @Override
    public void push(int num) {
        if (curSize != MAX_SIZE) {
            item[curSize++] = num;
        } else {
            System.out.println("over flow");
        }
    }

    @Override
    public int pop() {
        return curSize > 0 ? item[--curSize] : -1;
    }

    @Override
    public int size() {
        return this.curSize;
    }

    @Override
    public int empty() {
        return curSize > 0 ? 0 : 1;
    }

    @Override
    public int top() {
        return curSize > 0 ? item[curSize - 1] : -1;
    }
}
