class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        // 1. 정답배열
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < row; r++) {
            List<Integer> temp = new ArrayList<>();
            for (int c = 0; c < col; c++) {
                temp.add(0);
            }
            result.add(temp);
        }

        // 2. 모든 원소들을 새로운 자리로 배치
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 2-1. 현재 값, 현재 행, 현재 열
                int cur_val = grid[r][c];
                int cr = r;
                int cc = c;

                // 2-2. 몫, 나머지 활용
                int nr = cr;
                int nc = cc + k;

                // 2-3. nc가 col 이상이면 몫제거
                if (nc >= col) {
                    int mod_diff = nc / col;
                    nr = (cr + mod_diff) % row;
                    nc %= col;
                }

                // 2-4. 대입
                result.get(nr).set(nc, cur_val);



            }
        }

        return result;
    }
}