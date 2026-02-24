class Solution {
    static int[] answer = new int[2];
    
    
    public int[] solution(int[][] arr) {
        int N = arr.length;
        
    	back_tracking(0, 0, N, arr);    
        return answer;
    }
    
    
    
    static void back_tracking(int r, int c, int N, int[][] arr) {
        // 1. 먼저 한번에 축소시킬 수 있는지 확인하겠다.
        if(is_all_same(r, c, N, arr)) {
            int val = arr[r][c];
            answer[val]++;
            return;
        }
        
        // 2. 그렇지 않고, 한번에 축소시킬 수 없겠다?
        int new_size = N / 2;
        
        // 2-1. 왼쪽 위
        back_tracking(r, c, new_size, arr);
        
        // 2-2. 오른쪽 위
        back_tracking(r, c + new_size, new_size, arr);
        
        // 2-3. 왼쪽 아래
        back_tracking(r + new_size, c, new_size, arr);
        
        // 2-4. 오른쪽 아래
        back_tracking(r + new_size, c + new_size, new_size, arr);
    }
    
    
    static boolean is_all_same(int r, int c, int size, int[][] arr) {
        int first_val = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != first_val) return false;
            }
        }
        return true;
    }
    
    
}