import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] original_arr = new char[N][N];
			
			
			// 1-1. 시작점, 끝점
			int sr = 0;
			int sc = 0;
			int er = 0;
			int ec = 0;
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				for (int c = 0; c < s.length(); c++) {
					original_arr[r][c] = s.charAt(c);
					if (original_arr[r][c] == 'X') {
						sr = r;
						sc = c;
					}
					if (original_arr[r][c] == 'Y') {
						er = r;
						ec = c;
					}
				}
			}
			
			// 1-2. 초기 출력형태 생성
			System.out.print("#" + tc + " ");
			
			
			
			// 2. commands
			int Q = Integer.parseInt(br.readLine());
			for (int i = 0; i < Q; i++) {
				
				// 2-1. 매번 좌표 초기화
				char[][] arr = original_arr;
				
				String[] str = br.readLine().split(" ");
				int leng = Integer.parseInt(str[0]);
				String command_arr = str[1];
				char[] commands = new char[leng];
				for (int j = 0; j < leng; j++) {
					commands[j] = command_arr.charAt(j);
				}
				
				// 2-2. 초기 방향 (위쪽)
				int d = 0;
				int cr = sr;
				int cc = sc;
				
				for (int j = 0; j < leng; j++) {
					char cur_button = commands[j];
					int dr = 0;
					int dc = 0;
					
					// 2-3. 방향 설정
					if (d == 0 && cur_button == 'A') {
						dr = -1;
						dc = 0;
					}
					else if (d == 1 && cur_button == 'A') {
						dr = 0;
						dc = 1;
					}
					else if (d == 2 && cur_button == 'A') {
						dr = 1;
						dc = 0;
					}
					else if (d == 3 && cur_button == 'A') {
						dr = 0;
						dc = -1;
					}
					else if (cur_button == 'R') {
						d = (d+1) % 4;
						continue;
					}
					else if (cur_button == 'L') {
						d = ( (d-1) + (4) ) % 4;
						continue;
					}
					
					// 2-4. 칸 확인 (범위 가능한지)
					int nr = cr + dr;
					int nc = cc + dc;
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					// 2-5. 지나갈 수 있는 칸인지?
					// 2-5-a 나무라면 skip
					if (arr[nr][nc] == 'T') continue;
					
					// 2-5-b 빈공간이면 이동
					if (arr[nr][nc] == 'G' || arr[nr][nc] == 'Y' || arr[nr][nc] == 'X') {
						cr = nr;
						cc = nc;
					}
				}
				
				
				// 3. 검사
				if (cr == er && cc == ec) {
					System.out.print(1 + " ");
				}
				else System.out.print(0 + " ");
			}
			
			// 4. 줄바꿈
			System.out.println();
			
		}
		
	}
}