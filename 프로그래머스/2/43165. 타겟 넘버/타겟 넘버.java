class Solution {
    static int N;
    static int answer;
    
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        back_tracking(0, 0, target, numbers);
        return answer;
    }
    
    
    
    static void back_tracking(int idx, int cum_sum, int target, int[] numbers) {
        if (idx == N && cum_sum == target) {
            answer++;
        }
        if (idx == N) return;
        back_tracking(idx+1, cum_sum + numbers[idx], target, numbers);
        back_tracking(idx+1, cum_sum - numbers[idx], target, numbers);
    }
    
    
    
}