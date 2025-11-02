import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		
		// 4가지 경우중 최소값 구하자
		int res = Integer.MAX_VALUE;
		
		// 왼쪽부터 연속된 R을 제외하고 나머지 모든 R을 왼쪽으로
		int ans1 = check_from_left(N, arr, 'R');
		res = Math.min(res, ans1);
		
		// 오른쪽부터 연속된 R을 제외하고 나머지 모든 R을 오른쪽으로
		int ans2 = check_from_right(N, arr, 'R');
		res = Math.min(res,  ans2);
		
		// 왼쪽부터 연속된 B를 제외하고 나머지 모든 B를 왼쪽으로
		int ans3 = check_from_left(N, arr, 'B');
		res = Math.min(res, ans3);
		
		// 오른쪽부터 연속된 B를 모든 B를 오른쪽으로
		int ans4 = check_from_right(N, arr, 'B');
		res = Math.min(res,  ans4);
		
		
		System.out.println(res);
	}
	
	
	
	static int check_from_left(int N, char[] arr, char ch) {
		int cnt = 0;
		int idx_front = 0;
		while (idx_front < N) {
			if (arr[idx_front] != ch) {
				break;
			}
			idx_front++;
		}
		
		
		while (idx_front < N) {
			if (arr[idx_front] == ch) {
				cnt++;
			}
			idx_front++;
		}
		
		return cnt;
		
	}
	
	
	
	static int check_from_right(int N, char[] arr, char ch) {
		int cnt = 0;
		int idx_back = N-1;
		while (idx_back >= 0) {
			if (arr[idx_back] != ch) {
				break;
			}
			idx_back--;
		}
		
		while (idx_back >= 0) {
			if (arr[idx_back] == ch) {
				cnt++;
			}
			idx_back--;
		}

		
		return cnt;
	}
	
	
}
