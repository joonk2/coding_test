import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String S = st.nextToken();

            if (S.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            else if (S.equals("pop")) {
                if (stack.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.pop());
                }
            }

            else if (S.equals("size")) {
                System.out.println(stack.size());
            }

            else if (S.equals("empty")) {
                if (stack.empty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }

            else if (S.equals("top")) {
                if (stack.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                }
            }






        }


    }
}