// graph
import java.util.List;
import java.util.ArrayList;

// bfs
import java.util.Queue;
import java.util.LinkedList;
    

class Solution {
    static int abs_min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        // 1-1. 각 wires마다 1개씩 빼자
        for (int i = 0; i < wires.length; i++) {
            
            // 1-2. graph 생성
            List<Integer>[] graph = new ArrayList[n+1];
            for (int j = 1; j < n+1; j++) {
                graph[j] = new ArrayList<>();
            }
            
            // 1-3. 간선
            for (int j = 0; j < wires.length; j++) {
                // 1-4. 간선 1개씩 빼야하기 때문에 (i != j)
                if (i == j) continue;
                
                // 1-5. 그 이외
                int cur_node = wires[j][0];
                int cur_to = wires[j][1];
                
                // 1-6. 전력은 양방향
                graph[cur_node].add(cur_to);
                graph[cur_to].add(cur_node);
            }
            
            
            // 2. bfs 생성 (시작점은 무조건 1번 노드)
            boolean[] visited = new boolean[n+1];
            int start_node = 1;
            int cnt = bfs(start_node, graph, visited);
            int diff = Math.abs(cnt - (n-cnt));
            abs_min = Math.min(diff, abs_min);
        }
        return abs_min;
    }
    
    
    
    // 3. bfs 함수
    static int bfs(int start_node, List<Integer>[] graph, boolean[] visited) {
        int cnt = 1;
        
        // 3-1. q 생성
        Queue<Integer> q = new LinkedList<>();
        q.add(start_node);
        visited[start_node] = true;
        
        // 3-2. 탐색
        while (!q.isEmpty()) {
            int cur_node = q.poll();
            
            // 3-3. next_node
            for (int next_node : graph[cur_node]) {
                
                // 3-4. 만약에 next_node 방문했다면 skip
                if (visited[next_node]) continue;
                
                // 3-5. 그렇지 않다면
                visited[next_node] = true;
                q.offer(next_node);
                cnt++;
            }
        }
        return cnt;
    }
    
}