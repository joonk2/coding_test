import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	static int N;
	static boolean[] DP;
	static int cnt;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			
			
			// 1. 배열 생성
			int size = 0;
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(s[i]);
				size += arr[i]; 
			}
			
			// 2. 0점을 추가하자
			DP = new boolean[size + 1];
			DP[0] = true;
			
			
			// 3. 다른 부분집합 계산
			for (int i = 0; i < N; i++) {
				int cur_score = arr[i];
				for (int j = size - cur_score; j >= 0; j--) {
					// 3-1. 이미 점수가 기록되어있으면
					if (DP[j]) {
						DP[cur_score + j] = true;
					}
				}
			}
			
			
			// 4. 출력
			int cnt = 0;
			for (int i = 0; i < size+1; i++) {
				if (DP[i]) cnt++;
			}
			System.out.println("#" + tc + " " + cnt);
			
				
		}
	}
}