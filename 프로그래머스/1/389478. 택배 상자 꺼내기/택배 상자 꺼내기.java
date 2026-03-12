class Solution {
    public int solution(int n, int w, int num) {
        int row = 0;
        if (n % w == 0) {
            row = n / w;
        }
        else if ( n % w != 0) {
            row = (n / w) + 1;
        }
        int col = w;
        
        int[][] arr = new int[row][col];
        
        // 1. 배열 초기값 생성
        int digit = 1;
        int r = 0;
        while (digit <= n) {
            for (int c = 0; c < col; c++) {
                // 종료
                if (digit > n) break;
                
                
                // 그게 아니라면 값 할당
                if (r % 2 == 0) {
                    arr[row-1-r][c] = digit;
                }
                if (r % 2 == 1) {
                    arr[row-1-r][col-1-c] = digit;
                }
                digit++;
                
            }
            r++;
        }
        
        // 0을 세고 찾아야하니 해당박스의 row와 col을 찾자
        int box_r = 0;
        int box_c = 0;
        for (int i = 0; i < row; i++) {
            boolean done = false;
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == num) {
                    box_r = i;
                    box_c = j;
                    done = true;
                    break;
                }
            }
            // 조기 종료
            if (done) break;
        }
        
        
        // 수직으로 행만 확인하면 된다
        int cnt = 0;
        for (int i = 0; i < box_r + 1; i++) {
            if (arr[i][box_c] == 0) continue;
            cnt++;
        }
        
        return cnt;
    }
}