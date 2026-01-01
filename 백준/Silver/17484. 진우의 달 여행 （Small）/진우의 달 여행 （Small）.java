import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


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
		// 1. 최소거리 INF 초기화
		int INF = 1_000_000;
		int[][][] DP = new int[N][M][3];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 3; d++) {
					DP[r][c][d] = INF;
				}
			}
		}
		
		// 2. 첫번째 행 DP에 입력
		for (int r = 0; r < 1; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 3; d++) {
					DP[r][c][d] = arr[r][c];
				}
			}
		}
		
		// 3. 탐험 (2번째 행부터)
		// 3-1. 현재 위치가 범위를 벗어나는지?
		// 3-2. 이전위치가 범위를 벗어났는지?
		// 3-3. 현재 방향이 이전방향과 같은지?
		
		for (int r = 1; r < N; r++) {
			// 이 반복문으로 현재 위치는 범위를 벗어나지않는 것을 확인
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 3; d++) {
					int prev_r = r-1;
					int prev_c = c - dc[d];
					// 이전 위치가 범위를 벗어나는가?
					if (prev_c < 0 || prev_c >= M) continue;
					
					// 현재 방향이 이전 방향이랑 같은가?
					for (int prev_d = 0; prev_d < 3; prev_d++) {
						if (d == prev_d) continue;
						DP[r][c][d] = Math.min(DP[r][c][d], DP[prev_r][prev_c][prev_d] + arr[r][c]);
					}
				}
			}
		}
		
		// 4. 결과
		int min_fuel = INF;
		for (int c = 0; c < M; c++) {
			for (int d = 0; d < 3; d++) {
				min_fuel = Math.min(min_fuel, DP[N-1][c][d]);
			}
		}
		System.out.println(min_fuel);
	}
	
	
	
	
}