import java.util.Stack;

class Solution {
    public int solution(String s) {
        int cnt = 0;
        int N = s.length();
        
        // 조기종료
        if (N % 2 != 0) {
            int res = 0;
            return res;
        }
        
        // 조기종료 아니라면
        char[] arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }
     	
        
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
        	for (int j = 0; j < N; j++) {
                int idx = (i+j) % N;
                char ch = arr[idx];
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
                else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    else if (!stack.isEmpty()) {
                        char top = stack.peek();
                        if (ch == ')' && top == '(') stack.pop();
                        else if (ch == '}' && top == '{') stack.pop();
                        else if (ch == ']' && top == '[') stack.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            // 검사
            if (stack.isEmpty() && flag) cnt++;
        } 
        return cnt;
    }
    
    
    
}