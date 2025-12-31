import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int[] dr = {1,1,1};
	static int[] dc = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[][] arr = new int[N][M];
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(cols[c]);
			}
		}
		lets_figure_out_min_fuel(N, M, arr);
	}
	
	
	
	
	static void lets_figure_out_min_fuel(int N, int M, int[][] arr) {
		int INF = 1_000_000;
		int[][][] DP = new int[N][M][3];
		
		// initiation INF
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 3; d++) {
					DP[r][c][d] = INF;
				}
			}
		}
		
		
		
		
		// input first row on DP
		for (int r = 0; r < 1; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 3; d++) {
					DP[r][c][d] = arr[r][c];
				}
			}
		}
		
		
		// explore
		for (int r = 1; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 3; d++) {
					int prev_r = r-1;
					int prev_c = c - dc[d];
					
					// 만약 모서리지점인데 위치를 벗어나면 skip
					if (prev_c < 0 || prev_c >= M) continue;
					
					// 만약 d 랑 prev_d 같으면 skip
					for (int prev_d = 0; prev_d < 3; prev_d++) {
						if (d == prev_d) continue;
						DP[r][c][d] = Math.min(DP[r][c][d], DP[prev_r][prev_c][prev_d] + arr[r][c]);
					}
				}
			}
		}
		
		
		// result
		int min_fuel = INF;
		for (int c = 0; c < M; c++) {
			for (int d = 0; d < 3; d++) {
				min_fuel = Math.min(min_fuel, DP[N-1][c][d]);
			}
		}
		System.out.println(min_fuel);
		
	}
	
	
	
}