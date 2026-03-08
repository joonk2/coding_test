import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int cnt = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        int N = queue1.length;
        for (int i = 0; i < N; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        // 1. 조기종료
        if ( (sum1 + sum2) % 2 == 1) return -1; 
        
        
        // 2. 수행
        int limit = (queue1.length + queue2.length) * 2;
        while (sum1 != sum2) {
            
            // limit
            if (cnt > limit) return -1;
            
            if (sum1 > sum2) {
                int cur_val = q1.poll();
                sum1 -= cur_val;
                q2.add(cur_val);
                sum2 += cur_val;
            }
            else if (sum1 < sum2) {
                int cur_val = q2.poll();
                sum2 -= cur_val;
                q1.add(cur_val);
                sum1 += cur_val;
            }
            
            // 횟수 추가
            cnt++;
        }
        
        
        return cnt;
    }
}