/*
[힌트]
현재의 가동중인 서버 현황을 잘 확인하고, 최소한의 전력을 사용해야한다.
*/


class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0;
        
        int time = 24;
        // 현재 가동중인 서버 현황
        int[] DP = new int[time];
        
        for (int t = 0; t < time; t++) {
            // 현재 필요한 서버수
            int req_server = players[t] / m;
            int diff = 0;
            
            // 현재 가동중인 서버 < 현재 필요한 서버수라면??
            if (DP[t] < req_server) {
                diff = req_server - DP[t];
                cnt += diff;
            }
            
            // 현재 가동중인 서버에 k 만큼 전력 추가
            for (int i = t; i < t + k; i++) {
                // 범위 초과시 -> skip
                if (i >= time) continue;
                
                // 그게 아니라면
                DP[i] += diff;
            }
            
        }
        
        
        return cnt;
    }
}