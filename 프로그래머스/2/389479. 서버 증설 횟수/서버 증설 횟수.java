class Solution {
    public int solution(int[] players, int m, int k) {
        int time = 24;
        int cnt = 0;
        
        
        // 현재 구동중인 서버갯수의 현황
        int[] DP = new int[time];
        
        
        for (int t = 0; t < time; t++) {
            int req_server = players[t] / m;
            int diff = 0;
            
            // 서버가 부족한 상황이라면
            if (DP[t] < req_server) {
                diff = req_server - DP[t];
                cnt += diff;
            }
            
            // 서버 개설하기
            for (int i = t; i < t + k; i++) {
                // 범위 밖이면 skip
                if (i >= time) continue;
                
                // 그게 아니라면
                DP[i] += diff;
            }
            
        }
            
        
        
        return cnt;
    }
}