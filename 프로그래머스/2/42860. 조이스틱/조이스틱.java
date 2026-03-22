class Solution {
    public int solution(String name) {
        int cnt = 0;
        int N = name.length();
        
        
        // 1. 상, 하
        for (int i = 0; i < N; i++) {
            char ch = name.charAt(i);
            int down = ch - 'A';
            int up = 26 - (ch - 'A');
            
            int diff_1 = Math.min(down, up);
            cnt += diff_1;
        }
        
        // 2. 좌, 우
        int move = N-1;
        for (int i = 0; i < N; i++) {
            int next = i+1;
            while (next < N && name.charAt(next) == 'A') {
                next++;
            }
            
            // 오른쪽으로 끝까지 다돌기 vs 오른쪽으로 가다가 u턴 + 왼쪽으로 거꾸로
            move = Math.min(move, i*2 + (N-next));
            
            // 오른쪽으로 끝까지 다돌기 vs 왼쪽 뒤 가다가 u턴 + 오른쪽으로
            move = Math.min(move, (N-next)*2 + i);
        }
        
        cnt += move;
        
        return cnt;
    }
}