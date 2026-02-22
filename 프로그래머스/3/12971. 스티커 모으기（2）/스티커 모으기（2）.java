class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int N = sticker.length;
        
        // 조기종료
        if (N == 1) {
            int res = sticker[0];
            return res;
        }
        if (N == 2) {
            int res = Math.max(sticker[0], sticker[1]);
            return res;
        }
        
        
        
        int[] DP_0 = new int[N];
        int[] DP_1 = new int[N];
        
        // 1. 초기값 설정
        // 1-1. 0번째를 선택한 배열 -> 0 ~ N-2
        DP_0[0] = sticker[0];
        DP_0[1] = DP_0[0];
        
        // 1-2. 0번째 선택 안한 배열 ->  N-1 까지
        DP_1[1] = sticker[1];
        DP_1[2] = Math.max(DP_1[1], sticker[2]);
        
        // 2. 점화식 각각
        
        // 2-1. 0번째를 선택한 배열
        for (int i = 2; i < N-1; i++) {
            DP_0[i] = Math.max(DP_0[i-1], sticker[i] + DP_0[i-2]);
        }
        
        // 2-2. 1번째부터 선택한 배열
        for (int i = 3; i < N; i++) {
            DP_1[i] = Math.max(DP_1[i-1], sticker[i] + DP_1[i-2]);
        }
        
        
        // 3. 정답
        answer = Math.max(DP_0[N-2], DP_1[N-1]);
        return answer;
    }
}