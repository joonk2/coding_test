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
			
			for (int i = 0; i < N; i++) {
				C[i] = Integer.parseInt(arr[i]);
			}
			
			int max_leng = 1;
			int temp_leng = 1;
			
			for (int i = 1; i < N; i++) {
				if (C[i] > C[i-1]) temp_leng++;
				else {
					temp_leng = 1;
					continue;
				}
				max_leng = Math.max(max_leng,  temp_leng);
			}
			
			System.out.println("#" + tc + " " + max_leng);
		}
		
	}
}