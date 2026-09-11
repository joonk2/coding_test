import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			
			// 완탐
			int max_leng = 1;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cur = arr[r][c];
					int cur_leng = 1;
					
					int cr = r;
					int cc = c;
					int min_num = cur;
					while (true) {
						int target_r = -1;
						int target_c = -1;
						
						for (int d = 0; d < 4; d++) {
							int nr = cr + dr[d];
							int nc = cc + dc[d];
							if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							
							if (arr[nr][nc] < min_num) {
								min_num = arr[nr][nc];
								target_r = nr;
								target_c = nc;
							}
							
						}
						
						if (target_r == -1 && target_c == -1) break;
						
						cur_leng++;
						cr = target_r;
						cc = target_c;
					}
					
					max_leng = Math.max(cur_leng, max_leng);
				}
			}
			
			System.out.println("#" + tc + " " + max_leng);
			
			
			
		}
		
		
		
	}
}
