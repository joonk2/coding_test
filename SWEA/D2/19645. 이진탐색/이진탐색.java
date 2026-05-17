import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution { 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] PAB = br.readLine().split(" ");
			int P = Integer.parseInt(PAB[0]);
			int A = Integer.parseInt(PAB[1]);
			int B = Integer.parseInt(PAB[2]);
			
			int s = 1;
			int e = P;
			int target_A = A;
			int target_B = B;
			
			int cnt_A = binary_search(s, e, target_A);
			int cnt_B = binary_search(s, e, target_B);
			
			// 출력
			if (cnt_A < cnt_B) {
				System.out.println("#" + tc + " " + "A");
			}
			else if (cnt_A > cnt_B) {
				System.out.println("#" + tc + " " + "B");
			}
			else if (cnt_A == cnt_B) {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}
	
	
	
	static int binary_search(int left, int right, int target) {
		int cnt = 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid == target) return cnt;
			
			// mid가 target보다 작다면
			if (mid < target) {
				left = mid;
				cnt++;
			}
			// mid가 크다면
			else if (mid > target) {
				right = mid;
				cnt++;
			}
		}
		return cnt;
	}
}