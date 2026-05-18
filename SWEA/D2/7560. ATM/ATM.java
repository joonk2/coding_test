import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;


public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {	
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			
			// 1. 배열 생성
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			// 2. 정렬
			Arrays.sort(arr);
			
			// 3. 전체시간, 누적시간 
			int total_t = 0;
			int cum_t = 0;
			for (int i = 0; i < N; i++) {
				cum_t += arr[i];
				total_t += cum_t;
			}
			
			// 4. 출력
			System.out.println("#" + tc +  " " + total_t);
		}
	}
}