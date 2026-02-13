/*
[힌트]
현재의 가동중인 서버 현황을 잘 확인하고, 최소한의 전력을 사용해야한다.
*/



class Solution {
    public int solution(int[] players, int m, int k) {
        int time = 24;
        
        // 현재 가동중인 서버수를 확인하는 현황 
        int[] DP = new int[time];
        
        int cnt = 0;
        for (int t = 0; t < time; t++) {
            int diff = 0;
            
            // 현재 필요한 서버수
            int req_server = players[t] / m;
            
            // 만약에 현재 서버수가 가동중인 서버현황보다 모자라다???
            if (DP[t] < req_server) {
                diff = req_server - DP[t];
                cnt += diff;
            }
            
            // 서버 대수 미리 가동하여 현황 최신화하기
            for (int i = t; i < t + k; i++) {
                // 범위 밖 -> skip
                if (i >= time) continue;
                
                // 그게 아니라면
                DP[i] += diff;
            }
        	

        }
        
        
        return cnt;
    }
}