import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	static int N, L;
	static int max_score;
	static int[] score;
	static int[] kcal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NL = br.readLine().split(" "); 
			N = Integer.parseInt(NL[0]);
			L = Integer.parseInt(NL[1]);
			
			max_score = Integer.MIN_VALUE;
			
			// 1. 배열 생성
			score  = new int[N];
			kcal = new int[N];
			for (int i = 0; i < N; i++) {
				String[] s_k = br.readLine().split(" ");
				int s = Integer.parseInt(s_k[0]);
				int k = Integer.parseInt(s_k[1]);
				score[i] = s;
				kcal[i] = k;
			}
			
			// 2. 백트랙킹
			int idx = 0;
			int cur_score = 0;
			int cur_kcal = 0;
			back_tracking(idx, cur_score, cur_kcal);
			
			// 4. 출력
			System.out.println("#" + tc + " " + max_score);
		}
	}
	
	
	// 3. 백트랙킹 함수
	static void back_tracking(int idx, int cur_score, int cur_kcal) {
		// 3-1. 칼로리 초과시 -> 종료
		if (cur_kcal > L) return;
		
		// 3-2. 인덱스 초과시 -> 검사
		if (idx == N) {
			max_score = Math.max(cur_score, max_score);
			return;
		}
		
		// 3-3. 선택
		back_tracking(idx+1, cur_score + score[idx], cur_kcal + kcal[idx]);
		
		// 3-4. 미선택
		back_tracking(idx+1, cur_score, cur_kcal);
	}
}