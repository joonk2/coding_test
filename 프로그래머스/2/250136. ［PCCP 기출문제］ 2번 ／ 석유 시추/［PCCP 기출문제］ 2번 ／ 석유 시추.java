/*
BFS를 활용하여
만약 3중 반복문 r = 0, r < 1
c = 0; c < col;
k = 0; k < row
라면

최악의 실행시간은
500 * 250000 * 500 
즉 시간초과겠다.

다른 방법으로 구축해야한다.

완전탐색을 할까?
500 * 500 * 4가 되겠다.

배열을 하나 만들자
반복문을 통해 각 열마다 방문하지 않은 석유가 겹칠때마다 누적합산하자.
*/


import java.util.HashSet;
import java.util.Set;

import java.util.Queue;
import java.util.LinkedList;


class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max_oil = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int row, col;
    
    public int solution(int[][] land) {
        row = land.length;
        col = land[0].length;
        visited = new boolean[row][col];
        
        // 완전탐색시 각 열마다 방문안한 좌표를 합산해주기 위한 배열
        int[] oil_by_col = new int[col];
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 만약 방문 안했고 + 석유라면
                if (!visited[r][c] && land[r][c] == 1) {
                    BFS(r, c, oil_by_col, land);
                }
            }
        }
        
        // 최대 비교
        for (int i : oil_by_col) {
            max_oil = Math.max(i, max_oil);
        }
        
        return max_oil;
    }
    
    
    
    
    
    static void BFS(int r, int c, int[] oil_by_col, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        
        // 석유덩어리가 겹치는 열을 oil_by_col에 반복문으로 저장해주기위해 Set 사용
        Set<Integer> set = new HashSet<>();
        
        int cnt = 0;
        
        // 지금 현재 좌표는 방문 안한 석유니까 -> cnt++;
        // 그리고 현재좌표의 열도 석유랑 맞닥드렸으니 set에 추가하자
        cnt++;
        set.add(c);
        
        visited[r][c] = true;
        q.add(new int[] {r, c});
        
        
        // 확인
        while (!q.isEmpty()) {
            int[] cur_pos = q.poll();
            int cr = cur_pos[0];
            int cc = cur_pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 범위 밖이면 skip
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                
                // 다음좌표를 방문했거나, 빈땅이면 skip
                if (visited[nr][nc] || land[nr][nc] == 0) continue;
                
                // 미방문했다면 횟수 추가하고 방문처리
                visited[nr][nc] = true;
                cnt++;
                
                // 만약 col = 8일때, land[nr][nc] == 1
                // 그리고 그때의 nc가  0, 1, 4 -> set에 추가
                set.add(nc);
                q.add(new int[]{nr, nc});
            } 
        }
        
        // oil_by_col 에 set에 들은 열번호의 갯수만큼 반복하여 cnt 추가
        for (int col_idx : set) {
            oil_by_col[col_idx] += cnt;
        }
        
        
    }
    
    
    
}