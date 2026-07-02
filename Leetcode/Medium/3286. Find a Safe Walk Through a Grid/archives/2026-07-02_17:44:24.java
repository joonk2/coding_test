import java.util.Queue;
import java.util.LinkedList;


class Solution {
    static int row, col;
    static int[][] DP;
    static int sr, sc, er, ec;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        // 1. 행, 열
        row = grid.size();
        col = grid.get(0).size();
        DP = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                DP[r][c] = -1;
            }
        }

        // 2. 위치 설정
        sr = 0;
        sc = 0;
        er = row-1;
        ec = col-1;
        
        // 3=1. bfs 생성, 첫 원소넣고 방문 시작
        int start_health = health;
        Queue<int[]> q = new LinkedList<>();

        // 3-2. 만약 첫 시작점이 1이라면,체력 1 깎고 시작
        if (grid.get(0).get(0) == 1) {
            start_health--;
            DP[0][0] = start_health;
        }
        // 3-3. 조기종료
        if (start_health == 0) return false;

        // 3-4. 그 외는 탐색 시작
        q.add(new int[] {sr, sc, start_health});
        
        // 4. 검사
        boolean is_alive = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cur_health = cur[2];

            // 4-1. 끝점 도달했을때
            if (cr == er && cc == ec) {
                // 4-1-a. 현재 체력이 1이상이면
                if (cur_health >= 1) is_alive = true;

                // 4-1-b. 조기종료
                if (is_alive) break;
            }

            // 4-2. 아직 도달 못했으면
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                // 4-3. 격자 범위 밖이면 skip
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;

                // 4-4. 격자범위에 속해 있을 때
                int cur_status = grid.get(nr).get(nc);

                // 4-6. 다음 체력
                int next_health = cur_health - cur_status;

                // 4-7. 만약 다음체력이 1이상, DP보다 크다면?
                if (next_health >= 1 && next_health > DP[nr][nc]) {
                    DP[nr][nc] = next_health;
                    q.add(new int[] {nr, nc, next_health});
                }

            }

        }


        return is_alive;
    }
}