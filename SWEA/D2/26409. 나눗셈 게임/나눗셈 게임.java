import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] num = new int[s.length];
			for (int r = 0; r < N; r++) {
				num[r] = Integer.parseInt(s[r]);
			}
			
			// 1. 배열 생성
			int sum = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (r == c) continue;
					
					int temp_val = num[r] % num[c];
					sum += temp_val;
				}
			}
			
			
			// 2. 출력
			System.out.println("#" + tc + " " + sum);
			
			
		}
		
		
	}
}