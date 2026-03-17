import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int min_cost = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				W[r][c] = Integer.parseInt(cols[c]);
			}
		}
		
		
		// 1. 초기값 삽입
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			int start = i;
			visited[start] = true;
			back_tracking(start, i, 0, 1);
			visited[start] = false;
		}
		
		// 3. 출력
		System.out.println(min_cost);
	}
	
	
	
	// 2. 순회
	static void back_tracking(int start, int cur, int cost, int cnt) {
		// 2-1. 최대 깊이 도달시
		if (cnt == N) {
			if (W[cur][start] != 0) {
				min_cost = Math.min(min_cost, cost + W[cur][start]);
			}
			return;
		}
		
		// 2-2. 아직 전부 방문 안했다면
		for (int next = 0; next < N; next++) {
			// 만약 방문했거나, 같은 곳을 방문한다면 skip
			if (visited[next] || W[cur][next] == 0) continue;
			
			// 그게 아니라면
			visited[next] = true;
			back_tracking(start, next, cost + W[cur][next], cnt+1);
			visited[next] = false;
		}
		
	}
	
	
	
}