import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// graph
import java.util.ArrayList;

// Arrays.fill
import java.util.Arrays;

// pq
import java.util.PriorityQueue;



public class Main {
	static ArrayList<int[]>[] graph;
	static int[] dist;
	static int V, E, start_node;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] VE = br.readLine().split(" ");
		V = Integer.parseInt(VE[0]);
		E = Integer.parseInt(VE[1]);
		start_node = Integer.parseInt(br.readLine());
		
		// allocating size of graph
		graph = new ArrayList[V+1];
		for (int i = 1; i < V+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			String[] uvw = br.readLine().split(" ");
			int u = Integer.parseInt(uvw[0]);
			int v = Integer.parseInt(uvw[1]);
			int w = Integer.parseInt(uvw[2]);
			graph[u].add(new int[] {v, w});
		}
		solve();	
	}
	
	
	
	
	
	
	static void solve() {
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 시작점은 0에서 출발
		dist[start_node] = 0;
		
		// 거리가 작은 것부터 꺼내기 위해
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		pq.offer(new int[] {start_node, 0});
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int u = cur[0];
			int d = cur[1];
			
			// 거리가 더 크면 무시
			if (d > dist[u]) continue;
			
			for (int[] next : graph[u]) {
				int v = next[0];
				int w = next[1];
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					pq.offer(new int[] {v, dist[v]});
				}
			}
		}
		
		// res
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] < Integer.MAX_VALUE) {
				System.out.println(dist[i]);
			}
			else if (dist[i] >= Integer.MAX_VALUE) {
				System.out.println("INF");
			}
		}
		
	}
	
	
	
}