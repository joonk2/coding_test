import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        // 1. 판별기
        int[] res = my_converter(prices, N, answer);
        return res;
    }
    
    // 2. my_converter 함수
    static int[] my_converter(int[] prices, int N, int[] answer) {
        
        // 2-1. my_stack 객체 생성
        my_stack stack_v1 = new my_stack(N);
        
        // 2-2. 길이 계산을 위해 stack에는 값이 아닌 idx를 저장하자
        // idx를 저장하다가 stack의 마지막 idx를 price에 적용한 값이 prices[i] 보다 크면, 현재값보다 작을떄까지 추출
        
        for (int i = 0; i < N; i++) {
            int cur_price = prices[i];
            
            // 2-2-a. 스택이 비어있지 않고 && prices[stack_v1.peek()] > cur_price -> pop
            while (!stack_v1.isEmpty() && prices[stack_v1.peek()] > cur_price) {
                int idx = stack_v1.pop();
                answer[idx] = i - idx;
            }
            
            // 2-2-b. 위 while문 조건에 해당사항 없으면 그냥 스택에 현재 idx나 추가해라
            stack_v1.push(i);
        }
        
        // 2-3. stack에 남은 idx 계산
        while (!stack_v1.isEmpty()) {
            int idx = stack_v1.pop();
            answer[idx] = N - 1 - idx;
        }
        
        
        
        return answer;
    }
    
    
    
    // 3. my_stack 클래스
    static class my_stack {
        
        // 3-1. 데이터 상태 정의
        private int top;
        private int[] stack_v1;
        
        // 3-2. my_stack 생성자
        my_stack(int size) {
            top = -1;
            stack_v1 = new int[size];
        }
        
        // 3-3. push
        void push(int value) {
            top++;
            stack_v1[top] = value;
        }
        
        // 3-4. pop
        int pop() {
            int value = stack_v1[top];
            top--;
            return value;
        }
        
        // 3-5. peek
        int peek() {
            int value = stack_v1[top];
            return value;
        }
        
        // 3-6. isEmpty
        boolean isEmpty() {
            if (top != -1) return false;
            return true;
        }
        
        // 3-7. size
        int size() {
            return top + 1;
        }
        
    }
    
}