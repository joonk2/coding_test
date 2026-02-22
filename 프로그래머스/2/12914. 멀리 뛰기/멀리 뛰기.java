class Solution {
    public long solution(int n) {
        long answer = 0;
        
        // 1. 조기종료
        if (n == 1) {
            answer = 1;
            return answer;
        }
        if (n == 2) {
            answer = 2;
            return answer;
        }
        
        
        // 2. 점화식
        long[] DP = new long[n+1];
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i < n+1; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
        }
        
        answer = DP[n];
        return answer;
    }
}