import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] arr = new int[N];
			
			// 1. 배열 생성
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			// 2. 검사
			// 2-1. 현재건물에서 왼쪽으로 2칸, 오른쪽으로 2칸 검사
			// 2-2. 차이 = 현재건물 - 가장 큰 건물
			// 2-3. 만약 차이가 음수면 skip
			int total_cnt = 0;
			for (int i = 0; i < N; i++) {
				int cur_height = arr[i];
				
				// 현재 높이가 0이면 skip
				if (cur_height == 0) continue;
				
				int temp_max_height = 0;
				// 3-1. 왼쪽
				for (int j = i-1; j >= i-2; j--) {
					// 3-2. 범위 초과시 skip
					if (j < 0) continue;
					
					// 3-3. 범위 초과가 아니라면
					temp_max_height = Math.max(temp_max_height, arr[j]);
				}
				
				// 4-1. 오른쪽
				for (int j = i+1; j <= i+2; j++) {
					// 4-2. 범위 초과시 skip
					if (j >= N) continue;
					
					// 4-3. 범위 초과가 아니라면
					temp_max_height = Math.max(temp_max_height, arr[j]);
				}
				
				// 5-1. 자를 수 있는지?
				int temp_diff = cur_height - temp_max_height;
				
				// 5-2. 만약 음수라면 -> 0
				if (temp_diff <= 0) {
					temp_diff = 0;
				}
				
				// 5-3. 가산
				total_cnt += temp_diff;
			}
			
			// 6. 출력
			System.out.println("#" + tc + " " + total_cnt);
			
		}
		
		
	}
	
	
}