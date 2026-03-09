class Solution {
    static int er = 10;
    static int ec = 10;
    static int sr = 0;
    static int sc = 0;
    
    public int solution(String dirs) {
        int leng = 0;
        
        int N = dirs.length();
        char[] commands = new char[N];
        for (int i = 0; i < N; i++) commands[i] =  dirs.charAt(i);
        
        // 1. 초기 시작
        boolean[][][] visited = new boolean[10 + 1][10 + 1][444 + 1];
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
                dd = 111;
            }
            else if (cur_button == 'D') {
                dr = 1;
                dc = 0;
                dd = 222;
            }
            else if (cur_button == 'R') {
                dr = 0;
                dc = 1;
                dd = 333;
            }
            else if (cur_button == 'L') {
                dr = 0;
                dc = -1;
                dd = 444;
            }
            
            // 다음좌표
            int nr = cr + dr;
            int nc = cc + dc;
            int nd = dd;
            
            // 범위 밖 -> 다음으로 전환하고 skip
            if (nr < sr || nr > er || nc < sc || nc > ec) {
                i++;
                continue;
            }
            
            // 양방향 값을 확인하기위해 반대 방향도 추가하겠다
            int reverse_d = 0;
            if (nd == 111) reverse_d = 222;
            else if (nd == 222) reverse_d = 111;
            else if (nd == 333) reverse_d = 444;
            else if (nd == 444) reverse_d = 333;
            
            // 방문을 했어? -> 그렇다면 좌표만 갱신하고 다음으로 전환하고 skip
            if (visited[nr][nc][nd] || visited[cr][cc][reverse_d]) {
                cr = nr;
                cc = nc;
                i++;
                continue;
            }
            
            // new thing -> 양방향을 방문한 다음에 좌표를 갱신하고, 길이를 추가한다음 다음으로 전환하자.
            visited[nr][nc][nd] = true;
            visited[cr][cc][reverse_d] = true;
            cr = nr;
            cc = nc;
            leng++;
            i++;
        }
        
        
        return leng;
    }
}