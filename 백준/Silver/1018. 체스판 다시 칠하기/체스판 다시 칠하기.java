// 2가지 패턴을 만들어 비교한다

// 1. pattern_w (w로 먼저 시작)
// wb
// bw

// 2. pattern_b (b로 먼저 시작)
// bw
// wb


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		char[][] arr = new char[N][M];
		
		for (int r = 0; r < N; r++) {
			String cols = br.readLine();
			for (int c = 0; c < M; c++) {
				arr[r][c] = cols.charAt(c);
			}
		}
		
		
		char[] p1 = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
		char[] p2 = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
		
		char[][] pattern_a = new char[8][8];
		char[][] pattern_b = new char[8][8];
		
		for (int r = 0; r < 8; r++) {
			if (r % 2 == 0) {
				for (int c = 0; c < 8; c++) {
					pattern_a[r][c] = p1[c];
					pattern_b[r][c] = p2[c];
				}
			}
			if (r % 2 == 1) {
				for (int c = 0; c < 8; c++) {
					pattern_a[r][c] = p2[c];
					pattern_b[r][c] = p1[c];
				}
			}
		}
		how_many_min_squares(N, M, arr, pattern_a, pattern_b);
	}
	
	
	
	
	
	static void how_many_min_squares(int N, int M, char[][] arr, char[][] pattern_a, char[][] pattern_b) {
		int min_square = Integer.MAX_VALUE;
		
		for (int r = 0; r < N-8 + 1; r++) {
			for (int c = 0; c < M-8 + 1; c++) {
				int cnt_a = 0;
				int cnt_b = 0;
				for (int b = r; b < r+8; b++) {
					for (int a = c; a < c+8; a++) {
						if (arr[b][a] != pattern_a[b-r][a-c]) cnt_a++;
						if (arr[b][a] != pattern_b[b-r][a-c]) cnt_b++;
					}
				}
				min_square = Math.min(min_square, Math.min(cnt_a, cnt_b));
			}
		}
		System.out.println(min_square);
	}
	
	
	
	
	
	
}