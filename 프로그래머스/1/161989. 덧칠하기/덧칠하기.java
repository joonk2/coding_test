class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start_idx = 0;
        int N = section.length;
        
        while (start_idx < N) {
            int cur_num = section[start_idx];
            int s = cur_num;
            int e = s + m - 1;
            answer++;
            
            while (start_idx < N && section[start_idx] <= e) {
                start_idx++;
            }
        }
        
        
        return answer;
    }
}