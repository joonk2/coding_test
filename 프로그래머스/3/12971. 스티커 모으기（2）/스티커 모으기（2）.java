class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        
        // 1. 조기종료 처리
        if (N == 1) {
            int res = sticker[0];
            return res;
        }
        if (N == 2) {
            int res = Math.max(sticker[0], sticker[1]);
            return res;
        }
        
        // 0번째 idx 선택 -> idx : 0 ~ N-2
        // 0번째 idx 미선택 -> idx : ? ~ N-1
        
        int[] DP_x = new int[N];
        int[] DP_y = new int[N];
        
        // 2-1. 0번째 idx 선택
        DP_x[0] = sticker[0];
        DP_x[1] = DP_x[0];
        for (int i = 2; i < N-1; i++) {
            DP_x[i] = Math.max(DP_x[i-1], sticker[i] + DP_x[i-2]);
        }
        
        
        // 2-2. 0번째 idx 미선택
        DP_y[1] = sticker[1];
        DP_y[2] = Math.max(sticker[1], sticker[2]);
        for (int i = 3; i < N; i++) {
            DP_y[i] = Math.max(DP_y[i-1], sticker[i] + DP_y[i-2]);
        }
        
        
        // 3. 정답 구하기
        int answer = Math.max(DP_x[N-2], DP_y[N-1]);
        
        return answer;
    }
}