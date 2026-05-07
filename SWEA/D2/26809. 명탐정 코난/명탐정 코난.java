import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	static int N, K;
	static int[][] arr;
	static boolean found;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			String[] NK = br.readLine().split(" ");
			N = Integer.parseInt(NK[0]);
			K = Integer.parseInt(NK[1]);
			arr = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String[] cols = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(cols[c]);
				}
			}
			
			// 1. 범인 검거 여부
			found = false;
			
			// 2. 초기 출력 세팅
			System.out.print("#" + tc + " ");
			
			
			// 3-1. 검사
			int idx = 0;
			int cnt = 0;
			int[] my_reasoning = new int[N];
			
			// 3-2 처음에는 전부 무고한 사람으로 가정
			for (int i = 0; i < N; i++) {
				my_reasoning[i] = 1;
			}
			
			back_tracking(idx, cnt, my_reasoning);
			
			
			// 4. 간격 띄우기
			System.out.println();
		}
	}
	
	
	
	
	// 5. 내 추리 확인 
	static void back_tracking(int idx, int cnt, int[] my_reasoning) {
		
		// 5-1. 범인들 검거시 심문 종료
		if (found) return;
		
		// 5-2. K명의 용의자 확보시
		if (cnt == K) {
			if (is_valid(my_reasoning)) {
				found = true;
			}
			
			// 5-2-a 범인 검거시
			if (found) {
				int[] answer = new int[K];
				int new_idx = 0;
				for (int i = 0; i < N; i++) {
					if (my_reasoning[i] == 0) {
						answer[new_idx] = i+1;
						new_idx++;
					}
				}
				
				// 5-2-b 범인 명단 출력
				for (int i = 0; i < new_idx; i++) {
					System.out.print(answer[i] + " ");
				}
			}
			return;
		}
		
		
		// 5-3. 가지치기
		// idx 초과
		// 현재 찾은 용의자수랑 남은 사람들을 더 검사해도 K명만큼 못채울때
		if (idx >= N || cnt + (N-idx) < K) return;
		
		
		
		// 5-4. 해당 용의자 범인으로 간주
		my_reasoning[idx] = 0;
		back_tracking(idx+1, cnt+1, my_reasoning);
		
		
		// 5-5. 해당 용의자 무고한 시민으로 간주
		my_reasoning[idx] = 1;
		back_tracking(idx+1, cnt, my_reasoning);
	}
	
	
	
	// 6. 검사
	static boolean is_valid(int[] my_reasoning) {
		for (int i = 0; i < N; i++) {
			
			// 6-1. 무고한 사람은 자기 자신을 제외하고 모든 사람에 대해 실제 상태를 정확하게 진술 
			if (my_reasoning[i] == 1) {
				for (int j = 0; j < N; j++) {
					
					// 6-2. 동일인이면 skip
					if (i == j) continue;
					
					// 6-3. 무고한사람들의 증언이 하나하나 일치하나 검사
					// 하나라도 일치안한다면 거짓 증언
					if (my_reasoning[j] != arr[i][j]) return false;
				}
			}
		}
		return true;
	}
	
	
}