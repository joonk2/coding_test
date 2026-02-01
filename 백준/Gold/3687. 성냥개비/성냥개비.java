import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;



public class Main {	
	// 성냥 2,3,4,5,6,7 개
	static int[] min_digit = {1, 7, 4, 2, 0, 8};
	
	static long[] DP = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 프로그램 시작시 DP 테이블을 한번만 계산
		calculate_min_DP();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String res2 = find_max(N);
			long res1 = DP[N];
			System.out.println(res1 + " " + res2);
		}
	}
	
	
	
	
	
	
	
	static String find_max(int N) {
		String res = "";
		// 홀수 일때
		if (N % 2 == 1) {
			res += "7";
			N -= 3;
		}
		
		// 이어서 짝수
		while (N > 0) {
			res += "1";
			N -= 2;
		}
		
		return res;
	}
	
	
	
	
	static void calculate_min_DP() {
		Arrays.fill(DP, Long.MAX_VALUE);
		
		// 초기값 (맨 앞자리에 올때의 최솟값)
		DP[2] = 1;
		DP[3] = 7;
		DP[4] = 4;
		DP[5] = 2;
		DP[6] = 6;
		DP[7] = 8;
		DP[8] = 10;
		
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				long combined = DP[i-j]*10 + min_digit[j-2];
				
				if (combined < DP[i]) {
					DP[i] = combined;
				}
			}
		}
		
	}
	
	
	
	
}