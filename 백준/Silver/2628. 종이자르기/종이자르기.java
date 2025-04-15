import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
//import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] xy = br.readLine().split(" ");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
			
		int N = Integer.parseInt(br.readLine());
		
		// max 100 + 2(start, end)
		int[] row = new int[102]; 
		int[] col = new int[102];
		int r_cnt = 0;
		int c_cnt = 0;
		
		row[r_cnt++] = 0;
		row[r_cnt++] = y;
		col[c_cnt++] = 0;
		col[c_cnt++] = x;
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			int dir = Integer.parseInt(line[0]);
			int pos = Integer.parseInt(line[1]);
			
			if (dir == 0) {
				row[r_cnt++] = pos;
			}
			else if (dir == 1) {
				col[c_cnt++] = pos;
			}
			
		}
			// sort(idx[0] ~ idx[r_cnt])
			Arrays.sort(row, 0, r_cnt);
			Arrays.sort(col, 0, c_cnt);
			
			int max_row = 0;
			for (int k = 1; k < r_cnt; k++) {
				int temp_row = row[k] - row[k-1];
				if (temp_row > max_row) {
					max_row = temp_row;
				}
			}
			
			
			int max_col = 0;
			for (int k = 1; k < c_cnt; k++) {
				int temp_col = col[k] - col[k-1];
				if (temp_col > max_col) {
					max_col = temp_col;
				}
			}
			

		
		System.out.println(max_row * max_col);
		
		
	}
}