import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        
        
        
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                if (S.charAt(i-1) == '(') {
                    cnt += stack.size() -1;
                    stack.pop();
                }
                else {
                    cnt += 1;
                    stack.pop();
                }
            }
        }
        
        
        
        System.out.println(cnt);
        


    }
}