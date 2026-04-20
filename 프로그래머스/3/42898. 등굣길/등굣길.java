class Solution {
    static int mod = 1000000007;
    
    
    public int solution(int m, int n, int[][] puddles) {
        int row = n;
        int col = m;
        int[][] DP = new int[row][col];
        
        // 1. 웅덩이를 채우자
        for (int[] i : puddles) {
            int cur_r = i[1]-1;
            int cur_c = i[0]-1;
            DP[cur_r][cur_c] = -1;
        }
        
        // 2  테두리 채우기
        
        // 2-1. 시작점 무조건 [0][0]
        DP[0][0] = 1;
        
        // 2-2. 행 테두리 채우기 (왼 -> 오)
        for (int c = 1; c < col; c++) {
            // 현재값이 웅덩이라면 그만 봐라
            if (DP[0][c] == -1) break;
            
            // 현재값이 웅덩이가 아니라면 계속 이전값을 갱신
            DP[0][c] = DP[0][c-1];
        }
        
        // 2-3. 열 테두리 채우기 (위 -> 아래)
        for (int r = 1; r < row; r++) {
            // 현재값이 웅덩이라면 그만 봐라
            if (DP[r][0] == -1) break;
            
            // 현재값이 웅덩이가 아니라면 계속 이전값을 갱신해라
            DP[r][0] = DP[r-1][0];
        }
        
        // 3. 채우기
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                // 3-1. 웅덩이라면 넘어가자
                if (DP[r][c] == -1) continue;
                
                // 3-2 웅덩이가 아니라면
                int up = DP[r-1][c];
                int left = DP[r][c-1];
                if (up == -1) up = 0;
                if (left == -1) left = 0;
                DP[r][c] = (up + left) % mod; 
            }
        }
        
        
        return DP[row-1][col-1];
    }
}