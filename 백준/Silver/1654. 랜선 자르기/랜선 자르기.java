/*
랜선의 길이 <= 2^{31} -1
즉 이분탐색시 int 범위 벗어남 --> long 필요 
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int k = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		int[] cable = new int[k];
		long max_cable = 0;
		
		for (int i = 0; i < k; i++) {
			cable[i] = Integer.parseInt(br.readLine());
			if (cable[i] > max_cable) {
				max_cable = cable[i];
			}
		}
		
		// 최소 랜선 길이
		long left = 1;
		long right = max_cable;
		long res = 0;
		
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			
			
			for (int c : cable) {
				cnt += (c/mid);
			}
			
			
			if (cnt >= N) {
				res = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
			
		}
		
		System.out.println(res);
		
		
		
		
	}
}