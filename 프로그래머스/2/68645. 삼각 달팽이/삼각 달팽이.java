import java.util.Arrays;

class Solution {
    static int[] dr = {1, 0, -1};
    static int[] dc = {-1, 1, 0};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        // 1. 이동 최대값 설정
        int N = 0;
        for (int i = 1; i < n+1; i++) {
            N += i;
        }
        

        
        
        
        // 2. 초기값 삽입 
        int r = 0;
        int c = n-1;
        int i = 1;
        int start = 0;
        arr[r][c] = i;
        visited[r][c] = true;
        i++;
        
        
        // 3. 피라미드
        int d = 0;
        while (i <= N) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            // 3-1. 범위밖 -> 방향전환 후에 skip
            if (nr < 0 || nr > n-1 || nc < 0 || nc > n-1) {
                d = (d+1) % 3;
                continue;
            }
            
            // 3-2. 이미 방문했다면 방향전환 후에 skip
            if (visited[nr][nc]) {
                d = (d+1) % 3;
                continue;
            }
            
            // 3-3. 새것이라면 값 추가 후에 방문처리
            // 방향값 갱신후에, 마지막으로 값 증가            
            arr[nr][nc] = i;
            visited[nr][nc] = true;
            r = nr;
            c = nc;
            i++;
        }

        
        
        // 4. 결과
        int[] answer = new int[N];
        int x = 0;
        for (int a = 0; a < n; a++) {
            for (int b = n-1-a; b < n; b++) {
                answer[x] = arr[a][b];
                x++;
            }
        } 
        return answer;
    }
}