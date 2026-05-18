import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {	
			String[] N_lo_hi = br.readLine().split(" ");
			String[] s_arr = br.readLine().split(" ");
			
			int N = Integer.parseInt(N_lo_hi[0]);
			int lo = Integer.parseInt(N_lo_hi[1]);
			int hi = Integer.parseInt(N_lo_hi[2]);
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(s_arr[i]);
			
			// 0. 답
			int min_diff = Integer.MAX_VALUE;
			
			// 1. 정렬
			Arrays.sort(arr);
			
			// 2. 3개의 등급 모두 최소 lo개 이상
			for (int i = 0; i < N-lo-lo; i++) {
				for (int j = i + lo; j < N - lo; j++) {
					// 2-1. 같으면 skip
					if (i == j) continue;
					
					// 2-2. 다를 때
					int group_A = i+1;
					int group_B = j-i;
					int group_C = N-(j+1);
					
					// 2-3. 같은 쌍이 존재할때는, 구간에 겹치면 땡
					if (arr[i] == arr[i+1] || arr[j] == arr[j+1]) continue;
					
					// 2-3. 한쪽이 최소 못맞추면 skip
					if (group_A < lo || group_B < lo || group_C < lo) continue;
					
					// 2-4. 한쪽이 최대 초과면 skip
					if (group_A > hi || group_B > hi || group_C > hi) continue;
					
					
					// 2-5. 안그렇다면
					int temp_max = Math.max(group_A, Math.max(group_B, group_C));
					int temp_min = Math.min(group_A, Math.min(group_B, group_C));
					int temp_diff = temp_max - temp_min;
					min_diff = Math.min(temp_diff, min_diff);
				}
			}
			
			// 3. 출력
			if (min_diff == Integer.MAX_VALUE) {
				System.out.println("#" + tc + " " + -1);
			}
			else System.out.println("#" + tc + " " + min_diff);
			
			
			
		}
	}
}