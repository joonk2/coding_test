import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		
		for (int r = 0; r < N; r++) {
			arr[r] = br.readLine().toCharArray();
		}
		
		int cnt_max = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			boolean[] friend = new boolean[N];
			int cur_cnt = 0;
			// check_1 (1단계 친구)
			for (int c = 0; c < N; c++) {
				// 동일인물이면 skip
				if (r == c) continue;
				
				// 1단계 친구
				if (arr[r][c] == 'Y') friend[c] = true;
				
				// check_2 (2단계 친구)
				for (int d = 0; d < N; d++) {
					if (arr[r][c] == 'Y' && arr[c][d] == 'Y') {
						if (r != d) friend[d] = true;
					}
				}
			}
			// 친구수 계산
			for (int k = 0; k < N; k++) {
				if (friend[k]) cur_cnt++;
			}
			cnt_max = Math.max(cnt_max, cur_cnt);
		}
		
		System.out.println(cnt_max);
		
	}
}