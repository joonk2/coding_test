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
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			// 1. 배열 생성
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			// 2. 검사 (완전탐색)
			int max_leng = 1;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cr = r;
					int cc = c;
					int cur_leng = 1;
					
					// 2-1. 낮은 영역이 여러개면 가장 낮은 곳으로
					while (true) {
						int destionation_r = -1;
						int destionation_c = -1;
						int min_height = Integer.MAX_VALUE;
						
						for (int d = 0; d < 4; d++) {
							int nr = cr + dr[d];
							int nc = cc + dc[d];
							
							// 2-2. 범위 초과시 -> skip
							if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							
							// 2-3. 더 낮은 곳 발견시
							if (arr[nr][nc] < arr[cr][cc]) {
								if (arr[nr][nc] < min_height) {
									min_height = arr[nr][nc];
									destionation_r = nr;
									destionation_c = nc;
								}
							}
						}
						
						// 2-4. 이동 불가능하면 break
						if (destionation_r == -1 && destionation_c == -1) break;
						
						// 2-5. 이동 가능하면
						cr = destionation_r;
						cc = destionation_c;
						cur_leng++;
					}
					
					// 3. 값 비교
					max_leng = Math.max(max_leng, cur_leng);
					
				}
			}
			
			
			// 4. 출력
			System.out.println("#" + tc + " " + max_leng);
		}
	}
}