class Solution {
    static int row, col;
    static int[][] DP;
    static int er, ec;
    static int mod = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        row = n;
        col = m;
        DP = new int[row][col];
        
        // 1. 초기값
        DP[0][0] = 1;
        er = row-1;
        ec = col-1;
        
        // 2. puddles 채우기
        for (int[] pu : puddles) {
            int r = pu[1]-1;
            int c = pu[0]-1;
            DP[r][c] = -1;
        }
        
        // 2. 우측 테두리 채우기
        for (int c = 1; c < col; c++) {
            if (DP[0][c] == -1) continue;
            DP[0][c] = DP[0][c-1];
        }
        
        // 3. 아래 테두리 채우기
        for (int r = 1; r < row; r++) {
            if (DP[r][0] == -1) continue;
            DP[r][0] = DP[r-1][0];
        }
        
        // 4. 탐색
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                // 4-1. 연못이면 skip
                if (DP[r][c] == -1) continue;
                // 4-2. 그렇지 않다면
                else if (DP[r][c] != -1) {
                    int up = DP[r-1][c];
                    int left = DP[r][c-1];
                    if (DP[r-1][c] == -1) up = 0;
                    if (DP[r][c-1] == -1) left = 0;
                    
                    DP[r][c] = (up + left) % mod;
                }
            }
        }
        
        
        return DP[er][ec];
    }
}