import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


// bfs
import java.util.Queue;
import java.util.LinkedList;



public class Solution {
	static int N, sr, sc, er, ec;
	static int min_time;
	static int[][] arr;
	
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			// 0. 최소시간 매 testcase마다 초기화
			min_time = Integer.MAX_VALUE;
			
			// 1. 배열 생성
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			// 2. 시작점, 끝점
			String[] sr_sc = br.readLine().split(" ");
			String[] er_ec = br.readLine().split(" ");
			sr = Integer.parseInt(sr_sc[0]);
			sc = Integer.parseInt(sr_sc[1]);
			er = Integer.parseInt(er_ec[0]);
			ec = Integer.parseInt(er_ec[1]);
			
			// 3. bfs
			bfs();
			
			// 4. 출력
			if (min_time == Integer.MAX_VALUE) {
				System.out.println("#" + tc + " " + -1);
			}
			else {
				System.out.println("#" + tc + " " + min_time);
			}
			
			
		}
	}
	
	
	
	// 5. bfs 함수
	static void bfs() {
		
		// 5-1. q, 방문 배열 생성후에 시작점을 삽입하자
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][N][3];
		
		int start_time = 0;
		q.add(new int[] {sr, sc, start_time});
		visited[sr][sc][start_time % 3] = true;
		
		
		// 5-2. 검사
		while (!q.isEmpty()) {
			int[] cur_pos = q.poll();
			int cr = cur_pos[0];
			int cc = cur_pos[1];
			int cur_time = cur_pos[2];
			
			// !! 도착점에 도달하면?
			if (cr == er && cc == ec) {
				min_time = Math.min(min_time, cur_time);
				return;
			} 
			
			// 5-3. 다음 시간
			int next_time = cur_time + 1;
			
			// 5-4. 방향
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				// 5-5. 범위 검사
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				// 5-6. 장애물 검사
				if (arr[nr][nc] == 1) continue;
				
				// 5-7. 소용돌이??
				if (arr[nr][nc] == 2 && cur_time % 3 != 2) continue;
				
				// 5-8. 방문했다면? -> skip
				if (visited[nr][nc][next_time % 3]) continue;
				
				// 5-9. 방문하지 않았다면
				visited[nr][nc][next_time % 3] = true;
				q.add(new int[] {nr, nc, next_time});
			}
			
			
			// 6. 제자리에서 대기하는게 필요한가?
			if (!visited[cr][cc][next_time % 3]) {
				visited[cr][cc][next_time % 3] = true;
				q.add(new int[] {cr, cc, next_time});
			}
			
		}
		
		
		
	}
	
	
	
}