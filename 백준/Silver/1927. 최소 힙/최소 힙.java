import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Main {
    static class MinHeap {
        private int[] heap;
        private int size;

        public MinHeap(int capacity) {
            heap = new int[capacity + 1]; // idx 1부터 시작하려고
            size = 0;
        }

        public void add(int value) {
            heap[++size] = value; // 힙의 마지막 위치에 삽입
            upHeap(size); // 위로 올리기 
        }

        public int poll() {
            if (size == 0) return 0; // 힙이 비어 있으면 0 반환
            int min = heap[1]; // 최솟값 저장
            heap[1] = heap[size--]; // 마지막 원소를 루트로 이동
            downHeap(1); 
            return min;
        }

        private void upHeap(int index) {
            while (index > 1) {
                int parent = index / 2;
                if (heap[parent] <= heap[index]) break;
                swap(parent, index);
                index = parent;
            }
        }

        private void downHeap(int index) {
        	// 왼쪽 자식이 있을 때만 진행
            while (index * 2 <= size) { 
                int left = index * 2;
                int right = index * 2 + 1;
                int smallerChild = left;
                if (right <= size && heap[right] < heap[left]) {
                    smallerChild = right;
                }
                if (heap[index] <= heap[smallerChild]) break;
                swap(index, smallerChild);
                index = smallerChild;
            }
        }

        private void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }
    }

    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MinHeap minHeap = new MinHeap(N);

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                sb.append(minHeap.poll()).append("\n");
            } else {
                minHeap.add(x);
            }
        }
        System.out.print(sb);
    }
}
