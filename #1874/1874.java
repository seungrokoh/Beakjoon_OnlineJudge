import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StackImple stack = new StackImple(n);
        StringBuilder builder= new StringBuilder();

        int index = 1;
        for (int i = 0; i < n; i++) {
            int curItem = arr[i];
            while(true){
                if (index == curItem){
                    index++;
                    builder.append("+\n").append("-\n");
                    break;
                }

                if (curItem > index){
                    stack.push(index++);
                    builder.append("+\n");
                }

                if (curItem < index && !stack.isEmpty()) {
                    if (stack.top() != curItem){
                        System.out.println("NO");
                        return;
                    }
                    stack.pop();
                    builder.append("-\n");
                    break;
                }
            }
        }

        System.out.println(builder);
    }


    interface MyStack {
        void push(int n);
        void pop();
        int top();
        boolean isEmpty();
    }

    static class StackImple implements MyStack {

        int[] arr;
        int size;

        public StackImple(int size) {
            this.arr = new int[size];
            this.size = -1;
        }

        @Override
        public void push(int n) {
            arr[++size] = n;
        }

        @Override
        public void pop() {
            size--;
        }

        @Override
        public int top() {
            return arr[size];
        }


        @Override
        public boolean isEmpty() {
            return this.size < 0;
        }
    }

}
