import java.util.Arrays;


// requests[i].charAt(0) == arr[nr][nc] 일때 제거할 컨테이너
import java.util.List;
import java.util.ArrayList;

// .일때 계속 연결방문할 컨테이너
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] arr;
    static boolean[][] visited;
    static int row, col;
    
    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        arr = new char[row][col];
        
        // 1. 초기 격자 생성
        for (int r = 0; r < row; r++) {
            arr[r] = storage[r].toCharArray();
        }
        
        
        // 2. 요청 순차적으로 처리
        int i = 0;
        int N = requests.length;
        while (i < N) {
            String cur_req = requests[i];
            
            // 2-a. 지게차
            if (cur_req.length() == 1) {
                remove_with_fork_lift(cur_req.charAt(0));
            }
            // 2-b. 크레인
            else if (cur_req.length() == 2) {
                remove_with_crane(cur_req.charAt(0));
            }
            
            // 다음으로 전환
            i++;
        }
        
        
        // 3. 남은 컨테이너 갯수 산출
        int cnt = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (arr[r][c] != '.') cnt++;
            }
        }
        return cnt;
    }
    
    
    
    
    
    // b. 크레인
    static void remove_with_crane(char ch) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (arr[r][c] == ch) {
                    arr[r][c] = '.';
                }
            }
        }
    }
    
    
    // a. 지게차
    static void remove_with_fork_lift(char ch) {
        visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> to_remove = new ArrayList<>();
        
        // ㄱ. 테두리(모서리)에서 내부로 진입가능하니까 가장끝부터 탐색
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0 || r == row-1 || c == 0 || c == col-1) {
                    // 이미 컨테이너를 제거했다면
                    if (arr[r][c] == '.') {
                        q.add(new int[] {r, c});
                        visited[r][c] = true;
                    }
                    // 그게 아니라 target이라면
                    if(arr[r][c] == ch) {
                        to_remove.add(new int[] {r, c});
                        visited[r][c] = true;
                    }
                }
            }
        }
        
        // ㄴ. bfs
        bfs(ch, q, to_remove);
        
        // ㄷ. 수집된 ch 제거
        for (int[] pos : to_remove) {
            int r = pos[0];
            int c = pos[1];
            arr[r][c] = '.';
        }
        
    }
    
	
    
    
    
    
    
    static void bfs(char ch, Queue<int[]> q, List<int[]> to_remove) {
        while (!q.isEmpty()) {
            int[] cur_pos = q.poll();
            int cr = cur_pos[0];
            int cc = cur_pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 범위 밖이라면 pass
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                
                // 방문했다면 pass
                if (visited[nr][nc]) continue;
                
                
                // 빈공간이면 지나갈 수 있으니 q에 삽입
                if (arr[nr][nc] == '.') {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
                // 그렇지 않다면, ch랑 같을때 to_remove에 삽입
                else if (arr[nr][nc] == ch) {
                    to_remove.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
                
            }
        }
    }
    
    
    
    
    
    
    
}