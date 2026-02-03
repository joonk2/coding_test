import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] s1 = br.readLine().split(" ");
			String[] s2 = br.readLine().split(" ");
			
			int[][] arr = new int[2][N+1];
			int[][] DP = new int[2][N+1];
			
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < N; c++) {
					if (r%2 == 0) {
						arr[r][c+1] = Integer.parseInt(s1[c]);
					}
					else if (r%2 == 1) {
						arr[r][c+1] = Integer.parseInt(s2[c]);
					}
				}
			}
			
			// 초기값
			DP[0][1] = arr[0][1];
			DP[1][1] = arr[1][1];
			
			
			// 계산
			for (int i = 2; i < N+1; i++) {
				// 위쪽 스티커 땔떼
				DP[0][i] = Math.max(DP[1][i-1], DP[1][i-2]) + arr[0][i];
				
				// 아래쪽 스티커 땔떼
				DP[1][i] = Math.max(DP[0][i-1], DP[0][i-2]) + arr[1][i];
			}
			
			int max_val = Math.max(DP[0][N], DP[1][N]);
			System.out.println(max_val);
			
		}
	}
	
	
	
}
			