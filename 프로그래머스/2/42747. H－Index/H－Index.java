import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int N = citations.length;
        
        Arrays.sort(citations);
        for (int i = 0; i < N; i++) {
            int h = N - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
            
        }
        return answer;
    }
}