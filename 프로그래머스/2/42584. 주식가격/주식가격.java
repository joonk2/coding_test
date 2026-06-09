class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = i+1; j < N; j++) {
                if (prices[i] <= prices[j]) cnt++;
                else if (prices[i] > prices[j]) {
                    cnt++;
                    break;
                }
            }
            answer[idx] = cnt;
            idx++;
        }
        
        return answer;
    }
}