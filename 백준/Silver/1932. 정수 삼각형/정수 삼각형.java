import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	static int[] dr = {-1,1,1};
	static int[] dc = {1,0,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		arr[0][0] = Integer.parseInt(br.readLine());
		
		// 조기종료
		if (N == 1) {
			System.out.println(arr[0][0]);
			return;
		}
		
		// 1 이상일 때
		for (int i = 1; i < N; i++) {
			String[] nums = br.readLine().split(" ");
			for (int j = 0; j < nums.length; j++) {
				arr[i][j] = Integer.parseInt(nums[j]);
			}
		}
		
		
		// result
		lets_find_max_sum(N, arr);
	}
	
	
	
	
	
	
	static void lets_find_max_sum(int N, int[][] arr) {
		int[][] DP = new int[N][N];
		DP[0][0] = arr[0][0];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					// 범위밖이면 스킵
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					DP[nr][nc] = Math.max(DP[nr][nc], DP[r][c] + arr[nr][nc]);
				}
			}
		}
		
		
		
		// 결과
		int max_sum = Integer.MIN_VALUE;
		for (int c = 0; c < N; c++) {
			max_sum = Math.max(max_sum, DP[N-1][c]);
		}
		System.out.println(max_sum);
	}
	
	
	
	
}