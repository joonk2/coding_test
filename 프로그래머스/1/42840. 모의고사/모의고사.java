import java.util.List;
import java.util.ArrayList;

class Solution {
    static int[] s1_guess = {1,2,3,4,5};
    static int[] s2_guess = {2,1,2,3,2,4,2,5};
    static int[] s3_guess = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int cnt_s1 = 0;
        int cnt_s2 = 0;
        int cnt_s3 = 0;
        for (int i = 0; i < answers.length; i++) {
            int s1 = s1_guess[i % (s1_guess.length)];
            int s2 = s2_guess[i % (s2_guess.length)];
            int s3 = s3_guess[i % (s3_guess.length)];
            if (s1 == answers[i]) cnt_s1++;
            if (s2 == answers[i]) cnt_s2++;
            if (s3 == answers[i]) cnt_s3++;
        }
        
        int max = Math.max(cnt_s1, Math.max(cnt_s2, cnt_s3));
        
        List<Integer> lst = new ArrayList<>();
        
        if (cnt_s1 == max) lst.add(1);
        if (cnt_s2 == max) lst.add(2);
        if (cnt_s3 == max) lst.add(3);
        
        
        int[] answer = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        
        
        return answer;
    }
}