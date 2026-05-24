class Solution {
    public int solution(int[][] info, int n, int m) {
        
        // 1. 2차원 배열 생성
        boolean[][] DP = new boolean[n][m];
        
        // 2. 초기값, 처음에 A,B 누구도 어떤 것도 훔치지 않았다
        DP[0][0] = true;
        
        // 3. 검사
        for (int[] cur : info) {
            int a_trace = cur[0];
            int b_trace = cur[1];
            
            // 3-1. 새로운 배열
            boolean[][] next_DP = new boolean[n][m];
            
            // 3-2. 완전탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 3-3. 방문 안했으면 skip (도둑질한 현황이 없다는 뜻)
                    if (!DP[i][j]) continue;
                    
                    // 3-4. A 혹은 B가 도둑질한 현황이 있다면
                    
                    // 3-5. A의 흔적을 더 남길 수 있다면
                    if (i + a_trace < n) {
                        next_DP[i + a_trace][j] = true;
                    }
                    
                    // 3-6. B의 흔적을 더 남길 수 있다면
                    if (j + b_trace < m) {
                        next_DP[i][j + b_trace] = true;
                    }
                }
            }
            // 4. 갱신
            DP = next_DP;
        }
        
        // 5. A의 누적 최소흔적 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (DP[i][j]) {
                    return i;
                }
            }
        }
        
        // 6. A의 누적최소흔적이 없다면
        return -1;
    }
}