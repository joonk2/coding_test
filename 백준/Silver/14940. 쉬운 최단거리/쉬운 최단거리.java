import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;


public class Main {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);
		int[][] matrix = new int[R][C];
		int sr = 0;
		int sc = 0;
		for (int r = 0; r < R; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				matrix[r][c] = Integer.parseInt(cols[c]);
				if (matrix[r][c] == 2) {
					sr = r;
					sc = c;
				}
			}
		}
		lets_explore(matrix, sr, sc);
		lets_print(matrix);
	}
	
	
	
	
	static int[][] lets_explore(int[][] matrix, int sr, int sc) {
		int R = matrix.length;
		int C = matrix[0].length;
		matrix[sr][sc] = 0;
		int cnt = matrix[sr][sc];
		boolean[][] visited = new boolean[R][C];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sr,sc,cnt});
		visited[sr][sc] = true;
		while (!q.isEmpty()) {
			int[] cur_pos = q.poll();
			int cr = cur_pos[0];
			int cc = cur_pos[1];
			int cd = cur_pos[2];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (!visited[nr][nc] && matrix[nr][nc] == 1) {
						matrix[nr][nc] = cd+1;
						q.add(new int[] {nr, nc, cd+1});
						visited[nr][nc] = true;
					}
				}
			}
		}
		// update
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (!visited[r][c] && matrix[r][c] == 1) {
					matrix[r][c] = -1;
				} 
			}
		}
		return matrix;
	}
	
	
	
	
	static void lets_print(int[][] arr) {
		int R = arr.length;
		int C = arr[0].length;
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(arr[r][c] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	
	
}