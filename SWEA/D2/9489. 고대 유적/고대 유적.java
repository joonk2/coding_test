import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	static int max_leng;
	static int N, M;
	static int[][] arr;
	
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] NM = br.readLine().split(" ");
			N = Integer.parseInt(NM[0]);
			M = Integer.parseInt(NM[1]);
			arr = new int[N][M];
			
			// 0 . 최대길이 초기화
			max_leng = 1;
			
			// 1. 배열 생성
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < M; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			// 2. 완전탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int cur_val = arr[r][c];
					if (cur_val == 1) {
						
						// 2-1. 검사
						for (int d = 0; d < 2; d++) {
							int cur_leng = 1;
							int cr = r;
							int cc = c;
							while (true) {
								int nr = cr + dr[d];
								int nc = cc + dc[d];
								
								// 2-2. 범위 초과시 중단
								if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
								
								// 2-3. 장애물 초과시 중단
								if (arr[nr][nc] == 0) break;
								
								// 2-4. 1이라면, 좌표 갱신 및 길이 증가
								cr = nr;
								cc = nc;
								cur_leng++;
							}
							
							// 2-5. 값 갱신
							max_leng = Math.max(cur_leng, max_leng);
						}
					}
				}
			}
			
			// 3. 출력
			System.out.println("#" + tc + " " + max_leng);
		}
		
	}
}