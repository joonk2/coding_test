import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int N = B.length;
        
        // A 시작점
        // B 시작점
        int s1 = 0;
        int s2 = 0;
        while (true) {
            if (s1 >= N) break;
            if (s2 >= N) break;
            
            if (A[s1] >= B[s2]) s2++;
            else if (A[s1] < B[s2]) {
                s1++;
                s2++;
                answer++;
            }
        }
        return answer;
    }
}