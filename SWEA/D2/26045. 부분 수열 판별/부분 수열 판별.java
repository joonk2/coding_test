import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {	
			String[] NM = br.readLine().split(" ");
			String[] A = br.readLine().split(" ");
			String[] B = br.readLine().split(" ");
			
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			int[] sequence = new int[N];
			int[] sub_sequence = new int[M];
			
			for (int i = 0; i < N; i++) {
				sequence[i] = Integer.parseInt(A[i]);
			}
			for (int i = 0; i < M; i++) {
				sub_sequence[i] = Integer.parseInt(B[i]);
			}
			
			// 1. 검사
			int idx = 0;
			for (int i = 0; i < N; i++) {
				int cur_val = sequence[i];
				int sub_val = sub_sequence[idx];
				if (cur_val == sub_val) {
					idx++;
					// 1-1. 다 찾았으면 조기 종료
					if (idx == M) break;
				}
			}
			
			// 2. 출력
			if (idx == M) {
				System.out.println("#" + tc + " " + "YES");
			}
			else System.out.println("#" + tc + " " + "NO");
			
		}
	}
}