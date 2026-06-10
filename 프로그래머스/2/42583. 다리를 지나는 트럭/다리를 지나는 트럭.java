import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 1. q 생성 (시간, 무게)
        Queue<int[]> q = new LinkedList<>();
        
        // 2. 계산
        int time = 1;
        int N = truck_weights.length;
        int idx = 0;
        int limit = 0;
        while (true) {
            // 2-1. 내릴 수 있는지?
            if (!q.isEmpty()) {
                int[] cur_pos = q.peek();
                int first_t = cur_pos[0];
                int diff = time - first_t;
                // 2-1-a. 만약 diff == 다라길이 라면
                if (diff == bridge_length) {
                    // 2-1-b. 적발
                    int[] caught_pos = q.poll();
                    int caught_w = caught_pos[1];
                    limit -= caught_w;
                }
            }
            
            // 2-2. q가 비었고 더이상 다리에 올릴 트럭이 없다면 종료
            if (q.isEmpty() && idx >= N) break;
            
            // 2-3. 인덱스 초과라면
            if (idx >= N) {
                time++;
                continue;
            }
            
            // 2-4. 트럭이 다리에 올라올 수 있다면?
            int cur_w = truck_weights[idx];
            if (weight >= limit + cur_w) {
                limit += cur_w;
                q.add(new int[] {time, cur_w});
                idx++;
            }
            
            // 3. 시간 추가
            time++;
            
        }
        
        return time;
    }
}