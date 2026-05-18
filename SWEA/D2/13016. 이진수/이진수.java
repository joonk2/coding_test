import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] N_s = br.readLine().split(" ");
			int N = Integer.parseInt(N_s[0]);
			String s = N_s[1];
			
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i] = s.charAt(i);
			}
			
			// 1. 검사
			String answer = "";
			for (int i = 0; i < N; i++) {
				char cur_ch = arr[i];
				int cur_num = 0;
				
				// 1-1. 문자 변경
				if (cur_ch == 'A') {
					cur_num = 10;
				}
				else if (cur_ch == 'B') {
					cur_num = 11;
				}
				else if (cur_ch == 'C') {
					cur_num = 12;
				}
				else if (cur_ch == 'D') {
					cur_num = 13;
				}
				else if (cur_ch == 'E') {
					cur_num = 14;
				}
				else if (cur_ch == 'F') {
					cur_num = 15;
				}
				else cur_num = cur_ch - '0';
				
				// 1-2. 나누면서 추가
				for (int j = 3; j >= 0; j--) {
					int cur_bit = 0;
					if (j == 3) cur_bit = 8;
					else if (j == 2) cur_bit = 4;
					else if (j == 1) cur_bit = 2;
					else if (j == 0) cur_bit = 1;
					
					// 1-3. 적립 -> (1 or 0)
					if (cur_num >= cur_bit) {
						cur_num -= cur_bit;
						answer += 1;
					}
					else if (cur_num < cur_bit) {
						answer += 0;
					}
				}
			}
			
			// 2. 출력
			System.out.println("#" + tc + " " + answer);
			
			
		}
	}
}