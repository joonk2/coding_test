class Solution {
    static int er = 10;
    static int ec = 10;
    static int sr = 0;
    static int sc = 0;
    
    public int solution(String dirs) {
        int leng = 0;
        int N = dirs.length();
        char[] commands = new char[N];
        for (int i = 0; i < N; i++) {
            commands[i] = dirs.charAt(i);
        }
        

        
        // 1. 초기값 설정
        int cr = 5;
        int cc = 5;
        int cd = 0;
        boolean[][][] visited = new boolean[10+1][10+1][4];
        
        // 2. 탐색
        int i = 0;
        while (i < N) {
            // 현재 버튼
            char cur_button = commands[i];
            
            // 방향
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
            
            // 다음 방향
            int nr = cr + dr;
            int nc = cc + dc;
            int nd = dd;
            
            // 2-1. 범위 밖 -> 다음으로 전환후 skip
            if (nr < sr || nr > er || nc < sc || nc > ec) {
                i++;
                continue;
            }
            
            // 2-2. 방문했으면 -> 위치 이동, 다음으로 전환 후 skip
            if (visited[nr][nc][nd]) {
                cr = nr;
                cc = nc;
                cd = nd;
                i++;
                continue;
            }
            
            
            // 2-3-a. 양방향 처리
            int reversed_d = 0;
            if (dd == 0) reversed_d = 1;
            else if (dd == 1) reversed_d = 0;
            else if (dd == 2) reversed_d = 3;
            else if (dd == 3) reversed_d = 2;
            
            // 2-3-b. 범위O, 미방문시 -> 위치이동후 횟수++, 그리고 다음으로 전환
            
            visited[nr][nc][nd] = true;
            visited[cr][cc][reversed_d] = true;
            
            leng++;
            cr = nr;
            cc = nc;
            cd = nd;
            i++;
        }
        
        
        return leng;
    }
}