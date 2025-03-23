/*
[접근방법]
1. 그리디 
2. 이분탐색

*/



import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;


public class Main {
	static int max_cost, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] cost_arr = br.readLine().split(" ");
		int[] cost = new int[cost_arr.length];
		
		for (int i = 0; i < cost_arr.length; i++) {
			cost[i] = Integer.parseInt(cost_arr[i]);
		}
		
		// total_national_budget
		int M = Integer.parseInt(br.readLine());
		
		// 이분 탐색을 위해 미리 asc 정렬하자
		Arrays.sort(cost);
		
		
		int left = 0;
		int right = cost[N-1];
		int res = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			
			// 금액 배분
			for (int i = 0; i < N; i++ ) {
				if (cost[i] > mid) {
					sum += mid;
				}
				else {
					sum += cost[i];
				}
			}
			
			
			// 예산 키우기
			if (sum <= M) {
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