class Solution {
    public int solution(int[][] info, int n, int m) {
        int leng = info.length;
        
        // 1. 배열 생성
        boolean[][] DP = new boolean[n][m];
        
        // 1-1. 초기값은 무조건 true
        DP[0][0] = true;
        
        // 1-2. DP
        for (int[] cur : info) {
            int a_trace = cur[0];
            int b_trace = cur[1];
            
            // 1-3. 다음 배열
            boolean[][] next_DP = new boolean[n][m];
            
            // 1-4. 검사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    
                    // 1-5. 상태 못 만드면 skip
                    if (!DP[i][j]) continue;
                    
                    // 1-6. a가 흔적을 남길 수 있다면
                    if (i + a_trace < n) {
                        next_DP[i + a_trace][j] = true;
                    }
                    
                    // 1-7. b가 흔적을 남길 수 있다면
                    if (j + b_trace < m) {
                        next_DP[i][j + b_trace] = true;
                    }
                }
            }
            // 1-7. 갱신
            DP = next_DP;            
        }
        
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    if (DP[i][j]) return i;  // i가 최솟값 (i 오름차순 탐색)
                }
            }

        
        return -1;
    }
}