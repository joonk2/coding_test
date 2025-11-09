import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int answer = 0;
	static int[][] arr;
	
	static int[][][] bumerang = {
			// 노란 중심좌표를 기준으로 양옆 2개만 작성하자
			
			// ┐
			{ {0,-1}, {1,0} },
			
			// ┘
			{ {-1,0}, {0,-1} },
			
			// └
			{ {-1,0}, {0,1} },
			
			// ┌
			{ {0,1}, {1,0} }
			
	};
	
	
	static boolean[][] visited;
	
	
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
		
		// early stop
		if (N < 2 || M < 2) {
			System.out.println(0);
			return;
		}
		
		
		// result
		visited = new boolean[N][M];
		dfs(0, 0, 0);
		System.out.println(answer);
	}
	
	
	
	
	
	static void dfs(int r, int c, int sum) {
		
		// col이 끝지점 도달시 갱신
		if (c == M) {
			r++;
			c = 0;
		}
		
		// row가 끝지점 도달시 대소비교후 종료
		if (r == N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		
		// 방문 안했을때
		if (!visited[r][c]) {
			for(int[][] bumerang_pos : bumerang) {
				int ar = r + bumerang_pos[0][0];
				int ac = c + bumerang_pos[0][1];
				int br = r + bumerang_pos[1][0];
				int bc = c + bumerang_pos[1][1];
				
				// 범위밖이면 땡 
				if (ar < 0 || ar > N-1 || ac < 0 || ac > M-1) continue;
				if (br < 0 || br > N-1 || bc < 0 || bc > M-1) continue;
				
				// 방문했으면 땡
				if (visited[ar][ac] || visited[br][bc]) continue;
				
				int temp_sum = sum + (arr[r][c]*2) + arr[ar][ac] + arr[br][bc];
				
				// 방문처리
				visited[r][c] = true;
				visited[ar][ac] = true;
				visited[br][bc] = true;
				dfs(r, c, temp_sum);
				
				// 방문 해제
				visited[r][c] = false;
				visited[ar][ac] = false;
				visited[br][bc] = false;
			}
		}
		
		// 아무 조건에 해당 안하면
		dfs(r, c+1, sum);
	}
	
	
	
	
}