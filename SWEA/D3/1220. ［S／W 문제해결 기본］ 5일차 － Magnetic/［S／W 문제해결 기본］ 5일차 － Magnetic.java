import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for (int tc = 1; tc < T+1; tc++) {
			int leng = Integer.parseInt(br.readLine());
			
			// 1. 배열 생성
			int[][] arr = new int[leng][leng];
			for (int r = 0; r < leng; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < leng; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			int total_cnt = 0;
			// 2. 탐색 시작
			for (int c = 0; c < leng; c++) {
				
				// 2-1. 맨 위에서부터 아래로 검사
				int start_idx = 0;
				for (int r = 0; r < leng; r++) {
					// 2-1-a. N극이 나올떄까지 검사
					if (arr[r][c] == 1) break;
					
					// 2-1-b. S극(파란색 2) 이나 빈칸(0)이면 계속 전진
					start_idx++;
				}
				
				// 2-2. 맨 아래에서부터 위로 검사
				int end_idx = leng-1;
				for (int r = leng-1; r >= 0; r--) {
					// 2-2-a. S극이 나올떄까지 검사
					if (arr[r][c] == 2) break;
					
					// 2-2-b. N극(빨간색 1) 이나 빈칸(0)이면 계속 전진
					end_idx--;
				}
				
				// 2-3. 만약 자성체들을 전부 소각할 수 있다면?
				// 붉은 자성체만 있거나
				// 푸른 자성체만 있거나
				// 둘다 있긴한데 소각이 가능하다면
				if (start_idx == leng || end_idx == -1 || start_idx > end_idx) {
					continue;
				}
				
				// 2-4. 교착상태라면?
				int pair_cnt = 0;
				int temp_color = arr[start_idx][c];
				pair_cnt++;
				for (int r = start_idx+1; r < leng; r++) {
					// 2-4-a. 만약 다음 숫자가 다르면, 빈칸은 불가능
					if (temp_color != arr[r][c] && arr[r][c] != 0) {
						pair_cnt++;
						temp_color = arr[r][c];
					}
				}
				
				// 2-5. 교착상태 검사 종료후 총 횟수 가산
				int temp_cnt = pair_cnt / 2;
				total_cnt += temp_cnt;
			}
			
			
			// 3. 출력
			System.out.println("#" + tc + " " + total_cnt);
			
		}
		
		
	}
}