/*
[접근방법]
1. 그리디 

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
		
		// asc;
		Arrays.sort(cost);
		
		int total = 0;
		for (int i = 0; i < N; i++) {
			int remain = N-i;
			
			if (total + (cost[i]*remain) <= M ) {
				total += cost[i];
			}
			else {
				System.out.println( ((M-total) / remain) );
				return;
			}
			
			
		}
		
		
		System.out.println(cost[N-1]);
		
		
		
		// res
//		System.out.println(Arrays.toString(cost));
		
		
		
	}
	
	
	
	
	
	
}