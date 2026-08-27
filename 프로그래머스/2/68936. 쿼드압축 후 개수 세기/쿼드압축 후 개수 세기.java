class Solution {
    static int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        // 1. quad_tree
        int sr = 0;
        int sc = 0;
        int N = arr.length;
        quad_tree(sr, sc, arr, N);
        
        // 2. 결과값
        return answer;
    }
    
    
    
    // 3. quad_tree 함수
    static void quad_tree(int cr, int cc, int[][] arr, int N) {
        
        // 3-1-a. 격자 안의 값이 첫 값과 다 같은지 확인
        int point = arr[cr][cc];
        boolean is_all_same = true;
        for (int r = cr; r < cr + N; r++) {
            for (int c = cc; c < cc + N; c++) {
                // 3-1-b. 1개라도 틀리면 종료
                if (arr[r][c] != point) {
                    is_all_same = false;
                    break;
                }
            }
            // 3-1-c. 이미 1개라도 틀렸으면 break
            if (!is_all_same) break;
        }
        
        // 3-1-d. 만약 전부 같으면 -> 종료
        if (is_all_same) {
            answer[point]++;
            return;
        }
        
        
        // 3-2. 1개라도 틀려서 압축 못했을시
        int nr = cr;
        int nc = cc;
        int half = N / 2;
        
        // 3-3. 재귀
        
        // 3-3-a upper_left
        quad_tree(nr, nc, arr, half);
        
        // 3-3-b. upper_right
        quad_tree(nr, nc + half, arr, half);
        
        // 3-3-c. down_left
        quad_tree(nr + half, nc, arr, half);
        
        // 3-3-d. down_right
        quad_tree(nr + half, nc + half, arr, half);
    }
    
    
}