import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int operation = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        // 1. 초기값 삽입
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        // 2. 조기종료 (합이 홀수 일때)
        if ( (sum1 + sum2) % 2 == 1 ) {
            return -1;
        }
        
        
        // 3. 확인
        int limit = queue1.length * 3;
        
        while (sum1 != sum2) {
            // 3-1. 무한루프시 종료
            if (operation > limit) return -1;
            
            // 3-2. 그외
            
            if (sum1 > sum2) {
                int cur_val = q1.poll();
                sum1 -= cur_val;
                
                q2.add(cur_val);
                sum2 += cur_val;
            }
            else if (sum1 <= sum2) {
                int cur_val = q2.poll();
                sum2 -= cur_val;
                
                q1.add(cur_val);
                sum1 += cur_val;
            }
            
            operation++;
        }
        
        return operation;
    }
}