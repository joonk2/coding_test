/*
시작하며 이동 -> 더이상 이동할 수 없어서 텔레포트 -> 이동하다가 도착

이동 불가능한 칸들을 bfs로 시작점에서 출발했을때 List (start_borders)에 저장하고
bfs로 끝지점에서 출발했을때 List (end_borders)에 저장한다
*/


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;


public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, M;
	static int sr, sc, er, ec;
	static int[][] arr;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		arr = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(cols[c]);
			}
		}
		String[] sr_sc = br.readLine().split(" ");
		String[] er_ec = br.readLine().split(" ");
		
		sr = Integer.parseInt(sr_sc[0])-1;
		sc = Integer.parseInt(sr_sc[1])-1;
		er = Integer.parseInt(er_ec[0])-1;
		ec = Integer.parseInt(er_ec[1])-1;
		

		boolean[][] visited_start = new boolean[N][M];
		boolean[][] visited_end = new boolean[N][M];
		
		List<int[]> start_borders = new ArrayList<>();
		List<int[]> end_borders = new ArrayList<>();
		
		
		// BFS 2회 (각각 나무를 피해갈 수 있는 모든 칸까지의 최소거리)
		// 시작하며 이동 -> 더이상 이동할 수 없어서 텔레포트 -> 이동하다가 도착
		bfs(sr, sc, visited_start, start_borders);
		bfs(er, ec, visited_end, end_borders);
		
		// 시작에서 도착 가능하면 0
		if (visited_start[er][ec]) {
			System.out.println(0);
			return;
		}
		

		// 맨해튼 거리
		distance_of_manhattan(start_borders, end_borders);
	}
	
	
	
	
	static void bfs(int sr, int sc, boolean[][] visited, List<int[]> borders) {
		Queue<int[]> q = new LinkedList<>();
		visited[sr][sc] = true;
		q.offer(new int[] {sr, sc});
		
		while (!q.isEmpty()) {
			int[] cur_pos = q.poll();
			int cr = cur_pos[0];
			int cc = cur_pos[1];
			boolean is_border = false;
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				// 이동 불가능 칸이면 경계 표시 후 다음 방향으로
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == 0) {
					is_border = true;
					continue;
				}
				
				// 이미 방문했으면 다음 방향
				if (visited[nr][nc]) continue;
				
				// 이동 가능하면 방문처리후에 q에 추가
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
				
			}
			if (is_border) borders.add(new int[] {cr, cc});
		}
		
	}
	
	
	
	
	static void distance_of_manhattan(List<int[]> start_borders, List<int[]> end_borders) {
		int answer = Integer.MAX_VALUE;
		for (int[] s : start_borders) {
			for (int[] e : end_borders) {
				int dist = Math.abs(s[0] - e[0]) + Math.abs(s[1] - e[1]);
				answer = Math.min(answer, dist);
			}
		}
		System.out.println(answer);
	}
	
	
	
	
	
	
	
}