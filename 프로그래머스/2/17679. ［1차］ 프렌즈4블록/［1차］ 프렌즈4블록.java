class Solution {
    public int solution(int m, int n, String[] board) {
        int to_remove = 0;
        
        int row = m;
        int col = n;
        
        // 1. 배열 채우기
        char[][] arr = new char[row][col];
        for (int r = 0; r < row; r++) {
            arr[r] = board[r].toCharArray();
        }
        
        // 2. 탐색
        while (true) {
            boolean[][] visited = new boolean[row][col];
            boolean can_delete_block = false;
            
            
            for (int r = 0; r < row-1; r++) {
                for (int c= 0 ; c < col-1; c++) {
                    char ch = arr[r][c];
                    
                    // 2-1. 빈공간이면 skip
                    if (ch == '.') continue;
                    
                    // 2-2. 4개가 같으면 true
                    char right = arr[r][c+1];
                    char diag = arr[r+1][c+1];
                    char down = arr[r+1][c];
                    
                    if (ch == right && right == diag && diag == down) {
                        visited[r][c] = true;
                        visited[r][c+1] = true;
                        visited[r+1][c+1] = true;
                        visited[r+1][c] = true;
                        can_delete_block = true;
                    }
                }
            }
            
            // 2-3. 블록을 못지운 경우 -> 조기종료
            if (!can_delete_block) break;
            
            // 2-4. 지울블록들 지우기
            for (int r= 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (visited[r][c]) {
                        arr[r][c] = '.';
                        to_remove++;
                    }
                }
            }
            
            
            
            // 3. 블록을 아래로 떨어뜨리기 (수직낙하)
            for (int c = 0; c < col; c++) {
                int er = row-1;
                for (int r = row-1; r >= 0; r--) {
                    if (arr[r][c] != '.') {
                        char temp = arr[r][c];
                        arr[r][c] = '.';
                        arr[er][c] = temp;
                        er--;
                    }
                }
            }
            
            
            
        }
        
        
        
        return to_remove;
    }
}