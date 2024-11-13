import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 카드 갯수

        // 카드 array --> 카드 순서 거꾸로 역추리(reverse)
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int skill = Integer.parseInt(st.nextToken());

            if (skill == 1) {
                deque.addFirst(i);
            }

            else if (skill == 2) {
                int top = deque.removeFirst();
                deque.addFirst(i);
                deque.addFirst(top);
            }

            else if (skill == 3) {
                deque.addLast(i);
            }


        }

        // Sb에 저장 후 출력
        StringBuilder sb = new StringBuilder();
        while (deque.size() != 0) {
            sb.append(deque.removeFirst()).append(" ");
        }


        System.out.print(sb.toString());



    }
}