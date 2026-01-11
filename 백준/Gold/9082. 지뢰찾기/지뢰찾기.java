/*
#일때는 주변숫자를 1개라도 줄일 수 있다면 지뢰 매설가능지역으로 판단
주변 숫자들을 1이상일시 제거한다 3방향으로 반복하면서

그러나 인근지역 3곳을 확인하다가 한곳이라도 0이 나오면 그곳은 break (탐색종료)
그리고 다음 지점을 확인한다.
*/


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static int[] dr = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) arr[i] = nums.charAt(i)-'0';
			char[] bomb_area = br.readLine().toCharArray();
			
			lets_find_max_bomb(N, arr, bomb_area);
		}
	}
	
	
	
	
	static void lets_find_max_bomb(int N, int[] arr, char[] bomb_area) {
		for (int i = 0; i < N; i++) {
			boolean temp_check = false;
			
			
			// 매설 되어있으면
			if (bomb_area[i] == '*') {
				for (int d = 0; d < 3; d++) {
					if (i + dr[d] >= 0 && i + dr[d] < N) {
						if (arr[i+dr[d]] < 1) break;
						arr[ i+dr[d] ]--;
					}
				}
			}
			
			
			// 매설되있는지 잘 모르겠다면
			else if (bomb_area[i] == '#') {
				for (int d = 0; d < 3; d++) {
					if (i + dr[d] >= 0 && i + dr[d] < N) {
						if (arr[ i+dr[d] ] < 1) break;
						arr[ i+dr[d] ]--;
						temp_check = true;
					}
				}
				// temp_check 확인
				if (temp_check) {
					bomb_area[i] = '*';
				}
			}
		}
		
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (bomb_area[i] == '*') cnt++;
		}
		System.out.println(cnt);
		
	}
	
	
	
	
	
}