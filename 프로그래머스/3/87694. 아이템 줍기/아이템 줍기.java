import java.util.Queue;
import java.util.LinkedList;


class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        boolean[][] visited = new boolean[102][102];
        boolean[][] map = new boolean[102][102];
        int sr = characterY * 2;
        int sc = characterX * 2;
        int er = itemY * 2;
        int ec = itemX * 2;
        
        
        // 1. 전부 true 채우기
        for (int[] p : rectangle) {
            int r1 = p[1] * 2;
            int c1 = p[0] * 2;
            int r2 = p[3] * 2;
            int c2 = p[2] * 2;
            
            
            for (int r = r1; r < r2 + 1; r++) {
                for (int c = c1; c < c2 + 1; c++) {
                    map[r][c] = true;
                }
            }
        }
        
        // 2. 모서리를 제외한 나머지는 false
        for (int[] p : rectangle) {
            int r1 = p[1] * 2;
            int c1 = p[0] * 2;
            int r2 = p[3] * 2;
            int c2 = p[2] * 2;
            
            for (int r = r1 + 1; r < r2; r++) {
                for (int c = c1 + 1; c < c2; c++) {
                    map[r][c] = false;
                }
            }
        }
        
        // 3. bfs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int cr = cur[0];
            int cc = cur[1];
            int cur_dist = cur[2];
            
            // 3-1. 도달시 종료
            if (cr == er && cc == ec) {
                int res = cur_dist / 2;
                return res;
            }
            
            // 3-2. 그 외
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 3-3. 범위 밖 -> skip
                if (nr < 0 || nr >= 102 || nc < 0 || nc >= 102) continue;
                
                // 3-4. 테두리가 아니라면 skip
                if (!map[nr][nc]) continue;
                
                // 3-5. 방문 했다면
                if (visited[nr][nc]) continue;
                
                // 3-6. 테두리고 방문도 안했다면
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, cur_dist + 1});
            }
        }
        
        
        return answer;
    }
}