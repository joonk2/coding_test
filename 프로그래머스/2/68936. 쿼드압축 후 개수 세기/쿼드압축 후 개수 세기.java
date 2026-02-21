class Solution {
    static int[] answer = new int[2];
    
    
    public int[] solution(int[][] arr) {
        int N = arr.length;
        quad_tree(0, 0, N, arr);
        return answer;
    }
    
    
    static void quad_tree(int r, int c, int size, int[][] arr) {
        
        // 1. 전부 같은지 확인 -> 만약 같다면 값 적립후에 종료
        if (is_all_same(r, c, size, arr)) {
            answer[ arr[r][c] ]++;
            return;
        }
		
        
        // 2. 만약 값이 같지 않다면 분할
        int new_size = size / 2;
        
        // 2-1. 왼쪽 위
        quad_tree(r, c, new_size, arr);
        
        // 2-2. 오른쪽 위
        quad_tree(r, c + new_size, new_size, arr);
        
        // 2-3. 왼쪽 아래
        quad_tree(r + new_size, c, new_size, arr);
        
        // 2-4. 오른쪽 아래
        quad_tree(r + new_size, c + new_size, new_size, arr);  
    }
    
    
	
    static boolean is_all_same(int r, int c, int size, int[][] arr) {
        int cur_val = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != cur_val) return false;
            }
        }
        return true;
    }
    
    
    
}