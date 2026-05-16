import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;



public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String s = br.readLine();
			int N = s.length();
			
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i] = s.charAt(i);
			}
			
			
			int half = N/2;
			
			boolean is_everything_alright = true;
			for (int i = 0; i < half; i++) {
				if (arr[i] != arr[N-1-i]) {
					is_everything_alright = false;
					break;
				}
			}
			
			
			// 출력
			if (is_everything_alright) {
				System.out.println("#" + tc + " " + 1);
			}
			else {
				System.out.println("#" + tc + " " + 0);
			}
			
			
			
			
		}
		
		
	}
}