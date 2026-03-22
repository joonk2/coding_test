class Solution {
    public int solution(String s) {
        int answer = 0;
        int N = s.length();
        
        
        // 1. 각 회전마다 stack 내부의 괄호를 제거할 수 있나 확인
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            char[] stack = new char[N];
            int top = -1;
            
            // 2. 회전
            for (int j = 0; j < N; j++) {
                // 2-1. 회전하는 idx
                int idx = (i+j) % N;
                char ch = s.charAt(idx);
                
                // 여는 괄호면 stack에 추가
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack[++top] = ch;
                }
                // 닫는 괄호일때
                else if (ch == ')' || ch == '}' || ch == ']') {
                    // 스택이 현재 빈칸이라면 볼필요도 없다
                    if (top == -1) {
                        flag = false;
                        break;
                    }
                    // 매칭되면 stack 칸 줄이자
                    char peek = stack[top];
                    if (peek == '(' && ch == ')') {
                        top--;
                    }
                    else if (peek == '{' && ch == '}') {
                        top--;
                    }
                    else if (peek == '[' && ch == ']') {
                        top--;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            // 스택이 빈칸이고 true일때 answer++
            if (top == -1 && flag) answer++;
        }
        
        return answer;
    }
}