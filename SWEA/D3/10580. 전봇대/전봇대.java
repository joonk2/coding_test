import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 1. 배열 채우기
			int[] A = new int[1001];
			int[] B = new int[1001];
			for (int i = 0; i < N; i++) {
				String[] ai_bi = br.readLine().split(" ");
				int ai = Integer.parseInt(ai_bi[0]);
				int bi = Integer.parseInt(ai_bi[1]);
				A[i] = ai;
				B[i] = bi;
			}
			
			// 2. 식
			int cross_cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 2-1. 한 점을 기준으로 잡아야하니까 -> 본인과 달라야한다
					if (i == j) continue;
					
					// 2-2. 다른점일때
					if (A[i] < A[j] && B[i] > B[j]) cross_cnt++;				
				}
			}
			
			// 3. 출력
			System.out.println("#" + tc + " " + cross_cnt);
			
		}
		
		
	}
}