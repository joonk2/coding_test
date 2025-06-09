import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row = 9, col = 9;
		
		int[][] matrix = new int[row][col];
		for (int r = 0; r < row; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < col; c++) {
				matrix[r][c] = Integer.parseInt(cols[c]);
			}
		}
		
//		for (int r = 0; r < row; r++) {
//			System.out.println(Arrays.toString(matrix[r]));
//		}
		
		int max_val = Integer.MIN_VALUE;
		int max_row = -1;
		int max_col = -1;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				int temp_val = matrix[r][c];
				if (temp_val > max_val) {
					max_val = temp_val;
					max_row = r+1;
					max_col = c+1;
				}
			}
		}
		
		System.out.println(max_val);
		System.out.println(max_row + " " + max_col);
		
		
	}
}