import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// DFS
import java.util.Stack;



public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max_cnt;
	
	static int max_val = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(cols[c]);
				if (max_val < map[r][c]) max_val = map[r][c];
			}
		}
		DFS();
	}
	
	
	
	public static void DFS() {
		max_cnt = 0;
		for (int height = -1; height < max_val + 1; height++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c] && map[r][c] > height) {
						visited[r][c] = true;
						int lets_see = safe_area_cnt(r, c, height);
						cnt++;
					}
				}
			}
			if (cnt > max_cnt) max_cnt = cnt;
		}
		System.out.println(max_cnt);
	}
	
	
	
	public static int safe_area_cnt(int r, int c, int height) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {r, c});
		
		int cnt = 1;
		while (!stack.isEmpty()) {
			int[] cur_pos = stack.pop();
			int cur_r = cur_pos[0];
			int cur_c = cur_pos[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cur_r + dr[d];
				int nc = cur_c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!visited[nr][nc] && map[nr][nc] > height) {
						stack.push(new int[] {nr, nc});
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	
	
	
}