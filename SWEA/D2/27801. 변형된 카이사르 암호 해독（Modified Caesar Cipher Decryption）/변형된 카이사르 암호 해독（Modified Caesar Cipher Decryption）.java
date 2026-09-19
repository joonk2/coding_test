import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int space_cnt = Integer.parseInt(br.readLine());
			String S = br.readLine();
			
			// space_cnt 만큼 채우면 공백 추가하고 다시 cnt = 0으로 갱신, i < N-1 미만일때만 유효
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			
			// 암호문S의 길이는 26
			for (int i = 0; i < S.length(); i++) {
				char cur_ch = S.charAt(i);
				int step = i+1;
				
				// 기본적으로 step은 양수처리니 홀수 idx일때만 처리하면 된다.
				if (i % 2 == 1) step -= 2*step;
				
				// 새로운 idx
				int idx = (cur_ch - 'A' + 26 + step) % 26;
				
				// 새로운 글자
				char new_ch = (char) (idx + 'A');
				sb.append(new_ch);
				cnt++;
				
				// space_cnt 개씩 나누고, idx가 맨마지막 미만일때만
				if (cnt == space_cnt && i <= S.length()-2) {
					sb.append(" ");
					cnt = 0;
				}
			}
			// 출력
			System.out.println("#" + tc + " " + sb.toString());
			
		}
	}
}