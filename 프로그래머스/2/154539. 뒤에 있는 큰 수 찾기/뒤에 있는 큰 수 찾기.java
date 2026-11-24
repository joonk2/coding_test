import java.util.Stack;


class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        
        // 1. stack생성
        Stack<Integer> stack = new Stack<>();
 
        // 2. 역순으로 검사
        for (int i = N-1; i >= 0; i--) {
            int cur_num = numbers[i];
            
            // 2-1. 스택이 비지않았고, 현재 숫자가 스택의 꼭대기보다 크거나 같을 동안
            while (!stack.isEmpty() && cur_num >= stack.peek()) {
                stack.pop();
            }
            
            // 2-2. 만약 스택이 비었다면?
            if (stack.isEmpty()) {
                answer[i] = -1;
            }
            // 2-3. 만약 스택이 안비었다면?
            else if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            
            // 2-4. 스택에 원소 추가
            stack.push(cur_num);
        }
        
        // 3. 답
        return answer;
    }
}