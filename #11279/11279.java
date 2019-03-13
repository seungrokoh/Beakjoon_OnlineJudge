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
        solve(arr, n);
    }

    static void solve(int[] arr, int n){
        MaxHeapImpl maxHeap = new MaxHeapImpl(arr.length);

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                maxHeap.add(arr[i]);
            } else {
                maxHeap.remove();
            }
        }
    }


    static class MaxHeapImpl implements MaxHeap {
        int[] heap;
        int size = 0;

        public MaxHeapImpl(int n){
            heap = new int[n + 1];
        }
        @Override
        public void add(int n) {
            int temp;
            heap[++size] = n;

            for (int i = size; i > 1; i /= 2) {
                // 마지막 노드가 자신의 부모 노드 (i / 2)보다 크면 swap
                if (heap[i / 2] < heap[i]) {
                    temp = heap[i / 2];
                    heap[i / 2] = heap[i];
                    heap[i] = temp;
                } else {
                    break;
                }
            }
        }

        @Override
        public void remove() {
            if (isEmpty()) {
                System.out.println("0");
                return;
            }

            System.out.println(heap[1]);
            heap[1] = heap[size];
            heap[size--] = 0;

            heapify();
        }

        @Override
        public void heapify() {
            int left, right, temp;

            for (int i = 1; (i * 2) <= size;) {
                // 마지막 노드가 두 자식보다 크면 끝낸다.
                left = i * 2;
                right = i * 2 + 1;

                if (heap[i] > heap[left] && heap[i] > heap[right]) {
                    break;
                }

                if (heap[left] > heap[right]) {
                    temp = heap[i];
                    heap[i] = heap[left];
                    heap[left] = temp;
                    i = left;
                } else {
                    temp = heap[i];
                    heap[i] = heap[right];
                    heap[right] = temp;
                    i = right;
                }
            }
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }
    }
    public interface MaxHeap {
        void add(int n);
        void remove();
        void heapify();
        boolean isEmpty();
    }
}
