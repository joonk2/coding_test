/*
1. 첫 번째 수 : N, 두 번째 수 : N-- ~
2. 수열은 N과 i라는 2개의 숫자로 시작하니 cnt = 2
3. 첫 번째와 두 번째 숫자를 비교해주며 세 번째 숫자를 생성하고 다시 재대입하며 반복 -> a-b >= 0 까지
4. 조건문을 넣고 maxLen < cnt 라면 maxLen++, 당시 index를 maxSecond로 저장
5. 첫 번째 while문 작성 이후 아래 새로운 while문을 생성해주어 3번쨰 숫자부터 이어서 작성되게하자
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int maxLen = 1;
		int maxSecond = N;
		for (int i = N; i >= 0; i--) {
			int cnt = 2;
			int start = N;
			int second = i;
			
			while (start - second >= 0) {
				int third = start - second;
				start = second;
				second = third;
				cnt++;
			}
			
			if (maxLen < cnt) {
				maxLen = cnt;
				maxSecond = i;
			}
		}
			sb.append(maxLen).append("\n");
			sb.append(N).append(" ").append(maxSecond).append(" ");
			
			int first = N;
			while (first - maxSecond >= 0) {
				int third = first - maxSecond;
				first = maxSecond;
				maxSecond = third;
				
				sb.append(maxSecond).append(" ");
			}
			
		
		System.out.println(sb);
		
	}
}