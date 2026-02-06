import java.util.Queue;
import java.util.LinkedList;

import java.util.HashSet;
import java.util.Set;



class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max_oil = Integer.MIN_VALUE;
    static int row, col;
    
    
    public int solution(int[][] land) {
   		
        // 열, 행
        col = land[0].length;
        row = land.length;
        
        boolean[][] visited = new boolean[row][col];
        
        // 시추관(열) 별로 얼마나 석유가 있는지?
        int[] oil_by_col = new int[col];
        
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 방문안했고 + 석유라면
                if (!visited[r][c] && land[r][c] == 1) {
                    BFS(r, c, oil_by_col, visited, land);
                }
            }
        }
        
        // 최대값 비교
        for (int i : oil_by_col) {
            max_oil = Math.max(i, max_oil);  
        }
		        
        return max_oil;
    }
    
    
    
    
    static void BFS(int r, int c, int[] oil_by_col, boolean[][] visited, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        
        // 석유 덩어리가 겹친 열을 oil_by_col에 각각 열마다 추가하기 위해 set을 사용
        Set<Integer> set = new HashSet<>(); 
        
        // 횟수
        int cnt = 0;        
        
        // 큐에 해당 원소 넣고 그 좌표 방문 처리
        q.add(new int[] {r, c});
        visited[r][c] = true;
        cnt++;
		
        // 시작열도 석유 덩어리가 겹쳤기에 추가
        set.add(c);
        
        
        // 확인
		while (!q.isEmpty()) {
            int[] cur_pos = q.poll();
            int cr = cur_pos[0];
            int cc = cur_pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 만약 범위 밖이면 skip
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                
                // 만약 방문했거나 빈땅이면 skip
                if (visited[nr][nc] || land[nr][nc] == 0) continue;
         
                // 방문 안했고, 석유가 있다면 -> 횟수 추가
                visited[nr][nc] = true;
                cnt++;
                set.add(nc);
                q.add(new int[] {nr, nc});                
            }
        }
        
        // 석유 덩어리가 걸친 모든 열에 cnt 추가
        for (int idx : set) {
            oil_by_col[idx] += cnt;
        }
        
    }
    
    
    
}