class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        
        // 1. 조기종료
        if (N == 1) {
            return money[0];
        }
        else if (N == 2) {
            int res = Math.max(money[0], money[1]);
            return res;
        }
        else if (N == 3) {
            int res = Math.max(money[0], Math.max(money[1], money[2]));
        }
        
        // 2. N >= 4
        int[] DP_0 = new int[N];
        int[] DP_1 = new int[N];
        
        // 2-1. 0번째 집 선택
        DP_0[0] = money[0];
        DP_0[1] = money[0];
        for (int i = 2; i < N-1; i++) {
            DP_0[i] = Math.max(DP_0[i-1], DP_0[i-2] + money[i]);
        }
        
        // 2-2. 0번쨰 집 선택X
        DP_1[1] = money[1];
        DP_1[2] = Math.max(money[1], money[2]);
        for (int i = 3; i < N; i++) {
            DP_1[i] = Math.max(DP_1[i-1], DP_1[i-2] + money[i]);
        }
        
        // 3. 비교
        answer = Math.max(DP_0[N-2], DP_1[N-1]);
        return answer;
    }
}