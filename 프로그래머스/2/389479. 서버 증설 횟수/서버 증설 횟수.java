class Solution {
    public int solution(int[] players, int m, int k) {
        int min_cnt = 0;
        
        int[] cur_server = new int[24];
        // 1. 현재 서버 검사
        for (int i = 0; i < 24; i++) {
            int cur_mod = players[i] / m;
            
            // 2. 만약 현재 서버가 충분하다면 pass
            if (cur_server[i] >= cur_mod) continue;
            
            // 3. 그렇지 못하다면 서버에 차이만큼 추가
            int diff = cur_mod - cur_server[i];
            
            for (int j = i; j < i + k; j++) {
                // 3-1. 범위 넘어가면 멈춤
                if (j >= 24) break;
                
                // 3-2. 차이만큼 서버에 추가
                cur_server[j] += diff;
            }
            
            // 4. 횟수에 추가
            min_cnt += diff;
            
            
        }
        
        return min_cnt;
    }
}