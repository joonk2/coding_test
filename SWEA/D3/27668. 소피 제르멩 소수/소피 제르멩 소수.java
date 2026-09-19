import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] se = br.readLine().split(" ");
			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);
			
			int cnt = 0;
			for (int i = s; i < e+1; i++) {
				// 1. 최적화 (소수 아니면 skip)
				if (i < 2 || (i >= 3 && i % 2 == 0)) continue;
				
				// 2. 그외 검사
				if (is_prime(i) && is_prime(2*i + 1)) cnt++;
			}
			// 4. 출력
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	// 3. 함수 (소수인가?)
	static boolean is_prime(int num) {
		int my_sqrt = get_sqrt(num);
		// 한번이라도 나눠지면 소수 아님
		for (int i = 2; i < my_sqrt + 1; i++) {
			if (num % i == 0) return false;
		}
		// 3-2. 그외 true
		return true;
	}
	
	
	// 4. sqrt 구하는 함수
	static int get_sqrt(int num) {
		int left = 1;
		int right = num;
		int ans = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			// 오버플로우 방지 mid * mid > n
			if (mid > num/mid) {
				right = mid-1;
			}
			else if (mid <= num/mid) {
				ans = mid;
				left = mid + 1;
			}
		}
		return ans;
	}
	
	
}