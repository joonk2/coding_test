class Solution {
    static int er = 10;
    static int ec = 10;
    static int sr = 0;
    static int sc = 0;
    
    public int solution(String dirs) {
        int leng = 0;
        
        int N = dirs.length();
        char[] commands = new char[N];
        for (int i = 0; i < N; i++) commands[i] = dirs.charAt(i);
        
        // 1. 초기 시작
        boolean[][][] visited = new boolean[10 + 1][10 + 1][4];
        int cr = 5;
        int cc = 5;
        int i = 0;
        while (i < N) {
            char cur_button = commands[i];
            
            int dr = 0;
            int dc = 0;
            int dd = 0;
            
            if (cur_button == 'U') {
                dr = -1;
                dc = 0;
                dd = 0;
            }
            else if (cur_button == 'D') {
            	dr = 1;
                dc = 0;
                dd = 1;
            }
            else if (cur_button == 'R') {
                dr = 0;
                dc = 1;
                dd = 2;
            }
            else if (cur_button == 'L') {
                dr = 0;
                dc = -1;
                dd = 3;
            }
            
            // 다음 좌표
            int nr = cr + dr;
            int nc = cc + dc;
            int nd = dd;
            
            
            // 2. 범위 밖 -> 다음으로 전환 후, skip
            if (nr < sr || nr > er || nc < sc || nc > ec) {
                i++;
                continue;
            }
            
            // 3. 양방향 값 확인
            int reverse_d = 0;
            if (nd == 0) reverse_d = 1;
            else if (nd == 1) reverse_d = 0;
            else if (nd == 2) reverse_d = 3;
            else if (nd == 3) reverse_d = 2;
            
            // 4. 방문했다면 좌표를 갱신하고, 다음으로 전환하고 skip
            if (visited[nr][nc][nd] || visited[cr][cc][reverse_d]) {
                cr = nr;
                cc = nc;
                i++;
                continue;
            }
            
            // 5. 양방향 방문 후에, 좌표 갱신
            visited[nr][nc][nd] = true;
            visited[cr][cc][reverse_d] = true;
            
            leng++;
            cr = nr;
            cc = nc;
            i++;
        }
        
        
        return leng;
    }
}