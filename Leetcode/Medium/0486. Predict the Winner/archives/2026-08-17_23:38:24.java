class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        // 1. 값 차이를 저장하는 DP
        int N = nums.length;
        int[][] DP = new int[N][N];
        for (int i = 0; i < N; i++) {
            DP[i][i] = nums[i];
        }

        // 2. 왼쪽을 고르면, 맨 왼쪽 제외 i+1 ~ N-1
        // 오른쪽을 고르면 맨 오른쪽 제외 i ~ N-2
        for (int i = 2; i < N+1; i++) {
            for (int left = 0; left + i -1 < N; left++) {
                int right = left + i - 1;
                int pick_left = nums[left] - DP[left+1][right];
                int pick_right = nums[right] - DP[left][right-1];

                DP[left][right] = Math.max(pick_left, pick_right);
            }
        }

        // 3. 값차이가 양수라면 P1 승리로 간주
        if (DP[0][N-1] >= 0) {
            return true;
        }

        // 4. 기본값 반환 
        return false;
    }
}