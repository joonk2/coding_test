import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution { 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			
			// 탐색
			int area = 1;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 방문 안했고 1이라면?
					if (!visited[r][c] && arr[r][c] == 1) {
						// 시작점 : sr, sc
						int sr = r;
						int sc = c;
						
						int diff_r = sr;
						int diff_c = sc;
						int process = 0;
						
						while (process < 2) {
							// 1. 가로검사
							if (process == 0) {
								int nc = diff_c + 1;
								// 1-1. 범위 검사
								if (nc >= N) {
									process++;
									continue;
								}
								// 1-2. 0이라면 -> skip
								if (arr[sr][nc] == 0) {
									process++;
									continue;
								}
								
								// 1-3. 아니라면 -> 갱신
								diff_c = nc;
							}
							
							// 2. 세로검사
							else if (process == 1) {
								int nr = diff_r + 1;
								// 1-1. 범위 검사
								if (nr >= N) {
									process++;
									continue;
								}
								// 1-2. 0이라면 -> skip
								if (arr[nr][sc] == 0) {
									process++;
									continue;
								}
								// 1-3. 아니라면 -> 갱신
								diff_r = nr;
								
								
							}
						}
						
						// 2. 방문처리
						for (int i = sr; i < diff_r + 1; i++) {
							for (int j = sc; j < diff_c + 1; j++) {
								if (!visited[i][j]) {
									visited[i][j] = true;
								}
							}
						}
						
						// 3. 제일 큰 넓이인가?
						int temp_row = (diff_r - sr + 1);
						int temp_col = (diff_c - sc + 1);
						
						area = Math.max(area, temp_row * temp_col);
					}
				}
			}
			
			// 4. 출력
			System.out.println("#" + tc + " " + area); 
			
			
		}
		
		
	}
}