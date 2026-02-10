/*
-------------fork_lift-------------
접근 가능한 외부에서 테두리를 먼저 탐색하고 bfs 진행
q(이동 가능한 통로), to_remove(삭제할 컨테이너)

-------------crane-------------
전부 탐색
*/



// test
import java.util.Arrays;



// 테두리에서 시작하여 이동 가능한 통로들
import java.util.Queue;
import java.util.LinkedList;

// 제거할 컨테이너들
import java.util.List;
import java.util.ArrayList;



class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] arr;
    static boolean[][] visited;
    static int row, col;
    static int cnt;
    
    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        arr = new char[row][col];
        
        // 1. 초기 격자 생성
        for (int r = 0; r < row; r++) {
            arr[r] = storage[r].toCharArray();
        }
        
        
        // 2. 작업을 요청 순서에 따라 진행
        int i = 0;
        int N = requests.length;
        while (i < N) {
            String cur_req = requests[i];
            
            // 2-1. 길이가 2라면 crane
            if (cur_req.length() >= 2) {
                remove_with_crane(cur_req.charAt(0));
            }
            // 2-2. 길이가 1이면 -> fork_lift
            else if (cur_req.length() < 2) {
                remove_with_fork_lift(cur_req.charAt(0));
            }
            
            // 다음으로 전환
            i++;
        }
        
        
        // 3. 제거된 컨테이너 제외하고 합산
        cnt = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (arr[r][c] != '.') cnt++;
            }
        }
        
        return cnt;
    }
    
    
    
    
    // crane
    static void remove_with_crane(char target) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (arr[r][c] == target) {
                    arr[r][c] = '.';
                }
            }
        }
    }
    
    
    // fork_lift
    static void remove_with_fork_lift(char target) {
        visited = new boolean[row][col];
        
        Queue<int[]> q = new LinkedList<>();
        List<int[]> to_remove = new ArrayList<>();
        
        // a. 외부에서 접근하려면 테두리에서 먼저 찾자
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0 || r == row-1 || c == 0 || c == col-1) {
                    // a-1. 이동 가능한 빈 공간이라면
                    if (arr[r][c] == '.') {
                        q.add(new int[] {r, c});
                        visited[r][c] = true;
                    }
                    // a-2. 그렇지 않고 현재 작업중인 컨테이너와 일치시
                    else if (arr[r][c] == target) {
                        to_remove.add(new int[] {r, c});
                        visited[r][c] = true;
                    }
                }
            }
        }
        
        // b. bfs
        bfs(target, q, to_remove);
        
        // c. 삭제할 컨테이너 처리
        for (int[] pos : to_remove) {
            int r = pos[0];
            int c = pos[1];
            arr[r][c] = '.';
        }
        
    }
    
    
    
    
    // bfs
    static void bfs(char target, Queue<int[]> q, List<int[]> to_remove) {
        while (!q.isEmpty()) {
            int[] cur_pos = q.poll();
            int cr = cur_pos[0];
            int cc = cur_pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 만약 범위 밖이면 skip
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                
                // 방문했다면 skip
                if (visited[nr][nc]) continue;
                
                // 이동 가능한 빈 공간이라면
                if (arr[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
                // 현재 제거 중인 컨테이너와 일치한다면
                else if (arr[nr][nc] == target) {
                    visited[nr][nc] = true;
                    to_remove.add(new int[] {nr, nc});
                }
                
            }
        }

    }
    
    
}