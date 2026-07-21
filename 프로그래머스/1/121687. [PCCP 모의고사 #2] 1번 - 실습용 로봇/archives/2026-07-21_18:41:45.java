class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int[] solution(String command) {
        int[] answer = new int[2];
        
        // 1. 버튼 lst
        int N = command.length();
        char[] button = new char[N];
        for (int i = 0; i < N; i++) {
            button[i] = command.charAt(i);
        }
        
        // 2. 첫 시작좌표
        int cr = 0;
        int cc = 0;
        
        // 3. 버튼 동작
        int d = 0;
        for (int i = 0; i < N; i++) {
            // 3-1. R
            if (button[i] == 'R') {
                d = (d+1) % 4;
            }
            // 3-2. L
            else if (button[i] == 'L') {
                d = (d-1 + 4) % 4;
            }
            // 3-3. G
            else if (button[i] == 'G') {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                cr = nr;
                cc = nc;
            }
            // 3-4. B
            else if (button[i] == 'B') {
                int nr = cr - dr[d];
                int nc= cc - dc[d];
                cr = nr;
                cc = nc;
            }
        }
        
        // 4. 정답
        answer[0] =  cr;
        answer[1] = cc;
        return answer;
    }
}