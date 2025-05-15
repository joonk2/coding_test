import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;


import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] name = new String[N];
		String[] ring = new String[N];
		
		for (int i = 0; i < N; i++) {
			String[] words = br.readLine().split(" ");
			String s1 = words[0];
			String s2 = words[1];
			
			name[i] = s1;
			ring[i] = s2;
		}
		
		Map<String, Integer> ring_cnt = new HashMap<>();

		for (int i = 0; i < N; i++) {
			if (!ring[i].equals("-")) {
				ring_cnt.put(ring[i], ring_cnt.getOrDefault(ring[i], 0)+1);
			}
		}
		
		List<String> res = new ArrayList<>();
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			if (!ring_cnt.containsKey(ring[i]) || ring_cnt.get(ring[i]) != 2) continue;
			
			for (int j = i+1; j < N; j++) {
				if (!visited[j] && ring[i].equals(ring[j])) {
					visited[i] = true;
					visited[j] = true;
					res.add(name[i] + " " + name[j]);
					break;
				}
			}
			
		}
		
		
		System.out.println(res.size());
		for (String s : res) {
			System.out.println(s);
		}
		
		
		
	}
}