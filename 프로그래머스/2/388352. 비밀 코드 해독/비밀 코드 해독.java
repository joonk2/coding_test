class Solution {
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        int r = q[0].length;
        int[] is_possible_code = new int[r];
        comb(1, 0, n, r, is_possible_code, q, ans);
        
        return answer;
    }
    
    
    // 1. 조합
    static void comb(int start, int depth, int n, int r, int[] is_possible_code, int[][] q, int[] ans) {
        
        // 1-1. 최대 깊이 도달시
        if (depth == r) {
            calculate(r, is_possible_code, q, ans);
            return;
        }
        
        
        // 1-2. 아직 최대 깊이 도달 못했다면
        for (int i = start; i < n+1; i++) {
            is_possible_code[depth] = i;
            comb(i+1, depth+1, n, r, is_possible_code, q, ans);
        }
        
    }
    
    
    
    // 2. 계산
    static void calculate(int r, int[] is_possible_code, int[][] q, int[] ans) {
        int m = q.length;
        int cnt_check = 0;
        int total_check = m;
        
        for (int i = 0; i < m; i++) {
            int[] temp_q = q[i];
            int temp_cnt = 0;
            for (int j = 0; j < r; j++) {
                int cur_val = q[i][j];
                for (int k = 0; k < r; k++) {
                    int digit = is_possible_code[k];
                    if (cur_val == digit) {
                        temp_cnt++;
                        break;
                    }
                }
            }
            // 2-1. 1차 점검
            if (temp_cnt == ans[i]) cnt_check++;
        }
        
        // 2-2. 최종 확인
        if (cnt_check == total_check) answer++;
    }
    
    
    
    
}