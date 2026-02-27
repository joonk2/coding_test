class Solution {
    static int[] dr = {1};
    static int[] dc = {0};
    
    public int solution(int m, int n, String[] board) {
        int row = m;
        int col = n;
        int total_cnt = 0;
        
        
        // 1. 배열 만들기
        char[][] arr = new char[row][col];
        for (int r = 0; r < row; r++) {
            arr[r] = board[r].toCharArray();
        }
        
        // 2. 탐색 시작
        while (true) {
            boolean can_delete_block = false;
            boolean[][] visited = new boolean[row][col];
            
            for (int r = 0; r < row-1; r++) {
                for (int c = 0; c < col-1; c++) {
                    char cur_block = arr[r][c];
                    char right = arr[r][c+1];
                    char diag = arr[r+1][c+1];
                    char down = arr[r+1][c];
                    
                    // 빈칸 -> pass
                    if (cur_block == '.' || right == '.' || diag == '.' || down == '.') continue;
                    
                    // 2-1. 2x2 영역 같은지 확인
                    if (cur_block == right && right == diag && diag == down) {                   
                        visited[r][c] = true;
                        visited[r][c+1] = true;
                        visited[r+1][c+1] = true;
                        visited[r+1][c] = true;
                        can_delete_block = true;
                    }
                }
            }
            
            // 2-2. 지울 블락 없다면 조기 종료
            if (!can_delete_block) break;
            
            // 2-3. 지울 블락이 있다면 -> 지우자
            int temp_cnt = 0;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (visited[r][c]) {
                        arr[r][c] = '.';
                        temp_cnt++;
                    }
                }
            }
            total_cnt += temp_cnt;
            
            
            // 3. 블록 아래로 떨어뜨리기 (중력)
            for (int c = 0; c < col; c++) {
                int er = row-1;
                for (int r = row-1; r >= 0; r--) {
                    if (arr[r][c] != '.') {
                        char temp = arr[r][c];
                        arr[r][c] = '.';
                        arr[er][c] = temp;
                        
                        // stack 처럼 채우기
                        er--;
                    }
                }
            }
            
            
        }
        
        
        return total_cnt;
    }
}