// prim
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 1. graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 2. 전체를 최소비용으로 순회 (prim) -> 양방향 
        for (int[] c : costs) {
            int cur_node = c[0];
            int cur_to = c[1];
            int cur_cost = c[2];
            graph[cur_node].add(new int[] {cur_to, cur_cost});
            graph[cur_to].add(new int[] {cur_node, cur_cost});
        }
        
        // 3. visited[]
        boolean[] visited = new boolean[n];
        
        // 4. pq -> 비용 오름차순 (작은 값부터 나열)
        PriorityQueue<int[]> pq = new PriorityQueue<> (
            (a,b) -> a[1] - b[1]
        );
        
        // 5. 시작점 삽입 (start_node, start_cost);
        pq.offer(new int[] {0, 0});
        
        // 6. prim
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_node = cur[0];
            int cur_cost = cur[1];
            
            // 6-1. 만약 방문했다면 skip
            if (visited[cur_node]) continue;
            
            // 6-2. 방문 안했다면 -> 방문
            visited[cur_node] = true;
            
            // 6-3. 값 추가 (어차피 오름차순이라 제일 작은것부터 순서대로 나열)
            answer += cur_cost;
            
            // 6-4. next_node
            for (int[] next : graph[cur_node]) {
                int next_node = next[0];
                int next_cost = next[1];
                
                // 6-5. 만약 next_node 방문 안했다면
                if (!visited[next_node]) {
                    pq.offer(new int[] {next_node, next_cost});
                }
            }
        }
        
        return answer;
    }
}