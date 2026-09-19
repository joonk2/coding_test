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
				// 1. 소수 아니면 skip
				if (i < 2 || (i >= 3 && i % 2 == 0)) continue;
				
				// 2-1. 뒤집은 숫자와 i가 같다면 다음으로 넘기기
				int reversed_num = flip_over(i);
				if (i == reversed_num) continue;
				
				// 2-2. 그 외 소수인지 검사
				if (is_prime(i) && is_prime(reversed_num)) cnt++;
			}
			// 6. 출력
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	
	// 3. 함수 (숫자 뒤집기)
	static int flip_over(int num) {
		int res = 0;
		String str = String.valueOf(num);
		String temp = "";
		for (int i = str.length()-1; i >= 0; i--) {
			temp += str.charAt(i);
		}
		res = Integer.parseInt(temp);
		return res;
	}
	
	
	// 4. 함수 (소수인가?)
	static boolean is_prime(int num) {
		int my_sqrt = get_sqrt(num);
		// 4-1. 한번이라도 나눠지면 소수 아님
		for (int i = 2; i < my_sqrt + 1; i++) {
			if (num % i == 0) return false;
		}
		// 4-2. 그외 true
		return true;
	}
	
	
	// 5. sqrt 구하는 함수
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