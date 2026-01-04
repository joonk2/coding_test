import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < 3; c++) {
				arr[r][c] = Integer.parseInt(cols[c]);
			}
		}
		lets_figure_out_min_cost(N, arr);
	}
	
	
	
	
	
	static void lets_figure_out_min_cost(int N, int[][] arr) {
		int INF = 1000001;
		int answer = INF;
		
		for (int first = 0; first < 3; first++) {
			int[][] DP = new int[N][3];
			
			// 초기화
			for (int c = 0; c < 3; c++) {
				if (c == first) DP[0][c] = arr[0][c];
				else DP[0][c] = INF;
			}
			
			// DP
			for (int i = 1; i < N; i++) {
				DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + arr[i][0];
				DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + arr[i][1];
				DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + arr[i][2];
			}
			
			// result
			// 첫집과 같지 않아야한다
			for (int c = 0; c < 3; c++) {
				if (c != first) answer = Math.min(answer, DP[N-1][c]);
			}
		}
		System.out.println(answer);
	}
	
	
	
	
}