import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static boolean[][] visited;
    static int min_dist = Integer.MAX_VALUE;
    static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int answer = 0;
        answer = bfs(maps, 0, 0, 1);
        return answer;
    }
    
    
    
    public static int bfs(int[][] maps, int sr, int sc, int dist) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        q.add(new int[] {sr, sc, dist});
        visited[sr][sc] = true;
        
        while (!q.isEmpty()) {
            int[] cur_pos = q.poll();
            int cr = cur_pos[0];
            int cc = cur_pos[1];
            int c_dist = cur_pos[2];
            
            if (cr == n-1 && cc == m-1) {
                return c_dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc] && maps[nr][nc] == 1) {
                        q.add(new int[] {nr, nc, c_dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
            
        }
        return -1;
        
    }
    
    
    
}