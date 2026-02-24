import java.util.Arrays;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int cnt = 0;
        
        int row = board.length;
        int col = board[0].length;
        
        // 차분을 이용하자
        // 이후 마지막 idx인 row, col은 이용하지않는다
        // idx는 누적합시 row-1, col-1 까지만 이용하자
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
            if (type == 1) {
                degree = -degree;
            }
            
            // 1-1. 왼쪽 맨위끝 모서리
            diff[sr][sc] += degree;
            
            // 1-2. 왼쪽 맨위 우측끝 모서리
            diff[sr][ec+1] += -degree;
            
            // 1-3. 왼쪽 맨아래 맨밑 모서리
            diff[er+1][sc] += -degree;
            
            // 1-4. 맨 오른쪽 밑 끝 모서리
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
        
        // 4. 결과
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] + diff[r][c] > 0) cnt++;
            }
        }
        
        return cnt;
    }
}