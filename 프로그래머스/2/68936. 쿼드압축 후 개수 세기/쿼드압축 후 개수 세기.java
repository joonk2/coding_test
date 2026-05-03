class Solution {
    static int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int sr = 0;
        int sc = 0;
        int N = arr.length;
        
        back_tracking(sr, sc, N, arr);
        return answer;
    }
    
    
    
    static void back_tracking(int r, int c, int cur_size, int[][] arr) {
        // 1. 첫 원소
        int first_val = arr[r][c];
        
        // 1. 검사
        if (is_all_same(first_val, r, c, cur_size, arr)) {
            answer[first_val]++;
            return;
        }
        
        // 2. 4방향 탐색
        int new_size = cur_size / 2;
        
        // 2-1 왼위
        back_tracking(r, c, new_size, arr);
        
        // 2-2. 오위
        back_tracking(r, c+new_size, new_size, arr);
        
        // 2-3. 왼아래
        back_tracking(r+new_size, c, new_size, arr);
        
        // 2-4 오아래
        back_tracking(r+new_size, c+new_size, new_size, arr);
    }
    
    
    static boolean is_all_same(int val, int r, int c, int cur_size, int[][] arr) {
        for (int i = r; i < r + cur_size; i++) {
            for (int j = c; j < c + cur_size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        
        return true;
    }
    
    
    
}