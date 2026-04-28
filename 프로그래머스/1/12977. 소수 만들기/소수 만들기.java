class Solution {
    static int answer;
    static int N;
    
    public int solution(int[] nums) {
        answer = 0;
        N = nums.length;
        back_tracking(0, 0, 0, nums);
        return answer;
    }
    
    
    static void back_tracking(int idx, int cnt, int sum, int[] nums) {
        // 1. cnt 도달시 계산
        if (cnt == 3) {
            if (is_prime(sum)) {
                answer++;
            }
            return;
        }
        
        // 2. 가지치기 -> idx 초과 or (현재 고른횟수와 남은걸 다 골라도 3보다 작을때)
        if (idx >= N || cnt + (N-idx) < 3) return;
        
        
        // 3-1. 선택
        back_tracking(idx+1, cnt+1, sum + nums[idx], nums);
        
        // 3-2. 미선택
        back_tracking(idx+1, cnt, sum, nums);
    }
    
    
    
    static boolean is_prime(int sum) {
        int res = 0;
        for (int i = 1; i < sum+1; i++) {
            if (sum % i == 0) res++;
        }
        
        if (res == 2) return true;
        
        return false;
    }
    
    
}