import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < 3; c++) {
				arr[r][c] = Integer.parseInt(cols[c]);
			}
		}
		lets_figure_out_min_cost(N, arr);
	}
	
	
	
	static void lets_figure_out_min_cost(int N, int[][] arr) {
		int[][] DP = new int[N][3];
		DP[0][0] = arr[0][0];
		DP[0][1] = arr[0][1];
		DP[0][2] = arr[0][2];
		
		// 색깔이 겹치면 안된다 -> 각각 보자
		for (int i = 1; i < N; i++) {
			DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + arr[i][0];
			DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + arr[i][1];
			DP[i][2] = Math.min(DP[i-1][1] , DP[i-1][0]) + arr[i][2];
		}
		
		int res = 1001;
		res = Math.min(DP[N-1][0], Math.min(DP[N-1][1], DP[N-1][2]));
		System.out.println(res);
		
	}
	
	
}