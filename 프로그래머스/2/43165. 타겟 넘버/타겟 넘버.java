class Solution {
    static int answer;
    static int N;
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    static void dfs(int idx, int val, int target, int[] numbers) {
        
        // pruning
        if (idx == N && val == target) {
            answer++;
            return;
        }
        else if (idx == N) {
            return;
        }
        
        dfs(idx+1, val + numbers[idx], target, numbers);
        dfs(idx+1, val - numbers[idx], target, numbers);
    }
    
    
    
}