import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int max_sum = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			// 0. 배열 채우기
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			// 1. 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int temp_sum = 0;
					int cur_point = arr[r][c];
					temp_sum += cur_point;
					
					// 1-1. 방향 
					for (int d = 0; d < 4; d++) {
						for (int k = 1; k < N; k++) {
							int nr = r + (dr[d] * k);
							int nc = c + (dc[d] * k);
							// 1-2. 범위 초과시 skip
							if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							
							// 1-3. 그렇지 않다면 가산
							temp_sum += arr[nr][nc];
						}
					}
					
					// 2. 비교
					max_sum = Math.max(temp_sum, max_sum);
				}
			}
			// 3. 출력
			System.out.println("#" + tc + " " + max_sum);
		}
	}
}