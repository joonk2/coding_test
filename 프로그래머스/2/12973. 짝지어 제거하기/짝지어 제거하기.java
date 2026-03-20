import java.util.Arrays;


class Solution {
    public int solution(String s) {
        int answer = 1;
        
        int N = s.length();
        char[] stack = new char[N];
        int idx = -1;
        
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            
            // 스택이 비어있지않고, top이랑 같다면 제거
            if (idx != -1 && stack[idx] == c) {
                idx--;
            }
            else {
                stack[++idx] = c;
            }
        }
        
        // res
        if (idx == -1) {
            answer = 1;
        }
        else answer = 0;
        
        
        
        return answer;
    }
}