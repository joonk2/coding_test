import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Stack;
import java.util.List;

import java.util.Queue;
import java.util.LinkedList;


public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMV = br.readLine().split(" ");
		int N = Integer.parseInt(NMV[0]);
		int M = Integer.parseInt(NMV[1]);
		int V = Integer.parseInt(NMV[2]);
		
		
		graph = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < M; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i = 1; i < N+1; i++) {
			Collections.sort(graph[i]);
		}
		
//		for (int i = 1; i < N+1; i++) {
//			System.out.println(i + " -> " + graph[i]);
//		}
		
		visited = new boolean[N+1];
		DFS(V);
		
		System.out.println();
		
		visited = new boolean[N+1];
		BFS(V);
	}
	
	
	
	
	
	
	
	public static void DFS(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while (!stack.isEmpty()) {
			int node = stack.pop();
			
			if (visited[node]) continue;
			visited[node] = true;
			System.out.print(node + " ");
			
			List<Integer> neighbors = graph[node];
			for (int i = neighbors.size()-1; i >= 0; i--) {
				int next = neighbors.get(i);
				if (!visited[next]) {
					stack.push(next);
				}
			}
		}
	}
	
	
	
	
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			
			for (int next : graph[node]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
}