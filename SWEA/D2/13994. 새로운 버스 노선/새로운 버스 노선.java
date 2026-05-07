import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int max_stop = Integer.MIN_VALUE;
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[1001];
			
			for (int i = 0; i < N; i++) {
				String[] type_A_B = br.readLine().split(" ");
				int type = Integer.parseInt(type_A_B[0]);
				int A = Integer.parseInt(type_A_B[1]);
				int B = Integer.parseInt(type_A_B[2]);
				
				if (type == 1) {
					for (int j = A; j < B+1; j++) {
						arr[j]++;
					}
				}
				else if (type == 2) {
					if (A % 2 == 0) {
						for (int j = A; j < B+1; j++) {
							if (j % 2 == 0) {
								arr[j]++;
							}
						}
					}
					else if (A % 2 == 1) {
						for (int j = A; j < B+1; j++) {
							if (j % 2 == 1) {
								arr[j]++;
							}
						}
					}
				}
				else if (type == 3) {
					if (A % 2 == 0) {
						for (int j = A; j < B+1; j++) {
							if (j % 4 == 0 && j >= 4) {
								arr[j]++;
							}
						}
					}
					else if (A % 2 == 1) {
						for (int j = A; j < B+1; j++) {
							if (j % 3 == 0 && j >= 3 && j % 10 != 0) {
								arr[j]++;
							}
						}
					}
				}
			}
			
			// 최종검사
			for (int i = 1; i < 1000 + 1; i++) {
				max_stop = Math.max(max_stop, arr[i]);
			}
			System.out.println("#" + tc + " " + max_stop);
		}
		
	}
}