import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main { 
	static int N, L;
	static int[][] puddles;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NL = br.readLine().split(" ");
		N = Integer.parseInt(NL[0]);
		L = Integer.parseInt(NL[1]);
		puddles = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] se = br.readLine().split(" ");
			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);
			puddles[i][0] = s;
			puddles[i][1] = e;
		}
		
		
		// lambda 정렬
		Arrays.sort(puddles, (a,b) -> {
			return a[0] - b[0];
		});
		
		// res
		lets_find_the_answer();
	}
	
	
	
	
	static void lets_find_the_answer() {
		int cnt_min = 0;
		int range = 0;
		for (int i = 0; i < N; i++) {
			int s = puddles[i][0];
			int e = puddles[i][1];
			if (range < s) {
				range = s;
			}
			// 자원을 적게쓰기 위해 <= 가 아닌 < 다
			while (range < e) {
				range += L;
				cnt_min++;
			}
		}
		System.out.println(cnt_min);		
	}
	
	
	
	
}