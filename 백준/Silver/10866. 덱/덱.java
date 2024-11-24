import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String word = st.nextToken();

            if (word.equals("push_front")) {
                queue.addFirst(Integer.parseInt(st.nextToken()));
            }

            else if (word.equals("push_back")) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            }

            else if (word.equals("pop_front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.pollFirst());
                }
            }

            else if (word.equals("pop_back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.pollLast());
                }
            }

            else if (word.equals("size")) {
                System.out.println(queue.size());
            }

            else if (word.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }

            else if (word.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.peekFirst());
                }
            }

            else if (word.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.peekLast());
                }
            }



        }



    }
}