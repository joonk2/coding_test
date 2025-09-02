import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	static int[][] matrix;
	static int N;
	static int[] dr = {0,1,1};
	static int[] dc = {1,0,1};
	
	static int max_cnt;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		max_cnt = 0;
		
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(cols[c]);
			}
		}
		dfs(0, 1, 0);
		System.out.println(max_cnt);
	}
	
	
	
	static void dfs(int r, int c, int direction) {
		
		// 가지치기
		if (r == N-1 && c == N-1) {
			max_cnt++;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			// 대각선일때는 가로, 세로, 대각 다 가능
			// 세로일때는 세로, 대각선만 가능
			// 가로일때는 가로, 대각선만 가능
			if ( (direction == 0 && (d == 0 || d == 2)) || (direction == 1 && (d == 1 || d == 2)) || (direction == 2 && (d == 0 || d == 1 || d == 2)) ) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && matrix[nr][nc] == 0) {
					if (d == 2) {
						if (matrix[r+1][c] == 0 && matrix[r][c+1] == 0) {
							dfs(nr, nc, 2);
						}
					}
					else {
						dfs(nr, nc, d);
					}
				}
			}
			
			
		}
	}

	
	
	
}