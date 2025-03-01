/*
[시도 방법]
1. 연속적인 부분수열합
2. 비연속적인 부분수열 합 --> 백트랙킹

[틀린 이유]
1. 연속적인 부분수열만 고려했음
반례 -->
5 0
-7 -3 -2 8 5

*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, S, sum, cnt;
	static int[] lst;
	
	public static void main(String[] arsg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		S = Integer.parseInt(arr[1]);
		
		String[] sequence = br.readLine().split(" "); 
		
		lst = new int[N];
		for (int i = 0; i < N; i++) {
			lst[i] = Integer.parseInt(sequence[i]);
		}
		
        
        // backtrack
		cnt = 0;
		backtrack(0,0, false);
		System.out.println(cnt);
		
		
		
		
		
		
	}
	
	
	public static void backtrack(int i, int sum, boolean isSelected) {
        // 원소 5개까지 포함하여 다 돌아봤을 때
		if (i == N) {
			if (sum == S && isSelected == true) {
				cnt++;
			}
			return;
		}
		
		
		// 1. 현재 원소를 선택할 때
		backtrack(i+1, sum + lst[i], true);
		
		// 2. 현재 원소를 선택 안할 때
		backtrack(i+1, sum, isSelected);
		
	}
	
	
	
}