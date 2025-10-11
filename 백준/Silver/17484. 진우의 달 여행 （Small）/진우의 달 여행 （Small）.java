import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dr = {1,1,1};
	static int[] dc = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);
		int[][] arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(cols[c]);
			}
		}
		min_fuel(arr, R, C);
	}
	
	
	static void min_fuel(int[][] arr, int R, int C) {
		int INF = Integer.MAX_VALUE;
		long[][][] DP = new long[R][C][3];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				for (int d = 0; d < 3; d++) {
					DP[r][c][d] = INF;
				}
			}
		}
		
		// first row
		for (int c = 0; c < C; c++) {
			for (int d = 0; d < 3; d++) {
				DP[0][c][d] = arr[0][c];
			}
		}
		
		// explore
		for (int r = 1; r < R; r++) {
			for (int c = 0; c < C; c++) {
				for (int d = 0; d < 3; d++) {
					int prev_r = r-1;
					int prev_c = c - dc[d];
					
					// pruning (reverse check)
					if (prev_c < 0 || prev_c >= C) continue;
					for (int prev_d = 0; prev_d < 3; prev_d++) {
						
						// pruning -> (prev_d != d)
						if (prev_d == d) continue;
						DP[r][c][d] = Math.min(DP[r][c][d], DP[prev_r][prev_c][prev_d] + arr[r][c]);
					}
				}
			}
		}
		
		
		// res (exploring the last row)
		long min_fuel = Long.MAX_VALUE;
		for (int c = 0; c < C; c++) {
			for (int d = 0; d < 3; d++) {
				min_fuel = Math.min(min_fuel, DP[R-1][c][d]);
			}
		}
		System.out.println(min_fuel);
	}
	
	
}