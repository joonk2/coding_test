import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time_ticktok = 0;
        int i = 0;
        int temp_sum = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        
        while (!q.isEmpty() || i < truck_weights.length) {
            time_ticktok++;
            
            // 1. 다리 검사 먼저 진행 (트럭을 올려보낼 수 있는지)
            if (!q.isEmpty()) {
                int[] front = q.peek();
                if (time_ticktok - front[0] == bridge_length) {
                    temp_sum -= front[1];
                    q.poll();
                }
            }
            
            // 2. 트럭을 출발시킬 수 있는지 확인
            if (i < truck_weights.length) {
                if (temp_sum + truck_weights[i] <= weight) {
                    temp_sum += truck_weights[i];
                    q.add(new int[] {time_ticktok, truck_weights[i]});
                    i++;
                }
            }
            
        }
        return time_ticktok;
    }
}