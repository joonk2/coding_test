/*
prices = {1,3,2,3,6,4,5,2,1}
result = {8,1,6,4,1,2,1,1,0}
*/


class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] res = new int[N];
        
        // 1. stack 선언
        my_stack stack_v1 = new my_stack(N);
        
        // 2. prices[i]의 idx를 가격이 떨어지기 전까지 몇초동안 유지되는지?
        // 현재 가격이 stack에 저장된 마지막 가격보다 작으면 stack에 있는 idx 추출
        for (int i = 0; i < N; i++) {
            // 2-1. stack이 비어있지 않고 && 현재 가격 < stack의 마지막가격 일때
            int cur_price = prices[i];
            while (!stack_v1.isEmpty() && prices[stack_v1.peek()] > cur_price) {
                int idx = stack_v1.pop();
                res[idx] = i - idx;
            }
            // 2-2. stack에 현재 idx 추가
            stack_v1.push(i);
        }
        
        // 3. 스택 안에 남은 원소들 마저 제거
        while (!stack_v1.isEmpty()) {
            int idx = stack_v1.pop();
            res[idx] = N-1 - idx;
        }
        
        
        return res;
    }
    
    
    // 4. stack 클래스
    static class my_stack {
        
        // 4-1. 데이터 상태 정의
        private int top;
        private int[] stack_v1;
        
        // 4-2. 생성자
        my_stack(int size) {
            top = -1;
            stack_v1 = new int[size];
        }
        
        // 4-3. push
        void push(int value) {
            top++;
            stack_v1[top] = value;
        }
        
        // 4-4. pop
        int pop() {
            int value = stack_v1[top];
            top--;
            return value;
        }
        
        // 4-5. peek
        int peek() {
            int value = stack_v1[top];
            return value;
        }
        
        // 4-6. isEmpty
        boolean isEmpty() {
            if (top != -1) return false;
            return true;
        }
        
        // 4-7. size
        int size() {
            return top + 1;
        }
        
    }
    
    
    
}