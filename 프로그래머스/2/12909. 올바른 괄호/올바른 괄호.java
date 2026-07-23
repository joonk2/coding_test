class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int N = s.length();        
        char[] stack = new char[N];
        int top = -1;
        int idx = 0;
        while (idx < N) {
            char c = s.charAt(idx);
            
            if (c == '(') {
                top++;
                stack[top] = c;
            }
            else if (c == ')') {
                // 만약 맨앞이면
                if (top == -1) return false;
                // 그게 아니라면
                if (stack[top] == '(') {
                    top--;
                }
            }
            
            // 다음으로 전환
            idx++;
        }
        
        // 최종답 (조건)
        if (top != -1) return false;
        return answer;
    }
}