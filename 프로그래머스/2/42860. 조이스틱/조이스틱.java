import java.util.Arrays;

class Solution {
    public int solution(String name) {
        int cnt = 0;
        int N = name.length();
        
        
        // 1. 상, 하 (알파벳 변경)
        for (int i = 0; i < N; i++) {
            char ch = name.charAt(i);
            int down = ch - 'A';
            int up = 26 - (ch - 'A');
            
            int diff_1 = Math.min(down, up);
            cnt += diff_1;
        }
        
        // 2. 좌, 우 (커서 이동)
        int group_A = -1;
        int cnt_dir = -1;
        for (int i = 0; i < N; i++) {
            int x = name.charAt(i) - 'A';
            if (x == 0) group_A++;
            else cnt_dir++;
        }
        
        if (group_A == -1) group_A = 0;
        
        cnt += (group_A + cnt_dir);
        System.out.println(group_A + " " + cnt_dir);
        return cnt;
    }
}