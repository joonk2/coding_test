import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	static int N;
	static int[][] W;
	static int[][] DP;
	static int INF = Integer.MAX_VALUE;
	static int min_cost = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		DP = new int[N][1<<N];
		
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				W[r][c] = Integer.parseInt(cols[c]);
			}
			// 방문하지 않은 상태를 INF로 초기화
			Arrays.fill(DP[r], INF);
		}
		
		// 0번 도시에서 시작
		// 시작도시 방문했다는 표시로 mask=1
		int start = 0;
		dfs(start, 0, 1, 0);
		System.out.println(min_cost);
	}
	
	
	
	
	static void dfs(int start, int cur, int mask, int cost) {
		// 모든 도시를다 방문했다면
		if (mask == (1<<N)-1) {
			if (W[cur][start] != 0) {
				min_cost = Math.min(min_cost, cost + W[cur][start]);
			}
			return;
		}
		
		
		// 가지치기
		if (cost >= DP[cur][mask]) return;
		
		// 그게 아니라면 비용 갱신
		DP[cur][mask] = cost;
		
		for (int next = 0; next < N; next++) {
			// 다음 도시를 방문 안했고, 도시가 다르다면
			if ( (mask & (1<<next)) == 0 && W[cur][next] != 0 ) {
				int next_cost = cost + W[cur][next];
				
				// 비용이 작다면 dfs 진행
				if (next_cost < min_cost) {
					dfs(start, next, mask | (1<<next), next_cost);
				}
			}
		}
		
	}
	
	
	
	
}