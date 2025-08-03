import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		int[] beers = new int[N];
		for (int i = 0; i < N; i++) {
			beers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(beers);
		
		int res = parametric_search(K, beers);
		System.out.print(res);
		
		
	}
	
	
	public static int parametric_search(int K, int[] beers) {
		int answer = 0;
		int left = 1;
		int right = beers[beers.length-1];
		
		while (left <= right) {
			int mid = (left/2) + (right/2) + (1& left & right);
			int cnt = 0;
			for (int i : beers) {
				cnt += (i / mid);
			}
			
			if (cnt >= K) {
				answer = mid;
				left = mid + 1;
			}
			else if (cnt < K) {
				right = mid - 1;
			}
			
			
		}
		
		return answer;
		
	}
	
	
}