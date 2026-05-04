import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			int[] C = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				C[i] = Integer.parseInt(arr[i]);
				sum += C[i];
			}
			
			int temp_sum = 0;
			int min_diff = Integer.MAX_VALUE;
			int min_idx = 0;
			
			for (int i = 0; i < N; i++) {
				temp_sum += C[i];
				int temp_diff = Math.abs((sum - temp_sum) - temp_sum);
				int cur_idx = i+1;
				if (temp_diff < min_diff) {
					min_diff = temp_diff;
					min_idx = cur_idx;
				}
			}
			System.out.println("#" + tc + " " + min_idx + " " + min_diff);
			
			
			
		}
		
	}
}