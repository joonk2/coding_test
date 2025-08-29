class Solution {
	public static int solution(int n, int w, int num) {
		int row = (int) Math.ceil( (double) n/w );
		int start = 1;
		int r = row-1;
		int[][] matrix = new int[row][w];
		
		while (start <= n) {
			if ( (row-1 - r) % 2 == 0 ) {
				for (int c = 0; c < w; c++) {
					if (start > n) break;
					matrix[r][c] = start;
					start++;
				}
			}
			else if ( (row-1 - r) % 2 == 1 ) {
				for (int c = w-1; c >= 0; c--) {
					if (start > n) break;
					matrix[r][c] = start;
					start++;
				}
			}
			r--;
		}
		
		
		int required_cnt = 0;
		for (int j = 0; j < w; j++) {
			int temp_cnt = 0;
			for (int i = 0; i < row; i++) {
				int temp_val = matrix[i][j];
				if (temp_val > 0) temp_cnt++;
				if (temp_val == num) {
					required_cnt = temp_cnt;
					break;
				}
			}
			if (required_cnt > 0) break;
		}
		return required_cnt;
	}
}