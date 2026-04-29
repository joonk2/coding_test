// dijikstra
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

// test
import java.util.Arrays;


class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 1. graph 생성
        List<int[]>[] graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 2. 양방향 -> cur_node, cur_to, cur_cost
        for (int i = 0; i < road.length; i++) {
            int[] cur_pos = road[i];
            int cur_node = cur_pos[0];
            int cur_to = cur_pos[1];
            int cur_cost = cur_pos[2];
            graph[cur_node].add(new int[] {cur_to, cur_cost});
            graph[cur_to].add(new int[] {cur_node, cur_cost});
        }
        
        // 3. dist 생성후 초기화
        int[] dist = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        // 4. 시작점에 초기 비용 삽입
        dist[1] = 0;
        
        // 5. 비용 asc
        PriorityQueue<int[]> pq = new PriorityQueue<> (
            (a,b) -> a[1] - b[1]
        );
        
        // 6. pq에 시작점 삽입
        pq.offer(new int[] {1, 0});
        
        // 7. 탐색
        while (!pq.isEmpty()) {
            int[] cur_pos = pq.poll();
            int cur_node = cur_pos[0];
            int cur_cost = cur_pos[1];
            
            // 7-1. 현재 비용이 dist에 저장된 비용보다 비싸면 skip
            if (cur_cost > dist[cur_node]) continue;
            
            // 7-2. 안그렇다면
            for (int[] next : graph[cur_node]) {
                int next_node = next[0];
                int next_cost = cur_cost + next[1];
                
                // 7-3. 다음 비용이 다음 노드보다 더 싸다면
                if (dist[next_node] > next_cost) {
                    dist[next_node] = next_cost;
                    pq.offer(new int[] {next_node, next_cost});
                }
            } 
        }
        
        // 8. 갯수 확인
        for (int i = 1; i < N+1; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}