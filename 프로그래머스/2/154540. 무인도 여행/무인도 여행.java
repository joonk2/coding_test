/*
이 문제는 2차원 row * col * (bfs 영역 최대 10000칸)
1억 이내라서 충분히, 전형적인 완탐 풀이로 가능하다
*/

import java.util.Arrays;

import java.util.Queue;
import java.util.ArrayDeque;


class Solution {
    static int row;
    static int col;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int[] solution(String[] maps) {
        
        row = maps.length;
        col = maps[0].length();
        char[][] arr = new char[row][col];
        
        for (int r = 0; r < row; r++) {
            String cols = maps[r];
            for (int c = 0; c < col; c++) {
                arr[r][c] = cols.charAt(c);
            }
        }
        
        // 1. O(row * col *  (row*col)  )
        boolean[][] visited = new boolean[row][col];
        int[] temp_lst = new int[row * col];
        int idx = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int cr = r;
                int cc = c;
                
                // 1-1. 만약 'X' -> skip
                if (arr[cr][cc] == 'X') continue;
                
                // 1-2. 방문했으면 skip
                if (visited[cr][cc]) continue;
                
                // 1-3. X도 아니고, 방문도 안했으면 bfs
                int sum = bfs(cr, cc, arr, visited);
                temp_lst[idx] = sum;
                idx++;
            }
        }
        
        
        // 3. 조기종료 (하나도 못채웠다면)
        if (idx == 0) {
            int[] res = new int[1];
            res[0] = -1;
            return res;
        }
        
        // 4. 하나라도 채웠다면
        int[] answer = new int[idx];
        for (int i = 0; i < idx; i++) {
            answer[i] = temp_lst[i];
        }
        Arrays.sort(answer);
        return answer;
    }
    
    
    
    
    // 2. bfs
    static int bfs(int sr, int sc, char[][] arr, boolean[][] visited) {
        int res = 0;
        
        // 2-1. 시작점 1 <= arr[sr][sc] <= 9 이기에 방문처리
        visited[sr][sc] = true;
        
        // 2-2. q 생성하고, 첫 좌표 추가
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sr, sc});
        
        // 2-3. q가 비지않을때까지 검사
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            // 2-4. q에서 꺼낸 숫자 더하기
            int cur_num = arr[cr][cc] - '0';
            res += cur_num;
            
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 2-5. 만약 범위밖이면 -> skip
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                
                // 2-6. 만약 X면 -> skip
                if (arr[nr][nc] == 'X') continue;
                
                // 2-7. 만약 방문했다면 -> skip
                if (visited[nr][nc]) continue;
                
                // 2-8. 범위안, X도 아니고, 방문도 안했다면
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }
        
        
        return res;
    }
    
}