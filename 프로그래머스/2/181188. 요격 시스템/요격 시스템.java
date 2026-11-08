import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int N = targets.length;
        
        
        Arrays.sort(targets, (a,b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            
            return Integer.compare(a[0], b[0]);
        });
        
        
        // 1. 첫좌표 처리
        int prev_s = targets[0][0];
        int prev_e = targets[0][1];
        answer++;
        
        
        // 2. 두번째 좌표부터 검사
        for (int i = 1; i < N; i++) {
            int cur_s = targets[i][0];
            int cur_e = targets[i][1];
            
           // 2-1. 이전 구간과 겹치면 갱신
            if (cur_s < prev_e) {
                prev_e = Math.min(prev_e, cur_e);
                continue;
            }
            
            // 2-2. 이전구간과 겹치지 않는 경우
            if (prev_e <= cur_s) {
                prev_e = cur_e;
                answer++;
            }
            
            
        }
        
        return answer;
    }
}