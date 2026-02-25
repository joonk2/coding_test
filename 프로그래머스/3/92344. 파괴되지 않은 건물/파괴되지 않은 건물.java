class Solution {
    public int solution(int[][] board, int[][] skill) {
        int cnt = 0;
        
        int row = board.length;
        int col = board[0].length;
        
        // 변화랑
        long[][] diff = new long[row+1][col+1];
        
        int T = skill.length;
        for (int t = 0; t < T; t++) {
            int type = skill[t][0];
            int sr = skill[t][1];
            int sc = skill[t][2];
            int er = skill[t][3];
            int ec = skill[t][4];
            int degree = skill[t][5];
            
            // 공격일때 음수처리
            if (type == 1) degree = -degree;
            
            // 1-1. 왼쪽 맨위 끝 모서리
            diff[sr][sc] += degree;
            
            // 1-2. 왼쪽 맨위 우측 끝 모서리
            diff[sr][ec+1] += -degree;
            
            // 1-3. 왼쪽 맨 아래
            diff[er+1][sc] += -degree;
            
            // 1-4. 맨오른쪽 밑 아래
            diff[er+1][ec+1] += degree; 
        }
        
        
        // 2. 행방향 누적합
        for (int r = 0; r < row; r++) {
            for (int c = 1; c < col; c++) {
                diff[r][c] += diff[r][c-1];
            }
        }
        
        // 3. 열방향 누적합
        for (int r = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                diff[r][c] += diff[r-1][c];
            }
        }
        
         // 4. 결과를 보자
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] + diff[r][c] > 0) cnt++;
            }
        }

        return cnt;
    }
}