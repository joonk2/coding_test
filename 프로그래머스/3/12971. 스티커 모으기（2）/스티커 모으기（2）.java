class Solution {
    public int solution(int sticker[]) {
        // 2개의 배열을 생성하여 값 비교하자
        int N = sticker.length;
        
        // 1. 조기종료
        if (N == 1) {
            int res = sticker[0];
            return res;
        }
        if (N == 2) {
            int res = Math.max(sticker[0], sticker[1]);
            return res;
        }
        
        
        // 2-1. 0번째 idx 선택 -> 0 ~ N-2
        int[] DP_0 = new int[N];
        DP_0[0] = sticker[0];
        DP_0[1] = DP_0[0];
        for (int i = 2; i < N-1; i++) {
            DP_0[i] = Math.max(DP_0[i-1], sticker[i] + DP_0[i-2]);
        }
        
        // 2-2. 0번째 idx 미선택 -> ~ N-1
        int[] DP_1 = new int[N];
        DP_1[1] = sticker[1];
        DP_1[2] = Math.max(DP_1[1], sticker[2]);
        for (int i = 3; i < N; i++) {
            DP_1[i] = Math.max(DP_1[i-1], sticker[i] + DP_1[i-2]);
        }
        
        // 3. 비교
        int answer = Math.max(DP_0[N-2], DP_1[N-1]);
        return answer;
    }
}