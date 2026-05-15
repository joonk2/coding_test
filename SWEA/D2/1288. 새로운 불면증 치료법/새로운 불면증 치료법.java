import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int start_multiple = 1;
			boolean[] visited = new boolean[10];
			
			int answer = 0;
			int visited_cnt = 0;
			int cnt = 0;
			
			while (true) {
				int number = N * start_multiple;
				start_multiple++;
				cnt++;
				
				// 최초 방문 검사
				String s = String.valueOf(number);
				for (int i = 0; i < s.length(); i++) {
					int cur_num = s.charAt(i) - '0';
					if (!visited[cur_num]) {
						visited[cur_num] = true;
						visited_cnt++;
					}
				}
				
				// 숫자 원상복구
				number = Integer.valueOf(s);
				
				// 다 찾았으면 끝
				if (visited_cnt == 10) {
					answer = number;
					break;
				};
			}
			
			
			// 출력
			System.out.println("#" + tc + " " + answer);
			
		}
		
		
	}
}