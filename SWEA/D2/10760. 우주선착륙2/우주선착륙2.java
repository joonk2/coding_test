import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution { 
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[] dr_diag = {-1,-1,1,1};
	static int[] dc_diag = {-1,1,-1,1};
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			// 0. 배열 생성
			int[][] arr = new int[N][M];
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < M; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			// 1. 예비 후보지 개수
			int candidates = 0;
			
			// 2. 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 2-1. 현지점
					int cur_point = arr[r][c];
					int temp_candidates = 0;
					
					// 2-2. 상하좌우
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						// 2-2-a. 범위 초과시 skip
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						
						// 2-2-b 그렇지 않을때 -> 현지점보다 낮다면
						if (arr[nr][nc] < cur_point) {
							temp_candidates++;
						}
					}
					
					// 2-3. 대각선
					for (int d = 0; d < 4; d++) {
						int nr_diag = r + dr_diag[d];
						int nc_diag = c + dc_diag[d];
						// 2-2-a. 범위 초과시 skip
						if (nr_diag < 0 || nr_diag >= N || nc_diag < 0 || nc_diag >= M) continue;
						
						// 2-2-b 그렇지 않을때 -> 현지점보다 낮다면
						if (arr[nr_diag][nc_diag] < cur_point) {
							temp_candidates++;
						}
					}
					
					// 2-4. 4개 이상이면 후보지로 간주
					if (temp_candidates >= 4) candidates++;
				}
			}
			
			// 3. 출력
			System.out.println("#" + tc + " " + candidates);
			
		}
		
		
	}
}