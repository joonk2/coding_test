class Solution {
    static int INF = Integer.MAX_VALUE;
    
    
    public int solution(int[][] info, int n, int m) {
        
        // 1. B기준으로 각 A의 누적흔적 최소
        int[] DP = new int[m];
        
        // 2. INF 로 초기화하고, 첫값은 0
        for (int i = 0; i < m; i++) {
            DP[i] = INF;
        }
        DP[0] = 0;
        
        // 3. 검사
        for (int[] cur : info) {
            int a_trace = cur[0];
            int b_trace = cur[1];
            
            // 3-1. 다음 DP 생성하고, INF 초기화
            int[] next_DP = new int[m];
            for (int i = 0; i < m; i++) {
                next_DP[i] = INF;
            }
            
            
            // 3-2. 최소값 갱신
            for (int i = 0; i < m; i++) {
                // 3-1. 만약 훔치는게 이어지지 못하면 skip
                if (DP[i] == INF) continue;
                
                // 3-2. 그게 아니라면
                
                // 3-3. a흔적을 더 남길 수 있다면
                if (DP[i] + a_trace < n) {
                    next_DP[i] = Math.min(next_DP[i], DP[i] + a_trace);
                }
                
                // 3-4. b흔적을 더 남길 수 있다면
                if (i + b_trace < m) {
                    next_DP[i + b_trace] = Math.min(next_DP[i + b_trace], DP[i]);
                }
            }
            
            // 4. 갱신
            DP = next_DP;
        }
        
        // 5-1. 출력 (음수처리)
        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(DP[i], answer);
        }
        if (answer == INF) return -1;
        
        // 5-2. 출력 (음수가 아닐때)
        return answer;
    }
}