import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String num_arr = br.readLine();
			String[] KM = br.readLine().split(" ");
			
			int N = num_arr.length();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = num_arr.charAt(i) - '0';
			}
			int K = Integer.parseInt(KM[0]);
			int M = Integer.parseInt(KM[1]);
			
			
			// 1. 횟수, 범위 (j ~ j+K) 만큼 연속 변경 가능한지?
			int cnt = 0;
			boolean success = true;
			
			// 2. 검사
			for (int i = 0; i < N; i++) {
				if (arr[i] == 0) {
					for (int j = i; j < i+K; j++) {
						// 2-1. 가지치기
						if (j >= N) {
							success = false;
							break;
						}
						
						// 2-2. 숫자 뒤집기
						if (arr[j] == 0) {
							arr[j] = 1;
						}
						else if (arr[j] == 1) {
							arr[j] = 0;
						}
						
					}
					
					// 2-3. 가지치기
					if (!success) break;
					
					// 2-4. 횟수 추가
					cnt++;
				}
			}
			
			
			
			
			
			// 3. 출력
			if (success) {
				System.out.println("#" + tc + " " + cnt);
			}
			else if (!success) {
				System.out.println("#" + tc + " " + -1);
			}
			
			
			
			
		}
		
	}
}