import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    static int row, col;
    
    
    public int solution(int[][] points, int[][] routes) {
        row = 0;
        col = 0;
        
        // 1. 내 움직임 가동기
        int answer = my_mover(points, routes);
        return answer;
    }
    
    
    // 2. 함수
    static int my_mover(int[][] points, int[][] routes) {
        int cnt = 0;
        
        // 2-1. points를 저장할 pos 배열
        int[][] pos = new int[points.length][2];
        for (int i = 0; i < points.length + 0; i++) {
            int[] cur = points[i];
            int cr = cur[0];
            int cc= cur[1];
            row = Math.max(row, cr);
            col = Math.max(col, cc);
            
            pos[i][0] = cr;
            pos[i][1] = cc;
        }
        
        // 2-2. 배열 생성, q생성
        int[][] arr = new int[row + 1][col + 1];
        Queue<int[]> q = new LinkedList<>();
        
        // 2-3. 초기값 추가 -> 각 routes 길이만큼 반복
        // 시작점 배열에++, 그 이후 q에 추가
        int route_idx = 0;
        int n = routes[0].length;
        
        for (int r = 0; r < routes.length; r++) {
            int[] cur = routes[r];
            int first_route_point = cur[route_idx] - 1;
            
            int[] start_pos = pos[first_route_point];
            int sr = start_pos[0];
            int sc = start_pos[1];
            int no = r;
            arr[sr][sc]++;
            
            q.add(new int[] {no, sr, sc, route_idx+1, n});
        }
        
        // 2-4. 초기좌표 2개이상 겹치는 곳 있나 확인
        for (int r = 1; r < row + 1; r++) {
            for (int c = 1; c < col + 1; c++) {
                if (arr[r][c] >= 2) {
                    cnt++;
                }
            }
        }
        
        // 3. q가 안비었고, q.size() >= 2일떄까지 검사
        while (!q.isEmpty() && q.size() >= 1) {
            arr = new int[row + 1][col + 1];
            
            // 3-1. for문 (q 사이즈 동안)
            int M = q.size();
            for (int r = 0; r < M; r++) {
                int[] cur = q.poll();
                
                int cur_no = cur[0];
                int cr = cur[1];
                int cc = cur[2];
                int next_route_idx = cur[3];
                int N = cur[4];
                
                // 3-2. next_route_idx == N -> 끝
                if (next_route_idx == N) continue;
                
                // 3-3. 그 외는 next_pos 생성하고, nr, nc 생성
                int next_pos_idx = routes[cur_no][next_route_idx] - 1;
                int[] next_pos = pos[next_pos_idx];
                int target_r = next_pos[0];
                int target_c = next_pos[1];
                
                int nr = -999;
                int nc = -999;
                
                
                // 3-4-a. 행이 다르다면?
                if (cr != target_r) {
                    if (cr < target_r) nr = cr + 1;
                    else if (cr > target_r) nr = cr - 1;
                    nc = cc;
                }
                // 3-4-b. 현재 열이 더 작다면?
                else if (cc < target_c) {
                    nr = cr;
                    nc = cc + 1;
                }
                // 3-4-c. 현재 열이 더 크다면?
                else if (cc > target_c) {
                    nr = cr;
                    nc = cc - 1;
                }
                
                // 3-5. 값 추가
                arr[nr][nc]++;
                
                // 3-6. 만약 현재 행, 열이 target과 같다면
                if (nr == target_r && nc == target_c) {
                    q.add(new int[] {cur_no, nr, nc, next_route_idx + 1, N});
                }
                // 3-7. 그렇지않고 다르다면
                else {
                    q.add(new int[] {cur_no, nr, nc, next_route_idx, N});
                }
                
                
                
                
            }
            
            // 4. 교착지점 검사
            for (int r = 1; r < row + 1; r++) {
                for (int c = 1; c < col + 1; c++) {
                    if (arr[r][c] >= 2) cnt++;
                }
            }
            
        }
        return cnt;
    }

    
}