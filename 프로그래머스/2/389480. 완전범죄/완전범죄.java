class Solution {
    static int INF = 1000000;
    
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        
        // 1. memoization + dfs
        int[][] memo = new int[info.length][m];
        for (int r = 0; r < info.length; r++) {
            for (int c = 0; c < m; c++) {
                memo[r][c] = -1;
            }
        }
        
        int idx = 0;
        int cum_trace_B = 0;
        answer = dfs(idx, cum_trace_B, info, memo, n, m);
        
        // 2-1. 못 도달하면 return -1
        if (answer == INF) {
            return -1;
        }
        
        // 2-2. 도달하면 answer 반환
        return answer;
    }
    
    
    
    
    // 3. dfs 함수
    static int dfs(int idx, int cum_trace_B, int[][] info, int[][] memo, int n, int m) {
        int min_A = INF;
        
        // 3-1. 모든 물건을 다 훔쳤으면?
        if (idx == info.length) {
            return 0;
        }
        
        // 3-2. 이미 계산된 상태라면?
        if (memo[idx][cum_trace_B] != -1) {
            return memo[idx][cum_trace_B];
        }
        
        // 3-3. 현재 물건의 흔적
        int cur_trace_A = info[idx][0];
        int cur_trace_B = info[idx][1];
        
        // 3-4. 현재 물건을 A가 훔친다
        int res_A = dfs(idx+1, cum_trace_B, info, memo, n, m);
        
        if (res_A != INF && res_A + cur_trace_A < n) {
            min_A = Math.min(min_A, res_A + cur_trace_A);
        }
        
        
        // 3-5. 현재 물건을 B가 훔친다
        if (cum_trace_B + cur_trace_B < m) {
            int res_B = dfs(idx+1, cum_trace_B + cur_trace_B, info, memo, n, m);
            
            min_A = Math.min(min_A, res_B);
        }
        
        // 3-6. 현재 상태의 정답 저장
        memo[idx][cum_trace_B] = min_A;
        return min_A;
        
    }
    
    
    
}